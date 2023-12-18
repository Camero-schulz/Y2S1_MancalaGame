package mancala;  
//package mancala;
/*
import mancala.MancalaGame;
import mancala.Player;
import mancala.Saver;
import mancala.KalahRules;
import mancala.GameRules;

import mancala.NoSuchPlayerException;
import mancala.PitNotFoundException;
import mancala.InvalidMoveException;
*/
import java.util.Scanner;

public class TestUI {
    private MancalaGame mancalaGame;
    private Scanner scanner;
    private Player playerOne;
    private Player playerTwo;

    public TestUI() {
        mancalaGame = new MancalaGame();
        scanner = new Scanner(System.in);
        playerOne = new Player("one");
        playerTwo = new Player("two");
    }

    public void startGame() {
        System.out.println("Welcome to Mancala Game!");

        mancalaGame.setBoard(new KalahRules());
        mancalaGame.setPlayers(playerOne, playerTwo);
        mancalaGame.setCurrentPlayer(playerOne);
        mancalaGame.getBoard().registerPlayers(playerOne, playerTwo);
        //mancalaGame.getBoard().setPlayer(1);

        //mancalaGame.startNewGame();

        playGame();

    }

    private void displayBoard() {
        //Player playerOne = mancalaGame.getPlayers().get(0);
        //Player playerTwo = mancalaGame.getPlayers().get(1);
        try {
            System.out.println("[" + mancalaGame.getStoreCount(playerOne) + "] " +
                            "[" + mancalaGame.getNumStones(6) + "] " +
                            "[" + mancalaGame.getNumStones(5) + "] " +
                            "[" + mancalaGame.getNumStones(4) + "] " +
                            "[" + mancalaGame.getNumStones(3) + "] " +
                            "[" + mancalaGame.getNumStones(2) + "] " +
                            "[" + mancalaGame.getNumStones(1) + "] " +
                            "[" + mancalaGame.getStoreCount(playerTwo) + "]");

            System.out.print("    ");
        }catch (NoSuchPlayerException err) {
            System.out.println(err);
        } catch (PitNotFoundException err) {
            System.out.println(err);
        }
        for (int i = 7; i <= 12; i++) {
            System.out.print("[" + mancalaGame.getBoard().getNumStones(i) + "] ");
        }
        System.out.println();
    }

    private void playGame() {

        int stonesLeft = -1;
        while (!mancalaGame.isGameOver()) {
            //System.out.println(mancalaGame.toString());

            while (true) {

                Player currentPlayer = mancalaGame.getCurrentPlayer();
                System.out.println("\nCurrent Player: " + currentPlayer.getName());
                displayBoard();

                System.out.print("Enter pit number to move stones: ");
                int startPit = scanner.nextInt();

                try {
                    stonesLeft = mancalaGame.move(startPit);
                } catch (InvalidMoveException e) {
                    System.out.println("Invalid Move! Please try again.");
                } 
            }
        }
    } 

    public static void main(String[] args) {
        TestUI testUI = new TestUI();
        testUI.startGame();
    }

} 