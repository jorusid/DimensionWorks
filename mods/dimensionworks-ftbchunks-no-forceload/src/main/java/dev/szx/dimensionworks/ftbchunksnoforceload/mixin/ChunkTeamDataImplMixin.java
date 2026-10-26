package dev.szx.dimensionworks.ftbchunksnoforceload.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(targets = "dev.ftb.mods.ftbchunks.data.ChunkTeamDataImpl")
abstract class ChunkTeamDataImplMixin {
    @Inject(method = "forceLoad", at = @At("HEAD"), cancellable = true)
    private void dimensionworks$denyForceLoad(CallbackInfoReturnable<Object> cir) {
        try {
            Class<?> problemClass = Class.forName(
                    "dev.ftb.mods.ftbchunks.api.ClaimResult$StandardProblem",
                    false,
                    getClass().getClassLoader()
            );
            Object denied = problemClass.getField("NOT_ENOUGH_POWER").get(null);
            cir.setReturnValue(denied);
        } catch (ReflectiveOperationException exception) {
            throw new IllegalStateException("Unable to resolve FTB Chunks force-load denial result", exception);
        }
    }

    @Inject(method = "updateChunkTickets", at = @At("HEAD"), cancellable = true)
    private void dimensionworks$disableTicketRestoration(boolean load, CallbackInfo ci) {
        ci.cancel();
    }
}
