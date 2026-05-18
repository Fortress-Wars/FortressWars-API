package net.fortresswars.core.cosmetics;

import org.bukkit.Material;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum FWBlockEffect {
    NONE(
            "None",
            "No effect",
            "No effect",
            Material.BARRIER,
            0
    ),
    FLAME(
            "Flame",
            "Small flames that outline the block.",
            "Small flames that outline the block.",
            Material.BLAZE_POWDER,
            0
    ),
    WATER(
            "Water",
            "Bubble splash effect as if the water was made out of water.",
            "Bubble splash effect as if the water was made out of water.",
            Material.WATER_BUCKET,
            0
    ),
    GREEN_DUST(
            "Green Dust",
            "Dust particles that happen to be green.",
            "Dust particles that happen to be green.",
            Material.LIME_DYE,
            0
    ),
    SMOKE(
            "Smoke",
            "Black smoke particles outlining the block shape.",
            "Black smoke particles outlining the block shape.",
            Material.COAL_BLOCK,
            0
    ),
    SPARK(
            "Spark",
            "Quick flash of electric particles.",
            "Quick flash of electric particles.",
            Material.AMETHYST_SHARD,
            0
    ),
    ENCHANTED(
            "Enchanted",
            "Book particles indicating that the block was broken by someone special.",
            "Book particles indicating that the block was placed by someone special.",
            Material.BOOK,
            0
    ),
    POTION(
            "Potion",
            "Black potion particles flowing upwards.",
            "Black potion particles flowing upwards.",
            Material.SPLASH_POTION,
            0
    ),
    SOUL(
            "Soul",
            "Soulsand soul particles that outline the block.",
            "Soulsand soul particles that outline the block.",
            Material.SOUL_SAND,
            0
    ),
    PORTAL(
            "Portal",
            "Portal particles that come from above and then settle in place.",
            "Portal particles that linger around for a bit.",
            Material.CRYING_OBSIDIAN,
            0
    ),
    SCULK(
            "Sculk",
            "Sculk bubbles forming around the edges of the block.",
            "Sculk popping on the edges of the block",
            Material.SCULK,
            0
    ),
    FIREWORK(
            "Firework",
            "White firework particles that linger and slowly fall.",
            "White firework particles that linger and slowly fall.",
            Material.FIREWORK_ROCKET,
            0
    ),
    RAINBOW(
            "Rainbow Dust",
            "A rainbow of colors that outline the edge of the block.",
            "A rainbow of colors that outline the edge of the block.",
            Material.END_CRYSTAL,
            0
    ),

    ;

    private final String name;
    private final String blockBreakDescription;
    private final String blockPlaceDescription;
    private final Material icon;
    private final int cost;

    private static final List<FWBlockEffect> blockEffectList = new ArrayList<>(40);
    FWBlockEffect(String name, String blockBreakDescription, String blockPlaceDescription, Material icon, int cost) {
        this.name = name;
        this.blockBreakDescription = blockBreakDescription;
        this.blockPlaceDescription = blockPlaceDescription;
        this.icon = icon;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public String getBlockBreakDescription() {
        return blockBreakDescription;
    }

    public String getBlockPlaceDescription() {
        return blockPlaceDescription;
    }

    public Material getIcon() {
        return icon;
    }

    public int cost() {
        return cost;
    }


    public static List<FWBlockEffect> getBlockEffectList() {
        if (blockEffectList.isEmpty()) {
            Collections.addAll(Arrays.asList(FWBlockEffect.values()));
            Collections.sort(blockEffectList);
        }
        return blockEffectList;
    }
}
