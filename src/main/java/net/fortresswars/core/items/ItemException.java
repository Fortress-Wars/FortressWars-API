package net.fortresswars.core.items;

public class ItemException extends RuntimeException {

    public ItemException() {
        super();
    }

    public ItemException(String msg) {
        super(msg);
    }

    public ItemException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
