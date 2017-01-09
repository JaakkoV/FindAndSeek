package ui;

import dev.jaakkovirtanen.findandseek.levels.Board;
import dev.jaakkovirtanen.findandseek.mapobjects.Location;
import java.awt.*;
import javax.swing.*;
import dev.jaakkovirtanen.findandseek.mapobjects.Answer;
import dev.jaakkovirtanen.findandseek.mapobjects.BoardObject;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

/**
 * Class extends JPanel to and is a widget to place on the JFrame.
 */
public class DrawTarget extends JPanel {

    private Board gameboard;
    private Dimension prefSize;
    private Color answerColor;

    /**
     * Constructor for DrawBoard.
     *
     * @param gameboard initialized with gameboard
     */
    public DrawTarget(Board gameboard) {
        this.gameboard = gameboard;
        this.prefSize = new Dimension(30, 30);
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        for (Answer a : this.gameboard.getAnswers()) {
            if (isAnswerGoal(a.getRow(), a.getCol())) {
                drawRectangle(this.gameboard.getWidth() * 10 - 10, 25, 0, 25, g2d, this.answerColor);
            }
        }
    }

    private void drawRectangle(int xOffset, int cellWidth, int yOffset, int cellHeight, Graphics2D g2d, Color color) {
        Rectangle rectangle = new Rectangle(xOffset, yOffset, cellWidth, cellHeight);
        g2d.setColor(color);
        g2d.fill(rectangle);
        g2d.setColor(Color.black);
        g2d.draw(rectangle);
    }

    private boolean isAnswerGoal(int i, int j) {
        for (Answer a : this.gameboard.getAnswers()) {
            if (a.getLocation().equals(new Location(i, j))) {
                if (a.isTarget()) {
                    charToColor(a.getValue());
                    return true;
                }
            }
        }
        return false;
    }

    private void charToColor(char c) {
        switch (c) {
            case 'A':
                setAnswerColor(Color.BLUE);
                break;
            case 'B':
                setAnswerColor(Color.GREEN);
                break;
            case 'C':
                setAnswerColor(Color.PINK);
                break;
            case 'X':
                setAnswerColor(Color.CYAN);
                break;
            default:
                setAnswerColor(Color.BLUE);
                break;
        }
    }

    public Dimension getPrefSize() {
        return prefSize;
    }

    public void setAnswerColor(Color answerColor) {
        this.answerColor = answerColor;
    }

}
