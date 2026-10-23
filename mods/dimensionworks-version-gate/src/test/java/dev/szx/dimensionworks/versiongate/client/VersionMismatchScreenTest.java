package dev.szx.dimensionworks.versiongate.client;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.nio.file.Path;
import java.util.List;
import org.junit.jupiter.api.Test;

class VersionMismatchScreenTest {
    @Test
    void windowsUsesNativeExeReleaseAsset() {
        assertEquals(
            "update-dimensionworks-client.exe",
            VersionMismatchScreen.updaterFilename(true));
        assertEquals(
            List.of("C:\\mods\\update-dimensionworks-client.exe", "--release", "v0.2.0"),
            VersionMismatchScreen.updaterCommand(
                Path.of("C:\\mods\\update-dimensionworks-client.exe"), "v0.2.0", true));
    }

    @Test
    void posixUsesShellReleaseAsset() {
        assertEquals(
            "update-dimensionworks-client.sh",
            VersionMismatchScreen.updaterFilename(false));
        assertEquals(
            List.of("bash", "/mods/update-dimensionworks-client.sh", "--release", "v0.2.0"),
            VersionMismatchScreen.updaterCommand(
                Path.of("/mods/update-dimensionworks-client.sh"), "v0.2.0", false));
    }
}
