package dev.jaakkovirtanen.findandseek.game;

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
    
    public void performMove() {
        this.moveBehaviour.move();
    }
    
    public void changeMoveBehaviour(MoveBehaviour newMoveBehaviour) {
        this.moveBehaviour = newMoveBehaviour;
    }
}
