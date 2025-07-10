package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class Main {
    public static void main(String[] args) throws Exception {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        PlacementControl placementControl = context.getBean(PlacementControl.class);
        placementControl.applyDefaultPlacement();

    }
}