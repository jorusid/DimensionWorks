package dev.szx.dimensionworks.rpmlimit.quota;

import appeng.api.features.IPlayerRegistry;
import appeng.api.networking.IGridNode;
import appeng.me.service.CraftingService;
import dev.szx.dimensionworks.rpmlimit.mixin.ae2.CraftingServiceAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;

import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.UUID;

/** Weak registry of live AE2 crafting services and their grid owners. */
public final class AeCraftingRegistry {
    private static final Set<CraftingService> SERVICES =
        Collections.synchronizedSet(Collections.newSetFromMap(new WeakHashMap<>()));

    private AeCraftingRegistry() {
    }

    public static void register(CraftingService service) {
        if (service != null) {
            SERVICES.add(service);
        }
    }

    public static UUID owner(IGridNode node) {
        if (node == null) {
            return GearHeartOwnerResolver.SHARED_OWNER;
        }

        UUID profile = node.getOwningPlayerProfileId();
        if (profile == null && node.getOwningPlayerId() >= 0
            && node.getOwner() instanceof BlockEntity blockEntity
            && blockEntity.getLevel() != null) {
            IPlayerRegistry registry = IPlayerRegistry.getMapping(blockEntity.getLevel());
            if (registry != null) {
                profile = registry.getProfileId(node.getOwningPlayerId());
            }
        }
        return GearHeartOwnerResolver.normalize(profile);
    }

    public static UUID owner(CraftingService service) {
        if (service == null) {
            return GearHeartOwnerResolver.SHARED_OWNER;
        }
        appeng.api.networking.IGrid grid =
            ((CraftingServiceAccessor) (Object) service).dimensionworks$getGrid();
        return owner(grid == null ? null : grid.getPivot());
    }

    public static int busyCount(UUID owner) {
        if (owner == null) {
            return 0;
        }
        int count = 0;
        synchronized (SERVICES) {
            for (CraftingService service : SERVICES) {
                if (!owner.equals(owner(service))) {
                    continue;
                }
                count += busyCpus(service);
            }
        }
        return count;
    }

    public static int busyCountForOwner(UUID owner) {
        if (owner == null) {
            return 0;
        }
        int count = busyCount(owner);
        if (!owner.equals(GearHeartOwnerResolver.SHARED_OWNER)) {
            count += busyCount(GearHeartOwnerResolver.SHARED_OWNER);
        }
        return count;
    }

    static void clearForTest() {
        SERVICES.clear();
    }

    private static int busyCpus(CraftingService service) {
        int count = 0;
        for (var cpu : service.getCpus()) {
            if (cpu.isBusy()) {
                count++;
            }
        }
        return count;
    }
}
