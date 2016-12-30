package dev.jaakkovirtanen.findandseek.game.movealgorithms;

/**
 * Behaviour-class let's MapObject (which has a MoveBehaviour) to move diagonally
 */
public class MoveDiagonally implements MoveBehaviour {
    @Override
    public int move(char c) {
        switch(c) {
            case 'e':
                return 9;
            case 'q':
                return 7;
        }
        return 5;
    }
}
