package net.fortresswars.events.games;

import net.fortresswars.core.entities.FortressWarsPlayer;
import net.fortresswars.core.games.Game;

public class GameRemovedPlayerEvent extends GameEvent {

    private final FortressWarsPlayer player;

    public GameRemovedPlayerEvent(Game game, FortressWarsPlayer player) {
        super(game);
        this.player = player;
    }

    public FortressWarsPlayer getPlayer() {
        return player;
    }
}
