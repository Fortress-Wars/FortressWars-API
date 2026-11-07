package net.fortresswars.events.parkour;

import org.bukkit.entity.Player;

public class ParkourCompleteEvent extends ParkourEndEvent {

    private final double completeTime;
    private final boolean isPersonalBest;

    public ParkourCompleteEvent(Player player, String courseID, double completeTime, boolean isPersonalBest) {
        super(player, courseID, ParkourEndReason.COMPLETED);
        this.completeTime = completeTime;
        this.isPersonalBest = isPersonalBest;
    }

    public double getCompleteTime() {
        return completeTime;
    }

    public boolean isPersonalBest() {
        return isPersonalBest;
    }
}
