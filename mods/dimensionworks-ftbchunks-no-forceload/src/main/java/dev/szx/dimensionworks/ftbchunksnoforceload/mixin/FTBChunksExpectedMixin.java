package dev.szx.dimensionworks.ftbchunksnoforceload.mixin;

import net.minecraft.server.level.ServerLevel;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.UUID;

@Pseudo
@Mixin(targets = "dev.ftb.mods.ftbchunks.FTBChunksExpected", remap = false)
abstract class FTBChunksExpectedMixin {
    @Inject(
            method = "addChunkToForceLoaded",
            at = @At("HEAD"),
            cancellable = true,
            remap = false
    )
    private static void dimensionworks$denyFtbChunksTicket(
            ServerLevel level,
            String modId,
            UUID owner,
            int chunkX,
            int chunkZ,
            boolean add,
            CallbackInfo ci
    ) {
        // Always allow ticket removal; reject every FTB Chunks ticket addition.
        if (add && "ftbchunks".equals(modId)) {
            ci.cancel();
        }
    }
}
