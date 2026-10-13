package dev.szx.dimensionworks.mekstress.core;

import static org.junit.jupiter.api.Assertions.assertEquals;

import mekanism.api.math.FloatingLong;
import org.junit.jupiter.api.Test;

class MechanicalChargeTest {
    @Test
    void addsTwentyThousandKilojoulesPerTick() {
        FloatingLong capacity = FloatingLong.create(100_000_000L);

        assertEquals(FloatingLong.create(20_000_000L),
            MechanicalCharge.rechargeOneTick(FloatingLong.ZERO, capacity));
        assertEquals(FloatingLong.create(50_000_000L),
            MechanicalCharge.rechargeOneTick(FloatingLong.create(30_000_000L), capacity));
    }

    @Test
    void neverChargesPastTheContainerCapacity() {
        assertEquals(FloatingLong.create(25_000_000L),
            MechanicalCharge.rechargeOneTick(FloatingLong.create(20_000_000L), FloatingLong.create(25_000_000L)));
        assertEquals(FloatingLong.ZERO,
            MechanicalCharge.rechargeOneTick(FloatingLong.create(20_000_000L), FloatingLong.ZERO));
    }
}
