package net.fortresswars.core.entities;

import net.fortresswars.events.damage.FWMinionDeathEvent;
import org.bukkit.entity.Mob;
import org.jetbrains.annotations.Nullable;

public interface FortressWarsMinion extends FortressWarsLivingEntity, Memorious {

    void delete(FWMinionDeathEvent.Reason reason);

    /**
     * Get the owner of the minion
     * @return the fortress wars player
     */
    FortressWarsPlayer getOwner();

    /**
     * Get the underlying mob
     * @return the mob
     */
    Mob getMob();

    /**
     * Does this minion have a target
     * @return true if it has a target, false if it does not.
     */
    boolean hasTarget();

    /**
     * Get the target
     * @return the FortressWarsEntity target
     */
    @Nullable FortressWarsLivingEntity getTarget();

    /**
     * Set the target.
     * @param newTarget the new target. This can be null to unset the target.
     */
    void setTarget(@Nullable FortressWarsLivingEntity newTarget);
}
