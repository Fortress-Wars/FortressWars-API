package net.fortresswars.events.kits.engineer;

import net.fortresswars.core.entities.FortressWarsEntity;
import net.fortresswars.core.kits.engineer.EngineerDispenser;
import net.fortresswars.events.FortressWarsEvent;

import java.util.List;

public class EngineerDispenseResultEvent extends FortressWarsEvent {

    private final EngineerDispenser dispenser;
    private final List<FortressWarsEntity> entitiesDispensedTo;

    public EngineerDispenseResultEvent(EngineerDispenser dispenser, List<FortressWarsEntity> entitiesDispensedTo) {
        this.dispenser = dispenser;
        this.entitiesDispensedTo = entitiesDispensedTo;
    }

    public EngineerDispenser getDispenser() {
        return dispenser;
    }

    public int getNumberOfDispensees() {
        return entitiesDispensedTo.size();
    }

    public List<FortressWarsEntity> getPlayersDispensedTo() {
        return entitiesDispensedTo;
    }
}
