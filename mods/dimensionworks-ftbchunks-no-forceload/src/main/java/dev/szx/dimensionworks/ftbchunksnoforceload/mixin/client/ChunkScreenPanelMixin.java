package dev.szx.dimensionworks.ftbchunksnoforceload.mixin.client;

import net.minecraft.client.gui.screens.Screen;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Coerce;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Set;

@Pseudo
@Mixin(targets = "dev.ftb.mods.ftbchunks.client.gui.map.ChunkScreenPanel", remap = false)
abstract class ChunkScreenPanelMixin {
    @Shadow @Final private Set<?> selectedChunks;

    @Inject(
            method = "mouseReleased",
            at = @At(
                    value = "INVOKE",
                    target = "Ldev/ftb/mods/ftblibrary/client/gui/widget/Panel;mouseReleased(Ldev/ftb/mods/ftblibrary/client/gui/input/MouseButton;)V",
                    shift = At.Shift.AFTER
            ),
            cancellable = true,
            remap = false
    )
    private void dimensionworks$disableShiftLeftForceLoad(@Coerce Object button, CallbackInfo ci) {
        if (!Screen.hasShiftDown() || selectedChunks.isEmpty() || !isLeftButton(button)) {
            return;
        }

        // In FTB Chunks 2001.3.8, Shift+left-click is the force-load action.
        selectedChunks.clear();
        ci.cancel();
    }

    private static boolean isLeftButton(Object button) {
        try {
            return Boolean.TRUE.equals(button.getClass().getMethod("isLeft").invoke(button));
        } catch (ReflectiveOperationException exception) {
            throw new IllegalStateException("Unable to inspect FTB Library mouse button", exception);
        }
    }
}
