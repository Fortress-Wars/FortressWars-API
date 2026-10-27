package net.fortresswars.events.projectiles;

import net.fortresswars.core.damage.FWDamageCause;
import net.fortresswars.core.entities.FortressWarsEntity;
import net.fortresswars.events.FortressWarsCancellableEvent;
import org.bukkit.block.Block;

public class FWCustomProjectileHitEvent extends FortressWarsCancellableEvent {

    private final FortressWarsEntity shooter;
    private final FortressWarsEntity entity;
    private final Block block;
    private final double damage;
    private final FWDamageCause damageCause;

    public FWCustomProjectileHitEvent(FortressWarsEntity shooter, Block block, double damage, FWDamageCause damageCause) {
        this.shooter = shooter;
        this.block = block;
        this.damage = damage;
        this.damageCause = damageCause;
        this.entity = null;
    }

    public FWCustomProjectileHitEvent(FortressWarsEntity shooter, FortressWarsEntity entity, double damage, FWDamageCause damageCause) {
        this.shooter = shooter;
        this.entity = entity;
        this.damage = damage;
        this.damageCause = damageCause;
        this.block = null;
    }

    /**
     * Gets the shooter of the shot
     *
     * @return FortressWarsEntity shooter
     */
    public FortressWarsEntity getShooter() {
        return shooter;
    }

    /**
     * Gets the entity that was hit
     *
     * @return FortressWarsEntity entity
     */
    public FortressWarsEntity getEntity() {
        return entity;
    }

    /**
     * Gets the block that was hit
     *
     * @return Block block
     */
    public Block getBlock() {
        return block;
    }

    /**
     * Gets the base damage shot the bullet
     *
     * @return double damage
     */
    public double getDamage() {
        return damage;
    }

    /**
     * Gets the damae cause of the bullet damage instance
     *
     * @return FWDamageCause damageCause
     */
    public FWDamageCause getDamageCause() {
        return damageCause;
    }
}
