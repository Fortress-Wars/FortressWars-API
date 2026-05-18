package net.fortresswars.core.kits;

import net.fortresswars.core.achievements.FWAchievementSubCategory;
import net.fortresswars.core.statistics.FWStat;
import org.bukkit.Material;

import java.util.*;

public enum KitID {


    AQUAMAN("Aquaman", KitRole.DAMAGE, KitTag.PREMIUM, Material.TRIDENT, FWAchievementSubCategory.ACHIEVEMENTS_AQUAMAN,
            List.of(
                    FWStat.AQUAMAN_TIME_PLAYED,
                    FWStat.AQUAMAN_GAMES_PLAYED,
                    FWStat.AQUAMAN_TOTAL_WINS_UNWEIGHTED,
                    FWStat.AQUAMAN_TOTAL_DRAWS_UNWEIGHTED,
                    FWStat.AQUAMAN_TOTAL_LOSSES_UNWEIGHTED,
                    FWStat.AQUAMAN_TOTAL_WINS_WEIGHTED,
                    FWStat.AQUAMAN_TOTAL_DRAWS_WEIGHTED,
                    FWStat.AQUAMAN_TOTAL_LOSSES_WEIGHTED,
                    FWStat.AQUAMAN_ELIMINATIONS,
                    FWStat.AQUAMAN_FINAL_BLOWS,
                    FWStat.AQUAMAN_ASSISTS,
                    FWStat.AQUAMAN_DEATHS,
                    FWStat.AQUAMAN_SUICIDES,
                    FWStat.AQUAMAN_DAMAGE_DEALT,
                    FWStat.AQUAMAN_DAMAGE_TAKEN,
                    FWStat.AQUAMAN_TRIDENTS_HIT,
                    FWStat.AQUAMAN_WATER_SPHERES,
                    FWStat.AQUAMAN_TRIDENT_KILLS,
                    FWStat.AQUAMAN_FAR_TRIDENT_KILLS
            )
    ),

    AQUARIUS("Aquarius", KitRole.SUPPORT, KitTag.PREMIUM, Material.HEART_OF_THE_SEA, FWAchievementSubCategory.ACHIEVEMENTS_AQUARIUS,
            List.of(
                FWStat.AQUARIUS_TIME_PLAYED,
                FWStat.AQUARIUS_GAMES_PLAYED,
                FWStat.AQUARIUS_TOTAL_WINS_UNWEIGHTED,
                FWStat.AQUARIUS_TOTAL_DRAWS_UNWEIGHTED,
                FWStat.AQUARIUS_TOTAL_LOSSES_UNWEIGHTED,
                FWStat.AQUARIUS_TOTAL_WINS_WEIGHTED,
                FWStat.AQUARIUS_TOTAL_DRAWS_WEIGHTED,
                FWStat.AQUARIUS_TOTAL_LOSSES_WEIGHTED,
                FWStat.AQUARIUS_ELIMINATIONS,
                FWStat.AQUARIUS_FINAL_BLOWS,
                FWStat.AQUARIUS_ASSISTS,
                FWStat.AQUARIUS_DEATHS,
                FWStat.AQUARIUS_SUICIDES,
                FWStat.AQUARIUS_DAMAGE_DEALT,
                FWStat.AQUARIUS_DAMAGE_TAKEN,
                FWStat.AQUARIUS_MANA_CONSUMED,
                FWStat.AQUARIUS_WATER_HEALING,
                FWStat.AQUARIUS_WATER_BEAMS,
                FWStat.AQUARIUS_WATER_BOMBS
            )
    ),

    ARCHMAGE("Archmage", KitRole.DAMAGE, KitTag.EXCLUSIVE, Material.BREEZE_ROD, null,
            List.of(
                FWStat.ARCHMAGE_TIME_PLAYED,
                FWStat.ARCHMAGE_TOTAL_WINS_WEIGHTED,
                FWStat.ARCHMAGE_TOTAL_DRAWS_WEIGHTED,
                FWStat.ARCHMAGE_TOTAL_LOSSES_WEIGHTED,
                FWStat.ARCHMAGE_GAMES_PLAYED,
                FWStat.ARCHMAGE_TOTAL_WINS_UNWEIGHTED,
                FWStat.ARCHMAGE_TOTAL_DRAWS_UNWEIGHTED,
                FWStat.ARCHMAGE_TOTAL_LOSSES_UNWEIGHTED,
                FWStat.ARCHMAGE_ELIMINATIONS,
                FWStat.ARCHMAGE_FINAL_BLOWS,
                FWStat.ARCHMAGE_ASSISTS,
                FWStat.ARCHMAGE_DEATHS,
                FWStat.ARCHMAGE_SUICIDES,
                FWStat.ARCHMAGE_DAMAGE_DEALT,
                FWStat.ARCHMAGE_DAMAGE_TAKEN,
                FWStat.ARCHMAGE_MANA_CONSUMED
            )
    ),

    BOMBER("Bomber", KitRole.DAMAGE, KitTag.PREMIUM, Material.TNT, FWAchievementSubCategory.ACHIEVEMENTS_BOMBER,
            List.of(
                    FWStat.BOMBER_TIME_PLAYED,
                    FWStat.BOMBER_GAMES_PLAYED,
                    FWStat.BOMBER_TOTAL_WINS_UNWEIGHTED,
                    FWStat.BOMBER_TOTAL_DRAWS_UNWEIGHTED,
                    FWStat.BOMBER_TOTAL_LOSSES_UNWEIGHTED,
                    FWStat.BOMBER_TOTAL_WINS_WEIGHTED,
                    FWStat.BOMBER_TOTAL_DRAWS_WEIGHTED,
                    FWStat.BOMBER_TOTAL_LOSSES_WEIGHTED,
                    FWStat.BOMBER_ELIMINATIONS,
                    FWStat.BOMBER_FINAL_BLOWS,
                    FWStat.BOMBER_ASSISTS,
                    FWStat.BOMBER_DEATHS,
                    FWStat.BOMBER_SUICIDES,
                    FWStat.BOMBER_DAMAGE_DEALT,
                    FWStat.BOMBER_DAMAGE_TAKEN,
                    FWStat.BOMBER_BOMBS_PLACED,
                    FWStat.BOMBER_DETONATIONS,
                    FWStat.BOMBER_BOMBS_DETONATED,
                    FWStat.BOMBER_BOMB_KILLS,
                    FWStat.BOMBER_PLUS_2_BOMB_KILLS,
                    FWStat.BOMBER_PLUS_3_BOMB_KILLS
            )
    ),

    BRUTE("Brute", KitRole.DAMAGE, KitTag.PREMIUM, Material.IRON_AXE, FWAchievementSubCategory.ACHIEVEMENTS_BRUTE,
            List.of(
                FWStat.BRUTE_TIME_PLAYED,
                FWStat.BRUTE_GAMES_PLAYED,
                FWStat.BRUTE_TOTAL_WINS_UNWEIGHTED,
                FWStat.BRUTE_TOTAL_DRAWS_UNWEIGHTED,
                FWStat.BRUTE_TOTAL_LOSSES_UNWEIGHTED,
                FWStat.BRUTE_TOTAL_WINS_WEIGHTED,
                FWStat.BRUTE_TOTAL_DRAWS_WEIGHTED,
                FWStat.BRUTE_TOTAL_LOSSES_WEIGHTED,
                FWStat.BRUTE_ELIMINATIONS,
                FWStat.BRUTE_FINAL_BLOWS,
                FWStat.BRUTE_ASSISTS,
                FWStat.BRUTE_DEATHS,
                FWStat.BRUTE_SUICIDES,
                FWStat.BRUTE_DAMAGE_DEALT,
                FWStat.BRUTE_DAMAGE_TAKEN,
                FWStat.BRUTE_BERSERKS_ACTIVATED,
                FWStat.BRUTE_AXE_SWIRLS_PERFORMED,
                FWStat.BRUTE_AXE_SWIRL_KILLS,
                FWStat.BRUTE_AXE_SWIRL_DOUBLE_KILLS
            )
    ),

    BUFF_MASTER("Buff Master", KitRole.SUPPORT, KitTag.PREMIUM, Material.EMERALD, FWAchievementSubCategory.ACHIEVEMENTS_BUFF_MASTER,
            List.of(
                FWStat.BUFF_MASTER_TIME_PLAYED,
                FWStat.BUFF_MASTER_GAMES_PLAYED,
                FWStat.BUFF_MASTER_TOTAL_WINS_UNWEIGHTED,
                FWStat.BUFF_MASTER_TOTAL_DRAWS_UNWEIGHTED,
                FWStat.BUFF_MASTER_TOTAL_LOSSES_UNWEIGHTED,
                FWStat.BUFF_MASTER_TOTAL_WINS_WEIGHTED,
                FWStat.BUFF_MASTER_TOTAL_DRAWS_WEIGHTED,
                FWStat.BUFF_MASTER_TOTAL_LOSSES_WEIGHTED,
                FWStat.BUFF_MASTER_ELIMINATIONS,
                FWStat.BUFF_MASTER_FINAL_BLOWS,
                FWStat.BUFF_MASTER_ASSISTS,
                FWStat.BUFF_MASTER_DEATHS,
                FWStat.BUFF_MASTER_SUICIDES,
                FWStat.BUFF_MASTER_DAMAGE_DEALT,
                FWStat.BUFF_MASTER_DAMAGE_TAKEN,
                FWStat.BUFF_MASTER_PLAYERS_BUFFED,
                FWStat.BUFF_MASTER_REGENERATION_BUFFED,
                FWStat.BUFF_MASTER_ABSORPTION_BUFFED,
                FWStat.BUFF_MASTER_SPEED_BUFFED,
                FWStat.BUFF_MASTER_RESISTANCE_BUFFED
            )
    ),

    BUILDER("Builder", KitRole.UTILITY, KitTag.FREE, Material.BRICKS, FWAchievementSubCategory.ACHIEVEMENTS_BUILDER,
            List.of(
                FWStat.BUILDER_TIME_PLAYED,
                FWStat.BUILDER_GAMES_PLAYED,
                FWStat.BUILDER_TOTAL_WINS_UNWEIGHTED,
                FWStat.BUILDER_TOTAL_DRAWS_UNWEIGHTED,
                FWStat.BUILDER_TOTAL_LOSSES_UNWEIGHTED,
                FWStat.BUILDER_TOTAL_WINS_WEIGHTED,
                FWStat.BUILDER_TOTAL_DRAWS_WEIGHTED,
                FWStat.BUILDER_TOTAL_LOSSES_WEIGHTED,
                FWStat.BUILDER_ELIMINATIONS,
                FWStat.BUILDER_FINAL_BLOWS,
                FWStat.BUILDER_ASSISTS,
                FWStat.BUILDER_DEATHS,
                FWStat.BUILDER_SUICIDES,
                FWStat.BUILDER_DAMAGE_DEALT,
                FWStat.BUILDER_DAMAGE_TAKEN,
                FWStat.BUILDER_BRICK_KILLS,
                FWStat.BUILDER_BRICKS_PLACED,
                FWStat.BUILDER_LADDERS_PLACED
            )
    ),

