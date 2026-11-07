package net.fortresswars.core.effects;

import net.fortresswars.util.Options;
import org.jetbrains.annotations.NotNull;

public class StatusEffect {

    public static final String DELAY = "DELAY";
    public static final String APPLICATOR = "APPLICATOR";

    private final StatusEffectType type;
    private final int duration;
    private final int amplifier;
    private final Options options;

    public static StatusEffect create(@NotNull StatusEffectType type, int duration, int amplifier, Options options) {
        return new StatusEffect(type, duration, amplifier, options);
    }

    private StatusEffect(StatusEffectType type, int duration, int amplifier, Options options) {
        this.type = type;
        this.duration =  Math.max(0, duration);
        this.amplifier = Math.max(0, amplifier);
        this.options = options;
    }

    /**
     * Get the type of the status effect
     * @return StatusEffectType type
     */
    public StatusEffectType getType() {
        return type;
    }

    /**
     * Get the duration of the status effect
     * @return int duration
     */
    public int getDuration() {
        return duration;
    }

    /**
     * Get the amplifier of the status effect
     * @return int amplifier
     */
    public int getAmplifier() {
        return amplifier;
    }

    /**
     * Get the options of the status effect
     * @return options
     */
    public Options getOptions() {
        return options;
    }

    /**
     * Returns if this status effect is stronger than the status effect
     * @param effect to check
     * @return true if the status effect has a higher amplifier
     */
    public boolean isStrongerThan(StatusEffect effect) {
        if (effect.getType() != this.type) return false;
        return this.amplifier > effect.amplifier;
    }

    /**
     * Checks the incoming object is equal to this
     * @param o other StatusEffect to compare
     * @return true if the type, duration, and amplifier are equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StatusEffect that = (StatusEffect) o;
        return that.getType() == type && that.getDuration() == duration && that.getAmplifier() == amplifier;
    }

    @Override
    public int hashCode() {
        final int hash = 31;
        int result = type.hashCode();
        result = hash * result + duration;
        result = hash * result + amplifier;
        return result;
    }

    @Override
    public String toString() {
        return type.name() + duration + "t-x" + amplifier;
    }
}
