package net.fortresswars.core.ui.inventory.toolbars;

import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.Arrays;

public enum FrameButtonType {

    /** The "previous page" pagination button. */
    PREV_BUTTON(48),

    /** The "current page" indicator button (doesn't necessarily have an action associated). */
    CENTER_BUTTON(49),

    /** The "next page" pagination button. */
    NEXT_BUTTON(50),

    /** The "filter button" */
    FILTER_BUTTON(17),

    /** The "sort button" */
    SORT_BUTTON(26),

    /** No pre-defined action or button. */
    UNASSIGNED(null);

    /** The default slot for the button, or null. */
    @Nullable
    private final Integer defaultSlot;

    FrameButtonType(@Nullable Integer defaultSlot) {
        this.defaultSlot = defaultSlot;
    }

    @Nullable
    public Integer getDefaultSlot() {
        return defaultSlot;
    }

    @NotNull
    public static FrameButtonType getDefaultForSlot(int slot) {
        return Arrays.stream(values())
                .filter(type -> type.defaultSlot != null)
                .filter(type -> type.defaultSlot == slot)
                .findFirst()
                .orElse(FrameButtonType.UNASSIGNED);
    }
}