    CRUSADER("Crusader", KitRole.TANK, KitTag.FREE, Material.RAW_GOLD, FWAchievementSubCategory.ACHIEVEMENTS_CRUSADER,
            List.of(
                FWStat.CRUSADER_TIME_PLAYED,
                FWStat.CRUSADER_GAMES_PLAYED,
                FWStat.CRUSADER_TOTAL_WINS_UNWEIGHTED,
                FWStat.CRUSADER_TOTAL_DRAWS_UNWEIGHTED,
                FWStat.CRUSADER_TOTAL_LOSSES_UNWEIGHTED,
                FWStat.CRUSADER_TOTAL_WINS_WEIGHTED,
                FWStat.CRUSADER_TOTAL_DRAWS_WEIGHTED,
                FWStat.CRUSADER_TOTAL_LOSSES_WEIGHTED,
                FWStat.CRUSADER_ELIMINATIONS,
                FWStat.CRUSADER_FINAL_BLOWS,
                FWStat.CRUSADER_ASSISTS,
                FWStat.CRUSADER_DEATHS,
                FWStat.CRUSADER_SUICIDES,
                FWStat.CRUSADER_DAMAGE_DEALT,
                FWStat.CRUSADER_DAMAGE_TAKEN,
                FWStat.CRUSADER_SHIELD_BASHES,
                FWStat.CRUSADER_SHIELD_BASHES_HIT,
                FWStat.CRUSADER_SHIELD_BASH_KILLS,
                FWStat.CRUSADER_SHIELD_BASH_PLUS_2_KILLS,
                FWStat.CRUSADER_SHIELD_BASH_PLUS_3_KILLS
            )
    ),

    CRUSHER("Crusher", KitRole.DAMAGE, KitTag.PREMIUM, Material.ANVIL, FWAchievementSubCategory.ACHIEVEMENTS_CRUSHER,
            List.of(
                FWStat.CRUSHER_TIME_PLAYED,
                FWStat.CRUSHER_GAMES_PLAYED,
                FWStat.CRUSHER_TOTAL_WINS_UNWEIGHTED,
                FWStat.CRUSHER_TOTAL_DRAWS_UNWEIGHTED,
                FWStat.CRUSHER_TOTAL_LOSSES_UNWEIGHTED,
                FWStat.CRUSHER_TOTAL_WINS_WEIGHTED,
                FWStat.CRUSHER_TOTAL_DRAWS_WEIGHTED,
                FWStat.CRUSHER_TOTAL_LOSSES_WEIGHTED,
                FWStat.CRUSHER_ELIMINATIONS,
                FWStat.CRUSHER_FINAL_BLOWS,
                FWStat.CRUSHER_ASSISTS,
                FWStat.CRUSHER_DEATHS,
                FWStat.CRUSHER_SUICIDES,
                FWStat.CRUSHER_DAMAGE_DEALT,
                FWStat.CRUSHER_DAMAGE_TAKEN,
                FWStat.CRUSHER_ANVILS_SUMMONED,
                FWStat.CRUSHER_ANVIL_HITS,
                FWStat.CRUSHER_ANVIL_HITS_DIRECT,
                FWStat.CRUSHER_ANVIL_HITS_INDIRECT,
                FWStat.CRUSHER_ANVIL_KILLS,
                FWStat.CRUSHER_DIRECT_ANVIL_KILLS,
                FWStat.CRUSHER_INDIRECT_ANVIL_KILLS,
                FWStat.CRUSHER_DOUBLE_ANVIL_KILLS,
                FWStat.CRUSHER_TRIPLE_ANVIL_KILLS
            )
    ),

    DEFAULT("Default", KitRole.DAMAGE, KitTag.FREE, Material.STONE, null,
            List.of(
                FWStat.DEFAULT_TIME_PLAYED,
                FWStat.DEFAULT_GAMES_PLAYED,
                FWStat.DEFAULT_TOTAL_WINS_UNWEIGHTED,
                FWStat.DEFAULT_TOTAL_DRAWS_UNWEIGHTED,
                FWStat.DEFAULT_TOTAL_LOSSES_UNWEIGHTED,
                FWStat.DEFAULT_TOTAL_WINS_WEIGHTED,
                FWStat.DEFAULT_TOTAL_DRAWS_WEIGHTED,
                FWStat.DEFAULT_TOTAL_LOSSES_WEIGHTED,
                FWStat.DEFAULT_ELIMINATIONS,
                FWStat.DEFAULT_FINAL_BLOWS,
                FWStat.DEFAULT_ASSISTS,
                FWStat.DEFAULT_DEATHS,
                FWStat.DEFAULT_SUICIDES,
                FWStat.DEFAULT_DAMAGE_DEALT,
                FWStat.DEFAULT_DAMAGE_TAKEN
            )
    ),

    DEMOLITIONIST("Demolitionist", KitRole.TANK, KitTag.PREMIUM, Material.FLINT_AND_STEEL, FWAchievementSubCategory.ACHIEVEMENTS_DEMOLITIONIST,
            List.of(
                FWStat.DEMOLITIONIST_TIME_PLAYED,
                FWStat.DEMOLITIONIST_GAMES_PLAYED,
                FWStat.DEMOLITIONIST_TOTAL_WINS_UNWEIGHTED,
                FWStat.DEMOLITIONIST_TOTAL_DRAWS_UNWEIGHTED,
                FWStat.DEMOLITIONIST_TOTAL_LOSSES_UNWEIGHTED,
                FWStat.DEMOLITIONIST_TOTAL_WINS_WEIGHTED,
                FWStat.DEMOLITIONIST_TOTAL_DRAWS_WEIGHTED,
                FWStat.DEMOLITIONIST_TOTAL_LOSSES_WEIGHTED,
                FWStat.DEMOLITIONIST_ELIMINATIONS,
                FWStat.DEMOLITIONIST_FINAL_BLOWS,
                FWStat.DEMOLITIONIST_ASSISTS,
                FWStat.DEMOLITIONIST_DEATHS,
                FWStat.DEMOLITIONIST_SUICIDES,
                FWStat.DEMOLITIONIST_DAMAGE_DEALT,
                FWStat.DEMOLITIONIST_DAMAGE_TAKEN,
                FWStat.DEMOLITIONIST_BOMBS_CREATED,
                FWStat.DEMOLITIONIST_BOMB_BLOCKS_BROKEN,
                FWStat.DEMOLITIONIST_BOMB_KILLS,
                FWStat.DEMOLITIONIST_DOUBLE_BOMB_KILLS,
                FWStat.DEMOLITIONIST_TRIPLE_BOMB_KILLS,
                FWStat.DEMOLITIONIST_QUADRUPLE_BOMB_KILLS
            )
    ),

    DEMON("Demon", KitRole.SUPPORT, KitTag.PREMIUM, Material.BEETROOT, FWAchievementSubCategory.ACHIEVEMENTS_DEMON,
            List.of(
                    FWStat.DEMON_TIME_PLAYED,
                    FWStat.DEMON_TOTAL_WINS_WEIGHTED,
                    FWStat.DEMON_TOTAL_WINS_UNWEIGHTED,
                    FWStat.DEMON_TOTAL_DRAWS_UNWEIGHTED,
                    FWStat.DEMON_TOTAL_LOSSES_UNWEIGHTED,
                    FWStat.DEMON_TOTAL_WINS_WEIGHTED,
                    FWStat.DEMON_TOTAL_DRAWS_WEIGHTED,
                    FWStat.DEMON_TOTAL_LOSSES_WEIGHTED,
                    FWStat.DEMON_ELIMINATIONS,
                    FWStat.DEMON_FINAL_BLOWS,
                    FWStat.DEMON_ASSISTS,
                    FWStat.DEMON_DEATHS,
                    FWStat.DEMON_SUICIDES,
                    FWStat.DEMON_DAMAGE_DEALT,
                    FWStat.DEMON_DAMAGE_TAKEN,
                    FWStat.DEMON_BLOOD_POTIONS_USED,
                    FWStat.DEMON_BLOOD_CONSUMED,
                    FWStat.DEMON_BLOOD_OBTAINED,
                    FWStat.DEMON_BLOOD_TRANSMITTED,
                    FWStat.DEMON_BLOOD_TRANSFUSED,
                    FWStat.DEMON_HEALTH_TRANSFUSED,
                    FWStat.DEMON_BLOOD_HEALING,
                    FWStat.DEMON_HOMING_HEMOGLOBIN_SPELLS_CASTED,
                    FWStat.DEMON_HOMING_HEMOGLOBIN_KILLS,
                    FWStat.DEMON_BLOOD_BONDS_FORMED,
                    FWStat.DEMON_BLOOD_BOND_BREAK_DEATHS
            )
    ),

    ENGINEER("Engineer", KitRole.UTILITY, KitTag.PREMIUM, Material.BREWING_STAND, FWAchievementSubCategory.ACHIEVEMENTS_ENGINEER,
            List.of(
                FWStat.ENGINEER_TIME_PLAYED,
                FWStat.ENGINEER_GAMES_PLAYED,
                FWStat.ENGINEER_TOTAL_WINS_UNWEIGHTED,
                FWStat.ENGINEER_TOTAL_DRAWS_UNWEIGHTED,
                FWStat.ENGINEER_TOTAL_LOSSES_UNWEIGHTED,
                FWStat.ENGINEER_TOTAL_WINS_WEIGHTED,
                FWStat.ENGINEER_TOTAL_DRAWS_WEIGHTED,
                FWStat.ENGINEER_TOTAL_LOSSES_WEIGHTED,
                FWStat.ENGINEER_ELIMINATIONS,
                FWStat.ENGINEER_FINAL_BLOWS,
                FWStat.ENGINEER_ASSISTS,
                FWStat.ENGINEER_DEATHS,
                FWStat.ENGINEER_SUICIDES,
                FWStat.ENGINEER_DAMAGE_DEALT,
                FWStat.ENGINEER_DAMAGE_TAKEN,
                FWStat.ENGINEER_METAL_USED,
                FWStat.ENGINEER_SENTRIES_BUILT,
                FWStat.ENGINEER_SENTRY_KILLS,
                FWStat.ENGINEER_DISPENSERS_BUILT,
                FWStat.ENGINEER_DISPENSER_POTIONS_GIVEN,
                FWStat.ENGINEER_ENTRANCES_BUILT,
                FWStat.ENGINEER_EXITS_BUILT,
                FWStat.ENGINEER_PLAYERS_TELEPORTED
            )
    ),

