package net.fortresswars.ui.inventory.menus;

import net.fortresswars.helpers.EntityHelper;
import net.fortresswars.ui.inventory.MenuUI;
import net.fortresswars.ui.inventory.buttons.Button;
import net.fortresswars.ui.inventory.buttons.ButtonListener;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;

/**
 * The {@link MenuListener} provides reusable core logic for version-specific MenuUI inventory listeners.
 * This class is based on SGMenuListenerBase.java from <a href="https://github.com/SamJakob/SpiGUI">...</a>
 */
public class MenuListener implements Listener {

    private @NotNull final MenuUI menuUI;

    /**
     * Initialize an BaseMenuListener for the specified {@link MenuUI} instance.
     * @param menuUI that this listener is registered for.
     */
    public MenuListener(@NotNull MenuUI menuUI) {
        this.menuUI = menuUI;
    }

    /**
     * Returns true if the specified inventory exists and is a Menu, as that implies the inventory event should be
     * handled by this {@link MenuListener} class.
     * @param inventory to check.
     * @return true if inventory event should be handled by {@link MenuListener}, false if not.
     */
    protected boolean isMenu(@Nullable Inventory inventory) {
        return inventory != null && inventory.getHolder() != null && inventory.getHolder() instanceof Menu;
    }

    /**
     * In addition to the tests done by {@link #isMenu(Inventory)}, this method checks whether the instance of
     * {@link MenuUI} that this listener is listening on behalf of, holds a different plugin to the plugin that the
     * inventory is for. If the {@code inventory} is not an {@link Menu}, or it is held by a different plugin, the
     * event should be ignored by this listener instance.
     *
     * @param inventory to check.
     * @return False if the inventory event is for this plugin, true if not.
     */
    protected boolean shouldIgnoreGUI(@Nullable Inventory inventory) {
        if (inventory == null) return true;
        if (inventory.getHolder() == null) return true;
        if (!isMenu(inventory)) return true;
        return !Objects.equals(((Menu) inventory.getHolder()).getOwner(), menuUI.getOwner());
    }

    /**
     * Handles the main click event for an {@link Menu}.
     *
     * <p>This is a protected method, intended to be delegated to by subclasses of this class and {@link Listener}, to
     * re-use common logic across versions whilst providing an avenue for version-specific overrides.
     *
     * <p>The respective inventory is first checked to ensure that it is a SpiGUI {@link Menu} and, if it is, whether
     * a pagination button was clicked, finally (if not a pagination button) the event is delegated to the inventory the
     * click occurred in.
     *
     * @param event to handle.
     */
    protected void handleClick(@NotNull InventoryClickEvent event) {
        // Check if the inventory click event is one we should even care about (i.e., that the inventory is actually a
        // SpiGUI owned by the current plugin). Then, get the Menu instance that backs the inventory.
        final var inventory = event.getClickedInventory();
        if (shouldIgnoreGUI(inventory)) return;

        final var menu = (Menu) inventory.getHolder();
        final var whoClicked = event.getWhoClicked();
        if (EntityHelper.hasInternalCooldown(whoClicked, menu.getKey())) return;

        // Snapshot information like the page as soon as possible to ensure it is correct by the time the event is
        // handled.
        final var page = menu.getCurrentPage();
        final var bukkitSlot = event.getSlot();
        final var pageSize = menu.getPageSize();

        // Set up an ButtonListener Consumer that can be used to invoke a listener where we want to.
        final Consumer<ButtonListener> invokeListener = listener -> listener.onClick(event);

        // Handle Frame Buttons
        final var frameButton = menu.getFrameButton(page, bukkitSlot);
        if (handleClickButton(event, menu, frameButton)) return;

        // Finally, handle the button normally.
        final var menuSlot = menu.toMenuSlot(bukkitSlot);
        final var button = menu.getButton(page, menuSlot);
        if (handleClickButton(event, menu, frameButton)) return;

        // If the button wasn't clicked deny the click event
        event.setResult(Event.Result.DENY);
    }

    /**
     * Handle the click event for a button
     * @param event the inventory click event
     * @param menu the menu
     * @param button the button
     * @return true if the button was successfully clicked, false otherwise.
     */
    private boolean handleClickButton(@NotNull InventoryClickEvent event, @NotNull Menu menu, @Nullable Button button) {
        if (button == null) return false;
        final var listener = button.getListener();
        if (listener == null) return false;
        listener.onClick(event);
        final var whoClicked = event.getWhoClicked();
        EntityHelper.setInternalCooldown(whoClicked, menu.getKey(), 250);
        return true;
    }

