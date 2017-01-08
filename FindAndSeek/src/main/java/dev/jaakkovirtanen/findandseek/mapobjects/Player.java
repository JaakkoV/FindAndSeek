package dev.jaakkovirtanen.findandseek.mapobjects;

import dev.jaakkovirtanen.findandseek.movealgorithms.MoveBehaviour;

/**
 * Player extends BoardObject and is object on the gameboard.
 */
public class Player extends BoardObject {

    /**
     * Constructor for player, set location and movebehaviour (use concrete implementation, eg. new MoveCardinal()).
     * @param location set location
     * @param moveBehaviour set moveBehaviour
     */
    public Player(Location location, MoveBehaviour moveBehaviour) {
        this.location = location;
        this.moveBehaviour = moveBehaviour;
    }

    /**
     * Returns cloned player, with same parameters but different reference to heap.
     * @return Player, clone of the player
     */
    public Player getClonePlayer() {
        Player clonePlayer = new Player(this.location.getCloneLocation(), this.moveBehaviour);
        return clonePlayer;
    }
    
    /**
     * gets player's moveBehaviour.
     * @return MoveBehaviour
     */
    public MoveBehaviour getMoveBehaviour() {
        return moveBehaviour;
    }

}
