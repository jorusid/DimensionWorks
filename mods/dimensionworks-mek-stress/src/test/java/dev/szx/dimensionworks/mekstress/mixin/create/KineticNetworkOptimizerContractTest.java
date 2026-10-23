package dev.szx.dimensionworks.mekstress.mixin.create;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.jupiter.api.Test;

class KineticNetworkOptimizerContractTest {

    @Test
    void preservesVirtualMemberValidationAndRecordsIncrementalContributions() throws IOException {
        String source = Files.readString(Path.of(
            "src/main/java/dev/szx/dimensionworks/mekstress/mixin/create/KineticNetworkMixin.java"));

        assertTrue(source.contains("KineticNetworkOptimizer.cachedStress(network)"));
        assertTrue(source.contains("KineticNetworkOptimizer.beginStressRebuild(network)"));
        assertTrue(source.contains("KineticNetworkOptimizer.recordStressContribution(network, member, contribution)"));
        assertTrue(source.contains("KineticNetworkOptimizer.finishStressRebuild(network, totalStress)"));
        assertTrue(source.contains("IVirtualKineticMember"));
        assertTrue(source.contains("dimensionworks$isValid()"));
    }

    @Test
    void invalidatesCacheWhenVirtualMembersChangeNetworks() throws IOException {
        String source = Files.readString(Path.of(
            "src/main/java/dev/szx/dimensionworks/mekstress/memory/MachineKineticRegistry.java"));

        assertTrue(source.contains("KineticNetworkOptimizer.invalidate(previous)"));
        assertTrue(source.contains("KineticNetworkOptimizer.invalidate(network)"));
    }
}
