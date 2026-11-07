package net.fortresswars.events.games;

import net.fortresswars.core.games.Game;

public class GamePauseEvent extends GameEvent {
    public GamePauseEvent(Game game) {
        super(game);
    }
}
