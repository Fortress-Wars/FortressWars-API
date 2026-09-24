package net.fortresswars.events.killstreaks;

import net.fortresswars.core.entities.FortressWarsPlayer;

public class KillstreakIncreaseEvent extends KillstreakEvent {

    private final int from;
    private final int to;

    public KillstreakIncreaseEvent(FortressWarsPlayer player, int from, int to) {
        super(player);
        this.from = from;
        this.to = to;
    }

    /**
     * Get the old killstreak value
     * @return the old killstreak value
     */
    public int getFrom() {
        return from;
    }

    /**
     * Get the new killstreak value
     * @return the new killstreak value
     */
    public int getTo() {
        return to;
    }
}
