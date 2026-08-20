package net.fortresswars.core.ui.inventory.toolbars;

import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public enum FrameButtonType {

    /** The "previous page" pagination button. */
    PREV_BUTTON(0, 3,true),

    /** The "current page" indicator button (doesn't necessarily have an action associated). */
    CENTER_BUTTON(0, 4,true),

    /** The "next page" pagination button. */
    NEXT_BUTTON(0, 5,true),

    /** The "filter button" */
    FILTER_BUTTON(1, 8, false),

    /** The "sort button" */
    SORT_BUTTON(2, 8, false),

    /** No pre-defined action or button. */
    UNASSIGNED(null, null, false);

    private final @Nullable Integer row;
    private final @Nullable Integer col;
    private final boolean isBottom;

    FrameButtonType(@Nullable Integer row, @Nullable Integer col, boolean isBottom) {
        this.row = row;
        this.col = col;
        this.isBottom = isBottom;
    }

    @Nullable
    public Integer getDefaultRow() {
        return row;
    }

    @Nullable
    public Integer getDefaultCol() {
        return col;
    }

    public boolean isBottom() {
        return isBottom;
    }

    /**
     * Returns a set of integers representing the outer frame of a grid.
     * For a 6x9 grid, it returns indices 0-8, 45-53, and the sides.
     */
    public static Set<Integer> getFrameSlots(int rows, int cols) {
        final Set<Integer> frameSlots = new LinkedHashSet<>();
        if (rows <= 0 || cols <= 0) return frameSlots;

        // 1. Add the Top Row
        for (int i = 0; i < cols; i++) {
            frameSlots.add(i);
        }

        // 2. Add the Left and Right slots for the Middle Rows
        for (int r = 1; r < rows - 1; r++) {
            frameSlots.add(r * cols);                // Left edge
            if (cols > 1) {
                frameSlots.add(r * cols + cols - 1); // Right edge
            }
        }

        // 3. Add the Bottom Row (if there is more than 1 row)
        if (rows > 1) {
            int startOfBottomRow = (rows - 1) * cols;
            for (int i = 0; i < cols; i++) {
                frameSlots.add(startOfBottomRow + i);
            }
        }

        return frameSlots;
    }

    @NotNull
    public static FrameButtonType getDefaultForSlot(int rowsPerPage, int slot) {
        return Arrays.stream(values())
                .filter(type -> type.row != null && type.col != null)
                .filter(type -> {
                    if (!type.isBottom) {
                        final var defaultSlot = (type.row * 9) + type.col;
                        return defaultSlot == slot;
                    }
                    final var slotCol = slot % 9;
                    final var slotRow = slot / 9;
                    // + 1 because rows per page is 1 (-1) indexed and the  frame has 2 surrounding rows (+2)
                    final var offsetRow = rowsPerPage + 1;
                    return offsetRow == slotRow && type.col == slotCol;
                })
                .findFirst()
                .orElse(FrameButtonType.UNASSIGNED);
    }
}
