package net.fortresswars.events.kits.engineer;

import net.fortresswars.core.entities.FortressWarsPlayer;

public class EngineerObtainMetalEvent extends EngineerMetalEvent {
    public EngineerObtainMetalEvent(FortressWarsPlayer player, int metal) {
        super(player, metal);
    }
}
