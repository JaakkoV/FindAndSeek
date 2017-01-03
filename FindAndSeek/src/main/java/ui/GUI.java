package ui;

import javax.swing.*;

public class GUI {

    public void drawGui() {
        JFrame frame = new JFrame();
        JButton button = new JButton("testinappula");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(button);
        frame.setSize(300,300);
        frame.setVisible(true);
    }
}
