package net.fortresswars.core.entities;

import net.fortresswars.events.damage.FWMinionDeathEvent;
import org.bukkit.entity.Mob;
import org.jetbrains.annotations.Nullable;

public interface FortressWarsMinion extends FortressWarsLivingEntity, Memorious {

    void delete(FWMinionDeathEvent.Reason reason);

    FortressWarsPlayer getOwner();

    Mob getMob();

    boolean hasTarget();

    @Nullable FortressWarsLivingEntity getTarget();

    void setTarget(@Nullable FortressWarsLivingEntity newTarget);
}
