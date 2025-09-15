package constants;

public enum FineConfig {
    FINE_PER_DAY(1.5),
    GRACE_PERIOD_DAYS(2);

    private final double value;

    FineConfig(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}
