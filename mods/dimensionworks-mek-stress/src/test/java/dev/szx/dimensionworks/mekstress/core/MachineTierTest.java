package dev.szx.dimensionworks.mekstress.core;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class MachineTierTest {

    @Test
    void followsTheMekanismQualityTable() {
        assertEquals(1_024, MachineTier.BASIC.targetRpm());
        assertEquals(8_192L, MachineTier.BASIC.suPerTick());
        assertEquals(1_024L, MachineTier.BASIC.bandwidthRpm());
        assertEquals(8_192, MachineTier.ULTIMATE.targetRpm());
        assertEquals(65_536L, MachineTier.ULTIMATE.suPerTick());
        assertEquals(8_192L, MachineTier.ULTIMATE.bandwidthRpm());
    }
}
