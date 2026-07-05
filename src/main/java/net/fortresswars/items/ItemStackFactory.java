package net.fortresswars.items;

import com.destroystokyo.paper.profile.PlayerProfile;
import io.papermc.paper.datacomponent.DataComponentType;
import io.papermc.paper.datacomponent.DataComponentTypes;
import io.papermc.paper.datacomponent.item.Consumable;
import net.fortresswars.FortressWarsAPI;
import net.fortresswars.data.PersistentData;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.Style;
import org.bukkit.*;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.block.Banner;
import org.bukkit.block.BlockState;
import org.bukkit.block.banner.Pattern;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.EquipmentSlotGroup;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.*;
import org.bukkit.inventory.meta.components.FoodComponent;
import org.bukkit.inventory.meta.components.UseCooldownComponent;
import org.bukkit.inventory.meta.trim.ArmorTrim;
import org.bukkit.inventory.meta.trim.TrimMaterial;
import org.bukkit.inventory.meta.trim.TrimPattern;
import org.bukkit.map.MinecraftFont;
import org.bukkit.potion.PotionEffect;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;
import java.util.function.Consumer;

public class ItemStackFactory {

    public static ItemStackFactory create(Material material) {
        return new ItemStackFactory(material);
    }

    public static ItemStackFactory create(ItemStack item) {
        return new ItemStackFactory(item);
    }

    public static boolean hasEnchantment(ItemStack weapon, Enchantment enchantment) {
        if (weapon == null || enchantment == null) return false;
        return weapon.getEnchantments().containsKey(enchantment);
    }

    public static boolean hasBundleItems(ItemStack item) {
        return item.getItemMeta() instanceof BundleMeta bundleMeta && bundleMeta.hasItems();
    }

    public static @NotNull List<ItemStack> getBundleItems(ItemStack item) {
        if (item.getItemMeta() instanceof BundleMeta bundleMeta) {
            bundleMeta.getItems();
        }
        return List.of();
    }

    // ==================================================================
    //                             Factory
    // ==================================================================
    
    private ItemStack item;
    private ItemMeta itemMeta;
    private PersistentData persistentData;
    private final BlockState blockState;
    private final Map<DataComponentType.Valued<Object>, Object> dataComponentMap;

    public ItemStackFactory(Material material) {
        this(ItemStack.of(material));
    }

    public ItemStackFactory(ItemStack item) {
        this.item = item;
        itemMeta = item.getItemMeta();
        dataComponentMap = new HashMap<>();
        if (itemMeta instanceof BlockStateMeta blockStateMeta) {
            blockState = blockStateMeta.getBlockState();
        } else {
            blockState = null;
        }
    }

    public ItemMeta getItemMeta() {
        return itemMeta;
    }

    public ItemStackFactory setType(Material type) {
        item = item.withType(type);
        itemMeta = item.getItemMeta();
        return this;
    }

    public ItemStackFactory setTitle(Component title) {
        itemMeta.displayName(title);
        return this;
    }

    public ItemStackFactory setLore(Component... lore) {
        itemMeta.lore(List.of(lore));
        return this;
    }

    public ItemStackFactory addLoreContent(Component content, int width, int padding) {
        if (content == null) {
            return this;
        }

        final int sanitizedWidth = Math.max(width, 10);
        final int sanitizedPadding = Math.max(0, padding);
        final List<Component> newLore = new ArrayList<>();
        final List<Component> oldLore = itemMeta.lore();
        if (oldLore != null) {
            newLore.addAll(oldLore);
        }

        newLore.addAll(wrapComponentLore(content, sanitizedWidth, sanitizedPadding));
        itemMeta.lore(newLore);
        return this;
    }

    private List<Component> wrapComponentLore(Component content, int width, int padding) {
        final String paddingText = " ".repeat(padding);
        final List<WordPart> words = new ArrayList<>();
        collectWordParts(content, Style.empty(), words);

        final List<Component> wrapped = new ArrayList<>();
        Component currentLine = Component.empty();
        int currentWidth = 0;
        boolean hasWord = false;

        for (WordPart part : words) {
            if (part.lineBreak) {
                if (hasWord) {
                    wrapped.add(withPadding(currentLine, paddingText));
                    currentLine = Component.empty();
                    currentWidth = 0;
                    hasWord = false;
                } else {
                    wrapped.add(Component.text(""));
                }
                continue;
            }

            final int wordWidth = MinecraftFont.Font.getWidth(part.text);
            final int separatorWidth = hasWord ? MinecraftFont.Font.getWidth(" ") : 0;
            final boolean exceedsLine = currentWidth + separatorWidth + wordWidth > width;

            if (exceedsLine && hasWord) {
                wrapped.add(withPadding(currentLine, paddingText));
                currentLine = Component.empty();
                currentWidth = 0;
                hasWord = false;
            }

            if (hasWord) {
                currentLine = currentLine.append(Component.space());
                currentWidth += separatorWidth;
            }

            currentLine = currentLine.append(Component.text(part.text).style(part.style));
            currentWidth += wordWidth;
            hasWord = true;
        }

        if (hasWord) {
            wrapped.add(withPadding(currentLine, paddingText));
        }

        return wrapped;
    }

