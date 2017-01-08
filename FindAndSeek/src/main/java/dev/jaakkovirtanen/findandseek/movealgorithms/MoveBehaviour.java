package dev.jaakkovirtanen.findandseek.movealgorithms;

/**
 * Player implements this interface to know how to move Moving behaviour is made
 * by this way to be able to change player's move-logic dynamically during the
 * runtime (for the possible future purposes: example, magic mushroom mix up
 * direction/key) Design principle: "program to an interface, not an
 * implementation".
 *
 */
public interface MoveBehaviour {
    /**
     * Character to concrete move-method.
     * @param c character to move-method
     * @return Integer for moving the BoardObject
     */
    int move(char c);
}
