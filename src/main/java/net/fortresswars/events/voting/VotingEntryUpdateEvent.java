package net.fortresswars.events.voting;

import net.fortresswars.core.voting.VotingContainer;
import net.fortresswars.core.voting.VotingEntry;
import net.fortresswars.events.FortressWarsEvent;
import org.jetbrains.annotations.Nullable;

public class VotingEntryUpdateEvent extends FortressWarsEvent {

    private final VotingContainer.Type type;
    private final VotingEntry oldEntry;
    private final VotingEntry newEntry;
    private final boolean doVotesExist;

    public VotingEntryUpdateEvent(VotingContainer.Type type, VotingEntry oldEntry, VotingEntry newEntry, boolean doVotesExist) {
        this.type = type;
        this.oldEntry = oldEntry;
        this.newEntry = newEntry;
        this.doVotesExist = doVotesExist;
    }

    public VotingContainer.Type getType() {
        return type;
    }

    public @Nullable VotingEntry getOldEntry() {
        return oldEntry;
    }

    public @Nullable VotingEntry getNewEntry() {
        return newEntry;
    }

    public boolean doVotesExist() {
        return doVotesExist;
    }
}
