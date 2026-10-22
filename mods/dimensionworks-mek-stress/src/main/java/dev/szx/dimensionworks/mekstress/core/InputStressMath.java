package dev.szx.dimensionworks.mekstress.core;

/** Exact integer math for memory-card input-stress reduction. */
public final class InputStressMath {
    public static final int BASIS_POINTS_PER_WHOLE = 10_000;
    private static final long MAX_REMAINDER = BASIS_POINTS_PER_WHOLE - 1L;

    private InputStressMath() {
    }

    /** Sums are capped at 100% so effective input stress can never become negative. */
    public static int cappedReductionBasisPoints(long totalBasisPoints) {
        return (int) Math.max(0L, Math.min(BASIS_POINTS_PER_WHOLE, totalBasisPoints));
    }

    /**
     * Converts raw input SU after reduction while carrying fractional SU between calls.
     * This makes split transfers equivalent to applying the discount to their aggregate,
     * without floating-point drift or per-gearbox rounding bias.
     */
    public static Conversion convert(long inputSu, int reductionBasisPoints, long remainderNumerator) {
        if (inputSu <= 0L) {
            return new Conversion(0L, clampRemainder(remainderNumerator));
        }

        long previousRemainder = clampRemainder(remainderNumerator);
        long retainedBasisPoints = BASIS_POINTS_PER_WHOLE
            - cappedReductionBasisPoints(reductionBasisPoints);
        long wholeInput = inputSu / BASIS_POINTS_PER_WHOLE;
        long fractionalInput = inputSu % BASIS_POINTS_PER_WHOLE;
        long fractionalNumerator = fractionalInput * retainedBasisPoints + previousRemainder;

        long effectiveSu = wholeInput * retainedBasisPoints
            + fractionalNumerator / BASIS_POINTS_PER_WHOLE;
        long nextRemainder = fractionalNumerator % BASIS_POINTS_PER_WHOLE;
        return new Conversion(effectiveSu, nextRemainder);
    }

    private static long clampRemainder(long remainderNumerator) {
        return Math.max(0L, Math.min(MAX_REMAINDER, remainderNumerator));
    }

    public record Conversion(long effectiveSu, long remainderNumerator) {
    }
}
