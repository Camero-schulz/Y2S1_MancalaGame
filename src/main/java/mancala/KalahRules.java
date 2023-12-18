package mancala;

public class KalahRules extends GameRules {   

    private static final int MAX_PITS = 13;
    private static final int PIT_EMPTY = 1;
    private MancalaDataStructure gameBoard;
    private Countable obj;
    //private GameRules gameRules;
    //private int currentPlayer;

    public KalahRules() {
        gameBoard = getDataStructure();
    }

    // helper method
    private int nextIndex(int currPit, int playerNum) {
        currPit++;

        if (currPit == 13 && playerNum == 1) {
            currPit = 1;
        }

        if (currPit > MAX_PITS) { 
            currPit = 1;
        }
        return currPit;
    }

    //final private int setPlayer() 

    @Override
    public int moveStones(final int startPit, final int playerNum) throws InvalidMoveException {

        int storeCount = 0;
        final int begStore = gameBoard.getStoreCount(playerNum);      // retrieves the total stones in a player's store

        /* determines if there was anything in the starter pit -- if not, throw exception */
        final int numStones = gameBoard.removeStones(startPit);        // remove stones out of pit
        if (numStones == 0){ 
            throw new InvalidMoveException("Cannot play pit -- no stones in pit");
        }

        int currPit = startPit;     // reassign value so parameter value is not changed
        gameBoard.setIterator(currPit, playerNum, false);
        
        int stonesDistributed = 0;
        while (numStones > stonesDistributed) {

            /* loops until the total stones distributed is greater
            than the number of stones in the starting pit */
            
            obj = gameBoard.next();         // accesses next pit object 
            if (!(obj instanceof Store && currPit == 6)) {
                currPit = nextIndex(currPit, playerNum);   // accesses next index 
            }
            
            stonesDistributed += distributeStones(currPit);

            /* adds to storeCount for every store value passed */
            if (currPit == 6 || currPit == 13) {
                storeCount += 1;
            }
        }

        /* if pit ended on a store -- user gets another turn */
        if (obj instanceof Store) {   
            return -1;  // -1 specifies additional turn
        }

        // if last pit landed on was empty and if pit is on player's side
        if (getNumStones(currPit) == PIT_EMPTY && obj instanceof Pit) {
            if (playerNum == 1 && currPit <= 5 || playerNum == 2 && currPit >= 6) {

                /* finds distance between last pit and 
                current pit -- captures enemy stones */

                final int capturedStones = captureStones(12 - currPit);
                gameBoard.addToStore(playerNum, capturedStones);
                storeCount += capturedStones;
                
            }
        }

        return storeCount;  // returns # of stones added to player's store
    }

    @Override
    int distributeStones(int startingPoint) {
        /* Distribute stones in respected pit or store */
/*
        if (startingPoint > 7) {
            startingPoint = startingPoint - 1;
        } */

        if (obj instanceof Pit) {
            gameBoard.addStones(startingPoint, 1);
        } else if (obj instanceof Store) {
            gameBoard.addToStore(getPlayer(), 1);
        } else {
            return 0;
        }

        return 1;
    }

    @Override
    int captureStones(int stoppingPoint) {
        // Capture stones from opponent's pits

        final int capturedStones = gameBoard.removeStones(stoppingPoint);
        return capturedStones;   // returns the captured stones
    }
} 