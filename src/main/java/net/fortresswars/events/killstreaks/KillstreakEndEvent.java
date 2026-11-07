package net.fortresswars.events.killstreaks;

import net.fortresswars.core.entities.FortressWarsPlayer;

public class KillstreakEndEvent extends KillstreakStartEvent {

    public enum Reason {
        SUICIDE,
        DEATH,
        LOGOUT,
        ELIMINATION
    }

    private final Reason reason;

    public KillstreakEndEvent(FortressWarsPlayer player, Reason reason) {
        super(player);
        this.reason = reason;
    }

    /**
     * Get the reason why the kill streak ended
     * @return the reason
     */
    public Reason getReason() {
        return reason;
    }
}
