package net.fortresswars.events.effects;

import net.fortresswars.core.effects.Inflictable;
import net.fortresswars.core.effects.StatusEffect;

public class StatusEffectInflictedEvent extends StatusEffectEvent {

    public StatusEffectInflictedEvent(Inflictable inflictable, StatusEffect statusEffect, boolean isReapplication) {
        super(inflictable, statusEffect, isReapplication);
    }
}
