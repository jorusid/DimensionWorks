from __future__ import annotations

import hashlib
import http.server
import os
import shutil
import subprocess
import sys
import tempfile
import threading
import unittest
import zipfile
from pathlib import Path

ROOT = Path(__file__).resolve().parents[2]
UPDATERS = ROOT / "release-updaters"
sys.path.insert(0, str(ROOT / "scripts"))

import pack_manifest  # noqa: E402

SCRIPT_NAMES = (
    "update-dimensionworks-client.sh",
    "update-dimensionworks-client.bat",
    "update-dimensionworks-server.sh",
    "update-dimensionworks-server.bat",
)
PRESERVED_TOKENS = {
    "client": ("saves", "logs", "crash-reports", "screenshots"),
    "server": (
        "logs",
        "crash-reports",
        "debug",
        "screenshots",
        "world",
        "eula.txt",
        "server.properties",
        "user_jvm_args.txt",
        "usercache.json",
        "ops.json",
        "whitelist.json",
        "banned-ips.json",
        "banned-players.json",
    ),
}


def sha256(data: bytes) -> str:
    return hashlib.sha256(data).hexdigest()


def sha512(data: bytes) -> str:
    return hashlib.sha512(data).hexdigest()


class UpdaterScriptContractTest(unittest.TestCase):
    def test_four_standalone_scripts_exist_with_required_contract(self) -> None:
        for name in SCRIPT_NAMES:
            with self.subTest(name=name):
                path = UPDATERS / name
                self.assertTrue(path.is_file(), f"missing updater: {path}")
                data = path.read_bytes()
                self.assertNotIn(b"\r", data, f"{name} must use LF in repository")
                self.assertNotIn(b"python", data.lower(), f"{name} must not require Python")
                text = data.decode("utf-8")
                self.assertIn("--release", text)
                self.assertIn("--package", text)
                self.assertIn("--url", text)
                self.assertIn("--help", text)
                self.assertIn(".dimensionworks-update", text)
                self.assertIn("state.tsv", text)
                self.assertIn("VERSION", text)
                if name.endswith(".bat"):
                    self.assertIn("New-BootstrapState", text)
                    self.assertIn("serverRuntimeNames", text)
                else:
                    self.assertIn("bootstrap_state", text)
                kind = "server" if "server" in name else "client"
                for token in PRESERVED_TOKENS[kind]:
                    self.assertIn(token, text, f"{name} must preserve {token}")

    def test_shell_scripts_parse_and_do_not_embed_batch(self) -> None:
        for name in (
            "update-dimensionworks-client.sh",
            "update-dimensionworks-server.sh",
        ):
            with self.subTest(name=name):
                path = UPDATERS / name
                result = subprocess.run(
                    ["bash", "-n", str(path)],
                    capture_output=True,
                    text=True,
                    check=False,
                )
                self.assertEqual(result.returncode, 0, result.stderr)
                text = path.read_text(encoding="utf-8")
                self.assertNotIn("powershell", text.lower())
                self.assertNotIn("cmd.exe", text.lower())

    def test_batch_scripts_delegate_to_powershell_without_external_python(self) -> None:
        for name in (
            "update-dimensionworks-client.bat",
            "update-dimensionworks-server.bat",
        ):
            with self.subTest(name=name):
                text = (UPDATERS / name).read_text(encoding="utf-8")
                self.assertIn("powershell", text.lower())
                self.assertIn("-NoProfile", text)
                self.assertIn("-ExecutionPolicy", text)


