package dev.jaakkovirtanen.findandseek.game.mapobjects;

import dev.jaakkovirtanen.findandseek.game.movealgorithms.*;
import dev.jaakkovirtanen.findandseek.game.Location;

public class Answer extends BoardObject {
    private char value;
    
    public Answer() {
        location = new Location(8, 3);
        moveBehaviour = new MoveNoWay();
    }

    public Answer(Location location, MoveBehaviour moveBehaviour) {
        this.location = location;
        this.moveBehaviour = moveBehaviour;
    }

    public char getValue() {
        return value;
    }

    public void setValue(char value) {
        this.value = value;
    }
}
