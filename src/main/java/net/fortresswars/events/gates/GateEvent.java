package net.fortresswars.events.gates;

import net.fortresswars.core.gates.GateData;
import net.fortresswars.events.FortressWarsCancellableEvent;

public class GateEvent extends FortressWarsCancellableEvent {

    private final GateData data;

    public GateEvent(GateData data) {
        this.data = data;
    }

    /**
     * Get the location of the gate data block.
     * @return the location
     */
    public GateData getData() {
        return data;
    }
}
