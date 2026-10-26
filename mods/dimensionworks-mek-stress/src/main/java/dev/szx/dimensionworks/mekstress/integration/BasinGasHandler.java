package dev.szx.dimensionworks.mekstress.integration;

import com.simibubi.create.content.processing.basin.BasinBlockEntity;
import mekanism.api.Action;
import mekanism.api.chemical.gas.Gas;
import mekanism.api.chemical.gas.GasStack;
import mekanism.api.chemical.gas.IGasHandler;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.util.LazyOptional;

public final class BasinGasHandler implements IGasHandler {
    private static final long CAPACITY = 10_000L;
    private static final String NBT_KEY = "DimensionWorksBasinGas";

    private final BasinBlockEntity owner;
    private GasStack gas = GasStack.EMPTY;
    private long lastLeakTick;
    private final LazyOptional<IGasHandler> capability = LazyOptional.of(() -> this);

    public BasinGasHandler(BasinBlockEntity owner) {
        this.owner = owner;
    }

    public LazyOptional<IGasHandler> capability() {
        return capability;
    }

    public void invalidate() {
        capability.invalidate();
    }

    public boolean acceptProducedGas(Gas producedGas, long amount, boolean simulate) {
        if (amount <= 0 || amount > CAPACITY) {
            return false;
        }
        if (!gas.isEmpty() && !gas.getType().equals(producedGas)) {
            return false;
        }
        if (gas.getAmount() + amount > CAPACITY) {
            return false;
        }
        if (simulate) {
            return true;
        }

        gas = new GasStack(producedGas, gas.getAmount() + amount);
        owner.setChanged();
        leakIfDue();
        owner.notifyUpdate();
        return true;
    }

    public void leakIfDue() {
        Level level = owner.getLevel();
        if (level == null || level.isClientSide || gas.isEmpty()
            || !level.canSeeSky(owner.getBlockPos().above())) {
            return;
        }

        long now = level.getGameTime();
        if (now - lastLeakTick < 20) {
            return;
        }
        lastLeakTick = now;

        long loss = 100L + level.getRandom().nextInt(101);
        long remaining = Math.max(0L, gas.getAmount() - loss);
        gas = remaining == 0 ? GasStack.EMPTY : new GasStack(gas, remaining);
        owner.setChanged();
        owner.notifyUpdate();
    }

    public void readFromNbt(CompoundTag tag) {
        gas = tag.contains(NBT_KEY, Tag.TAG_COMPOUND)
            ? GasStack.readFromNBT(tag.getCompound(NBT_KEY))
            : GasStack.EMPTY;
    }

    public void writeToNbt(CompoundTag tag) {
        tag.put(NBT_KEY, gas.write(new CompoundTag()));
    }

    @Override
    public int getTanks() {
        return 1;
    }

    @Override
    public GasStack getChemicalInTank(int tank) {
        return tank == 0 ? gas.copy() : GasStack.EMPTY;
    }

    @Override
    public void setChemicalInTank(int tank, GasStack stack) {
        if (tank == 0 && stack.getAmount() <= CAPACITY) {
            gas = stack.copy();
        }
    }

    @Override
    public long getTankCapacity(int tank) {
        return tank == 0 ? CAPACITY : 0;
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
        if (tank != 0 || amount <= 0 || gas.isEmpty()) {
            return GasStack.EMPTY;
        }
        long extracted = Math.min(amount, gas.getAmount());
        GasStack result = new GasStack(gas, extracted);
        if (action.execute()) {
            long remaining = gas.getAmount() - extracted;
            gas = remaining == 0 ? GasStack.EMPTY : new GasStack(gas, remaining);
            owner.setChanged();
            owner.notifyUpdate();
        }
        return result;
    }
}
