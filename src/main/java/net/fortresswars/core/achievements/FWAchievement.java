package net.fortresswars.core.achievements;

import net.fortresswars.core.kits.KitID;
import org.bukkit.Material;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public enum FWAchievement {

    // GENERAL
    GENERAL_JOIN_SERVER("Welcome to Fortress Wars!", "Join the server for the first time!", Material.BEACON, FWAchievementSubCategory.ACHIEVEMENTS_GENERAL_JOIN_SERVER, FWAchievementReward.FIVE_HUNDRED_CREDITS),
    GENERAL_SELECT_KIT("Select Kit!", "Select a kit for the first time!", Material.IRON_SWORD, FWAchievementSubCategory.ACHIEVEMENTS_GENERAL, FWAchievementReward.TEN_CREDITS),
    GENERAL_VOTE_FOR_MAP("Vote For Map!", "Vote for a map for the first time!", Material.MAP, FWAchievementSubCategory.ACHIEVEMENTS_GENERAL, FWAchievementReward.TEN_CREDITS),
    GENERAL_VOTE_FOR_GAMERULE("Vote For Gamerule!", "Vote for a gamerule for the first time!", Material.CREEPER_BANNER_PATTERN, FWAchievementSubCategory.ACHIEVEMENTS_GENERAL, FWAchievementReward.TEN_CREDITS),
    GENERAL_KING_OF_THE_LADDER("King Of The Ladder!", "Become King of the ladder for the first time!", Material.LADDER, FWAchievementSubCategory.ACHIEVEMENTS_GENERAL, FWAchievementReward.TWENTY_CREDITS),
    GENERAL_VOTE_FOR_SERVER("Vote For The Server!", "Vote for the server for the first time!", Material.EMERALD, FWAchievementSubCategory.ACHIEVEMENTS_GENERAL, FWAchievementReward.ONE_HUNDRED_CREDITS),
    GENERAL_PURCHASE_FW_PLUS_RANK("Purchase FW+!", "Purchase the Fortress Wars Plus rank!", Material.DIAMOND, FWAchievementSubCategory.ACHIEVEMENTS_GENERAL, FWAchievementReward.FIVE_HUNDRED_CREDITS),
    GENERAL_KITS_UNLOCK_10("Trying new things!", "Unlock 10 kits.", Material.BOOK, FWAchievementSubCategory.ACHIEVEMENTS_GENERAL_UNLOCK_KIT, FWAchievementReward.TWENTY_CREDITS),
    GENERAL_KITS_UNLOCK_20("I NEED MORE!", "Unlock 20 kits.", Material.BOOK, FWAchievementSubCategory.ACHIEVEMENTS_GENERAL_UNLOCK_KIT, FWAchievementReward.TWENTY_CREDITS),
    GENERAL_KITS_UNLOCK_30("Big Spender", "Unlock 30 kits.", Material.BOOK, FWAchievementSubCategory.ACHIEVEMENTS_GENERAL_UNLOCK_KIT, FWAchievementReward.TWENTY_CREDITS),
    GENERAL_KITS_UNLOCK_ALL("Gotta unlock 'em all!", "Unlock all the kits.", Material.BOOK, FWAchievementSubCategory.ACHIEVEMENTS_GENERAL_UNLOCK_KIT, FWAchievementReward.TWENTY_CREDITS),
    GENERAL_GAME_MOST_ELIMINATIONS("Top Eliminations!", "Get top eliminations in a game.", Material.GOLD_INGOT, FWAchievementSubCategory.ACHIEVEMENTS_GENERAL_TOP_STATS_IN_GAME, FWAchievementReward.TWENTY_CREDITS),
    GENERAL_GAME_BEST_EDR("Best EDR!", "Get best Elimination/Death Ratio in a game.", Material.IRON_INGOT, FWAchievementSubCategory.ACHIEVEMENTS_GENERAL_TOP_STATS_IN_GAME, FWAchievementReward.TWENTY_CREDITS),
    GENERAL_GAME_MOST_DEATHS("Top Deaths!", "Get top deaths in a game.", Material.COPPER_INGOT, FWAchievementSubCategory.ACHIEVEMENTS_GENERAL_TOP_STATS_IN_GAME, FWAchievementReward.TWENTY_CREDITS),
    GENERAL_GAME_MOST_DAMAGE_DEALT("Top Damage Dealt!", "Get top damage in a game.", Material.NETHERITE_INGOT, FWAchievementSubCategory.ACHIEVEMENTS_GENERAL_TOP_STATS_IN_GAME, FWAchievementReward.TWENTY_CREDITS),
    GENERAL_GAME_MOST_DAMAGE_TAKEN("Top Damage Taken!", "Get the most damage during a game.", Material.BRICK, FWAchievementSubCategory.ACHIEVEMENTS_GENERAL_TOP_STATS_IN_GAME, FWAchievementReward.TWENTY_CREDITS),
    GENERAL_GAME_MOST_BEACON_HITS("Top Beacon Hits!", "Get most beacon hits in a game.", Material.BEACON, FWAchievementSubCategory.ACHIEVEMENTS_GENERAL_TOP_STATS_IN_GAME, FWAchievementReward.TWENTY_CREDITS),
    GENERAL_GAME_FINAL_BREAK("It's the final countdown", "Get a beacon break in a game.", Material.BEACON, FWAchievementSubCategory.ACHIEVEMENTS_GENERAL_TOP_STATS_IN_GAME, FWAchievementReward.TWENTY_CREDITS),

    // STATS
    STATS_WIN_1("The taste of victory", "Get your first win!", Material.PAPER, FWAchievementSubCategory.ACHIEVEMENTS_STATS_WINS, FWAchievementReward.TWENTY_CREDITS),
    STATS_WIN_25("Dynasty", "Get 25 wins!", Material.PAPER, FWAchievementSubCategory.ACHIEVEMENTS_STATS_WINS, FWAchievementReward.TWENTY_CREDITS),
    STATS_WIN_100("Corporate office hours", "Get 100 wins!", Material.PAPER, FWAchievementSubCategory.ACHIEVEMENTS_STATS_WINS, FWAchievementReward.ONE_HUNDRED_CREDITS),
    STATS_WIN_250("The crucible", "Get 250 wins!", Material.PAPER, FWAchievementSubCategory.ACHIEVEMENTS_STATS_WINS, FWAchievementReward.FIVE_HUNDRED_CREDITS),
    STATS_WIN_1000("Kit win?", "Get 1,000 wins!", Material.PAPER, FWAchievementSubCategory.ACHIEVEMENTS_STATS_WINS, FWAchievementReward.ONE_THOUSAND_CREDITS),
    STATS_ELIMINATIONS_25("Baby Steps!", "Get 25 eliminations!", Material.WOODEN_SWORD, FWAchievementSubCategory.ACHIEVEMENTS_STATS_ELIMINATION, FWAchievementReward.TWENTY_CREDITS),
    STATS_ELIMINATIONS_50("Impressive!", "Get 50 eliminations!", Material.STONE_SWORD, FWAchievementSubCategory.ACHIEVEMENTS_STATS_ELIMINATION, FWAchievementReward.THIRTY_CREDITS),
    STATS_ELIMINATIONS_69("Nice!", "Get 69 eliminations - nice!", Material.GOLDEN_HOE, FWAchievementSubCategory.ACHIEVEMENTS_STATS_ELIMINATION, FWAchievementReward.THIRTY_CREDITS),
    STATS_ELIMINATIONS_100("Money Moves!", "Get 100 eliminations!", Material.GOLDEN_SWORD, FWAchievementSubCategory.ACHIEVEMENTS_STATS_ELIMINATION, FWAchievementReward.FIFTY_CREDITS),
    STATS_ELIMINATIONS_420("Let 'em cook!", "Get 420 eliminations!", Material.TALL_GRASS, FWAchievementSubCategory.ACHIEVEMENTS_STATS_ELIMINATION, FWAchievementReward.ONE_HUNDRED_CREDITS),
    STATS_ELIMINATIONS_500("Outlawed", "Get 500 eliminations!", Material.IRON_SWORD, FWAchievementSubCategory.ACHIEVEMENTS_STATS_ELIMINATION, FWAchievementReward.ONE_HUNDRED_CREDITS),
    STATS_ELIMINATIONS_1000("Kill Everyone You Meet!", "Get 1,000 eliminations!", Material.DIAMOND_SWORD, FWAchievementSubCategory.ACHIEVEMENTS_STATS_ELIMINATION, FWAchievementReward.ONE_HUNDRED_CREDITS),
    STATS_ELIMINATIONS_2013("A year to remember!", "Get 2,013 eliminations!", Material.NETHERITE_SWORD, FWAchievementSubCategory.ACHIEVEMENTS_STATS_ELIMINATION, FWAchievementReward.ONE_HUNDRED_CREDITS),
    STATS_ELIMINATIONS_10000("Hardcore!", "Get 10,000 eliminations!", Material.NETHERITE_SWORD, FWAchievementSubCategory.ACHIEVEMENTS_STATS_ELIMINATION, FWAchievementReward.FIVE_HUNDRED_CREDITS),
    STATS_ELIMINATIONS_50000("Public Enemy #1", "Get 50,000 eliminations!", Material.NETHERITE_SWORD, FWAchievementSubCategory.ACHIEVEMENTS_STATS_ELIMINATION, FWAchievementReward.FIVE_HUNDRED_CREDITS),
    STATS_ELIMINATIONS_100000("A LEGEND IN MY TIME!", "Get 100,000 eliminations!", Material.NETHERITE_SWORD, FWAchievementSubCategory.ACHIEVEMENTS_STATS_ELIMINATION, FWAchievementReward.FIVE_HUNDRED_CREDITS),
    STATS_KILLSTREAK_5("Hard to Kill!", "Go on a killstreak of 5.", Material.IRON_AXE, FWAchievementSubCategory.ACHIEVEMENTS_STATS_KILLSTREAK, FWAchievementReward.TWENTY_CREDITS),
    STATS_KILLSTREAK_10("Relentless!", "Go on a killstreak of 10.", Material.IRON_AXE, FWAchievementSubCategory.ACHIEVEMENTS_STATS_KILLSTREAK, FWAchievementReward.TWENTY_CREDITS),
    STATS_KILLSTREAK_15("Unstoppable!", "Go on a killstreak of 15.", Material.IRON_AXE, FWAchievementSubCategory.ACHIEVEMENTS_STATS_KILLSTREAK, FWAchievementReward.TWENTY_CREDITS),
    STATS_KILLSTREAK_20("Rampage!", "Go on a killstreak of 20.", Material.IRON_AXE, FWAchievementSubCategory.ACHIEVEMENTS_STATS_KILLSTREAK, FWAchievementReward.TWENTY_CREDITS),
    STATS_KILLSTREAK_25("Dominating!", "Go on a killstreak of 25.", Material.IRON_AXE, FWAchievementSubCategory.ACHIEVEMENTS_STATS_KILLSTREAK, FWAchievementReward.TWENTY_CREDITS),
    STATS_KILLSTREAK_30("Overwhelming!", "Go on a killstreak of 30.", Material.NETHERITE_AXE, FWAchievementSubCategory.ACHIEVEMENTS_STATS_KILLSTREAK, FWAchievementReward.TWENTY_CREDITS),
    STATS_DEAL_10000_DAMAGE("I have knife hands?", "Deal 10,000 Damage.", Material.REDSTONE, FWAchievementSubCategory.ACHIEVEMENTS_STATS_DAMAGE_DEALT, FWAchievementReward.FIFTY_CREDITS),
    STATS_DEAL_50000_DAMAGE("I looked down, and my hands were knives.", "Deal 50,000 Damage.", Material.REDSTONE, FWAchievementSubCategory.ACHIEVEMENTS_STATS_DAMAGE_DEALT, FWAchievementReward.FIFTY_CREDITS),
    STATS_DEAL_100000_DAMAGE("Yeah.", "Deal 100,000 Damage.", Material.REDSTONE, FWAchievementSubCategory.ACHIEVEMENTS_STATS_DAMAGE_DEALT, FWAchievementReward.ONE_HUNDRED_CREDITS),
    STATS_DEAL_500000_DAMAGE("No, they're my hands.", "Deal 500,000 Damage.", Material.REDSTONE, FWAchievementSubCategory.ACHIEVEMENTS_STATS_DAMAGE_DEALT, FWAchievementReward.TWO_HUNDRED_FIFTY_CREDITS),
    STATS_DEAL_1000000_DAMAGE("I don't want knife hands.", "Deal 1,000,000 Damage.", Material.REDSTONE, FWAchievementSubCategory.ACHIEVEMENTS_STATS_DAMAGE_DEALT, FWAchievementReward.FIVE_HUNDRED_CREDITS),
    STATS_DEAL_5000000_DAMAGE("I can't pet my cat.", "Deal 5,000,000 Damage.", Material.REDSTONE, FWAchievementSubCategory.ACHIEVEMENTS_STATS_DAMAGE_DEALT, FWAchievementReward.FIVE_HUNDRED_CREDITS),
    STATS_DEAL_10000000_DAMAGE("What am I gonna do be a chef?", "Deal 10,000,000 Damage.", Material.REDSTONE, FWAchievementSubCategory.ACHIEVEMENTS_STATS_DAMAGE_DEALT, FWAchievementReward.ONE_THOUSAND_CREDITS),
    STATS_DEAL_50000000_DAMAGE("Just chop chop chop my whole life, nothing but chopping.", "Deal 50,000,000 Damage.", Material.REDSTONE, FWAchievementSubCategory.ACHIEVEMENTS_STATS_DAMAGE_DEALT, FWAchievementReward.ONE_THOUSAND_CREDITS),

    // KIT
    KITS_AQUAMAN_SHOOT_FLYING_RAVEN("Something something trident.", "Hit a flying raven with your trident.", KitID.AQUAMAN.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_AQUAMAN, FWAchievementReward.TWENTY_CREDITS),
    KITS_AQUAMAN_KILL_FROM_FAR("It was up to me and I let them die.", "Kill an enemy with your trident from a far distance.", KitID.AQUAMAN.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_AQUAMAN, FWAchievementReward.FORTY_CREDITS),
    KITS_AQUAMAN_TRIDENT_KILLS_MILESTONE("Where I come from...The sea carries our tears away.", "Get 50 trident kills.", KitID.AQUAMAN.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_AQUAMAN, FWAchievementReward.ONE_THOUSAND_CREDITS),
    KITS_AQUAMAN_KILL_AN_ENEMY_IN_WATER("Ask the sea for mercy!", "Kill an enemy in water.", KitID.AQUAMAN.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_AQUAMAN, FWAchievementReward.TWENTY_CREDITS),

    KITS_AQUARIUS_WATER_HEALING_MILESTONE("Soothing Water", "Heal a total of 5,000 as kit Aquarius", KitID.AQUARIUS.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_AQUARIUS, FWAchievementReward.FIVE_HUNDRED_CREDITS),
    KITS_AQUARIUS_WATER_BOMB_10_ENTITIES("Fun at the water park!", "Affect 10 Entities at once with your water bomb spell.", KitID.AQUARIUS.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_AQUARIUS, FWAchievementReward.FIFTY_CREDITS),
    KITS_AQUARIUS_WATER_BOMB_SNIPER("Water Sniper", "Cast your water bomb spell and successfully hit an enemy or ally from 50 blocks away.", KitID.AQUARIUS.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_AQUARIUS, FWAchievementReward.TWENTY_CREDITS),

    KITS_BOMBER_BLOWUP_BRICKS("The Destruction of Fort Knox!", "Blow up enemy builder bricks as bomber!", KitID.BOMBER.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_BOMBER, FWAchievementReward.TWENTY_CREDITS),
    KITS_BOMBER_FAR_BOMB_KILL("Aye, what just happened?", "Blow up an enemy from far away as bomber.", KitID.BOMBER.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_BOMBER, FWAchievementReward.TWENTY_CREDITS),
    KITS_BOMBER_BLOW_UP_INVISIBLE_ENEMY("Couldn't ya see the bloody bombs!", "Blow up a invisible enemy as bomber.", KitID.BOMBER.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_BOMBER, FWAchievementReward.TWENTY_CREDITS),
    KITS_BOMBER_PLUS_2_BOMB_KILL("Ka-boooom!", "Get a double bomb kill as bomber.", KitID.BOMBER.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_BOMBER, FWAchievementReward.THIRTY_CREDITS),
    KITS_BOMBER_PLUS_3_BOMB_KILL("Kablooie!", "Get a triple bomb kill as bomber.", KitID.BOMBER.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_BOMBER, FWAchievementReward.FIFTY_CREDITS),
    KITS_BOMBER_BOMB_KILLS_MILESTONE("And that's what ya get for touching that!", "Get 50 bomb kills as bomber.", KitID.BOMBER.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_BOMBER, FWAchievementReward.ONE_THOUSAND_CREDITS),

    KITS_BRUTE_BERSERK_PASSIVES_MILESTONE("Passive Aggressive Negotiator", "Activate the berserk passive 100 times.", KitID.BRUTE.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_BRUTE, FWAchievementReward.ONE_HUNDRED_CREDITS),
    KITS_BRUTE_2_FINAL_BLOWS_1_BERSERK("Skull splitter", "Get 2 final blows within one berserk.", KitID.BRUTE.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_BRUTE, FWAchievementReward.FIFTY_CREDITS),
    KITS_BRUTE_AXE_SWIRL_KILLS_MILESTONE("Head Collector", "Get 50 axe swirl kills.", KitID.BRUTE.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_BRUTE, FWAchievementReward.ONE_THOUSAND_CREDITS),
    KITS_BRUTE_DOUBLE_AXE_SWIRL_KILL("A clean cut", "Get a double axe swirl kill.", KitID.BRUTE.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_BRUTE, FWAchievementReward.FIFTY_CREDITS),
    KITS_BRUTE_DECAPITATE_SNOW_GOLEM_MINION("Pumpkin Carving", "Decapitate a snow golem minion.", KitID.BRUTE.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_BRUTE, FWAchievementReward.TWENTY_CREDITS),

    KITS_BUFF_MASTER_BUFF_4_TEAMMATES("Family Practice", "Buff 4 teammates with one activation.", KitID.BUFF_MASTER.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_BUFF_MASTER, FWAchievementReward.TWENTY_CREDITS),
    KITS_BUFF_MASTER_BUFF_TEAMMATES_MILESTONE("The True Buff Master", "Buff 250 teammates.", KitID.BUFF_MASTER.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_BUFF_MASTER, FWAchievementReward.ONE_HUNDRED_CREDITS),
    KITS_BUFF_MASTER_BUFF_CREEPER("Stronk Creeper", "Buff a creeper with buff master.", KitID.BUFF_MASTER.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_BUFF_MASTER, FWAchievementReward.TWENTY_CREDITS),

    KITS_BUILDER_BRICKS_KILL("BUILDAH KILL!", "Eliminate an enemy with your bricks.", KitID.BUILDER.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_BUILDER, FWAchievementReward.TWENTY_CREDITS),
    KITS_BUILDER_PLACE_BRICKS_MILESTONE("Sturdy fortress!", "Place 1,000 bricks.", KitID.BUILDER.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_BUILDER, FWAchievementReward.TWO_HUNDRED_FIFTY_CREDITS),
    KITS_BUILDER_PLACE_LADDERS_MILESTONE("Ladder to heaven!", "Place 500 ladders.", KitID.BUILDER.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_BUILDER, FWAchievementReward.TWO_HUNDRED_FIFTY_CREDITS),
    KITS_BUILDER_GET_ENVIRONMENTAL_KILL("Don't underestimate the BRICKS!", "Get a death plane kill as builder.", KitID.BUILDER.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_BUILDER, FWAchievementReward.TWENTY_CREDITS),
    KITS_BUILDER_BRICK_KILLS_MILESTONE("Monumental Mason", "Get 50 brick kills.", KitID.BUILDER.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_BUILDER, FWAchievementReward.ONE_THOUSAND_CREDITS),

    KITS_CRUSADER_DOUBLE_SHIELD_BASH_KILL("Stronk Shield!", "Get a double shield bash kill.", KitID.CRUSADER.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_CRUSADER, FWAchievementReward.ONE_HUNDRED_CREDITS),
    KITS_CRUSADER_TRIPLE_SHIELD_BASH_KILL("The Flattener!", "Get a triple shield bash kill.", KitID.CRUSADER.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_CRUSADER, FWAchievementReward.TWO_HUNDRED_FIFTY_CREDITS),
    KITS_CRUSADER_HIT_4_ENEMIES_WITH_SHIELD_BASH("Get out of my way!", "Hit 4 enemies with one shield bash!", KitID.CRUSADER.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_CRUSADER, FWAchievementReward.TWENTY_CREDITS),
    KITS_CRUSADER_SHIELD_BASH_KILLS_MILESTONE("Iron Shield", "Get 50 shield bash kills.", KitID.CRUSADER.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_CRUSADER, FWAchievementReward.ONE_THOUSAND_CREDITS),

    KITS_CRUSHER_KILL_SLIME("Bowling Ball vs Trampoline!", "Kill a slime minion with an anvil.", KitID.CRUSHER.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_CRUSHER, FWAchievementReward.TWENTY_CREDITS),
    KITS_CRUSHER_CRUSH_SENTRY("Pixar Lamp", "Crush an engineer sentry and destroy it.", KitID.CRUSHER.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_CRUSHER, FWAchievementReward.TWENTY_CREDITS),
    KITS_CRUSHER_ANVIL_HITS_MILESTONE("Anvil Inc.", "Hit 100 enemies with summoned anvils.", KitID.CRUSHER.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_CRUSHER, FWAchievementReward.FIFTY_CREDITS),
    KITS_CRUSHER_DIRECT_ANVIL_KILL("Heavy Metal", "Get a direct anvil kill.", KitID.CRUSHER.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_CRUSHER, FWAchievementReward.TWENTY_CREDITS),
    KITS_CRUSHER_STUN_RAVEN_AND_KILL("Bird Squ-”watcher”", "Eliminate a raven with an anvil.", KitID.CRUSHER.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_CRUSHER, FWAchievementReward.TWENTY_CREDITS),
    KITS_CRUSHER_DOUBLE_ANVIL_KILL("Splat!", "Get a double anvil kill!", KitID.CRUSHER.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_CRUSHER, FWAchievementReward.FIFTY_CREDITS),
    KITS_CRUSHER_TRIPLE_ANVIL_KILL("Blacksmith's Graveyard", "Get a triple anvil kill!", KitID.CRUSHER.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_CRUSHER, FWAchievementReward.FIFTY_CREDITS),
    KITS_CRUSHER_ANVIL_KILLS_MILESTONE("“Kilogramme o' steel”", "Get 50 anvil kills!", KitID.CRUSHER.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_CRUSHER, FWAchievementReward.ONE_THOUSAND_CREDITS),

    KITS_DEMOLITIONIST_DESTROY_BLOCKS_MILESTONE("Base Breaker", "Destroy 1,000 blocks with your bombs.", KitID.DEMOLITIONIST.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_DEMOLITIONIST, FWAchievementReward.TWO_HUNDRED_FIFTY_CREDITS),
    KITS_DEMOLITIONIST_BOMB_KILLS_MILESTONE("Ultimate Demolisher", "Get 50 bomb kills as a demolitionist.", KitID.DEMOLITIONIST.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_DEMOLITIONIST, FWAchievementReward.ONE_THOUSAND_CREDITS),
    KITS_DEMOLITIONIST_DOUBLE_BOMB_KILL("2 with one Bomb", "Get a double bomb kill as a demolitionist.", KitID.DEMOLITIONIST.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_DEMOLITIONIST, FWAchievementReward.FIFTY_CREDITS),
    KITS_DEMOLITIONIST_TRIPLE_BOMB_KILL("Bombs, Blocks, and Bones", "Get a triple bomb kill as a demolitionist.", KitID.DEMOLITIONIST.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_DEMOLITIONIST, FWAchievementReward.FIFTY_CREDITS),
    KITS_DEMOLITIONIST_QUADRUPLE_BOMB_KILL("Where did they go? Are they in the walls?", "Get a quadruple bomb kill as a demolitionist.", KitID.DEMOLITIONIST.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_DEMOLITIONIST, FWAchievementReward.FIFTY_CREDITS),
    KITS_DEMOLITIONIST_IGNITE_CREEPER_POTION_EFFECT("Forced Ignition", "Ignite a creeper with a potion effect applied on it.", KitID.DEMOLITIONIST.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_DEMOLITIONIST, FWAchievementReward.TWENTY_CREDITS),
    KITS_DEMOLITIONIST_RECYCLE("Bomb Recycler", "Help a bomber recycle their bomb.", KitID.DEMOLITIONIST.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_DEMOLITIONIST, FWAchievementReward.TWENTY_CREDITS),
    KITS_DEMOLITIONIST_ENEMY_BOMB_EXPLODE_AND_KILL("My bombs are bigger", "Ignite an enemy bomb and get a kill.", KitID.DEMOLITIONIST.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_DEMOLITIONIST, FWAchievementReward.TWENTY_CREDITS),

    KITS_DEMON_BLOOD_CONSUMED_MILESTONE("Archdemon", "Consume 5,000,000ml of blood as demon.", KitID.DEMON.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_DEMON, FWAchievementReward.TWO_HUNDRED_FIFTY_CREDITS),
    KITS_DEMON_HOMING_HEMOGLOBIN_KILLS_MILESTONE("Satan's Wrath", "Get 50 homing hemoglobin kills.", KitID.DEMON.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_DEMON, FWAchievementReward.ONE_THOUSAND_CREDITS),
    KITS_DEMON_BLOOD_HEALING_MILESTONE("The Devil's Advocate", "Restore a total of 5,000 health as demon.", KitID.DEMON.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_DEMON, FWAchievementReward.TWO_HUNDRED_FIFTY_CREDITS),
    KITS_DEMON_BLOOD_BOND_WITHER_SKELETON("Satan's little helper", "Form a blood bond with a wither skeleton.", KitID.DEMON.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_DEMON, FWAchievementReward.TWENTY_CREDITS),
    KITS_DEMON_ELIMINATE_PRIEST("Perish", "Eliminate a priest as demon.", KitID.DEMON.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_DEMON, FWAchievementReward.TWENTY_CREDITS),
    KITS_DEMON_MAINTAIN_MULTIPLE_BLOOD_BONDS("Hemokinesis", "Maintain 4 blood bonds at once.", KitID.DEMON.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_DEMON, FWAchievementReward.TWENTY_CREDITS),

    KITS_ENGINEER_DOC_HOLIDAY("Doc Holiday!", "Have a dispenser dispense to three teammates at the same time.", KitID.ENGINEER.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_ENGINEER, FWAchievementReward.TWENTY_CREDITS),
    KITS_ENGINEER_STUN_SENTRY("Howdy, pardner!", "Stun an enemy sentry!", KitID.ENGINEER.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_ENGINEER, FWAchievementReward.TWENTY_CREDITS),
    KITS_ENGINEER_REPAIR_ALLY("Land Grab!", "Help a teammate repair one of their buildings.", KitID.ENGINEER.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_ENGINEER, FWAchievementReward.TWENTY_CREDITS),
    KITS_ENGINEER_ENGIHERE("The engineer is Engi-here!", "As engineer, take your teleporter that leads right into the enemy base.", KitID.ENGINEER.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_ENGINEER, FWAchievementReward.TWENTY_CREDITS),
    KITS_ENGINEER_SENTRY_KILLS_MILESTONE("Best Little Slaughterhouse in Texas", "Rack up over 50 kills with your sentry gun.", KitID.ENGINEER.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_ENGINEER, FWAchievementReward.ONE_THOUSAND_CREDITS),
    KITS_ENGINEER_DISPENSE_POTIONS_MILESTONE("Drugstore Cowboy", "Dispense a combined amount of over 100 health potions.", KitID.ENGINEER.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_ENGINEER, FWAchievementReward.TWO_HUNDRED_FIFTY_CREDITS),

    KITS_FISH_FISHY_BUSINESS("Fishy Business!", "Fish up and eat a cod!", Material.COD, FWAchievementSubCategory.ACHIEVEMENTS_FISH, FWAchievementReward.UNLOCK_KIT_FISH),
    KITS_FISH_FISH_REPELLENT("Fish Repellent", "Block a fish attack.", Material.COD, FWAchievementSubCategory.ACHIEVEMENTS_FISH, FWAchievementReward.TWENTY_CREDITS),
    KITS_FISH_PUFFERFISH_KILL("I PRAY TO RNG", "Get a pufferfish kill.", Material.COD, FWAchievementSubCategory.ACHIEVEMENTS_FISH, FWAchievementReward.TWENTY_CREDITS),
    KITS_FISH_FISH_KILLS_MILESTONE("Anchovies!", "Get 50 fish kills.", KitID.FISH.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_FISH, FWAchievementReward.ONE_THOUSAND_CREDITS),

    KITS_GLACIER_FREEZE_ENEMIES_MILESTONE("Frozen Blob", "Freeze 250 enemies with your ice ball.", KitID.GLACIER.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_GLACIER, FWAchievementReward.TWO_HUNDRED_FIFTY_CREDITS),
    KITS_GLACIER_SNOWDRIFT_MILESTONE("Ski-Mogul", "Walk on a snow layer 1,000 times.", KitID.GLACIER.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_GLACIER, FWAchievementReward.TWO_HUNDRED_FIFTY_CREDITS),
    KITS_GLACIER_FREEZE_GLACIER("Skiing accident", "Freeze a enemy glacier with an ice ball", KitID.GLACIER.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_GLACIER, FWAchievementReward.TWENTY_CREDITS),
    KITS_GLACIER_KILL_FISH("Ice Fishing", "Kill a fish as glacier.", KitID.GLACIER.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_GLACIER, FWAchievementReward.TWENTY_CREDITS),
    KITS_GLACIER_ICE_BALL_COBWEB("Cold and Tangled", "Freeze an enemy that is in a cobweb with an ice ball.", KitID.GLACIER.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_GLACIER, FWAchievementReward.TWENTY_CREDITS),
    KITS_GLACIER_ICE_BALL_SNOWBALL("Deep Freeze", "Freeze an enemy that is already frozen from a snowman with an ice ball.", KitID.GLACIER.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_GLACIER, FWAchievementReward.TWENTY_CREDITS),

    KITS_GOLEM_PLUS_DOUBLE_SHATTER_KILL("Even rocks move on", "Get a double earth shatter kill.", KitID.GOLEM.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_GOLEM, FWAchievementReward.TWENTY_CREDITS),
    KITS_GOLEM_HIT_4_ENEMIES_SHATTER("There is no planet B", "Hit 4 enemies at once with one earth shatter.", KitID.GOLEM.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_GOLEM, FWAchievementReward.TWENTY_CREDITS),
    KITS_GOLEM_EARTH_WALLS_MILESTONE("Earth Power", "Cast 100 earth walls.", KitID.GOLEM.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_GOLEM, FWAchievementReward.TWO_HUNDRED_FIFTY_CREDITS),
    KITS_GOLEM_EARTH_SHATTER_KILLS_MILESTONE("Killer roots", "Get 50 earth shatter kills.", KitID.GOLEM.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_GOLEM, FWAchievementReward.ONE_THOUSAND_CREDITS),

    KITS_GRAPPLER_ENEMIES_GRAPPLED_MILESTONE("Reel Warrior", "Grapple in 250 entities", KitID.GRAPPLER.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_GRAPPLER, FWAchievementReward.TWO_HUNDRED_FIFTY_CREDITS),
    KITS_GRAPPLER_HOOK_KILLS_MILESTONE("Master of Strings", "Get 50 grappling hook kills", KitID.GRAPPLER.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_GRAPPLER, FWAchievementReward.ONE_THOUSAND_CREDITS),
    KITS_GRAPPLER_KILL_FISH("Chum Bucket", "Kill a fish as grappler", KitID.GRAPPLER.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_GRAPPLER, FWAchievementReward.TWENTY_CREDITS),
    KITS_GRAPPLER_KILL_AQUAMAN("Beach Battle", "Kill an aquaman as grappler", KitID.GRAPPLER.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_GRAPPLER, FWAchievementReward.TWENTY_CREDITS),
    KITS_GRAPPLER_VERTICAL_VICTORY("Vertical Victory", "As grappler, kill a player while at least 10 blocks above them", KitID.GRAPPLER.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_GRAPPLER, FWAchievementReward.FIFTY_CREDITS),
    KITS_GRAPPLER_GRAVITY_WINS("Gravity Wins", "Grapple an enemy player into the void", KitID.GRAPPLER.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_GRAPPLER, FWAchievementReward.FIFTY_CREDITS),
    KITS_GRAPPLER_REEL_DEAL("Reel Deal", "Grapple 10 different enemies with your grappling hook in one life", KitID.GRAPPLER.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_GRAPPLER, FWAchievementReward.FIFTY_CREDITS),
    KITS_GRAPPLER_HOOK_AND_SLASH("Hook and Slash", "Grapple an enemy and hit them with a melee attack within 1 second", KitID.GRAPPLER.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_GRAPPLER, FWAchievementReward.TWENTY_CREDITS),
    KITS_GRAPPLER_FIRST_GRAPPLE("Get over here!", "Pull an enemy toward you using a grappling hook", KitID.GRAPPLER.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_GRAPPLER, FWAchievementReward.TWENTY_CREDITS),

    KITS_GUNNER_DISTANCE_KILL("Weeeeeeeeh! Waaaaaaaahh!", "Gun down an enemy from 50 blocks away.", KitID.GUNNER.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_GUNNER, FWAchievementReward.FIFTY_CREDITS),
    KITS_GUNNER_MACHINE_GUN_KILLS_MILESTONE("Ooohhhh, run, run, I'm coming for you!", "Get 50 machine gun kills.", KitID.GUNNER.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_GUNNER, FWAchievementReward.ONE_THOUSAND_CREDITS),
    KITS_GUNNER_SENTRY_VS_MACHINE_GUN("Go ahead! Build your tiny gun, then run!", "Destroy a sentry with your machine gun.", KitID.GUNNER.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_GUNNER, FWAchievementReward.TWENTY_CREDITS),
    KITS_GUNNER_SHIELD_BULLET("Not today, oh wait...", "Get hit by a gunner bullet while shielding.", KitID.GUNNER.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_GUNNER, FWAchievementReward.TWENTY_CREDITS),

    KITS_HITMAN_AFFECT_4_ENEMIES("Names Are For Friends, So I Don't Need One", "Affect 4 enemies at the same time as hitman.", KitID.HITMAN.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_HITMAN, FWAchievementReward.TWENTY_CREDITS),
    KITS_HITMAN_KILL_AQUAMAN("Name's Dennis. I've been hired to exterminate you.", "As hitman, kill an aquaman.", KitID.HITMAN.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_HITMAN, FWAchievementReward.TWENTY_CREDITS),
    KITS_HITMAN_INVIS_GLOWING("Agent 47's hair-loss program", "Affect an enemy with glowing while they are invisible.", KitID.HITMAN.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_HITMAN, FWAchievementReward.TWENTY_CREDITS),
    KITS_HITMAN_DAMAGE_DART_KILLS_MILESTONE("One Day, I Will Think Of This As Just Another Job", "Get 50 damage dart kills.", KitID.HITMAN.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_HITMAN, FWAchievementReward.ONE_THOUSAND_CREDITS),

    KITS_HULK_HULK_SMASH("HULK SMASH", "Hulk out and destroy a sentry, bomb and a cobweb.", KitID.HULK.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_HULK, FWAchievementReward.TWO_HUNDRED_FIFTY_CREDITS),
    KITS_HULK_HULK_BOW_KILL("Quit yapping!", "Kill an enemy with your hulk bow.", KitID.HULK.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_HULK, FWAchievementReward.TWENTY_CREDITS),
    KITS_HULK_3_RAGE_KILLS("I'M ALWAYS ANGRY", "Get 3 kills during one rage mode activation!", KitID.HULK.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_HULK, FWAchievementReward.FIFTY_CREDITS),

    KITS_ILLUSIONIST_KILL_WHILE_INVIS("Haha...your plan Z failed!", "Kill an illusionist while they are invisible.", KitID.ILLUSIONIST.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_ILLUSIONIST, FWAchievementReward.TWENTY_CREDITS),
    KITS_ILLUSIONIST_REVENGE("Plan Z is working perfectly!", "Fake your death as illusionist and kill the opponent that you faked your death against.", KitID.ILLUSIONIST.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_ILLUSIONIST, FWAchievementReward.TWENTY_CREDITS),
    KITS_ILLUSIONIST_FAKE_DEATH("Plan Z, I love ya!", "Fake your death as illusionist.", KitID.ILLUSIONIST.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_ILLUSIONIST, FWAchievementReward.TWENTY_CREDITS),
    KITS_ILLUSIONIST_HACK_SENTRY("I murdered your toys as well.", "Hack an enemy sentry as illusionist.", KitID.ILLUSIONIST.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_ILLUSIONIST, FWAchievementReward.TWENTY_CREDITS),
    KITS_ILLUSIONIST_FUTURE_SIGHT_KILLS_MILESTONE("Pure Divination", "Get 50 future sight kills.", KitID.ILLUSIONIST.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_ILLUSIONIST, FWAchievementReward.ONE_THOUSAND_CREDITS),

    KITS_JUMPER_INTO_BASE("Oh how convenient?", "Teleport into an enemy beacon room from outside the base.", KitID.JUMPER.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_JUMPER, FWAchievementReward.TWENTY_CREDITS),
    KITS_JUMPER_TELEPORT_TOTAL_DISTANCE_MILESTONE("What am I, an Enderman?", "Teleport a total distance of 2,500 blocks.", KitID.JUMPER.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_JUMPER, FWAchievementReward.TWO_HUNDRED_FIFTY_CREDITS),
    KITS_JUMPER_TELEPORT_BACK_TO_BASE("Run That Back", "Teleport back to your base while in combat.", KitID.JUMPER.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_JUMPER, FWAchievementReward.TWENTY_CREDITS),
    KITS_JUMPER_TELEPORT_BACK_TO_BASE_AND_STOP_BREAK("Just in time!", "Stop an enemy from breaking the beacon by teleporting to them.", KitID.JUMPER.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_JUMPER, FWAchievementReward.TWENTY_CREDITS),

    KITS_KANGAROO_STOMP_KILLS_MILESTONE("Stomptopia", "Get 50 stomp kills.", KitID.KANGAROO.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_KANGAROO, FWAchievementReward.ONE_THOUSAND_CREDITS),
    KITS_KANGAROO_STOMP_DESTROY_SENTRY("Crippled Turret", "Destroy a sentry with your stomp ability.", KitID.KANGAROO.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_KANGAROO, FWAchievementReward.TWENTY_CREDITS),
    KITS_KANGAROO_STOMP_AND_HIT_FROM_50_BLOCKS("Mega Stomp", "Stomp on an enemy after falling for 50 blocks.", KitID.KANGAROO.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_KANGAROO, FWAchievementReward.FIFTY_CREDITS),

    KITS_KNIGHT_DEFLECT_KILL("Spiky!", "Get a deflect kill.", KitID.KNIGHT.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_KNIGHT, FWAchievementReward.TWENTY_CREDITS),
    KITS_KNIGHT_ROYAL_GUARD("Royal Shield!", "Absorb a decent amount of damage with the royal guard passive.", KitID.KNIGHT.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_KNIGHT, FWAchievementReward.TWENTY_CREDITS),
    KITS_KNIGHT_DEFLECT_KILLS_MILESTONE("Thorns 50", "Get 50 deflect kills.", KitID.KNIGHT.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_KNIGHT, FWAchievementReward.ONE_THOUSAND_CREDITS),

    KITS_MASTER_CREEPER_DOUBLE_KILL("Come on kiddies, have some ice cream.", "Get a double creeper kill.", KitID.MASTER.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_MASTER, FWAchievementReward.TWENTY_CREDITS),
    KITS_MASTER_CREEPER_TRIPLE_KILL("Oh no, you dropped your ice cream.", "Get a triple creeper kill.", KitID.MASTER.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_MASTER, FWAchievementReward.TWENTY_CREDITS),
    KITS_MASTER_CREEPER_KILLS_MILESTONE("Creeper Army!", "Get 50 creeper kills.", KitID.MASTER.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_MASTER, FWAchievementReward.ONE_THOUSAND_CREDITS),
    KITS_MASTER_SUPER_CREEPER_KILL("Head Dropper", "Get a super creeper kill.", KitID.MASTER.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_MASTER, FWAchievementReward.TWENTY_CREDITS),

    KITS_MATHEMATICIAN_CORRECT_ANSWERS_MILESTONE("Math Wizard", "Solve 100 math problems.", KitID.MATHEMATICIAN.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_MATHEMATICIAN, FWAchievementReward.TWO_HUNDRED_FIFTY_CREDITS),
    KITS_MATHEMATICIAN_PRACTICE_PROBLEM_KILLS_MILESTONE("Just an arbitrary number", "Get 50 practice problems kills.", KitID.MATHEMATICIAN.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_MATHEMATICIAN, FWAchievementReward.ONE_THOUSAND_CREDITS),
    KITS_MATHEMATICIAN_MATH_HEALING_MILESTONE("All according to my calculations", "Do a total of 1,000 math healing.", KitID.MATHEMATICIAN.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_MATHEMATICIAN, FWAchievementReward.FIVE_HUNDRED_CREDITS),
    KITS_MATHEMATICIAN_HEAL_AN_ENEMY("Consequences of bad math", "Heal an enemy.", KitID.MATHEMATICIAN.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_MATHEMATICIAN, FWAchievementReward.TWENTY_CREDITS),
    KITS_MATHEMATICIAN_DIE_BY_INCORRECTLY_ANSWERING_PROBLEMS("Algebruh moment", "Pay the ultimate price for incorrectly answering a practice problem.", KitID.MATHEMATICIAN.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_MATHEMATICIAN, FWAchievementReward.TWENTY_CREDITS),
    KITS_MATHEMATICIAN_BEST_EDR_NO_FINAL_BLOWS("Top-tier Pacifist", "Win a game with the best EDR with no final blows.", KitID.MATHEMATICIAN.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_MATHEMATICIAN, FWAchievementReward.UNLOCK_KIT_MATHEMATICIAN),

    KITS_MEDIC_TOTAL_HEALING_MILESTONE("Ze healing is not as revarding as ze hurting!", "Do a total of 5,000 healing as medic.", KitID.MEDIC.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_MEDIC, FWAchievementReward.FIVE_HUNDRED_CREDITS),
    KITS_MEDIC_HEAL_4_ALLIES_AT_ONCE("Get zem. Raus, Raus!", "Heal 4 allies at once as medic.", KitID.MEDIC.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_MEDIC, FWAchievementReward.TWENTY_CREDITS),

    KITS_MERCY_ATTACH_BEAM_SELF("Fine, I'll do it myself...", "Attach a mercy beam to yourself as mercy.", KitID.MERCY.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_MERCY, FWAchievementReward.TWENTY_CREDITS),
    KITS_MERCY_KILL("You might not want to tell your friends about that.", "Get a final blow as mercy", KitID.MERCY.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_MERCY, FWAchievementReward.TWENTY_CREDITS),
    KITS_MERCY_ENGINEER("Midwife Crisis", "As mercy, have your beam attached to a friendly engineer as they repair their sentry gun.", KitID.MERCY.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_MERCY, FWAchievementReward.TWENTY_CREDITS),
    KITS_MERCY_KILLS_MILESTONE("Battle Mercy", "Get 50 kills as Mercy.", KitID.MERCY.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_MERCY, FWAchievementReward.ONE_THOUSAND_CREDITS),
    KITS_MERCY_HEALING_MILESTONE("Guardian Angel", "Restore a total of 5,000 health as kit mercy", KitID.MERCY.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_MERCY, FWAchievementReward.TWO_HUNDRED_FIFTY_CREDITS),
    KITS_MERCY_MULTI_ALLY_CONNECTIONS("Beam Team", "Create a mercy beam connection between 3 allies.", KitID.MERCY.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_MERCY, FWAchievementReward.TWENTY_CREDITS),
    KITS_MERCY_MULTI_ENEMY_CONNECTIONS("Chain of Pain", "Create a mercy beam connection between 3 enemies.", KitID.MERCY.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_MERCY, FWAchievementReward.TWENTY_CREDITS),

    KITS_MINER_MINE_BLOCKS("Efficiently Mining", "As Miner, mine over 100 blocks in one life.", KitID.MINER.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_MINER, FWAchievementReward.TWENTY_CREDITS),
    KITS_MINER_BREAK_TANK_SHIELD_INSTANTLY("Shield Smasher", "Break an enemy shield while using Miner's Fervor.", KitID.MINER.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_MINER, FWAchievementReward.TWENTY_CREDITS),
    KITS_MINER_BREAK_BLOCKS_MILESTONE("Mole Rat", "Break 10,000 blocks as Miner.", KitID.MINER.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_MINER, FWAchievementReward.FIVE_HUNDRED_CREDITS),
    KITS_MINER_BREAK_ENGINEER_BLOCKS("Efficiently Scrapping", "Destroy an Engineer's dispenser, sentry, and teleporter pads in one life.", KitID.MINER.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_MINER, FWAchievementReward.TWENTY_CREDITS),
    KITS_MINER_GOBBLESTONE_KILL("Rock Lobber", "Get a Gobblestone kill.", KitID.MINER.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_MINER, FWAchievementReward.TWENTY_CREDITS),
    KITS_MINER_GOBBLESTONE_DOUBLE_KILL("Two Birds, One Stone", "Get a double Gobblestone kill.", KitID.MINER.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_MINER, FWAchievementReward.THIRTY_CREDITS),
    KITS_MINER_GOBBLESTONE_TRIPLE_KILL("Rockslide", "Get a triple Gobblestone kill.", KitID.MINER.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_MINER, FWAchievementReward.FIFTY_CREDITS),
    KITS_MINER_GOBBLESTONE_KILLS_MILESTONE("Rock Legend", "Get 50 Gobblestone kills.", KitID.MINER.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_MINER, FWAchievementReward.ONE_THOUSAND_CREDITS),
    KITS_MINER_MINE_EARTH_WALL("Wall Breaker", "Dig through an entire Earth Golem wall.", KitID.MINER.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_MINER, FWAchievementReward.TWENTY_CREDITS),
    KITS_MINER_GIVE_BUILDER_GOBBLESTONE("Construction Assistant", "Give Gobblestone to a friendly Builder.", KitID.MINER.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_MINER, FWAchievementReward.TWENTY_CREDITS),

    KITS_MUSKETEER_DUEL("ahh mustard...", "Eliminate an enemy musketeer from a far distance as they eliminate you.", KitID.MUSKETEER.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_MUSKETEER, FWAchievementReward.TWENTY_CREDITS),
    KITS_MUSKETEER_KILL_MIDAIR("Jumper Stumper", "Eliminate an enemy that is in midair with your rifle", KitID.MUSKETEER.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_MUSKETEER, FWAchievementReward.TWENTY_CREDITS),
    KITS_MUSKETEER_KILL_TANK_WHILE_THEY_ARE_SHIELDING("A shield's not gonna stop me!", "Shoot an enemy through their shield to eliminate them.", KitID.MUSKETEER.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_MUSKETEER, FWAchievementReward.TWENTY_CREDITS),
    KITS_MUSKETEER_SENTRY_75_BLOCKS_AWAY("Sentry Sniper", "Destroy a sentry from over 75 blocks away.", KitID.MUSKETEER.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_MUSKETEER, FWAchievementReward.TWENTY_CREDITS),
    KITS_MUSKETEER_RIFLE_KILLS_MILESTONE("American Revolution", "Get 50 rifle kills.", KitID.MUSKETEER.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_MUSKETEER, FWAchievementReward.ONE_THOUSAND_CREDITS),
    KITS_MUSKETEER_KILL_WHILE_RELOADING("Gun needs a break, eh?", "Kill an enemy musketeer while they are reloading.", KitID.MUSKETEER.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_MUSKETEER, FWAchievementReward.TWENTY_CREDITS),

    KITS_NECROMANCER_SKELETON_KILLS_MILESTONE("Dead Men Tell No Tales", "Get 50 skeleton kills.", KitID.NECROMANCER.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_NECROMANCER, FWAchievementReward.ONE_THOUSAND_CREDITS),
    KITS_NECROMANCER_SKELETON_KILLS_CREEPER("Wither Roses are black, Creepers are green", "Have your wither skeleton minion kill an enemy creeper.", KitID.NECROMANCER.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_NECROMANCER, FWAchievementReward.TWENTY_CREDITS),
    KITS_NECROMANCER_GATHER_ESSENCE_MILESTONE("Undead Alchemy", "Gather a total of 100 Essence of the Afterlife.", KitID.NECROMANCER.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_NECROMANCER, FWAchievementReward.TWO_HUNDRED_FIFTY_CREDITS),

    KITS_NINJA_PARRY_KILLS_MILESTONE("Fruit of the Blade", "Get 50 katana parry kills.", KitID.NINJA.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_NINJA, FWAchievementReward.ONE_THOUSAND_CREDITS),
    KITS_NINJA_KI_ACCUMULATED_MILESTONE("Reservoir of Will", "Accumulate 10,000 Ki.", KitID.NINJA.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_NINJA, FWAchievementReward.TWO_HUNDRED_FIFTY_CREDITS),
    KITS_NINJA_DODGES_PERFORMED_MILESTONE("Dance of Shadows", "Perform 250 ninja dodges.", KitID.NINJA.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_NINJA, FWAchievementReward.TWO_HUNDRED_FIFTY_CREDITS),
    KITS_NINJA_KILL_SPY("Outstealthed", "Kill a spy as ninja.", KitID.NINJA.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_NINJA, FWAchievementReward.TWENTY_CREDITS),
    KITS_NINJA_KILL_KNIGHT("Knightmare", "Kill a knight as ninja.", KitID.NINJA.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_NINJA, FWAchievementReward.TWENTY_CREDITS),
    KITS_NINJA_PARRY_A_PARRY("Phantom Reflexes", "Parry a katana parry as ninja.", KitID.NINJA.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_NINJA, FWAchievementReward.THIRTY_CREDITS),
    KITS_NINJA_KILL_AFTER_DODGE("From the Shadows", "Earn a kill within 2 seconds after using the ninja dodge ability.", KitID.NINJA.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_NINJA, FWAchievementReward.TWENTY_CREDITS),
    KITS_NINJA_PARRY_KILL_NOT_SOURCE("Collateral Cut", "Earn a katana parry kill on an enemy that isn't the parry source.", KitID.NINJA.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_NINJA, FWAchievementReward.TWENTY_CREDITS),
    KITS_NINJA_KILL_BOMBER("Smoke Without Bombs", "Kill a bomber as ninja", KitID.NINJA.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_NINJA, FWAchievementReward.TWENTY_CREDITS),
    KITS_NINJA_MANY_PARRIES_IN_ONE_LIFE("Art of Redirection", "Parry 10 attacks in one life", KitID.NINJA.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_NINJA, FWAchievementReward.FIFTY_CREDITS),

    KITS_PORCUPINE_QUILL_KILLS_MILESTONE("Spiny", "Get 50 quill kills.", KitID.PORCUPINE.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_PORCUPINE, FWAchievementReward.ONE_THOUSAND_CREDITS),
    KITS_PORCUPINE_DOUBLE_QUILL_KILL("Effective Quills", "Get a double quill kill.", KitID.PORCUPINE.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_PORCUPINE, FWAchievementReward.TWENTY_CREDITS),
    KITS_PORCUPINE_TRIPLE_QUILL_KILL("Super Effective Quills", "Get a triple quill kill.", KitID.PORCUPINE.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_PORCUPINE, FWAchievementReward.TWENTY_CREDITS),
    KITS_PORCUPINE_KILL_WITH_THORNS("Did that hurt?", "Get a kill with your thorns as porcupine.", KitID.PORCUPINE.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_PORCUPINE, FWAchievementReward.TWENTY_CREDITS),

    KITS_POTION_MASTER_POTION_KILLS_MILESTONE("Superb Cocktail", "Get 50 potion kills.", KitID.POTION_MASTER.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_POTION_MASTER, FWAchievementReward.ONE_THOUSAND_CREDITS),
    KITS_POTION_MASTER_KILL_BRUTE_IN_BERSERK_WITH_WEAKNESS("Damage? What Damage?", "Kill a brute while they are in berserk and have weakness applied as potion master.", KitID.POTION_MASTER.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_POTION_MASTER, FWAchievementReward.TWENTY_CREDITS),
    KITS_POTION_MASTER_DOUBLE_POTION_KILL("Two to go please!", "Get a double potion kill.", KitID.POTION_MASTER.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_POTION_MASTER, FWAchievementReward.TWENTY_CREDITS),
    KITS_POTION_MASTER_POTION_SPLASH_CREEPER("Creeper Cocktail", "Throw a potion on an enemy creeper as potion master.", KitID.POTION_MASTER.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_POTION_MASTER, FWAchievementReward.TWENTY_CREDITS),

    KITS_PRIEST_LIGHT_BEAM_HITS_MILESTONE("Sunbathing Rays", "Hit 1,000 allies/enemies with light beam.", KitID.PRIEST.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_PRIEST, FWAchievementReward.ONE_HUNDRED_CREDITS),
    KITS_PRIEST_STATE_OF_GRACE("State of Grace!", "Receive Grace 1,000 times.", KitID.PRIEST.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_PRIEST, FWAchievementReward.TWO_HUNDRED_FIFTY_CREDITS),
    KITS_PRIEST_CLEANSING_LIGHT("Cleansing Light", "Absolve with maximum grace 50 times.", KitID.PRIEST.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_PRIEST, FWAchievementReward.TWO_HUNDRED_FIFTY_CREDITS),
    KITS_PRIEST_POWER_OF_THE_SUN("Bask in the Light!", "Absolve with maximum grace.", KitID.PRIEST.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_PRIEST, FWAchievementReward.TWO_HUNDRED_FIFTY_CREDITS),
    KITS_PRIEST_LIGHT_HEALING_MILESTONE("The Tome of Warmth!", "As Priest, restore a total of 1,000 health.", KitID.PRIEST.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_PRIEST, FWAchievementReward.FIVE_HUNDRED_CREDITS),
    KITS_PRIEST_LIGHT_BEAM_HIT_DEMON("Repent!", "Ignite a demon with your light beam spell.", KitID.PRIEST.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_PRIEST, FWAchievementReward.TWENTY_CREDITS),

    KITS_PROMETHEUS_IGNITE_ENEMIES_MILESTONE("It's lit!", "Ignite enemies 1,000 times.", KitID.PROMETHEUS.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_PROMETHEUS, FWAchievementReward.TWO_HUNDRED_FIFTY_CREDITS),
    KITS_PROMETHEUS_FIRE_KILLS_MILESTONE("I'll have a blazed doughnut", "Get 50 Fire Kills.", KitID.PROMETHEUS.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_PROMETHEUS, FWAchievementReward.ONE_THOUSAND_CREDITS),
    KITS_PROMETHEUS_FIREBALL_KILLS_MILESTONE("In the Hall of Flame.", "Get 50 fireball kills.", KitID.PROMETHEUS.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_PROMETHEUS, FWAchievementReward.ONE_THOUSAND_CREDITS),
    KITS_PROMETHEUS_DOUBLE_FIREBALL_KILL("Grab the ember-ella!", "Get a double fireball kill.", KitID.PROMETHEUS.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_PROMETHEUS, FWAchievementReward.FIFTY_CREDITS),
    KITS_PROMETHEUS_TRIPLE_FIREBALL_KILL("Burn down the em-fire!", "Get a triple fireball kill.", KitID.PROMETHEUS.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_PROMETHEUS, FWAchievementReward.FIFTY_CREDITS),
    KITS_PROMETHEUS_IMBUE_WHILE_ON_FIRE("That was heated.", "Use the imbue spell to save yourself from burning.", KitID.PROMETHEUS.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_PROMETHEUS, FWAchievementReward.TWENTY_CREDITS),
    KITS_PROMETHEUS_BURNT_TO_ASH("That's not fire.", "Use the imbue spell again after already casting it.", KitID.PROMETHEUS.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_PROMETHEUS, FWAchievementReward.TWENTY_CREDITS),
    KITS_PROMETHEUS_FROST_FIRE("Frost fire", "Ignite an enemy that has the frozen effect.", KitID.PROMETHEUS.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_PROMETHEUS, FWAchievementReward.TWENTY_CREDITS),
    KITS_PROMETHEUS_DEFLECTED_ENEMY_FIREBALL("Deflected…but at what cost?", "Deflect an enemy fireball and kill an ally.", KitID.PROMETHEUS.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_PROMETHEUS, FWAchievementReward.TWENTY_CREDITS),

    KITS_PYROTECHNIC_ROCKET_KILLS_MILESTONE("Snap, Crackle, Pop", "Get 50 rocket kills.", KitID.PYROTECHNIC.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_PYROTECHNIC, FWAchievementReward.ONE_THOUSAND_CREDITS),
    KITS_PYROTECHNIC_DOUBLE_ROCKET_KILL("Keep calm and sparkle on.", "Get a double rocket kill.", KitID.PYROTECHNIC.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_PYROTECHNIC, FWAchievementReward.TWENTY_CREDITS),
    KITS_PYROTECHNIC_TRIPLE_ROCKET_KILL("Glorified Gunpowder", "Get a triple rocket kill.", KitID.PYROTECHNIC.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_PYROTECHNIC, FWAchievementReward.TWENTY_CREDITS),
    KITS_PYROTECHNIC_ROCKET_RAVEN_OUT_OF_FLIGHT("When birds fry", "Knock a raven out of flight using rockets.", KitID.PYROTECHNIC.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_PYROTECHNIC, FWAchievementReward.TWENTY_CREDITS),

    KITS_RAVEN_FLIGHT_DISTANCE_MILESTONE("I believe I can fly...", "Fly over 10,000 meters.", KitID.RAVEN.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_RAVEN, FWAchievementReward.TWO_HUNDRED_FIFTY_CREDITS),
    KITS_RAVEN_MAGIC_FAIL_DEATH("How did I die?", "Forget to stop your flight spell.", KitID.RAVEN.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_RAVEN, FWAchievementReward.TWENTY_CREDITS),
    KITS_RAVEN_FLIGHT_DURATION_MILESTONE("Project Excelsior", "Fly for 30 minutes.", KitID.RAVEN.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_RAVEN, FWAchievementReward.TWO_HUNDRED_FIFTY_CREDITS),

    KITS_SLIME_SLIME_KILL("Not just a damage sponge!", "Get a slime kill.", KitID.SLIME.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_SLIME, FWAchievementReward.TWENTY_CREDITS),
    KITS_SLIME_SLIME_KILLS_MILESTONE("Optimus Slime", "Get 50 slime kills.", KitID.SLIME.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_SLIME, FWAchievementReward.ONE_THOUSAND_CREDITS),
    KITS_SLIME_ALLY_DAMAGE_MITIGATED_MILESTONE("Damage Sponge", "Mitigate 1,000 damage from allies as slime.", KitID.SLIME.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_SLIME, FWAchievementReward.TWO_HUNDRED_FIFTY_CREDITS),
    KITS_SLIME_EXTRA_PROTECTION("Extra protection.", "Provide a kangaroo with slime armor!", KitID.SLIME.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_SLIME, FWAchievementReward.TWENTY_CREDITS),
    KITS_SLIME_ABSORPTION("A touch of jello.", "Have your slime give you absorption.", KitID.SLIME.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_SLIME, FWAchievementReward.TWENTY_CREDITS),
    KITS_SLIME_SLIME_ON_SLIME("Slimy slime", "Provide slime armor to your slimes.", KitID.SLIME.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_SLIME, FWAchievementReward.TWENTY_CREDITS),

    KITS_SNIPER_HEADSHOT_KILLS_MILESTONE("Head Humiliator", "Get 50 headshot kills.", KitID.SNIPER.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_SNIPER, FWAchievementReward.ONE_THOUSAND_CREDITS),
    KITS_SNIPER_KNEESHOT_KILLS_MILESTONE("Knee Knocker", "Get 50 kneeshot kills.", KitID.SNIPER.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_SNIPER, FWAchievementReward.ONE_THOUSAND_CREDITS),
    KITS_SNIPER_BOW_MASTER("The New Bow Master!", "Headshot your opponent 3 times in a row and bring them to the grave.", KitID.SNIPER.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_SNIPER, FWAchievementReward.TWENTY_CREDITS),
    KITS_SNIPER_KNEESHOT("I used to be an adventurer like you...", "Shoot an enemy in the knees as sniper.", KitID.SNIPER.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_SNIPER, FWAchievementReward.TWENTY_CREDITS),
    KITS_SNIPER_HEADSHOT("Took more than the knee!", "Shoot an enemy in the head as sniper", KitID.SNIPER.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_SNIPER, FWAchievementReward.TWENTY_CREDITS),

    KITS_SNOW_GOLEM_ICICLE_KILLS_MILESTONE("Breaking the Ice", "Get 50 icicle kills.", KitID.SNOW_GOLEM.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_SNOW_GOLEM, FWAchievementReward.ONE_THOUSAND_CREDITS),
    KITS_SNOW_GOLEM_HEALING_MILESTONE("Frost Aid Kit", "Restore a total of 5,000 health as kit snow golem.", KitID.SNOW_GOLEM.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_SNOW_GOLEM, FWAchievementReward.TWO_HUNDRED_FIFTY_CREDITS),
    KITS_SNOW_GOLEM_KILL_PROMETHEUS("Putting the Flame Out", "Kill an enemy prometheus as kit snow golem.", KitID.SNOW_GOLEM.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_SNOW_GOLEM, FWAchievementReward.TWENTY_CREDITS),
    KITS_SNOW_GOLEM_KILL_GOLEM("Glacial Smash", "Kill an enemy golem as kit snow golem.", KitID.SNOW_GOLEM.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_SNOW_GOLEM, FWAchievementReward.TWENTY_CREDITS),
    KITS_SNOW_GOLEM_SNOW_GOLEM_KILL("Seasonal Flurry", "Get a snow golem kill.", KitID.SNOW_GOLEM.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_SNOW_GOLEM, FWAchievementReward.TWENTY_CREDITS),
    KITS_SNOW_GOLEM_MINIONS_HEAL_EACH_OTHER("Frost Friends Forever", "Have both your snow golem minions heal each other.", KitID.SNOW_GOLEM.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_SNOW_GOLEM, FWAchievementReward.TWENTY_CREDITS),
    KITS_SNOW_GOLEM_ICICLE_ATTACK_SLIME_MINION("Cryo-Goop", "Attack an enemy slime minion with an icicle projectile.", KitID.SNOW_GOLEM.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_SNOW_GOLEM, FWAchievementReward.TWENTY_CREDITS),
    KITS_SNOW_GOLEM_COORDINATED_HEALING("Instant Ice Pack", "Heal an ally together with your snow golem minions.", KitID.SNOW_GOLEM.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_SNOW_GOLEM, FWAchievementReward.TWENTY_CREDITS),

    KITS_SNOWMAN_FREEZE_ENEMIES_MILESTONE("Ice Nation", "Freeze 100 enemies with your freeze spell.", KitID.SNOWMAN.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_SNOWMAN, FWAchievementReward.TWO_HUNDRED_FIFTY_CREDITS),
    KITS_SNOWMAN_FREEZE_RAVEN_FLYING("Heal Those Broken Wings", "Freeze a raven while they are flying.", KitID.SNOWMAN.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_SNOWMAN, FWAchievementReward.TWENTY_CREDITS),
    KITS_SNOWMAN_FREEZE_FROM_50_BLOCKS("Snowball Sniper", "Freeze an enemy from 50 blocks away.", KitID.SNOWMAN.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_SNOWMAN, FWAchievementReward.TWENTY_CREDITS),

    KITS_SOLDIER_GRENADE_DESTROY_SENTRY("That's where books get you, professor!", "Destroy an engineer sentry with soldier's grenade.", KitID.SOLDIER.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_SOLDIER, FWAchievementReward.TWENTY_CREDITS),
    KITS_SOLDIER_DOUBLE_GRENADE_KILL("Maggots!", "Get a double grenade kill.", KitID.SOLDIER.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_SOLDIER, FWAchievementReward.TWENTY_CREDITS),
    KITS_SOLDIER_GRENADE_KILLS_MILESTONE("Take your lumps like a man, Private Twinkletoes.", "Get 50 grenade kills.", KitID.SOLDIER.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_SOLDIER, FWAchievementReward.ONE_THOUSAND_CREDITS),
    KITS_SOLDIER_DESTROY_BUILDER_BRICKS("Oh no...your bricks...they're broken", "Destroy builder bricks with soldier.", KitID.SOLDIER.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_SOLDIER, FWAchievementReward.TWENTY_CREDITS),
    KITS_SOLDIER_DISABLE_SHIELD("Block this!", "Disable an enemy shield with your grenade.", KitID.SOLDIER.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_SOLDIER, FWAchievementReward.TWENTY_CREDITS),
    KITS_SOLDIER_GRENADE_KILL_AFTER_DEATH("Mutually Assured Destruction", "Kill an enemy with a grenade after he kills you.", KitID.SOLDIER.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_SOLDIER, FWAchievementReward.TWENTY_CREDITS),

    KITS_SONIC_TRAVEL_MILESTONE("Escape From The City", "Use your sonic speed to travel 10,000 meters.", KitID.SONIC.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_SONIC, FWAchievementReward.TWO_HUNDRED_FIFTY_CREDITS),
    KITS_SONIC_SONIC_BOOM_KILLS_MILESTONE("Through the Sound Barrier", "Get 50 sonic boom kills.", KitID.SONIC.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_SONIC, FWAchievementReward.ONE_THOUSAND_CREDITS),
    KITS_SONIC_GOOMBA_STOMP("Goomba Stomp", "Goomba stomp on someone to activate your sonic boom.", KitID.SONIC.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_SONIC, FWAchievementReward.TWENTY_CREDITS),
    KITS_SONIC_DOUBLE_BOOM_KILL("I'm a hedgehog", "Get a double sonic boom kill!", KitID.SONIC.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_SONIC, FWAchievementReward.ONE_HUNDRED_CREDITS),
    KITS_SONIC_TRIPLE_BOOM_KILL("Gotta Go Fast", "Get a triple sonic boom kill!", KitID.SONIC.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_SONIC, FWAchievementReward.ONE_HUNDRED_CREDITS),

    KITS_SPIDER_TRAPS_ACTIVATED_MILESTONE("Web Master", "Activate 250 web traps.", KitID.SPIDER.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_SPIDER, FWAchievementReward.TWO_HUNDRED_FIFTY_CREDITS),
    KITS_SPIDER_TRAP_INVIS_SPY("Sticky circumstance", "Trap an invisible spy with a web trap.", KitID.SPIDER.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_SPIDER, FWAchievementReward.TWENTY_CREDITS),

    KITS_SPY_SNEAK_ATTACK("You got blood on my suit!", "Earn a sneak attack kill as spy!", KitID.SPY.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_SPY, FWAchievementReward.TWENTY_CREDITS),
    KITS_SPY_ENEMY_TELEPORTER("Sorry to 'pop-in' unannounced!", "Take an enemy teleporter as a spy!", KitID.SPY.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_SPY, FWAchievementReward.TWENTY_CREDITS),
    KITS_SPY_ENEMY_DISPENSER("Happy trails, laborer!", "Use an enemy dispenser as a spy!", KitID.SPY.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_SPY, FWAchievementReward.TWENTY_CREDITS),
    KITS_SPY_SNEAK_ATTACK_KILLS_MILESTONE("Oh dear, I've made quite a mess.", "Get 50 sneak attack kills.", KitID.SPY.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_SPY, FWAchievementReward.ONE_THOUSAND_CREDITS),
    KITS_SPY_KILL_INVISIBLE_SPY("Didn't see you there", "Kill an invisible spy.", KitID.SPY.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_SPY, FWAchievementReward.TWENTY_CREDITS),

    KITS_VITALIST_TOTAL_HEALING_MILESTONE("Unbending Support", "Heal 5,000 health with crossbow shots as vitalist", KitID.VITALIST.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_VITALIST, FWAchievementReward.FIVE_HUNDRED_CREDITS),
    KITS_VITALIST_CROSSBOW_KILLS_MILESTONE("Blessed Rebuttal", "Get 50 kills with the crossbow as vitalist", KitID.VITALIST.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_VITALIST, FWAchievementReward.ONE_THOUSAND_CREDITS),
    KITS_VITALIST_CRUSADER_HEAL("Crusader²", "Heal a crusader as vitalist", KitID.VITALIST.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_VITALIST, FWAchievementReward.TWENTY_CREDITS),
    KITS_VITALIST_HEAL_100_BLOCKS("Value from a Distance", "Heal a teammate from over 100 blocks away as vitalist", KitID.VITALIST.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_VITALIST, FWAchievementReward.TWENTY_CREDITS),

    KITS_WIZARD_DOUBLE_CHAIN_LIGHTNING_KILL("Watts up?", "Get a double chain lightning kill.", KitID.WIZARD.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_WIZARD, FWAchievementReward.TWENTY_CREDITS),
    KITS_WIZARD_TRIPLE_CHAIN_LIGHTNING_KILL("I'm shocked at the current situation", "Get a triple chain lightning kill.", KitID.WIZARD.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_WIZARD, FWAchievementReward.TWO_HUNDRED_FIFTY_CREDITS),
    KITS_WIZARD_QUADRUPLE_CHAIN_LIGHTNING_KILL("Learn how to conduct yourself", "Get a quadruple chain lightning kill.", KitID.WIZARD.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_WIZARD, FWAchievementReward.TWO_HUNDRED_FIFTY_CREDITS),
    KITS_WIZARD_DOUBLE_LIGHTNING_STRIKE_KILL("Shocking revelation!", "Get a double lightning strike kill.", KitID.WIZARD.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_WIZARD, FWAchievementReward.TWENTY_CREDITS),
    KITS_WIZARD_TRIPLE_LIGHTNING_STRIKE_KILL("It hertz!", "Get a triple lightning strike kill.", KitID.WIZARD.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_WIZARD, FWAchievementReward.TWO_HUNDRED_FIFTY_CREDITS),
    KITS_WIZARD_CHAIN_LIGHTNING_HIT_ENEMY_AND_ENGINEER_BLOCK("I'm de-lighted", "Use chain lightning and hit an enemy and an enemy engineer block.", KitID.WIZARD.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_WIZARD, FWAchievementReward.TWENTY_CREDITS),
    KITS_WIZARD_LIGHTNING_STRIKE_KILL_WHILE_DAMAGE_BOOSTED("I'm ex-static", "Get a lightning strike kill while damage boosted by a friendly mercy.", KitID.WIZARD.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_WIZARD, FWAchievementReward.TWENTY_CREDITS),
    KITS_WIZARD_LIGHTNING_CREEPER("Powered Creeper", "Electrify an ally creeper.", KitID.WIZARD.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_WIZARD, FWAchievementReward.TWENTY_CREDITS),
    KITS_WIZARD_CHAIN_LIGHTNING_KILLS_MILESTONE("I'm wired different", "Get 50 chain lightning kills.", KitID.WIZARD.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_WIZARD, FWAchievementReward.ONE_THOUSAND_CREDITS),
    KITS_WIZARD_LIGHTNING_STRIKE_KILLS_MILESTONE("Be sure to wear shocks", "Get 50 lightning strike kills.", KitID.WIZARD.getMaterialRepresentation(), FWAchievementSubCategory.ACHIEVEMENTS_WIZARD, FWAchievementReward.ONE_THOUSAND_CREDITS),

    // MAPS
    MAPS_WIN_BIOHAZARD("Acid's not so toxic...", "Win a game on the map Biohazard.", Material.LIME_GLAZED_TERRACOTTA, FWAchievementSubCategory.CLASSIC_MAP_WIN, FWAchievementReward.TWENTY_CREDITS),
    MAPS_WIN_BOOTCAMP("I survived bootcamp!", "Win a game on the map Bootcamp.", Material.PODZOL, FWAchievementSubCategory.CLASSIC_MAP_WIN, FWAchievementReward.TWENTY_CREDITS),
    MAPS_WIN_CANDYLAND("Sugar Rush!", "Win a game on the map Candyland.", Material.COOKIE, FWAchievementSubCategory.AD_MAP_WIN, FWAchievementReward.TWENTY_CREDITS),
    MAPS_WIN_CAVERNS("Are there any spiders?", "Win a game on the map Caverns.", Material.MOSSY_COBBLESTONE, FWAchievementSubCategory.CLASSIC_MAP_WIN, FWAchievementReward.TWENTY_CREDITS),
    MAPS_WIN_CLAY("This isn't Black Mesa!", "Win a game on the map Clay.", Material.TERRACOTTA, FWAchievementSubCategory.CLASSIC_MAP_WIN, FWAchievementReward.TWENTY_CREDITS),
    MAPS_WIN_CLAY_NB("What's Black Mesa?", "Win a game on the map Clay (NB).", Material.ORANGE_TERRACOTTA, FWAchievementSubCategory.CLASSIC_MAP_WIN, FWAchievementReward.TWENTY_CREDITS),
    MAPS_WIN_CLIFFS("No Caves, but plenty of Cliffs", "Win a game on the map Cliffs.", Material.STONE, FWAchievementSubCategory.CLASSIC_MAP_WIN, FWAchievementReward.TWENTY_CREDITS),
    MAPS_WIN_COLLIERY("Successful Excavation", "Win a game on the map Colliery.", Material.IRON_ORE, FWAchievementSubCategory.AD_MAP_WIN, FWAchievementReward.TWENTY_CREDITS),
    MAPS_WIN_FROSTNOVA("It's too cold for this!", "Win a game on the map Frostnova.", Material.SNOW_BLOCK, FWAchievementSubCategory.CLASSIC_MAP_WIN, FWAchievementReward.TWENTY_CREDITS),
    MAPS_WIN_GLASS_FOREST("Precious trees", "Win a game on the map Glass Forest.", Material.LIME_STAINED_GLASS, FWAchievementSubCategory.CLASSIC_MAP_WIN, FWAchievementReward.TWENTY_CREDITS),
    MAPS_WIN_GREAT_WALL("This wall ain't gonna stop me!", "Win a game on the map Great Wall.", Material.BRICKS, FWAchievementSubCategory.CLASSIC_MAP_WIN, FWAchievementReward.TWENTY_CREDITS),
    MAPS_WIN_HOTEL_MONSENOR("Underwater Vacation", "Win a game on the map Hotel Monsenor.", Material.DARK_PRISMARINE, FWAchievementSubCategory.KOTH_MAP_WIN, FWAchievementReward.TWENTY_CREDITS),
    MAPS_WIN_ICEFIELDS("What on ice are you doing?", "Win a game on the map Icefields.", Material.ICE, FWAchievementSubCategory.CLASSIC_MAP_WIN, FWAchievementReward.TWENTY_CREDITS),
    MAPS_WIN_ICEFIELDS_NB("Ice breaker!", "Win a game on the map Icefields (NB)", Material.PACKED_ICE, FWAchievementSubCategory.CLASSIC_MAP_WIN, FWAchievementReward.TWENTY_CREDITS),
    MAPS_WIN_ICEFIELDS_AD("Give ‘em hail!", "WIn a game on the map Icefields (AD)", Material.BLUE_ICE, FWAchievementSubCategory.AD_MAP_WIN, FWAchievementReward.TWENTY_CREDITS),
    MAPS_WIN_LEAFY_CANYON("I planted all of this!", "Win a game on the map Leafy Canyon.", Material.GLOW_BERRIES, FWAchievementSubCategory.KOTH_MAP_WIN, FWAchievementReward.TWENTY_CREDITS),
    MAPS_WIN_MOUNTAIN("Over the mountain we go!", "Win a game on the map Mountain.", Material.COAL_BLOCK, FWAchievementSubCategory.CLASSIC_MAP_WIN, FWAchievementReward.TWENTY_CREDITS),
    MAPS_WIN_OASIS_CITY("A mirage miracle!", "Win a game on the map Oasis City.", Material.CHISELED_SANDSTONE, FWAchievementSubCategory.KOTH_MAP_WIN, FWAchievementReward.TWENTY_CREDITS),
    MAPS_WIN_OVERGROWN("Spiders in my head, spiders in my mind!", "Win a game on the map Overgrown.", Material.JUNGLE_LEAVES, FWAchievementSubCategory.AD_MAP_WIN, FWAchievementReward.TWENTY_CREDITS),
    MAPS_WIN_RAVINE("Bit of a skill gap...", "Win a game on the map Ravine.", Material.SPONGE, FWAchievementSubCategory.CLASSIC_MAP_WIN, FWAchievementReward.TWENTY_CREDITS),
    MAPS_WIN_RIVER("Those Mountains have faces!", "Win a game on the map River.", Material.WATER_BUCKET, FWAchievementSubCategory.CLASSIC_MAP_WIN, FWAchievementReward.TWENTY_CREDITS),
    MAPS_WIN_SHIPS("Ahoy, Me Hearties!", "Win a game on the map Ships.", Material.OAK_BOAT, FWAchievementSubCategory.CLASSIC_MAP_WIN, FWAchievementReward.TWENTY_CREDITS),
    MAPS_WIN_SKYLANDS("I didn't fall!", "Win a game on the map Skylands.", Material.GLASS, FWAchievementSubCategory.CLASSIC_MAP_WIN, FWAchievementReward.TWENTY_CREDITS),
    MAPS_WIN_TWO_CASTLES("The Men in the High Castle", "Win a game on the map Two Castles.", Material.STONE_BRICKS, FWAchievementSubCategory.CLASSIC_MAP_WIN, FWAchievementReward.TWENTY_CREDITS),
    MAPS_WIN_UNDERWORLD("Satan didn't eat me!", "Win a game on the map Underworld.", Material.NETHERRACK, FWAchievementSubCategory.CLASSIC_MAP_WIN, FWAchievementReward.TWENTY_CREDITS),
    MAPS_WIN_URBAN("Not a place for rural activities!", "Win a game on the map Urban.", Material.BOOKSHELF, FWAchievementSubCategory.CLASSIC_MAP_WIN, FWAchievementReward.TWENTY_CREDITS),
    MAPS_WIN_VALLEY("Into the valley we go!", "Win a game on the map Valley.", Material.GRASS_BLOCK, FWAchievementSubCategory.CLASSIC_MAP_WIN, FWAchievementReward.TWENTY_CREDITS),
    MAPS_WIN_VALLEY_NB("Valley? What valley?", "Win a game on the map Valley (NB).", Material.MYCELIUM, FWAchievementSubCategory.CLASSIC_MAP_WIN, FWAchievementReward.TWENTY_CREDITS),
    MAPS_WIN_VOID("I have finally found a place where I can be all ALONE!", "Win a game on the map Void.", Material.BARRIER, FWAchievementSubCategory.CLASSIC_MAP_WIN, FWAchievementReward.TWENTY_CREDITS),
    MAPS_WIN_COAST_CLASSIC("Let's shell-ebrate!", "Win a game on the map Coast (Classic).", Material.SAND, FWAchievementSubCategory.CLASSIC_MAP_WIN, FWAchievementReward.TWENTY_CREDITS),
    MAPS_WIN_COAST_KOTH("We're all just coasting.", "Win a game on the map Coast (Koth).", Material.SANDSTONE, FWAchievementSubCategory.KOTH_MAP_WIN, FWAchievementReward.TWENTY_CREDITS),
    MAPS_WIN_VOID_KOTH("It's worse than void", "Win a game on the map Void (Koth).", Material.STRUCTURE_VOID, FWAchievementSubCategory.KOTH_MAP_WIN, FWAchievementReward.TWENTY_CREDITS),
    MAPS_WIN_ASHLANDS_KOTH("A pain in the ash.", "Win a game on the map Ashlands.", Material.BASALT, FWAchievementSubCategory.KOTH_MAP_WIN, FWAchievementReward.TWENTY_CREDITS),
    MAPS_WIN_LAZARUS_KOTH("The Fight for the Fountain of Youth", "Win a game on the map Lazarus.", Material.JUNGLE_WOOD, FWAchievementSubCategory.KOTH_MAP_WIN, FWAchievementReward.TWENTY_CREDITS),
    MAPS_WIN_SOMBER_SWAMPS("A firefly to remember", "Win a game on the map Somber Swamps.", Material.MUD, FWAchievementSubCategory.KOTH_MAP_WIN, FWAchievementReward.TWENTY_CREDITS),
    MAPS_WIN_ISLANDS("Above all else", "Win a game on the map Islands.", Material.EMERALD_BLOCK, FWAchievementSubCategory.CLASSIC_MAP_WIN, FWAchievementReward.TWENTY_CREDITS),
    MAPS_WIN_SPAWN_RUINS("Relic of War", "Win a game on the map Spawn Ruins.", Material.REDSTONE_LAMP, FWAchievementSubCategory.KOTH_MAP_WIN, FWAchievementReward.TWENTY_CREDITS),
    MAPS_WIN_BOOTCAMP_AD("No Pain, No Gain", "Win a game on the map Bootcamp (AD).", Material.COARSE_DIRT, FWAchievementSubCategory.AD_MAP_WIN, FWAchievementReward.TWENTY_CREDITS),
    ;

    private final String name;
    private final String description;
    private final Material icon;
    private final FWAchievementSubCategory subcategory;
    private final FWAchievementReward rewardType;

    private static HashMap<FWAchievementSubCategory, List<FWAchievement>> achievementSubcategoryMap;
    private static HashMap<FWAchievementCategory, List<FWAchievement>> achievementCategoryMap;


    private static void populateAchievementLists() {
        FWAchievement[] achievements = FWAchievement.values();

        achievementSubcategoryMap = new HashMap<>();
        achievementCategoryMap = new HashMap<>();

        for (FWAchievement achievement : achievements) {

            // Populate subcategory list
            FWAchievementSubCategory subcategory = achievement.getSubCategory();
            if (!achievementSubcategoryMap.containsKey(subcategory)) {
                achievementSubcategoryMap.put(subcategory, new ArrayList<>());
            }
            List<FWAchievement> subcategoryAchievementList = achievementSubcategoryMap.get(subcategory);
            subcategoryAchievementList.add(achievement);

            // Populate category list
            FWAchievementCategory category = achievement.getCategory();
            if (!achievementCategoryMap.containsKey(category)) {
                achievementCategoryMap.put(category, new ArrayList<>());
            }
            List<FWAchievement> categoryAchievementList = achievementCategoryMap.get(category);
            categoryAchievementList.add(achievement);
        }

        for (FWAchievementSubCategory subcategory : FWAchievementSubCategory.values()) {
            if (subcategory.getParentCategory() == FWAchievementCategory.GENERAL) continue;
            if (subcategory.getParentCategory() == FWAchievementCategory.STATS) continue;
            if (!achievementSubcategoryMap.containsKey(subcategory)) continue;
            sortAchievements(achievementSubcategoryMap.get(subcategory));
        }

        for (FWAchievementCategory category : FWAchievementCategory.values()) {
            if (category == FWAchievementCategory.GENERAL) continue;
            if (category == FWAchievementCategory.STATS) continue;
            if (!achievementCategoryMap.containsKey(category)) continue;
            sortAchievements(achievementCategoryMap.get(category));
        }
    }

    private static void sortAchievements(List<FWAchievement> list) {
        list.sort(Comparator.comparing(Enum::toString));
    }

    public static List<FWAchievement> getAchievementsInCategory(FWAchievementCategory category) {
        if (achievementCategoryMap == null ||  achievementSubcategoryMap == null) populateAchievementLists();
        return achievementCategoryMap.getOrDefault(category, List.of());
    }

    public static List<FWAchievement> getAchievementsInSubCategory(FWAchievementSubCategory subcategory) {
        if (achievementCategoryMap == null ||  achievementSubcategoryMap == null) populateAchievementLists();
        return achievementSubcategoryMap.getOrDefault(subcategory, List.of());
    }

    FWAchievement(String name, String description, Material icon, FWAchievementSubCategory subcategory, FWAchievementReward rewardType) {
        this.name = name;
        this.description = description;
        this.icon = icon;
        this.subcategory = subcategory;
        this.rewardType = rewardType;
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

    public FWAchievementCategory getCategory() {
        return subcategory.getParentCategory();
    }

    public FWAchievementSubCategory getSubCategory() {
        return subcategory;
    }

    public FWAchievementReward getRewardType() {
        return rewardType;
    }
}
