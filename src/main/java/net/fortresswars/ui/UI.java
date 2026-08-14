package net.fortresswars.ui;

import com.samjakob.spigui.SpiGUI;
import com.samjakob.spigui.buttons.SGButton;
import com.samjakob.spigui.buttons.SGButtonListener;
import com.samjakob.spigui.menu.SGMenu;
import com.samjakob.spigui.toolbar.SGToolbarButtonType;
import net.fortresswars.core.items.ItemStackFactory;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.plugin.java.JavaPlugin;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.function.Predicate;

// TODO: Implement our own menu api

public abstract class UI {

    private final JavaPlugin plugin;
    private final SpiGUI spigui;
    private Instant lastClickedInstant;

    private static final String LOADING_TEXT = "&8Loading...";

    private final Map<Integer, SGButton> itemCache;

    public UI(JavaPlugin plugin, SpiGUI spigui) {
        this.plugin = plugin;
        this.spigui = spigui;
        itemCache = new HashMap<>();
    }

    protected abstract String getTitle(Player player);

    protected abstract int getRows();

    protected abstract CompletableFuture<Void> build(SGMenu menu, Player player);

    public void open(Player player) {
        final int rows = this.getRows();
        final SGMenu menu = this.spigui.create(LOADING_TEXT, rows - 1);
        menu.setBlockDefaultInteractions(true);
        menu.setAutomaticPaginationEnabled(true);
        setFrame(menu);
        setToolBar(menu);

        // Open
        player.openInventory(menu.getInventory());
        final CompletableFuture<Void> buildFuture = this.build(menu, player);
        buildFuture.thenAccept((unused) -> {
            final String title = this.getTitle(player);
            menu.setName(title);

            // Refresh Synchronously
            Bukkit.getScheduler().runTask(plugin, () -> menu.refreshInventory(player));
        }).exceptionally((e) -> {
            plugin.getLogger().warning("Error opening menu: " +  e.getMessage());
            Bukkit.getScheduler().runTask(plugin, () -> menu.refreshInventory(player));
            return null;
        });
    }

    public int getSlotCount(SGMenu menu) {
        final int maxPage = menu.getMaxPage();
        final int pageSize = menu.getPageSize();
        return pageSize * (maxPage + 1);
    }

    private int getNextEmptySlot(SGMenu menu) {
        final int slotCount = getSlotCount(menu);
        for (int slot = 0; slot < slotCount; slot++) {
            if (isSlotEmpty(menu, slot)) {
                return slot;
            }
        }
        // If we get here it is because the pages are perfectly filled.
        // The next index is the first slot on a new page. If a page has a
        // size of 9, then the slots on page 0 are 0-8, so the next empty
        // slot is slot 9.
        return slotCount;
    }

    /**
     * Get the list of items.
     * @param menu the menu
     * @return the list of items
     */
    protected List<SGButton> getItems(SGMenu menu) {
        // Use get page with page and slot, so search is O(n)
        final List<SGButton> items = new LinkedList<>();
        final var slotCount = this.getSlotCount(menu);
        for (int slot = 0; slot < slotCount; slot++) {
            if (!isSlotEmpty(menu, slot)) continue;
            final var item = this.itemCache.get(slot);
            if (item == null) break;
            items.add(item);
        }
        return items;
    }

    private boolean isSlotEmpty(SGMenu menu, int slot) {
        final var normalizedStickiedSlot = slot % menu.getPageSize();
        return !menu.isStickiedSlot(normalizedStickiedSlot) && menu.getButton(slot) == null;
    }

    private SGButton getFrameButton() {
        return new SGButton(
                ItemStackFactory.create(Material.GRAY_STAINED_GLASS_PANE)
                        .setTitle(Component.text(""))
                        .build()
        ).withListener(e -> e.setResult(Event.Result.DENY));
    }

    protected void setFrame(SGMenu sgMenu) {
        final SGButton borderButton = getFrameButton();
        final HashSet<Integer> borderSlots = new HashSet<>(Set.of(0, 1, 2, 3, 4, 5, 6, 7, 8));

        // Start at the second row and end at the second to last row, since the first and
        // last rows are already filled with the border
        for (int row = 2; row < getRows(); row++) {
            borderSlots.add(9 * (row - 1));
            borderSlots.add((9 * row) - 1);
        }

        final var filter = getFilterButton(sgMenu);
        if (filter != null) {
            final var filterSlot = 17;
            borderSlots.remove(filterSlot);
            sgMenu.setButton(filterSlot, filter);
            sgMenu.stickSlot(filterSlot);
        }

        for (int slot : borderSlots) {
            sgMenu.setButton(slot, borderButton);
            sgMenu.stickSlot(slot);
        }
    }

    protected SGButton getFilterButton(SGMenu menu) {
        return null;
    }

    protected void applyFilter(Player player, SGMenu menu, Predicate<SGButton> filter) {
        menu.clearAllButStickiedSlots();
        final var items = this.getItems(menu);
        int slot = 0;
        for (final var item : items) {
            if (filter != null && !filter.test(item)) continue;
            slot = this.insertButton(menu, item, slot, false);
        }
        menu.refreshInventory(player);
    }

    protected void removeFilter(Player player, SGMenu menu) {
        this.applyFilter(player, menu, null);
    }

