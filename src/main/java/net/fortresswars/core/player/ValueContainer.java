package net.fortresswars.core.player;

public class ValueContainer {

    final String value;

    public static ValueContainer create() {
        return new ValueContainer(null);
    }

    public static ValueContainer create(String value) {
        return new ValueContainer(value);
    }

    public static ValueContainer create(boolean value) {
        return new ValueContainer(Boolean.toString(value));
    }

    public static ValueContainer create(double value) {
        return new ValueContainer(Double.toString(value));
    }

    private ValueContainer(String value) {
        this.value = value;
    }

    public String getString() {
        return value;
    }

    public boolean getBoolean() {
        return Boolean.parseBoolean(value);
    }

    public double getDouble() {
        try {
            return Double.parseDouble(value);
        } catch (NumberFormatException | NullPointerException e) {
            return 0;
        }
    }
}
