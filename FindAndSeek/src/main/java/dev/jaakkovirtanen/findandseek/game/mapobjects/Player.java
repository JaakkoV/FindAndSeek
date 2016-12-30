package dev.jaakkovirtanen.findandseek.game.mapobjects;

import dev.jaakkovirtanen.findandseek.game.movealgorithms.MoveCardinal;
import dev.jaakkovirtanen.findandseek.game.Location;

public class Player extends BoardObject {
    
    public Player() {
        location = new Location(3, 1);
        moveBehaviour = new MoveCardinal();
    }
}
