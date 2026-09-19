package net.fortresswars.core.games;

import net.fortresswars.core.player.TeamColor;

public interface KothGame extends BeaconGame {

    TeamColor getTeamControllingBeacon();

    void lockBeacon();

    void unlockBeacon();
}
