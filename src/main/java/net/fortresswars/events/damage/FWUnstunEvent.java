package net.fortresswars.events.damage;

import net.fortresswars.core.entities.Stunnable;
import net.fortresswars.events.FortressWarsEvent;

public class FWUnstunEvent extends FortressWarsEvent {

    private final Stunnable stunnable;

    public FWUnstunEvent(Stunnable stunnable) {
        this.stunnable = stunnable;
    }

    public Stunnable getStunnable() {
        return stunnable;
    }
}
