package net.fortresswars.core.games.states;

public enum FWGameState {
    // Lobby
    LOBBY(FWGameStateType.LOBBY),
    MAP_VOTING(FWGameStateType.LOBBY),
    GAMERULE_VOTING(FWGameStateType.LOBBY),
    GAME_STARTING(FWGameStateType.LOBBY),

    // Classic
    CLASSIC_PREPARE_GAME(FWGameStateType.START),
    CLASSIC_BUILDING(FWGameStateType.BUILDING),
    CLASSIC_IN_GAME(FWGameStateType.IN_GAME),
    CLASSIC_SUDDEN_DEATH(FWGameStateType.IN_GAME),

    // KOTH
    KOTH_PREPARE_GAME(FWGameStateType.START),
    KOTH_IN_PRE_GAME(FWGameStateType.IN_GAME),
    KOTH_IN_GAME(FWGameStateType.IN_GAME),
    KOTH_OVERTIME(FWGameStateType.IN_GAME),

    // AD
    AD_PREPARE_GAME(FWGameStateType.START),
    AD_BUILDING(FWGameStateType.BUILDING),
    AD_PRE_ROUND_1(FWGameStateType.IN_GAME),
    AD_ROUND_1(FWGameStateType.IN_GAME),
    AD_BETWEEN_ROUNDS(FWGameStateType.IN_GAME),
    AD_PRE_ROUND_2(FWGameStateType.IN_GAME),
    AD_ROUND_2(FWGameStateType.IN_GAME),

    // Game End
    GAME_END(FWGameStateType.END),
    RESET(FWGameStateType.END),
    ERROR(FWGameStateType.END);

    private final FWGameStateType type;

    FWGameState(FWGameStateType type) {
        this.type = type;
    }

    public FWGameStateType getType() {
        return type;
    }
}
