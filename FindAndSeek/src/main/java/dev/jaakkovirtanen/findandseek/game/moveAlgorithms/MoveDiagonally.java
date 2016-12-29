package dev.jaakkovirtanen.findandseek.game.moveAlgorithms;

/**
 * Behaviour-class let's MapObject (which has a MoveBehaviour) to move diagonally
 */
public class MoveDiagonally implements MoveBehaviour {
    @Override
    public void move() {
        System.out.println("moving diagonally only");
    }
}
