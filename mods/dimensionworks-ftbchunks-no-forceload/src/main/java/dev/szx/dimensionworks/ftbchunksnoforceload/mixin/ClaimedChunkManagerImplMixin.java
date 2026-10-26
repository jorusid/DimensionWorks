package dev.szx.dimensionworks.ftbchunksnoforceload.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(targets = "dev.ftb.mods.ftbchunks.data.ClaimedChunkManagerImpl")
abstract class ClaimedChunkManagerImplMixin {
    @Inject(method = "initForceLoadedChunks", at = @At("HEAD"), cancellable = true)
    private void dimensionworks$disableStartupForceLoads(CallbackInfo ci) {
        ci.cancel();
    }
}
