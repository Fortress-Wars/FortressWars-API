package net.fortresswars.events.games;

import net.fortresswars.core.entities.FortressWarsPlayer;
import net.fortresswars.core.games.Game;
import net.fortresswars.core.player.TeamColor;

import java.util.HashSet;
import java.util.Set;

public class GameEndEvent extends GameEvent {

    private final Set<FortressWarsPlayer> winners;
    private final Set<FortressWarsPlayer> losers;
    private final Set<FortressWarsPlayer> players;
    private final TeamColor winningTeam;

    public GameEndEvent(Game game, TeamColor winningTeam, Set<FortressWarsPlayer> winners, Set<FortressWarsPlayer> losers) {
        super(game);
        this.winners = winners;
        this.losers = losers;
        this.winningTeam = winningTeam;

        this.players = new HashSet<>();
        this.players.addAll(winners);
        this.players.addAll(losers);
    }

    public TeamColor getWinningTeam() {
        return winningTeam;
    }

    public Set<FortressWarsPlayer> getWinners() {
        return winners;
    }

    public Set<FortressWarsPlayer> getLosers() {
        return losers;
    }

    public Set<FortressWarsPlayer> getPlayers() {
        return players;
    }
}
