package net.fortresswars.ui;

public class MenuException extends RuntimeException {

    public MenuException() {
        super();
    }

    public MenuException(String msg) {
        super(msg);
    }

    public MenuException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
