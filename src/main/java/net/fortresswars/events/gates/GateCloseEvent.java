package net.fortresswars.events.gates;

import net.fortresswars.core.gates.GateData;

public class GateCloseEvent extends GateEvent {
    public GateCloseEvent(GateData data) {
        super(data);
    }
}
