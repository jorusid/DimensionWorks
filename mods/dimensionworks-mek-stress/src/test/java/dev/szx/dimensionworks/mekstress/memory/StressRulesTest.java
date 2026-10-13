package dev.szx.dimensionworks.mekstress.memory;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class StressRulesTest {
    @Test
    void chargepadCanReceiveMechanicalPower() {
        assertTrue(StressRules.isEligibleClass("mekanism.common.tile.TileEntityChargepad"));
    }

    @Test
    void keepsRetiredEnergyInfrastructureIneligible() {
        assertTrue(StressRules.isEligibleClass("mekanism.common.tile.machine.TileEntityEnrichmentChamber"));
        assertFalse(StressRules.isEligibleClass("mekanism.common.tile.TileEntityEnergyCube"));
        assertFalse(StressRules.isEligibleClass("mekanism.common.tile.transmitter.TileEntityUniversalCable"));
        assertFalse(StressRules.isEligibleClass("mekanismgenerators.common.tile.TileEntityGenerator"));
        assertFalse(StressRules.isEligibleClass(null));
    }
}
