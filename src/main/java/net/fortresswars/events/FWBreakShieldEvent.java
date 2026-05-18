package net.fortresswars.events;

import net.fortresswars.core.damage.FWDamageCause;
import net.fortresswars.core.entities.FortressWarsEntity;

public class FWBreakShieldEvent extends FortressWarsEvent {

    private final FortressWarsEntity entity;
    private final FortressWarsEntity disabler;
    private final FWDamageCause damageCause;

    private int duration;

    public FWBreakShieldEvent(FortressWarsEntity entity, FortressWarsEntity disabler, FWDamageCause damageCause, int duration) {
        this.entity = entity;
        this.disabler = disabler;
        this.damageCause = damageCause;
        this.duration = duration;
    }

    public FortressWarsEntity getEntity() {
        return entity;
    }

    public FortressWarsEntity getDisabler() {
        return disabler;
    }

    public FWDamageCause getDamageCause() {
        return damageCause;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
