package net.fortresswars.core.entities;

import net.fortresswars.core.player.TeamColor;
import org.bukkit.entity.Entity;

public interface FortressWarsEntity extends Fighter, Hackable, Zappable, Dataable, Taskable, Pauseable<Boolean> {

    /**
     * Delete the entity
     */
    void delete();

    void setEntity(Entity entity);

    TeamColor getTeam();

    void setTeam(TeamColor team);

    String getDisplayString();

    String getTeamColorCode();

    Entity getEntity();

    boolean isInGame();
}
