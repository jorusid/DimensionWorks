package dev.szx.dimensionworks.mekstress.mixin.mek;

import dev.szx.dimensionworks.mekstress.integration.jade.JadeEnergyVisibility;
import net.minecraft.world.level.block.entity.BlockEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import snownee.jade.addon.universal.EnergyStorageProvider;
import snownee.jade.api.Accessor;

/** Suppresses Jade's built-in FE/J provider for every Mekanism block entity. */
@Mixin(value = EnergyStorageProvider.class, remap = false)
public abstract class JadeUniversalEnergyProviderMixin {
    @Inject(method = "putData", at = @At("HEAD"), cancellable = true, remap = false)
    private static void dimensionworks$skipServerData(Accessor<?> accessor, CallbackInfo ci) {
        if (accessor.getTarget() instanceof BlockEntity blockEntity
            && JadeEnergyVisibility.shouldHide(blockEntity)) {
            ci.cancel();
        }
    }
}
