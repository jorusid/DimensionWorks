# DimensionWorks Drop Lifetime

Forge 1.20.1 server-side behavior that shortens how long dropped item entities remain on the ground, based on each stack's vanilla item rarity.

| Vanilla rarity | Color | Ground lifetime |
|---|---|---:|
| Common | White | 25 seconds |
| Uncommon | Yellow | 50 seconds |
| Rare | Aqua | 75 seconds |
| Epic (purple) | Light purple | 180 seconds (3 minutes) |

Common, Uncommon, and Rare increase by 25 seconds per level. Epic (purple) and any higher rarity exposed through the same vanilla rarity API use the 180-second (3-minute) cap. The mod uses the item's actual `ItemStack#getRarity()` value, so it does not depend on client-only border-rendering mods.

Build with `gradle build --no-daemon`.
