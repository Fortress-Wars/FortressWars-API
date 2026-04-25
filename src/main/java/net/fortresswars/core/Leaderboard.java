package net.fortresswars.core;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public record Leaderboard(
        String id,
        Date date,
        List<LeaderboardEntry> entries
) {

    public void insertEntry(LeaderboardEntry entry) {
        entries.add(entry);
    }

    public void sort(Comparator<LeaderboardEntry> compareMethod) {
        entries.sort(compareMethod);
    }

    public UUID getUUID(int position) {
        if (position >= entries.size()) return null;
        final LeaderboardEntry entry = entries.get(position);
        if (entry == null) return null;
        return entry.uuid();
    }

    public String getUsername(int position) {
        if (position >= entries.size()) return null;
        final LeaderboardEntry entry = entries.get(position);
        if (entry == null) return null;
        return entry.username();
    }

    public double getValue(int position) {
        if (position >= entries.size()) return 0;
        final LeaderboardEntry entry = entries.get(position);
        if (entry == null) return 0;
        return entry.value();
    }

    public boolean containsEntry(int position) {
        return position >= 0 && position < entries.size();
    }

    public void delete() {
        entries.clear();
    }
}
