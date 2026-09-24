package net.fortresswars.events.killstreaks;

import net.fortresswars.core.entities.FortressWarsPlayer;
import net.fortresswars.events.entities.FortressWarsPlayerEvent;

public class KillstreakEvent extends FortressWarsPlayerEvent {

    public KillstreakEvent(FortressWarsPlayer player) {
        super(player);
    }
}
