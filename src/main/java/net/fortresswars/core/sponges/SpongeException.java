package net.fortresswars.core.sponges;

public class SpongeException extends RuntimeException {
    public SpongeException() {
        super();
    }

    public SpongeException(String msg) {
        super(msg);
    }

    public SpongeException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