    FISH("Fish", KitRole.DAMAGE, KitTag.SPECIAL, Material.COD, FWAchievementSubCategory.ACHIEVEMENTS_FISH,
            List.of(
                FWStat.FISH_TIME_PLAYED,
                FWStat.FISH_GAMES_PLAYED,
                FWStat.FISH_TOTAL_WINS_UNWEIGHTED,
                FWStat.FISH_TOTAL_DRAWS_UNWEIGHTED,
                FWStat.FISH_TOTAL_LOSSES_UNWEIGHTED,
                FWStat.FISH_TOTAL_WINS_WEIGHTED,
                FWStat.FISH_TOTAL_DRAWS_WEIGHTED,
                FWStat.FISH_TOTAL_LOSSES_WEIGHTED,
                FWStat.FISH_ELIMINATIONS,
                FWStat.FISH_FINAL_BLOWS,
                FWStat.FISH_ASSISTS,
                FWStat.FISH_DEATHS,
                FWStat.FISH_SUICIDES,
                FWStat.FISH_DAMAGE_DEALT,
                FWStat.FISH_DAMAGE_TAKEN,
                FWStat.FISH_THROWN,
                FWStat.FISH_SHOT,
                FWStat.FISH_FISHPLOSIONS,
                FWStat.FISH_FISH_HEALING,
                FWStat.FISH_FISH_KILLS,
                FWStat.FISH_PUFFERFISH_KILLS
            )
    ),

    GLACIER("Glacier", KitRole.DAMAGE, KitTag.PREMIUM, Material.PACKED_ICE, FWAchievementSubCategory.ACHIEVEMENTS_GLACIER,
            List.of(
                    FWStat.GLACIER_TIME_PLAYED,
                    FWStat.GLACIER_GAMES_PLAYED,
                    FWStat.GLACIER_TOTAL_WINS_UNWEIGHTED,
                    FWStat.GLACIER_TOTAL_DRAWS_UNWEIGHTED,
                    FWStat.GLACIER_TOTAL_LOSSES_UNWEIGHTED,
                    FWStat.GLACIER_TOTAL_WINS_WEIGHTED,
                    FWStat.GLACIER_TOTAL_DRAWS_WEIGHTED,
                    FWStat.GLACIER_TOTAL_LOSSES_WEIGHTED,
                    FWStat.GLACIER_ELIMINATIONS,
                    FWStat.GLACIER_FINAL_BLOWS,
                    FWStat.GLACIER_ASSISTS,
                    FWStat.GLACIER_DEATHS,
                    FWStat.GLACIER_SUICIDES,
                    FWStat.GLACIER_DAMAGE_DEALT,
                    FWStat.GLACIER_DAMAGE_TAKEN,
                    FWStat.GLACIER_ICE_BALLS_THROWN,
                    FWStat.GLACIER_ENEMIES_FROZEN,
                    FWStat.GLACIER_SNOWDRIFT_GLIDES
            )

    ),

    GOLEM("Golem", KitRole.TANK, KitTag.PREMIUM, Material.MUD, FWAchievementSubCategory.ACHIEVEMENTS_GOLEM,
            List.of(
                FWStat.GOLEM_TIME_PLAYED,
                FWStat.GOLEM_GAMES_PLAYED,
                FWStat.GOLEM_TOTAL_WINS_UNWEIGHTED,
                FWStat.GOLEM_TOTAL_DRAWS_UNWEIGHTED,
                FWStat.GOLEM_TOTAL_LOSSES_UNWEIGHTED,
                FWStat.GOLEM_TOTAL_WINS_WEIGHTED,
                FWStat.GOLEM_TOTAL_DRAWS_WEIGHTED,
                FWStat.GOLEM_TOTAL_LOSSES_WEIGHTED,
                FWStat.GOLEM_ELIMINATIONS,
                FWStat.GOLEM_FINAL_BLOWS,
                FWStat.GOLEM_ASSISTS,
                FWStat.GOLEM_DEATHS,
                FWStat.GOLEM_SUICIDES,
                FWStat.GOLEM_DAMAGE_DEALT,
                FWStat.GOLEM_DAMAGE_TAKEN,
                FWStat.GOLEM_MANA_CONSUMED,
                FWStat.GOLEM_EARTH_SHATTERS_CASTED,
                FWStat.GOLEM_EARTH_SHATTER_KILLS,
                FWStat.GOLEM_EARTH_SHATTER_PLUS_2_KILLS,
                FWStat.GOLEM_EARTH_WALLS_CREATED
            )
    ),

    GRAPPLER("Grappler", KitRole.DAMAGE, KitTag.PREMIUM, Material.LEAD, FWAchievementSubCategory.ACHIEVEMENTS_GRAPPLER,
            List.of(
                FWStat.GRAPPLER_TIME_PLAYED,
                FWStat.GRAPPLER_GAMES_PLAYED,
                FWStat.GRAPPLER_TOTAL_WINS_UNWEIGHTED,
                FWStat.GRAPPLER_TOTAL_DRAWS_UNWEIGHTED,
                FWStat.GRAPPLER_TOTAL_LOSSES_UNWEIGHTED,
                FWStat.GRAPPLER_TOTAL_WINS_WEIGHTED,
                FWStat.GRAPPLER_TOTAL_DRAWS_WEIGHTED,
                FWStat.GRAPPLER_TOTAL_LOSSES_WEIGHTED,
                FWStat.GRAPPLER_ELIMINATIONS,
                FWStat.GRAPPLER_FINAL_BLOWS,
                FWStat.GRAPPLER_ASSISTS,
                FWStat.GRAPPLER_DEATHS,
                FWStat.GRAPPLER_SUICIDES,
                FWStat.GRAPPLER_DAMAGE_DEALT,
                FWStat.GRAPPLER_DAMAGE_TAKEN,
                FWStat.GRAPPLER_BLOCKS_GRAPPLED,
                FWStat.GRAPPLER_ENTITIES_GRAPPLED,
                FWStat.GRAPPLER_HOOKS_CASTED,
                FWStat.GRAPPLER_FALL_DAMAGE_TAKEN,
                FWStat.GRAPPLER_FALL_DEATHS,
                FWStat.GRAPPLER_HOOK_KILLS
            )
    ),

    GUNNER("Gunner", KitRole.DAMAGE, KitTag.PREMIUM, Material.BONE, FWAchievementSubCategory.ACHIEVEMENTS_GUNNER,
            List.of(
                FWStat.GUNNER_TIME_PLAYED,
                FWStat.GUNNER_GAMES_PLAYED,
                FWStat.GUNNER_TOTAL_WINS_UNWEIGHTED,
                FWStat.GUNNER_TOTAL_DRAWS_UNWEIGHTED,
                FWStat.GUNNER_TOTAL_LOSSES_UNWEIGHTED,
                FWStat.GUNNER_TOTAL_WINS_WEIGHTED,
                FWStat.GUNNER_TOTAL_DRAWS_WEIGHTED,
                FWStat.GUNNER_TOTAL_LOSSES_WEIGHTED,
                FWStat.GUNNER_ELIMINATIONS,
                FWStat.GUNNER_FINAL_BLOWS,
                FWStat.GUNNER_ASSISTS,
                FWStat.GUNNER_DEATHS,
                FWStat.GUNNER_SUICIDES,
                FWStat.GUNNER_DAMAGE_DEALT,
                FWStat.GUNNER_DAMAGE_TAKEN,
                FWStat.GUNNER_MACHINE_GUN_KILLS
            )
    ),

    HITMAN("Hitman", KitRole.UTILITY, KitTag.PREMIUM, Material.TIPPED_ARROW, FWAchievementSubCategory.ACHIEVEMENTS_HITMAN,
            List.of(
                FWStat.HITMAN_TIME_PLAYED,
                FWStat.HITMAN_GAMES_PLAYED,
                FWStat.HITMAN_TOTAL_WINS_UNWEIGHTED,
                FWStat.HITMAN_TOTAL_DRAWS_UNWEIGHTED,
                FWStat.HITMAN_TOTAL_LOSSES_UNWEIGHTED,
                FWStat.HITMAN_TOTAL_WINS_WEIGHTED,
                FWStat.HITMAN_TOTAL_DRAWS_WEIGHTED,
                FWStat.HITMAN_TOTAL_LOSSES_WEIGHTED,
                FWStat.HITMAN_ELIMINATIONS,
                FWStat.HITMAN_FINAL_BLOWS,
                FWStat.HITMAN_ASSISTS,
                FWStat.HITMAN_DEATHS,
                FWStat.HITMAN_SUICIDES,
                FWStat.HITMAN_DAMAGE_DEALT,
                FWStat.HITMAN_DAMAGE_TAKEN,
                FWStat.HITMAN_ENEMIES_TAGGED,
                FWStat.HITMAN_DEBUFFS_APPLIED,
                FWStat.HITMAN_DARKNESS_APPLIED,
                FWStat.HITMAN_GLOWING_APPLIED,
                FWStat.HITMAN_WEAKNESS_APPLIED,
                FWStat.HITMAN_HARM_APPLIED,
                FWStat.HITMAN_DAMAGE_POTION_KILLS
            )
    ),

    HULK("Hulk", KitRole.DAMAGE, KitTag.PREMIUM, Material.CREEPER_HEAD, FWAchievementSubCategory.ACHIEVEMENTS_HULK,
            List.of(
                FWStat.HULK_TIME_PLAYED,
                FWStat.HULK_GAMES_PLAYED,
                FWStat.HULK_TOTAL_WINS_UNWEIGHTED,
                FWStat.HULK_TOTAL_DRAWS_UNWEIGHTED,
                FWStat.HULK_TOTAL_LOSSES_UNWEIGHTED,
                FWStat.HULK_TOTAL_WINS_WEIGHTED,
                FWStat.HULK_TOTAL_DRAWS_WEIGHTED,
                FWStat.HULK_TOTAL_LOSSES_WEIGHTED,
                FWStat.HULK_ELIMINATIONS,
                FWStat.HULK_FINAL_BLOWS,
                FWStat.HULK_ASSISTS,
                FWStat.HULK_DEATHS,
                FWStat.HULK_SUICIDES,
                FWStat.HULK_DAMAGE_DEALT,
                FWStat.HULK_DAMAGE_TAKEN,
                FWStat.HULK_RAGE_MODE_ACTIVATIONS,
                FWStat.HULK_RAGE_MODE_DURATION,
                FWStat.HULK_RAGE_KILLS,
                FWStat.HULK_RELAX_KILLS
            )
    ),

