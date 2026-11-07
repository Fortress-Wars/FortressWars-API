package net.fortresswars.events.games;

import net.fortresswars.core.games.Game;
import net.fortresswars.events.FortressWarsEvent;

public class GameEvent extends FortressWarsEvent {

    private final Game game;

    public GameEvent(Game game) {
        this.game = game;
    }

    public Game getGame() {
        return game;
    }

    public String getMapID() {
        return game.getMapDisplayData().id();
    }

    public String getMapName() {
        return game.getMapDisplayData().displayName();
    }

    public String getGameruleName() {
        return game.getGamerule().getName();
    }
}
