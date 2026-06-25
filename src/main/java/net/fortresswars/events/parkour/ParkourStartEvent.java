package net.fortresswars.events.parkour;

import org.bukkit.entity.Player;

public class ParkourStartEvent extends ParkourEvent {
    public ParkourStartEvent(Player player, String courseID) {
        super(player, courseID);
    }
}
