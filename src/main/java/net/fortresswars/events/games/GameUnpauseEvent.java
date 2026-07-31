package net.fortresswars.events.games;

import net.fortresswars.core.games.Game;

public class GameUnpauseEvent extends GameEvent {
    public GameUnpauseEvent(Game game) {
        super(game);
    }
}
