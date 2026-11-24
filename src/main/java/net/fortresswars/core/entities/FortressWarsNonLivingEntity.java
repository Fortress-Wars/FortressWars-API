package net.fortresswars.core.entities;

import net.fortresswars.events.damage.FWDamageEvent;
import net.fortresswars.events.damage.FWHealEvent;

public interface FortressWarsNonLivingEntity extends FortressWarsEntity {

    /**
     * Called when the entity is healed. This method is called before the heal is applied to the entity's health.
     * @param event the heal event
     */
    void onHeal(FWHealEvent event);

    /**
     * Called when the entity takes damage. This method is called before the damage is applied to the entity's health.
     * @param event the damage event
     */
    void onDamage(FWDamageEvent event);

    /**
     * Called when the entity dies. This method is called before the death is applied to the entity's health.
     * @param event the damage event that caused the death
     */
    void onDeath(FWDamageEvent event);
}
