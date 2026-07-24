package net.fortresswars.events.damage;

import net.fortresswars.core.entities.Hackable;
import net.fortresswars.events.FortressWarsEvent;

public class FWUnhackEvent extends FortressWarsEvent {

    private final Hackable hackable;

    public FWUnhackEvent(Hackable hackable) {
        this.hackable = hackable;
    }

    public Hackable getHackable() {
        return hackable;
    }
}
