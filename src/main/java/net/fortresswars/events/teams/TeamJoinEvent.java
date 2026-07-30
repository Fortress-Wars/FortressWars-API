package net.fortresswars.events.teams;

import net.fortresswars.core.player.TeamColor;
import org.bukkit.entity.Entity;

public class TeamJoinEvent extends TeamEvent {

    public TeamJoinEvent(Entity entity, TeamColor team) {
        super(entity, team);
    }
}
