package net.fortresswars.core.kits.abilities;

public enum AbilityID {

    NAME_TAG("Name Tag", AbilityType.DISPLAY),
    HEALING_POTIONS("Healing Potions", AbilityType.ACTIVE),
    MANA_POTIONS("Mana Potions", AbilityType.ACTIVE),
    SHIELD("Shield", AbilityType.ACTIVE),
    HELMET("Helmet", AbilityType.ARMOR),
    CHESTPLATE("Chestplate", AbilityType.ARMOR),
    LEGGINGS("Leggings", AbilityType.ARMOR),
    BOOTS("Boots", AbilityType.ARMOR),

    // Aquaman
    AQUAMAN_WATER_SPHERE("Water Sphere", AbilityType.ACTIVE),
    AQUAMAN_TRIDENT("Trident", AbilityType.ACTIVE),
    AQUAMAN_ONE_WITH_THE_SEA("One with the Sea", AbilityType.PASSIVE),

    // Aquarius
    AQUARIUS_SWORD("Aquarius Sword", AbilityType.ACTIVE),
    AQUARIUS_WAND("Aquarius Wand", AbilityType.ACTIVE),
    AQUARIUS_SOOTHING_WATER("Soothing Water", AbilityType.PASSIVE),

    // Archmage
    ARCHMAGE_SWORD("Archmage Sword", AbilityType.ACTIVE),

    // Bomber
    BOMBER_SWORD("Bomber Sword", AbilityType.ACTIVE),
    BOMBER_BOMBS("Bombs", AbilityType.ACTIVE),
    BOMBER_DETONATE_BOMBS("Detonate", AbilityType.ACTIVE),

    // Brute
    BRUTE_AXE("Axe", AbilityType.ACTIVE),
    BRUTE_BERSERK("Berserk", AbilityType.PASSIVE),

    // Buff Master
    BUFF_MASTER_SWORD("Buff Master Sword", AbilityType.ACTIVE),
    BUFF_MASTER_USE_BUFF("Use Buff", AbilityType.ACTIVE),
    BUFF_MASTER_SWITCH_BUFF("Switch Buff", AbilityType.ACTIVE),

    // Builder
    BUILDER_BRICKS("Builder Bricks", AbilityType.ACTIVE),
    BUILDER_LADDERS("Builder Ladders", AbilityType.ACTIVE),

    // Crusader
    CRUSADER_SWORD("Crusader Sword", AbilityType.ACTIVE),
    CRUSADER_SHIELD_BASH("Shield Bash", AbilityType.ACTIVE),
    CRUSADER_IRONCLAD("Ironclad", AbilityType.PASSIVE),

    // Crusher
    CRUSHER_SWORD("Crusher Sword", AbilityType.ACTIVE),
    CRUSHER_CRUSH("Crush", AbilityType.ACTIVE),

    // Default
    DEFAULT_SWORD("Default Sword", AbilityType.ACTIVE),
    DEFAULT_BOW("Default Bow", AbilityType.ACTIVE),

    // Demolitionist
    DEMOLITIONIST_SWORD("Demolitionist Sword", AbilityType.ACTIVE),
    DEMOLITIONIST_DEMOLISH("Demolish", AbilityType.ACTIVE),
    DEMOLITIONIST_BOMB_RECYCLING("Bomb Recycling", AbilityType.PASSIVE),

    // Demon
    DEMON_SWORD("Demon Sword", AbilityType.ACTIVE),
    DEMON_BLOOD_STAFF("Blood Staff", AbilityType.ACTIVE),
    DEMON_BLOOD_BOND("Blood Bond", AbilityType.ACTIVE),
    DEMON_HELLFIRE("Hellfire", AbilityType.PASSIVE),
    DEMON_TRANSFUSION("Transfusion", AbilityType.ACTIVE),
    DEMONS_CURSE("Demon's Curse", AbilityType.PASSIVE),
    BLOOD("Blood", AbilityType.RESOURCE),
    BLOOD_POTIONS("Blood Potions", AbilityType.ACTIVE),

    // Engineer
    ENGINEER_WRENCH("Wrench", AbilityType.ACTIVE),
    ENGINEER_SENTRY("Sentry", AbilityType.ACTIVE),
    ENGINEER_DISPENSER("Dispenser", AbilityType.ACTIVE),
    ENGINEER_ENTRANCE_TELEPORTER("Entrance Teleporter", AbilityType.ACTIVE),
    ENGINEER_EXIT_TELEPORTER("Exit Teleporter", AbilityType.ACTIVE),
    ENGINEER_METAL_SATCHEL("Metal Satchel", AbilityType.PASSIVE),
    ENGINEER_METAL_SCRAPPER("Metal Scrapper", AbilityType.PASSIVE),

    // Fish
    FISH("Fish", AbilityType.ACTIVE),
    FISH_BOW("Fish Bow", AbilityType.ACTIVE),
    FISH_SUFFOCATE("OP Fish", AbilityType.PASSIVE),
    FISH_TRAIL("Fish Trail", AbilityType.PASSIVE),
    FISH_TANK("Fish Tank", AbilityType.RESOURCE),
    WATER_SYNERGY("Water Synergy", AbilityType.PASSIVE),

