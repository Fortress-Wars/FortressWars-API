package net.fortresswars.events.login;

import net.fortresswars.events.FortressWarsEvent;
import org.bukkit.entity.Player;

public class FWLogoutEvent extends FortressWarsEvent {

    private final Player player;

    public FWLogoutEvent(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }
}
