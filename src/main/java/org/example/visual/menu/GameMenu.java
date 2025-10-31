package org.example.visual.menu;

import javax.swing.*;
import java.awt.*;

public class GameMenu extends JFrame {
    public GameMenu(GameMenuController gameMenuController) {
        setTitle("Battle Game Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setResizable(true);
        setLayout(new BorderLayout());

        JLabel title = new JLabel("Battle Game", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        add(title, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 1, 40, 40));

        JButton aContinue = new JButton("Continue");
        JButton aNewGame = new JButton("New Game");
        JButton aLoadGame = new JButton("LoadGame");
        JButton aExitButton = new JButton("Exit");

        aContinue.addActionListener(e -> gameMenuController.onContinue());
        aNewGame.addActionListener(e -> gameMenuController.onNewGame());
        aLoadGame.addActionListener(e -> gameMenuController.onLoadGame());
        aExitButton.addActionListener(e -> gameMenuController.onExit());

        buttonPanel.add(aContinue);
        buttonPanel.add(aNewGame);
        buttonPanel.add(aLoadGame);
        buttonPanel.add(aExitButton);

        add(buttonPanel, BorderLayout.CENTER);
        setVisible(true);
    }
}
