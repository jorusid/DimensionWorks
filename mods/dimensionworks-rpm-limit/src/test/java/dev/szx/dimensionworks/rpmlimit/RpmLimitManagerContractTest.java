package dev.szx.dimensionworks.rpmlimit;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.jupiter.api.Test;

class RpmLimitManagerContractTest {
    @Test
    void ownerlessKineticChainsUseTheConservativeDefaultLimit() throws IOException {
        String source = Files.readString(Path.of(
            "src/main/java/dev/szx/dimensionworks/rpmlimit/RpmLimitManager.java"));

        assertTrue(source.contains("return owner == null ? RpmLimitConfig.DEFAULT_RPM.get()"));
        assertTrue(source.contains("instanceof IPreclampedKineticSpeed"));
    }
}
