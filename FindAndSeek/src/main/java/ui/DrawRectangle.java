package ui;

import java.awt.Color;

public class DrawRectangle {

    private Color color;

    private void charToColor(char c) {
        switch (c) {
            case 'A':
                setColor(Color.BLUE);
                break;
            case 'B':
                setColor(Color.GREEN);
                break;
            case 'C':
                setColor(Color.PINK);
                break;
            case 'X':
                setColor(Color.CYAN);
                break;
            default:
                setColor(Color.BLUE);
                break;
        }
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

}
