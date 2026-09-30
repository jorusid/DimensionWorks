package dev.szx.dimensionworks.mekstress.core;

/** Pure math for ME network congestion and production scaling. */
public final class NetworkMath {
    private NetworkMath() {
    }

    public static double clampRatio(double ratio) {
        if (!Double.isFinite(ratio) || ratio <= 0.0D) {
            return 0.0D;
        }
        return Math.min(1.0D, ratio);
    }

    /** SU demanded at the RPM coverage actually available this tick. */
    public static long requiredSuForRpm(long demandSuPerTick, long bandwidthRpm, long demandRpm) {
        if (demandSuPerTick <= 0L || bandwidthRpm <= 0L || demandRpm <= 0L) {
            return 0L;
        }
        double scaled = (double) demandSuPerTick * rpmQ(bandwidthRpm, demandRpm);
        if (!Double.isFinite(scaled) || scaled <= 0.0D) {
            return 0L;
        }
        return scaled >= (double) Long.MAX_VALUE ? Long.MAX_VALUE : (long) Math.ceil(scaled);
    }

    /** Binary SU gate: the demand for this tick is either available or it is not. */
    public static double suGate(long storedSu, long requiredSu) {
        if (storedSu <= 0L || requiredSu <= 0L) {
            return 0.0D;
        }
        return storedSu >= requiredSu ? 1.0D : 0.0D;
    }

    /**
     * Normalized relation used by the calibration tests. The math treats the
     * two inputs as a capacity/load pair and reports the smaller side as the
     * utilization ratio.
     */
    public static double bandwidthRatio(long a, long b) {
        if (a <= 0L || b <= 0L) {
            return 0.0D;
        }
        return clampRatio((double) Math.min(a, b) / (double) Math.max(a, b));
    }

    /** Actual q_bw: min(1, bandwidth / demand). */
    public static double bandwidthQ(long bandwidthRpm, long demandRpm) {
        return rpmQ(bandwidthRpm, demandRpm);
    }

    public static double rpmQ(long bandwidthRpm, long demandRpm) {
        if (bandwidthRpm <= 0L || demandRpm <= 0L) {
            return 0.0D;
        }
        return clampRatio((double) bandwidthRpm / (double) demandRpm);
    }

    public static double finalQ(double stockQ, double bandwidthQ) {
        return Math.min(clampRatio(stockQ), clampRatio(bandwidthQ));
    }

    /** Mechanical power is available only when both SU stock and RPM bandwidth exist. */
    public static double availableQ(long storedSu, long demandSuPerTick, long bandwidthRpm, long demandRpm) {
        double rpmQ = rpmQ(bandwidthRpm, demandRpm);
        long requiredSu = requiredSuForRpm(demandSuPerTick, bandwidthRpm, demandRpm);
        return finalQ(suGate(storedSu, requiredSu), rpmQ);
    }

    public static double efficiency(double q, double exponent) {
        return Math.pow(clampRatio(q), exponent);
    }

    public static double productionRate(double effectiveRpmRatio, double q, double exponent) {
        double rpmRatio = Math.max(0.0D, Math.min(1.0D, effectiveRpmRatio));
        return rpmRatio * Math.pow(clampRatio(q), exponent + 1.0D);
    }

    public static long actualRpm(long effectiveRpm, double q) {
        return Math.round(Math.max(0L, effectiveRpm) * clampRatio(q));
    }
}
