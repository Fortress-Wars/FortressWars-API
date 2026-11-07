package net.fortresswars.events.entities;

import net.fortresswars.core.entities.FortressWarsPlayer;
import org.jetbrains.annotations.NotNull;

public abstract class FortressWarsPlayerEvent extends FortressWarsEntityEvent {

    private final @NotNull FortressWarsPlayer player;

    protected FortressWarsPlayerEvent(@NotNull FortressWarsPlayer player) {
        super(player);
        this.player = player;
    }

    public @NotNull FortressWarsPlayer getPlayer() {
        return player;
    }
}
