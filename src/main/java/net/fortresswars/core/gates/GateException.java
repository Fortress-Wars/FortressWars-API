package net.fortresswars.core.gates;

public class GateException extends RuntimeException {
    public GateException() {
        super();
    }

    public GateException(String msg) {
        super(msg);
    }

    public GateException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
