package net.fortresswars.events.kits;


import net.fortresswars.core.entities.FortressWarsPlayer;
import net.fortresswars.events.FortressWarsEvent;

public class FWManaChangeEvent extends FortressWarsEvent {

    private final FortressWarsPlayer fwp;
    private final double from;
    private final double to;

    public FWManaChangeEvent(FortressWarsPlayer fwp, double from, double to) {
        this.fwp = fwp;
        this.from = from;
        this.to = to;
    }

    public FortressWarsPlayer getPlayer() {
        return fwp;
    }

    public double getFrom() {
        return from;
    }

    public double getTo() {
        return to;
    }
}
