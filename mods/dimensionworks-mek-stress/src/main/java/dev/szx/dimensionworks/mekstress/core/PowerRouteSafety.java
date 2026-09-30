package dev.szx.dimensionworks.mekstress.core;

/** Pure safety gates for cached Create kinetic routes. */
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

    public static boolean canRefreshStress(boolean sourcePresent, boolean removed, boolean clientSide,
                                           boolean networkPresent) {
        return sourcePresent && !removed && !clientSide && networkPresent;
    }

    public static boolean sameNetwork(Object sourceNetwork, Object gearboxNetwork) {
        return sourceNetwork != null && sourceNetwork == gearboxNetwork;
    }
}