    /**
     * Insert a button. This will add the button to the next empty slot.
     * @param menu the menu
     * @param button the button to add
     * @return the slot the button was inserted into.
     */
    public int insertButton(SGMenu menu, SGButton button) {
        return insertButton(menu, button, true);
    }

    /**
     * Insert a button. This will add the button to the next empty slot.
     * @param menu the menu
     * @param button the button to add
     * @param addToCache if the button should be added to cache
     * @return the slot the button was inserted into.
     */
    public int insertButton(SGMenu menu, SGButton button, boolean addToCache) {
        return insertButton(menu, button, 0, addToCache);
    }

    /**
     * Insert a button. This will add the button to the next empty slot.
     * @param menu the menu
     * @param button the button to add
     * @param slot the starting slot
     * @param addToCache if the button should be added to cache
     * @return the slot the button was inserted into.
     */
    public int insertButton(SGMenu menu, SGButton button, int slot, boolean addToCache) {
        final var slotCount = this.getSlotCount(menu);
        for (; slot < slotCount; slot++) {
            if (isSlotEmpty(menu, slot)) break;
        }
        menu.setButton(slot, button);
        if (addToCache) {
            this.itemCache.put(slot, button);
        }
        return slot;
    }

    protected SGButton getPreviousButton(SGMenu menu) {
        return new SGButton(
                ItemStackFactory.create(Material.GRAY_WOOL)
                        .setTitle(
                                Component.text(
                                        "← Previous Page",
                                        NamedTextColor.GRAY,
                                        TextDecoration.BOLD
                                )
                        )
                        .build())
                .withListener((e) -> {
                    if (!(e.getWhoClicked() instanceof Player player)) return;
                    playUIClickSound(player);
                    menu.previousPage(player);
                });
    }

    protected SGButton getCustomCenterButton(SGMenu menu) {
        return null;
    }

    protected SGButton getCenterButton(SGMenu menu) {
        return new SGButton(
                ItemStackFactory.create(Material.NETHER_STAR)
                        .setTitle(
                                Component.text(
                                        String.format("Page %d of %d", menu.getCurrentPage() + 1, menu.getMaxPage()),
                                        NamedTextColor.GRAY,
                                        TextDecoration.BOLD
                                )
                        )
                        .build())
                .withListener(e -> e.setResult(Event.Result.DENY));
    }

    protected SGButton getNextButton(SGMenu menu) {
        return new SGButton(
                ItemStackFactory.create(Material.GRAY_WOOL)
                        .setTitle(
                                Component.text(
                                        "Next Page →",
                                        NamedTextColor.GRAY,
                                        TextDecoration.BOLD
                                )
                        )
                        .build())
                .withListener((e) -> {
                    if (!(e.getWhoClicked() instanceof Player player)) return;
                    playUIClickSound(player);
                    menu.nextPage(player);
                });
    }

    protected void setToolBar(SGMenu sgMenu) {
        final SGButton borderButton = getFrameButton();
        sgMenu.setToolbarBuilder((slot, page, type, menu) -> {
            // Previous
            if (type == SGToolbarButtonType.PREV_BUTTON) {
                if (menu.getCurrentPage() > 0) {
                    return getPreviousButton(menu);
                }
                return borderButton;
            }

            // Current
            if (type == SGToolbarButtonType.CURRENT_BUTTON) {
                final var customCenterButton = getCustomCenterButton(sgMenu);
                if (customCenterButton != null) {
                    return customCenterButton;
                } else if (menu.getMaxPage() > 1) {
                    return getCenterButton(menu);
                }
            }

            // Next
            if (type == SGToolbarButtonType.NEXT_BUTTON) {
                if (menu.getCurrentPage() + 1 < menu.getMaxPage()) {
                    return getNextButton(menu);
                }
                return borderButton;
            }

            return borderButton;
        });
    }

    private boolean canClick() {
        if (lastClickedInstant == null) return true;
        return Instant.now().isAfter(lastClickedInstant.plus(250, ChronoUnit.MILLIS));
    }

    public int addButton(SGMenu menu, SGButton button, SGButtonListener sgButtonListener) {
        button.withListener((e) -> {
            // Work around for this bug: https://github.com/SamJakob/SpiGUI/issues/32
            final int slot = e.getSlot();
            if (slot >= 45 && slot < 54) return;
            Bukkit.getScheduler().runTask(plugin, () -> {
                if (!canClick()) return;
                lastClickedInstant = Instant.now();
                sgButtonListener.onClick(e);
            });
        });
        return this.insertButton(menu, button);
    }

    public void removeButton(SGMenu menu, int slot) {
        menu.removeButton(slot);
        this.itemCache.remove(slot);
    }

    public void playUIClickSound(Player p) {
        Bukkit.getScheduler().runTask(plugin, () -> p.playSound(p, Sound.UI_BUTTON_CLICK, 0.5f, 1f));
    }

    public void playUISuccessSound(Player p) {
        Bukkit.getScheduler().runTask(plugin, () -> p.playSound(p, Sound.BLOCK_NOTE_BLOCK_BELL, 0.5f, 1f));
    }

    public void playUIFailSound(Player p) {
        Bukkit.getScheduler().runTask(plugin, () -> p.playSound(p, Sound.BLOCK_NOTE_BLOCK_DIDGERIDOO, 0.5f, 0f));
    }
}
