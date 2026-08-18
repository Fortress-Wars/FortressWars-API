package net.fortresswars.ui.inventory;

import net.fortresswars.ui.inventory.menus.Menu;
import net.kyori.adventure.text.Component;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public class MenuUI {

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
    public MenuUI(@NotNull JavaPlugin plugin) {
        this.plugin = plugin;
    }

    /**
     * Creates an inventory with a given name, tag and number of rows. The display name is color code translated.
     * @param name The display name of the inventory.
     * @param rows The number of rows the inventory should have per page.
     * @return The created inventory.
     */
    public Menu create(Component name, int rows) {
        return new Menu(this, name, rows);
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