    ILLUSIONIST("Illusionist", KitRole.DAMAGE, KitTag.PREMIUM, Material.LINGERING_POTION, FWAchievementSubCategory.ACHIEVEMENTS_ILLUSIONIST,
            List.of(
                FWStat.ILLUSIONIST_TIME_PLAYED,
                FWStat.ILLUSIONIST_GAMES_PLAYED,
                FWStat.ILLUSIONIST_TOTAL_WINS_UNWEIGHTED,
                FWStat.ILLUSIONIST_TOTAL_DRAWS_UNWEIGHTED,
                FWStat.ILLUSIONIST_TOTAL_LOSSES_UNWEIGHTED,
                FWStat.ILLUSIONIST_TOTAL_WINS_WEIGHTED,
                FWStat.ILLUSIONIST_TOTAL_DRAWS_WEIGHTED,
                FWStat.ILLUSIONIST_TOTAL_LOSSES_WEIGHTED,
                FWStat.ILLUSIONIST_ELIMINATIONS,
                FWStat.ILLUSIONIST_FINAL_BLOWS,
                FWStat.ILLUSIONIST_ASSISTS,
                FWStat.ILLUSIONIST_DEATHS,
                FWStat.ILLUSIONIST_SUICIDES,
                FWStat.ILLUSIONIST_DAMAGE_DEALT,
                FWStat.ILLUSIONIST_DAMAGE_TAKEN,
                FWStat.ILLUSIONIST_FUTURE_SIGHTS,
                FWStat.ILLUSIONIST_FUTURE_SIGHTS_KILLS,
                FWStat.ILLUSIONIST_FAKE_DEATHS
            )
    ),

    JUMPER("Jumper", KitRole.DAMAGE, KitTag.PREMIUM, Material.ENDER_EYE, FWAchievementSubCategory.ACHIEVEMENTS_JUMPER,
            List.of(
                FWStat.JUMPER_TIME_PLAYED,
                FWStat.JUMPER_GAMES_PLAYED,
                FWStat.JUMPER_TOTAL_WINS_UNWEIGHTED,
                FWStat.JUMPER_TOTAL_DRAWS_UNWEIGHTED,
                FWStat.JUMPER_TOTAL_LOSSES_UNWEIGHTED,
                FWStat.JUMPER_TOTAL_WINS_WEIGHTED,
                FWStat.JUMPER_TOTAL_DRAWS_WEIGHTED,
                FWStat.JUMPER_TOTAL_LOSSES_WEIGHTED,
                FWStat.JUMPER_ELIMINATIONS,
                FWStat.JUMPER_FINAL_BLOWS,
                FWStat.JUMPER_ASSISTS,
                FWStat.JUMPER_DEATHS,
                FWStat.JUMPER_SUICIDES,
                FWStat.JUMPER_DAMAGE_DEALT,
                FWStat.JUMPER_DAMAGE_TAKEN,
                FWStat.JUMPER_TRANSLOCATORS_CREATED,
                FWStat.JUMPER_TRANSLOCATORS_USED,
                FWStat.JUMPER_TRANSLOCATORS_BROKEN,
                FWStat.JUMPER_DISTANCE_TELEPORTED
            )
    ),

    KANGAROO("Kangaroo", KitRole.DAMAGE, KitTag.PREMIUM, Material.DIAMOND_BOOTS, FWAchievementSubCategory.ACHIEVEMENTS_KANGAROO,
            List.of(
                FWStat.KANGAROO_TIME_PLAYED,
                FWStat.KANGAROO_GAMES_PLAYED,
                FWStat.KANGAROO_TOTAL_WINS_UNWEIGHTED,
                FWStat.KANGAROO_TOTAL_DRAWS_UNWEIGHTED,
                FWStat.KANGAROO_TOTAL_LOSSES_UNWEIGHTED,
                FWStat.KANGAROO_TOTAL_WINS_WEIGHTED,
                FWStat.KANGAROO_TOTAL_DRAWS_WEIGHTED,
                FWStat.KANGAROO_TOTAL_LOSSES_WEIGHTED,
                FWStat.KANGAROO_ELIMINATIONS,
                FWStat.KANGAROO_FINAL_BLOWS,
                FWStat.KANGAROO_ASSISTS,
                FWStat.KANGAROO_DEATHS,
                FWStat.KANGAROO_SUICIDES,
                FWStat.KANGAROO_DAMAGE_DEALT,
                FWStat.KANGAROO_DAMAGE_TAKEN,
                FWStat.KANGAROO_STOMP_KILLS
            )
    ),

    KNIGHT("Knight", KitRole.TANK, KitTag.PREMIUM, Material.NAUTILUS_SHELL, FWAchievementSubCategory.ACHIEVEMENTS_KNIGHT,
            List.of(
                FWStat.KNIGHT_TIME_PLAYED,
                FWStat.KNIGHT_GAMES_PLAYED,
                FWStat.KNIGHT_TOTAL_WINS_UNWEIGHTED,
                FWStat.KNIGHT_TOTAL_DRAWS_UNWEIGHTED,
                FWStat.KNIGHT_TOTAL_LOSSES_UNWEIGHTED,
                FWStat.KNIGHT_TOTAL_WINS_WEIGHTED,
                FWStat.KNIGHT_TOTAL_DRAWS_WEIGHTED,
                FWStat.KNIGHT_TOTAL_LOSSES_WEIGHTED,
                FWStat.KNIGHT_ELIMINATIONS,
                FWStat.KNIGHT_FINAL_BLOWS,
                FWStat.KNIGHT_ASSISTS,
                FWStat.KNIGHT_DEATHS,
                FWStat.KNIGHT_SUICIDES,
                FWStat.KNIGHT_DAMAGE_DEALT,
                FWStat.KNIGHT_DAMAGE_TAKEN,
                FWStat.KNIGHT_SHIELD_KILLS
            )
    ),

    MASTER("Master", KitRole.DAMAGE, KitTag.PREMIUM, Material.CREEPER_SPAWN_EGG, FWAchievementSubCategory.ACHIEVEMENTS_MASTER,
            List.of(
                FWStat.MASTER_TIME_PLAYED,
                FWStat.MASTER_GAMES_PLAYED,
                FWStat.MASTER_TOTAL_WINS_UNWEIGHTED,
                FWStat.MASTER_TOTAL_DRAWS_UNWEIGHTED,
                FWStat.MASTER_TOTAL_LOSSES_UNWEIGHTED,
                FWStat.MASTER_TOTAL_WINS_WEIGHTED,
                FWStat.MASTER_TOTAL_DRAWS_WEIGHTED,
                FWStat.MASTER_TOTAL_LOSSES_WEIGHTED,
                FWStat.MASTER_ELIMINATIONS,
                FWStat.MASTER_FINAL_BLOWS,
                FWStat.MASTER_ASSISTS,
                FWStat.MASTER_DEATHS,
                FWStat.MASTER_SUICIDES,
                FWStat.MASTER_DAMAGE_DEALT,
                FWStat.MASTER_DAMAGE_TAKEN,
                FWStat.MASTER_CREEPERS_SPAWNED,
                FWStat.MASTER_SUPER_CREEPERS_CREATED,
                FWStat.MASTER_CREEPER_KILLS,
                FWStat.MASTER_CREEPER_DOUBLE_KILLS,
                FWStat.MASTER_CREEPER_TRIPLE_KILLS,
                FWStat.MASTER_SUPER_CREEPER_KILLS,
                FWStat.MASTER_SUPER_CREEPER_DOUBLE_KILLS,
                FWStat.MASTER_SUPER_CREEPER_TRIPLE_KILLS
            )
    ),

    MATHEMATICIAN("Mathematician", KitRole.SUPPORT, KitTag.SPECIAL, Material.PAPER, FWAchievementSubCategory.ACHIEVEMENTS_MATHEMATICIAN,
            List.of(
                FWStat.MATHEMATICIAN_TIME_PLAYED,
                FWStat.MATHEMATICIAN_GAMES_PLAYED,
                FWStat.MATHEMATICIAN_TOTAL_WINS_UNWEIGHTED,
                FWStat.MATHEMATICIAN_TOTAL_DRAWS_UNWEIGHTED,
                FWStat.MATHEMATICIAN_TOTAL_LOSSES_UNWEIGHTED,
                FWStat.MATHEMATICIAN_TOTAL_WINS_WEIGHTED,
                FWStat.MATHEMATICIAN_TOTAL_DRAWS_WEIGHTED,
                FWStat.MATHEMATICIAN_TOTAL_LOSSES_WEIGHTED,
                FWStat.MATHEMATICIAN_ELIMINATIONS,
                FWStat.MATHEMATICIAN_FINAL_BLOWS,
                FWStat.MATHEMATICIAN_ASSISTS,
                FWStat.MATHEMATICIAN_DEATHS,
                FWStat.MATHEMATICIAN_SUICIDES,
                FWStat.MATHEMATICIAN_DAMAGE_DEALT,
                FWStat.MATHEMATICIAN_DAMAGE_TAKEN,
                FWStat.MATHEMATICIAN_PRACTICE_PROBLEM_TOTAL_HEALING,
                FWStat.MATHEMATICIAN_PRACTICE_PROBLEM_ALLY_HEALING,
                FWStat.MATHEMATICIAN_PRACTICE_PROBLEM_ENEMY_HEALING,
                FWStat.MATHEMATICIAN_PRACTICE_PROBLEM_KILLS,
                FWStat.MATHEMATICIAN_PRACTICE_PROBLEMS_DISTRIBUTED,
                FWStat.MATHEMATICIAN_PROBLEMS_SOLVED_CORRECTLY,
                FWStat.MATHEMATICIAN_PROBLEMS_SOLVED_INCORRECTLY
            )
    ),

