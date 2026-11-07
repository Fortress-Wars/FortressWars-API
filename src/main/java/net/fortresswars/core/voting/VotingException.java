package net.fortresswars.core.voting;

public class VotingException extends RuntimeException {

    public VotingException() {
        super();
    }

    public VotingException(String msg) {
        super(msg);
    }

    public VotingException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
