#!/usr/bin/env python3
"""Prepare a temporary client instance for packaging preflight on GitHub Actions."""

from __future__ import annotations

import argparse
import json
import shutil
import sys
import urllib.parse
from pathlib import Path
from typing import Any

sys.path.insert(0, str(Path(__file__).resolve().parent))
import package_mrpack  # noqa: E402  (sibling packaging helpers)

ROOT = package_mrpack.ROOT
MANIFEST = package_mrpack.MANIFEST
CLIENT_ENVIRONMENTS = {"client", "both"}


def modrinth_primary_file(mod: dict[str, Any]) -> tuple[str, str]:
    version = package_mrpack.request_json(
        f"https://api.modrinth.com/v2/version/{mod['version_id']}"
    )
    files = version.get("files", [])
    selected = next((item for item in files if item.get("primary")), None)
    if selected is None and files:
        selected = files[0]
    if selected is None:
        raise ValueError(f"{mod['id']}: Modrinth version has no files")
    return selected["url"], selected["filename"]


def stage_client_mods(instance_dir: Path, cache_dir: Path) -> tuple[int, int]:
    manifest = json.loads(MANIFEST.read_text(encoding="utf-8"))
    mods_dir = instance_dir / "mods"
    mods_dir.mkdir(parents=True, exist_ok=True)
    staged = 0
    skipped = 0

    for mod in manifest.get("mods", []):
        if mod.get("environment") not in CLIENT_ENVIRONMENTS:
            continue
        source = mod.get("source")
        if source == "in-repo":
            skipped += 1
            continue

        if source == "modrinth":
            url, filename = modrinth_primary_file(mod)
            package_mrpack.download(url, mods_dir / filename)
        elif source == "curseforge":
            filename = mod["file_name"]
            cached = package_mrpack.cached_file(
                cache_dir, "curseforge", filename, package_mrpack.curseforge_url(mod)
            )
            shutil.copy2(cached, mods_dir / filename)
        elif source == "github-release":
            filename = mod["asset"]
            url = (
                f"https://github.com/{mod['repository']}/releases/download/"
                f"{urllib.parse.quote(mod['release'])}/{urllib.parse.quote(filename)}"
            )
            cached = package_mrpack.cached_file(cache_dir, "github", filename, url)
            shutil.copy2(cached, mods_dir / filename)
        else:
            raise ValueError(f"{mod['id']}: unsupported source {source!r}")

        staged += 1

    return staged, skipped


def main() -> int:
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument("--instance-dir", type=Path, required=True)
    parser.add_argument(
        "--cache-dir",
        type=Path,
        default=Path("/private/tmp/dimensionworks-pack-cache"),
    )
    args = parser.parse_args()

    instance_dir = args.instance_dir.expanduser().resolve()
    cache_dir = args.cache_dir.expanduser().resolve()
    cache_dir.mkdir(parents=True, exist_ok=True)
    instance_dir.mkdir(parents=True, exist_ok=True)
    shutil.copytree(ROOT / "config", instance_dir / "config", dirs_exist_ok=True)

    try:
        staged, skipped = stage_client_mods(instance_dir, cache_dir)
    except (OSError, ValueError) as error:
        print(f"CI INSTANCE FAIL: {error}", file=sys.stderr)
        return 1

    print(
        f"CI INSTANCE OK: {staged} third-party client mods staged, "
        f"{skipped} in-repo client mods skipped"
    )
    return 0


if __name__ == "__main__":
    sys.exit(main())
