package net.fortresswars.events.teams;

import net.fortresswars.core.player.TeamColor;
import net.fortresswars.events.FortressWarsEvent;
import org.bukkit.entity.Entity;

public class TeamEvent extends FortressWarsEvent {

    private final Entity entity;
    private final TeamColor team;

    public TeamEvent(Entity entity, TeamColor team) {
        this.entity = entity;
        this.team = team;
    }

    public Entity getEntity() {
        return entity;
    }

    public TeamColor getTeam() {
        return team;
    }
}
