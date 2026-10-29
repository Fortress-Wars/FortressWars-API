package net.fortresswars.events.items;

import net.fortresswars.core.entities.FortressWarsEntity;
import org.bukkit.entity.Item;

public class FWItemPickupEvent extends FWItemEvent {

    public FWItemPickupEvent(Item item, FortressWarsEntity entity) {
        super(item, entity);
    }
}
