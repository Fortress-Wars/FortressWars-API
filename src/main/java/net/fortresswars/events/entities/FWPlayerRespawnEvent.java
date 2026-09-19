package net.fortresswars.events.entities;

import net.fortresswars.core.entities.FortressWarsPlayer;
import org.bukkit.Location;
import org.jetbrains.annotations.NotNull;

public class FWPlayerRespawnEvent extends FortressWarsPlayerEvent {

    private @NotNull Location respawnLocation;

    public FWPlayerRespawnEvent(@NotNull FortressWarsPlayer player, @NotNull Location respawnLocation) {
        super(player);
        this.respawnLocation = respawnLocation;
    }

    public @NotNull Location getRespawnLocation() {
        return respawnLocation;
    }

    public void setRespawnLocation(Location respawnLocation) {
        if (respawnLocation == null) return;
        this.respawnLocation = respawnLocation;
    }
}
