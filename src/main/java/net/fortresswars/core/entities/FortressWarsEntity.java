package net.fortresswars.core.entities;

import net.fortresswars.core.player.TeamColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;

public interface FortressWarsEntity extends Fighter, Hackable, Zappable, Dataable, Taskable, Pauseable<Boolean> {

    void setEntity(LivingEntity entity);

    TeamColor getTeam();

    void setTeam(TeamColor team);

    String getDisplayString();

    String getTeamColorCode();

    Entity getEntity();

//    Game getGame();

    boolean isInGame();
}
