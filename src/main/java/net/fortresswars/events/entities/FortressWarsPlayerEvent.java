package net.fortresswars.events.entities;

import net.fortresswars.core.entities.FortressWarsPlayer;
import net.fortresswars.events.FortressWarsEvent;
import org.jetbrains.annotations.NotNull;

public abstract class FortressWarsPlayerEvent extends FortressWarsEvent {

    private final @NotNull FortressWarsPlayer player;

    protected FortressWarsPlayerEvent(@NotNull FortressWarsPlayer player) {
        this.player = player;
    }

    public @NotNull FortressWarsPlayer getPlayer() {
        return player;
    }
}
