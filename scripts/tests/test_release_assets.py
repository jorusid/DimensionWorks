from __future__ import annotations

import unittest
from pathlib import Path

ROOT = Path(__file__).resolve().parents[2]
WORKFLOW = ROOT / ".github" / "workflows" / "release-pack.yml"


class ReleaseWorkflowTest(unittest.TestCase):
    def test_workflow_publishes_all_standalone_assets_and_refuses_overwrite(self) -> None:
        text = WORKFLOW.read_text(encoding="utf-8")
        required = (
            "pack_version.resolve_version",
            "inputs.release_version",
            "inputs.dimension_complete",
            "--dimension-complete",
            "refusing to overwrite it",
            "build_server_delta.py",
            "DimensionWorks-${PACK_VERSION}-update-manifest.tsv",
            "DimensionWorks-${PACK_VERSION}-delta.zip",
            "DimensionWorks-Server-${PACK_VERSION}-update-manifest.tsv",
            "DimensionWorks-Server-${PACK_VERSION}-delta.zip",
            "update-dimensionworks-client.sh",
            "update-dimensionworks-client.exe",
            "update-dimensionworks-server.sh",
            "update-dimensionworks-server.exe",
            "SHA256SUMS",
            "git push origin",
        )
        for fragment in required:
            with self.subTest(fragment=fragment):
                self.assertIn(fragment, text)

    def test_workflow_keeps_updater_scripts_out_of_packages(self) -> None:
        text = WORKFLOW.read_text(encoding="utf-8")
        self.assertIn("Updater script embedded in client package", text)
        self.assertIn("Updater script embedded in server package", text)
        self.assertIn("cmp \"dist/DimensionWorks-${PACK_VERSION}-update-manifest.tsv\"", text)

    def test_server_packager_supports_explicit_minor_release(self) -> None:
        text = (ROOT / "scripts" / "package_server.py").read_text(encoding="utf-8")
        self.assertIn('"--dimension-complete"', text)
        self.assertIn("dimension_complete=args.dimension_complete", text)


if __name__ == "__main__":
    unittest.main()
