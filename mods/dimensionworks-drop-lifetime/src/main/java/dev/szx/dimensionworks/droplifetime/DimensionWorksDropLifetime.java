package dev.szx.dimensionworks.droplifetime;

import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod(DimensionWorksDropLifetime.MOD_ID)
public final class DimensionWorksDropLifetime {
    public static final String MOD_ID = "dimensionworks_drop_lifetime";

    private DimensionWorksDropLifetime() {
    }

    @Mod.EventBusSubscriber(
            modid = MOD_ID,
            bus = Mod.EventBusSubscriber.Bus.FORGE
    )
    public static final class ItemLifetimeHandler {
        private static final int BASE_LIFETIME_SECONDS = 25;
        private static final int MAX_LIFETIME_SECONDS = 180;
        private static final int TICKS_PER_SECOND = 20;

        private ItemLifetimeHandler() {
        }

        @SubscribeEvent
        public static void onEntityJoinLevel(EntityJoinLevelEvent event) {
            if (event.getLevel().isClientSide()) {
                return;
            }
            if (!(event.getEntity() instanceof ItemEntity itemEntity)) {
                return;
            }

            ItemStack stack = itemEntity.getItem();
            if (stack.isEmpty()) {
                return;
            }

            Rarity rarity = stack.getRarity();
            int rarityLevel = switch (rarity) {
                case COMMON -> 1;
                case UNCOMMON -> 2;
                case RARE -> 3;
                case EPIC -> 4;
            };

            int lifetimeSeconds = Math.min(
                    MAX_LIFETIME_SECONDS,
                    BASE_LIFETIME_SECONDS * rarityLevel
            );
            itemEntity.lifespan = lifetimeSeconds * TICKS_PER_SECOND;
        }
    }
}
