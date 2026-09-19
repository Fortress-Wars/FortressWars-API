package net.fortresswars.events.login;

import net.fortresswars.events.FortressWarsEvent;
import org.bukkit.entity.Player;

public class FWLoginEvent extends FortressWarsEvent {

    private final Player player;

    public FWLoginEvent(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }
}
