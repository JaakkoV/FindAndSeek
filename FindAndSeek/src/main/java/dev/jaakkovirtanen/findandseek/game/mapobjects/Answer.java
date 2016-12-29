package dev.jaakkovirtanen.findandseek.game.mapobjects;

import dev.jaakkovirtanen.findandseek.game.movealgorithms.MoveNoWay;
import dev.jaakkovirtanen.findandseek.game.Location;

public class Answer extends MapObject {

    public Answer() {
        location = new Location(1, 1);
        moveBehaviour = new MoveNoWay();
    }

}
