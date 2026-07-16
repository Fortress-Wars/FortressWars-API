package net.fortresswars.events.gates;

import net.fortresswars.events.FortressWarsCancellableEvent;
import org.bukkit.Location;

public class GateEvent extends FortressWarsCancellableEvent {

    private final Location location;

    public GateEvent(Location location) {
        this.location = location;
    }

    /**
     * Get the location of the gate data block.
     * @return the location
     */
    public Location getLocation() {
        return location;
    }
}
