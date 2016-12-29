package dev.jaakkovirtanen.findandseek.game.mapObjects;

import dev.jaakkovirtanen.findandseek.game.Location;
import dev.jaakkovirtanen.findandseek.game.moveAlgorithms.*;

public class Answer extends MapObject {

    public Answer() {
        location = new Location(1, 1);
        moveBehaviour = new MoveNoWay();
    }

}
