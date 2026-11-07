package net.fortresswars.core.items;

import net.fortresswars.core.data.PersistentData;
import net.fortresswars.core.data.PersistentDataKey;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import java.util.UUID;

public class PlayerInventoryContainer implements Cloneable {

    public static final int INVALID_SLOT = Integer.MIN_VALUE;
    public static final int BOOTS_SLOT = 36;
    public static final int LEGGINGS_SLOT = 37;
    public static final int CHESTPLATE_SLOT = 38;
    public static final int HELMET_SLOT = 39;
    public static final int OFF_HAND_SLOT = 40;
    public static final int CURSOR_SLOT = 41;

    private final ItemStack[] contents;
    private ItemStack cursorItem;

    public PlayerInventoryContainer(Player player, boolean shouldMerge) {
        // Get Contents
        final PlayerInventory playerInventory = player.getInventory();
        final ItemStack[] piContents = playerInventory.getContents();

        // Create Copy Contents
        contents = new ItemStack[piContents.length];
        cursorItem = null;

        // Merge Contents
        if (shouldMerge) {
            merge(piContents, contents, true);
            cursorItem = player.getItemOnCursor();
        }
    }

    /**
     * Returns the integer location in the inventory where the item exists at
     * @param player player whose inventory to check
     * @param associatedUUID associated uuid to match
     * @return true if item is in inventory, false otherwise
     */
    public static boolean inventoryContains(Player player, UUID associatedUUID) {
        return getMatchingItemSlot(player, associatedUUID) != INVALID_SLOT;
    }

    /**
     * Get an item in the specified slot
     * @param player player to get item from
     * @param slot -2 for offhand, -1 for cursor, 0-35 for inventory
     * @return Item in the specified slot
     */
    public static ItemStack getItemInSlot(Player player, int slot) {
        final PlayerInventory playerInventory = player.getInventory();
        if (slot < 0) return null;
        if (slot != CURSOR_SLOT && slot > playerInventory.getContents().length) return null;

        if (slot == CURSOR_SLOT) {
            return player.getItemOnCursor();
        }

        return playerInventory.getItem(slot);
    }

    /**
     * Returns the integer location in the inventory where the item exists at
     * @param player player whose inventory to check
     * @param associatedUUID associated uuid to match
     * @return -3 if not found, -2 if offhand, -1 if on cursor, 0-35 if in inventory
     */
    public static int getMatchingItemSlot(Player player, UUID associatedUUID) {
        final PlayerInventory inventory = player.getInventory();
        final ItemStack cursorItem = player.getItemOnCursor();

        // Try item on cursor first
        if (doesItemMatch(cursorItem, associatedUUID)) return CURSOR_SLOT;

        // Try items in inventory
        final ItemStack[] contents = inventory.getContents();
        for (int i = 0; i < contents.length; i++) {
            if (doesItemMatch(contents[i], associatedUUID)) return i;
        }
        return INVALID_SLOT;
    }

    /**
     * Sets an item in the specified slot
     * @param player player to set item
     * @param newItem item to set
     * @param slot 0-35 for inventory, 36-39 for armor, 40 for off-hand, 41 for cursor item
     * @return previous item
     */
    public static ItemStack setItemInSlot(Player player, ItemStack newItem, int slot) {
        if (slot < 0) return null;

        final PlayerInventory inventory = player.getInventory();
        if (slot != CURSOR_SLOT && slot > inventory.getContents().length) return null;

        final ItemStack previousItem = getItemInSlot(player, slot);
        if (slot == CURSOR_SLOT) {
            player.setItemOnCursor(newItem);
        } else {
            inventory.setItem(slot, newItem);
        }
        return previousItem;
    }

    public static boolean isHotBarSlot(int slotNum) {
        return slotNum >= 0 && slotNum < 9 || slotNum == OFF_HAND_SLOT;
    }

    /**
     * Replace an item with the specified material and associated UUID with the provided item in a players inventory
     *
     * @param player target player
     * @param associatedUUID associated uuid to match
     * @param item item to place met criteria with
     * @return the slot the item is in
     */
    public static int replaceMaterialWithItem(Player player, UUID associatedUUID, ItemStack item) {
        final PlayerInventory inventory = player.getInventory();
        final int itemSlot = getMatchingItemSlot(player, associatedUUID);

        if (itemSlot < 0) return INVALID_SLOT;
        if (itemSlot != CURSOR_SLOT && itemSlot > inventory.getContents().length) return INVALID_SLOT;

        if (itemSlot == CURSOR_SLOT) {
            player.setItemOnCursor(item);
        } else {
            inventory.setItem(itemSlot, item);
        }

        return itemSlot;
    }

