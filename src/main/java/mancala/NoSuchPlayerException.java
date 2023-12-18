package mancala;

public class NoSuchPlayerException extends Exception implements java.io.Serializable {

    public static final long serialVersionUID = 222222222L;

    public NoSuchPlayerException() {
        super("Player not found");
    }

    public NoSuchPlayerException(final String message) {
        super(message);
    }
}