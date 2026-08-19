package net.fortresswars.core.ui.inventory.menus;

import net.fortresswars.core.ui.inventory.InventoryGUI;
import net.fortresswars.core.ui.inventory.buttons.Button;
import net.fortresswars.core.ui.inventory.toolbars.DefaultFrameBuilder;
import net.fortresswars.core.ui.inventory.toolbars.FrameBuilder;
import net.fortresswars.core.ui.inventory.toolbars.FrameButtonType;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jspecify.annotations.NonNull;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Predicate;

public abstract class InventoryMenu implements InventoryHolder {

    private @NotNull final NamespacedKey key;
    private @NotNull final InventoryGUI inventoryGUI;
    private @NotNull final List<Button> items;
    private @Nullable List<Button> viewedItems;
    private final int rowsPerPage;

    private Component name;
    private int currentPage;
    private @NotNull FrameBuilder frameBuilder;
    private int filterIndex;
    private Predicate<Button> filter;
    private int sortIndex;
    private Comparator<Button> sort;
    private Consumer<InventoryCloseEvent> onClose;
    private Consumer<InventoryMenu> onPageChange;

    /**
     * Menu is used to implement the library's GUIs.
     * This class is based on SGMenu.java from <a href="https://github.com/SamJakob/SpiGUI">...</a>
     */
    public InventoryMenu(@NotNull InventoryGUI inventoryGUI, int rowsPerPage) {
        this.inventoryGUI = inventoryGUI;
        this.name = Component.text("Loading...", NamedTextColor.GRAY).decoration(TextDecoration.ITALIC, false);
        this.rowsPerPage = Math.clamp(rowsPerPage, 1, 4);
        this.items = new LinkedList<>();
        this.viewedItems = new LinkedList<>();
        this.currentPage = 0;
        this.frameBuilder = new DefaultFrameBuilder();
        this.key = new NamespacedKey(inventoryGUI.getOwner(), "menu_" + UUID.randomUUID());
        this.filterIndex = -1;
        this.sortIndex = -1;
    }

    /**
     * Called to build the menu for a player
     * @param player the player opening the menu
     * @return a completable future for the task to build the inventory.
     */
    public abstract CompletableFuture<Void> build(Player player);

    /**
     * Get the name of the menu after it has been loaded.
     * @param player the player opening the menu.
     * @return the name as a component.
     */
    public abstract Component getPostLoadedName(Player player);

    public void setFrameBuilder(@NonNull FrameBuilder frameBuilder) {
        this.frameBuilder = frameBuilder;
    }

    public @NotNull FrameBuilder getFrameBuilder() {
        return this.frameBuilder;
    }

    // -- INVENTORY OWNER -- //

    /**
     * Returns the plugin that the inventory is associated with. As this field is final, this would be the plugin that
     * created the inventory.
     *
     * @return The plugin the inventory is associated with.
     */
    public @NotNull JavaPlugin getOwner() {
        return inventoryGUI.getOwner();
    }

    /**
     * Return the menu key
     * @return the key of the menu
     */
    public @NotNull NamespacedKey getKey() {
        return key;
    }

    // -- INVENTORY SIZE -- //

    /**
     * Returns the number of rows (of 7 columns) per page of the inventory. If you want the total number of slots on a
     * page, you should use {@link #getPageSize()} instead.
     *
     * @return The number of rows per page.
     */
    public int getRowsPerPage() {
        return rowsPerPage;
    }

    /**
     * Returns the number of slots per page of the inventory.
     *
     * <p>So for example if {@link #getRowsPerPage()} was 3, this would be 21, as Menus have rows of 7 columns.
     *
     * @return The number of inventory slots per page.
     */
    public int getPageSize() {
        return rowsPerPage * 7;
    }

    // -- INVENTORY NAME -- //

    /**
     * This sets the inventory's display name using a component.
     * @param name The display name to set.
     */
    public void setName(Component name) {
        this.name = name;
    }

    /**
     * This sets the inventory's display using a string
     * @param name The display name to set.
     */
    public void setRawName(String name) {
        this.name = Component.text(name);
    }

    /**
     * This returns the inventory's display name.
     * @return The inventory's display name.
     */
    public Component getName() {
        return name;
    }

    // -- BUTTONS -- //

    /**
     * Adds the provided {@link Button}.
     *
     * @param button The button to add.
     */
    public void addButton(Button button) {
        this.items.add(button);
    }

