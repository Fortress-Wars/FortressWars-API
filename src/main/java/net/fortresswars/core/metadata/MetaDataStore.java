package net.fortresswars.core.metadata;

import net.fortresswars.FortressWarsAPI;
import net.fortresswars.core.damage.FWDamageCause;
import net.fortresswars.core.entities.FortressWarsPlayer;
import net.fortresswars.core.kits.abilities.AbilityID;
import net.fortresswars.core.kits.abilities.spells.SpellID;
import net.fortresswars.core.player.TeamColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.entity.Entity;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.metadata.Metadatable;

import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

public class MetaDataStore {

    private static final String META_DATA_KEY_PREFIX = "FW_META_DATA_";

    public static void reset(Metadatable m) {
        // We want to retain the original!
        final Object originalValue = getObject(m, MetaDataKey.ORIGINAL);

        for (MetaDataKey key : MetaDataKey.values()) {
            removeMetaData(m, key);
        }

        // Set the original back!
        setMetaData(m, MetaDataKey.ORIGINAL, originalValue);
    }

    public static void setAir(Block block) {
        // Reset MetaData
        reset(block);

        // Break the block
        block.setBlockData(Material.AIR.createBlockData());
    }

    public static void removeMetaData(Metadatable m, MetaDataKey key) {
        m.removeMetadata(META_DATA_KEY_PREFIX + key, FortressWarsAPI.getInstance());
    }

    public static <T> void setMetaData(Metadatable m, MetaDataKey key, T value) {
        if (m == null) return;
        if (key == null) return;
        m.setMetadata(META_DATA_KEY_PREFIX + key, new FixedMetadataValue(FortressWarsAPI.getInstance(), value));
    }

    public static boolean hasMetaData(Metadatable m, MetaDataKey key) {
        return m.hasMetadata(META_DATA_KEY_PREFIX + key);
    }

    public static void print(Logger logger, Metadatable m) {
        for (MetaDataKey key : MetaDataKey.values()) {
            if (!hasMetaData(m, key)) continue;
            final Object value = getObject(m, key);
            logger.info(key + ": " + value);
        }
    }

    public static Object getObject(Metadatable m, MetaDataKey key) {
        if (m == null) return null;
        if (key == null) return null;
        List<MetadataValue> values = m.getMetadata(META_DATA_KEY_PREFIX + key);
        if (values.isEmpty()) return null;
        return values.get(0).value();
    }

    public static String getString(Metadatable m, MetaDataKey key) {
        Object metadataValue = getObject(m, key);
        if (metadataValue instanceof String string) return string;
        return null;
    }

    public static int getInt(Metadatable m, MetaDataKey key) {
        Object metadataValue = getObject(m, key);
        if (metadataValue instanceof Integer integer) return integer;
        double value = getDouble(m, key);
        return (int) value;
    }

    public static double getDouble(Metadatable m, MetaDataKey key) {
        Object metadataValue = getObject(m, key);
        if (metadataValue instanceof Double doub) {
            return doub;
        }
        return 0;
    }

    public static boolean getBoolean(Metadatable m, MetaDataKey key) {
        Object metadataValue = getObject(m, key);
        if (metadataValue instanceof Boolean bool) return bool;
        return false;
    }

    public static UUID getUUID(Metadatable m, MetaDataKey key) {
        Object metadataValue = getObject(m, key);
        if (metadataValue instanceof UUID uuid) return uuid;
        return null;
    }

    public static TeamColor getTeam(Metadatable m, MetaDataKey key) {
        Object metadataValue = getObject(m, key);
        if (metadataValue instanceof TeamColor team) return team;
        return TeamColor.NONE;
    }

    public static FWDamageCause getFWDamageCause(Metadatable m, MetaDataKey key) {
        Object metadataValue = getObject(m, key);
        if (metadataValue instanceof FWDamageCause damageCause) return damageCause;
        return null;
    }

    public static AbilityID getAbilityID(Metadatable m, MetaDataKey key) {
        Object metadataValue = getObject(m, key);
        if (metadataValue instanceof AbilityID abilityID) return abilityID;
        return null;
    }

    public static SpellID getSpellID(Metadatable m, MetaDataKey key) {
        Object metadataValue = getObject(m, key);
        if (metadataValue instanceof SpellID spellID) return spellID;
        return null;
    }

    public static BlockData getBlockData(Metadatable m, MetaDataKey key) {
        Object metadataValue = getObject(m, key);
        if (metadataValue instanceof BlockData blockData) return blockData;
        return null;
    }

    public static Location getLocation(Metadatable m, MetaDataKey key) {
        Object metadataValue = getObject(m, key);
        if (metadataValue instanceof Location location) return location;
        return null;
    }

    public static FortressWarsPlayer getFortressWarsPlayer(Entity m, MetaDataKey key) {
        Object metadataValue = getObject(m, key);
        if (metadataValue instanceof FortressWarsPlayer fortressWarsPlayer) return fortressWarsPlayer;
        return null;
    }
}
