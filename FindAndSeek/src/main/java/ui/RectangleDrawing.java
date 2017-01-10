/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import dev.jaakkovirtanen.findandseek.game.Game;
import dev.jaakkovirtanen.findandseek.mapobjects.Answer;
import dev.jaakkovirtanen.findandseek.mapobjects.Location;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 *
 * @author User
 */
public class RectangleDrawing {

    public RectangleDrawing(Game game) {
    }

    public static void drawRectangle(int xOffset, int j, int cellWidth, int yOffset, int i, int cellHeight, Graphics2D g2d, Color color) {
        Rectangle rectangle = new Rectangle(xOffset + (j * cellWidth), yOffset + (i * cellHeight), cellWidth, cellHeight);
        g2d.setColor(color);
        g2d.fill(rectangle);
        g2d.setColor(Color.black);
        g2d.draw(rectangle);
    }

    public static boolean isPlayer(Game game, int i, int j) {
        return game.getGameBoard().getPlayer().getLocation().equals(new Location(i, j));
    }

    public static Color answersColor(Game game, int i, int j) {
        for (Answer a : game.getGameBoard().getAnswers()) {
            if (a.getLocation().equals(new Location(i, j))) {
                return charToColor(a.getValue());
            }
        }
        return null;
    }

    public static Color charToColor(char c) {
        switch (c) {
            case 'A':
                return Color.BLUE;
            case 'B':
                return Color.GREEN;
            case 'C':
                return Color.PINK;
            case 'D':
                return Color.ORANGE;
            case 'E':
                return Color.YELLOW;
            case 'F':
                return Color.MAGENTA;
            case 'X':
                return Color.CYAN;
            default:
                return Color.BLUE;
        }
    }
}
