package dev.szx.dimensionworks.droplifetime;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.event.entity.item.ItemExpireEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

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
        private static final int INDUSTRIAL_EXTENSION_TICKS = BASE_LIFETIME_SECONDS * TICKS_PER_SECOND;
        private static final int INDUSTRIAL_SCAN_RADIUS = 3;

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
                case COMMON -> BASE_LIFETIME_SECONDS;
                case UNCOMMON -> 50;
                case RARE -> 75;
                case EPIC -> MAX_LIFETIME_SECONDS;
            };
            itemEntity.lifespan = lifetimeSeconds * TICKS_PER_SECOND;
        }

        @SubscribeEvent
        public static void onItemExpire(ItemExpireEvent event) {
            ItemEntity itemEntity = event.getEntity();
            Level level = itemEntity.level();
            if (level.isClientSide() || !isNearCreateProcessingMachine(level, itemEntity.blockPosition())) {
                return;
            }

            // Keep drops alive while they are part of a Create processing setup.
            // If they leave the area, normal rarity-based expiry resumes.
            event.setExtraLife(INDUSTRIAL_EXTENSION_TICKS);
        }

        private static boolean isNearCreateProcessingMachine(Level level, BlockPos center) {
            for (BlockPos pos : BlockPos.betweenClosed(
                    center.offset(-INDUSTRIAL_SCAN_RADIUS, -INDUSTRIAL_SCAN_RADIUS, -INDUSTRIAL_SCAN_RADIUS),
                    center.offset(INDUSTRIAL_SCAN_RADIUS, INDUSTRIAL_SCAN_RADIUS, INDUSTRIAL_SCAN_RADIUS))) {
                BlockState state = level.getBlockState(pos);
                ResourceLocation id = ForgeRegistries.BLOCKS.getKey(state.getBlock());
                if (id == null || !"create".equals(id.getNamespace())) {
                    continue;
                }

                String path = id.getPath();
                if (path.contains("encased_fan")
                        || path.contains("depot")
                        || path.contains("basin")
                        || path.contains("mechanical_press")
                        || path.contains("millstone")
                        || path.contains("crushing_wheel")
                        || path.contains("mechanical_mixer")
                        || path.contains("spout")
                        || path.contains("chute")
                        || path.contains("belt")) {
                    return true;
                }
            }
            return false;
        }
    }
}
