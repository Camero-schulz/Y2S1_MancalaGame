package mancala;

// EVERYTHING BELOW IS AI GENERATED
public class Pit implements Countable {
    private int stoneCount;

    public Pit() {
        stoneCount = 4; // Initializing each pit with 4 stones
    }

    @Override
    public int getStoneCount() {
        return stoneCount;
    }

    @Override
    public void addStone() {
        stoneCount++;
    }

    @Override
    public int removeStones() {
        final int stonesRemoved = stoneCount;
        stoneCount = 0;
        return stonesRemoved;
    }

    @Override
    public void addStones(int amount) {
        stoneCount+=amount;
    }

    //ADDED THIS
    public void removeAStone() {
        stoneCount+=-1;
    }

    @Override
    public String toString() {
        return "Pit [Stone Count: " + stoneCount + "]";
    }
}
