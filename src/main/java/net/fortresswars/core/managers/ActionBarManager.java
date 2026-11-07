package net.fortresswars.core.managers;

import net.fortresswars.FortressWarsAPI;
import net.fortresswars.core.data.PersistentData;
import net.fortresswars.core.data.PersistentDataKey;
import net.fortresswars.helpers.EntityHelper;
import net.kyori.adventure.text.Component;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import javax.annotation.Nullable;

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

        // Message Weight
        final int previousWeight = PersistentData.getProperty(player, PersistentDataKey.WEIGHT, ACTION_BAR_KEY).asInt();
        final int currentWeight = msgType.weight;

        // Check if we should show a new message.
        if (currentWeight < previousWeight && EntityHelper.hasInternalCooldown(entity, ACTION_BAR_KEY)) return;

        // Set new data
        EntityHelper.setInternalCooldown(player, ACTION_BAR_KEY, ACTION_BAR_COOLDOWN_MS);
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
