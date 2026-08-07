package net.fortresswars.core.games.states;

public enum FWGameState {
    // Lobby
    LOBBY,
    MAP_VOTING,
    GAMERULE_VOTING,
    GAME_STARTING,

    // Classic
    CLASSIC_PREPARE_GAME,
    CLASSIC_BUILDING,
    CLASSIC_IN_GAME,
    CLASSIC_SUDDEN_DEATH,

    // KOTH
    KOTH_PREPARE_GAME,
    KOTH_IN_PRE_GAME,
    KOTH_IN_GAME,
    KOTH_OVERTIME,

    // AD
    AD_PREPARE_GAME,
    AD_BUILDING,
    AD_PRE_ROUND_1,
    AD_ROUND_1,
    AD_BETWEEN_ROUNDS,
    AD_PRE_ROUND_2,
    AD_ROUND_2,

    // Game End
    GAME_END,
    RESET,
    ERROR,
}
