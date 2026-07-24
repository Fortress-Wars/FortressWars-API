package net.fortresswars.events.damage;

import net.fortresswars.core.entities.FortressWarsEntity;
import net.fortresswars.events.FortressWarsCancellableEvent;
import org.bukkit.entity.Projectile;
import org.bukkit.event.entity.ProjectileHitEvent;

public class FWProjectileHitEvent extends FortressWarsCancellableEvent {

    private final ProjectileHitEvent projectileHitEvent;
    private final FortressWarsEntity shooter;
    private final FortressWarsEntity hitEntity;

    public FWProjectileHitEvent(ProjectileHitEvent projectileHitEvent, FortressWarsEntity shooter, FortressWarsEntity hitEntity) {
        this.projectileHitEvent = projectileHitEvent;
        this.shooter = shooter;
        this.hitEntity = hitEntity;
    }

    public ProjectileHitEvent getProjectileHitEvent() {
        return projectileHitEvent;
    }

    public FortressWarsEntity getShooter() {
        return shooter;
    }

    public FortressWarsEntity getHitEntity() {
        return hitEntity;
    }

    public Projectile getProjectile() {
        return projectileHitEvent.getEntity();
    }
}
