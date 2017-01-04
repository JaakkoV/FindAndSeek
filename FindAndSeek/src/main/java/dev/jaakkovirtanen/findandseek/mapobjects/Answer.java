package dev.jaakkovirtanen.findandseek.mapobjects;

import dev.jaakkovirtanen.findandseek.movealgorithms.MoveBehaviour;

/**
 * Answer-object extends BoardObject and is an answer on the gameboard.
 * 
 * Answer has boolean isTarget, which is goal of the game
 */
public class Answer extends BoardObject {

    private boolean isTarget = false;

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
