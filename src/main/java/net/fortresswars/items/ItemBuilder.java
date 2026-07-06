package net.fortresswars.items;

import net.fortresswars.data.PersistentData;
import net.fortresswars.data.PersistentDataKey;
import org.bukkit.NamespacedKey;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.util.Set;
import java.util.UUID;

public abstract class ItemBuilder {

    private final JavaPlugin plugin;
    private final NamespacedKey key;
    private final NamespacedKey cooldownKey;
    private final String id;
    private final UUID uuid;

    public ItemBuilder(JavaPlugin plugin, String key, String id) {
        this.plugin = plugin;
        this.key = new NamespacedKey(plugin, key);
        this.id = id;
        this.uuid =  UUID.randomUUID();
        this.cooldownKey = new NamespacedKey(plugin, key + "." + this.uuid);
    }

    /**
     * Is the item unique
     * @return true if it is, false if it is not.
     */
    protected boolean isUnique() {
        return true;
    }

    /**
     * Get the default data
     * @return the ItemConfig
     */
    public abstract @NotNull PersistentData getDefaultData();

    /**
     * Get the properties
     * @return the keys for the data config
     */
    public Set<PersistentDataKey> getDataKeys() {
        final PersistentData defaultData = getDefaultData();
        final Set<PersistentDataKey> keys = defaultData.getKeys();
        keys.add(PersistentDataKey.ID);
        keys.add(PersistentDataKey.UUID);
        return keys;
    }

    /**
     * Get the base item stack
     * @param data the loaded data
     * @return an item stack factor.
     */
    public abstract @NotNull ItemStackFactory getItemStack(PersistentData data);

    private ConfigurationSection getConfigurationSection() {
        final FileConfiguration fileConfiguration = plugin.getConfig();
        return fileConfiguration.getConfigurationSection(key.getKey());
    }

    public ItemStack build() {
        // Config
        final ConfigurationSection fileConfiguration = this.getConfigurationSection();
        final PersistentData defaultData = this.getDefaultData();
        final PersistentData persistentData = PersistentData.fromFileConfiguration(fileConfiguration, defaultData);
        persistentData.set(PersistentDataKey.ID, this.id);
        final ItemStackFactory itemStackFactory = this.getItemStack(persistentData);

        if (isUnique()) {
            persistentData.set(PersistentDataKey.UUID, uuid.toString());
            final float cooldown = persistentData.get(PersistentDataKey.COOLDOWN).asFloat();
            if (cooldown > 0) {
                itemStackFactory.setCooldownComponent(this.cooldownKey, cooldown);
            }
        }

        // Item
        persistentData.applyTo(itemStackFactory.getItemMeta(), null);
        if (persistentData.has(PersistentDataKey.MELEE_DAMAGE)) {
            itemStackFactory.addMeleeDamage(persistentData.get(PersistentDataKey.MELEE_DAMAGE).asDouble());
        }
        if (persistentData.has(PersistentDataKey.MELEE_SPEED)) {
            itemStackFactory.addMeleeSpeed(persistentData.get(PersistentDataKey.MELEE_SPEED).asDouble());
        }

        return itemStackFactory.build();
    }
}
