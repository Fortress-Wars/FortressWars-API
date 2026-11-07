package net.fortresswars.util;

import net.fortresswars.core.entities.FortressWarsEntity;
import net.fortresswars.core.player.TeamColor;
import org.bukkit.ChatColor;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Options {

    private boolean isLocked;

    public static Options create() {
        return new Options();
    }

    private final Map<String,Object> options;

    protected Options() {
        this.options = new HashMap<>();
        this.isLocked = false;
    }

    public Options lock() {
        if (!isLocked) {
            isLocked = true;
        }
        return this;
    }

    public Options merge(Options from) {
        if (isLocked) {
            throw new UnsupportedOperationException("Options has been locked and can no longer be modified");
        }
        for (String key : from.options.keySet()) {
            final Object value = from.options.get(key);
            this.options.put(key, value);
        }
        return this;
    }

    public Options set(String key, Object value) {
        if (isLocked) {
            throw new UnsupportedOperationException("Options has been locked and can no longer be modified");
        }
        this.options.put(key, value);
        return this;
    }

    public Object getObject(String key) {
        return this.options.getOrDefault(key, null);
    }

    public boolean getBoolean(String key) {
        final Object value = getObject(key);
        if (value instanceof Boolean booleanValue) {
            return booleanValue;
        }
        return false;
    }

    public int getInt(String key) {
        final Object value = getObject(key);
        if (value instanceof Number number) {
            return number.intValue();
        }
        return 0;
    }

    public double getDouble(String key) {
        final Object value = getObject(key);
        if (value instanceof Number number) {
            return number.doubleValue();
        }
        return 0;
    }

    public String getString(String key) {
        final Object value = getObject(key);
        if (value instanceof String stringValue) {
            return stringValue;
        }
        return null;
    }

    public UUID getUUID(String key) {
        final Object value = getObject(key);
        if (value instanceof UUID uuidValue) {
            return uuidValue;
        }
        return null;
    }

    public FortressWarsEntity getFortressWarsEntity(String key) {
        final Object value = getObject(key);
        if (value instanceof FortressWarsEntity fweValue) {
            return fweValue;
        }
        return null;
    }

    public ChatColor getChatColor(String key) {
        final Object value = getObject(key);
        if (value instanceof ChatColor chatColorValue) {
            return chatColorValue;
        }
        return ChatColor.WHITE;
    }

    public TeamColor getTeamColor(String key) {
        final Object value = getObject(key);
        if (value instanceof TeamColor teamColorValue) {
            return teamColorValue;
        }
        return null;
    }
}
