package org.example.visual.menu;

import org.example.visual.GameController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayButtonHandler implements ActionListener {

    private final GameMenu gameMenu;

    public PlayButtonHandler(GameMenu gameMenu) {
        this.gameMenu = gameMenu;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        GameController gameController = new GameController();
        gameController.startGame();
    }
}
