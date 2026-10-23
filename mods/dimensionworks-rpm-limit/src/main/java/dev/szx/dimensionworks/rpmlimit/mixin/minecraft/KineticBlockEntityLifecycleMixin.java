package dev.szx.dimensionworks.rpmlimit.mixin.minecraft;

import com.simibubi.create.content.kinetics.base.KineticBlockEntity;
import dev.szx.dimensionworks.rpmlimit.optimizer.KineticNetworkOptimizer;
import net.minecraft.world.level.block.entity.BlockEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/** Invalidates kinetic totals when Minecraft unloads or removes a block entity. */
@Mixin(BlockEntity.class)
public abstract class KineticBlockEntityLifecycleMixin {

    @Inject(method = "setRemoved", at = @At("HEAD"))
    private void dimensionworks$invalidateKineticCache(CallbackInfo ci) {
        Object self = this;
        if (self instanceof KineticBlockEntity kinetic) {
            KineticNetworkOptimizer.invalidateFor(kinetic);
        }
    }
}