    /**
     * Blocks events that occur in adjacent inventories to a Menu when those events would affect the Menu. (For
     * example, double-clicking on an item in the player's inventory that is the same as an item in the Menu).
     * @param event to handle.
     */
    protected void handleAdjacentClick(@NotNull InventoryClickEvent event) {
        // If the clicked inventory is not adjacent to a SpiGUI menu, ignore the click event.
        if (shouldIgnoreGUI(event.getView().getTopInventory())) return;

        // If the clicked inventory is the SpiGUI menu (the top inventory),
        // ignore the click event (it will be handled by handleClick).
        if (event.getClickedInventory() == event.getView().getTopInventory()) return;

        // Otherwise, the clicked menu was the bottom inventory, and it should be canceled.
        event.setResult(Event.Result.DENY);
    }

    /**
     * Blocks drag events in an {@link Menu} and between an {@link Menu} and an adjacent inventory.
     * @param event to handle.
     */
    protected void handleDrag(@NotNull InventoryDragEvent event) {
        if (shouldIgnoreGUI(event.getInventory())) return;
        final Menu menu = (Menu) event.getInventory().getHolder();

        // Cancel the drag event if any of the affected slots are in the
        // SpiGUI menu (the top inventory).
        if (slotsIncludeTopInventory(event.getView(), event.getRawSlots())) {
            event.setResult(Event.Result.DENY);
        }
    }

    /**
     * Overrides the close event for a Menu, ensuring the {@link Menu#getOnClose()} handler is invoked when the
     * inventory is closed.
     * @param event to handle.
     */
    protected void handleClose(@NotNull InventoryCloseEvent event) {
        if (shouldIgnoreGUI(event.getInventory())) return;
        final Menu menu = (Menu) event.getInventory().getHolder();
        if (menu == null) return;

        // Invoke the inventory's onClose if there is one.
        Optional.ofNullable(menu.getOnClose()).ifPresent(onClose -> onClose.accept(event));
    }

    /**
     * Handles the main click event for an {@link Menu}.
     *
     * @param event to handle.
     * @see #handleClick(InventoryClickEvent)
     */
    @EventHandler
    public void onInventoryClick(@NotNull InventoryClickEvent event) {
        this.handleClick(event);
    }

    /**
     * Blocks events that occur in adjacent inventories to an Menu when those events would affect the Menu. (For
     * example, double-clicking on an item in the player's inventory that is the same as an item in the Menu).
     *
     * <p>It is recommended that the event listener that invokes this method be defined with
     * {@link org.bukkit.event.EventPriority#LOWEST}, meaning that the event handler will be invoked first (allowing
     * subsequent event handlers to override it).
     *
     * @param event to handle.
     * @see #handleAdjacentClick(InventoryClickEvent)
     */
    @EventHandler(priority = EventPriority.LOWEST)
    public void onAdjacentInventoryClick(@NotNull InventoryClickEvent event) {
        this.handleAdjacentClick(event);
    }

    /**
     * Blocks drag events in an {@link Menu} and between an {@link Menu} and an adjacent inventory.
     *
     * <p>It is recommended that the event listener that invokes this method be defined with
     * {@link org.bukkit.event.EventPriority#LOWEST}, meaning that the event handler will be invoked first (allowing
     * subsequent event handlers to override it).
     *
     * @param event to handle.
     * @see #handleDrag(InventoryDragEvent)
     */
    @EventHandler(priority = EventPriority.LOWEST)
    public void onInventoryDrag(@NotNull InventoryDragEvent event) {
        this.handleDrag(event);
    }

    /**
     * Overrides the close event for a Menu, ensuring the {@link#getOnClose()} handler is invoked when the
     * inventory is closed.
     *
     * @param event to handle.
     * @see #handleClose(InventoryCloseEvent)
     */
    @EventHandler
    public void onInventoryClose(@NotNull InventoryCloseEvent event) {
        this.handleClose(event);
    }

    /**
     * Checks whether the specified set of slots includes any slots in the top inventory of the specified
     * {@link InventoryView}.
     *
     * @param view The relevant {@link InventoryView}.
     * @param slots The set of slots to check.
     * @return True if the set of slots includes any slots in the top inventory, otherwise false.
     */
    private boolean slotsIncludeTopInventory(@NotNull InventoryView view, @NotNull Set<Integer> slots) {
        return slots.stream().anyMatch(slot -> {
            // If the slot is bigger than the SpiGUI menu's page size,
            // it's a pagination button, so we'll ignore it.
            if (slot >= view.getTopInventory().getSize()) return false;
            // Otherwise, we'll check if the slot's converted value matches
            // its raw value. If it matches, it means the slot is in the
            // SpiGUI menu, so we'll return true.
            return slot == view.convertSlot(slot);
        });
    }
}
