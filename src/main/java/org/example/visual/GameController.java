package org.example.visual;

import org.example.Board;
import org.example.GameEngine;
import org.example.Player;
import org.example.Position;
import org.example.save.SaveManager;

import java.util.Map;

public class GameController {

    private GameEngine gameEngine;
    SaveManager saveManager = new SaveManager();

    public void startGame() {
        Player player1 = new Player("Player 1");
        saveManager.saveGame("Hi", saveManager.createSave("Hi", player1));

        System.out.println(player1.toString());
    }
}
