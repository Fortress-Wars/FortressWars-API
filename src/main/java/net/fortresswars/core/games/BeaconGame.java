package net.fortresswars.core.games;

import net.fortresswars.core.player.TeamColor;

public interface BeaconGame extends Game {

    FWBeacon getBeacon(TeamColor teamColor);
}
