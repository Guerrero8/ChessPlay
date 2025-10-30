package org.example.visual.menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class GameMenu extends JFrame {

    public GameMenu() {
        setTitle("Battle Game Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setResizable(true);
        setLayout(new BorderLayout());

        JLabel title = new JLabel("Battle Game", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        add(title, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 1, 40, 40));

        JButton aContinue = new JButton("Continue");
        JButton aNewGame = new JButton("NewGame");
        JButton exitButton = new JButton("Exit");

        aContinue.addActionListener(new PlayButtonHandler(this));
        aNewGame.addActionListener();
        exitButton.addActionListener(new ExitButtonHandler());

        buttonPanel.add(aContinue);
        buttonPanel.add(exitButton);

        add(buttonPanel, BorderLayout.CENTER);
        setVisible(true);
    }
}
