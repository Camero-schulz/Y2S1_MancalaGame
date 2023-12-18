package mancala;

// EVERYTHING BELOW IS AI GENERATED
public class Store implements Countable {
    private int totalStones;
    private Player owner;

    public Store() {
        // Default constructor
        totalStones = 0;
    }   

    public void setOwner(final Player player) {
        this.owner = player;
    }

    public Player getOwner() {
        return owner;
    }

    @Override
    public void addStones(final int amount) {
        totalStones += amount;
    }

    @Override
    public void addStone() {
        totalStones++;
    }

    @Override
    public int getStoneCount() {
        return totalStones;
    }

    @Override
    public int removeStones() {
        final int stonesInStore = totalStones;
        totalStones = 0;
        return stonesInStore;
    }

    @Override
    public String toString() {
        return "Store of " + owner.getName() + " [Total Stones: " + totalStones + "]";
    }
}
