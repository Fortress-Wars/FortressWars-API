package net.fortresswars.events.kits.engineer;

import net.fortresswars.core.entities.FortressWarsPlayer;

public class EngineerConsumeMetalEvent extends EngineerMetalEvent {
    public EngineerConsumeMetalEvent(FortressWarsPlayer player, int metal) {
        super(player, metal);
    }
}
