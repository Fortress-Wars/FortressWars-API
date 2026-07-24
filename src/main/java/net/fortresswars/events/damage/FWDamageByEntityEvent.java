package net.fortresswars.events.damage;

import net.fortresswars.core.damage.FWDamageCause;
import net.fortresswars.core.entities.FortressWarsEntity;
import net.fortresswars.core.entities.FortressWarsMinion;
import net.fortresswars.core.entities.FortressWarsPlayer;
import org.bukkit.event.entity.EntityDamageEvent;
import org.jetbrains.annotations.Nullable;

public class FWDamageByEntityEvent extends FWDamageEvent {

    private final FortressWarsEntity source;

    /**
     * Called when a FortressWarsEntity takes damage.
     * @param entity entity being damaged
     * @param source entity damaging
     * @param damageCause type of damage
     * @param damageThatHitShield damage that hit the shield (from spigot DamageModifier)
     * @param damage amount of damage
     */
    public FWDamageByEntityEvent(
            FortressWarsEntity entity,
            FortressWarsEntity source,
            FWDamageCause damageCause,
            EntityDamageEvent.DamageCause minecraftCause,
            double damageThatHitShield,
            double damage
    ) {
        super(entity, damageCause, minecraftCause, damageThatHitShield, damage);
        this.source = source;
    }

    public FortressWarsEntity getSource() {
        return source;
    }

    public FortressWarsPlayer getPlayerSource() {
        return getPlayerSource(source);
    }

    public static @Nullable FortressWarsPlayer getPlayerSource(FortressWarsEntity source) {
        if (source instanceof FortressWarsPlayer playerSource) return playerSource;
        if (source instanceof FortressWarsMinion minionSource) return minionSource.getOwner();
        return null;
    }
}
