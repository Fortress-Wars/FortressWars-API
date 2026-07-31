package net.fortresswars.core.games.states;

import net.fortresswars.core.entities.Pauseable;
import net.fortresswars.core.managers.Enableable;

import java.awt.*;

public interface GameState extends Enableable, Pauseable<Void> {
    /*
     * Returns the friendly name of the Game State
     */
    FWGameState getStateID();

    /**
     * Skip to the next game state.
     */
    void skip();

    /*
     * Runs the logic needed for game tick in the state
     */
    void run();

    /*
     * The component that should be displayed over the boss bar overlay
     */
    Component getOverlayDisplayComponent();
}
