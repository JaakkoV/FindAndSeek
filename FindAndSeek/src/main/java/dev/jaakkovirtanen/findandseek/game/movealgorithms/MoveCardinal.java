package dev.jaakkovirtanen.findandseek.game.movealgorithms;

/**
 * Behaviour-class let's MapObject (which has a MoveBehaviour) to move cardinally
 */
public class MoveCardinal implements MoveBehaviour {
    @Override
    public int move(char c) {
        switch(c) {
            case 'w':
                return 8;
            case 's':
                return 2;
        }
        return 5;
    }
}
