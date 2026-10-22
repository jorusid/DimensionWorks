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

    public DimensionWorksDropLifetime() {
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
            int lifetimeSeconds = switch (rarity) {
                case COMMON -> 25;
                case UNCOMMON -> 50;
                case RARE -> 75;
                case EPIC -> MAX_LIFETIME_SECONDS;
            };
            itemEntity.lifespan = lifetimeSeconds * TICKS_PER_SECOND;
        }
    }
}