class FixtureFactory:
    def __init__(self, temp: str) -> None:
        self.temp = Path(temp)

    def write_client_package(
        self,
        *,
        version: str,
        files: dict[str, bytes],
        remote: dict[str, bytes] | None = None,
    ) -> Path:
        staging = self.temp / f"client-{version}"
        (staging / "overrides").mkdir(parents=True)
        (staging / "modrinth.index.json").write_text("{}", encoding="utf-8")
        index_entries = []
        for path, data in (remote or {}).items():
            index_entries.append(
                {
                    "path": path,
                    "hashes": {"sha512": sha512(data)},
                    "downloads": [f"https://example.invalid/{Path(path).name}"],
                }
            )
        for path, data in files.items():
            target = staging / "overrides" / path
            target.parent.mkdir(parents=True, exist_ok=True)
            target.write_bytes(data)
        manifest = pack_manifest.make_client_manifest(
            index_entries,
            staging,
            version=version,
            release=f"v{version}",
        )
        manifest_bytes = pack_manifest.render_manifest(manifest)
        (staging / pack_manifest.MANIFEST_NAME).write_bytes(manifest_bytes)
        output = self.temp / f"DimensionWorks-{version}.mrpack"
        with zipfile.ZipFile(output, "w", zipfile.ZIP_DEFLATED) as archive:
            for path in sorted(staging.rglob("*")):
                if path.is_file():
                    archive.write(path, path.relative_to(staging).as_posix())
        return output

    def write_server_package(
        self,
        *,
        version: str,
        files: dict[str, bytes],
    ) -> Path:
        staging = self.temp / f"server-{version}"
        staging.mkdir(parents=True)
        for path, data in files.items():
            target = staging / path
            target.parent.mkdir(parents=True, exist_ok=True)
            target.write_bytes(data)
        manifest = pack_manifest.make_server_manifest(
            staging,
            version=version,
            release=f"v{version}",
        )
        (staging / pack_manifest.MANIFEST_NAME).write_bytes(
            pack_manifest.render_manifest(manifest)
        )
        output = self.temp / f"DimensionWorks-Server-{version}.zip"
        with zipfile.ZipFile(output, "w", zipfile.ZIP_DEFLATED) as archive:
            for path in sorted(staging.rglob("*")):
                if path.is_file():
                    archive.write(path, path.relative_to(staging).as_posix())
        return output


