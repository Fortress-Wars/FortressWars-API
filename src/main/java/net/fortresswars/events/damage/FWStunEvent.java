package net.fortresswars.events.damage;

import net.fortresswars.core.entities.FortressWarsEntity;
import net.fortresswars.core.entities.Stunnable;
import net.fortresswars.events.FortressWarsCancellableEvent;

public class FWStunEvent extends FortressWarsCancellableEvent {

    private final Stunnable stunnable;
    private final int duration;
    private final FortressWarsEntity stunner;

    public FWStunEvent(Stunnable stunnable, int duration, FortressWarsEntity stunner) {
        this.stunnable = stunnable;
        this.duration = duration;
        this.stunner = stunner;
    }

    public Stunnable getStunnable() {
        return stunnable;
    }

    public int getDuration() {
        return duration;
    }

    public FortressWarsEntity getStunner() {
        return stunner;
    }
}
