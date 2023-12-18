/*package mancala;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.ArrayList;
import java.util.List;

public class BoardTest {
    private Board board;
    private Player playerOne;
    private Player playerTwo;

    @BeforeEach
    public void setup() {
        board = new Board();
        playerOne = new Player("one");
        playerTwo = new Player("two");
        board.registerPlayers(playerOne, playerTwo);
    }

    @Test
    @DisplayName("test captureStones")
    public void testCaptureStones() {
        board.setCurrentPlayer(playerOne);

        try {
            // gets total stones in store prior (0)
            int storeBefore = board.getCurrentPlayer().getStore().getTotalStones(); 
            // captures stones, put in store (4)    
            int result = board.captureStones(5);    
            // gets total stones in store after (4)                                   
            int storeAfter = board.getCurrentPlayer().getStore().getTotalStones();      

            Assertions.assertEquals(storeBefore + storeAfter, result);  // determines if stones gets added to store 
            Assertions.assertEquals(0, board.getNumStones(5));          // determines if pit gets removed

        } catch (PitNotFoundException err) {

        } 
    }

    @Test
    @DisplayName("test getNumStones")
    public void testGetNumStones() {
        try {

            int result = board.getNumStones(5);

            List<Pit> pits = board.getPits();
            Pit pit = pits.get(5);
            pit.removeStones();
            int resultEmpty = board.getNumStones(5);

            Assertions.assertEquals(4, result);
            Assertions.assertEquals(0, resultEmpty);

        } catch (PitNotFoundException err) {

        }
    }

    @Test
    @DisplayName("test distribute stones")
    public void testDistributeStones() {
        board.setCurrentPlayer(playerOne);

        try {
            int beforePit = board.getNumStones(6);
            int beforeStore = board.getCurrentPlayer().getStore().getTotalStones();

            int result = board.distributeStones(6);

            int afterPit = board.getNumStones(6);
            int afterStore = board.getCurrentPlayer().getStore().getTotalStones();

            Assertions.assertEquals(2, result); // checks if result returns correct value
            Assertions.assertEquals(beforeStore + afterStore, 1); // checks if store returns correct
            Assertions.assertEquals(afterPit - beforePit, 1); // checks if pit returns correct
            
        } catch (PitNotFoundException err) {

        }
    }

    @Test
    @DisplayName("test if side empty")
    public void testIsSideEmpty() {
        board.setCurrentPlayer(playerOne);
        try {

            boolean resultFull = board.isSideEmpty(3);
            board.getPits().forEach(pit -> pit.removeStones()); // Clearing all stones from the pits
            boolean resultEmpty = board.isSideEmpty(3);

            Assertions.assertFalse(resultFull);
            Assertions.assertTrue(resultEmpty);

        } catch (PitNotFoundException err) {

        }
    }

    @Test
    @DisplayName("test resetBoard")
    public void testResetBoard() {

        try {
            // Remove stones from all pits
            for (Pit pit : board.getPits()) {
                pit.removeStones();
            }
            board.resetBoard(); //resets board

            for (int i = 0; i < 12; i++) {
                Assertions.assertEquals(4, board.getNumStones(i));
            }
        } catch (PitNotFoundException err) {
            
        }
    }

    @Test
    @DisplayName("test register players")
    public void testRegisterPlayers() {
        Store store = new Store();
        board.registerPlayers(playerOne, playerTwo);

        // use method I made to get each player's respective Store
        Store boardStoreOne = board.getPlayerStore(playerOne);
        Store boardStoreTwo = board.getPlayerStore(playerTwo);

        // get respective owner's name which was done in registerPlayers()
        Assertions.assertEquals(playerOne, boardStoreOne.getOwner());
        Assertions.assertEquals(playerTwo, boardStoreTwo.getOwner());
    }


}*/