package dev.jaakkovirtanen.findandseek.game.mapobjects;

/**
 * Class defines location of objects on the gameBoard Location is parameter in
 * BoardObject-instances BoardObject-class is abstract class for all objects on
 * the gameBoard Classes that extend BoardObject are: - Player - Answer
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

    public boolean equals(Location anotherLocation) {
        if (this.row == anotherLocation.getRow() && this.col == anotherLocation.getCol()) {
            return true;
        }
        return false;
    }

    public boolean isInside(int row, int col) {
        if (this.row < row && this.col < col && this.row >= 0 && this.col >= 0) {
            return true;
        }
        return false;
    }
    
    public Location getCloneLocation() {
        return new Location(row, col);
    }
}
