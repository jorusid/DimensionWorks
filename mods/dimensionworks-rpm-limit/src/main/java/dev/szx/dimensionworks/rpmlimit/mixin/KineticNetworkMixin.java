package dev.szx.dimensionworks.rpmlimit.mixin;

import com.simibubi.create.content.kinetics.KineticNetwork;
import com.simibubi.create.content.kinetics.base.KineticBlockEntity;
import dev.szx.dimensionworks.rpmlimit.RpmLimitManager;
import dev.szx.dimensionworks.rpmlimit.optimizer.KineticNetworkOptimizer;
import dev.szx.dimensionworks.rpmlimit.quota.CreateCapacityRegistry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * Adds cached network accounting without changing Create's rotation-propagation graph.
 * Natural capacity is cached before the existing per-owner quota is applied.
 */
@Mixin(value = KineticNetwork.class, remap = false)
public abstract class KineticNetworkMixin {

    @Inject(method = "calculateCapacity", at = @At("HEAD"), cancellable = true, remap = false)
    private void dimensionworks$useCachedCapacity(CallbackInfoReturnable<Float> cir) {
        KineticNetwork self = (KineticNetwork) (Object) this;
        Float cached = KineticNetworkOptimizer.cachedCapacity(self);
        if (cached != null) {
            cir.setReturnValue(CreateCapacityRegistry.limitNaturalCapacity(self, cached));
        }
    }

    @Inject(method = "calculateCapacity", at = @At("RETURN"), cancellable = true, remap = false)
    private void dimensionworks$limitOwnerAggregate(CallbackInfoReturnable<Float> cir) {
        KineticNetwork self = (KineticNetwork) (Object) this;
        float naturalCapacity = cir.getReturnValueF();
        KineticNetworkOptimizer.finishCapacityRebuild(self, naturalCapacity);
        cir.setReturnValue(CreateCapacityRegistry.limitNaturalCapacity(self, naturalCapacity));
    }

    @Inject(method = "getActualStressOf", at = @At("RETURN"), cancellable = true, remap = false)
    private void dimensionworks$limitEffectiveStress(KineticBlockEntity be,
                                                     CallbackInfoReturnable<Float> cir) {
        float raw = be.getTheoreticalSpeed();
        float scale = RpmLimitManager.effectiveScale(be, raw);
        if (scale < 1) {
            cir.setReturnValue(cir.getReturnValueF() * scale);
        }
    }

    @Inject(method = "getActualCapacityOf", at = @At("RETURN"), cancellable = true, remap = false)
    private void dimensionworks$limitEffectiveCapacity(KineticBlockEntity be,
                                                       CallbackInfoReturnable<Float> cir) {
        float raw = be.getGeneratedSpeed();
        float scale = RpmLimitManager.effectiveScale(be, raw);
        if (scale < 1) {
            cir.setReturnValue(cir.getReturnValueF() * scale);
        }
    }

    @Inject(method = "updateCapacityFor", at = @At("HEAD"), cancellable = true, remap = false)
    private void dimensionworks$updateCapacityIncrementally(KineticBlockEntity be, float capacity,
                                                            CallbackInfo ci) {
        KineticNetwork self = (KineticNetwork) (Object) this;
        self.sources.put(be, capacity);
        KineticNetworkOptimizer.updateCapacityContribution(self, be);

        if (KineticNetworkOptimizer.isBatching()) {
            KineticNetworkOptimizer.queueNetwork(self);
            ci.cancel();
            return;
        }

        self.updateCapacity();
        ci.cancel();
    }

    @Inject(method = "updateStressFor", at = @At("HEAD"), cancellable = true, remap = false)
    private void dimensionworks$updateStressIncrementally(KineticBlockEntity be, float stress,
                                                          CallbackInfo ci) {
        KineticNetwork self = (KineticNetwork) (Object) this;
        self.members.put(be, stress);
        KineticNetworkOptimizer.updateStressContribution(self, be);

        if (KineticNetworkOptimizer.isBatching()) {
            KineticNetworkOptimizer.queueNetwork(self);
            ci.cancel();
            return;
        }

        self.updateStress();
        ci.cancel();
    }

    @Inject(method = "updateCapacity", at = @At("HEAD"), cancellable = true, remap = false)
    private void dimensionworks$batchCapacityRefresh(CallbackInfo ci) {
        if (KineticNetworkOptimizer.isBatching()) {
            KineticNetworkOptimizer.queueNetwork((KineticNetwork) (Object) this);
            ci.cancel();
        }
    }

    @Inject(method = "updateStress", at = @At("HEAD"), cancellable = true, remap = false)
    private void dimensionworks$batchStressRefresh(CallbackInfo ci) {
        if (KineticNetworkOptimizer.isBatching()) {
            KineticNetworkOptimizer.queueNetwork((KineticNetwork) (Object) this);
            ci.cancel();
        }
    }

    @Inject(method = "updateNetwork", at = @At("HEAD"), cancellable = true, remap = false)
    private void dimensionworks$batchFullRefresh(CallbackInfo ci) {
        if (KineticNetworkOptimizer.isBatching()) {
            KineticNetworkOptimizer.queueNetwork((KineticNetwork) (Object) this);
            ci.cancel();
        }
    }

    @Inject(method = "add", at = @At("RETURN"), remap = false)
    private void dimensionworks$invalidateAfterAdd(KineticBlockEntity be, CallbackInfo ci) {
        KineticNetworkOptimizer.onTopologyChanged((KineticNetwork) (Object) this);
    }

    @Inject(method = "addSilently", at = @At("RETURN"), remap = false)
    private void dimensionworks$invalidateAfterSilentAdd(KineticBlockEntity be, float lastCapacity,
                                                         float lastStress, CallbackInfo ci) {
        KineticNetworkOptimizer.onTopologyChanged((KineticNetwork) (Object) this);
    }

    @Inject(method = "remove", at = @At("RETURN"), remap = false)
    private void dimensionworks$invalidateAfterRemove(KineticBlockEntity be, CallbackInfo ci) {
        KineticNetworkOptimizer.onTopologyChanged((KineticNetwork) (Object) this);
    }

    @Inject(method = "initFromTE", at = @At("HEAD"), remap = false)
    private void dimensionworks$invalidateBeforeLoad(float maxStress, float currentStress, int members,
                                                     CallbackInfo ci) {
        KineticNetworkOptimizer.invalidate((KineticNetwork) (Object) this);
    }
}
