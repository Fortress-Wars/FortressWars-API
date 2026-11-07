package net.fortresswars.events.kits.jumper;

import net.fortresswars.core.entities.FortressWarsPlayer;
import net.fortresswars.events.FortressWarsEvent;
import org.bukkit.Location;

public class JumperTeleportEvent extends FortressWarsEvent {

    private final FortressWarsPlayer player;
    private final Location from;
    private final Location to;

    public JumperTeleportEvent(FortressWarsPlayer player, Location from, Location to) {
        this.player = player;
        this.from = from;
        this.to = to;
    }

    public FortressWarsPlayer getPlayer() {
        return player;
    }

    public Location getFrom() {
        return from;
    }

    public Location getTo() {
        return to;
    }
}
