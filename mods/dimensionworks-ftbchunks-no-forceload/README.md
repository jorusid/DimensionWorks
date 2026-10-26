# DimensionWorks FTB Chunks Force-load Disable

This Forge 1.20.1 mod is pinned to the pack's FTB Chunks 2001.3.8.

- Rejects FTB Chunks force-load requests on the server.
- Prevents FTB Chunks from restoring force-load tickets during startup and player login/logout transitions.
- Hides the force-loaded marker and tooltip details in the FTB Chunks map.
- Leaves claims, unclaims, claim protection, teams, waypoints, and other mods' chunk tickets untouched.

Existing force-load metadata may remain in FTB Chunks team data, but this mod prevents that metadata from being turned into FTB Chunks chunk tickets. Players can still unclaim chunks and use all non-FTB-Chunks force-loading mechanisms.

The mod deliberately does not patch Minecraft's generic chunk-ticket API, so the pack's dedicated force-load blocks and other mods are not globally disabled.
