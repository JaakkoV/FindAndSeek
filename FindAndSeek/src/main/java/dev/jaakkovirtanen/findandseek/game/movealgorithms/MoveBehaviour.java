package dev.jaakkovirtanen.findandseek.game.movealgorithms;
/**
 * Player implements this interface to know how to move
 * Moving behaviour is made by this way to be able to change
 * player's move-logic dynamically during the runtime 
 * (for the possible future purposes: example, magic mushroom mix up direction/key)
 * Design principle: "program to an interface, not an implementation"
 */
public interface MoveBehaviour {
    void move();
}
