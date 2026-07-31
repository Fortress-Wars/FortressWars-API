package net.fortresswars.events.gamerules;

import net.fortresswars.core.gamerules.Gamerule;
import net.fortresswars.events.FortressWarsEvent;

public class GameruleChangeEvent extends FortressWarsEvent {

    private final Gamerule oldGamerule;
    private final Gamerule newGamerule;

    public GameruleChangeEvent(Gamerule oldGamerule, Gamerule newGamerule) {
        this.oldGamerule = oldGamerule;
        this.newGamerule = newGamerule;
    }

    public Gamerule getOldGamerule() {
        return oldGamerule;
    }

    public Gamerule getNewGamerule() {
        return newGamerule;
    }
}
