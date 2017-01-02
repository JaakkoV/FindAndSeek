package dev.jaakkovirtanen.findandseek.game.mapobjects;

import dev.jaakkovirtanen.findandseek.game.movealgorithms.*;
import dev.jaakkovirtanen.findandseek.game.Location;

public class Answer extends BoardObject {

    private boolean isTarget = false;

    public Answer() {
        location = new Location(8, 3);
        moveBehaviour = new MoveNoWay();
    }

    public Answer(Location location, MoveBehaviour moveBehaviour) {
        this.location = location;
        this.moveBehaviour = moveBehaviour;
    }

    public char getValue() {
        return super.getValue();
    }

    public void setValue(char value) {
        super.setValue(value);
    }

    public boolean isTarget() {
        return isTarget;
    }

    public void setIsTarget(boolean isTarget) {
        this.isTarget = isTarget;
    }
}
