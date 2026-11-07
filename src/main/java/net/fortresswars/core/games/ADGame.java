package net.fortresswars.core.games;

import net.fortresswars.core.player.TeamColor;

public interface ADGame extends BeaconGame {

    TeamColor getDefendingFirstTeam();

    TeamColor getAttackingFirstTeam();

    TeamColor getDefendingTeam();

    TeamColor getAttackingTeam();

}
