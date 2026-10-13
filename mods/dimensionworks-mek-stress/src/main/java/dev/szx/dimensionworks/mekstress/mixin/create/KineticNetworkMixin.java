package dev.szx.dimensionworks.mekstress.mixin.create;

import com.simibubi.create.content.kinetics.KineticNetwork;
import com.simibubi.create.content.kinetics.base.KineticBlockEntity;
import dev.szx.dimensionworks.mekstress.memory.IVirtualKineticMember;
import java.util.Iterator;
import java.util.Map;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = KineticNetwork.class, remap = false)
public abstract class KineticNetworkMixin {
    @Shadow
    public Map<KineticBlockEntity, Float> members;

    @Shadow
    private float unloadedStress;

    @Inject(method = "calculateStress", at = @At("HEAD"), cancellable = true, remap = false)
    private void dimensionworks$calculateVirtualMachineStress(CallbackInfoReturnable<Float> cir) {
        float presentStress = 0.0F;
        Iterator<KineticBlockEntity> iterator = members.keySet().iterator();
        while (iterator.hasNext()) {
            KineticBlockEntity member = iterator.next();
            if (member instanceof IVirtualKineticMember virtualMember) {
                if (!virtualMember.dimensionworks$isValid()) {
                    iterator.remove();
                    continue;
                }
            } else if (member.getLevel() == null
                || member.getLevel().getBlockEntity(member.getBlockPos()) != member) {
                iterator.remove();
                continue;
            }
            presentStress += ((KineticNetwork) (Object) this).getActualStressOf(member);
        }
        cir.setReturnValue(presentStress + unloadedStress);
    }
}
