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
        frame.setSize(300,300);
        Image peli = new ImageIcon("game.jpg").getImage();
        DrawPanel paneeli = new DrawPanel();
        frame.getContentPane().add(paneeli);

        frame.setVisible(true);
    }
}
