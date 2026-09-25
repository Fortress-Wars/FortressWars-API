package net.fortresswars.events.games;

import net.fortresswars.core.entities.FortressWarsPlayer;
import net.fortresswars.core.games.Game;

public class GameAddedPlayerEvent extends GameEvent {

    private final FortressWarsPlayer player;

    public GameAddedPlayerEvent(Game game, FortressWarsPlayer player) {
        super(game);
        this.player = player;
    }

    public FortressWarsPlayer getPlayer() {
        return player;
    }
}