@unittest.skipUnless(
    shutil.which("bash") and shutil.which("unzip"), "shell fixture tools unavailable"
)
class ShellClientFixtureTest(unittest.TestCase):
    def setUp(self) -> None:
        self.temp_ctx = tempfile.TemporaryDirectory()
        self.temp = Path(self.temp_ctx.name)
        self.fixture = FixtureFactory(self.temp)
        self.instance = self.temp / "instance"
        self.instance.mkdir()
        shutil.copy2(
            UPDATERS / "update-dimensionworks-client.sh",
            self.instance / "update-dimensionworks-client.sh",
        )
        (self.instance / "VERSION").write_text("0.0.1\n", encoding="ascii")
        (self.instance / "saves" / "keep").mkdir(parents=True)
        (self.instance / "saves" / "keep" / "level.dat").write_bytes(b"keep")

    def tearDown(self) -> None:
        self.temp_ctx.cleanup()

    def run_script(self, package: Path) -> subprocess.CompletedProcess[str]:
        return subprocess.run(
            ["bash", str(self.instance / "update-dimensionworks-client.sh"), "--package", str(package)],
            cwd=self.instance,
            capture_output=True,
            text=True,
            check=False,
        )

    def test_local_package_adds_modifies_and_deletes_only_managed_files(self) -> None:
        first = self.fixture.write_client_package(
            version="0.0.2",
            files={"config/old.cfg": b"old", "kubejs/server_scripts/old.js": b"old"},
            remote={"mods/remote.jar": b"remote-v1"},
        )
        (self.instance / "mods").mkdir()
        (self.instance / "mods" / "remote.jar").write_bytes(b"remote-v1")
        result = self.run_script(first)
        self.assertEqual(result.returncode, 0, result.stderr)
        self.assertEqual((self.instance / "config" / "old.cfg").read_bytes(), b"old")
        self.assertEqual((self.instance / "VERSION").read_text(), "0.0.2\n")
        state_text = (self.instance / ".dimensionworks-update" / "state.tsv").read_text(encoding="utf-8")
        self.assertTrue(state_text.startswith("# DimensionWorks update manifest 1\n"))
        self.assertIn("# kind client\n# version 0.0.2\n", state_text)

        second = self.fixture.write_client_package(
            version="0.0.3",
            files={"config/new.cfg": b"new", "config/changed.cfg": b"changed"},
            remote={"mods/remote.jar": b"remote-v2"},
        )
        (self.instance / "mods" / "remote.jar").write_bytes(b"remote-v2")
        result = self.run_script(second)
        self.assertEqual(result.returncode, 0, result.stderr)
        self.assertFalse((self.instance / "config" / "old.cfg").exists())
        self.assertFalse((self.instance / "kubejs" / "server_scripts" / "old.js").exists())
        self.assertEqual((self.instance / "config" / "changed.cfg").read_bytes(), b"changed")
        self.assertEqual((self.instance / "saves" / "keep" / "level.dat").read_bytes(), b"keep")
        self.assertEqual((self.instance / "VERSION").read_text(), "0.0.3\n")

    def test_failed_update_rolls_back_changed_file_and_preserves_private_data(self) -> None:
        package = self.fixture.write_client_package(
            version="0.0.4",
            files={"config/aaa.cfg": b"new", "config/value.cfg": b"new"},
        )
        (self.instance / "config").mkdir()
        (self.instance / "config" / "aaa.cfg").write_bytes(b"old")
        (self.instance / "config" / "value.cfg").mkdir()
        (self.instance / "config" / "value.cfg" / "keep").write_bytes(b"keep")
        state = self.instance / ".dimensionworks-update"
        state.mkdir()
        (state / "state.tsv").write_text(
            "# DimensionWorks update manifest 1\n"
            "# kind client\n# version 0.0.4\n# release v0.0.4\n# base v0.0.4\n"
            "action\tpath\talgorithm\tvalue\tsource\n"
            f"archive\tconfig/aaa.cfg\tsha256\t{sha256(b'old')}\toverrides/config/aaa.cfg\n",
            encoding="utf-8",
        )
        result = self.run_script(package)
        self.assertNotEqual(result.returncode, 0)
        self.assertEqual((self.instance / "config" / "aaa.cfg").read_bytes(), b"old")
        self.assertEqual((self.instance / "config" / "value.cfg" / "keep").read_bytes(), b"keep")
        self.assertEqual((self.instance / "VERSION").read_text(), "0.0.1\n")

    def test_rejects_archive_source_path_traversal_before_apply(self) -> None:
        package = self.fixture.write_client_package(
            version="0.0.5",
            files={"config/value.cfg": b"new"},
        )
        rewritten = self.temp / "traversal.mrpack"
        with zipfile.ZipFile(package) as source, zipfile.ZipFile(rewritten, "w") as target:
            for info in source.infolist():
                data = source.read(info.filename)
                if info.filename == pack_manifest.MANIFEST_NAME:
                    data = data.replace(
                        b"overrides/config/value.cfg",
                        b"../outside.cfg",
                    )
                target.writestr(info, data)
        result = self.run_script(rewritten)
        self.assertNotEqual(result.returncode, 0)
        self.assertIn("更新清单格式无效", result.stderr)
        self.assertEqual((self.instance / "VERSION").read_text(), "0.0.1\n")

    def test_url_uses_embedded_manifest_and_bootstraps_old_managed_files(self) -> None:
        package = self.fixture.write_client_package(
            version="0.0.6",
            files={"config/new.cfg": b"new"},
        )
        (self.instance / "config").mkdir()
        (self.instance / "config" / "stale.cfg").write_bytes(b"stale")
        handler = lambda *args, **kwargs: http.server.SimpleHTTPRequestHandler(
            *args, directory=str(self.temp), **kwargs
        )
        server = http.server.ThreadingHTTPServer(("127.0.0.1", 0), handler)
        thread = threading.Thread(target=server.serve_forever, daemon=True)
        thread.start()
        try:
            url = f"http://127.0.0.1:{server.server_port}/{package.name}"
            result = subprocess.run(
                ["bash", str(self.instance / "update-dimensionworks-client.sh"), "--url", url],
                cwd=self.instance,
                capture_output=True,
                text=True,
                check=False,
            )
        finally:
            server.shutdown()
            server.server_close()
            thread.join(timeout=2)
        self.assertEqual(result.returncode, 0, result.stderr)
        self.assertFalse((self.instance / "config" / "stale.cfg").exists())
        self.assertEqual((self.instance / "config" / "new.cfg").read_bytes(), b"new")



