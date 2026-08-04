package net.fortresswars.core.gamerules;

public class GameruleException extends RuntimeException {

    public GameruleException() {
        super();
    }

    public GameruleException(String msg) {
        super(msg);
    }

    public GameruleException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
