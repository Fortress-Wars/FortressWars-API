package net.fortresswars.events.games;

import net.fortresswars.core.games.states.FWGameState;
import net.fortresswars.events.FortressWarsEvent;

import javax.annotation.Nullable;

public class GameStateChangeEvent extends FortressWarsEvent {

    private final FWGameState gameStateID;

    public GameStateChangeEvent(@Nullable FWGameState gameStateID) {
        this.gameStateID = gameStateID;
    }

    public FWGameState getState() {
        return gameStateID;
    }
}