    // Glacier
    GLACIER_SWORD("Glacier Sword", AbilityType.ACTIVE),
    GLACIER_ICE_BALL("Ice Ball", AbilityType.ACTIVE),
    GLACIER_SNOWDRIFT("Snowdrift", AbilityType.PASSIVE),

    // Golem
    GOLEM_SWORD("Golem Sword", AbilityType.ACTIVE),
    GOLEM_WAND("Golem Wand", AbilityType.ACTIVE),

    // Gunner
    GUNNER_SWORD("Gunner Sword", AbilityType.ACTIVE),
    GUNNER_MACHINE_GUN("Machine Gun", AbilityType.ACTIVE),

    // Grappler
    GRAPPLER_SWORD("Grappler Sword", AbilityType.ACTIVE),
    GRAPPLER_GRAPPLE("Grapple", AbilityType.ACTIVE),
    FEATHER_FALLING("Feather Falling", AbilityType.PASSIVE),

    // Hitman
    HITMAN_SWORD("Hitman Sword", AbilityType.ACTIVE),
    HITMAN_BOW("Hitman Bow", AbilityType.ACTIVE),
    HITMAN_ARROWS("Hitman Arrow", AbilityType.ACTIVE),
    HITMAN_ROTATE_EFFECT("Hitman Rotate Effect", AbilityType.ACTIVE),

    // Hulk
    HULK_BOW_SWORD("Hulk Bow and Sword", AbilityType.ACTIVE),
    HULK_ACTIVATION("Hulk Activation", AbilityType.ACTIVE),
    HULK_RAGE_FORM("Hulk Rage Form", AbilityType.PASSIVE),

    // Illusionist
    ILLUSIONIST_SWORD("Illusionist Sword", AbilityType.ACTIVE),
    ILLUSIONIST_DIVINATION_STAR("Divination Star", AbilityType.ACTIVE),
    ILLUSIONIST_FUTURE_SIGHT("Future Sight", AbilityType.PASSIVE),

    // Jumper
    JUMPER_SWORD("Jumper Sword", AbilityType.ACTIVE),
    JUMPER_TRANSLOCATOR_ABILITY("Translocator", AbilityType.ACTIVE),

    // Kangaroo
    KANGAROO_SWORD("Kangaroo Sword", AbilityType.ACTIVE),
    KANGAROO_STOMP("Stomp", AbilityType.ACTIVE),
    KANGAROO_STRONG_LEGS("Strong Legs", AbilityType.PASSIVE),

    // Knight
    KNIGHT_SWORD("Knight Sword", AbilityType.ACTIVE),
    KNIGHT_FORTIFY("Fortify", AbilityType.ACTIVE),

    // Master
    MASTER_SWORD("Master Sword", AbilityType.ACTIVE),
    MASTER_MINION("Master Minion", AbilityType.ACTIVE),

    // Mathematician
    MATHEMATICIAN_SWORD("Mathematician Sword", AbilityType.ACTIVE),
    MATHEMATICIAN_WORKSHEET("Mathematician Worksheet", AbilityType.ACTIVE),

    // Medic
    MEDIC_SWORD("Medic Sword", AbilityType.ACTIVE),
    MEDIC_HEALING_STONE("Healing Stone", AbilityType.ACTIVE),
    MEDIC_ELECTROLYTES("Electrolytes", AbilityType.RESOURCE),

    // Mercy
    MERCY_STAFF("Mercy Staff", AbilityType.ACTIVE),
    MERCY_SWITCH_EFFECT("Mercy Switch Effect", AbilityType.ACTIVE),

    // Miner
    MINER_MINERS_FERVOR("Miner's Fervor", AbilityType.ACTIVE),
    MINER_PAXEL("Miner's Paxel", AbilityType.ACTIVE),
    MINER_GOBBLESTONE_BAG("Gobblestone Bag", AbilityType.ACTIVE),
    MINER_GOBBLESTONE("Gobblestone", AbilityType.RESOURCE),
    MINER_GOBBLESTONE_PROGRESS("Gobblestone PRogress", AbilityType.RESOURCE),

    // Musketeer
    MUSKETEER_SWORD("Musketeer Sword", AbilityType.ACTIVE),
    MUSKETEER_RIFLE("Musketeer Rifle", AbilityType.ACTIVE),
    MUSKETEER_SWITCH_RIFLE_MODE("Musketeer Switch Rifle Mode", AbilityType.ACTIVE),

    // Necromancer
    NECROMANCER_SWORD("Necromancer Sword", AbilityType.ACTIVE),
    NECROMANCER_WITHER_SKELETON("Necromancer Skeleton", AbilityType.ACTIVE),

    // Ninja
    NINJA_KATANA("Ninja Katana", AbilityType.ACTIVE),
    NINJA_KI("Ki", AbilityType.RESOURCE),
    NINJA_DODGE("Ninja Dodge", AbilityType.ACTIVE),
    NINJA_KI_FOCUS("Ninja Ki Focus", AbilityType.PASSIVE),
    NINJA_AGILITY("Ninja Agility", AbilityType.PASSIVE),

