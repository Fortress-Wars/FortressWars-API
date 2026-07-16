package net.fortresswars.events.gates;

import org.bukkit.Location;

public class GateOpenEvent extends GateEvent {
    public GateOpenEvent(Location location) {
        super(location);
    }
}
