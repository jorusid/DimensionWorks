package dev.szx.dimensionworks.mekstress.core;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class NetworkMathTest {

    @Test
    void computesTheDdr5TerminalCalibration() {
        long demandRpm = 10L * 4096L + 100L * 2048L;
        assertEquals(245_760L, demandRpm);
        assertEquals(1_966_080L, demandRpm * 8L);
        assertEquals(0.9375D, NetworkMath.clampRatio(NetworkMath.bandwidthRatio(262_144L, demandRpm)), 1.0E-9D);
    }

    @Test
    void usesTheLowerOfInventoryAndBandwidth() {
        double rpmQ = NetworkMath.rpmQ(512L, 1_024L);
        long requiredSu = NetworkMath.requiredSuForRpm(200L, 512L, 1_024L);
        assertEquals(100L, requiredSu);
        assertEquals(0.5D, rpmQ, 1.0E-9D);
        assertEquals(0.0D, NetworkMath.suGate(99L, requiredSu), 1.0E-9D);
        assertEquals(1.0D, NetworkMath.suGate(100L, requiredSu), 1.0E-9D);
        assertEquals(rpmQ, NetworkMath.finalQ(1.0D, rpmQ), 1.0E-9D);
    }

    @Test
    void appliesCongestionEfficiencyToProduction() {
        assertEquals(0.4204482D, NetworkMath.efficiency(0.5D, 1.25D), 1.0E-7D);
        assertEquals(0.2102241D, NetworkMath.productionRate(1.0D, 0.5D, 1.25D), 1.0E-7D);
    }

    @Test
    void handlesZeroInventoryAndExactCapacity() {
        assertEquals(0.0D, NetworkMath.suGate(0L, 100L), 1.0E-9D);
        assertEquals(1.0D, NetworkMath.suGate(100L, 100L), 1.0E-9D);
        assertEquals(0.0D, NetworkMath.bandwidthQ(0L, 100L), 1.0E-9D);
        assertEquals(1.0D, NetworkMath.bandwidthQ(100L, 100L), 1.0E-9D);
    }

    @Test
    void keepsRawRatiosNeutralButAvailableQRequiresDemand() {
        assertEquals(0.0D, NetworkMath.suGate(0L, 0L), 1.0E-9D);
        assertEquals(0.0D, NetworkMath.bandwidthQ(0L, 0L), 1.0E-9D);
        assertEquals(1.0D, NetworkMath.finalQ(1.0D, 1.0D), 1.0E-9D);
        assertEquals(0.0D, NetworkMath.availableQ(0L, 0L, 0L, 0L), 1.0E-9D);
    }

    @Test
    void requiresBothSuAndRpmForAvailableMechanicalPower() {
        assertEquals(0.0D, NetworkMath.availableQ(0L, 100L, 1_024L, 256L), 1.0E-9D);
        assertEquals(0.0D, NetworkMath.availableQ(100L, 100L, 0L, 256L), 1.0E-9D);
        assertEquals(0.0D, NetworkMath.availableQ(100L, 0L, 1_024L, 256L), 1.0E-9D);
        assertEquals(0.0D, NetworkMath.availableQ(100L, 100L, 1_024L, 0L), 1.0E-9D);
        assertEquals(0.0D, NetworkMath.availableQ(99L, 200L, 1_024L, 512L), 1.0E-9D);
        assertEquals(0.5D, NetworkMath.availableQ(100L, 200L, 512L, 1_024L), 1.0E-9D);
        assertEquals(1.0D, NetworkMath.availableQ(200L, 200L, 1_024L, 512L), 1.0E-9D);
    }

    @Test
    void scalesRpmContinuouslyWithoutASixtyPercentCutoff() {
        assertEquals(0.001D, NetworkMath.rpmQ(1L, 1_000L), 1.0E-9D);
        assertEquals(0.599D, NetworkMath.rpmQ(599L, 1_000L), 1.0E-9D);
        assertEquals(0.75D, NetworkMath.rpmQ(768L, 1_024L), 1.0E-9D);
        assertEquals(1.0D, NetworkMath.rpmQ(2_048L, 1_024L), 1.0E-9D);
        assertEquals(0.0D, NetworkMath.rpmQ(0L, 1_024L), 1.0E-9D);
        assertEquals(0.0D, NetworkMath.rpmQ(1_024L, 0L), 1.0E-9D);
    }

    @Test
    void combinesStockAndRpmFactorsWithoutBorrowingSu() {
        assertEquals(0.75D, NetworkMath.availableQ(150L, 200L, 768L, 1_024L), 1.0E-9D);
        assertEquals(0.0D, NetworkMath.availableQ(149L, 200L, 768L, 1_024L), 1.0E-9D);
        assertEquals(0.599D, NetworkMath.availableQ(120L, 200L, 599L, 1_000L), 1.0E-9D);
        assertEquals(0.0D, NetworkMath.availableQ(119L, 200L, 599L, 1_000L), 1.0E-9D);
    }
}
