package mancala;

import java.io.Serializable;

public class UserProfile implements Serializable {
    private String username;
    private int kalahGamesPlayed;
    private int ayoGamesPlayed;
    private int kalahGamesWon;
    private int ayoGamesWon;
    //private Saver saver = new Saver();

    public UserProfile(String username) {
        this.username = username;
        this.kalahGamesPlayed = 0;
        this.ayoGamesPlayed = 0;
        this.kalahGamesWon = 0;
        this.ayoGamesWon = 0;
        
    }

//    public Serializable loadProfile() {
//        return saver.loadObject("bob.ser");
//    }

    public String getUsername() {
        return username;
    }

    public int getKalahGamesPlayed() {
        return kalahGamesPlayed;
    }

    public int getAyoGamesPlayed() {
        return ayoGamesPlayed;
    }

    public int getKalahGamesWon() {
        return kalahGamesWon;
    }

    public int getAyoGamesWon() {
        return ayoGamesWon;
    }

    public void updateKalahGamesPlayed() {
        kalahGamesPlayed++;
    }

    public void updateAyoGamesPlayed() {
        ayoGamesPlayed++;
    }

    public void updateKalahGamesWon() {
        kalahGamesWon++;
    }

    public void updateAyoGamesWon() {
        ayoGamesWon++;
    }

}