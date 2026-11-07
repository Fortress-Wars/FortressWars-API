package net.fortresswars.core.items;

import net.fortresswars.core.managers.ActionBarManager;
import net.fortresswars.core.managers.EventManager;
import net.fortresswars.core.data.PersistentData;
import net.fortresswars.core.data.PersistentDataKey;
import org.bukkit.ChatColor;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public abstract class ItemHandler extends EventManager {

    private final String key;
    private final String id;

    protected ItemHandler(JavaPlugin plugin, String key, String id) {
        super(plugin);
        this.key = key;
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public boolean isHandlerItem(ItemStack item) {
        if (item == null) return false;
        final var maybeId = PersistentData.getProperty(item.getItemMeta(), PersistentDataKey.ID).asString();
        return this.id.equals(maybeId);
    }

    @EventHandler
    public void onPlayerInteractEvent(PlayerInteractEvent e) {
        final Player player = e.getPlayer();
        try {
            final ItemStack item = e.getItem();
            if (item == null) return;
            if (player.hasCooldown(item)) {
                e.setCancelled(true);
                return;
            }
            if (!(isHandlerItem(item))) return;

            final var action = e.getAction();
            if (action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK) {
                this.onRightClick(e);
                return;
            }

            if (action == Action.LEFT_CLICK_AIR || action == Action.LEFT_CLICK_BLOCK ){
                this.onLeftClick(e);
            }
        } catch (ItemException ex) {
            ActionBarManager.sendMessage(player, ChatColor.RED + ex.getMessage());
        }
    }

    @EventHandler (ignoreCancelled = true)
    public void onPlayerItemHeldEvent(PlayerItemHeldEvent e) {
        final var player = e.getPlayer();
        try {
            final var previousItem = PlayerInventoryContainer.getItemInSlot(player, e.getPreviousSlot());
            if (isHandlerItem(previousItem)) {
                onReleaseItem(player, previousItem);
                return; // A player can't release and hold the item at the same time, therefore we return here
            }

            final var newItem = PlayerInventoryContainer.getItemInSlot(player, e.getNewSlot());
            if (isHandlerItem(newItem)) {
                onHoldItem(player, newItem);
            }
        } catch (ItemException ex) {
            // Squash
        }
    }

    public void giveCooldown(Player player, ItemStack item) {
        final var uuid = PersistentData.getProperty(item.getItemMeta(), PersistentDataKey.UUID).asUUID();
        if (uuid == null) return;

        final var key = new NamespacedKey(plugin, this.key + "." + uuid);

        final var itemMeta = item.getItemMeta();
        final var useCooldown = itemMeta.getUseCooldown();
        final var cooldownSeconds = useCooldown.getCooldownSeconds();
        final var cooldownTicks =  (int) (cooldownSeconds * 20);
        player.setCooldown(key, cooldownTicks);
    }

    protected abstract void onRightClick(PlayerInteractEvent e);

    protected abstract void onLeftClick(PlayerInteractEvent e);

    protected abstract void onHoldItem(Player player, ItemStack item);

    protected abstract void onReleaseItem(Player player, ItemStack item);
}

