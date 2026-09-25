package net.fortresswars.core.games;

import net.fortresswars.core.entities.FortressWarsEntity;
import net.fortresswars.core.entities.FortressWarsPlayer;
import net.fortresswars.core.gamerules.Gamerule;
import net.fortresswars.core.games.scores.Score;
import net.fortresswars.core.managers.Enableable;
import net.fortresswars.core.maps.MapDisplayData;
import net.fortresswars.core.player.TeamColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface Game extends Enableable {

    @NotNull World getWorld();

    Gamerule getGamerule();

    FWGameMode getGameMode();

    @NotNull FortressWarsPlayer newPlayer(@NotNull Player player);

    TeamColor getWinningTeam();

    Score getScore();

    int getRespawnTime(FortressWarsEntity fwe);

    void teleportPlayerToSpawn(FortressWarsEntity fwe);

    boolean isInNoBuildZone(Location location);

    boolean isInObjectiveBox(Location location, TeamColor teamColor);

    boolean isInSpawnBox(Location location, TeamColor teamColor);

    boolean isObjectiveBlock(Block block, TeamColor teamColor);

    boolean isAboveObjectiveCeiling(int y);

    boolean isInObjectiveXZValue(Location loc);

    Location getObjectiveLocation(TeamColor team);

    Location getSpawnLocation(TeamColor team);

    Location getRespawnLocation(TeamColor team);

    MapDisplayData getMapDisplayData();

    boolean isInObjectiveRadius(Location location, TeamColor teamColor, int offset);

    boolean isBelowDeathPlane(Location location);

    List<Location> getGateLocations();

    double getObjectiveRadius();

    double getObjectiveCeiling();

//    void createObjectiveHolograms();
//
//    void updateObjectiveHolograms();
//
//    void deleteObjectiveHolograms();
}
