import json
import unittest
from pathlib import Path

from scripts.pack_hook import has_dependency_cycle, in_repo_mods


ROOT = Path(__file__).resolve().parents[2]


class QuestDependencyCycleTest(unittest.TestCase):
    def test_accepts_acyclic_graph(self) -> None:
        graph = {
            "root": {"middle"},
            "middle": {"leaf"},
            "leaf": set(),
            "independent": set(),
        }
        self.assertFalse(has_dependency_cycle(graph))

    def test_detects_multi_node_cycle(self) -> None:
        graph = {
            "a": {"b"},
            "b": {"c"},
            "c": {"a"},
        }
        self.assertTrue(has_dependency_cycle(graph))

    def test_detects_self_cycle(self) -> None:
        self.assertTrue(has_dependency_cycle({"a": {"a"}}))

    def test_ignores_missing_nodes_for_cycle_detection(self) -> None:
        self.assertFalse(has_dependency_cycle({"a": {"missing"}}))


class InRepoModResourceContractTest(unittest.TestCase):
    def test_in_repo_mod_sources_include_pack_metadata(self) -> None:
        missing = [
            mod["id"]
            for mod in in_repo_mods()
            if not (ROOT / str(mod["project_path"]) / "src" / "main" / "resources" / "pack.mcmeta").is_file()
        ]
        self.assertEqual(missing, [], "every in-repo mod jar must include pack.mcmeta")

    def test_polarity_inverter_model_uses_existing_vanilla_texture(self) -> None:
        model_path = (
            ROOT
            / "mods"
            / "dimensionworks-cave-factory"
            / "src"
            / "main"
            / "resources"
            / "assets"
            / "dimensionworks_cave_factory"
            / "models"
            / "item"
            / "polarity_inverter.json"
        )
        model = json.loads(model_path.read_text(encoding="utf-8"))
        self.assertEqual(model["textures"]["layer0"], "minecraft:block/redstone_torch")


if __name__ == "__main__":
    unittest.main()
