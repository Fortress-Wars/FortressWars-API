package net.fortresswars.events.damage;

import net.fortresswars.core.damage.FWDamageCause;
import net.fortresswars.core.entities.FortressWarsEntity;
import org.bukkit.entity.Entity;
import org.bukkit.event.entity.EntityDamageEvent;

public class FWMagicDamageEvent extends FWDamageByEntityEvent {

    private final Entity magicDamager;

    public FWMagicDamageEvent(
            FortressWarsEntity entity,
            FortressWarsEntity source,
            FWDamageCause damageCause,
            EntityDamageEvent.DamageCause minecraftCause,
            double damage,
            double damageThatHitShield,
            Entity magicDamager
    ) {
        super(entity, source, damageCause, minecraftCause, damageThatHitShield, damage);
        this.magicDamager = magicDamager;
    }

    /**
     * Return the entity that caused the magic damage
     * @return minecraft entity
     */
    public Entity getMagicDamager() {
        return magicDamager;
    }
}
