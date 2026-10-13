package dev.szx.dimensionworks.mekstress.core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class MachineWorkContextTest {
    @Test
    void scalesOutputsAndRestoresNestedContexts() {
        assertFalse(MachineWorkContext.scaling());
        try (MachineWorkContext.Scope outer = MachineWorkContext.push(1.5D)) {
            assertTrue(MachineWorkContext.scaling());
            assertEquals(3L, MachineWorkContext.scaleOutput(1L, 2));
            try (MachineWorkContext.Scope inner = MachineWorkContext.push(2.0D)) {
                assertEquals(4L, MachineWorkContext.scaleOutput(1L, 2));
            }
            assertEquals(3L, MachineWorkContext.scaleOutput(1L, 2));
        }
        assertFalse(MachineWorkContext.scaling());
    }

    @Test
    void neverReducesOrPoisonsOutputWhenPowerIsInsufficient() {
        try (MachineWorkContext.Scope ignored = MachineWorkContext.push(Double.NaN)) {
            assertFalse(MachineWorkContext.scaling());
            assertEquals(2L, MachineWorkContext.scaleOutput(1L, 2));
        }
    }
}
