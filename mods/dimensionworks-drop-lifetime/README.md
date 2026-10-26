# DimensionWorks Drop Lifetime

Forge 1.20.1 server-side behavior that shortens how long dropped item entities remain on the ground, based on each stack's vanilla item rarity.

| Vanilla rarity | Color | Ground lifetime outside Create processing areas |
|---|---|---:|
| Common | White | 25 seconds |
| Uncommon | Yellow | 50 seconds |
| Rare | Aqua | 75 seconds |
| Epic (purple) | Light purple | 180 seconds (3 minutes) |

Common, Uncommon, and Rare increase by 25 seconds per level. Epic (purple) and any higher rarity exposed through the same vanilla rarity API use the 180-second (3-minute) cap. The mod uses the item's actual `ItemStack#getRarity()` value, so it does not depend on client-only border-rendering mods.

## Create processing compatibility

When an item reaches its normal expiry time within 3 blocks of a recognized Create processing component (including encased fans, depots, basins, presses, millstones, crushing wheels, mixers, spouts, chutes, and belts), it receives another 25 seconds instead of being removed. This check repeats at expiry, allowing washing or blasting drops to remain available for long-running processing. Once the item is moved away from the processing area, normal rarity-based cleanup resumes.

This is a local, temporary exemption rather than a global lifetime increase, so loose drops in non-industrial areas are still cleaned up quickly.

Build with `gradle build --no-daemon`.
