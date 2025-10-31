package org.example.visual.menu;

import org.example.visual.GameController;

import javax.swing.*;

public class GameMenuController {

    final private GameController gameController;

    public GameMenuController(GameController gameController) {
        this.gameController = gameController;
    }

    public void onContinue() {

    }

    public void onNewGame() {

        String playerName = JOptionPane.showInputDialog(null, "Введите имя игрока:", "Новая игра", JOptionPane.QUESTION_MESSAGE);

        if (playerName != null && !playerName.trim().isEmpty()) {
            gameController.onStartNewGame(playerName.trim());
        } else {
            JOptionPane.showMessageDialog(null, "Имя игрока не может быть пустым!", "Ошибка", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void onLoadGame() {

    }

    public void onExit() {
        System.exit(0);
    }
}