    /**
     * Gets the first ItemStack that matches the uuid
     * @param player player to get the item from
     * @param uuid associated uuid on the item
     * @return ItemStack - null if not found
     */
    public static ItemStack getAssociatedItemStack(Player player, UUID uuid) {
        final int itemSlot = getMatchingItemSlot(player, uuid);
        final PlayerInventory inventory = player.getInventory();
        if (itemSlot < 0) return null;
        if (itemSlot != CURSOR_SLOT && itemSlot > inventory.getContents().length) return null;
        if (itemSlot == CURSOR_SLOT) return player.getItemOnCursor();
        return inventory.getItem(itemSlot);
    }

    public static void givePlayerItemStack(Player player, ItemStack itemStack) {
        final PlayerInventory pi = player.getInventory();
        pi.addItem(itemStack);
    }

    /**
     * Helper function to check if an item matches a material type and has the associated uuid
     * @param itemStack item to check
     * @param uuid uuid to check
     * @return true if criteria met, false otherwise
     */
    public static boolean doesItemMatch(ItemStack itemStack, UUID uuid) {
        if (itemStack == null || uuid == null) return false;
        final UUID itemUUID = PersistentData.getProperty(itemStack.getItemMeta(), PersistentDataKey.UUID).asUUID();
        return uuid.equals(itemUUID);
    }

    /**
     * Get if the player holding a specific ability item
     * @param player the player to check
     * @param abilityUUID the ability uuid to check
     * @return true if the player is holding the ability item, false if they are not
     */
    public static boolean isPlayerHoldingAbilityItem(Player player, UUID abilityUUID) {
        final  PlayerInventory pi = player.getInventory();
        final ItemStack heldItem = pi.getItemInMainHand();
        return doesItemMatch(heldItem, abilityUUID);
    }

    /**
     * Get if the ability item is in use
     * @param player the player to check
     * @param abilityUUID the ability uuid to check
     * @return true if the ability item is active, false if is not
     */
    public static boolean isAbilityItemInUse(Player player, UUID abilityUUID) {
        if (player == null || abilityUUID == null) return false;
        if (!player.hasActiveItem()) return false;
        final ItemStack itemInUse = player.getActiveItem();
        final UUID itemUUID = PersistentData.getProperty(itemInUse.getItemMeta(), PersistentDataKey.UUID).asUUID();
        return abilityUUID.equals(itemUUID);
    }

    /**
     * Helper function to merge contents
     * @param from Contents to merge from
     * @param to Contents to merge to
     */
    private void merge(ItemStack[] from, ItemStack[] to, boolean override) {
        for (int i = 0; i < from.length && i < to.length; i++) {
            // Skip if the index of the "from contents" is null
            if (from[i] == null) continue;

            // Set the item stack in the "to contents"
            if (to[i] != null || override) {
                to[i] = from[i];
            }
        }
    }

    /**
     * Merged the provided contents to the specified ContentType
     * @param contents contents to merge from
     * @param override if the contents override items in the same slot
     */
    public void merge(ItemStack[] contents, boolean override) {
        merge(contents, this.contents, override);
    }

    /**
     * Set an item in the player inventory
     * @param item item to set
     * @param slot slot to set item in
     * @return if the item was set successfully, false otherwise.
     */
    public boolean set(ItemStack item, int slot) {
        if (slot < 0) return false; // Return early if the slot is below 0
        if (slot >= contents.length) return false;  // Return if the slot is out of bounds

        // Set the item in the specified slot
        contents[slot] = item;
        return true;
    }

    /**
     * Set the item in the cursor slot
     * @param item item
     * @return true if the cursor item was set
     */
    public boolean setCursorItem(ItemStack item) {
        this.cursorItem = item;
        return true;
    }

    /**
     * Override the contents of the provided player inventory
     * @param player player whose inventory we should override
     */
    public void overrideInventory(Player player) {
        final PlayerInventory playerInventory = player.getInventory();
        playerInventory.setContents(contents);
        player.setItemOnCursor(cursorItem);
    }

    /**
     * Merge all contents stored in this class into the provided player inventory
     * @param player whose inventory we merge into
     */
    public void merge(Player player) {
        // Get current contents
        final PlayerInventory playerInventory = player.getInventory();
        final ItemStack[] piContents = playerInventory.getContents();

        // Merge the contents
        merge(contents, piContents, true);
        if (cursorItem != null) {
            player.setItemOnCursor(cursorItem);
        }

        // Set Contents
        playerInventory.setContents(piContents);
    }

    @Override
    public PlayerInventoryContainer clone() {
        try {
            return (PlayerInventoryContainer) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