    private Component withPadding(Component line, String paddingText) {
        if (paddingText.isEmpty()) {
            return line;
        }
        return Component.text(paddingText).append(line);
    }

    private void collectWordParts(Component component, Style inheritedStyle, List<WordPart> out) {
        final Style currentStyle = inheritedStyle.merge(component.style(), Style.Merge.Strategy.ALWAYS);

        if (component instanceof TextComponent textComponent) {
            collectWordsFromText(textComponent.content(), currentStyle, out);
        }

        for (Component child : component.children()) {
            collectWordParts(child, currentStyle, out);
        }
    }

    private void collectWordsFromText(String text, Style style, List<WordPart> out) {
        final StringBuilder word = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            final char c = text.charAt(i);
            if (c == '\r') {
                continue;
            }
            if (c == '\n') {
                if (!word.isEmpty()) {
                    out.add(new WordPart(word.toString(), style, false));
                    word.setLength(0);
                }
                out.add(WordPart.breakToken());
                continue;
            }
            if (Character.isWhitespace(c)) {
                if (!word.isEmpty()) {
                    out.add(new WordPart(word.toString(), style, false));
                    word.setLength(0);
                }
                continue;
            }
            word.append(c);
        }

        if (!word.isEmpty()) {
            out.add(new WordPart(word.toString(), style, false));
        }
    }

    private record WordPart(String text, Style style, boolean lineBreak) {
        private static WordPart breakToken() {
            return new WordPart("", Style.empty(), true);
        }
    }

    public ItemStackFactory prependLore(Component... lore) {
        final List<Component> existingLore = itemMeta.lore();
        if (existingLore == null) {
            return setLore(lore);
        }
        final List<Component> newLore = new ArrayList<>(List.of(lore));
        newLore.addAll(existingLore);
        itemMeta.lore(newLore);
        return this;
    }

    public ItemStackFactory appendLore(Component... lore) {
        final List<Component> existingLore = itemMeta.lore();
        if (existingLore == null) {
            return setLore(lore);
        }
        final List<Component> newLore = new ArrayList<>(existingLore);
        newLore.addAll(List.of(lore));
        itemMeta.lore(newLore);
        return this;
    }

    public ItemStackFactory setLore(List<Component> lore) {
        itemMeta.lore(lore);
        return this;
    }

    public ItemStackFactory setFlags(ItemFlag... flags) {
        itemMeta.addItemFlags(flags);
        return this;
    }
    public ItemStackFactory setUnbreakable() {
        itemMeta.setUnbreakable(true);
        return this;
    }

    public ItemStackFactory withPersistentData(Consumer<PersistentData> persistentDataConsumer) {
        persistentData = new PersistentData();
        persistentDataConsumer.accept(persistentData);
        return this;
    }

    public ItemStackFactory applyPersistentData(@Nullable NamespacedKey namespacedKey) {
        if (persistentData != null) {
            persistentData.applyTo(itemMeta, namespacedKey);
        }
        return this;
    }

    public ItemStackFactory hideAttributes() {
        final NamespacedKey namespacedKey = new NamespacedKey(FortressWarsAPI.NAMESPACE, "dummy.attribute");
        itemMeta.addAttributeModifier(
                Attribute.LUCK,
                new AttributeModifier(
                        namespacedKey,
                        0,
                        AttributeModifier.Operation.ADD_NUMBER,
                        EquipmentSlotGroup.ARMOR
                )
        );
        itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        return this;
    }

    public ItemStackFactory addMeleeDamage(double damage) {
        final NamespacedKey namespacedKey = new NamespacedKey(FortressWarsAPI.NAMESPACE, "generic.attack_damage." + UUID.randomUUID());
        itemMeta.addAttributeModifier(
                Attribute.ATTACK_DAMAGE,
                new AttributeModifier(
                        namespacedKey,
                        damage - 1,
                        AttributeModifier.Operation.ADD_NUMBER,
                        EquipmentSlotGroup.MAINHAND
                )
        );
        return this;
    }

    public ItemStackFactory addMeleeSpeed(double speed) {
        final NamespacedKey namespacedKey = new NamespacedKey(FortressWarsAPI.NAMESPACE, "generic.attack_speed." + UUID.randomUUID());
        itemMeta.addAttributeModifier(
                Attribute.ATTACK_SPEED,
                new AttributeModifier(
                        namespacedKey,
                        speed - 4,
                        AttributeModifier.Operation.ADD_NUMBER,
                        EquipmentSlotGroup.MAINHAND
                )
        );
        return this;
    }

    public ItemStackFactory setArmorToughness(double armorToughness, EquipmentSlotGroup slot) {
        final NamespacedKey namespacedKey = new NamespacedKey(FortressWarsAPI.NAMESPACE, "generic.armorToughness." + UUID.randomUUID());
        itemMeta.removeAttributeModifier(Attribute.ARMOR_TOUGHNESS);
        itemMeta.addAttributeModifier(
                Attribute.ARMOR_TOUGHNESS,
                new AttributeModifier(
                        namespacedKey,
                        armorToughness,
                        AttributeModifier.Operation.ADD_NUMBER,
                        slot
                )
        );
        return this;
    }

    public ItemStackFactory setKnockbackResistance(double armorKnockbackResistance, EquipmentSlotGroup slot) {
        final NamespacedKey namespacedKey = new NamespacedKey(FortressWarsAPI.NAMESPACE, "generic.armorKnockbackResistance." + UUID.randomUUID());
        itemMeta.removeAttributeModifier(Attribute.KNOCKBACK_RESISTANCE);
        itemMeta.addAttributeModifier(
                Attribute.KNOCKBACK_RESISTANCE,
                new AttributeModifier(
                        namespacedKey,
                        armorKnockbackResistance,
                        AttributeModifier.Operation.ADD_NUMBER,
                        slot
                )
        );
        return this;
    }

    public ItemStackFactory setArmorPoints(double armorPoints, EquipmentSlotGroup slot) {
        final NamespacedKey namespacedKey = new NamespacedKey(FortressWarsAPI.NAMESPACE, "generic.armor." + UUID.randomUUID());
        itemMeta.removeAttributeModifier(Attribute.ARMOR);
        itemMeta.addAttributeModifier(
                Attribute.ARMOR,
                new AttributeModifier(
                        namespacedKey,
                        armorPoints,
                        AttributeModifier.Operation.ADD_NUMBER,
                        slot
                )
        );
        return this;
    }

    public ItemStackFactory setFoodComponent(FoodComponent foodComponment) {
        itemMeta.setFood(foodComponment);
        return this;
    }

    public ItemStackFactory setConsumable(Consumable consumable) {
        setData(DataComponentTypes.CONSUMABLE, consumable);
        return this;
    }

    public FoodComponent getFoodComponent() {
        return itemMeta.getFood();
    }

    public ItemStackFactory setItemModel(Material material) {
        final NamespacedKey materialKey = material.getKey();
        itemMeta.setItemModel(materialKey);
        return this;
    }

    /**
     * Add an enchantment to the item
     * @param enchantment enchantment to add
     * @param level level of the enchantment
     * @return the ItemStackFactory
     */
    public ItemStackFactory enchant(Enchantment enchantment, int level) {
        itemMeta.addEnchant(enchantment, level, true);
        return this;
    }

    /**
     * Remove an enchantment from the item
     * @param enchantment enchantment to remove
     * @return the ItemStackFactory
     */
    public ItemStackFactory removeEnchant(Enchantment enchantment) {
        itemMeta.removeEnchant(enchantment);
        return this;
    }

    public ItemStackFactory setModalData(int data) {
        itemMeta.setCustomModelData(data);
        return this;
    }

    public ItemStackFactory setPotionColor(Color color) {
        if (itemMeta instanceof PotionMeta pm) {
            pm.setColor(color);
        }
        return this;
    }

    public ItemStackFactory setPotionEffect(PotionEffect potionEffect) {
        if (itemMeta instanceof PotionMeta pm) {
            pm.addCustomEffect(potionEffect, false);
        }
        return this;
    }

    public ItemStackFactory setAuthor(String author) {
        if (itemMeta instanceof BookMeta bm) {
            bm.setAuthor(author);
        }
        return this;
    }

    public ItemStackFactory setBookPages(String... pages) {
        if (itemMeta instanceof BookMeta bm) {
            bm.setPages(pages);
        }
        return this;
    }

    public ItemStackFactory setBookPages(List<String> pages) {
        if (itemMeta instanceof BookMeta bm) {
            bm.setPages(pages);
        }
        return this;
    }

    public ItemStackFactory clearPotionEffects() {
        if (itemMeta instanceof PotionMeta pm) {
            pm.clearCustomEffects();
        }
        return this;
    }

    public ItemStackFactory setAmount(int amount) {
        item.setAmount(amount);
        return this;
    }

    public ItemStackFactory setDurabilityDamage(int durability) {
        if (itemMeta instanceof Damageable damageable) {
            damageable.setDamage(Math.max(0, durability));
        }
        return this;
    }

    public ItemStackFactory setMaxDurabilityDamage(int maxDurability) {
        if (itemMeta instanceof Damageable damageable) {
            damageable.setMaxDamage(maxDurability);
        }
        return this;
    }

    public ItemStackFactory setBannerBaseColor(DyeColor dyeColor) {
        if (blockState instanceof Banner bannerBlockState) {
            bannerBlockState.setBaseColor(dyeColor);
        }
        return this;
    }

    public ItemStackFactory setBannerPattern(Pattern... patterns) {
        if (blockState instanceof Banner bannerBlockState) {
            bannerBlockState.setPatterns(List.of(patterns));
        }
        return this;
    }

    public ItemStackFactory setLeatherColor(Color color) {
        if (itemMeta instanceof LeatherArmorMeta leatherArmorMeta) {
            leatherArmorMeta.setColor(color);
        }
        return this;
    }

    public ItemStackFactory clearChargedProjectiles() {
        if (itemMeta instanceof CrossbowMeta crossbowMeta) {
            crossbowMeta.setChargedProjectiles(new ArrayList<>());

        }
        return this;
    }

    public ItemStackFactory setArmorTrim(TrimMaterial material, TrimPattern pattern) {
        if (itemMeta instanceof ArmorMeta armorMeta) {
            armorMeta.setTrim(new ArmorTrim(material, pattern));
        }
        return this;
    }

    public ItemStackFactory removeArmorTrim() {
        if (itemMeta instanceof ArmorMeta armorMeta) {
            armorMeta.setTrim(null);
        }
        return this;
    }

    public boolean hasChargedProjectiles() {
        if (itemMeta instanceof CrossbowMeta crossbowMeta) {
            return crossbowMeta.hasChargedProjectiles();
        }
        return false;
    }

    public ItemStackFactory addChargedProjectile(ItemStack projectileItem) {
        if (itemMeta instanceof CrossbowMeta crossbowMeta) {
            crossbowMeta.addChargedProjectile(projectileItem);
        }

        return this;
    }

    public ItemStackFactory addFireworkEffect(FireworkEffect fireworkEffect) {
        if (itemMeta instanceof FireworkMeta fireworkMeta) {
            fireworkMeta.addEffect(fireworkEffect);
        }

        return this;
    }

    public ItemStackFactory clearLodestone() {
        if (itemMeta instanceof CompassMeta compassMeta) {
            compassMeta.clearLodestone();
        }
        return this;
    }

    public ItemStackFactory setLodestoneTracked(boolean isLodestoneTracked) {
        if (itemMeta instanceof CompassMeta compassMeta) {
            compassMeta.setLodestoneTracked(isLodestoneTracked);
        }
        return this;
    }

    public ItemStackFactory setLodestone(Location lodestone) {
        if (itemMeta instanceof CompassMeta compassMeta) {
            compassMeta.setLodestone(lodestone);
        }

        return this;
    }

    public <T> ItemStackFactory setData(DataComponentType.Valued<T> key, T value) {
        dataComponentMap.put((DataComponentType.Valued<Object>) key, value);
        item.setData(key, value);
        return this;
    }

    public <T> T getData(DataComponentType.Valued<T> key) {
        return item.getData(key);
    }

    public ItemStackFactory addBundleItem(ItemStack item) {
        if (itemMeta instanceof BundleMeta bundleMeta) {
            bundleMeta.addItem(item);
        }
        return this;
    }

    public ItemStackFactory setBundleItems(List<ItemStack> items) {
        if (itemMeta instanceof BundleMeta bundleMeta) {
            bundleMeta.setItems(items);
        }
        return this;
    }

    public ItemStackFactory setCooldownComponent(NamespacedKey key, float seconds) {
        final UseCooldownComponent component = itemMeta.getUseCooldown();
        component.setCooldownGroup(key);
        component.setCooldownSeconds(seconds);
        itemMeta.setUseCooldown(component);
        return this;
    }

    public ItemStackFactory setProfile(PlayerProfile profile) {
        if (itemMeta instanceof SkullMeta skullMeta) {
            skullMeta.setPlayerProfile(profile);
        }
        return this;
    }

    public ItemStack build() {
        if (itemMeta instanceof BlockStateMeta blockStateMeta) {
            blockStateMeta.setBlockState(blockState);
        }
        item.setItemMeta(itemMeta);

        // We must set the data components after setting the meta!!!!!
        for (DataComponentType.Valued<Object> key : dataComponentMap.keySet()) {
            item.setData(key, dataComponentMap.get(key));
        }

        return item;
    }

    // ==================================================================
    //                             Getters
    // ==================================================================

    public int getDamage() {
        if (itemMeta instanceof Damageable damageable) {
            return damageable.getDamage();
        }
        return 0;
    }

    public int getMaxDamage() {
        if (itemMeta instanceof Damageable damageable) {
            return damageable.getMaxDamage();
        }
        return 0;
    }

    public String getTitle() {
        return itemMeta.getDisplayName();
    }
}

