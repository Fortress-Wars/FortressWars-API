package net.fortresswars.events.kits.engineer;

import net.fortresswars.core.kits.engineer.EngineerBlock;
import net.fortresswars.events.CollectorEvent;

import java.util.function.Predicate;

public class EngineerBlockCollectorEvent extends CollectorEvent<EngineerBlock> {
    public EngineerBlockCollectorEvent(Predicate<EngineerBlock> predicate) {
        super(predicate);
    }
}