    MEDIC("Medic", KitRole.SUPPORT, KitTag.FREE, Material.HONEY_BOTTLE, FWAchievementSubCategory.ACHIEVEMENTS_MEDIC,
            List.of(
                FWStat.MEDIC_TIME_PLAYED,
                FWStat.MEDIC_GAMES_PLAYED,
                FWStat.MEDIC_TOTAL_WINS_UNWEIGHTED,
                FWStat.MEDIC_TOTAL_DRAWS_UNWEIGHTED,
                FWStat.MEDIC_TOTAL_LOSSES_UNWEIGHTED,
                FWStat.MEDIC_TOTAL_WINS_WEIGHTED,
                FWStat.MEDIC_TOTAL_DRAWS_WEIGHTED,
                FWStat.MEDIC_TOTAL_LOSSES_WEIGHTED,
                FWStat.MEDIC_ELIMINATIONS,
                FWStat.MEDIC_FINAL_BLOWS,
                FWStat.MEDIC_ASSISTS,
                FWStat.MEDIC_DEATHS,
                FWStat.MEDIC_SUICIDES,
                FWStat.MEDIC_DAMAGE_DEALT,
                FWStat.MEDIC_DAMAGE_TAKEN,
                FWStat.MEDIC_PLAYERS_HEALED,
                FWStat.MEDIC_HEALING_DONE
            )
    ),

    MERCY("Mercy", KitRole.SUPPORT, KitTag.PREMIUM, Material.FISHING_ROD, FWAchievementSubCategory.ACHIEVEMENTS_MERCY,
            List.of(
                FWStat.MERCY_TIME_PLAYED,
                FWStat.MERCY_GAMES_PLAYED,
                FWStat.MERCY_TOTAL_WINS_UNWEIGHTED,
                FWStat.MERCY_TOTAL_DRAWS_UNWEIGHTED,
                FWStat.MERCY_TOTAL_LOSSES_UNWEIGHTED,
                FWStat.MERCY_TOTAL_WINS_WEIGHTED,
                FWStat.MERCY_TOTAL_DRAWS_WEIGHTED,
                FWStat.MERCY_TOTAL_LOSSES_WEIGHTED,
                FWStat.MERCY_ELIMINATIONS,
                FWStat.MERCY_FINAL_BLOWS,
                FWStat.MERCY_ASSISTS,
                FWStat.MERCY_DEATHS,
                FWStat.MERCY_SUICIDES,
                FWStat.MERCY_DAMAGE_DEALT,
                FWStat.MERCY_DAMAGE_TAKEN,
                FWStat.MERCY_DECAY_KILLS,
                FWStat.MERCY_HEALING_DONE
            )
    ),

    MINER("Miner", KitRole.UTILITY, KitTag.FREE, Material.DIAMOND_PICKAXE, FWAchievementSubCategory.ACHIEVEMENTS_MINER,
            List.of(
                FWStat.MINER_TIME_PLAYED,
                FWStat.MINER_GAMES_PLAYED,
                FWStat.MINER_TOTAL_WINS_UNWEIGHTED,
                FWStat.MINER_TOTAL_DRAWS_UNWEIGHTED,
                FWStat.MINER_TOTAL_LOSSES_UNWEIGHTED,
                FWStat.MINER_TOTAL_WINS_WEIGHTED,
                FWStat.MINER_TOTAL_DRAWS_WEIGHTED,
                FWStat.MINER_TOTAL_LOSSES_WEIGHTED,
                FWStat.MINER_ELIMINATIONS,
                FWStat.MINER_FINAL_BLOWS,
                FWStat.MINER_ASSISTS,
                FWStat.MINER_DEATHS,
                FWStat.MINER_SUICIDES,
                FWStat.MINER_DAMAGE_DEALT,
                FWStat.MINER_DAMAGE_TAKEN,
                FWStat.MINER_BLOCKS_BROKEN,
                FWStat.MINER_BEACON_DAMAGE,
                FWStat.MINER_BEACON_HITS,
                FWStat.MINER_GOBBLESTONE_KILLS,
                FWStat.MINER_GOBBLESTONE_DOUBLE_KILLS,
                FWStat.MINER_GOBBLESTONE_TRIPLE_KILLS,
                FWStat.MINER_GOBBLESTONE_COLLECTED,
                FWStat.MINER_GOBBLESTONE_THROWN,
                FWStat.MINER_GOBBLESTONE_BURST,
                FWStat.MINER_GOBBLESTONE_GIVEN
            )
    ),

    MUSKETEER("Musketeer", KitRole.DAMAGE, KitTag.PREMIUM, Material.SPYGLASS, FWAchievementSubCategory.ACHIEVEMENTS_MUSKETEER,
            List.of(
                FWStat.MUSKETEER_TIME_PLAYED,
                FWStat.MUSKETEER_GAMES_PLAYED,
                FWStat.MUSKETEER_TOTAL_WINS_UNWEIGHTED,
                FWStat.MUSKETEER_TOTAL_DRAWS_UNWEIGHTED,
                FWStat.MUSKETEER_TOTAL_LOSSES_UNWEIGHTED,
                FWStat.MUSKETEER_TOTAL_WINS_WEIGHTED,
                FWStat.MUSKETEER_TOTAL_DRAWS_WEIGHTED,
                FWStat.MUSKETEER_TOTAL_LOSSES_WEIGHTED,
                FWStat.MUSKETEER_ELIMINATIONS,
                FWStat.MUSKETEER_FINAL_BLOWS,
                FWStat.MUSKETEER_ASSISTS,
                FWStat.MUSKETEER_DEATHS,
                FWStat.MUSKETEER_SUICIDES,
                FWStat.MUSKETEER_DAMAGE_DEALT,
                FWStat.MUSKETEER_DAMAGE_TAKEN,
                FWStat.MUSKETEER_RIFLE_SHOTS_FIRED,
                FWStat.MUSKETEER_RIFLE_KILLS
            )
    ),

    NECROMANCER("Necromancer", KitRole.TANK, KitTag.PREMIUM, Material.CHARCOAL, FWAchievementSubCategory.ACHIEVEMENTS_NECROMANCER,
            List.of(
                FWStat.NECROMANCER_TIME_PLAYED,
                FWStat.NECROMANCER_GAMES_PLAYED,
                FWStat.NECROMANCER_TOTAL_WINS_UNWEIGHTED,
                FWStat.NECROMANCER_TOTAL_DRAWS_UNWEIGHTED,
                FWStat.NECROMANCER_TOTAL_LOSSES_UNWEIGHTED,
                FWStat.NECROMANCER_TOTAL_WINS_WEIGHTED,
                FWStat.NECROMANCER_TOTAL_DRAWS_WEIGHTED,
                FWStat.NECROMANCER_TOTAL_LOSSES_WEIGHTED,
                FWStat.NECROMANCER_ELIMINATIONS,
                FWStat.NECROMANCER_FINAL_BLOWS,
                FWStat.NECROMANCER_ASSISTS,
                FWStat.NECROMANCER_DEATHS,
                FWStat.NECROMANCER_SUICIDES,
                FWStat.NECROMANCER_DAMAGE_DEALT,
                FWStat.NECROMANCER_DAMAGE_TAKEN,
                FWStat.NECROMANCER_ESSENCE_COLLECTED,
                FWStat.NECROMANCER_SKELETONS_SPAWNED,
                FWStat.NECROMANCER_SKELETON_KILLS
            )
    ),

    NINJA("Ninja", KitRole.DAMAGE, KitTag.PREMIUM, Material.BLACK_DYE, FWAchievementSubCategory.ACHIEVEMENTS_NINJA,
            List.of(
                    FWStat.NINJA_TIME_PLAYED,
                    FWStat.NINJA_GAMES_PLAYED,
                    FWStat.NINJA_TOTAL_WINS_UNWEIGHTED,
                    FWStat.NINJA_TOTAL_DRAWS_UNWEIGHTED,
                    FWStat.NINJA_TOTAL_LOSSES_UNWEIGHTED,
                    FWStat.NINJA_TOTAL_WINS_WEIGHTED,
                    FWStat.NINJA_TOTAL_DRAWS_WEIGHTED,
                    FWStat.NINJA_TOTAL_LOSSES_WEIGHTED,
                    FWStat.NINJA_ELIMINATIONS,
                    FWStat.NINJA_FINAL_BLOWS,
                    FWStat.NINJA_ASSISTS,
                    FWStat.NINJA_DEATHS,
                    FWStat.NINJA_SUICIDES,
                    FWStat.NINJA_DAMAGE_DEALT,
                    FWStat.NINJA_DAMAGE_TAKEN,
                    FWStat.NINJA_KATANA_PARRY_KILLS,
                    FWStat.NINJA_KATANA_PARRIES_PERFORMED,
                    FWStat.NINJA_KI_ACCUMULATED,
                    FWStat.NINJA_KI_CONSUMED,
                    FWStat.NINJA_DODGES_PERFORMED
            )
    ),

    NONE("None", KitRole.DAMAGE, KitTag.EXCLUSIVE, Material.WOODEN_SWORD, null,
            List.of(
                FWStat.NONE_TIME_PLAYED,
                FWStat.NONE_GAMES_PLAYED,
                FWStat.NONE_TOTAL_WINS_UNWEIGHTED,
                FWStat.NONE_TOTAL_DRAWS_UNWEIGHTED,
                FWStat.NONE_TOTAL_LOSSES_UNWEIGHTED,
                FWStat.NONE_TOTAL_WINS_WEIGHTED,
                FWStat.NONE_TOTAL_DRAWS_WEIGHTED,
                FWStat.NONE_TOTAL_LOSSES_WEIGHTED,
                FWStat.NONE_ELIMINATIONS,
                FWStat.NONE_FINAL_BLOWS,
                FWStat.NONE_ASSISTS,
                FWStat.NONE_DEATHS,
                FWStat.NONE_SUICIDES,
                FWStat.NONE_DAMAGE_DEALT,
                FWStat.NONE_DAMAGE_TAKEN
            )
    ),

    PORCUPINE("Porcupine", KitRole.DAMAGE, KitTag.PREMIUM, Material.NETHER_STAR, FWAchievementSubCategory.ACHIEVEMENTS_PORCUPINE,
            List.of(
                FWStat.PORCUPINE_TIME_PLAYED,
                FWStat.PORCUPINE_GAMES_PLAYED,
                FWStat.PORCUPINE_TOTAL_WINS_UNWEIGHTED,
                FWStat.PORCUPINE_TOTAL_DRAWS_UNWEIGHTED,
                FWStat.PORCUPINE_TOTAL_LOSSES_UNWEIGHTED,
                FWStat.PORCUPINE_TOTAL_WINS_WEIGHTED,
                FWStat.PORCUPINE_TOTAL_DRAWS_WEIGHTED,
                FWStat.PORCUPINE_TOTAL_LOSSES_WEIGHTED,
                FWStat.PORCUPINE_ELIMINATIONS,
                FWStat.PORCUPINE_FINAL_BLOWS,
                FWStat.PORCUPINE_ASSISTS,
                FWStat.PORCUPINE_DEATHS,
                FWStat.PORCUPINE_SUICIDES,
                FWStat.PORCUPINE_DAMAGE_DEALT,
                FWStat.PORCUPINE_DAMAGE_TAKEN,
                FWStat.PORCUPINE_QUILL_KILLS,
                FWStat.PORCUPINE_DOUBLE_QUILL_KILLS,
                FWStat.PORCUPINE_TRIPLE_QUILL_KILLS
            )
    ),

