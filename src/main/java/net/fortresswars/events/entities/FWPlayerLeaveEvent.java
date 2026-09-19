package net.fortresswars.events.entities;

import net.fortresswars.core.entities.FortressWarsPlayer;
import org.jetbrains.annotations.NotNull;

public class FWPlayerLeaveEvent extends FortressWarsPlayerEvent {

    public FWPlayerLeaveEvent(@NotNull FortressWarsPlayer player) {
        super(player);
    }
}
