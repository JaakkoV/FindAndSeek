package dev.jaakkovirtanen.findandseek.game;

/**
 * Class defines location of objects on the game-map
 * Location is parameter in MapObject-instances
 * MapObject-class is abstract class for all objects on the game-map
 * Classes that extend MapObject are:
 *      - Player
 *      - Answer
 */
public class Location {
    
    private int row;
    private int col;

    public Location(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }
    
}