    /**
     * Adds the specified {@link Button}s consecutively.
     *
     * @param buttons The buttons to add.
     */
    public void addButtons(Button... buttons) {
        for (Button button : buttons) addButton(button);
    }

    /**
     * Adds the provided {@link Button} at the position denoted by the supplied slot parameter.
     *
     * <p>If you specify a value larger than the value of the first page, pagination will be automatically applied when
     * the inventory is rendered. An alternative to this is to use {@link #setButton(int, int, Button)}.
     *
     * @see #setButton(int, int, Button)
     * @param slot The desired location of the button.
     * @param button The button to add.
     */
    public void setButton(int slot, Button button) {
        items.set(slot, button);
    }

    /**
     * Adds the provided {@link Button} at the position denoted by the supplied slot parameter <i>on the page denoted
     * by the supplied page parameter</i>.
     *
     * <p>This is an alias for {@link #setButton(int, Button)}, however one where the slot value is mapped to the
     * specified page. So if page is 2 (the third page) and the inventory row count was 3 (so a size of 27), a supplied
     * slot value of 3 would actually map to a slot value of (2 * 27) + 3 = 54. The mathematical formula for this is
     * <code>(page * pageSize) + slot</code>.
     *
     * <p>If the slot value is out of the bounds of the specified page, this function will do nothing.
     *
     * @see #setButton(int, Button)
     * @param page The page to which the button should be added.
     * @param slot The position on that page the button should be added at.
     * @param button The button to add.
     */
    public void setButton(int page, int slot, Button button) {
        if (slot < 0 || slot > getPageSize()) return;
        setButton((page * getPageSize()) + slot, button);
    }

    /**
     * Removes a button from the specified slot.
     *
     * @param slot The slot containing the button you wish to remove.
     */
    public void removeButton(int slot) {
        items.remove(slot);
    }

    /**
     * An alias for {@link #removeButton(int)} to remove a button from the specified slot on the specified page.
     *
     * <p>If the slot value is out of the bounds of the specified page, this function will do nothing.
     *
     * @param page The page containing the button you wish to remove.
     * @param slot The slot, of that page, containing the button you wish to remove.
     */
    public void removeButton(int page, int slot) {
        final var pageSize = getPageSize();
        if (slot < 0 || slot > pageSize) return;
        removeButton((page * pageSize) + slot);
    }

    /**
     * Returns the {@link Button} in the specified slot using the menu slot number.
     *
     * <p>If you attempt to get a slot less than 0 or greater than the slot containing the button at the greatest slot
     * value, this will return null.
     *
     * @param slot The menu slot containing the button you wish to get.
     * @return The {@link Button} that was in that slot or null if the slot was invalid or if there was no button that
     *     slot.
     */
    public Button getButton(int slot) {
        if (slot < 0 || slot > getHighestFilledSlot()) return null;
        return Objects.requireNonNullElse(this.viewedItems, this.items).get(slot);
    }

    /**
     * This is an alias for {@link #getButton(int)} that allows you to get a button contained by a slot on a
     * given page using the menu slot number.
     *
     * @param page The page containing the button.
     * @param slot The menu slot, on that page, containing the button.
     * @return The {@link Button} that was in that slot or null if the slot was invalid or if there was no button that
     * slot.
     */
    public Button getButton(int page, int slot) {
        final var pageSize = getPageSize();
        if (slot < 0 || slot > pageSize) return null;
        return getButton((page * pageSize) + slot);
    }

    /**
     * Get the frame button of the slot using the bukkit inventory indexing.
     * @param slot The page containing the button.
     * @param page The Bukkit slot, on that page, containing the button.
     * @return The frame {@link Button} that was in that slot or null if it is not a frame button.
     */
    public Button getFrameButton(int page, int slot) {
        if (!DefaultFrameBuilder.VALID_FRAME_SLOTS.contains(slot)) return null;
        final var frameBuilder = this.getFrameBuilder();
        final var frameType = FrameButtonType.getDefaultForSlot(slot);
        final var button = frameBuilder.buildFrameButton(slot, page, frameType, this);
        if (button != null) return button;
        return Button.getEmptyButton();
    }

    // -- EVENTS -- //

    /**
     * The action to be performed on close.
     *
     * @return The action to be performed on close.
     * @see #setOnClose(Consumer)
     */
    public Consumer<InventoryCloseEvent> getOnClose() {
        return this.onClose;
    }

