package org.example.visual;

import org.example.PiecePlacementController;
import org.example.Player;
import org.example.save.SaveController;
import org.springframework.stereotype.Component;


@Component
public class GameController {
    SaveController saveController = new SaveController();
    PiecePlacementController piecePlacementController = new PiecePlacementController();

    public void onContinue(){
    }

    public void onStartNewGame(String playerName){
        Player player = new Player(playerName);
        piecePlacementController.createDefaultPlacement(player);
        System.out.println(player);
        // saveController.createSave(playerName, player);
    }
}
