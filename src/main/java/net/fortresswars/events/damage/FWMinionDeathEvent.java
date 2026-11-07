package net.fortresswars.events.damage;

import net.fortresswars.core.entities.FortressWarsEntity;
import net.fortresswars.core.entities.FortressWarsMinion;
import net.fortresswars.events.FortressWarsEvent;

public class FWMinionDeathEvent extends FortressWarsEvent {

    public enum Reason {
        DIED,
        EXPIRED,
        DISABLED,
        TOO_MANY,
        ERRORED
    }

    private final FortressWarsMinion fwm;
    private final FortressWarsEntity killer;
    private final Reason reason;

    public FWMinionDeathEvent(FortressWarsMinion fwm, FortressWarsEntity killer, Reason reason) {
        this.fwm = fwm;
        this.killer = killer;
        this.reason = reason;
    }

    public FortressWarsMinion getMob() {
        return fwm;
    }

    public FortressWarsEntity getKiller() {
        return killer;
    }

    public Reason getReason() {
        return reason;
    }
}
