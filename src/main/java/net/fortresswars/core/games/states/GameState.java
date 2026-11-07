package net.fortresswars.core.games.states;

import net.fortresswars.core.entities.Pauseable;
import net.fortresswars.core.managers.Enableable;
import org.bukkit.event.Listener;

public interface GameState extends Enableable, Pauseable<Void>, Listener {
    /*
     * Returns the friendly name of the Game State
     */
    FWGameState getStateID();

    /**
     * Called when the gamerule is initializing.
     */
    void init();

    /*
     * Runs the logic needed for game tick in the state
     */
    void run();

    /**
     * Skip to the next game state.
     */
    void skip();
}
