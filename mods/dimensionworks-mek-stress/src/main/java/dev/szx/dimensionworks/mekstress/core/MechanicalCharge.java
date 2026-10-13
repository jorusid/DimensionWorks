package dev.szx.dimensionworks.mekstress.core;

import java.util.Objects;
import mekanism.api.math.FloatingLong;

/** Per-tick internal energy supplied by a valid Create mechanical route. */
public final class MechanicalCharge {
    /** 20,000 kJ expressed in Mekanism's Joules. */
    public static final long RECHARGE_JOULES_PER_TICK = 20_000_000L;

    private MechanicalCharge() {
    }

    public static FloatingLong rechargeOneTick(FloatingLong stored, FloatingLong capacity) {
        Objects.requireNonNull(stored, "stored");
        Objects.requireNonNull(capacity, "capacity");
        return stored.add(RECHARGE_JOULES_PER_TICK).min(capacity);
    }
}
