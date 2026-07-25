package net.fortresswars.core.teams;

public class TeamException extends RuntimeException {

    public TeamException() {
        super();
    }

    public TeamException(String msg) {
        super(msg);
    }

    public TeamException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
