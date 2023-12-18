package mancala;

import java.util.Scanner;

public class TextUI {
    private MancalaGame mancalaGame;
    private Scanner scanner;

    public TextUI() {
        mancalaGame = new MancalaGame();
        scanner = new Scanner(System.in);
    }

    public void startGame() {
        System.out.println("Welcome to Mancala Game!");

        // Setup players
        Player playerOne = new Player('one');
        Player playerTwo = new Player('two');
        mancalaGame.setPlayers(playerOne, playerTwo);

        // Register players and set up the board
        mancalaGame.getBoard().registerPlayers(playerOne, playerTwo);

        // Start the game loop
        playGame();
    }

    private void displayBoard() {
        Board board = mancalaGame.getBoard();
        ArrayList<Pit> pits = board.getPits();
        ArrayList<Store> stores = board.getStores();
        Player playerOne = mancalaGame.getPlayers().get(0);
        Player playerTwo = mancalaGame.getPlayers().get(1);

        System.out.println("[" + playerOne.getStore().getTotalStones() + "] " +
                        "[" + pits.get(5).getStoneCount() + "] " +
                        "[" + pits.get(4).getStoneCount() + "] " +
                        "[" + pits.get(3).getStoneCount() + "] " +
                        "[" + pits.get(2).getStoneCount() + "] " +
                        "[" + pits.get(1).getStoneCount() + "] " +
                        "[" + pits.get(0).getStoneCount() + "] " +
                        "[" + playerTwo.getStore().getTotalStones() + "]");

        System.out.print("                ");
        for (int i = 6; i < 12; i++) {
            System.out.print("[" + pits.get(i).getStoneCount() + "] ");
        }
        System.out.println();
    }

    private void playGame() {
        while (!mancalaGame.isGameOver()) {
            System.out.println(mancalaGame.toString());

            Player currentPlayer = mancalaGame.getCurrentPlayer();
            System.out.println("Current Player: " + currentPlayer.getName());

            System.out.print("Enter pit number to move stones: ");
            int startPit = scanner.nextInt();

            try {
                int stonesLeft = mancalaGame.move(startPit);
                System.out.println("Stones left: " + stonesLeft);
            } catch (InvalidMoveException | PitNotFoundException e) {
                System.out.println("Invalid Move! Please try again.");
            }
        }

        endGame();
    }

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

    public static void main(String[] args) {
        TextUI textUI = new TextUI();
        textUI.startGame();
    }
}
