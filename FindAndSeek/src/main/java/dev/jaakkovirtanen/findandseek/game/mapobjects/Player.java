package dev.jaakkovirtanen.findandseek.game.mapobjects;

import dev.jaakkovirtanen.findandseek.game.movealgorithms.MoveCardinal;
import dev.jaakkovirtanen.findandseek.game.Location;

public class Player extends MapObject {
    
    public Player() {
        location = new Location(1, 1);
        moveBehaviour = new MoveCardinal();
    }
}
