package dev.szx.dimensionworks.mekstress.mixin.create;

import com.simibubi.create.content.processing.basin.BasinBlockEntity;
import dev.szx.dimensionworks.mekstress.DimensionWorksMekStress;
import java.util.List;
import mekanism.api.Action;
import mekanism.api.MekanismAPI;
import mekanism.api.chemical.gas.Gas;
import mekanism.api.chemical.gas.GasStack;
import mekanism.api.chemical.gas.IGasHandler;
import mekanism.common.capabilities.Capabilities;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.fluids.FluidStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = BasinBlockEntity.class, remap = false)
public abstract class BasinGasIntegrationMixin implements IGasHandler {
    @Unique
    private static final long dimensionworks$gasCapacity = 10_000L;
    @Unique
    private GasStack dimensionworks$gas = GasStack.EMPTY;
    @Unique
    private long dimensionworks$lastGasLeakTick;
    @Unique
    private LazyOptional<IGasHandler> dimensionworks$gasCapability =
        LazyOptional.of(() -> (IGasHandler) (Object) this);

    @Inject(method = "acceptOutputs", at = @At("HEAD"), cancellable = true, remap = false)
    private void dimensionworks$acceptGasRecipeOutput(
        List<ItemStack> outputItems,
        List<FluidStack> outputFluids,
        boolean simulate,
        CallbackInfoReturnable<Boolean> cir
    ) {
        boolean hasMarker = outputItems.stream()
            .anyMatch(stack -> stack.is(DimensionWorksMekStress.GAS_OUTPUT_ITEM.get()));
        if (!hasMarker) {
            return;
        }

        if (outputItems.size() != 1 || !outputFluids.isEmpty()) {
            cir.setReturnValue(false);
            return;
        }

        ItemStack marker = outputItems.get(0);
        CompoundTag tag = marker.getTag();
        if (tag == null || !tag.contains("Gas", Tag.TAG_STRING) || !tag.contains("Amount", Tag.TAG_ANY_NUMERIC)) {
            cir.setReturnValue(false);
            return;
        }

        ResourceLocation gasId = ResourceLocation.tryParse(tag.getString("Gas"));
        Gas gas = gasId == null ? null : MekanismAPI.gasRegistry().getValue(gasId);
        long amount = tag.getLong("Amount") * marker.getCount();
        if (gas == null || gas.isEmptyType() || amount <= 0) {
            cir.setReturnValue(false);
            return;
        }

        cir.setReturnValue(dimensionworks$acceptProducedGas(gas, amount, simulate));
    }

    @Unique
    private boolean dimensionworks$acceptProducedGas(Gas gas, long amount, boolean simulate) {
        if (amount <= 0 || amount > dimensionworks$gasCapacity) {
            return false;
        }
        if (!dimensionworks$gas.isEmpty() && !dimensionworks$gas.getType().equals(gas)) {
            return false;
        }
        if (dimensionworks$gas.getAmount() + amount > dimensionworks$gasCapacity) {
            return false;
        }
        if (simulate) {
            return true;
        }

        long stored = dimensionworks$gas.getAmount();
        dimensionworks$gas = new GasStack(gas, stored + amount);
        BasinBlockEntity self = (BasinBlockEntity) (Object) this;
        self.setChanged();
        dimensionworks$applyLeakIfDue(self);
        self.notifyUpdate();
        return true;
    }

    @Inject(method = "tick", at = @At("TAIL"), remap = false)
    private void dimensionworks$leakExposedGas(CallbackInfo ci) {
        dimensionworks$applyLeakIfDue((BasinBlockEntity) (Object) this);
    }

    @Unique
    private void dimensionworks$applyLeakIfDue(BasinBlockEntity self) {
        if (self.getLevel() == null || self.getLevel().isClientSide || dimensionworks$gas.isEmpty()) {
            return;
        }
        long now = self.getLevel().getGameTime();
        if (now - dimensionworks$lastGasLeakTick < 20
            || !self.getLevel().canSeeSky(self.getBlockPos().above())) {
            return;
        }

        dimensionworks$lastGasLeakTick = now;
        long loss = 100L + self.getLevel().getRandom().nextInt(101);
        long remaining = Math.max(0L, dimensionworks$gas.getAmount() - loss);
        dimensionworks$gas = remaining == 0 ? GasStack.EMPTY : new GasStack(dimensionworks$gas, remaining);
        self.setChanged();
        self.notifyUpdate();
    }

    @Inject(method = "read", at = @At("RETURN"), remap = false)
    private void dimensionworks$readGas(CompoundTag tag, boolean clientPacket, CallbackInfo ci) {
        dimensionworks$gas = tag.contains("DimensionWorksBasinGas", Tag.TAG_COMPOUND)
            ? GasStack.readFromNBT(tag.getCompound("DimensionWorksBasinGas"))
            : GasStack.EMPTY;
    }

    @Inject(method = "write", at = @At("RETURN"), remap = false)
    private void dimensionworks$writeGas(CompoundTag tag, boolean clientPacket, CallbackInfo ci) {
        tag.put("DimensionWorksBasinGas", dimensionworks$gas.write(new CompoundTag()));
    }

    @Inject(method = "getCapability", at = @At("HEAD"), cancellable = true, remap = false)
    private void dimensionworks$exposeGasCapability(
        Capability<?> capability,
        Direction side,
        CallbackInfoReturnable<LazyOptional<?>> cir
    ) {
        if (capability == Capabilities.GAS_HANDLER) {
            cir.setReturnValue(dimensionworks$gasCapability.cast());
        }
    }

    @Inject(method = "invalidate", at = @At("HEAD"), remap = false)
    private void dimensionworks$invalidateGasCapability(CallbackInfo ci) {
        dimensionworks$gasCapability.invalidate();
    }

    @Override
    public int getTanks() {
        return 1;
    }

    @Override
    public GasStack getChemicalInTank(int tank) {
        return tank == 0 ? dimensionworks$gas.copy() : GasStack.EMPTY;
    }

    @Override
    public void setChemicalInTank(int tank, GasStack stack) {
        if (tank == 0 && stack.getAmount() <= dimensionworks$gasCapacity) {
            dimensionworks$gas = stack.copy();
        }
    }

    @Override
    public long getTankCapacity(int tank) {
        return tank == 0 ? dimensionworks$gasCapacity : 0;
    }

    @Override
    public boolean isValid(int tank, GasStack stack) {
        return false;
    }

    @Override
    public GasStack insertChemical(int tank, GasStack stack, Action action) {
        return stack;
    }

    @Override
    public GasStack extractChemical(int tank, long amount, Action action) {
        if (tank != 0 || amount <= 0 || dimensionworks$gas.isEmpty()) {
            return GasStack.EMPTY;
        }
        long extracted = Math.min(amount, dimensionworks$gas.getAmount());
        GasStack result = new GasStack(dimensionworks$gas, extracted);
        if (action.execute()) {
            long remaining = dimensionworks$gas.getAmount() - extracted;
            dimensionworks$gas = remaining == 0 ? GasStack.EMPTY : new GasStack(dimensionworks$gas, remaining);
            BasinBlockEntity self = (BasinBlockEntity) (Object) this;
            self.setChanged();
            self.notifyUpdate();
        }
        return result;
    }
}
