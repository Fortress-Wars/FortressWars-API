package net.fortresswars.events;

import org.bukkit.event.Cancellable;

public class FortressWarsCancellableEvent extends FortressWarsEvent implements Cancellable {

    private boolean isCancelled = false;

    @Override
    public boolean isCancelled() {
        return isCancelled;
    }

    @Override
    public void setCancelled(boolean b) {
        this.isCancelled = b;
    }
}
