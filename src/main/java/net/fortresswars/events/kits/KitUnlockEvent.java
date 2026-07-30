package net.fortresswars.events.kits;

import net.fortresswars.events.FortressWarsEvent;
import org.bukkit.entity.Player;

public class KitUnlockEvent extends FortressWarsEvent {

    private final Player p;

    public KitUnlockEvent(Player p) {
        this.p = p;
    }

    public Player getPlayer() {
        return p;
    }
}
