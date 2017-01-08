package dev.jaakkovirtanen.findandseek.mapobjects;

import dev.jaakkovirtanen.findandseek.movealgorithms.MoveBehaviour;

/**
 * BoardObject is abstract-class to mimic objects on the gameboard.
 */
public abstract class BoardObject {

    private char value;
    Location location;
    MoveBehaviour moveBehaviour;
    int movesPerformed;

    /**
     * Empty constructor.
     */
    public BoardObject() {

    }

    /**
     * Constructor, new BoardObject with location and movebehaviour.
     *
     * @param location set objects location
     * @param moveBehaviour set objects moveBehaviour (use concrete
     * implementation, eg. new MoveCardinal())
     */
    public BoardObject(Location location, MoveBehaviour moveBehaviour) {
        this.location = location;
        this.moveBehaviour = moveBehaviour;
    }

    public int getCol() {
        return this.location.getCol();
    }

    public int getRow() {
        return this.location.getRow();
    }

    /**
     * Try to perform objects move.
     *
     * @param c character from player
     */
    public void performMove(char c) {
        changeLocation(this.moveBehaviour.move(c));
        movesPerformed++;
    }

    private void changeLocation(int direction) {
        switch (direction) {
            case 1:
                this.location.setCol(this.location.getCol() + 1);
                this.location.setRow(this.location.getRow() + 1);
                break;
            case 4:
                this.location.setCol(this.location.getCol() - 1);
                break;
            case 7:
                this.location.setCol(this.location.getCol() - 1);
                this.location.setRow(this.location.getRow() - 1);
                break;
            case 2:
                this.location.setRow(this.location.getRow() + 1);
                break;
            case 8:
                this.location.setRow(this.location.getRow() - 1);
                break;
            case 3:
                this.location.setCol(this.location.getCol() - 1);
                this.location.setRow(this.location.getRow() + 1);
                break;
            case 6:
                this.location.setCol(this.location.getCol() + 1);
                break;
            case 9:
                this.location.setCol(this.location.getCol() + 1);
                this.location.setRow(this.location.getRow() - 1);
                break;
            case 5:
                break;
        }
    }

    /**
     * Change objects moveAlgorithm.
     *
     * @param newMoveBehaviour set new moveBehaviour (use concrete
     * implementation, eg. new MoveDiagonal())
     */
    public void changeMoveBehaviour(MoveBehaviour newMoveBehaviour) {
        this.moveBehaviour = newMoveBehaviour;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }

    public char getValue() {
        return value;
    }

    public void setValue(char value) {
        this.value = value;
    }

    public void setMovesPerformed(int movesPerformed) {
        this.movesPerformed = movesPerformed;
    }

    public int getMovesPerformed() {
        return movesPerformed;
    }

}
