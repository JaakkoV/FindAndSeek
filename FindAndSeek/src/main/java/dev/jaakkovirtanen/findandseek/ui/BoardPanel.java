package dev.jaakkovirtanen.findandseek.ui;

import java.awt.*;
import javax.swing.*;

/**
 * BoardPanel extends JPanel and give gameboard to GUI-frame.
 */
public class BoardPanel extends JPanel {

    private GUI gui;
    private Dimension prefSize;

    /**
     * Constructor for the gameboard panel, needs gui.
     *
     * @param gui Gui, which wants the drawn gameboard
     */
    public BoardPanel(GUI gui) {
        this.gui = gui;
        this.prefSize = new Dimension(gui.getGame().getGameBoard().getWidth() * 20 + 10, gui.getGame().getGameBoard().getHeight() * 20 + 10);
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        int width = gui.getGame().getGameBoard().getWidth() * 10;
        int height = gui.getGame().getGameBoard().getHeight() * 10;

        int cellWidth = width / (gui.getGame().getGameBoard().getWidth()) * 2;
        int cellHeight = height / (gui.getGame().getGameBoard().getHeight()) * 2;

        int xOffset = (width - (gui.getGame().getGameBoard().getWidth() * cellWidth)) / 1000;
        int yOffset = (height - (gui.getGame().getGameBoard().getHeight() * cellHeight)) / 1000;
        for (int i = 0; i < gui.getGame().getGameBoard().getHeight(); i++) {
            for (int j = 0; j < gui.getGame().getGameBoard().getWidth(); j++) {
                if (RectangleDrawing.isPlayer(gui.getGame(), i, j)) {
                    RectangleDrawing.drawRectangle(xOffset, j, cellWidth, yOffset, i, cellHeight, g2d, Color.red);
                } else if (RectangleDrawing.answersColor(gui.getGame(), i, j) != null) {
                    RectangleDrawing.drawRectangle(xOffset, j, cellWidth, yOffset, i, cellHeight, g2d, RectangleDrawing.answersColor(gui.getGame(), i, j));
                } else {
                    RectangleDrawing.drawRectangle(xOffset, j, cellWidth, yOffset, i, cellHeight, g2d, Color.gray);
                }
            }
        }
    }

    public Dimension getPrefSize() {
        return prefSize;
    }

}
