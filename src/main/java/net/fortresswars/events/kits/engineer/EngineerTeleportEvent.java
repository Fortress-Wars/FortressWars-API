package net.fortresswars.events.kits.engineer;

import net.fortresswars.core.entities.FortressWarsPlayer;
import net.fortresswars.core.kits.engineer.EngineerTeleporter;
import net.fortresswars.events.FortressWarsEvent;
import org.bukkit.Location;

public class EngineerTeleportEvent extends FortressWarsEvent {

    private final EngineerTeleporter teleporter;
    private final FortressWarsPlayer fwp;
    private final Location from;
    private final Location to;

    public EngineerTeleportEvent(EngineerTeleporter teleporter, FortressWarsPlayer fwp, Location from, Location to) {
        this.teleporter = teleporter;
        this.fwp = fwp;
        this.from = from;
        this.to = to;
    }

    public EngineerTeleporter getTeleporter() {
        return teleporter;
    }

    public FortressWarsPlayer getPlayer() {
        return fwp;
    }

    public Location getFrom() {
        return from;
    }

    public Location getTo() {
        return to;
    }

}
