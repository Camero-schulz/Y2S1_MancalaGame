package mancala;

import java.util.ArrayList;
import java.io.Serializable;

public class MancalaGame implements Serializable {
    private static final long serialVersionUID = -3788086098781612036L;
    final private ArrayList<Player> players;
    private GameRules board;
    private Player currentPlayer;
    private Player onePlayer; 
    private Player twoPlayer;

    public MancalaGame() {
        players = new ArrayList<>();
        //board = new KalahRules();
    }

    public void setPlayers(final Player onePlayer, final Player twoPlayer) {
        this.onePlayer = onePlayer; // Assign onePlayer to the instance variable
        this.twoPlayer = twoPlayer; // Assign twoPlayer to the instance variable
        players.add(onePlayer);
        players.add(twoPlayer);
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(final Player player) {
        this.currentPlayer = player;
        if (player == onePlayer) {
            board.setPlayer(1);
        } else {
            board.setPlayer(2);
        }
    }

    public void setBoard(final GameRules theBoard) {
        this.board = theBoard;
    }

    public GameRules getBoard() {
        return board;
    }

    public String getBoardName() {
        return (board.getClass().getSimpleName());
    }

    // EVERYTHING ABOVE CREATED BY AI


    public int getNumStones(final int pitNum) throws PitNotFoundException {
        if (!(pitNum >= 1 && pitNum <= 12)) {
            throw new PitNotFoundException("mancalagame Invalid pit option: " + pitNum);
        }
        return board.getNumStones(pitNum);
    }

    public int move(final int startPit) throws InvalidMoveException {

        int playerNum = 0;

        if (!(currentPlayer.equals(onePlayer) || currentPlayer.equals(twoPlayer))) {
            throw new IllegalStateException("Invalid player!");
        }

        if (currentPlayer.equals(onePlayer) && !(startPit >= 1 && startPit <= 6)) {
            throw new InvalidMoveException("Invalid move option: " + startPit);
        }

        if (currentPlayer.equals(twoPlayer) && !(startPit >= 7 && startPit <= 12)) {
            throw new InvalidMoveException("Invalid move option: " + startPit);
        }

        if (currentPlayer.equals(onePlayer)) {
            playerNum = 1;
        } else if (currentPlayer.equals(twoPlayer)) {
            playerNum = 2;
        }

        final int newStonesInStore = board.moveStones(startPit, playerNum);
        if (newStonesInStore == -1) { // returns -1 -- specifies additional turn
            return -1;
        }

        int totalStones = 0;

        try {
            if (currentPlayer.equals(onePlayer)) {
                for (int i = 1; i <= 6; i++) {
                    totalStones += getNumStones(i);
                }
            } else if (currentPlayer.equals(twoPlayer)) {
                for (int i = 7; i <= 12; i++) {
                    totalStones += getNumStones(i);
                }
            }
        } catch (PitNotFoundException err) {
            System.out.println(err.getMessage());
        }

        // switch players
        if (currentPlayer.equals(onePlayer)) {
            setCurrentPlayer(twoPlayer);
        } else {
            setCurrentPlayer(onePlayer);
        }

        // returns the total number of stones remaining in the player's side pits
        return totalStones;
    }

    public int getStoreCount(final Player player) throws NoSuchPlayerException {
        //return player.getStore().getStoneCount();
        if (!(player.equals(onePlayer) || player.equals(twoPlayer))) {
            throw new NoSuchPlayerException("Invalid player!");
        }
        return player.getStoreCount();
    }

    // EVERYTHING BELOW CREATED BY AI

    public Player getWinner() throws GameNotOverException {
        if (!isGameOver()) {
            throw new GameNotOverException("Game is not over yet.");
        }

        // default values
        int storeOne = 0;
        int storeTwo = 0;

        try {
            storeOne = getStoreCount(players.get(0));
            storeTwo = getStoreCount(players.get(1));
        } catch (NoSuchPlayerException err) {
            System.out.println(err.getMessage());
        }

        Player winner;
        if (storeOne > storeTwo) {
            winner = players.get(0);
        } else if (storeTwo > storeOne) {
            winner = players.get(1);
        } else {
            return null; // Tie
        }

        return winner;
    }

    public boolean isGameOver() {
        return board.isSideEmpty(1) || board.isSideEmpty(7);
    }

    public void startNewGame() {
        board.resetBoard();
    }

    @Override
    public String toString() {
        return "Mancala Game: \n" + board.toString();
    }
}
