package mancala;

public class PitNotFoundException extends Exception implements java.io.Serializable {

    public static final long serialVersionUID = 111111111L;

    public PitNotFoundException() {
        super("Pit not found");
    }

    public PitNotFoundException(final String message) {
        super(message);
    }
}