package net.fortresswars.helpers;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandException;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permissible;

import java.util.List;

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
     * Ensure the player is online and return the Player instance, or throw a CommandException.
     */
    public static Player requirePlayer(String playerName) throws CommandException {
        if (playerName == null) {
            throw new CommandException("Missing player argument");
        }
        final var player = Bukkit.getPlayer(playerName);
        if (EntityHelper.isVanished(player)) {
            throw new CommandException("Player is not online");
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

    public static List<String> getOnlinePlayerNames() {
        return Bukkit.getOnlinePlayers().stream().map(Player::getName).toList();
    }
}