    POTION_MASTER("Potion Master", KitRole.DAMAGE, KitTag.PREMIUM, Material.POTION, FWAchievementSubCategory.ACHIEVEMENTS_POTION_MASTER,
            List.of(
                FWStat.POTION_MASTER_TIME_PLAYED,
                FWStat.POTION_MASTER_GAMES_PLAYED,
                FWStat.POTION_MASTER_TOTAL_WINS_UNWEIGHTED,
                FWStat.POTION_MASTER_TOTAL_DRAWS_UNWEIGHTED,
                FWStat.POTION_MASTER_TOTAL_LOSSES_UNWEIGHTED,
                FWStat.POTION_MASTER_TOTAL_WINS_WEIGHTED,
                FWStat.POTION_MASTER_TOTAL_DRAWS_WEIGHTED,
                FWStat.POTION_MASTER_TOTAL_LOSSES_WEIGHTED,
                FWStat.POTION_MASTER_ELIMINATIONS,
                FWStat.POTION_MASTER_FINAL_BLOWS,
                FWStat.POTION_MASTER_ASSISTS,
                FWStat.POTION_MASTER_DEATHS,
                FWStat.POTION_MASTER_SUICIDES,
                FWStat.POTION_MASTER_DAMAGE_DEALT,
                FWStat.POTION_MASTER_DAMAGE_TAKEN,
                FWStat.POTION_MASTER_POTION_KILLS,
                FWStat.POTION_MASTER_DOUBLE_POTION_KILLS,
                FWStat.POTION_MASTER_PLAYERS_DEBUFFED,
                FWStat.POTION_MASTER_HARMING_DEBUFFED,
                FWStat.POTION_MASTER_SLOWNESS_DEBUFFED,
                FWStat.POTION_MASTER_POISON_DEBUFFED,
                FWStat.POTION_MASTER_WEAKNESS_DEBUFFED
            )
    ),

    PRIEST("Priest", KitRole.SUPPORT, KitTag.PREMIUM, Material.EXPERIENCE_BOTTLE, FWAchievementSubCategory.ACHIEVEMENTS_PRIEST,
            List.of(
                FWStat.PRIEST_TIME_PLAYED,
                FWStat.PRIEST_GAMES_PLAYED,
                FWStat.PRIEST_TOTAL_WINS_UNWEIGHTED,
                FWStat.PRIEST_TOTAL_DRAWS_UNWEIGHTED,
                FWStat.PRIEST_TOTAL_LOSSES_UNWEIGHTED,
                FWStat.PRIEST_TOTAL_WINS_WEIGHTED,
                FWStat.PRIEST_TOTAL_DRAWS_WEIGHTED,
                FWStat.PRIEST_TOTAL_LOSSES_WEIGHTED,
                FWStat.PRIEST_ELIMINATIONS,
                FWStat.PRIEST_FINAL_BLOWS,
                FWStat.PRIEST_ASSISTS,
                FWStat.PRIEST_DEATHS,
                FWStat.PRIEST_SUICIDES,
                FWStat.PRIEST_DAMAGE_DEALT,
                FWStat.PRIEST_DAMAGE_TAKEN,
                FWStat.PRIEST_GRACE_RECEIVED,
                FWStat.PRIEST_LIGHT_BEAM_CASTS,
                FWStat.PRIEST_LIGHT_BEAM_HITS,
                FWStat.PRIEST_LIGHT_BEAM_ALLY_HITS,
                FWStat.PRIEST_LIGHT_BEAM_ENEMY_HITS,
                FWStat.PRIEST_ABSOLUTIONS,
                FWStat.PRIEST_LEVEL_1_ABSOLUTION,
                FWStat.PRIEST_LEVEL_2_ABSOLUTION,
                FWStat.PRIEST_LEVEL_3_ABSOLUTION,
                FWStat.PRIEST_LEVEL_4_ABSOLUTION,
                FWStat.PRIEST_LEVEL_5_ABSOLUTION,
                FWStat.PRIEST_PLAYERS_BURNED,
                FWStat.PRIEST_BURN_KILLS,
                FWStat.PRIEST_HEALING_DONE,
                FWStat.PRIEST_MANA_USED
            )
    ),

    PROMETHEUS("Prometheus", KitRole.DAMAGE, KitTag.PREMIUM, Material.BLAZE_ROD, FWAchievementSubCategory.ACHIEVEMENTS_PROMETHEUS,
            List.of(
                FWStat.PROMETHEUS_TIME_PLAYED,
                FWStat.PROMETHEUS_GAMES_PLAYED,
                FWStat.PROMETHEUS_TOTAL_WINS_UNWEIGHTED,
                FWStat.PROMETHEUS_TOTAL_DRAWS_UNWEIGHTED,
                FWStat.PROMETHEUS_TOTAL_LOSSES_UNWEIGHTED,
                FWStat.PROMETHEUS_TOTAL_WINS_WEIGHTED,
                FWStat.PROMETHEUS_TOTAL_DRAWS_WEIGHTED,
                FWStat.PROMETHEUS_TOTAL_LOSSES_WEIGHTED,
                FWStat.PROMETHEUS_ELIMINATIONS,
                FWStat.PROMETHEUS_FINAL_BLOWS,
                FWStat.PROMETHEUS_ASSISTS,
                FWStat.PROMETHEUS_DEATHS,
                FWStat.PROMETHEUS_SUICIDES,
                FWStat.PROMETHEUS_DAMAGE_DEALT,
                FWStat.PROMETHEUS_DAMAGE_TAKEN,
                FWStat.PROMETHEUS_FIRE_KILLS,
                FWStat.PROMETHEUS_FLAME_SPELLS_CASTED,
                FWStat.PROMETHEUS_FIREBALLS_SPELLS_CASTED,
                FWStat.PROMETHEUS_IMBUE_SPELLS_CASTED,
                FWStat.PROMETHEUS_MANA_USED,
                FWStat.PROMETHEUS_ENEMIES_IGNITED,
                FWStat.PROMETHEUS_FIREBALL_KILLS,
                FWStat.PROMETHEUS_FIREBALL_DOUBLE_KILLS,
                FWStat.PROMETHEUS_FIREBALL_TRIPLE_KILLS
            )
    ),

    PYROTECHNIC("Pyrotechnic", KitRole.DAMAGE, KitTag.PREMIUM, Material.FIREWORK_ROCKET, FWAchievementSubCategory.ACHIEVEMENTS_PYROTECHNIC,
            List.of(
                FWStat.PYROTECHNIC_TIME_PLAYED,
                FWStat.PYROTECHNIC_GAMES_PLAYED,
                FWStat.PYROTECHNIC_TOTAL_WINS_UNWEIGHTED,
                FWStat.PYROTECHNIC_TOTAL_DRAWS_UNWEIGHTED,
                FWStat.PYROTECHNIC_TOTAL_LOSSES_UNWEIGHTED,
                FWStat.PYROTECHNIC_TOTAL_WINS_WEIGHTED,
                FWStat.PYROTECHNIC_TOTAL_DRAWS_WEIGHTED,
                FWStat.PYROTECHNIC_TOTAL_LOSSES_WEIGHTED,
                FWStat.PYROTECHNIC_ELIMINATIONS,
                FWStat.PYROTECHNIC_FINAL_BLOWS,
                FWStat.PYROTECHNIC_ASSISTS,
                FWStat.PYROTECHNIC_DEATHS,
                FWStat.PYROTECHNIC_SUICIDES,
                FWStat.PYROTECHNIC_DAMAGE_DEALT,
                FWStat.PYROTECHNIC_DAMAGE_TAKEN,
                FWStat.PYROTECHNIC_ROCKET_KILLS,
                FWStat.PYROTECHNIC_PLUS_2_ROCKET_KILLS,
                FWStat.PYROTECHNIC_PLUS_3_ROCKET_KILLS
            )
    ),

    RAVEN("Raven", KitRole.DAMAGE, KitTag.PREMIUM, Material.FEATHER, FWAchievementSubCategory.ACHIEVEMENTS_RAVEN,
            List.of(
                FWStat.RAVEN_TIME_PLAYED,
                FWStat.RAVEN_GAMES_PLAYED,
                FWStat.RAVEN_TOTAL_WINS_UNWEIGHTED,
                FWStat.RAVEN_TOTAL_DRAWS_UNWEIGHTED,
                FWStat.RAVEN_TOTAL_LOSSES_UNWEIGHTED,
                FWStat.RAVEN_TOTAL_WINS_WEIGHTED,
                FWStat.RAVEN_TOTAL_DRAWS_WEIGHTED,
                FWStat.RAVEN_TOTAL_LOSSES_WEIGHTED,
                FWStat.RAVEN_ELIMINATIONS,
                FWStat.RAVEN_FINAL_BLOWS,
                FWStat.RAVEN_ASSISTS,
                FWStat.RAVEN_DEATHS,
                FWStat.RAVEN_SUICIDES,
                FWStat.RAVEN_DAMAGE_DEALT,
                FWStat.RAVEN_DAMAGE_TAKEN,
                FWStat.RAVEN_MANA_CONSUMED,
                FWStat.RAVEN_WIND_GUSTS_USED,
                FWStat.RAVEN_TOTAL_FLIGHT_DISTANCE,
                FWStat.RAVEN_TOTAL_FLIGHT_DURATION,
                FWStat.RAVEN_FLIGHT_CANCELLED
            )
    ),

