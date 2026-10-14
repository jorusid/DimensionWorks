package dev.szx.dimensionworks.rpmlimit;

import net.minecraft.nbt.CompoundTag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GearHeartLoginPolicyTest {

    @Test
    void emptySlotIsFilledButOccupiedSlotIsLeftAlone() {
        assertTrue(GearHeartState.shouldFillEmptySlot(true));
        assertFalse(GearHeartState.shouldFillEmptySlot(false));
    }

    @Test
    void replacementHeartStartsWithEveryCurseUnrepaired() {
        CompoundTag heart = GearHeartState.unrepairedCursedHeartTag();

        assertEquals(1, heart.getInt("CustomModelData"));
        assertEquals(0, heart.getInt(GearHeartState.REPAIRED_MASK_KEY));
    }
}
