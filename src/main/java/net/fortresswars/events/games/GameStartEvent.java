package net.fortresswars.events.games;

import net.fortresswars.core.games.Game;

public class GameStartEvent extends GameEvent {

    public GameStartEvent(Game game) {
        super(game);
    }
}
