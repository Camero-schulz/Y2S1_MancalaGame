package mancala;

public class InvalidMoveException extends Exception implements java.io.Serializable {

    public static final long serialVersionUID = 333333333L;

    public InvalidMoveException() {
        super("Move not found");
    }

    public InvalidMoveException(final String message) {
        super(message);
    }
}