package net.fortresswars.core.cosmetics;

import org.bukkit.Material;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public enum FWParticleEffect {

    NONE(
            "None",
            "No Particle Effect",
            Material.BARRIER,
            0
    ),
    FLAME(
            "Flame Effect",
            "Flame circle while you are standing still and a flame trail while you are moving.",
            Material.BLAZE_POWDER,
            0
    ),
    RAIN_CLOUD(
            "Rain Cloud",
            "Clouds with a rain effect.",
            Material.WHITE_WOOL,
            0
    ),
    ENCHANTED(
            "Enchanted",
            "Enchanted book particles as if you are consuming knowledge.",
            Material.BOOK,
            0
    ),
    BUBBLING(
            "Bubbling",
            "Bubble particles that pop.",
            Material.AXOLOTL_BUCKET,
            0
    ),
    HAPPY(
            "Happy Trail",
            "A Green Joyful particle surrounds your movement.",
            Material.EMERALD,
            0
    ),
    ANGRY(
            "Steaming Anger",
            "A Angry particle floats above your head while standing still and a trail of smoke clouding your movement.",
            Material.MAGMA_CREAM,
            0
    ),
    MUSIC(
            "Note Block Hero",
            "For those who enjoy a colorful display of music",
            Material.JUKEBOX,
            0
    ),
    RAINBOW(
            "Rainbow Halo",
            "A rainbow ring that orbits above the player.",
            Material.END_CRYSTAL,
            0
    ),
    ;

    private static final List<FWParticleEffect> particleEffectsList = new ArrayList<>(40);

    private final String name;
    private final String description;
    private final Material icon;
    private final int cost;

    FWParticleEffect(String name, String description, Material icon, int cost) {
        this.name = name;
        this.description = description;
        this.icon = icon;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Material getIcon() {
        return icon;
    }

    public int cost() {
        return cost;
    }

    public static List<FWParticleEffect> getParticleEffectsList() {
        if (!particleEffectsList.isEmpty()) {
            Collections.addAll(particleEffectsList, FWParticleEffect.values());
            Collections.sort(particleEffectsList);
        }
        return particleEffectsList;
    }
}
