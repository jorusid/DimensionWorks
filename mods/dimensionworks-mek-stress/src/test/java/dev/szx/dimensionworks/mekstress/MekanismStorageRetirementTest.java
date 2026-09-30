package dev.szx.dimensionworks.mekstress;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import org.junit.jupiter.api.Test;

class MekanismStorageRetirementTest {
    private static final List<String> STORAGE_ITEMS = List.of(
        "mekanism:basic_energy_cube",
        "mekanism:advanced_energy_cube",
        "mekanism:elite_energy_cube",
        "mekanism:ultimate_energy_cube",
        "mekanism:creative_energy_cube",
        "mekanism:energy_tablet",
        "mekanism:basic_induction_cell",
        "mekanism:advanced_induction_cell",
        "mekanism:elite_induction_cell",
        "mekanism:ultimate_induction_cell",
        "mekanism:basic_induction_provider",
        "mekanism:advanced_induction_provider",
        "mekanism:elite_induction_provider",
        "mekanism:ultimate_induction_provider"
    );

    @Test
    void retiresEveryMekanismEnergyStorageItem() throws IOException {
        String startup = Files.readString(Path.of("..", "..", "kubejs", "startup_scripts", "me_memory.js"));
        String server = Files.readString(Path.of("..", "..", "kubejs", "server_scripts", "me_memory.js"));
        String client = Files.readString(Path.of("..", "..", "kubejs", "client_scripts", "me_memory.js"));

        for (String id : STORAGE_ITEMS) {
            assertTrue(startup.contains("'" + id + "'"), "startup script must retire " + id);
            assertTrue(server.contains("'" + id + "'"), "server script must retire " + id);
            assertTrue(client.contains("'" + id + "'"), "client script must hide " + id);
        }
        assertTrue(startup.contains("StartupEvents.modifyCreativeTab('mekanism:main'"));
        assertTrue(server.contains("event.remove({ output: id })"));
        assertTrue(client.contains("retiredMekanismStorageItems.forEach(id => event.hide(id))"));
        assertTrue(server.contains("event.replaceInput({}, 'mekanism:energy_tablet', retiredMekanismRecipeMaterialReplacement)"));
    }
}
