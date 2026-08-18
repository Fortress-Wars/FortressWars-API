package net.fortresswars.ui.inventory.toolbars;

import net.fortresswars.core.items.ItemStackFactory;
import net.fortresswars.ui.inventory.buttons.Button;
import net.fortresswars.ui.inventory.menus.Menu;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Material;
import org.jetbrains.annotations.NotNull;
import org.jspecify.annotations.Nullable;

import java.util.*;

public class DefaultFrameBuilder implements FrameBuilder {

    public static final Set<Integer> VALID_FRAME_SLOTS = Set.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 17, 18, 26, 27, 35, 36, 44, 45, 53);

    @Override
    public @Nullable Button buildFrameButton(int slot, int page, @NotNull FrameButtonType type, @NotNull Menu menu) {
        // Previous
        if (type == FrameButtonType.PREV_BUTTON && menu.getCurrentPage() > 0) {
            return buildPreviousButton(menu);
        }

        // Current
        if (type == FrameButtonType.CENTER_BUTTON) {
            return buildCenterButton(menu);
        }

        // Next
        if (type == FrameButtonType.NEXT_BUTTON && menu.getCurrentPage() + 1 < menu.getMaxPage()) {
            return buildNextButton(menu);
        }

        // Filter
        if (type == FrameButtonType.FILTER_BUTTON) {
            return buildFilterButton(menu);
        }

        // Sort
        if (type == FrameButtonType.SORT_BUTTON) {
            return buildSortButton(menu);
        }

        return null;
    }

    public @Nullable Button buildPreviousButton(@NotNull Menu menu) {
        return new Button(
                ItemStackFactory.create(Material.GRAY_WOOL)
                        .setTitle(Component.text("←", NamedTextColor.GRAY, TextDecoration.BOLD))
                        .build())
                .withListener((e) -> {
                    final var whoClicked = e.getWhoClicked();
                    menu.playClickSound(whoClicked);
                    menu.previousPage(whoClicked);
                });
    }

    public @Nullable Button buildCenterButton(@NotNull Menu menu) {
        if (menu.getMaxPage() <= 1) return null;
        return new Button(
                ItemStackFactory.create(Material.NETHER_STAR)
                        .setTitle(
                                Component.text(
                                        String.format("Page %d of %d", menu.getCurrentPage() + 1, menu.getMaxPage()),
                                        NamedTextColor.GRAY,
                                        TextDecoration.BOLD
                                )
                        )
                        .build());
    }

    public @Nullable Button buildNextButton(@NotNull Menu menu) {
        return new Button(
                ItemStackFactory.create(Material.GRAY_WOOL)
                        .setTitle(Component.text("→", NamedTextColor.GRAY, TextDecoration.BOLD))
                        .build())
                .withListener((e) -> {
                    final var whoClicked = e.getWhoClicked();
                    menu.playClickSound(whoClicked);
                    menu.nextPage(whoClicked);
                });
    }

    public @Nullable Button buildFilterButton(@NotNull Menu menu) {
        return null;
    }

    public @Nullable Button buildSortButton(@NotNull Menu menu) {
        return null;
    }
}
