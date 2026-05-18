/*
 * Name: StatisticsPack
 * Author: Peter Cesmegi
 * Description: Container for statisics
 */
package net.fortresswars.core.statistics;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

public class StatisticsPack {

    private final HashMap<FWStat, Double> statisticsMap;
    private final String playerName;
    private final UUID playerUUID;

    public StatisticsPack(Player player) {
        statisticsMap = new HashMap<>();
        playerName = player.getName();
        playerUUID = player.getUniqueId();
    }

    /**
     * @param stat  type to set a value to
     * @param value of the specified statistic to set
     */
    public void setValue(final FWStat stat, final double value) {
        statisticsMap.put(stat, value);
    }

    /**
     * @param stat  type to add a value to
     * @param value of the specified statistic to add
     * @return new value of the specified statistic
     */
    public double addValue(final FWStat stat, final double value) {
        final double previousValue = getStat(stat);
        final double newValue = switch (stat.getAggregationType()) {
            case MIN -> Math.min(previousValue, value);
            case MAX-> Math.max(previousValue, value);
            default -> previousValue + value;
        };
        statisticsMap.put(stat, newValue);
        return newValue;
    }

    /**
     * @param stat to retrieve
     * @return specified statistic value
     */
    public double getStat(final FWStat stat) {
        return statisticsMap.getOrDefault(stat, 0.0);
    }

    /**
     * @return the entire hashMap
     */
    public HashMap<FWStat, Double> getAllStats() {
        return statisticsMap;
    }

    /**
     * @return name of the player that owns this stat pack
     */
    public String getPlayerName() {
        return playerName;
    }

    /**
     * @return UUID of the player that owns this stat pack
     */
    public UUID getPlayerUUID() {
        return playerUUID;
    }
}
