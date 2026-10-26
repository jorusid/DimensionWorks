# DimensionWorks FTB Chunks Force-load Disable

This Forge 1.20.1 mod is pinned to the pack's FTB Chunks 2001.3.8.

- Rejects every FTB Chunks force-load request on the server, including packet, command, API, and admin paths.
- Blocks FTB Chunks from marking a claimed chunk as force-loaded or adding its own chunk tickets, while still allowing ticket removal.
- Prevents saved force-load entries from being restored into active tickets at startup.
- Hides force-load markers and tooltip details, and disables the force-load expiry wheel control in the FTB Chunks map.
- Cancels the Shift+left-click force-load action in the client map before it sends a packet.
- Leaves claims, unclaims, claim protection, teams, waypoints, and other mods' chunk tickets untouched.

Existing force-load metadata may remain in FTB Chunks team data, but this mod prevents that metadata from being turned into FTB Chunks chunk tickets. The map no longer displays the force-loaded marker or its tooltip status. A stale marker in saved team data does not mean the chunk has an active ticket. Players can still unclaim chunks and use all non-FTB-Chunks force-loading mechanisms.

The mod deliberately does not patch Minecraft's generic chunk-ticket API, so the pack's dedicated force-load blocks and other mods are not globally disabled.

Standalone Gradle builds resolve ForgeGradle and Mixin from their official plugin repositories. The complete client and server guard set is released as mod version 0.1.2.

The Mixin targets are declared as external optional targets at compile time; the mod metadata still requires the pack's pinned FTB Chunks version at runtime.
