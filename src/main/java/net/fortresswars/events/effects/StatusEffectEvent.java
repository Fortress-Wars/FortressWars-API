package net.fortresswars.events.effects;

import net.fortresswars.core.effects.Inflictable;
import net.fortresswars.core.effects.StatusEffect;
import net.fortresswars.events.FortressWarsCancellableEvent;

public class StatusEffectEvent extends FortressWarsCancellableEvent {

    private final Inflictable inflictable;
    private final StatusEffect statusEffect;
    private final boolean isReapplication;

    public StatusEffectEvent(Inflictable inflictable, StatusEffect statusEffect, boolean isReapplication) {
        this.inflictable = inflictable;
        this.statusEffect = statusEffect;
        this.isReapplication = isReapplication;
    }

    public StatusEffect getStatusEffect() {
        return statusEffect;
    }

    public Inflictable getInflictable() {
        return inflictable;
    }

    public boolean isReapplication() {
        return isReapplication;
    }
}
