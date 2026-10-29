package net.fortresswars.events.items;

import net.fortresswars.core.entities.FortressWarsEntity;
import net.fortresswars.events.entities.FortressWarsEntityEvent;
import org.bukkit.entity.Item;
import org.bukkit.event.Cancellable;

public abstract class FWItemEvent extends FortressWarsEntityEvent implements Cancellable {

    private final Item item;
    private boolean isCancelled;

    public FWItemEvent(Item item, FortressWarsEntity entity) {
        super(entity);
        this.item = item;
    }

    public Item getItem() {
        return item;
    }

    @Override
    public boolean isCancelled() {
        return isCancelled;
    }

    @Override
    public void setCancelled(boolean isCancelled) {
        this.isCancelled = isCancelled;
    }
}
