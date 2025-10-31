package org.example.save;

import org.example.Player;

import java.io.*;

public class SaveController {
    private static final String SAVE_PATH = "src/main/java/org/example/save/saves/";

    public void createSave(String saveName, Player player) {
        saveGame(saveName, new Save(saveName, player));
    }

    public void renameSave (String saveName, Save save){
        save.setSaveName(saveName);
    }

    public void saveGame (String saveName, Save save) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream(SAVE_PATH + saveName + ".sav"))){
            objectOutputStream.writeObject(save);
        } catch (IOException exception){
            exception.printStackTrace();
        }
    }


    public Save loadGame(String saveName) {
        try (ObjectInputStream in = new ObjectInputStream(
                new FileInputStream(SAVE_PATH + saveName + ".sav"))) {
            Save save = (Save) in.readObject();
            return save;
        } catch (IOException | ClassNotFoundException exception) {
            exception.printStackTrace();
        }
        return null;
    }

}
