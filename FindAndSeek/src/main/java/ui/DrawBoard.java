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
    private Dimension prefSize;
    private Color answerColor;

    public DrawBoard(Board gameboard) {
        this.gameboard = gameboard;
        this.prefSize = new Dimension(this.gameboard.getWidth() * 20 + 10, this.gameboard.getHeight() * 20 + 10);
        this.answerColor = Color.WHITE;
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        int width = this.gameboard.getWidth() * 10;
        int height = this.gameboard.getHeight() * 10;

        int cellWidth = width / (this.gameboard.getWidth()) * 2;
        int cellHeight = height / (this.gameboard.getHeight()) * 2;

        int xOffset = (width - (this.gameboard.getWidth() * cellWidth)) / 1000;
        int yOffset = (height - (this.gameboard.getHeight() * cellHeight)) / 1000;
        for (int i = 0; i < this.gameboard.getHeight(); i++) {
            for (int j = 0; j < this.gameboard.getWidth(); j++) {
                if (isPlayer(i, j)) {
                    drawRectangle(xOffset, j, cellWidth, yOffset, i, cellHeight, g2d, Color.red);
                } else if (isAnswer(i, j)) {
                    drawRectangle(xOffset, j, cellWidth, yOffset, i, cellHeight, g2d, this.answerColor);
                } else {
                    drawRectangle(xOffset, j, cellWidth, yOffset, i, cellHeight, g2d, Color.gray);
                }
            }
        }
    }

    private void drawRectangle(int xOffset, int j, int cellWidth, int yOffset, int i, int cellHeight, Graphics2D g2d, Color color) {
        Rectangle rectangle = new Rectangle(xOffset + (j * cellWidth), yOffset + (i * cellHeight), cellWidth, cellHeight);
        g2d.setColor(color);
        g2d.fill(rectangle);
        g2d.setColor(Color.black);
        g2d.draw(rectangle);
    }

    private boolean isPlayer(int i, int j) {
        return this.gameboard.getPlayer().getLocation().equals(new Location(i, j));
    }

    private boolean isAnswer(int i, int j) {
        for (Answer a : this.gameboard.getAnswers()) {
            if (a.getLocation().equals(new Location(i, j))) {
                charToColor(a.getValue());
                return true;
            }
        }
        return false;
    }

    private void charToColor(char c) {
        System.out.println(c);
        switch (c) {
            case 'A':
                System.out.println("blue");
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
