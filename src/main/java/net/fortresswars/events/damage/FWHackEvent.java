package net.fortresswars.events.damage;

import net.fortresswars.core.entities.FortressWarsEntity;
import net.fortresswars.core.entities.Hackable;
import net.fortresswars.events.FortressWarsCancellableEvent;

public class FWHackEvent extends FortressWarsCancellableEvent {

    private final Hackable hackable;
    private final int duration;
    private final FortressWarsEntity hacker;

    public FWHackEvent(Hackable hackable, int duration, FortressWarsEntity hacker) {
        this.hackable = hackable;
        this.duration = duration;
        this.hacker = hacker;
    }

    public Hackable getHackable() {
        return hackable;
    }

    public int getDuration() {
        return duration;
    }

    public FortressWarsEntity getHacker() {
        return hacker;
    }
}
