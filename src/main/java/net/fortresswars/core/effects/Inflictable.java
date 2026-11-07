package net.fortresswars.core.effects;

import org.bukkit.entity.LivingEntity;

import java.util.Collection;

public interface Inflictable {

    /**
     * Gets the living entity of this inflictable.
     * @return the living entity
     */
    LivingEntity getLivingEntity();

    /**
     * Add a status effect.
     * @param effect the status effect to add
     * @return true if the effect was added, false if it is not
     */
    boolean addStatusEffect(StatusEffect effect);

    /**
     * Remove a status effect
     * @param effect the status effect to add
     */
    void removeStatusEffect(StatusEffectType effect);

    /**
     * Get if this inflictable object has the specified status effect.
     * @param effect the effect to check
     * @return true if the entity has the effect, false if it doesn't
     */
    boolean hasStatusEffect(StatusEffectType effect);

    /**
     * Clear all status effects
     */
    void clearStatusEffects();

    /**
     * Get the status effect data object
     * @param effect the status effect to get
     * @return the data object of the status effect, null if the entity doesn't have the status effect.
     */
    StatusEffect getStatusEffect(StatusEffectType effect);

    /**
     * Get the status effect task object
     * @param effect the status effect to get
     * @return the task object of the status effect, null if the entity doesn't have the status effect.
     */
    StatusEffectTask getStatusEffectTask(StatusEffectType effect);

    /**
     * Get all status effect data object
     * @return the collection of status effects
     */
    Collection<StatusEffect> getStatusEffects();
}

