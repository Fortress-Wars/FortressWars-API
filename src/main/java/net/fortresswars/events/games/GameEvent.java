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
        final var map = game.getMap();
        final var mapDisplayData = map.getMapDisplayData();
        return mapDisplayData.id();
    }

    public String getMapName() {
        final var map = game.getMap();
        final var mapDisplayData = map.getMapDisplayData();
        return mapDisplayData.displayName();
    }

    public String getGameruleName() {
        return game.getGamerule().getName();
    }
}
