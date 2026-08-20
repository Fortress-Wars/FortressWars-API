package net.fortresswars.core.ui.inventory.toolbars;

import net.fortresswars.core.items.ItemStackFactory;
import net.fortresswars.core.ui.inventory.buttons.Button;
import net.fortresswars.core.ui.inventory.menus.InventoryMenu;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Material;
import org.jetbrains.annotations.NotNull;
import org.jspecify.annotations.Nullable;

import java.util.*;

public class DefaultFrameBuilder implements FrameBuilder {

    @Override
    public @Nullable Button buildFrameButton(int slot, int page, @NotNull FrameButtonType type, @NotNull InventoryMenu inventoryMenu) {
        // Previous
        if (type == FrameButtonType.PREV_BUTTON && page > 0) {
            return buildPreviousButton(inventoryMenu);
        }

        // Current
        if (type == FrameButtonType.CENTER_BUTTON) {
            return buildCenterButton(inventoryMenu);
        }

        // Next
        if (type == FrameButtonType.NEXT_BUTTON && page < inventoryMenu.getMaxPage()) {
            return buildNextButton(inventoryMenu);
        }

        // Filter
        if (type == FrameButtonType.FILTER_BUTTON) {
            return buildFilterButton(inventoryMenu);
        }

        // Sort
        if (type == FrameButtonType.SORT_BUTTON) {
            return buildSortButton(inventoryMenu);
        }

        return null;
    }

    public @Nullable Button buildPreviousButton(@NotNull InventoryMenu inventoryMenu) {
        return new Button(
                ItemStackFactory.create(Material.GRAY_WOOL)
                        .setTitle(Component.text("← Previous Page", NamedTextColor.GRAY, TextDecoration.BOLD)
                                .decoration(TextDecoration.ITALIC, false))
                        .build())
                .withListener((e) -> {
                    final var whoClicked = e.getWhoClicked();
                    inventoryMenu.playClickSound(whoClicked);
                    inventoryMenu.previousPage(whoClicked);
                });
    }

    public @Nullable Button buildCenterButton(@NotNull InventoryMenu inventoryMenu) {
        if (inventoryMenu.getMaxPage() < 1) return null;
        return new Button(
                ItemStackFactory.create(Material.NETHER_STAR)
                        .setTitle(
                                Component.text(
                                        String.format("Page %d of %d", inventoryMenu.getCurrentPage() + 1, inventoryMenu.getMaxPage() + 1),
                                        NamedTextColor.GRAY,
                                        TextDecoration.BOLD
                                ).decoration(TextDecoration.ITALIC, false)
                        )
                        .build());
    }

    public @Nullable Button buildNextButton(@NotNull InventoryMenu inventoryMenu) {
        return new Button(
                ItemStackFactory.create(Material.GRAY_WOOL)
                        .setTitle(Component.text("Next Page →", NamedTextColor.GRAY, TextDecoration.BOLD)
                                .decoration(TextDecoration.ITALIC, false))
                        .build())
                .withListener((e) -> {
                    final var whoClicked = e.getWhoClicked();
                    inventoryMenu.playClickSound(whoClicked);
                    inventoryMenu.nextPage(whoClicked);
                });
    }

    public @Nullable Button buildFilterButton(@NotNull InventoryMenu inventoryMenu) {
        return null;
    }

    public @Nullable Button buildSortButton(@NotNull InventoryMenu inventoryMenu) {
        return null;
    }
}
