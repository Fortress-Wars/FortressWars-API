package net.fortresswars.events.kits.engineer;

import net.fortresswars.core.entities.FortressWarsPlayer;
import net.fortresswars.events.entities.FortressWarsPlayerEvent;

public class EngineerShowMetalEvent extends FortressWarsPlayerEvent {

    public EngineerShowMetalEvent(FortressWarsPlayer player) {
        super(player);
    }
}
