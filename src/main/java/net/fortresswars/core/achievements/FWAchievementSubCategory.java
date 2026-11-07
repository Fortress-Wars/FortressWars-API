package net.fortresswars.core.achievements;

public enum FWAchievementSubCategory {

    // GENERAL SUBCATEGORIES
    ACHIEVEMENTS_GENERAL_JOIN_SERVER(FWAchievementCategory.GENERAL),
    ACHIEVEMENTS_GENERAL(FWAchievementCategory.GENERAL),
    ACHIEVEMENTS_GENERAL_UNLOCK_KIT(FWAchievementCategory.GENERAL),
    ACHIEVEMENTS_GENERAL_TOP_STATS_IN_GAME(FWAchievementCategory.GENERAL),

    // STATS ACHIEVEMENT TABLES
    ACHIEVEMENTS_STATS_WINS(FWAchievementCategory.STATS),
    ACHIEVEMENTS_STATS_ELIMINATION(FWAchievementCategory.STATS),
    ACHIEVEMENTS_STATS_KILLSTREAK(FWAchievementCategory.STATS),
    ACHIEVEMENTS_STATS_DAMAGE_DEALT(FWAchievementCategory.STATS),

    // KIT SUBCATEGORIES
    ACHIEVEMENTS_RAVEN(FWAchievementCategory.KITS),
    ACHIEVEMENTS_AQUAMAN(FWAchievementCategory.KITS),
    ACHIEVEMENTS_BOMBER(FWAchievementCategory.KITS),
    ACHIEVEMENTS_BRUTE(FWAchievementCategory.KITS),
    ACHIEVEMENTS_BUFF_MASTER(FWAchievementCategory.KITS),
    ACHIEVEMENTS_BUILDER(FWAchievementCategory.KITS),
    ACHIEVEMENTS_CRUSADER(FWAchievementCategory.KITS),
    ACHIEVEMENTS_CRUSHER(FWAchievementCategory.KITS),
    ACHIEVEMENTS_VITALIST(FWAchievementCategory.KITS),
//    ACHIEVEMENTS_DEFAULT(FWAchievementCategory.KITS),
    ACHIEVEMENTS_DEMOLITIONIST(FWAchievementCategory.KITS),
    ACHIEVEMENTS_DEMON(FWAchievementCategory.KITS),
    ACHIEVEMENTS_GOLEM(FWAchievementCategory.KITS),
    ACHIEVEMENTS_GRAPPLER(FWAchievementCategory.KITS),
    ACHIEVEMENTS_WIZARD(FWAchievementCategory.KITS),
    ACHIEVEMENTS_ENGINEER(FWAchievementCategory.KITS),
    ACHIEVEMENTS_FISH(FWAchievementCategory.KITS),
    ACHIEVEMENTS_GUNNER(FWAchievementCategory.KITS),
    ACHIEVEMENTS_HITMAN(FWAchievementCategory.KITS),
    ACHIEVEMENTS_HULK(FWAchievementCategory.KITS),
    ACHIEVEMENTS_ILLUSIONIST(FWAchievementCategory.KITS),
    ACHIEVEMENTS_JUMPER(FWAchievementCategory.KITS),
    ACHIEVEMENTS_KANGAROO(FWAchievementCategory.KITS),
    ACHIEVEMENTS_KNIGHT(FWAchievementCategory.KITS),
    ACHIEVEMENTS_MASTER(FWAchievementCategory.KITS),
    ACHIEVEMENTS_MATHEMATICIAN(FWAchievementCategory.KITS),
    ACHIEVEMENTS_MEDIC(FWAchievementCategory.KITS),
    ACHIEVEMENTS_MERCY(FWAchievementCategory.KITS),
    ACHIEVEMENTS_MINER(FWAchievementCategory.KITS),
    ACHIEVEMENTS_MUSKETEER(FWAchievementCategory.KITS),
    ACHIEVEMENTS_NECROMANCER(FWAchievementCategory.KITS),
    ACHIEVEMENTS_NINJA(FWAchievementCategory.KITS),
//    ACHIEVEMENTS_NONE(FWAchievementCategory.SECRET),
    ACHIEVEMENTS_PORCUPINE(FWAchievementCategory.KITS),
    ACHIEVEMENTS_POTION_MASTER(FWAchievementCategory.KITS),
    ACHIEVEMENTS_PRIEST(FWAchievementCategory.KITS),
    ACHIEVEMENTS_PYROTECHNIC(FWAchievementCategory.KITS),
    ACHIEVEMENTS_SLIME(FWAchievementCategory.KITS),
    ACHIEVEMENTS_SNIPER(FWAchievementCategory.KITS),
    ACHIEVEMENTS_SNOW_GOLEM(FWAchievementCategory.KITS),
    ACHIEVEMENTS_SNOWMAN(FWAchievementCategory.KITS),
    ACHIEVEMENTS_SOLDIER(FWAchievementCategory.KITS),
    ACHIEVEMENTS_SONIC(FWAchievementCategory.KITS),
    ACHIEVEMENTS_SPIDER(FWAchievementCategory.KITS),
    ACHIEVEMENTS_SPY(FWAchievementCategory.KITS),
    ACHIEVEMENTS_AQUARIUS(FWAchievementCategory.KITS),
    ACHIEVEMENTS_PROMETHEUS(FWAchievementCategory.KITS),
    ACHIEVEMENTS_GLACIER(FWAchievementCategory.KITS),

    // MAPS
    CLASSIC_MAP_WIN(FWAchievementCategory.MAPS),
    KOTH_MAP_WIN(FWAchievementCategory.MAPS),
    AD_MAP_WIN(FWAchievementCategory.MAPS),

    // SECRET

    ;

    private final FWAchievementCategory parentCategory;

    FWAchievementSubCategory(FWAchievementCategory parentCategory) {
        this.parentCategory = parentCategory;
    }

    public FWAchievementCategory getParentCategory() {
        return parentCategory;
    }
}
