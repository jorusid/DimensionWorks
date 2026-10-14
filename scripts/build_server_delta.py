#!/usr/bin/env python3
"""Create a server update delta by comparing two DimensionWorks server ZIPs."""

from __future__ import annotations

import argparse
import hashlib
import stat
import tempfile
import zipfile
from pathlib import Path, PurePosixPath

import pack_manifest


class DeltaError(ValueError):
    """Raised when a server archive cannot produce a safe delta."""


def _safe_member(name: str) -> None:
    if not name or name.startswith("/") or "\\" in name:
        raise DeltaError(f"unsafe archive member: {name!r}")
    path = PurePosixPath(name)
    if path.is_absolute() or path.as_posix() != name or any(
        part in ("", ".", "..") for part in path.parts
    ):
        raise DeltaError(f"unsafe archive member: {name!r}")


def _members(archive: zipfile.ZipFile) -> dict[str, zipfile.ZipInfo]:
    result: dict[str, zipfile.ZipInfo] = {}
    for info in archive.infolist():
        if info.is_dir():
            continue
        _safe_member(info.filename)
        mode = info.external_attr >> 16
        if stat.S_ISLNK(mode):
            raise DeltaError(f"symbolic links are not allowed: {info.filename}")
        if info.filename in result:
            raise DeltaError(f"duplicate archive member: {info.filename}")
        result[info.filename] = info
    return result


def _sha256(archive: zipfile.ZipFile, info: zipfile.ZipInfo) -> str:
    digest = hashlib.sha256()
    with archive.open(info) as source:
        while chunk := source.read(1024 * 1024):
            digest.update(chunk)
    return digest.hexdigest()


def _manifest(archive: zipfile.ZipFile) -> pack_manifest.UpdateManifest:
    try:
        data = archive.read(pack_manifest.MANIFEST_NAME)
    except KeyError as error:
        raise DeltaError("new server ZIP has no update manifest") from error
    return pack_manifest.parse_manifest(data, expected_kind="server")


def build_server_delta(
    base_zip: Path,
    new_zip: Path,
    output: Path,
    *,
    manifest: pack_manifest.UpdateManifest | None = None,
) -> Path:
    output.parent.mkdir(parents=True, exist_ok=True)
    with zipfile.ZipFile(base_zip) as base, zipfile.ZipFile(new_zip) as new:
        base_members = _members(base)
        new_members = _members(new)
        update_manifest = manifest or _manifest(new)
        if update_manifest.kind != "server":
            raise DeltaError("delta manifest must be a server manifest")
        changed: list[str] = []
        for entry in update_manifest.entries:
            if entry.action != "archive":
                raise DeltaError(f"server delta entry must be archive: {entry.path}")
            if entry.source != entry.path:
                raise DeltaError(f"server delta source must match path: {entry.path}")
            _safe_member(entry.path)
            new_info = new_members.get(entry.path)
            if new_info is None:
                raise DeltaError(f"new ZIP is missing manifest file: {entry.path}")
            if _sha256(new, new_info) != entry.value:
                raise DeltaError(f"new ZIP digest mismatch: {entry.path}")
            old_info = base_members.get(entry.path)
            if old_info is None or _sha256(base, old_info) != entry.value:
                changed.append(entry.path)

        with tempfile.TemporaryDirectory(prefix="dimensionworks-delta-") as temp:
            staging = Path(temp)
            for relative in changed:
                source = new_members[relative]
                target = staging / relative
                target.parent.mkdir(parents=True, exist_ok=True)
                target.write_bytes(new.read(source))
                mode = source.external_attr >> 16
                if mode & 0o111:
                    target.chmod(target.stat().st_mode | 0o111)

            temporary = output.with_suffix(output.suffix + ".part")
            temporary.unlink(missing_ok=True)
            with zipfile.ZipFile(
                temporary, "w", compression=zipfile.ZIP_DEFLATED, compresslevel=6
            ) as delta:
                for relative in changed:
                    source = staging / relative
                    info = zipfile.ZipInfo.from_file(source, relative)
                    info.compress_type = zipfile.ZIP_DEFLATED
                    if source.stat().st_mode & 0o111:
                        info.external_attr = (0o100755 & 0xFFFF) << 16
                    delta.writestr(info, source.read_bytes(), compress_type=zipfile.ZIP_DEFLATED)
            temporary.replace(output)
    return output


def write_empty_delta(output: Path) -> Path:
    output.parent.mkdir(parents=True, exist_ok=True)
    temporary = output.with_suffix(output.suffix + ".part")
    temporary.unlink(missing_ok=True)
    with zipfile.ZipFile(temporary, "w"):
        pass
    temporary.replace(output)
    return output


def main() -> int:
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument("--base", type=Path)
    parser.add_argument("--new", type=Path, required=True)
    parser.add_argument("--output", type=Path, required=True)
    parser.add_argument(
        "--empty",
        action="store_true",
        help="create an empty delta when no previous release is available",
    )
    args = parser.parse_args()
    try:
        if args.empty:
            if args.base is not None:
                raise DeltaError("--empty cannot be combined with --base")
            write_empty_delta(args.output)
        else:
            if args.base is None:
                raise DeltaError("--base is required unless --empty is used")
            build_server_delta(args.base, args.new, args.output)
    except (OSError, ValueError, zipfile.BadZipFile, DeltaError) as error:
        print(f"DELTA FAIL: {error}")
        return 1
    print(f"DELTA OK: {args.output}")
    return 0


if __name__ == "__main__":
    raise SystemExit(main())
