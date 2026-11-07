package net.fortresswars.events.parkour;

import org.bukkit.entity.Player;

public class ParkourEndEvent extends ParkourEvent {

    private final ParkourEndReason reason;

    public enum ParkourEndReason {
        TIMER_EXPIRED,
        MANUAL,
        LOGOUT,
        GAME_START,
        COMPLETED,
        PARKOUR_DISABLED
    }

    public ParkourEndEvent(Player player, String courseID, ParkourEndReason reason) {
        super(player, courseID);
        this.reason = reason;
    }

    public ParkourEndReason getReason() {
        return reason;
    }
}
