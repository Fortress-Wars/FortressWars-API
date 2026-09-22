package net.fortresswars.core.entities;

import net.fortresswars.core.games.Game;
import net.fortresswars.core.player.TeamColor;
import net.fortresswars.core.statistics.StatisticsContainer;
import org.bukkit.entity.Entity;
import org.jetbrains.annotations.NotNull;

public interface FortressWarsEntity extends Fighter, Hackable, Zappable, Dataable, Taskable, StatisticsContainer, Pauseable<Boolean> {

    void setEntity(Entity entity);

    TeamColor getTeam();

    void setTeam(TeamColor team);

    String getDisplayString();

    String getTeamColorCode();

    Entity getEntity();

    @NotNull Game getGame();

    void saveEntityPauseState(boolean hasQuit);

    /**
     * Delete the entity
     */
    void delete();
}
