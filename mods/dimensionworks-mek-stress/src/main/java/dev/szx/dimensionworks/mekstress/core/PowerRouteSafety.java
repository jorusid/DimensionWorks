package dev.szx.dimensionworks.mekstress.core;

/** Pure safety gates for live Create kinetic routes. */
public final class PowerRouteSafety {
    private PowerRouteSafety() {
    }

    public static boolean shouldAssignStress(boolean routePresent, boolean running, float rpm, boolean networkPresent) {
        return routePresent && networkPresent;
    }

    public static boolean hasMechanicalPower(boolean routePresent, boolean running, float rpm,
                                            boolean networkPresent, boolean overStressed) {
        return routePresent && running && rpm > 0.0F && networkPresent && !overStressed;
    }
}
