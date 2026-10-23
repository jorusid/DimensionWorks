package dev.szx.dimensionworks.rpmlimit.mixin;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.jupiter.api.Test;

class ValueSettingsPacketMixinTest {
    @Test
    void controllerOwnershipIsOnlyBackfilledWhenMissing() throws IOException {
        String source = Files.readString(Path.of(
            "src/main/java/dev/szx/dimensionworks/rpmlimit/mixin/ValueSettingsPacketMixin.java"));

        assertTrue(source.contains("RpmLimitManager.owner(controller) == null"));
        assertTrue(source.contains("setOwner(controller"));
    }
}
