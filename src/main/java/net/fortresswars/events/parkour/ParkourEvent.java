package net.fortresswars.events.parkour;

import net.fortresswars.events.FortressWarsEvent;
import org.bukkit.entity.Player;

public class ParkourEvent extends FortressWarsEvent {

    private final Player player;
    private final String courseID;

    public ParkourEvent(Player player, String courseID) {
        this.player = player;
        this.courseID = courseID;
    }

    public Player getPlayer() {
        return player;
    }

    public String getCourseID() {
        return courseID;
    }
}
