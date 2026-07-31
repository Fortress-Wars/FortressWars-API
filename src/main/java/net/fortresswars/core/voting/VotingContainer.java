package net.fortresswars.core.voting;

import net.fortresswars.events.voting.VotingEntryUpdateEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.stream.Collectors;

public class VotingContainer {

    public enum Type {
        MAP("maps"),
        GAMERULE("gamerules");

        private final String configName;

        Type(String configName) {
            this.configName = configName;
        }

        public String getConfigName() {
            return this.configName;
        }
    }

    public record Vote(
        String name,
        int amount
    ) {
        public static String getName(Vote newVote) {
            if (newVote == null) return null;
            return newVote.name;
        }
    }

    private final Type type;
    private final Map<String, Vote> votes;
    private final Map<String, VotingEntry> entryMap;

    public VotingContainer(Type type) {
        this.type = type;
        this.votes = new HashMap<>();
        this.entryMap = new HashMap<>();
    }

    public void clearVotes() {
        this.votes.clear();
        for (VotingEntry votingEntry : this.entryMap.values()) {
            votingEntry.resetVotes();
        }
    }

    public void setEntryMap(Map<String, VotingEntry> entryMap) {
        this.clearVotes();
        this.entryMap.putAll(entryMap);
    }

    public boolean isValidVotingEntry(String voteEntryID) {
        if (voteEntryID == null) return true;
        return this.entryMap.containsKey(voteEntryID);
    }

    public void addVote(Player player, String newVote) throws VotingException {
        final UUID uuid = player.getUniqueId();
        updateVoteEntry(uuid.toString(), new Vote(newVote, 1));
    }

    public String getVote(Player player) {
        final UUID uuid = player.getUniqueId();
        final Vote vote = this.votes.get(uuid.toString());
        return vote.name();
    }

    public boolean hasVote(Player player) {
        final UUID uuid = player.getUniqueId();
        return this.votes.containsKey(uuid.toString());
    }

    public String addRandomVote(Player player) throws VotingException {
        final List<String> entryKeys = this.entryMap.keySet().stream().toList();
        final int randomEntryIndex = (int) (Math.random() * entryKeys.size());
        final String randomVote = entryKeys.get(randomEntryIndex);
        addVote(player, randomVote);
        return randomVote;
    }

    public void resetVote(Player player) throws VotingException {
        final UUID uuid = player.getUniqueId();
        updateVoteEntry(uuid.toString(), null);
    }

    public String getEntryFriendlyName(String voteEntryID) {
        if (!isValidVotingEntry(voteEntryID)) {
            return null;
        }
        return this.entryMap.get(voteEntryID).getName();
    }

    private boolean isSameVoteName(Vote vote1, Vote vote2) {
        if (vote1 == null && vote2 == null) return true;
        if (vote1 == null) return false;
        if (vote2 == null) return false;
        return vote1.name.equals(vote2.name);
    }

    /**
     * Remove a vote.
     * @param entry The entry to reset.
     * @return the voting entry that was removed from.
     */
    private VotingEntry removeVote(@NotNull String entry) {
        final Vote oldVote = this.votes.remove(entry);
        if (oldVote == null) return null;
        final VotingEntry votingEntry = this.entryMap.get(oldVote.name);
        if (votingEntry != null) {
            votingEntry.removeVote(entry);
        }
        return votingEntry;
    }

    /**
     * Add a vote
     * @param entry the entry to set
     * @param vote the vote object to use to add.
     * @return the voting entry that the vote was added to.
     */
    private VotingEntry addVote(@NotNull String entry, Vote vote) {
        if (vote == null) return null;

        // Add new vote
        this.votes.put(entry, vote);

        final VotingEntry newVotingEntry = this.entryMap.get(vote.name);
        if (newVotingEntry != null) {
            newVotingEntry.addVote(entry, vote);
        }

        return newVotingEntry;
    }

    private void updateVoteEntry(@NotNull String entry, Vote newVote) throws VotingException {
        if (!isValidVotingEntry(Vote.getName(newVote))) {
            throw new VotingException("Invalid vote");
        }

        final Vote oldVote = this.votes.get(entry);
        if (isSameVoteName(oldVote, newVote)) return;

        // Reset the old vote
        final VotingEntry oldVotingEntry = this.removeVote(entry);
        final VotingEntry newVotingEntry = this.addVote(entry, newVote);

        // Call Event
        final VotingEntryUpdateEvent event = new VotingEntryUpdateEvent(
                this.type,
                VotingEntry.copy(oldVotingEntry),
                VotingEntry.copy(newVotingEntry),
                !votes.isEmpty()
        );
        Bukkit.getPluginManager().callEvent(event);
    }

    /**
     * Get the current votes
     * @return Get a copy of the current vote set
     */
    public Set<VotingEntry> getCurrentVotes() {
        return entryMap.values().stream().map(VotingEntry::copy).collect(Collectors.toSet());
    }

    /**
     * Get the most voted map entry.
     * @return a copy of the most voted entry or null if there aren't any votes.
     */
    public VotingEntry getMostVotedEntry() {
        if (votes.isEmpty()) {
            return null;
        }

        final List<VotingEntry> sortedVotingEntry = new ArrayList<>(entryMap.values());
        sortedVotingEntry.sort(Comparator.comparingInt(VotingEntry::getVotes));
        return VotingEntry.copy(sortedVotingEntry.getFirst());
    }

    /**
     * Get if the container has any votes.
     * @return true if the container has votes, false if it does not.
     */
    public boolean hasVotes() {
        return entryMap.values().stream().anyMatch(entry -> entry.getVotes() > 0);
    }
}
