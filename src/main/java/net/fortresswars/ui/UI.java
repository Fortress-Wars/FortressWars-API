package net.fortresswars.ui;

import com.samjakob.spigui.SpiGUI;
import com.samjakob.spigui.buttons.SGButton;
import com.samjakob.spigui.buttons.SGButtonListener;
import com.samjakob.spigui.menu.SGMenu;
import com.samjakob.spigui.toolbar.SGToolbarButtonType;
import net.fortresswars.items.ItemStackFactory;
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
import java.util.List;
import java.util.concurrent.CompletableFuture;

public abstract class UI {

    private final JavaPlugin plugin;
    private final SpiGUI spigui;
    private Instant lastClickedInstant;

    private static final String LOADING_TEXT = "&8Loading...";

    public UI(JavaPlugin plugin, SpiGUI spigui) {
        this.plugin = plugin;
        this.spigui = spigui;
    }

    protected abstract String getTitle();

    protected abstract int getRows();

    protected abstract CompletableFuture<Void> build(SGMenu menu, Player player);

    public void open(Player player) {
        final int rows = this.getRows();
        final SGMenu menu = this.spigui.create(LOADING_TEXT, rows - 1);
        menu.setBlockDefaultInteractions(true);
        menu.setAutomaticPaginationEnabled(true);
        setFrame(menu);

        // Open
        player.sendMessage(Component.text("Opening menu...", NamedTextColor.GREEN));
        player.openInventory(menu.getInventory());
        final CompletableFuture<Void> buildFuture = this.build(menu, player);
        buildFuture.thenAccept((unused) -> {
            final String title = this.getTitle();
            menu.setName(title);

            // Refresh Synchronously
            Bukkit.getScheduler().runTask(plugin, () -> menu.refreshInventory(player));
        }).exceptionally((e) -> {
            plugin.getLogger().warning("Error opening menu: " +  e.getMessage());
            Bukkit.getScheduler().runTask(plugin, () -> menu.refreshInventory(player));
            return null;
        });
    }

    private int getNextEmptySlot(SGMenu menu) {
        // Use get page with page and slot, so search is O(n)
        final int maxPage = menu.getMaxPage();
        final int pageSize = menu.getPageSize();
        for (int page = 0; page < maxPage; page++) {
            for (int slot = 0; slot < pageSize; slot ++) {
                if (menu.getButton(page, slot) == null) {{
                    return page * pageSize + slot;
                }}
            }
        }
        // If we get here it is because the pages are perfectly filled.
        // The next index is the first slot on a new page. If a page has a
        // size of 100, then the slots on page 0 are 0-99, so the next empty
        // slot is slot 100. The maxPage is exclusive.
        return maxPage * pageSize;
    }

    private void setFrame(SGMenu sgMenu) {
        // Border
        final SGButton borderButton = new SGButton(
                ItemStackFactory.create(Material.GRAY_STAINED_GLASS_PANE)
                        .setTitle(Component.text(""))
                        .build()
        ).withListener(e -> e.setResult(Event.Result.DENY));

        final List<Integer> borderSlots = List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 17, 18, 26, 27, 35, 36, 44);
        for (int slot : borderSlots) {
            sgMenu.setButton(slot, borderButton);
            sgMenu.stickSlot(slot);
        }

        // Tool Bar
        sgMenu.setToolbarBuilder((slot, page, type, menu) -> {
            // Previous
            if (type == SGToolbarButtonType.PREV_BUTTON) {
                if (menu.getCurrentPage() > 0) {
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
                            .withListener((e) -> menu.previousPage(e.getWhoClicked()));
                }
                return borderButton;
            }

            // Current
            if (type == SGToolbarButtonType.CURRENT_BUTTON) {
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

            // Next
            if (type == SGToolbarButtonType.NEXT_BUTTON) {
                if (menu.getCurrentPage() + 1 < menu.getMaxPage()) {
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
                            .withListener((e) -> menu.nextPage(e.getWhoClicked()));
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

    public void addButton(SGMenu menu, SGButton button, SGButtonListener sgButtonListener) {
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
        menu.setButton(this.getNextEmptySlot(menu), button);
    }

    public void playUISuccessSound(Player p) {
        Bukkit.getScheduler().runTask(plugin, () -> p.playSound(p, Sound.BLOCK_NOTE_BLOCK_BELL, 0.5f, 1f));
    }

    public void playUIFailSound(Player p) {
        Bukkit.getScheduler().runTask(plugin, () -> p.playSound(p, Sound.BLOCK_NOTE_BLOCK_DIDGERIDOO, 0.5f, 0f));
    }
}
