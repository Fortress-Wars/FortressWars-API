package net.fortresswars.events.damage;

import net.fortresswars.core.damage.FWDamageCause;
import net.fortresswars.core.entities.FortressWarsEntity;
import org.bukkit.entity.Entity;
import org.bukkit.event.entity.EntityDamageEvent;

public class FWExplodeDamageEvent extends FWDamageByEntityEvent {

    private final Entity exploder;
    private final boolean isInLOS;

    public FWExplodeDamageEvent(FortressWarsEntity entity, FortressWarsEntity source, FWDamageCause damageCause, EntityDamageEvent.DamageCause minecraftCause, double damageThatHitShield, double damage, Entity exploder, boolean isInLOS) {
        super(entity, source, damageCause, minecraftCause, damageThatHitShield, damage);
        this.exploder = exploder;
        this.isInLOS = isInLOS;
    }

    /**
     * Returns the entity that caused the damage
     * @return Entity reference
     */
    public Entity getExploder() {
        return exploder;
    }

    /**
     * Returns if the entity was in LOS
     * @return true if the entity is in LOS, false if they are not
     */
    public boolean isInLOS() {
        return isInLOS;
    }
}
