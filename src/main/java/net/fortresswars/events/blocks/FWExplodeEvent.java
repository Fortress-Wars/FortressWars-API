package net.fortresswars.events.blocks;

import net.fortresswars.core.damage.FWDamageCause;
import net.fortresswars.core.entities.FortressWarsEntity;
import net.fortresswars.events.FortressWarsCancellableEvent;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;

import java.util.Set;

public class FWExplodeEvent extends FortressWarsCancellableEvent {

    private final Entity entity;
    private final FortressWarsEntity source;
    private final FWDamageCause damageType;
    private final double radius;
    private final Set<Block> blockSet;

    public FWExplodeEvent(Entity entity, FortressWarsEntity source, FWDamageCause damageType, double radius, Set<Block> blockSet) {
        this.entity = entity;
        this.source = source;
        this.damageType = damageType;
        this.radius = radius;
        this.blockSet = blockSet;
    }

    /**
     * Get the entity that exploded
     * @return Entity reference
     */
    public Entity getEntity() {
        return entity;
    }

    public Set<Block> blockSet() {
        return blockSet;
    }

    /**
     * Get the location of the explosion
     * @return Location
     */
    public Location getLocation() {
        return entity.getLocation();
    }

    /**
     * Get the source entity for this exploding event
     * @return FortressWarsEntity reference
     */
    public FortressWarsEntity getSource() {
        return source;
    }

    /**
     * Get the damage type of the explosion
     * @return FWDamageCause reference
     */
    public FWDamageCause getDamageCause() {
        return damageType;
    }

    /**
     * Get the radius of the explosion
     * @return double
     */
    public double getRadius() {
        return radius;
    }
}
