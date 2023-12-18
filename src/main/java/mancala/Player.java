package mancala;

// EVERYTHING BELOW IS AI GENERATED
public class Player {
    private String name;
    private Store store;
    private UserProfile userProfile;

    public Player() {
        // Default constructor
    }

    public Player(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

//    public void setName(final String name) {
//        this.name = userProfile.getUsername();
//        //this.name = name;
//    }

    public void setName(UserProfile userProfile) {
        this.name = userProfile.getUsername();
    }

    public Store getStore() {
        return store;
    }

    public int getStoreCount() {
        return store.getStoneCount();
    }

    public void setStore(final Store store) {
        this.store = store;
    }

    @Override
    public String toString() {
        return "Player: " + name;
    }
}
