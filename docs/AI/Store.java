package mancala;

public class Store {
    private int totalStones;
    private Player owner;

    public Store() {
        // Default constructor
    }

    public void setOwner(Player player) {
        this.owner = player;
    }

    public Player getOwner() {
        return owner;
    }

    public void addStones(int amount) {
        totalStones += amount;
    }

    public int getTotalStones() {
        return totalStones;
    }

    public int emptyStore() {
        int stonesInStore = totalStones;
        totalStones = 0;
        return stonesInStore;
    }

    @Override
    public String toString() {
        return "Store of " + owner.getName() + " [Total Stones: " + totalStones + "]";
    }
}