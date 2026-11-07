package net.fortresswars.events.entities;

import net.fortresswars.core.entities.FortressWarsPlayer;
import org.jetbrains.annotations.NotNull;

public class FWPlayerJoinEvent extends FortressWarsPlayerEvent {

    public FWPlayerJoinEvent(@NotNull FortressWarsPlayer player) {
        super(player);
    }
}
