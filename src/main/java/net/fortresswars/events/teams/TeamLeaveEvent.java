package net.fortresswars.events.teams;

import net.fortresswars.core.player.TeamColor;
import org.bukkit.entity.Entity;

public class TeamLeaveEvent extends TeamEvent {

    public TeamLeaveEvent(Entity entity, TeamColor team) {
        super(entity, team);
    }
}
