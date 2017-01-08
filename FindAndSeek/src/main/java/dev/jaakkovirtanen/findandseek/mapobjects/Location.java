package dev.jaakkovirtanen.findandseek.mapobjects;

/**
 * Class defines location of objects on the gameBoard Location is parameter in
 * BoardObject-instances BoardObject-class is abstract class for all objects on
 * the gameBoard Classes that extend BoardObject are: Player, Answer.
 */
public class Location {

    private int row;
    private int col;

    /**
     * Constructor with row and column.
     * @param row set row for location
     * @param col set column for location
     */
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

    /**
     * Returns boolean if the locations are the same coordinate-point on the board.
     * @param anotherLocation for comparison
     * @return boolean value if the locations are the same
     */
    public boolean equals(Location anotherLocation) {
        if (this.row == anotherLocation.getRow() && this.col == anotherLocation.getCol()) {
            return true;
        }
        return false;
    }

    /**
     * Returns boolean if the location is inside given area.
     * @param row RowCount for comparison
     * @param col ColumnCount for comparison
     * @return boolean if location is inside given parameters
     */
    public boolean isInside(int row, int col) {
        if (this.row < row && this.col < col && this.row >= 0 && this.col >= 0) {
            return true;
        }
        return false;
    }
    
    /**
     * Returns clone of the location, needed for "deep-clone" of the player.
     * @return clone of the location
     */
    public Location getCloneLocation() {
        return new Location(row, col);
    }
}
