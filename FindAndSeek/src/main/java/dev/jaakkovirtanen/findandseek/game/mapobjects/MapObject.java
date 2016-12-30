package dev.jaakkovirtanen.findandseek.game.mapobjects;

import dev.jaakkovirtanen.findandseek.game.Location;
import dev.jaakkovirtanen.findandseek.game.movealgorithms.MoveBehaviour;

public abstract class MapObject {
    Location location;
    MoveBehaviour moveBehaviour;

    public MapObject() {
    }

    public int getCol() {
        return this.location.getCol();
    }
    
    public int getRow() {
        return this.location.getRow();
    }
    
    public void performMove(char c) {
        changeLocation(this.moveBehaviour.move(c));
    }
    
    private void changeLocation(int direction) {
        switch(direction) {
            case 1:
                this.location.setCol(this.location.getCol() - 1);
                this.location.setRow(this.location.getRow() - 1);
                break;
            case 4:
                this.location.setCol(this.location.getCol() - 1);
                break;
            case 7:
                this.location.setCol(this.location.getCol() - 1);
                this.location.setRow(this.location.getRow() + 1);
                break;
            case 2:
                this.location.setCol(this.location.getRow() - 1);
                break;
            case 8:
                this.location.setCol(this.location.getRow() + 1);
                break;
            case 3:
                this.location.setCol(this.location.getCol() + 1);
                this.location.setRow(this.location.getRow() - 1);
                break;
            case 6:
                this.location.setCol(this.location.getCol() + 1);
                break;
            case 9:
                this.location.setCol(this.location.getCol() + 1);
                this.location.setRow(this.location.getRow() + 1);
                break;
            case 5:
                break;
        }
    }
    
    public void changeMoveBehaviour(MoveBehaviour newMoveBehaviour) {
        this.moveBehaviour = newMoveBehaviour;
    }
}
