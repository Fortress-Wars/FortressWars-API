package net.fortresswars.events.games;

import net.fortresswars.core.entities.FortressWarsPlayer;
import net.fortresswars.core.games.BeaconGame;
import net.fortresswars.core.games.FWBeacon;

public class FWBeaconDamageByPlayerEvent extends FWBeaconDamageEvent {

    private final FortressWarsPlayer player;

    public FWBeaconDamageByPlayerEvent(BeaconGame game, FWBeacon beacon, int damage, FortressWarsPlayer player) {
        super(game, beacon, damage, Reason.PLAYER);
        this.player = player;
    }

    /**
     * Get the player that damaged
     * @return the FortressWarsPlayer
     */
    public FortressWarsPlayer getPlayer() {
        return this.player;
    }
}
