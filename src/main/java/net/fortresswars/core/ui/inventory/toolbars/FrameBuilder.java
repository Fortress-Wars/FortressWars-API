package net.fortresswars.core.ui.inventory.toolbars;

import net.fortresswars.core.ui.inventory.buttons.Button;
import net.fortresswars.core.ui.inventory.menus.InventoryMenu;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public interface FrameBuilder {
    /**
     * Specifies the frame button builder for an {@link InventoryMenu}. This can be customized to render different frame
     * buttons for a GUI.
     *
     * <p>This method is called once per frame slot every time a page is rendered. To leave a slot empty, return null.
     *
     * @param slot The slot being rendered.
     * @param page The current page of the inventory being rendered.
     * @param defaultType The default button type of the current slot.
     * @param inventoryMenu The inventory the frame is being rendered in.
     * @return The button to be rendered for that slot, or null if no button should be rendered.
     */
    @Nullable
    Button buildFrameButton(int slot, int page, @NotNull FrameButtonType defaultType, @NotNull InventoryMenu inventoryMenu);
}
