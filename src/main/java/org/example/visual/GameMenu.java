package org.example.visual;

import javax.swing.*;
import java.awt.*;

public class GameMenu extends JFrame {

    public GameMenu() {
        setTitle("Battle Game Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setResizable(true);
        setLayout(new BorderLayout());

        // Заголовок
        JLabel title = new JLabel("Battle Game", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        add(title, BorderLayout.NORTH);

        // Панель кнопок
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 1, 40, 40));

        JButton play = new JButton("play");
        JButton exitButton = new JButton("Exit");

        buttonPanel.add(play);
        buttonPanel.add(exitButton);

        add(buttonPanel, BorderLayout.CENTER);

        // Действия кнопок
        exitButton.addActionListener(e -> System.exit(0));

        setVisible(true);
    }
}
