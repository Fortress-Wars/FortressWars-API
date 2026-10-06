package net.fortresswars.core.statistics;

import net.fortresswars.core.entities.FortressWarsPlayer;

import java.util.List;

public class HighRecordStat extends RecordStat {

    public HighRecordStat(List<FortressWarsPlayer> players, FWStat stat, boolean includeZero) {
        super(players, stat, includeZero);
    }

    public void doWork() {
        if (players.isEmpty()) return;
        boolean isFirstValue = true;
        for (final var player : players) {
            final double value = fetchRecordValue(player);

            // Skip zero values if includeZero is false
            if (value == 0 && !includeZero) {
                continue;
            }

            // If this is the first value, set it as the record and add the player to the entries list
            if (isFirstValue) {
                recordValue = value;
                entries.add(player);
                isFirstValue = false;
                continue;
            }

            // If the value is less than the current record, skip this player
            if (value < recordValue) continue;

            // If the value is greater than the current record, clear the entries list and set the new record value
            if (value > recordValue) {
                entries.clear();
                recordValue = value;
            }

            // Add the player to the entries list
            entries.add(player);
        }
    }

    @Override
    protected double fetchRecordValue(FortressWarsPlayer player) {
        return player.getStatistic(stat);
    }
}
