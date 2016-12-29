package dev.jaakkovirtanen.findandseek.game.movealgorithms;

/**
 * Behaviour-class let's MapObject (which has a MoveBehaviour) to move cardinally
 */
public class MoveCardinal implements MoveBehaviour {
    @Override
    public void move() {
        System.out.println("moving cardinally only");
    }
}
