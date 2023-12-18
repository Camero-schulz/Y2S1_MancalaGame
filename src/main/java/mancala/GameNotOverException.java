package mancala;

public class GameNotOverException extends Exception implements java.io.Serializable {

    public static final long serialVersionUID = 444444444L;

    public GameNotOverException() {
        super("Game is not over");
    }

    public GameNotOverException(final String message) {
        super(message);
    }
}