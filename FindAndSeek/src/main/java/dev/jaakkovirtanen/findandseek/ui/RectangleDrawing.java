package dev.jaakkovirtanen.findandseek.ui;

import dev.jaakkovirtanen.findandseek.game.*;
import dev.jaakkovirtanen.findandseek.mapobjects.*;
import java.awt.*;

public class RectangleDrawing {

    /**
     * Draws rectangle with given parameters, encapsulated here.
     *
     * Used in JPanels, BoardPanel and TopMenu. All methods are static.
     *
     * @param xOffset int
     * @param j int for scaling
     * @param cellWidth int
     * @param yOffset int
     * @param i int for scaling
     * @param cellHeight int
     * @param g2d instance of graphics object
     * @param color color wanted
     */
    public static void drawRectangle(int xOffset, int j, int cellWidth, int yOffset, int i, int cellHeight, Graphics2D g2d, Color color) {
        Rectangle rectangle = new Rectangle(xOffset + (j * cellWidth), yOffset + (i * cellHeight), cellWidth, cellHeight);
        g2d.setColor(color);
        g2d.fill(rectangle);
        g2d.setColor(Color.black);
        g2d.draw(rectangle);
    }

    /**
     * Returns boolean if player is located of given game's given location.
     *
     * @param game Game to be examined
     * @param i Location row parameter to examined
     * @param j Location col parameter to examined
     * @return Boolean if player is located on the given location
     */
    public static boolean isPlayer(Game game, int i, int j) {
        return game.getGameBoard().getPlayer().getLocation().equals(new Location(i, j));
    }

    /**
     * Turns game's location's answer's value to corresponding color.
     *
     * @param game Game to be examined
     * @param i Location row parameter to examined
     * @param j Location col parameter to examined * @return Color of given
     * @return game's given location's answer's color
     */
    public static Color answersColor(Game game, int i, int j) {
        for (Answer a : game.getGameBoard().getAnswers()) {
            if (a.getLocation().equals(new Location(i, j))) {
                return charToColor(a.getValue());
            }
        }
        return null;
    }

    /**
     * Static method to return color corresponding character.
     *
     * @param c Character which represents answers value
     * @return Color mapped to specific character
     */
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
