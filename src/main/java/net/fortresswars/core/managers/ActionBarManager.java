package net.fortresswars.core.managers;

import net.fortresswars.FortressWarsAPI;
import net.fortresswars.data.PersistentData;
import net.fortresswars.data.PersistentDataKey;
import net.kyori.adventure.text.Component;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import javax.annotation.Nullable;
import java.util.Date;
import java.util.Set;

public class ActionBarManager {

    private final static long ACTION_BAR_COOLDOWN_MS = 1500;
    private final static NamespacedKey ACTION_BAR_KEY = new NamespacedKey(FortressWarsAPI.NAMESPACE, "action_bar_cooldown");

    public enum MessageType {
        ALERT(0),
        STATUS(1),
        INFO(2);

        private final int weight;

        MessageType(int weight) {
            this.weight = weight;
        }

        public int getWeight() {
            return weight;
        }
    }

    public static void sendMessage(@Nullable Entity entity, String message, MessageType msgType) {
        sendMessage(entity, Component.text(message), msgType);
    }

    public static void sendMessage(@Nullable Entity entity, Component message, MessageType msgType) {
        if (!(entity instanceof Player player)) return;

        final PersistentData previousData = PersistentData.fromHolder(
                player,
                Set.of(PersistentDataKey.TIME, PersistentDataKey.WEIGHT),
                ACTION_BAR_KEY
        );

        // Message Weight
        final int previousWeight = previousData.get(PersistentDataKey.WEIGHT).asInt();
        final int currentWeight = msgType.weight;

        // Message Cooldown
        final long previousTime = previousData.get(PersistentDataKey.TIME).asLong();
        final long currentTime = new Date().getTime();
        final long elapsedTime = currentTime - previousTime;
        final boolean hasCooldown = ACTION_BAR_COOLDOWN_MS - elapsedTime > 0;

        // Check if we should show a new message.
        if (currentWeight < previousWeight && hasCooldown) return;

        // Set new data
        PersistentData.setProperty(player, PersistentDataKey.TIME, currentTime, ACTION_BAR_KEY);
        PersistentData.setProperty(player, PersistentDataKey.WEIGHT, currentWeight, ACTION_BAR_KEY);

        entity.sendActionBar(message);
    }

    public static void sendMessage(Entity entity, String message) {
        sendMessage(entity, message, MessageType.INFO);
    }

    public static void clearMessage(Entity entity) {
        if (!(entity instanceof Player player)) return;
        player.sendActionBar(Component.text(""));
    }
}
