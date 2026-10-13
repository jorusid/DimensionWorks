package dev.szx.dimensionworks.mekstress.core;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class PowerRouteSafetyTest {

    @Test
    void onlyAssignsStressForRoutesBackedByALiveKineticNetwork() {
        assertTrue(PowerRouteSafety.shouldAssignStress(true, true, 512.0F, true));
        assertTrue(PowerRouteSafety.shouldAssignStress(true, false, 0.0F, true));
        assertFalse(PowerRouteSafety.shouldAssignStress(true, true, 512.0F, false));
        assertFalse(PowerRouteSafety.shouldAssignStress(false, false, 0.0F, false));
    }

    @Test
    void requiresRunningUnstressedPowerForMechanicalEnergy() {
        assertTrue(PowerRouteSafety.hasMechanicalPower(true, true, 512.0F, true, false));
        assertTrue(PowerRouteSafety.hasMechanicalPower(true, true, -512.0F, true, false));
        assertFalse(PowerRouteSafety.hasMechanicalPower(true, false, 0.0F, true, false));
        assertFalse(PowerRouteSafety.hasMechanicalPower(true, true, Float.NaN, true, false));
        assertFalse(PowerRouteSafety.hasMechanicalPower(true, true, 512.0F, false, false));
        assertFalse(PowerRouteSafety.hasMechanicalPower(true, true, 512.0F, true, true));
    }
}
