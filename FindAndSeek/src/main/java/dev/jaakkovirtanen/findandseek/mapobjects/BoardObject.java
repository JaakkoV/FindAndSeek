package dev.jaakkovirtanen.findandseek.mapobjects;

import dev.jaakkovirtanen.findandseek.movealgorithms.MoveBehaviour;

public abstract class BoardObject {

    private char value;
    Location location;
    MoveBehaviour moveBehaviour;
    int movesPerformed;

    public BoardObject() {

    }

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

    public void changeMoveBehaviour(MoveBehaviour newMoveBehaviour) {
        this.moveBehaviour = newMoveBehaviour;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }

    public void printLocation() {
        // for debugging purposes fast print
        System.out.println("Column is: " + this.getCol() + " and Row is: " + this.getRow());
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
