package org.example.visual.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExitButtonHandler implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
}
