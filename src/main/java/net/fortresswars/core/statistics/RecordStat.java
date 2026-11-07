package net.fortresswars.core.statistics;

import net.fortresswars.core.entities.FortressWarsPlayer;

import java.util.*;

public abstract class RecordStat {

    public enum Type {
        HIGHEST,
        HIGHEST_RATIO,
        LOWEST,
        LOWEST_RATIO,
    }

    public static RecordStat createRecordStat(Type type, List<FortressWarsPlayer> players, boolean includeZero, FWStat... stats) {
        final var recordStat = switch (type) {
            case HIGHEST -> new HighRecordStat(players, stats[0], includeZero);
            case HIGHEST_RATIO -> new HighRatioRecordStat(players, stats[0], stats[1], includeZero);
            case LOWEST -> new LowRecordStat(players, stats[0], includeZero);
            case LOWEST_RATIO -> new LowRatioRecordStat(players, stats[0], stats[1], includeZero);
        };
        recordStat.doWork();
        return recordStat;
    }

    protected final List<FortressWarsPlayer> players;
    protected final List<FortressWarsPlayer> entries;
    protected double recordValue;
    protected final boolean includeZero;
    protected final FWStat stat;

    public RecordStat(List<FortressWarsPlayer> players, FWStat stat, boolean includeZero) {
        this.players = players;
        this.stat = stat;
        this.includeZero = includeZero;
        entries = new ArrayList<>();
    }

    /**
     * @return returns the record value
     */
    public double getValue() {
        return recordValue;
    }

    /**
     * @return List of entries that share this record
     */
    public List<FortressWarsPlayer> getEntries() {
        return entries;
    }

    /**
     * Updates the record based on the conditions implemented in this method
     */
    protected abstract void doWork();

    /**
     * Fetches the record value for a given player based on the conditions implemented in this method
     * @param player The player to fetch the record value for
     */
    protected abstract double fetchRecordValue(FortressWarsPlayer player);
}
