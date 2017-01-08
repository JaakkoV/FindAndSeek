package ui;

import dev.jaakkovirtanen.findandseek.levels.Board;
import dev.jaakkovirtanen.findandseek.mapobjects.Location;
import java.awt.*;
import javax.swing.*;
import dev.jaakkovirtanen.findandseek.mapobjects.Answer;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

/**
 * Class extends JPanel to and is a widget to place on the JFrame.
 */
public class DrawTarget extends JPanel {

    private Board gameboard;
    private Dimension prefSize;

    public DrawTarget(Board gameboard) {
        this.gameboard = gameboard;
        this.prefSize = new Dimension(30,30);
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        drawRectangle(this.gameboard.getWidth() * 10 - 10, 25, 0, 25, g2d, Color.yellow);
        
    }

    private void drawRectangle(int xOffset,  int cellWidth, int yOffset, int cellHeight, Graphics2D g2d, Color color) {
        Rectangle rectangle = new Rectangle(xOffset, yOffset, cellWidth, cellHeight);
        g2d.setColor(color);
        g2d.fill(rectangle);
        g2d.setColor(Color.black);
        g2d.draw(rectangle);
    }

    private boolean isPlayer(int i, int j) {
        return this.gameboard.getPlayer().getLocation().equals(new Location(i, j));
    }

    private char[] isAnswer(int i, int j) {
        char[] returnsChar = new char[1];
        for (Answer a : this.gameboard.getAnswers()) {
            if (a.getLocation().equals(new Location(i, j))) {
                char ans = a.getValue();
                returnsChar[0] = ans;
                return returnsChar;
            }
        }
        return null;
    }

    public Dimension getPrefSize() {
        return prefSize;
    }

}