class ShellServerFixtureTest(unittest.TestCase):
    def test_fresh_server_install_writes_default_runtime_files(self) -> None:
        with tempfile.TemporaryDirectory() as temp:
            fixture = FixtureFactory(temp)
            instance = Path(temp) / "server"
            instance.mkdir()
            shutil.copy2(
                UPDATERS / "update-dimensionworks-server.sh",
                instance / "update-dimensionworks-server.sh",
            )
            package = fixture.write_server_package(
                version="0.0.8",
                files={
                    "server.properties": b"level-name=world\n",
                    "eula.txt": b"eula=false\n",
                    "user_jvm_args.txt": b"-Xmx2G\n",
                    "mods/new.jar": b"new",
                },
            )
            result = subprocess.run(
                ["bash", str(instance / "update-dimensionworks-server.sh"), "--package", str(package)],
                cwd=instance,
                capture_output=True,
                text=True,
                check=False,
            )
            self.assertEqual(result.returncode, 0, result.stderr)
            self.assertEqual((instance / "server.properties").read_text(), "level-name=world\n")
            self.assertEqual((instance / "eula.txt").read_text(), "eula=false\n")
            self.assertEqual((instance / "user_jvm_args.txt").read_text(), "-Xmx2G\n")

    def test_url_uses_embedded_manifest(self) -> None:
        with tempfile.TemporaryDirectory() as temp:
            fixture = FixtureFactory(temp)
            instance = Path(temp) / "server"
            instance.mkdir()
            shutil.copy2(
                UPDATERS / "update-dimensionworks-server.sh",
                instance / "update-dimensionworks-server.sh",
            )
            package = fixture.write_server_package(
                version="0.0.7",
                files={"mods/new.jar": b"new"},
            )
            handler = lambda *args, **kwargs: http.server.SimpleHTTPRequestHandler(
                *args, directory=temp, **kwargs
            )
            server = http.server.ThreadingHTTPServer(("127.0.0.1", 0), handler)
            thread = threading.Thread(target=server.serve_forever, daemon=True)
            thread.start()
            try:
                url = f"http://127.0.0.1:{server.server_port}/{package.name}"
                result = subprocess.run(
                    ["bash", str(instance / "update-dimensionworks-server.sh"), "--url", url],
                    cwd=instance,
                    capture_output=True,
                    text=True,
                    check=False,
                )
            finally:
                server.shutdown()
                server.server_close()
                thread.join(timeout=2)
            self.assertEqual(result.returncode, 0, result.stderr)
            self.assertEqual((instance / "mods" / "new.jar").read_bytes(), b"new")

    def test_server_preserves_runtime_files_and_deletes_obsolete_managed_file(self) -> None:
        with tempfile.TemporaryDirectory() as temp:
            fixture = FixtureFactory(temp)
            instance = Path(temp) / "server"
            instance.mkdir()
            shutil.copy2(
                UPDATERS / "update-dimensionworks-server.sh",
                instance / "update-dimensionworks-server.sh",
            )
            (instance / "VERSION").write_text("0.0.1\n", encoding="ascii")
            (instance / "world").mkdir()
            (instance / "world" / "level.dat").write_bytes(b"world")
            (instance / "server.properties").write_text("level-name=world\n", encoding="ascii")
            (instance / "eula.txt").write_text("eula=true\n", encoding="ascii")

            first = fixture.write_server_package(
                version="0.0.5",
                files={
                    "mods/old.jar": b"old",
                    "config/server.cfg": b"old",
                    "server.properties": b"bad-default",
                    "eula.txt": b"bad-default",
                },
            )
            result = subprocess.run(
                ["bash", str(instance / "update-dimensionworks-server.sh"), "--package", str(first)],
                cwd=instance,
                capture_output=True,
                text=True,
                check=False,
            )
            self.assertEqual(result.returncode, 0, result.stderr)
            self.assertEqual((instance / "config" / "server.cfg").read_bytes(), b"old")
            self.assertEqual((instance / "server.properties").read_text(), "level-name=world\n")
            self.assertEqual((instance / "eula.txt").read_text(), "eula=true\n")

            second = fixture.write_server_package(
                version="0.0.6",
                files={
                    "mods/new.jar": b"new",
                    "config/server.cfg": b"new",
                    "server.properties": b"bad-default-2",
                },
            )
            result = subprocess.run(
                ["bash", str(instance / "update-dimensionworks-server.sh"), "--package", str(second)],
                cwd=instance,
                capture_output=True,
                text=True,
                check=False,
            )
            self.assertEqual(result.returncode, 0, result.stderr)
            self.assertFalse((instance / "mods" / "old.jar").exists())
            self.assertEqual((instance / "mods" / "new.jar").read_bytes(), b"new")
            self.assertEqual((instance / "world" / "level.dat").read_bytes(), b"world")
            self.assertEqual((instance / "server.properties").read_text(), "level-name=world\n")


if __name__ == "__main__":
    unittest.main()
