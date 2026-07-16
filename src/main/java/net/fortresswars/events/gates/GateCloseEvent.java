package net.fortresswars.events.gates;

import org.bukkit.Location;

public class GateCloseEvent extends GateEvent {
    public GateCloseEvent(Location location) {
        super(location);
    }
}
