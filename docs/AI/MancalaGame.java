package mancala;

import java.util.ArrayList;

public class MancalaGame {
    private ArrayList<Player> players;
    private Board board;
    private Player currentPlayer;

    public MancalaGame() {
        players = new ArrayList<>();
        board = new Board();
    }

    public void setPlayers(Player onePlayer, Player twoPlayer) {
        players.add(onePlayer);
        players.add(twoPlayer);
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player player) {
        this.currentPlayer = player;
    }

    public void setBoard(Board theBoard) {
        this.board = theBoard;
    }

    public Board getBoard() {
        return board;
    }

    public int getNumStones(int pitNum) throws PitNotFoundException {
        return board.getNumStones(pitNum);
    }

    public int move(int startPit) throws InvalidMoveException {
        return board.moveStones(startPit, currentPlayer);
    }

    public int getStoreCount(Player player) throws NoSuchPlayerException {
        return player.getStore().getStoneCount();
    }

    public Player getWinner() throws GameNotOverException {
        if (!isGameOver()) {
            throw new GameNotOverException("Game is not over yet.");
        }

        int storeOne = players.get(0).getStore().getStoneCount();
        int storeTwo = players.get(1).getStore().getStoneCount();

        if (storeOne > storeTwo) {
            return players.get(0);
        } else if (storeTwo > storeOne) {
            return players.get(1);
        } else {
            return null; // Tie
        }
    }

    public boolean isGameOver() {
        return board.isSideEmpty(0) || board.isSideEmpty(6);
    }

    public void startNewGame() {
        board.resetBoard();
    }

    @Override
    public String toString() {
        return "Mancala Game: \n" + board.toString();
    }
}