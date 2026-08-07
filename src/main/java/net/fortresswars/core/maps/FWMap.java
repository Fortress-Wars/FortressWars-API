/*
 * Name: Map
 * Author: Peter Cesmegi
 * Description: Class representing a map for fortress wars 3
 */

package net.fortresswars.core.maps;

import net.fortresswars.core.player.TeamColor;
import net.fortresswars.core.respawn.RespawnTimes;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public abstract class FWMap {
    protected final double LOCATION_OFFSET = 0.5;
    protected final int BUILD_FLY_EXTRA_DISTANCE = 5;

    protected final MapDisplayData mapDisplayData;

    protected final ArrayList<Location> gateLocs;

    private Location redSpawnLocation;
    private Location blueSpawnLocation;
    private Location redRespawnLocation;
    private Location blueRespawnLocation;

    protected Location redBuildRadiusCenterLocation;
    protected Location blueBuildRadiusCenterLocation;
    protected boolean useNonBeaconBuildRadius = false;

    protected final int buildRadius;

    protected final int respawnY = 200;
    protected final int buildCeiling;

    protected int deathPlaneY = -64;

    protected int redSpawnBoxLowerCornerX;
    protected int redSpawnBoxLowerCornerY;
    protected int redSpawnBoxLowerCornerZ;

    protected int redSpawnBoxUpperCornerX;
    protected int redSpawnBoxUpperCornerY;
    protected int redSpawnBoxUpperCornerZ;

    protected int blueSpawnBoxLowerCornerX;
    protected int blueSpawnBoxLowerCornerY;
    protected int blueSpawnBoxLowerCornerZ;

    protected int blueSpawnBoxUpperCornerX;
    protected int blueSpawnBoxUpperCornerY;
    protected int blueSpawnBoxUpperCornerZ;

    // blue build radius center location
    private int bbrcx;
    private int bbrcy;
    private int bbrcz;

    // red build radius center location
    private int rbrcx;
    private int rbrcy;
    private int rbrcz;

    // Red Spawn X, Y, Z, Yaw, Pitch
    private int rsx;
    private int rsy;
    private int rsz;
    private float ry;
    private float rp;

    // Blue Spawn X, Y, Z, Yaw, Pitch
    private int bsx;
    private int bsy;
    private int bsz;
    private float by;
    private float bp;

    // Red Respawn X, Y, Z, Yaw, Pitch
    private int rrsx;
    private int rrsy;
    private int rrsz;
    private float rry;
    private float rrp;

    // Blue Respawn X, Y, Z, Yaw, Pitch
    private int brsx;
    private int brsy;
    private int brsz;
    private float bry;
    private float brp;

    private boolean hasNoBuildBox1 = false;
    private int box1MaxX = 0;
    private int box1MinX = 0;
    private int box1MaxY = 0;
    private int box1MinY = 0;
    private int box1MaxZ = 0;
    private int box1MinZ = 0;

    private boolean hasNoBuildBox2 = false;
    private int box2MaxX = 0;
    private int box2MinX = 0;
    private int box2MaxY = 0;
    private int box2MinY = 0;
    private int box2MaxZ = 0;
    private int box2MinZ = 0;

    private final RespawnTimes respawnTimes;

    public FWMap(MapDisplayData mapDisplayData, int buildRadius, int buildCeiling, @NotNull RespawnTimes respawnTimes) {
        this.mapDisplayData = mapDisplayData;
        this.buildRadius = buildRadius;
        this.buildCeiling = buildCeiling;
        this.gateLocs = new ArrayList<>();
        this.respawnTimes = respawnTimes;
    }

    public abstract boolean isBeaconBlock(Block block);

    public abstract boolean isInBeaconBox(int x, int y, int z);

    public abstract boolean isAboveBeaconCeiling(int y);

    public abstract boolean isInBeaconXZValue(Location loc);

    public abstract Location getObjectiveLocation(TeamColor team);

    public abstract Location getBeaconLocation(TeamColor team);

    public MapDisplayData getMapDisplayData() {
        return this.mapDisplayData;
    }

    public Location getRedSpawnLocation() {
        return redSpawnLocation;
    }

    public Location getBlueSpawnLocation() {
        return blueSpawnLocation;
    }

    public Location getRedRespawnLocation() {
        return redRespawnLocation;
    }

    public Location getBlueRespawnLocation() {
        return blueRespawnLocation;
    }

    public void setRedBuildRadiusCoords(int x, int y, int z) {
        this.rbrcx = x;
        this.rbrcy = y;
        this.rbrcz = z;
        useNonBeaconBuildRadius = true;
    }

    public void setBlueBuildRadiusCoords(int x, int y, int z) {
        this.bbrcx = x;
        this.bbrcy = y;
        this.bbrcz = z;
        useNonBeaconBuildRadius = true;
    }

    public void setRedRespawnSpawnCoords(int x, int y, int z, float yaw, float pitch) {
        this.rrsx = x;
        this.rrsy = y;
        this.rrsz = z;
        this.rry = yaw;
        this.rrp = pitch;
    }

    public void setBlueRespawnSpawnCoords(int x, int y, int z, float yaw, float pitch) {
        this.brsx = x;
        this.brsy = y;
        this.brsz = z;
        this.bry = yaw;
        this.brp = pitch;
    }

    public void setRedSpawnCoords(int x, int y, int z, float yaw, float pitch) {
        this.rsx = x;
        this.rsy = y;
        this.rsz = z;
        this.ry = yaw;
        this.rp = pitch;
        redSpawnBoxLowerCornerX = rsx - 1;
        redSpawnBoxLowerCornerY = rsy - 2;
        redSpawnBoxLowerCornerZ = rsz - 1;
        redSpawnBoxUpperCornerX = rsx + 1;
        redSpawnBoxUpperCornerY = rsy + 3;
        redSpawnBoxUpperCornerZ = rsz + 1;
    }

    public void setBlueSpawnCoords(int x, int y, int z, float yaw, float pitch) {
        this.bsx = x;
        this.bsy = y;
        this.bsz = z;
        this.by = yaw;
        this.bp = pitch;
        blueSpawnBoxLowerCornerX = bsx - 1;
        blueSpawnBoxLowerCornerY = bsy - 2;
        blueSpawnBoxLowerCornerZ = bsz - 1;
        blueSpawnBoxUpperCornerX = bsx + 1;
        blueSpawnBoxUpperCornerY = bsy + 3;
        blueSpawnBoxUpperCornerZ = bsz + 1;
    }

    public void updateLocations(World world) {
        redSpawnLocation = new Location(world, rsx + LOCATION_OFFSET, rsy, rsz + LOCATION_OFFSET, ry, rp);
        blueSpawnLocation = new Location(world, bsx + LOCATION_OFFSET, bsy, bsz + LOCATION_OFFSET, by, bp);
        redRespawnLocation = new Location(world, rrsx + LOCATION_OFFSET, rrsy, rrsz + LOCATION_OFFSET, rry, rrp);
        blueRespawnLocation = new Location(world, brsx + LOCATION_OFFSET, brsy, brsz + LOCATION_OFFSET, bry, brp);

        updateGates(world);
        updateBuildRadiusCenterLocation(world);
    }

    public void updateBuildRadiusCenterLocation(World world) {
        if (!useNonBeaconBuildRadius) return;
        blueBuildRadiusCenterLocation = new Location(world, bbrcx + LOCATION_OFFSET, bbrcy, bbrcz + LOCATION_OFFSET);
        redBuildRadiusCenterLocation = new Location(world, rbrcx + LOCATION_OFFSET, rbrcy, rbrcz + LOCATION_OFFSET);
    }

    protected void updateGates(World world) {
        for (Location location : gateLocs) {
            location.setWorld(world);
        }
    }

    public abstract boolean isInBuildRadiusWithExtraDistance(Location loc, TeamColor teamColor, int extraDistance);

    public boolean isInBeaconRadius(Location loc, TeamColor teamColor) {
        return isInBuildRadiusWithExtraDistance(loc, teamColor, 0);
    }

    public boolean isInBeaconFlyRadius(Location loc, TeamColor teamColor) {
        return isInBuildRadiusWithExtraDistance(loc, teamColor, BUILD_FLY_EXTRA_DISTANCE);
    }

    public boolean isInSpawnBox(int x, int y, int z) {
        if (x >= redSpawnBoxLowerCornerX && x <= redSpawnBoxUpperCornerX && y >= redSpawnBoxLowerCornerY && y <= redSpawnBoxUpperCornerY && z >= redSpawnBoxLowerCornerZ && z <= redSpawnBoxUpperCornerZ) {
            return true;
        } else
            return x >= blueSpawnBoxLowerCornerX && x <= blueSpawnBoxUpperCornerX && y >= blueSpawnBoxLowerCornerY && y <= blueSpawnBoxUpperCornerY && z >= blueSpawnBoxLowerCornerZ && z <= blueSpawnBoxUpperCornerZ;
    }

    public boolean isInRespawnStructure(int y) {
        return y >= respawnY;
    }

    public boolean isBelowDeathPlane(Location loc) {
        if (loc == null) return false;
        final var id = mapDisplayData.id();
        if (!loc.getWorld().getName().equals(id)) return false;
        return loc.getY() <= deathPlaneY;
    }

    public boolean isBlockInNoBuildeBox1(int x, int y, int z) {
        if (!hasNoBuildBox1) return false;

        boolean inX = x >= box1MinX && x <= box1MaxX;
        boolean inY = y >= box1MinY && y <= box1MaxY;
        boolean inZ = z >= box1MinZ && z <= box1MaxZ;
        return inX && inY && inZ;
    }

    public boolean isBlockInNoBuildeBox2(int x, int y, int z) {
        if (!hasNoBuildBox2) return false;

        boolean inX = x >= box2MinX && x <= box2MaxX;
        boolean inY = y >= box2MinY && y <= box2MaxY;
        boolean inZ = z >= box2MinZ && z <= box2MaxZ;
        return inX && inY && inZ;
    }

    public void setDeathPlane(int deathPlaneY) {
        this.deathPlaneY = deathPlaneY;
    }

    public void setNoPlaceBox1(int x1, int y1, int z1, int x2, int y2, int z2) {
        hasNoBuildBox1 = true;
        if (x1 > x2) {
            box1MaxX = x1;
            box1MinX = x2;
        } else {
            box1MaxX = x2;
            box1MinX = x1;
        }

        if (y1 > y2) {
            box1MaxY = y1;
            box1MinY = y2;
        } else {
            box1MaxY = y2;
            box1MinY = y1;
        }

        if (z1 > z2) {
            box1MaxZ = z1;
            box1MinZ = z2;
        } else {
            box1MaxZ = z2;
            box1MinZ = z1;
        }
    }

    public void setNoPlaceBox2(int x1, int y1, int z1, int x2, int y2, int z2) {
        hasNoBuildBox2 = true;
        if (x1 > x2) {
            box2MaxX = x1;
            box2MinX = x2;
        } else {
            box2MaxX = x2;
            box2MinX = x1;
        }

        if (y1 > y2) {
            box2MaxY = y1;
            box2MinY = y2;
        } else {
            box2MaxY = y2;
            box2MinY = y1;
        }

        if (z1 > z2) {
            box2MaxZ = z1;
            box2MinZ = z2;
        } else {
            box2MaxZ = z2;
            box2MinZ = z1;
        }
    }

    public void createGate(int x, int y, int z) {
        gateLocs.add(new Location(null, x, y, z));
    }

    public void closeGates() {
//        for (Location location : gateLocs) {
//            if (location.getWorld() == null) return;
//            plugin.API.GATE.close(location);
//        }
    }

    public void openGates() {
//        for (Location location : gateLocs) {
//            if (location.getWorld() == null) return;
//            plugin.API.GATE.open(location);
//        }
    }

    public double getBuildRadius() {
        return buildRadius;
    }

    public RespawnTimes getRespawnTimes() {
        return respawnTimes;
    }

}
