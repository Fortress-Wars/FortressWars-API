package net.fortresswars.events.gates;

import net.fortresswars.core.gates.GateData;

public class GateOpenEvent extends GateEvent {
    public GateOpenEvent(GateData data) {
        super(data);
    }
}
