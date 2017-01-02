package dev.jaakkovirtanen.findandseek.game.mapobjects;

import dev.jaakkovirtanen.findandseek.game.movealgorithms.*;
import dev.jaakkovirtanen.findandseek.game.Location;

public class Player extends BoardObject {
    
    public Player() {
        location = new Location(0,1);
        moveBehaviour = new MoveCardinal();
    }
    
    public Player(Location location, MoveBehaviour moveBehaviour) {
        this.location = location;
        this.moveBehaviour = moveBehaviour;
    }
    
    public Player getClonePlayer() {
        Player clonePlayer = new Player(this.location.getCloneLocation(), this.moveBehaviour);
        return clonePlayer;
    }
}
