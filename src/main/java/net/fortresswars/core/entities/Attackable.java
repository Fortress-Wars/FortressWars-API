package net.fortresswars.core.entities;

import net.fortresswars.core.damage.FWDamageCause;
import net.fortresswars.events.damage.FWDamageByEntityEvent;
import net.fortresswars.events.damage.FWDamageEvent;

public interface Attackable {

    /**
     * Damage this fortress wars entity
     * @param source source fighter
     * @param damageCause damage cause of this damage instance
     * @param amount amount of damage to deal
     * @return the final damage that was dealt
     */
    double damage(FortressWarsEntity source, FWDamageCause damageCause, double amount);

    /**
     * Damage the fortress wars entity with the provided damage event.
     *  Useful if you want to use subclasses for the FWDamageByEntityEvent
     * @return the final damage that was dealt
     */
    double damage(FWDamageByEntityEvent damageEvent);

    FWDamageEvent getLastDamageEvent();

    FortressWarsEntity getLastDamager();

    FWDamageCause getLastDamageCause();

    void setLastDamageEvent(FWDamageEvent lastDamageEvent);

    boolean isDead();

    void setIsDead(boolean isDead);

    boolean isBlocking();
}
