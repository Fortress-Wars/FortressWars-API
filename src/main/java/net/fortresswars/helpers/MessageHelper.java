package net.fortresswars.helpers;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Bukkit;

public class MessageHelper {

    /**
     * Broadcast a message to all players and senders.
     * (Messages are not broadcast if the plugin is still loading)
     * @param msg message to broadcast
     */
    public static void broadcastServerMessage(String msg) {
        Bukkit.broadcast(Component.text("§2[FW] ", NamedTextColor.DARK_GREEN)
                .append(Component.text(msg, NamedTextColor.GOLD)));
    }
}
