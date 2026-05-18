package net.fortresswars.core.cosmetics;

import org.bukkit.Material;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public enum FWArrowTrail {
    NONE(
            "None",
            "No Arrow Trail",
            Material.BARRIER,
            0
    ),
    FLAME(
            "Trail Blazer",
            "Small flame particles that blaze out of the arrow. Flame burst on hit.",
            Material.BLAZE_POWDER,
            0
    ),
    WATER(
            "Bubble Popping Bath",
            "Water particles convert your arrow into bubble. Explodes into A water sphere on impact.",
            Material.WATER_BUCKET,
            0
    ),
    EMERALD(
            "Emerald Trail",
            "Vibrant green particles that follow the arrow. Burst of particles on hit.",
            Material.EMERALD_BLOCK,
            0
    ),
    NOTE(
            "Performer",
            "Music notes that perform on the arrow. Plays a sound on hit.",
            Material.NOTE_BLOCK,
            0
    ),
    PORTAL(
            "Interdimensional",
            "Portal particles leak out of the other side as the arrow is piercing the overworld. Implodes and then explodes on hit", Material.CRYING_OBSIDIAN, 0),
    SCULK(
            "Ancient Curse",
            "Sculk particles that possess the arrow. Taints the target on hit.",
            Material.ECHO_SHARD,
            0
    ),
    NAUTILUS(
            "Nautilus",
            "Nautilus particles straight out of the ocean. Implodes on hit.",
            Material.NAUTILUS_SHELL,
            0
    ),
    SOUL(
            "Release of Spirits",
            "Soul particles that release from the arrow. Releases many souls on hit.",
            Material.SOUL_SAND,
            0
    ),
    RAINBOW(
            "Colorful Display",
            "A rainbow follows the arrow and has a angelic chime to it.",
            Material.END_CRYSTAL,
            0
    )
    ;

    private final String name;
    private final String description;
    private final Material icon;
    private final int cost;

    private static final List<FWArrowTrail> arrowTrailList = new ArrayList<>(40);
    FWArrowTrail(String name, String description, Material icon, int cost) {
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

    public static List<FWArrowTrail> getArrowTrailsList() {
        if (!arrowTrailList.isEmpty()) {
            Collections.addAll(arrowTrailList, FWArrowTrail.values());
            Collections.sort(arrowTrailList);
        }
        return arrowTrailList;
    }
}

