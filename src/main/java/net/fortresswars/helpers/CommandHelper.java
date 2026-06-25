package net.fortresswars.helpers;

import org.bukkit.command.CommandException;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permissible;

public class CommandHelper {

    /**
     * Ensure the sender is a player and return the Player instance, or throw a CommandException.
     */
    public static Player requirePlayer(CommandSender sender) throws CommandException {
        if (!(sender instanceof Player player)) {
            throw new CommandException("Only players are allowed to use this command");
        }
        return player;
    }

    /**
     * Ensure the permissible has the given permission or throw a CommandException.
     */
    public static void requirePermission(Permissible permissible, String permission) throws CommandException {
        if (!permissible.hasPermission(permission)) {
            throw new CommandException("You don't have permission to use this command");
        }
    }
}
