package net.fortresswars.core.voting;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;

public class VotingEntry implements Comparable<VotingEntry> {

    public static VotingEntry copy(@Nullable VotingEntry votingEntry) {
        if (votingEntry == null) return null;
        final VotingEntry copy = new VotingEntry(votingEntry.id, votingEntry.friendlyName);

        for (String key : votingEntry.votes.keySet()) {
            final VotingContainer.Vote vote = votingEntry.votes.get(key);
            copy.addVote(key, vote);
        }
        return copy;
    }

    private final Map<String, VotingContainer.Vote> votes;

    private final String friendlyName;
    private final String id;

    public VotingEntry(String id, String friendlyName) {
        this.id = id;
        this.friendlyName = friendlyName;
        this.votes = new HashMap<>();
    }

    public String getID() {
        return id;
    }

    public String getName() {
        return friendlyName;
    }

    public void addVote(String entry, VotingContainer.Vote vote) {
        this.votes.put(entry, vote);
    }

    public void removeVote(String entry) {
        this.votes.remove(entry);
    }

    public void resetVotes() {
        this.votes.clear();
    }

    public int getVotes() {
        return votes.values().stream().mapToInt(VotingContainer.Vote::amount).sum();
    }

    @Override
    public int compareTo(@NotNull VotingEntry o) {
        return getVotes() - o.getVotes();
    }

    @Override
    public String toString() {
        return "VotingEntry={" + this.id + ", " + getVotes()+ "}";
    }
}
