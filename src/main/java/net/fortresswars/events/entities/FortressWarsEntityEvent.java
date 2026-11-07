package net.fortresswars.events.entities;

import net.fortresswars.core.entities.FortressWarsEntity;
import net.fortresswars.events.FortressWarsEvent;
import org.jetbrains.annotations.NotNull;

public class FortressWarsEntityEvent extends FortressWarsEvent {

    private final @NotNull FortressWarsEntity entity;

    public FortressWarsEntityEvent(@NotNull FortressWarsEntity entity) {
        this.entity = entity;
    }

    public @NotNull FortressWarsEntity getEntity() {
        return entity;
    }
}
