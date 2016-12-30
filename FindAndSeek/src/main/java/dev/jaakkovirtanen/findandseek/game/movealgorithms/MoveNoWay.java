package dev.jaakkovirtanen.findandseek.game.movealgorithms;

/**
 * Behaviour-Class which freezes the MapObject (which has a MoveBehavior)
 */
public class MoveNoWay implements MoveBehaviour {
    @Override
    public int move(char c) {
        System.out.println("not moving at all");
        return 5;
    }
}
