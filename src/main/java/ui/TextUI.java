/*package mancala;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.io.FileNotFoundException;

public class TextUI {
    private MancalaGame mancalaGame;
    private Scanner scanner;
    private GameRules board;
  //  private Saver saver;

    public TextUI() {
        mancalaGame = new MancalaGame();
        scanner = new Scanner(System.in);
        board = mancalaGame.getBoard();
   //     saver = new Saver();
    }

    public void startGame() {
        System.out.println("Welcome to Mancala Game!");

        // Setup players
        Player playerOne = new Player("one");
        Player playerTwo = new Player("two");
        mancalaGame.setPlayers(playerOne, playerTwo);
        //mancalaGame.setCurrentPlayer(playerOne);

        // Register players and set up the board
       // mancalaGame.getBoard().registerPlayers(playerOne, playerTwo);

        //UserProfile userProfile = new UserProfile("bobby");
        Saver saver = new Saver();
        UserProfile loadProfile;

        try {

            loadProfile = (UserProfile) saver.loadObject("bob.ser");
            loadProfile.updateAyoGamesPlayed();
            System.out.println(loadProfile.getUsername() + loadProfile.getAyoGamesPlayed()); 
            saver.saveObject(loadProfile, "bob.ser");

            //saver.saveObject(userProfile, "bob.ser");

            loadProfile = (UserProfile) saver.loadObject("bob.ser");
            System.out.println(loadProfile.getUsername() + loadProfile.getAyoGamesPlayed());

        } catch (FileNotFoundException err) {
            System.out.println(err);
        }

        // Start the game loop
        //playGame();
    }

    private void displayBoard() {
        Player playerOne = mancalaGame.getPlayers().get(0);
        Player playerTwo = mancalaGame.getPlayers().get(1);

        System.out.println("[" + playerOne.getStoreCount() + "] " +
                        "[" + board.getNumStones(5) + "] " +
                        "[" + board.getNumStones(4) + "] " +
                        "[" + board.getNumStones(3) + "] " +
                        "[" + board.getNumStones(2) + "] " +
                        "[" + board.getNumStones(1) + "] " +
                        "[" + board.getNumStones(0) + "] " +
                        "[" + playerTwo.getStoreCount() + "]");

        System.out.print("    ");
        for (int i = 6; i < 12; i++) {
            System.out.print("[" + board.getNumStones(i) + "] ");
        }
        System.out.println();
    }

    // EVERYTHTING ABOVE IS AI GENERATED

    // This method was originally created by AI, but updated to produce correct results and new changes
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

                if (stonesLeft != -1 || board.isSideEmpty(0) || board.isSideEmpty(7)) { // -1 return specifies another turn
                    break;
                }  
                    System.out.println("pit not found");

            }

            System.out.println("Stones left: " + stonesLeft);    
            
        }
        displayBoard();
        endGame();
        newGame();
    }

    // AI GENERATED

    private void endGame() {
        System.out.println("Game Over!");
        Player winner = null;
        try {
            winner = mancalaGame.getWinner();
            if (winner != null) {
                System.out.println("Winner: " + winner.getName());
            } else {
                System.out.println("It's a tie!");
            }
        } catch (GameNotOverException e) {
            System.out.println("Game is not over yet.");
        }
    }

    // created by me
    private void newGame() {

        String userInput;

        System.out.print("New game? (y/n):");
        while (true) {
            userInput = scanner.next();
            if (userInput.equals("n") || userInput.equals("y")) {
                break;
            }
            System.out.print("Please enter (y/n): ");
        }
        if (userInput.equals("y")) {
            mancalaGame.startNewGame();  
            playGame();
        }
    }

    public static void main(String[] args) {
        TextUI textUI = new TextUI();
        textUI.startGame();
    }
}
*/