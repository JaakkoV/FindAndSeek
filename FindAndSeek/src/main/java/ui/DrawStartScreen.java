package ui;

import java.awt.*;
import javax.swing.*;

public class DrawStartScreen extends JPanel {

    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        Image peli = new ImageIcon("assets/game.jpg").getImage();
        g2d.drawImage(peli, 0, 0, this);
        g2d.setPaint(Color.ORANGE);
        g2d.fillRect(40, 40, 90, 15);
        g2d.setPaint(Color.BLACK);
        char[] cs = {'G', 'R', 'A', 'F', 'I', 'I', 'K', 'K', 'A', 'A', '!'};
        g2d.drawChars(cs, 0, cs.length, 50, 50);
    }
}
