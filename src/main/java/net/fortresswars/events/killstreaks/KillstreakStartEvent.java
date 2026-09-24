package net.fortresswars.events.killstreaks;

import net.fortresswars.core.entities.FortressWarsPlayer;

public class KillstreakStartEvent extends KillstreakIncreaseEvent {

    public KillstreakStartEvent(FortressWarsPlayer player) {
        super(player, 0, 1);
    }
}
