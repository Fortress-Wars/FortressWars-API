package net.fortresswars.core.ui.inventory.buttons;

import net.fortresswars.core.ui.inventory.InventoryGUI;
import net.fortresswars.core.items.ItemStackFactory;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.Objects;

/**
 * A Button represents a clickable item in a Menu (GUI). It consists of an icon ({@link ItemStack}) and a listener
 * ({@link Button}).
 * This class is based on SGButton.java from <a href="https://github.com/SamJakob/SpiGUI">...</a>
 *
 * <p>When the icon is clicked in the Menu, the listener is called, thus allowing for rudimentary menus to be built by
 * displaying icons and overriding their behavior.
 *
 * <p>This somewhat resembles the point-and-click nature of Graphical User Interfaces (GUIs) popularized by Operating
 * Systems developed in the late 80s and 90s which is where the name of the concept in Spigot plugins was derived.
 */
public class Button {

    /** The on-click handler for this button. */
    @Nullable
    private ButtonListener listener;

    /** The Bukkit {@link ItemStack} that will be used as the button's icon. */
    @NotNull
    private ItemStack icon;

    /**
     * Creates a Button with the specified {@link ItemStack} as it's 'icon' in the inventory.
     *
     * @param icon The desired 'icon' for the Button.
     */
    public Button(@NotNull ItemStack icon) {
        this.icon = validateIcon(icon);
    }

    /**
     * Sets the {@link ButtonListener} to be called when the button is clicked.
     *
     * @param listener The listener to be called when the button is clicked.
     */
    public void setListener(@Nullable ButtonListener listener) {
        this.listener = listener;
    }

    /**
     * A chainable alias of {@link #setListener(ButtonListener)}.
     *
     * @param listener The listener to be called when the button is clicked.
     * @return The {@link Button} the listener was applied to.
     */
    public Button withListener(@Nullable ButtonListener listener) {
        this.listener = listener;
        return this;
    }

    /**
     * Returns the {@link ButtonListener} that is to be executed when the button is clicked.
     *
     * <p>This is typically intended for internal use by the main {@link InventoryGUI} API.
     *
     * @return The listener to be called when the button is clicked.
     */
    @Nullable
    public ButtonListener getListener() {
        return listener;
    }

    /**
     * Returns the {@link ItemStack} that will be used as the Button's icon in the Menu (GUI).
     *
     * @return The icon ({@link ItemStack}) that will be used to represent the button.
     */
    @NotNull
    public ItemStack getIcon() {
        return icon;
    }

    /**
     * Changes the Button's icon.
     *
     * @param icon The icon ({@link ItemStack}) that will be used to represent the button.
     */
    public void setIcon(@NotNull ItemStack icon) {
        this.icon = validateIcon(icon);
    }

    /**
     * Ensure that the {@link ItemStack} will be a suitable icon.
     *
     * @param icon to check.
     * @return the icon, if it is suitable.
     * @throws IllegalArgumentException if the icon is not suitable.
     * @throws NullPointerException if the icon is null.
     */
    @NotNull
    private ItemStack validateIcon(@NotNull ItemStack icon) {
        if (icon.getType() == Material.AIR) {
            throw new IllegalArgumentException("Cannot use AIR as icon.");
        }

        return Objects.requireNonNull(icon, "Don't use a null icon - remove the button instead.");
    }

    public static Button getEmptyButton() {
        final var item = ItemStackFactory.create(Material.GRAY_STAINED_GLASS_PANE)
                .setTitle(Component.text(""))
                .build();
        return new Button(item);
    }
}
