package net.fortresswars.ui.inventory.buttons;

import org.bukkit.event.inventory.InventoryClickEvent;
import org.jetbrains.annotations.NotNull;

/**
 * Holds the event handler for an SGButton.
 * This interface is based on SGButtonListener.java from <a href="https://github.com/SamJakob/SpiGUI">...</a>
 */
public interface ButtonListener {

    /**
     * The event handler that should be executed when a Button is clicked. Implement this with a
     * lambda when you  create a Button.
     *
     * @param event The Bukkit/Spigot API {@link InventoryClickEvent}.
     */
    void onClick(@NotNull InventoryClickEvent event);
}
