package net.fortresswars.core.statistics;

import java.util.HashMap;
import java.util.UUID;

public class LowRecordStat extends RecordStat {

    public LowRecordStat(HashMap<UUID, StatisticsPack> statisticsEntries, FWStat stat, boolean includeZero) {
        super(statisticsEntries, stat, includeZero);
    }

    public void doWork() {
        if (statisticsEntries.isEmpty()) return;

        boolean firstValue = true;

        for (UUID uuid : statisticsEntries.keySet()) {
            StatisticsPack sp = statisticsEntries.get(uuid);
            double statValue = sp.getStat(stat);
            if (statValue == 0 && !includeZero) continue;
            else if (firstValue) {
                recordValue = statValue;
                entries.add(uuid);
                firstValue = false;
                continue;
            } else if (statValue > recordValue) {
                continue;
            } else if (statValue < recordValue) {
                entries.clear();
                recordValue = statValue;
            }
            entries.add(uuid);
        }
    }
}
