package mancala;

import java.util.ArrayList;

public class Board {
    private ArrayList<Pit> pits;
    private ArrayList<Store> stores;
    private Player playerOne;
    private Player playerTwo;

    public Board() {
        pits = new ArrayList<>();
        stores = new ArrayList<>();
        setUpPits();
        setUpStores();
    }

    public void setUpPits() {
        for (int i = 0; i < 12; i++) {
            pits.add(new Pit());
        }
    }

    public ArrayList<Pit> getPits() {
        return pits;
    }

    public ArrayList<Store> getStores() {
        return stores;
    }

    public void setUpStores() {
        stores.add(new Store());
        stores.add(new Store());
    }

    public void initializeBoard() {
        pits.clear(); // Clear existing pits if any
        for (int i = 0; i < 12; i++) {
            pits.add(new Pit()); // Create and add a new Pit object (initialized with default stone count) to the pits ArrayList
        }
    }

    public void resetBoard() {
        // Redistribute stones but retain players
        initializeBoard(); // For simplicity, resetting board is the same as initialization
    }

    public void registerPlayers(Player one, Player two) {
        this.playerOne = one;
        this.playerTwo = two;
        one.setStore(stores.get(0));
        two.setStore(stores.get(1));
        stores.get(0).setOwner(one);
        stores.get(1).setOwner(two);
    }

    public int moveStones(int startPit, Player player) throws InvalidMoveException {
        // Move stones according to game rules
        return 0; // Placeholder
    }

    public int distributeStones(int startingPoint) throws PitNotFoundException {
        // Distribute stones in pits and stores
        return 0; // Placeholder
    }

    public int captureStones(int stoppingPoint) throws PitNotFoundException {
        // Capture stones from opponent's pits
        return 0; // Placeholder
    }

    public int getNumStones(int pitNum) throws PitNotFoundException {
        // Get number of stones in a specific pit
        return 0; // Placeholder
    }

    public boolean isSideEmpty(int pitNum) throws PitNotFoundException {
        // Check if one side of the board is empty
        return false; // Placeholder
    }

    @Override
    public String toString() {
        // String representation of the board
        return "Mancala Board"; // Placeholder
    }
}