    // None
    NONE_SWORD("None Sword", AbilityType.ACTIVE),
    NONE_BOW("None Bow", AbilityType.ACTIVE),

    // Porcupine
    PORCUPINE_SWORD("Porcupine Sword", AbilityType.ACTIVE),
    PORCUPINE_QUILLS("Porcupine Quill", AbilityType.ACTIVE),

    // Potion Master
    POTION_MASTER_SWORD("Potion Master Sword", AbilityType.ACTIVE),
    POTION_MASTER_THROWABLE_POTION("Potion Master Throwable Potion", AbilityType.ACTIVE),

    // Priest
    PRIEST_SWORD("Priest Sword", AbilityType.ACTIVE),
    PRIEST_WAND("Priest Wand", AbilityType.ACTIVE),
    PRIEST_GRACE("Grace", AbilityType.RESOURCE),
    PRIEST_SOOTHING_LIGHT("Soothing Light", AbilityType.PASSIVE),

    // Prometheus
    PROMETHEUS_SWORD("Prometheus Sword", AbilityType.ACTIVE),
    PROMETHEUS_WAND("Prometheus Wand", AbilityType.ACTIVE),

    // Pyrotechnic
    PYROTECHNIC_SWORD("Pyrotechnic Sword", AbilityType.ACTIVE),
    PYROTECHNIC_ROCKET_LAUNCHER("Pyrotechnic Rocket Launcher", AbilityType.ACTIVE),
    PYROTECHNIC_BARRAGE("Pyrotechnic Barrage", AbilityType.ACTIVE),

    // Raven
    RAVEN_SWORD("Raven Sword", AbilityType.ACTIVE),
    RAVEN_WAND("Raven Wand", AbilityType.ACTIVE),

    // Slime
    SLIME_SWORD("Slime Sword", AbilityType.ACTIVE),
    SLIME_ARMOR("Slime Armor", AbilityType.ACTIVE),
    SLIME_MINION("Slime Minion", AbilityType.ACTIVE),

    // Sniper
    SNIPER_SWORD("Sniper Sword", AbilityType.ACTIVE),
    SNIPER_ARROWS("Sniper Arrows", AbilityType.RESOURCE),
    SNIPER_INFINITY_BOW("Sniper Infinity Bow", AbilityType.ACTIVE),
    SNIPER_POWER_BOW("Sniper Power Bow", AbilityType.ACTIVE),

    SNOW_GOLEM_ICICLE_STAFF("Icicle Staff", AbilityType.ACTIVE),
    SNOW_GOLEM_MINION("Snow Golem Minion", AbilityType.ACTIVE),
    SNOW_TRAIL_SUPPORT("Snow Trail Support", AbilityType.PASSIVE),

    // Snowman
    SNOWMAN_SWORD("Snowman Sword", AbilityType.ACTIVE),
    SNOWMAN_SHIELD("Snowman Shield", AbilityType.ACTIVE),
    SNOWMAN_WAND("Snowman Wand", AbilityType.ACTIVE),

    // Soldier
    SOLDIER_SWORD("Soldier Sword", AbilityType.ACTIVE),
    SOLDIER_GRENADE("Grenade", AbilityType.ACTIVE),

    // Sonic
    SONIC_SWORD("Sonic Sword", AbilityType.ACTIVE),
    SONIC_SPEED("Sonic Speed", AbilityType.ACTIVE),

    // Spider
    SPIDER_SWORD("Spider Sword", AbilityType.ACTIVE),
    SPIDER_COBWEB_TRAP("Spider Cobweb Trap", AbilityType.ACTIVE),
    SPIDER_WEAVING("Weaving", AbilityType.PASSIVE),

    // Spy
    SPY_SWORD("Spy Sword", AbilityType.ACTIVE),
    SPY_SNEAK_ATTACK_SWORD("Spy Sneak Attack Sword", AbilityType.ACTIVE),
    SPY_ELECTRO_SAPPER("Spy Electro Sapper", AbilityType.PASSIVE),

    // Vitalist
    VITALIST_SWORD("Vitalist Sword", AbilityType.ACTIVE),
    VITALIST_CROSSBOW("Vitalist Crossbow", AbilityType.ACTIVE),

    WIZARD_SWORD("Wizard Sword", AbilityType.ACTIVE),
    WIZARD_WAND("Wizard Wand", AbilityType.ACTIVE),

    // Misc
    MANA("Mana", AbilityType.RESOURCE),
    AMMO("Ammo", AbilityType.RESOURCE),
    ESSENCE_OF_THE_AFTER_LIFE("Essence of the Afterlife", AbilityType.RESOURCE),
    THORNS("Throws", AbilityType.PASSIVE),
    BEACON_BREAKER("Beacon Breaker", AbilityType.PASSIVE),
    POISON_IMMUNITY("Poison Immunity", AbilityType.PASSIVE),
    CLOAK("Cloak", AbilityType.ACTIVE);

    private final String name;
    private final AbilityType type;

    AbilityID(String name, AbilityType type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public AbilityType getType() {
        return type;
    }
}
