package net.fortresswars.events.items;

import net.fortresswars.core.entities.FortressWarsEntity;
import org.bukkit.entity.Item;

public class FWItemDestroyEvent extends FWItemEvent {

    public FWItemDestroyEvent(Item item) {
        super(item, null);
    }

    public FWItemDestroyEvent(Item item, FortressWarsEntity source) {
        super(item, source);
    }
}
