package net.fortresswars.items;

import net.fortresswars.core.managers.EventManager;
import net.fortresswars.data.PersistentData;
import net.fortresswars.data.PersistentDataKey;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
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
        final var maybeId = PersistentData.getProperty(item.getItemMeta(), PersistentDataKey.ID).asString();
        return this.id.equals(maybeId);
    }

    @EventHandler
    public void onPlayerInteractEvent(PlayerInteractEvent e) {
        final Player player = e.getPlayer();
        final ItemStack item = e.getItem();
        if (item == null) return;
        if (player.hasCooldown(item)) return;
        if (!(isHandlerItem(item))) return;

        if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            this.onRightClick(e);
            return;
        }

        if (e.getAction() == Action.LEFT_CLICK_AIR || e.getAction() == Action.LEFT_CLICK_BLOCK ){
            this.onLeftClick(e);
        }
    }

    public void giveCooldown(Player player, ItemStack item) {
        final var uuid = PersistentData.getProperty(item.getItemMeta(), PersistentDataKey.UUID).asUUID();
        if (uuid == null) return;

        final var key = new NamespacedKey(plugin, this.key + "." + uuid);

        final var itemMeta = item.getItemMeta();
        final var useCooldown = itemMeta.getUseCooldown();
        final var cooldownSeconds = useCooldown.getCooldownSeconds();
        final var cooldownTicks =  (int) cooldownSeconds * 20;
        player.setCooldown(key, cooldownTicks);
    }

    protected abstract void onRightClick(PlayerInteractEvent e);

    protected abstract void onLeftClick(PlayerInteractEvent e);
}

