package net.fortresswars.core.statistics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public abstract class RecordStat {

    protected final HashMap<UUID, StatisticsPack> statisticsEntries;
    protected final List<UUID> entries;
    protected double recordValue;
    protected final boolean includeZero;
    protected final FWStat stat;

    public RecordStat(HashMap<UUID, StatisticsPack> statisticsEntries, FWStat stat, boolean includeZero) {
        this.statisticsEntries = statisticsEntries;
        this.stat = stat;
        this.includeZero = includeZero;
        entries = new ArrayList<>();
        doWork();
    }

    /**
     * @return returns the record value
     */
    public double getValue() {
        return recordValue;
    }

    /**
     * @return List of entires that share this record
     */
    public List<UUID> getEntries() {
        return entries;
    }

    /**
     * Updates the record based on the conditions implemented in this method
     */
    public abstract void doWork();
}
