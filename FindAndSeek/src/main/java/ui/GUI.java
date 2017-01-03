package ui;

import java.awt.*;
import javax.swing.*;

public class GUI {

    public void drawGui() {
        JFrame frame = new JFrame();
        JButton button = new JButton("testinappula");
        JCheckBox box = new JCheckBox();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.getContentPane().add(box);
//        frame.getContentPane().add(button);
        frame.setSize(600,400);
        Image peli = new ImageIcon("game.jpg").getImage();
        DrawStartScreen paneeli = new DrawStartScreen();
        frame.getContentPane().add(paneeli);

        frame.setVisible(true);
    }
}
