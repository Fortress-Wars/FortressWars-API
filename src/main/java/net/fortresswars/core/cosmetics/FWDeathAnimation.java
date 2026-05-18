package net.fortresswars.core.cosmetics;

import org.bukkit.Material;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public enum FWDeathAnimation {
    NONE(
            "None",
            "No Death Animation",
            Material.BARRIER,
            0
    ),
    SIMPLE_FIRE(
            "Simple Fire",
            "Flame, smoke, and falling lava particles",
            Material.MAGMA_BLOCK,
            5000
    ),
    SMITE(
            "Smite",
            "Lightning effect with electric and potion particles",
            Material.AMETHYST_SHARD,
            5000
    ),
    SIMPLE_SPLASH(
            "Simple Splash",
            "Splash animation with water particles and sounds",
            Material.WATER_BUCKET,
            5000
    ),
    SQUID_FIREWORK(
            "Squid Firework",
            "A squid rocket, that explodes into a firework",
            Material.INK_SAC,
            5000
    ),
    GLOW_SQUID_FIREWORK(
            "Glow Squid Firework",
            "A squid rocket, that explodes into a firework, but pretty",
            Material.GLOW_INK_SAC,
            5000
    ),
    COW_FIREWORK(
            "Cow Firework"
            , "A cow rocket, that explodes after a short while",
            Material.BEEF,
            5000
    ),
    BLOOD_EXPLOSION(
            "Blood Explosion",
            "An explosion of blood effect",
            Material.REDSTONE,
            5000
    ),
    BUNNY_EXPLOSIONS(
            "Bunny Explosions",
            "6 Bunnies that explode after a bit",
            Material.RABBIT_FOOT,
            5000
    ),
    BAT_SWARM(
            "Bat Swarm",
            "Bats swarm the enemies corpse and will dissipate after a while",
            Material.PHANTOM_MEMBRANE,
            5000
    ),
    BREAKING_BONES(
            "Breaking Bones",
            "Effect as if the body was crushed",
            Material.BONE,
            5000
    ),
    SCULK(
            "Sculk-splosion",
            "Sculk exploding from the body as if they were infected by it",
            Material.ECHO_SHARD,
            5000
    ),
    POOF(
            "Poof",
            "Poof like a magician",
            Material.SNOW_BLOCK,
            5000
    ),
    PORTAL(
            "Portal",
            "Portal effect as if they were teleported to another dimension when they were eliminated",
            Material.CRYING_OBSIDIAN,
            5000
    ),
    ;

    private static final List<FWDeathAnimation> deathAnimationList = new ArrayList<>(40);

    private final String name;
    private final String description;
    private final Material icon;
    private final int cost;

    FWDeathAnimation(String name, String description, Material icon, int cost) {
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

    public static List<FWDeathAnimation> getDeathAnimationList() {
        if (deathAnimationList.isEmpty()) {
            Collections.addAll(deathAnimationList, FWDeathAnimation.values());
            Collections.sort(deathAnimationList);
        }
        return deathAnimationList;
    }
}
