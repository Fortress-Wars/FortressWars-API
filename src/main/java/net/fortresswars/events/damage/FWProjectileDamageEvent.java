package net.fortresswars.events.damage;

import net.fortresswars.core.damage.FWDamageCause;
import net.fortresswars.core.entities.FortressWarsEntity;
import org.bukkit.entity.Projectile;
import org.bukkit.event.entity.EntityDamageEvent;

public class FWProjectileDamageEvent extends FWDamageByEntityEvent {

    private final Projectile projectile;

    public FWProjectileDamageEvent(
            FortressWarsEntity entity,
            FortressWarsEntity source,
            FWDamageCause damageCause,
            EntityDamageEvent.DamageCause minecraftCause,
            double damage,
            double damageThatHitShield,
            Projectile projectile
    ) {
        super(entity, source, damageCause, minecraftCause, damageThatHitShield, damage);
        this.projectile = projectile;
    }

    /**
     * Returns the projectile that caused the damage
     * @return Projectile reference
     */
    public Projectile getProjectile() {
        return projectile;
    }
}
