package dev.szx.dimensionworks.ftbchunksnoforceload.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Pseudo
@Mixin(targets = "dev.ftb.mods.ftbchunks.data.ClaimedChunkImpl", remap = false)
abstract class ClaimedChunkImplMixin {
    @Inject(method = "setForceLoadedTime", at = @At("HEAD"), cancellable = true, remap = false)
    private void dimensionworks$denyForceLoadedState(long time, CallbackInfo ci) {
        // Zero is required for normal unloads. Any positive timestamp enables force-loading.
        if (time > 0L) {
            ci.cancel();
        }
    }
}
