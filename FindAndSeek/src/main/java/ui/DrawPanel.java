package ui;

import java.awt.*;
import javax.swing.*;

public class DrawPanel extends JPanel {
    
    public void paintComponent(Graphics g) {
        Image peli = new ImageIcon("assets/game.jpg").getImage();
        g.drawImage(peli, 3, 4, this);
    }
}