    /**
     * Used to set an action to be performed on inventory close without registering an
     * {@link org.bukkit.event.inventory.InventoryCloseEvent} specifically for this inventory.
     *
     * @param onClose The action to be performed on close.
     */
    public void setOnClose(Consumer<InventoryCloseEvent> onClose) {
        this.onClose = onClose;
    }

    /**
     * The action to be performed on page change.
     *
     * @return The action to be performed on page change.
     * @see #setOnPageChange(Consumer)
     */
    public Consumer<InventoryMenu> getOnPageChange() {
        return this.onPageChange;
    }

    /**
     * Used to set an action to be performed on inventory page change.
     *
     * @param onPageChange The action to be performed on page change.
     */
    public void setOnPageChange(Consumer<InventoryMenu> onPageChange) {
        this.onPageChange = onPageChange;
    }

    // -- PAGINATION -- //

    /**
     * Returns the current page of the inventory. This is the page that will be displayed when the inventory is opened
     * and displayed to a player (i.e. rendered).
     *
     * <p>The value returned by {@code getCurrentPage} and accepted by {@link #setCurrentPage(int)} is zero-indexed -
     * that is, the first page is 0. The analogue for getting the maximum page is {@link #getMaxPage()}
     *
     * <p>Unfortunately, the historic behavior for {@link #getMaxPage()} is confusingly that it would be one-indexed not
     * zero-indexed - hence the deprecation (for clarity) - and it is anticipated that simply changing the behavior of
     * that method would be subtle yet disastrous.
     *
     * @return The current page of the inventory.
     * @see #getMaxPage()
     */
    public int getCurrentPage() {
        return currentPage;
    }

    /**
     * Sets the page of the inventory that will be displayed when the inventory is opened and displayed to a player
     * (i.e. rendered).
     *
     * @param page The new current page of the inventory.
     */
    public void setCurrentPage(int page) {
        this.currentPage = page;
    }

    /**
     * Get the maximum page number that can be displayed.
     * @return the maximum page number.
     */
    public int getMaxPage() {
        final var highestFilledSlot = getHighestFilledSlot();
        final var pageSize = getPageSize();
        return Math.max(0, highestFilledSlot) / pageSize;
    }

    /**
     * Gets the Bukkit inventory slot number from the menu item slot number
     * @param menuSlot the menu slot number stored in this menu.
     * @return the Bukkit inventory api slot number.
     */
    public int toBukkitSlot(int menuSlot) {
        if (menuSlot < 0 || menuSlot >= getPageSize()) return -1;
        final var row = menuSlot / 7;
        final var col = menuSlot % 7;
        return (row + 1) * 9 + (col + 1);
    }

    /**
     * Gets the Menu inventory slot number from the menu item slot number
     * @param bukkitSlot the bukkit slot number stored in this menu.
     * @return the menu slot number.
     */
    public int toMenuSlot(int bukkitSlot) {
        final var row = bukkitSlot / 9;
        final var col = bukkitSlot % 9;
        if (row < 1 || row > this.rowsPerPage || col < 1 || col > 7) return -1;
        return (row - 1) * 7 + (col - 1);
    }

    /**
     * Returns the slot number of the highest filled slot post filtering. This is mainly used to calculate the number of
     * pages there  needs to be to display the GUI's contents in the rendered inventory.
     * @return The highest filled slot's number.
     */
    public int getHighestFilledSlot() {
        return Objects.requireNonNullElse(this.viewedItems, this.items).size() - 1;
    }

