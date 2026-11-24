package net.fortresswars.events.damage;

import net.fortresswars.core.entities.FortressWarsEntity;
import net.fortresswars.core.entities.FortressWarsMinion;

import javax.annotation.Nullable;

public class FWMinionDeathEvent extends FWDeathEvent {

    public enum Reason {
        DIED,
        EXPIRED,
        DISABLED,
        TOO_MANY,
        ERRORED
    }

    private final FortressWarsMinion fwm;
    private final Reason reason;

    public FWMinionDeathEvent(FortressWarsMinion fwm, @Nullable FortressWarsEntity killer, Reason reason) {
        super(fwm, killer);
        this.fwm = fwm;
        this.reason = reason;
    }

    public FortressWarsMinion getMob() {
        return fwm;
    }

    public Reason getReason() {
        return reason;
    }
}
