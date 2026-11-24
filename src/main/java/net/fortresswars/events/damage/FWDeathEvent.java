package net.fortresswars.events.damage;

import net.fortresswars.core.damage.FWDamageCause;
import net.fortresswars.core.entities.FortressWarsEntity;
import net.fortresswars.events.FortressWarsEvent;

import javax.annotation.Nullable;

public class FWDeathEvent extends FortressWarsEvent {

    private final FortressWarsEntity entity;
    private final @Nullable FortressWarsEntity killer;
    private final FWDamageEvent lastDamageEvent;
    private final double distance;

    public FWDeathEvent(FortressWarsEntity entity, @Nullable FortressWarsEntity killer) {
        this(entity, killer, entity.getLastDamageEvent(), entity.distance(killer));
    }

    public FWDeathEvent(FortressWarsEntity entity, @Nullable FortressWarsEntity killer, FWDamageEvent lastDamageEvent) {
        this(entity, killer, lastDamageEvent, entity.distance(killer));
    }

    public FWDeathEvent(FortressWarsEntity entity, @Nullable FortressWarsEntity killer, FWDamageEvent lastDamageEvent, double distance) {
        this.entity = entity;
        this.killer = killer;
        this.lastDamageEvent = lastDamageEvent;
        this.distance = distance;
    }

    public FortressWarsEntity getEntity() {
        return entity;
    }

    public @Nullable FortressWarsEntity getKiller() {
        return killer;
    }

    public FWDamageCause getDamageCause() {
        if (lastDamageEvent == null) {
            return null;
        }
        return lastDamageEvent.getDamageCause();
    }

    public FWDamageEvent getDamageEvent() {
        return lastDamageEvent;
    }

    public double getDistanceFromKiller() {
        return distance;
    }

    public boolean isSuicide() {
        return this.entity == this.killer;
    }
}
