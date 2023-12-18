package mancala;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import java.io.FileNotFoundException;

public class Saver {
    //private String fileName;
    //MancalaGame loadedMancalaGame;
    UserProfile userProfile;

    public void saveObject(Serializable toSave, String filename) {
        try (ObjectOutputStream objectOut = new ObjectOutputStream(new FileOutputStream("./src/main/assets/" + filename))) {
            
            objectOut.writeObject(toSave);
            //System.out.println("serialized: " + filename);
        } catch (IOException err) {
            err.printStackTrace();
        }
    }

    public Serializable loadObject(String filename) throws FileNotFoundException{
        try (ObjectInputStream objectIn = new ObjectInputStream(new FileInputStream("./src/main/assets/" + filename))) {
            
            //loadedMancalaGame = (MancalaGame) objectIn.readObject();
            userProfile = (UserProfile) objectIn.readObject();
            //System.out.println("MancalaGame object loaded from: " + filename);
        } catch (FileNotFoundException err) {
            throw err;
        } catch (IOException | ClassNotFoundException err) { 
            err.printStackTrace();
        }
        //return loadedMancalaGame;
        return userProfile;
    }

}

