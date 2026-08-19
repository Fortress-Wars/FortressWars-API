package net.fortresswars.core.ui.inventory;

import net.fortresswars.core.ui.inventory.menus.InventoryMenu;
import net.fortresswars.core.ui.inventory.menus.InventoryMenuListener;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class InventoryGUI {

    private @NotNull
    final JavaPlugin plugin;

    /**
     * The core class for the MenuUI library.
     * This class is based on SGMenu.java from <a href="https://github.com/SamJakob/MenuUI">...</a>
     *
     * <p>One instance of the MenuUI class is registered for each plugin using it.
     *
     * <p>The expected usage of MenuUI is that you register a MenuUI instance for your plugin with <code>new MenuUI(this);
     * </code> in your class that extends <code>JavaPlugin</code>. You can then use the instance you've created throughout
     * your project to create GUIs that use MenuUI.
     */
    public InventoryGUI(@NotNull JavaPlugin plugin) {
        this.plugin = plugin;
        final var listener = new InventoryMenuListener(this);
        Bukkit.getPluginManager().registerEvents(listener, plugin);
    }

    /**
     * Open the inventory
     * @param menu the menu to open
     * @param player the player that should view the menu
     */
    public void open(InventoryMenu menu, Player player) {
        final var inventory = menu.getInventory();
        player.openInventory(inventory);
        final CompletableFuture<Void> buildFuture = menu.build(player);
        buildFuture.thenAccept((unused) -> {
            // Refresh Synchronously
            final var name = menu.getPostLoadedName(player);
            menu.setName(name);
            Bukkit.getScheduler().runTask(plugin, () -> menu.refreshInventory(player));
        }).exceptionally((e) -> {
            plugin.getLogger().warning("Error opening menu: " +  e.getMessage());
            Bukkit.getScheduler().runTask(plugin, () -> menu.refreshInventory(player));
            return null;
        });
    }

    /**
     * Returns the plugin that this instance of MenuUI was registered with.
     * @return the plugin for this MenuUI instance.
     */
    @NotNull
    public JavaPlugin getOwner() {
        return this.plugin;
    }

}
