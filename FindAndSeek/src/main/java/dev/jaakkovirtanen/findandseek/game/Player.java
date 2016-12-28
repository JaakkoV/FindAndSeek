package dev.jaakkovirtanen.findandseek.game;

public class Player extends MapObject {
    
    public Player() {
        location = new Location(1, 1);
        moveBehaviour = new MoveCardinal();
    }
}
