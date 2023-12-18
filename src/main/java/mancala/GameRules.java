package mancala;

/**
 * Abstract class representing the rules of a Mancala game.
 * KalahRules and AyoRules will subclass this class.
 */
public abstract class GameRules {
    private MancalaDataStructure gameBoard;
    private int currentPlayer = 1; // Player number (1 or 2)

    /**
     * Constructor to initialize the game board.
     */
    public GameRules() {
        gameBoard = new MancalaDataStructure();
    }

    /**
     * Get the number of stones in a pit.
     *
     * @param pitNum The number of the pit.
     * @return The number of stones in the pit.
     */
    public int getNumStones(int pitNum) {
        return gameBoard.getNumStones(pitNum);
    }

    /**
     * Get the game data structure.
     *
     * @return The MancalaDataStructure.
     */
    MancalaDataStructure getDataStructure() {
        return gameBoard;
    }

    /**
     * Check if a side (player's pits) is empty.
     *
     * @param pitNum The number of a pit in the side.
     * @return True if the side is empty, false otherwise.
     */

    public int swapPlayer(final int pitNum) {
        // swaps player
        if (pitNum <= 6) {
            return 2;
        }
        return 1;
    }   

    public void clearBoard(final int player) {

        int num;
        // adds remaining pits to player's store
        for (int i = 1; i <= 12; i++) {
            num = gameBoard.removeStones(i);
            if (player != 0) {
                gameBoard.addToStore(player, num);
            }
            else {
                gameBoard.addToStore(1, -(gameBoard.getStoreCount(1)));
                gameBoard.addToStore(2, -(gameBoard.getStoreCount(2)));
            }
        }
    }

    boolean isSideEmpty(int pitNum) {
        // This method can be implemented in the abstract class.

        int startPit = 0;

        if (pitNum <= 6) {
            startPit = 1;
        } else if (pitNum >= 7) {
            startPit = 7;
        } 

        for (int i = 0; i < 6; i++) {
            if (getNumStones(startPit + i) > 0) {
                return false;
            }
        }

        // clears the board -- adds remaining stones to other player's store
        clearBoard(swapPlayer(startPit));

        return true;
    }

    /**
     * Set the current player.
     *
     * @param playerNum The player number (1 or 2).
     */
    public void setPlayer(int playerNum) {
        currentPlayer = playerNum;
    }

    // ADDED THIS
    /** 
    * Return current player
    *
    * @return current player
    */
    public int getPlayer() {
        return currentPlayer;
    }

    /**
     * Perform a move and return the number of stones added to the player's store.
     *
     * @param startPit  The starting pit for the move.
     * @param playerNum The player making the move.
     * @return The number of stones added to the player's store.
     * @throws InvalidMoveException If the move is invalid.
     */
    public abstract int moveStones(int startPit, int playerNum) throws InvalidMoveException;

    /**
     * Distribute stones from a pit and return the number distributed.
     *
     * @param startPit The starting pit for distribution.
     * @return The number of stones distributed.
     */
    abstract int distributeStones(int startPit);

    /**
     * Capture stones from the opponent's pit and return the number captured.
     *
     * @param stoppingPoint The stopping point for capturing stones.
     * @return The number of stones captured.
     */
    abstract int captureStones(int stoppingPoint);

    /**
     * Register two players and set their stores on the board.
     *
     * @param one The first player.
     * @param two The second player.
     */
    public void registerPlayers(Player one, Player two) {
        // this method can be implemented in the abstract class.
        Store storeOne = new Store();       // creates new stores
        Store storeTwo = new Store();
        storeOne.setOwner(one);             // sets owners of stores
        storeTwo.setOwner(two);
        one.setStore(storeOne);             // sets stores to appropriate players
        two.setStore(storeTwo);
        gameBoard.setStore(storeOne, 1);    // set stores in list of pits and stores
        gameBoard.setStore(storeTwo, 2);

        /* make a new store in this method, set the owner
         then use the setStore(store,playerNum) method of the data structure*/
    }

    /**
     * Reset the game board by setting up pits and emptying stores.
     */
    public void resetBoard() {
        clearBoard(0);
        gameBoard.setUpPits();
        //gameBoard.emptyStores();
    }

    @Override
    public String toString() {
        // Implement toString() method logic here.
        // String representation of the board
        return "Mancala Board"; // Placeholder
    }
}
