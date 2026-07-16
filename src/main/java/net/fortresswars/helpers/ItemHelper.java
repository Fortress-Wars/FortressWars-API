package net.fortresswars.helpers;

import net.fortresswars.items.ItemException;
import org.bukkit.command.CommandException;
import org.bukkit.permissions.Permissible;

public class ItemHelper {

    /**
     * Ensure the permissible has the given permission or throw a ItemException.
     */
    public static void requirePermission(Permissible permissible, String permission) throws CommandException {
        if (!permissible.hasPermission(permission)) {
            throw new ItemException("You don't have permission to use this item");
        }
    }
}
