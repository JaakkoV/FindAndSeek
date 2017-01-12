package dev.jaakkovirtanen.findandseek.movealgorithms;

/**
 * Behaviour-Class which freezes the BoardObject (which has a MoveBehavior).
 */
public class MoveNoWay implements MoveBehaviour {

    @Override
    public int move(char c) {
        return 5;
    }
}