    SLIME("Slime", KitRole.TANK, KitTag.PREMIUM, Material.SLIME_BALL, FWAchievementSubCategory.ACHIEVEMENTS_SLIME,
            List.of(
                FWStat.SLIME_TIME_PLAYED,
                FWStat.SLIME_GAMES_PLAYED,
                FWStat.SLIME_TOTAL_WINS_UNWEIGHTED,
                FWStat.SLIME_TOTAL_DRAWS_UNWEIGHTED,
                FWStat.SLIME_TOTAL_LOSSES_UNWEIGHTED,
                FWStat.SLIME_TOTAL_WINS_WEIGHTED,
                FWStat.SLIME_TOTAL_DRAWS_WEIGHTED,
                FWStat.SLIME_TOTAL_LOSSES_WEIGHTED,
                FWStat.SLIME_ELIMINATIONS,
                FWStat.SLIME_FINAL_BLOWS,
                FWStat.SLIME_ASSISTS,
                FWStat.SLIME_DEATHS,
                FWStat.SLIME_SUICIDES,
                FWStat.SLIME_DAMAGE_DEALT,
                FWStat.SLIME_DAMAGE_TAKEN,
                FWStat.SLIME_SLIME_ARMOR_PROVIDED,
                FWStat.SLIME_ALLY_DAMAGE_MITIGATED,
                FWStat.SLIME_SLIMES_SUMMONED,
                FWStat.SLIME_KILLS,
                FWStat.SLIME_SLIME_ABSORPTION_RECEIVED
            )
    ),

    SNIPER("Sniper", KitRole.DAMAGE, KitTag.PREMIUM, Material.BOW, FWAchievementSubCategory.ACHIEVEMENTS_SNIPER,
            List.of(
                FWStat.SNIPER_TIME_PLAYED,
                FWStat.SNIPER_GAMES_PLAYED,
                FWStat.SNIPER_TOTAL_WINS_UNWEIGHTED,
                FWStat.SNIPER_TOTAL_DRAWS_UNWEIGHTED,
                FWStat.SNIPER_TOTAL_LOSSES_UNWEIGHTED,
                FWStat.SNIPER_TOTAL_WINS_WEIGHTED,
                FWStat.SNIPER_TOTAL_DRAWS_WEIGHTED,
                FWStat.SNIPER_TOTAL_LOSSES_WEIGHTED,
                FWStat.SNIPER_ELIMINATIONS,
                FWStat.SNIPER_FINAL_BLOWS,
                FWStat.SNIPER_ASSISTS,
                FWStat.SNIPER_DEATHS,
                FWStat.SNIPER_SUICIDES,
                FWStat.SNIPER_DAMAGE_DEALT,
                FWStat.SNIPER_DAMAGE_TAKEN,
                FWStat.SNIPER_HEADSHOTS,
                FWStat.SNIPER_HEADSHOT_KILLS,
                FWStat.SNIPER_KNEESHOTS,
                FWStat.SNIPER_KNEESHOT_KILLS
            )
    ),

    SNOW_GOLEM(
            "Snow Golem",
            KitRole.SUPPORT,
            KitTag.PREMIUM,
            Material.SNOW_GOLEM_SPAWN_EGG,
            FWAchievementSubCategory.ACHIEVEMENTS_SNOW_GOLEM,
            List.of(
                    FWStat.SNOW_GOLEM_TIME_PLAYED,
                    FWStat.SNOW_GOLEM_TOTAL_WINS_WEIGHTED,
                    FWStat.SNOW_GOLEM_TOTAL_DRAWS_WEIGHTED,
                    FWStat.SNOW_GOLEM_TOTAL_LOSSES_WEIGHTED,
                    FWStat.SNOW_GOLEM_GAMES_PLAYED,
                    FWStat.SNOW_GOLEM_TOTAL_WINS_UNWEIGHTED,
                    FWStat.SNOW_GOLEM_TOTAL_DRAWS_UNWEIGHTED,
                    FWStat.SNOW_GOLEM_TOTAL_LOSSES_UNWEIGHTED,
                    FWStat.SNOW_GOLEM_ELIMINATIONS,
                    FWStat.SNOW_GOLEM_FINAL_BLOWS,
                    FWStat.SNOW_GOLEM_ASSISTS,
                    FWStat.SNOW_GOLEM_DEATHS,
                    FWStat.SNOW_GOLEM_SUICIDES,
                    FWStat.SNOW_GOLEM_DAMAGE_DEALT,
                    FWStat.SNOW_GOLEM_DAMAGE_TAKEN,
                    FWStat.SNOW_GOLEM_ICICLES_CASTED,
                    FWStat.SNOW_GOLEM_ICICLE_KILLS,
                    FWStat.SNOW_GOLEM_MINIONS_SPAWNED,
                    FWStat.SNOW_GOLEM_MINION_KILLS,
                    FWStat.SNOW_GOLEM_HEALING_DONE,
                    FWStat.SNOW_GOLEM_SNOW_LAYER_HEALING_DONE,
                    FWStat.SNOW_GOLEM_PLAYER_ICICLE_HEALING_DONE,
                    FWStat.SNOW_GOLEM_MINION_ICICLE_HEALING_DONE
            )
        ),

    SNOWMAN("Snowman", KitRole.TANK, KitTag.PREMIUM, Material.SNOWBALL, FWAchievementSubCategory.ACHIEVEMENTS_SNOWMAN,
            List.of(
                FWStat.SNOWMAN_TIME_PLAYED,
                FWStat.SNOWMAN_GAMES_PLAYED,
                FWStat.SNOWMAN_TOTAL_WINS_UNWEIGHTED,
                FWStat.SNOWMAN_TOTAL_DRAWS_UNWEIGHTED,
                FWStat.SNOWMAN_TOTAL_LOSSES_UNWEIGHTED,
                FWStat.SNOWMAN_TOTAL_WINS_WEIGHTED,
                FWStat.SNOWMAN_TOTAL_DRAWS_WEIGHTED,
                FWStat.SNOWMAN_TOTAL_LOSSES_WEIGHTED,
                FWStat.SNOWMAN_ELIMINATIONS,
                FWStat.SNOWMAN_FINAL_BLOWS,
                FWStat.SNOWMAN_ASSISTS,
                FWStat.SNOWMAN_DEATHS,
                FWStat.SNOWMAN_SUICIDES,
                FWStat.SNOWMAN_DAMAGE_DEALT,
                FWStat.SNOWMAN_DAMAGE_TAKEN,
                FWStat.SNOWMAN_MANA_CONSUMED,
                FWStat.SNOWMAN_SNOWBALLS_CASTED,
                FWStat.SNOWMAN_SNOWSTORMS_CASTED,
                FWStat.SNOWMAN_IMBUE_SPELLS_CASTED,
                FWStat.SNOWMAN_ENEMIES_FROZEN
            )
    ),

    SOLDIER("Soldier", KitRole.DAMAGE, KitTag.FREE, Material.ENDER_PEARL, FWAchievementSubCategory.ACHIEVEMENTS_SOLDIER,
            List.of(
                FWStat.SOLDIER_TIME_PLAYED,
                FWStat.SOLDIER_GAMES_PLAYED,
                FWStat.SOLDIER_TOTAL_WINS_UNWEIGHTED,
                FWStat.SOLDIER_TOTAL_DRAWS_UNWEIGHTED,
                FWStat.SOLDIER_TOTAL_LOSSES_UNWEIGHTED,
                FWStat.SOLDIER_TOTAL_WINS_WEIGHTED,
                FWStat.SOLDIER_TOTAL_DRAWS_WEIGHTED,
                FWStat.SOLDIER_TOTAL_LOSSES_WEIGHTED,
                FWStat.SOLDIER_ELIMINATIONS,
                FWStat.SOLDIER_FINAL_BLOWS,
                FWStat.SOLDIER_ASSISTS,
                FWStat.SOLDIER_DEATHS,
                FWStat.SOLDIER_SUICIDES,
                FWStat.SOLDIER_DAMAGE_DEALT,
                FWStat.SOLDIER_DAMAGE_TAKEN,
                FWStat.SOLDIER_GRENADE_KILLS,
                FWStat.SOLDIER_PLUS_2_GRENADE_KILLS
            )
    ),

    SONIC("Sonic", KitRole.DAMAGE, KitTag.PREMIUM, Material.GOLDEN_BOOTS, FWAchievementSubCategory.ACHIEVEMENTS_SONIC,
            List.of(
                FWStat.SONIC_TIME_PLAYED,
                FWStat.SONIC_GAMES_PLAYED,
                FWStat.SONIC_TOTAL_WINS_UNWEIGHTED,
                FWStat.SONIC_TOTAL_DRAWS_UNWEIGHTED,
                FWStat.SONIC_TOTAL_LOSSES_UNWEIGHTED,
                FWStat.SONIC_TOTAL_WINS_WEIGHTED,
                FWStat.SONIC_TOTAL_DRAWS_WEIGHTED,
                FWStat.SONIC_TOTAL_LOSSES_WEIGHTED,
                FWStat.SONIC_ELIMINATIONS,
                FWStat.SONIC_FINAL_BLOWS,
                FWStat.SONIC_ASSISTS,
                FWStat.SONIC_DEATHS,
                FWStat.SONIC_SUICIDES,
                FWStat.SONIC_DAMAGE_DEALT,
                FWStat.SONIC_DAMAGE_TAKEN,
                FWStat.SONIC_SPEED_TOTAL_RUN_DISTANCE,
                FWStat.SONIC_BOOMS,
                FWStat.SONIC_BOOM_KILLS,
                FWStat.SONIC_BOOM_PLUS_2_KILLS,
                FWStat.SONIC_BOOM_PLUS_3_KILLS
            )
    ),

    SPIDER("Spider", KitRole.TANK, KitTag.PREMIUM, Material.COBWEB, FWAchievementSubCategory.ACHIEVEMENTS_SPIDER,
            List.of(
                FWStat.SPIDER_TIME_PLAYED,
                FWStat.SPIDER_GAMES_PLAYED,
                FWStat.SPIDER_TOTAL_WINS_UNWEIGHTED,
                FWStat.SPIDER_TOTAL_DRAWS_UNWEIGHTED,
                FWStat.SPIDER_TOTAL_LOSSES_UNWEIGHTED,
                FWStat.SPIDER_TOTAL_WINS_WEIGHTED,
                FWStat.SPIDER_TOTAL_DRAWS_WEIGHTED,
                FWStat.SPIDER_TOTAL_LOSSES_WEIGHTED,
                FWStat.SPIDER_ELIMINATIONS,
                FWStat.SPIDER_FINAL_BLOWS,
                FWStat.SPIDER_ASSISTS,
                FWStat.SPIDER_DEATHS,
                FWStat.SPIDER_SUICIDES,
                FWStat.SPIDER_DAMAGE_DEALT,
                FWStat.SPIDER_DAMAGE_TAKEN,
                FWStat.SPIDER_TRAPS_SET,
                FWStat.SPIDER_TRAPS_COLLECTED,
                FWStat.SPIDER_TRAPS_ACTIVATED
            )
    ),

