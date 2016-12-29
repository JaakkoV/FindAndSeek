package dev.jaakkovirtanen.findandseek.game.mapObjects;

import dev.jaakkovirtanen.findandseek.game.Location;
import dev.jaakkovirtanen.findandseek.game.moveAlgorithms.*;

public class Player extends MapObject {
    
    public Player() {
        location = new Location(1, 1);
        moveBehaviour = new MoveCardinal();
    }
}
