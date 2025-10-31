package org.example;

import org.example.visual.GameController;
import org.example.visual.menu.GameMenu;
import org.example.visual.menu.GameMenuController;
import org.springframework.context.annotation.ComponentScan;

import javax.swing.*;

@ComponentScan
public class Main {
    public static void main(String[] args) {
//        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//        PlacementControl placementControl = context.getBean(PlacementControl.class);
//        placementControl.applyDefaultPlacement();

        SwingUtilities.invokeLater(() -> {
            new GameMenu(new GameMenuController(new GameController()));
        });
    }
}