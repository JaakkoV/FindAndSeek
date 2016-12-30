package dev.jaakkovirtanen.findandseek.game.mapobjects;

import dev.jaakkovirtanen.findandseek.game.movealgorithms.*;
import dev.jaakkovirtanen.findandseek.game.Location;

public class Answer extends BoardObject {

    public Answer() {
        location = new Location(8, 3);
        moveBehaviour = new MoveNoWay();
    }

    public Answer(Location location, MoveBehaviour moveBehaviour) {
        this.location = location;
        this.moveBehaviour = moveBehaviour;
    }
}
