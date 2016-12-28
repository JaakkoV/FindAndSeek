package dev.jaakkovirtanen.findandseek.game;

/**
 * Behaviour-Class which freezes the MapObject (which has a MoveBehavior)
 */
public class MoveNoWay implements MoveBehaviour {
    @Override
    public void move() {
        System.out.println("not moving at all");
    }
}
