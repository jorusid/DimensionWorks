package dev.szx.dimensionworks.mekstress.core;

/** The six orthogonal memory-card archetypes used by every DDR tier. */
public enum MemoryCardType {
    ECONOMY("economy", -1, -1, 200, true),
    BALANCED("balanced", 0, 0, 150, true),
    HIGH_SPEED("high_speed", -1, 1, 175, true),
    HIGH_STORAGE("high_storage", 1, -1, 75, true),
    DEFECTIVE("defective", -2, -2, 2_000, false),
    FINAL("final", 2, 2, 0, false);

    private final String id;
    private final int defaultStorageExponent;
    private final int defaultSpeedExponent;
    private final int inputReductionBasisPoints;
    private final boolean craftable;

    MemoryCardType(String id, int defaultStorageExponent, int defaultSpeedExponent,
                   int inputReductionBasisPoints, boolean craftable) {
        this.id = id;
        this.defaultStorageExponent = defaultStorageExponent;
        this.defaultSpeedExponent = defaultSpeedExponent;
        this.inputReductionBasisPoints = inputReductionBasisPoints;
        this.craftable = craftable;
    }

    public String id() {
        return id;
    }

    public int defaultStorageExponent() {
        return defaultStorageExponent;
    }

    public int defaultSpeedExponent() {
        return defaultSpeedExponent;
    }

    /** Input-stress reduction contributed by one card, in basis points (100 bp = 1%). */
    public int inputReductionBasisPoints() {
        return inputReductionBasisPoints;
    }

    public boolean craftable() {
        return craftable;
    }
}
