package net.fortresswars.core.entities;

import net.fortresswars.core.games.Game;
import net.fortresswars.core.managers.Enableable;
import net.fortresswars.core.player.TeamColor;
import net.fortresswars.core.statistics.StatisticsContainer;
import net.fortresswars.events.entities.FWAdjustVelocityEvent;
import org.bukkit.entity.Entity;
import org.jetbrains.annotations.NotNull;

public interface FortressWarsEntity extends Enableable, Fighter, Hackable, Zappable, Dataable, Taskable, StatisticsContainer, Pauseable<Boolean> {

    void setEntity(@NotNull Entity entity);

    TeamColor getTeam();

    void setTeam(TeamColor team);

    String getDisplayString();

    String getTeamColorCode();

    @NotNull Entity getEntity();

    @NotNull Game getGame();

    /**
     * Launch the entity in a direction away from the source entity. The velocity is multiplied by the multiplier.
     * @param source the source entity that is launching this entity
     * @param fweSource the FortressWarsEntity source that is launching this entity. The entity could be a player or
     *                  a kit ability block, for example, so this is the FortressWarsEntity instance that owns the launch.
     * @param multiplier the multiplier for the velocity
     * @param launchType the type of launch, which determines how the velocity is adjusted
     */
    void launch(Entity source, FortressWarsEntity fweSource, double multiplier, FWAdjustVelocityEvent.AdjustingType launchType);

    void saveEntityPauseState(boolean hasQuit);

    /**
     * Delete the entity
     */
    void delete();
}
