package net.fortresswars.events.lobby;

import net.fortresswars.events.FortressWarsCancellableEvent;
import org.bukkit.entity.Player;

public class PlayerSpawnInLobbyEvent extends FortressWarsCancellableEvent {

    private final Player player;

    public PlayerSpawnInLobbyEvent(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }
}
