package net.fortresswars.data;

import org.jetbrains.annotations.Nullable;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;

public class PersistentDataProperty {

    private Object value;

    public PersistentDataProperty(Object value) {
        this.value = value;
    }

    public void set(Object value) {
        this.value = value;
    }

    /**
     * Is the value empty
     * @return true if the value is null (empty)
     */
    public boolean isEmpty() {
        return value == null;
    }

    /**
     * Cast as a string
     * @return value - string
     */
    public @Nullable String asString() {
        if (value instanceof String stringValue) {
            return stringValue;
        }
        return null;
    }

    /**
     * Cast as a uuid
     * @return value - uuid
     */
    public @Nullable UUID asUUID() {
        try {
            return UUID.fromString(Objects.requireNonNull(asString()));
        } catch (IllegalArgumentException | NullPointerException e) {
            return null;
        }
    }

    /**
     * Cast as an int
     * @return value as an integer
     */
    public int asInt() {
        if (value instanceof Number number) {
            return number.intValue();
        }
        return 0;
    }

    /**
     * Cast as a double
     * @return value - double
     */
    public double asDouble() {
        if (value instanceof Number number) {
            return number.doubleValue();
        }
        return 0;
    }

    /**
     * Cast as a long
     * @return value - long
     */
    public long asLong() {
        if (value instanceof Number number) {
            return number.longValue();
        }
        return 0;
    }

    /**
     * Cast as a float
     * @return value as a float
     */
    public float asFloat() {
        if (value instanceof Number number) {
            return number.floatValue();
        }
        return 0;
    }

    /**
     * Cast as a boolean
     * @return true if value is greater than 0, false otherwise
     */
    public boolean asBoolean() {
        if (value instanceof Boolean booleanValue) {
            return booleanValue;
        }
        return false;
    }

    /**
     * Cast as a potion level
     * @return value as an integer -1
     */
    public int asPotionLevel() {
        return Math.max(0, asInt() - 1);
    }

    /**
     * Cast as melee damage
     * @return value as an integer -1
     */
    public double asMeleeDamage() {
        return Math.max(0, asDouble() - 1);
    }
    /**
     * Cast as a percentage
     * @return value of the percentage converted to a double (i.e. 80 -> 0.8)
     */
    public double asPercentage() {
        return asDouble() / 100;
    }

    /**
     * Cast as a milliseconds (from ticks)
     * @return value of the milliseconds
     */
    public int asMilliseconds() {
        return asInt() * 50;
    }

    /**
     * Cast as a seconds (from ticks)
     * @return value of the seconds
     */
    public double asSeconds() {
        return asDouble() * 0.05;
    }

    /**
     * Cast as a date.
     * @return value of the date
     */
    public Date asDate() {
        return new Date(asLong());
    }

}
