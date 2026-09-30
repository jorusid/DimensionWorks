package dev.szx.dimensionworks.mekstress.memory;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.jupiter.api.Test;

class MachinePowerRouteContractTest {
    @Test
    void staleRoutesCannotRefreshANullKineticNetwork() throws IOException {
        String source = Files.readString(Path.of(
            "src/main/java/dev/szx/dimensionworks/mekstress/memory/MachinePowerManager.java"));

        assertTrue(source.contains("PowerRouteSafety.shouldAssignStress("));
        assertTrue(source.contains("for (Direction direction : Direction.values())"));
        assertTrue(source.contains("PowerRouteSafety.sameNetwork("));
        assertTrue(source.contains("!source.hasNetwork() || !gearbox.hasNetwork()"));
        assertTrue(source.contains("KineticNetwork network = source.getOrCreateNetwork();"));
        assertTrue(source.contains("if (network == null)"));
        assertTrue(source.contains("KineticNetwork network = kinetic.getOrCreateNetwork();"));
        assertTrue(source.contains("if (ownNetwork != null)"));
    }
}
