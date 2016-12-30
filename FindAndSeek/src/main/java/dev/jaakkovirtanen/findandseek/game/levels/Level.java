package dev.jaakkovirtanen.findandseek.game.levels;

import dev.jaakkovirtanen.findandseek.game.levels.Board;
import dev.jaakkovirtanen.findandseek.game.mapobjects.MapObject;
import dev.jaakkovirtanen.findandseek.game.mapobjects.Player;

/**
 * Level is concrete implementation, which consist of
 *      - MapObjects Player & answers
 *      - char[][], which is 2-dimensional Board
 * Level extends Board, which the Game uses to render the GameBoard
 * 
 * Level is only a "building instruction" for the Board, a thing to be
 * loaded
 */
public class Level extends Board {
    private MapObject player;

    public Level(char[][] level, Player player) {
        this.player = player;
        this.loadLevel(level);
    }
    
}
