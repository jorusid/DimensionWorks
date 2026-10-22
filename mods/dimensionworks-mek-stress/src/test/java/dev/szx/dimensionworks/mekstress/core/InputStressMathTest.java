package dev.szx.dimensionworks.mekstress.core;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class InputStressMathTest {

    @Test
    void capsTheNetworkWideReductionAtOneHundredPercent() {
        assertEquals(10_000, InputStressMath.cappedReductionBasisPoints(10_000));
        assertEquals(10_000, InputStressMath.cappedReductionBasisPoints(12_000));
        assertEquals(0, InputStressMath.cappedReductionBasisPoints(-50));
    }

    @Test
    void defectiveCardsCanReduceAllInputStress() {
        InputStressMath.Conversion conversion =
            InputStressMath.convert(Long.MAX_VALUE, 10_000, 0L);
        assertEquals(0L, conversion.effectiveSu());
        assertEquals(0L, conversion.remainderNumerator());
    }

    @Test
    void splitInputTransfersMatchTheAggregateDiscount() {
        InputStressMath.Conversion first = InputStressMath.convert(25L, 150, 0L);
        InputStressMath.Conversion second = InputStressMath.convert(25L, 150, first.remainderNumerator());
        InputStressMath.Conversion third = InputStressMath.convert(25L, 150, second.remainderNumerator());
        InputStressMath.Conversion fourth = InputStressMath.convert(25L, 150, third.remainderNumerator());

        assertEquals(98L, first.effectiveSu() + second.effectiveSu()
            + third.effectiveSu() + fourth.effectiveSu());
        assertEquals(5_000L, fourth.remainderNumerator());
    }

    @Test
    void conversionDoesNotOverflowForMaximumSu() {
        InputStressMath.Conversion conversion =
            InputStressMath.convert(Long.MAX_VALUE, 0, 0L);
        assertEquals(Long.MAX_VALUE, conversion.effectiveSu());
        assertEquals(0L, conversion.remainderNumerator());
    }
}
