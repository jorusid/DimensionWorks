package dev.szx.dimensionworks.ftbchunksnoforceload.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Pseudo
@Mixin(targets = "dev.ftb.mods.ftbchunks.data.ClaimedChunkManagerImpl", remap = false)
abstract class ClaimedChunkManagerImplMixin {
    @Inject(method = "initForceLoadedChunks", at = @At("HEAD"), cancellable = true)
    private void dimensionworks$disableStartupForceLoads(CallbackInfo ci) {
        ci.cancel();
    }
}