    SPY("Spy", KitRole.DAMAGE, KitTag.PREMIUM, Material.GOLDEN_CARROT, FWAchievementSubCategory.ACHIEVEMENTS_SPY,
            List.of(
                FWStat.SPY_TIME_PLAYED,
                FWStat.SPY_GAMES_PLAYED,
                FWStat.SPY_TOTAL_WINS_UNWEIGHTED,
                FWStat.SPY_TOTAL_DRAWS_UNWEIGHTED,
                FWStat.SPY_TOTAL_LOSSES_UNWEIGHTED,
                FWStat.SPY_TOTAL_WINS_WEIGHTED,
                FWStat.SPY_TOTAL_DRAWS_WEIGHTED,
                FWStat.SPY_TOTAL_LOSSES_WEIGHTED,
                FWStat.SPY_ELIMINATIONS,
                FWStat.SPY_FINAL_BLOWS,
                FWStat.SPY_ASSISTS,
                FWStat.SPY_DEATHS,
                FWStat.SPY_SUICIDES,
                FWStat.SPY_DAMAGE_DEALT,
                FWStat.SPY_DAMAGE_TAKEN,
                FWStat.SPY_CLOAKS,
                FWStat.SPY_CLOAKED_KILLS,
                FWStat.SPY_CLOAKED_DEATHS
            )
    ),

    VITALIST("Vitalist", KitRole.SUPPORT, KitTag.PREMIUM, Material.CROSSBOW, FWAchievementSubCategory.ACHIEVEMENTS_VITALIST,
            List.of(
                FWStat.VITALIST_TIME_PLAYED,
                FWStat.VITALIST_GAMES_PLAYED,
                FWStat.VITALIST_TOTAL_WINS_UNWEIGHTED,
                FWStat.VITALIST_TOTAL_DRAWS_UNWEIGHTED,
                FWStat.VITALIST_TOTAL_LOSSES_UNWEIGHTED,
                FWStat.VITALIST_TOTAL_WINS_WEIGHTED,
                FWStat.VITALIST_TOTAL_DRAWS_WEIGHTED,
                FWStat.VITALIST_TOTAL_LOSSES_WEIGHTED,
                FWStat.VITALIST_ELIMINATIONS,
                FWStat.VITALIST_FINAL_BLOWS,
                FWStat.VITALIST_ASSISTS,
                FWStat.VITALIST_DEATHS,
                FWStat.VITALIST_SUICIDES,
                FWStat.VITALIST_DAMAGE_DEALT,
                FWStat.VITALIST_DAMAGE_TAKEN,
                FWStat.VITALIST_HEALING_DONE,
                FWStat.VITALIST_CROSSBOW_KILLS
            )
    ),

    WIZARD("Wizard", KitRole.DAMAGE, KitTag.PREMIUM, Material.AMETHYST_SHARD, FWAchievementSubCategory.ACHIEVEMENTS_WIZARD,
            List.of(
                    FWStat.WIZARD_TIME_PLAYED,
                    FWStat.WIZARD_GAMES_PLAYED,
                    FWStat.WIZARD_TOTAL_WINS_UNWEIGHTED,
                    FWStat.WIZARD_TOTAL_DRAWS_UNWEIGHTED,
                    FWStat.WIZARD_TOTAL_LOSSES_UNWEIGHTED,
                    FWStat.WIZARD_TOTAL_WINS_WEIGHTED,
                    FWStat.WIZARD_TOTAL_DRAWS_WEIGHTED,
                    FWStat.WIZARD_TOTAL_LOSSES_WEIGHTED,
                    FWStat.WIZARD_ELIMINATIONS,
                    FWStat.WIZARD_FINAL_BLOWS,
                    FWStat.WIZARD_ASSISTS,
                    FWStat.WIZARD_DEATHS,
                    FWStat.WIZARD_SUICIDES,
                    FWStat.WIZARD_DAMAGE_DEALT,
                    FWStat.WIZARD_DAMAGE_TAKEN,
                    FWStat.WIZARD_MANA_CONSUMED,
                    FWStat.WIZARD_CHAIN_LIGHTNINGS_CASTED,
                    FWStat.WIZARD_CHAIN_LIGHTNING_KILLS,
                    FWStat.WIZARD_CHAIN_LIGHTNING_PLUS_2_KILLS,
                    FWStat.WIZARD_CHAIN_LIGHTNING_PLUS_3_KILLS,
                    FWStat.WIZARD_CHAIN_LIGHTNING_PLUS_4_KILLS,
                    FWStat.WIZARD_LIGHTNING_STRIKES_CASTED,
                    FWStat.WIZARD_LIGHTNING_STRIKE_KILLS,
                    FWStat.WIZARD_LIGHTNING_STRIKE_PLUS_2_KILLS,
                    FWStat.WIZARD_LIGHTNING_STRIKE_PLUS_3_KILLS
            )
    );

    private static final int INITIAL_CAPACITY = 100;
    private static List<KitID> kitIDList = new ArrayList<>(INITIAL_CAPACITY);
    private static List<String> kitIDStringList = new ArrayList<>(INITIAL_CAPACITY);

    private final List<FWStat> kitStats;
    private final String kitID;
    private final KitRole kitRole;
    private final Material itemRepresentation;
    private final FWStat timePlayedStat;
    private final FWStat gamesPlayed;
    private final FWStat winsUnweightedStat;
    private final FWStat lossesUnweightedStat;
    private final FWStat drawsUnweightedStat;
    private final FWStat winsWeightedStat;
    private final FWStat lossesWeightedStat;
    private final FWStat drawsWeightedStat;
    private final FWStat elimStat;
    private final FWStat assistStat;
    private final FWStat finalblowsStat;
    private final FWStat deathStat;
    private final FWStat suicideStat;
    private final FWStat damageDealtStat;
    private final FWStat damageTakenStat;
    private final KitTag kitTag;
    private final FWAchievementSubCategory achievementSubCategory;
    private final String documentationLink;

    KitID(
            String kitID,
            KitRole kitRole,
            KitTag kitTag,
            Material itemRepresentation,
            FWAchievementSubCategory achievementSubCategory,
            List<FWStat> kitStats
    ) {
        this.kitID = kitID;
        this.kitRole = kitRole;
        this.kitTag = kitTag;
        this.itemRepresentation = itemRepresentation;
        this.achievementSubCategory = achievementSubCategory;
        this.kitStats = kitStats;

        // Map Stats
        this.timePlayedStat = kitStats.get(0);
        this.gamesPlayed = kitStats.get(1);
        this.winsUnweightedStat = kitStats.get(2);
        this.drawsUnweightedStat = kitStats.get(3);
        this.lossesUnweightedStat = kitStats.get(4);
        this.winsWeightedStat = kitStats.get(5);
        this.drawsWeightedStat = kitStats.get(6);
        this.lossesWeightedStat = kitStats.get(7);
        this.elimStat = kitStats.get(8);
        this.finalblowsStat = kitStats.get(9);
        this.assistStat = kitStats.get(10);
        this.deathStat = kitStats.get(11);
        this.suicideStat = kitStats.get(12);
        this.damageDealtStat = kitStats.get(13);
        this.damageTakenStat = kitStats.get(14);

        // Generate the documentation link
        final String domain = "https://wiki.fortresswars.net/#/kits/";
        final String page = kitID.replace(" ", "_");
        this.documentationLink = domain + page;
    }

    public static List<KitID> getKitIDListTags(Set<KitTag> kitTags) {
        if (kitTags == null) return List.of();
        final List<KitID> kitTagList = new ArrayList<>(INITIAL_CAPACITY);
        for (KitID kitID : KitID.values()) {
            if (kitTags.contains(kitID.kitTag)) kitTagList.add(kitID);
        }
        return kitTagList;
    }

    public static List<KitID> getKitIDList() {
        if (!kitIDList.isEmpty()) return kitIDList;
        kitIDList = new ArrayList<>(List.of(KitID.values()));
        Collections.sort(kitIDList);
        return kitIDList;
    }

    public static List<String> getKitIDStringList() {
        if (!kitIDStringList.isEmpty()) return kitIDStringList;
        List<String> kitStringList = new ArrayList<>(40);
        List<KitID> kitIDList = getKitIDList();
        for (KitID kitID : kitIDList) {
            kitStringList.add(kitID.name());
        }
        kitIDStringList = kitStringList;
        return kitStringList;
    }

    public static void mergeKitLists(List<KitID> list1, List<KitID> list2) {
        if (list1 == null || list2 == null) return;
        final Set<KitID> mergedSet = new HashSet<>(list1);
        mergedSet.addAll(list2);

        final List<KitID> mergedList = new ArrayList<>(mergedSet);
        Collections.sort(mergedList);

        list1.clear();
        list1.addAll(mergedList);
    }

    public static KitID fromString(String string) {
        try {
            return KitID.valueOf(string.toUpperCase());
        } catch (Exception e) {
            return null;
        }
    }

    public String getName() {
        return kitID;
    }

    public KitRole getRole() {
        return kitRole;
    }

    public List<FWStat> getAllKitStats() {
        return kitStats;
    }

    public FWStat getTimeStat() {
        return timePlayedStat;
    }

    public FWStat getGamesPlayedStat() {
        return gamesPlayed;
    }

    public FWStat getWinsUnweightedStat() {
        return winsUnweightedStat;
    }

    public FWStat getLossesUnweightedStat() {
        return lossesUnweightedStat;
    }

    public FWStat getDrawsUnweightedStat() {
        return drawsUnweightedStat;
    }

    public FWStat getWinsWeightedStat() {
        return winsWeightedStat;
    }

    public FWStat getLossesWeightedStat() {
        return lossesWeightedStat;
    }

    public FWStat getDrawsWeightedStat() {
        return drawsWeightedStat;
    }

    public FWStat getElimsStat() {
        return elimStat;
    }

    public FWStat getAssistsStat() {
        return assistStat;
    }

    public FWStat getFinalblowsStat() {
        return finalblowsStat;
    }

    public FWStat getDeathStat() {
        return deathStat;
    }

    public FWStat getSuicideStat() {
        return suicideStat;
    }

    public FWStat getDamageDealtStat() {
        return damageDealtStat;
    }

    public FWStat getDamageTakenStat() {
        return damageTakenStat;
    }

    public Material getMaterialRepresentation() {
        return itemRepresentation;
    }

    public KitTag getKitTag() {
        return kitTag;
    }

    public FWAchievementSubCategory getAchievementSubCategory() {
        return achievementSubCategory;
    }

    public String getDocumentationLink() {
        return documentationLink;
    }
}
