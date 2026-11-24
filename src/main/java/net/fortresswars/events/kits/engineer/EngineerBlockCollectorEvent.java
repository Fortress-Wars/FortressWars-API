package net.fortresswars.events.kits.engineer;

import net.fortresswars.core.kits.engineer.EngineerStructure;
import net.fortresswars.events.CollectorEvent;

import java.util.function.Predicate;

public class EngineerBlockCollectorEvent extends CollectorEvent<EngineerStructure> {
    public EngineerBlockCollectorEvent(Predicate<EngineerStructure> predicate) {
        super(predicate);
    }
}
