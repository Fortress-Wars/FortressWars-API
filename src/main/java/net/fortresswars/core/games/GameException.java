package net.fortresswars.core.games;

public class GameException extends RuntimeException {
    public GameException() {
        super();
    }

    public GameException(String msg) {
        super(msg);
    }

    public GameException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
