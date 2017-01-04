package ui;

import dev.jaakkovirtanen.findandseek.levels.Board;
import dev.jaakkovirtanen.findandseek.mapobjects.Location;
import java.awt.*;
import javax.swing.*;
import dev.jaakkovirtanen.findandseek.mapobjects.Answer;
import java.util.ArrayList;

/**
 * Class extends JPanel to and is a widget to place on the JFrame.
 */
public class DrawBoard extends JPanel {

    private Board gameboard;

    public DrawBoard(Board gameboard) {
        this.gameboard = gameboard;
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        int width = 400;
        int height = 400;

        int cellWidth = width / (this.gameboard.getWidth() + 1);
        int cellHeight = height / (this.gameboard.getHeight() + 1);

        int xOffset = (width - (this.gameboard.getWidth() * cellWidth)) / 2;
        int yOffset = (height - (this.gameboard.getHeight() * cellHeight)) / 2;
        for (int i = 0; i < this.gameboard.getHeight(); i++) {
            for (int j = 0; j < this.gameboard.getWidth(); j++) {
                if (isPlayer(i, j)) {
                    Rectangle player = new Rectangle(xOffset + (j * cellWidth), yOffset + (i * cellHeight), cellWidth, cellHeight);
                    g2d.setColor(Color.red);
                    g2d.fill(player);
                    g2d.setColor(Color.black);
                    g2d.draw(player);
                    char[] cs = {this.gameboard.getPlayer().getValue()};
                    g2d.drawChars(cs, 0, 1, xOffset * 2 - 5 + (j * cellWidth), yOffset * 2 + (i * cellHeight)
                    );
                } else if (isAnswer(i, j) != null) {
                    Rectangle answer = new Rectangle(xOffset + (j * cellWidth), yOffset + (i * cellHeight), cellWidth, cellHeight);
                    g2d.setColor(Color.yellow);
                    g2d.fill(answer);
                    g2d.setColor(Color.black);
                    g2d.draw(answer);
                    char[] cs = isAnswer(i, j);
                    g2d.drawChars(cs, 0, 1, xOffset * 2 - 5 + (j * cellWidth), yOffset * 2 + (i * cellHeight));
                } else {
                    Rectangle empty = new Rectangle(xOffset + (j * cellWidth), yOffset + (i * cellHeight), cellWidth, cellHeight);
                    g2d.setColor(Color.gray);
                    g2d.fill(empty);
                    g2d.setColor(Color.black);
                    g2d.draw(empty);
                }
            }
        }
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

}
