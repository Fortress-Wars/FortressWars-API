package net.fortresswars.ui;

import com.samjakob.spigui.SpiGUI;
import com.samjakob.spigui.buttons.SGButton;
import com.samjakob.spigui.buttons.SGButtonListener;
import com.samjakob.spigui.menu.SGMenu;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
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
        final SGMenu menu = this.spigui.create(LOADING_TEXT, rows);
        menu.setBlockDefaultInteractions(true);
        menu.setAutomaticPaginationEnabled(true);

        // Open
        player.sendMessage(Component.text("Opening menu...", NamedTextColor.GREEN));
        player.openInventory(menu.getInventory());
        final CompletableFuture<Void> buildFuture = this.build(menu, player);
        buildFuture.thenAccept((unused) -> {
            final String title = this.getTitle();
            menu.setName(title);

            // Refresh Synchronously
            Bukkit.getScheduler().runTask(plugin, () -> menu.refreshInventory(player));
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
        menu.addButton(button);
    }

    public void playUISuccessSound(Player p) {
        Bukkit.getScheduler().runTask(plugin, () -> p.playSound(p, Sound.BLOCK_NOTE_BLOCK_BELL, 0.5f, 1f));
    }

    public void playUIFailSound(Player p) {
        Bukkit.getScheduler().runTask(plugin, () -> p.playSound(p, Sound.BLOCK_NOTE_BLOCK_DIDGERIDOO, 0.5f, 0f));
    }
}
