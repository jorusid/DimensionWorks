package dev.szx.dimensionworks.mekstress.integration.mek;

import dev.szx.dimensionworks.mekstress.core.MachineWorkContext;
import mekanism.api.Action;
import mekanism.api.AutomationType;
import mekanism.api.chemical.ChemicalStack;
import mekanism.api.chemical.IChemicalTank;
import mekanism.api.fluid.IExtendedFluidTank;
import mekanism.api.inventory.IInventorySlot;
import mekanism.api.recipes.cache.CachedRecipe.OperationTracker;
import mekanism.api.recipes.cache.CachedRecipe.OperationTracker.RecipeError;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

/** Shared output insertion and capacity checks for the mechanical production multiplier. */
public final class MachineOutputDelivery {
    private MachineOutputDelivery() {
    }

    public static void insertItem(IInventorySlot slot, ItemStack toOutput, int operations) {
        if (!MachineWorkContext.scaling() || operations <= 0 || toOutput.isEmpty()) {
            return;
        }
        long count = MachineWorkContext.scaleOutput(toOutput.getCount(), operations);
        insertItemAmount(slot, toOutput, count);
    }

    public static void insertItemAmount(IInventorySlot slot, ItemStack toOutput, long count) {
        if (count <= 0L || toOutput.isEmpty()) {
            return;
        }
        int batchSize = Math.max(1, toOutput.getMaxStackSize());
        long remaining = count;
        while (remaining > 0L) {
            int batchCount = (int) Math.min((long) batchSize, remaining);
            ItemStack remainder = slot.insertItem(toOutput.copyWithCount(batchCount),
                Action.EXECUTE, AutomationType.INTERNAL);
            long inserted = batchCount - (long) remainder.getCount();
            if (inserted <= 0L) {
                return;
            }
            remaining -= inserted;
        }
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    public static void insertChemical(IChemicalTank tank, ChemicalStack toOutput, int operations) {
        if (!MachineWorkContext.scaling() || operations <= 0 || toOutput.isEmpty()) {
            return;
        }
        long amount = MachineWorkContext.scaleOutput(toOutput.getAmount(), operations);
        if (amount > 0L) {
            tank.insert(tank.createStack(toOutput, amount), Action.EXECUTE, AutomationType.INTERNAL);
        }
    }

    public static void insertFluid(IExtendedFluidTank tank, FluidStack toOutput, int operations) {
        if (!MachineWorkContext.scaling() || operations <= 0 || toOutput.isEmpty()) {
            return;
        }
        long amount = MachineWorkContext.scaleOutput(toOutput.getAmount(), operations);
        if (amount > 0L) {
            tank.insert(new FluidStack(toOutput, (int) Math.min(Integer.MAX_VALUE, amount)),
                Action.EXECUTE, AutomationType.INTERNAL);
        }
    }

    public static void capItem(OperationTracker tracker, RecipeError notEnoughSpace, IInventorySlot slot,
                               ItemStack toOutput) {
        if (toOutput.isEmpty()) {
            return;
        }
        ItemStack maxOutput = toOutput.copyWithCount(toOutput.getMaxStackSize());
        ItemStack remainder = slot.insertItem(maxOutput, Action.SIMULATE, AutomationType.INTERNAL);
        long availableRoom = maxOutput.getCount() - remainder.getCount();
        int operations = MachineWorkContext.maxOutputOperations(toOutput.getCount(), availableRoom);
        tracker.updateOperations(operations);
        if (operations == 0) {
            if (availableRoom == 0L && slot.getLimit(slot.getStack()) - slot.getCount() > 0) {
                tracker.addError(RecipeError.INPUT_DOESNT_PRODUCE_OUTPUT);
            } else {
                tracker.addError(notEnoughSpace);
            }
        }
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    public static void capChemical(OperationTracker tracker, RecipeError notEnoughSpace, IChemicalTank tank,
                                   ChemicalStack toOutput) {
        if (toOutput.isEmpty()) {
            return;
        }
        ChemicalStack maxOutput = tank.createStack(toOutput, Long.MAX_VALUE);
        ChemicalStack remainder = tank.insert(maxOutput, Action.SIMULATE, AutomationType.INTERNAL);
        long availableRoom = maxOutput.getAmount() - remainder.getAmount();
        int operations = MachineWorkContext.maxOutputOperations(toOutput.getAmount(), availableRoom);
        tracker.updateOperations(operations);
        if (operations == 0) {
            if (availableRoom == 0L && tank.getNeeded() > 0L) {
                tracker.addError(RecipeError.INPUT_DOESNT_PRODUCE_OUTPUT);
            } else {
                tracker.addError(notEnoughSpace);
            }
        }
    }

    public static void capFluid(OperationTracker tracker, RecipeError notEnoughSpace, IExtendedFluidTank tank,
                                FluidStack toOutput) {
        if (toOutput.isEmpty()) {
            return;
        }
        FluidStack maxOutput = new FluidStack(toOutput, Integer.MAX_VALUE);
        FluidStack remainder = tank.insert(maxOutput, Action.SIMULATE, AutomationType.INTERNAL);
        long availableRoom = maxOutput.getAmount() - remainder.getAmount();
        int operations = MachineWorkContext.maxOutputOperations(toOutput.getAmount(), availableRoom);
        tracker.updateOperations(operations);
        if (operations == 0) {
            if (availableRoom == 0L && tank.getNeeded() > 0L) {
                tracker.addError(RecipeError.INPUT_DOESNT_PRODUCE_OUTPUT);
            } else {
                tracker.addError(notEnoughSpace);
            }
        }
    }
}
