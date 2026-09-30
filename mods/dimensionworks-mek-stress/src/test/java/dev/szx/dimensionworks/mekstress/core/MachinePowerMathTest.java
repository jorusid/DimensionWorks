package dev.szx.dimensionworks.mekstress.core;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class MachinePowerMathTest {

    @Test
    void chargesEightSuForEachEffectiveRpm() {
        assertEquals(4_096L, MachinePowerMath.suForRpm(512.0F));
        assertEquals(32_768L, MachinePowerMath.suForRpm(4_096.0F));
        assertEquals(0L, MachinePowerMath.suForRpm(0.0F));
        assertEquals(0L, MachinePowerMath.suForRpm(-512.0F));
    }

    @Test
    void roundsFractionalRpmUpSoRunningMachinesNeverGetFreeTicks() {
        assertEquals(4_097L, MachinePowerMath.suForRpm(512.125F));
    }

    @Test
    void keepsAnIdleGearboxRunningWithoutChangingSingleMachineLoad() {
        assertEquals(4_096.0D, MachinePowerMath.gearboxLoad(0.0D, 512), 1.0E-9D);
        assertEquals(4_096.0D, MachinePowerMath.gearboxLoad(4_096.0D, 512), 1.0E-9D);
        assertEquals(12_288.0D, MachinePowerMath.gearboxLoad(12_288.0D, 512), 1.0E-9D);
        assertEquals(0.0D, MachinePowerMath.gearboxLoad(4_096.0D, 0), 1.0E-9D);
    }

    @Test
    void convertsEffectiveRpmScaleIntoPerRpmStress() {
        assertEquals(8.0F, MachinePowerMath.stressPerRpm(1.0F), 1.0E-6F);
        assertEquals(2.0F, MachinePowerMath.stressPerRpm(0.25F), 1.0E-6F);
        assertEquals(0.0F, MachinePowerMath.stressPerRpm(-1.0F), 1.0E-6F);
    }

    @Test
    void scalesWorkWithRpmAndCapsAtTargetSpeed() {
        assertEquals(0.0D, MachinePowerMath.workRate(0, 4_096), 1.0E-9D);
        assertEquals(0.25D, MachinePowerMath.workRate(1_024, 4_096), 1.0E-9D);
        assertEquals(1.0D, MachinePowerMath.workRate(4_096, 4_096), 1.0E-9D);
        assertEquals(1.0D, MachinePowerMath.workRate(8_192, 4_096), 1.0E-9D);
        assertEquals(0.0D, MachinePowerMath.workRate(4_096, 0), 1.0E-9D);
    }
}
