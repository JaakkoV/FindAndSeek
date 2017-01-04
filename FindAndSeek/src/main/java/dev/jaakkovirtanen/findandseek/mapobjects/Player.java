package dev.jaakkovirtanen.findandseek.mapobjects;

import dev.jaakkovirtanen.findandseek.movealgorithms.MoveBehaviour;

/**
 * Player extends BoardObject and is object on the gameboard.
 */
public class Player extends BoardObject {

    public Player(Location location, MoveBehaviour moveBehaviour) {
        this.location = location;
        this.moveBehaviour = moveBehaviour;
    }

    public Player getClonePlayer() {
        Player clonePlayer = new Player(this.location.getCloneLocation(), this.moveBehaviour);
        return clonePlayer;
    }

    public MoveBehaviour getMoveBehaviour() {
        return moveBehaviour;
    }

}
