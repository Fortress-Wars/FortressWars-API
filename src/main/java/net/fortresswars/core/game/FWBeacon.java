/*
 * Name: Beacon
 * Author: Peter Cesmegi
 * Description: Class Representing a beacon
 */

package net.fortresswars.core.game;

import net.fortresswars.core.player.TeamColor;
import org.bukkit.Location;

public class FWBeacon {
    private int percentage;
    private final TeamColor beaconTeam;
    private final String mapName;
    private final int x;
    private final int y;
    private final int z;

    public FWBeacon(TeamColor beaconTeam, String mapName, int x, int y, int z, int startingPercentage) {
        this.beaconTeam = beaconTeam;
        this.mapName = mapName;
        this.percentage = startingPercentage;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getBeaconPercent() {
        return percentage;
    }

    public static String getBeaconPercentColorCode(int beaconPercent) {
        if (beaconPercent <= 10) return "§4";
        if (beaconPercent <= 25) return "§6";
        if (beaconPercent <= 50) return "§e";
        return "§a";
    }

    public String getBeaconPercentColorCode() {
        return getBeaconPercentColorCode(percentage);
    }

    public void setPercentage(int percentage) {
        this.percentage = Math.clamp(percentage, 0, 100);
    }

    public boolean damageBeacon(int amount) {
        if (percentage <= amount) {
            percentage = 0;
            return true;
        }
        this.percentage -= amount;
        return false;
    }

    public String getMapName() {
        return mapName;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

    public boolean tick(int amount) {
        if (amount < 0) {
            if (percentage <= 1) {
                percentage = 0;
                return true;
            }
            this.percentage -= 1;
            return false;
        } else if (amount > 0) {
            if (percentage >= 99) {
                percentage = 100;
                return true;
            }
            this.percentage += 1;
            return false;
        }
        return false;
    }

    public TeamColor getColor() {
        return beaconTeam;
    }

    public boolean coordsMatch(Location loc) {
        return (x == loc.getBlockX() && y == loc.getBlockY() && z == loc.getBlockZ());
    }
}