    /**
     * Increments the current page. This will automatically refresh the inventory by calling
     * {@link #refreshInventory(HumanEntity)} if the page was changed.
     *
     * @param viewer The {@link HumanEntity} viewing the inventory.
     * @return Whether the page could be changed (false means the max page is currently open).
     */
    public boolean nextPage(HumanEntity viewer) {
        if (currentPage < getMaxPage()) {
            currentPage++;
            refreshInventory(viewer);
            if (this.onPageChange != null) this.onPageChange.accept(this);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Decrements the current page. This will automatically refresh the inventory by calling
     * {@link #refreshInventory(HumanEntity)} if the page was changed.
     *
     * @param viewer The {@link HumanEntity} viewing the inventory.
     * @return Whether the page could be changed (false means the first page is currently open).
     */
    public boolean previousPage(HumanEntity viewer) {
        if (currentPage > 0) {
            currentPage--;
            refreshInventory(viewer);
            if (this.onPageChange != null) this.onPageChange.accept(this);
            return true;
        } else {
            return false;
        }
    }

    // -- Sounds -- //

    public void playClickSound(HumanEntity humanEntity) {
        if (!(humanEntity instanceof Player player)) return;
        Bukkit.getScheduler().runTask(getOwner(), () -> player.playSound(player, Sound.UI_BUTTON_CLICK, 0.5f, 1f));
    }

    public void playSuccessSound(HumanEntity humanEntity) {
        if (!(humanEntity instanceof Player player)) return;
        Bukkit.getScheduler().runTask(getOwner(), () -> player.playSound(player, Sound.BLOCK_NOTE_BLOCK_BELL, 0.5f, 1f));
    }

    public void playFailSound(HumanEntity humanEntity) {
        if (!(humanEntity instanceof Player player)) return;
        Bukkit.getScheduler().runTask(getOwner(), () -> player.playSound(player, Sound.BLOCK_NOTE_BLOCK_DIDGERIDOO, 0.5f, 0f));
    }

    // -- Filter -- //

    public void setFilter(int filterIndex, Predicate<Button> filter) {
        this.filterIndex = filterIndex;
        this.filter = filter;
    }
    
    public void removeFilter() {
        this.filterIndex = -1;
        this.filter = null;
    }
    
    public boolean hasFilter() {
        return this.filter != null;
    }

    public Predicate<Button> getFilter() {
        return this.filter;
    }
    
    public int getFilterIndex() {
        return this.filterIndex;
    }

    // -- Sort -- //

    public void setSort(int sortIndex, Comparator<Button> sort) {
        this.sortIndex = sortIndex;
        this.sort = sort;
    }
    
    public void removeSort() {
        this.sortIndex = -1;
        this.sort = null;
    }

    public boolean hasSort() {
        return this.sort != null;
    }

    public Comparator<Button> getSort() {
        return this.sort;
    }

    public int getSortIndex() {
        return this.sortIndex;
    }

    // -- INVENTORY API -- //

    /**
     * Refresh an inventory that is currently open for a given viewer.
     *
     * <p>This method checks if the specified viewer is looking at an {@link InventoryMenu} and, if they are, it refreshes the
     * inventory for them.
     *
     * @param viewer The viewer of the open inventory.
     */
    public void refreshInventory(HumanEntity viewer) {
        // If the open inventory isn't a Menu - or if it isn't this inventory, do nothing.
        final var openInventory = viewer.getOpenInventory();
        final var openTopInventory = openInventory.getTopInventory();
        final var inventoryHolder = openTopInventory.getHolder();
        if (inventoryHolder != this) return;

        // Get new inventory
        final var newInventory = getInventory();

        // If the name has changed, we'll need to open a new inventory.
        if (!openInventory.title().equals(name)) {
            viewer.openInventory(newInventory);
            return;
        }

        // Otherwise, we can refresh the contents without re-opening the inventory.
        final var newContents = newInventory.getContents();
        openTopInventory.setContents(newContents);
    }

    @Override
    public @NotNull Inventory getInventory() {
        final var bukkitPageSize = (this.rowsPerPage + 2) * 9;
        final var inventory = Bukkit.createInventory(this, bukkitPageSize, name);

        // Process the items
        final var filter = this.getFilter();
        var itemStream = this.items.stream()
                .filter((item) -> {
                    if (item == null) return false;
                    return filter == null || filter.test(item);
                });

        // Sort
        if (sort != null) {
            final var sort = this.getSort();
            itemStream = itemStream.sorted(sort);
        }

        // Consume the stream and assign to the filtered items (used for dynamic max page)
        this.viewedItems = itemStream.toList();

        // Ensure we are not on a page with no items!
        final var maxPage = this.getMaxPage();
        if (this.currentPage > maxPage) {
            this.currentPage = maxPage;
        }

        // Set the frame
        final var frameBuilder = getFrameBuilder();
        for (final int slot : DefaultFrameBuilder.VALID_FRAME_SLOTS) {
            final var frameButton = this.getFrameButton(currentPage, slot);
            if (frameButton == null) continue;
            inventory.setItem(slot, frameButton.getIcon());
        }

        // Stream for the inventory view
        final var pageSize = getPageSize();
        this.viewedItems.stream()
                .skip((long) this.currentPage * pageSize)
                .limit(pageSize)
                .map(Button::getIcon)
                .forEach(inventory::addItem);

        return inventory;
    }
}
