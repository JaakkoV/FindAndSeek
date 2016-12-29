package dev.jaakkovirtanen.findandseek.game.levels;

import dev.jaakkovirtanen.findandseek.game.levels.Map;
import dev.jaakkovirtanen.findandseek.game.mapObjects.MapObject;
import dev.jaakkovirtanen.findandseek.game.mapObjects.Player;

/**
 * Level is concrete Map implementation, which consist of
 *      - MapObjects Player & answers
 *      - char[][], which is 2-dimensional map for the MapObjects
 *
 */
public class Level extends Map {
    private MapObject player;

    public Level(char[][] level, Player player) {
        this.player = player;
        this.changeMap(level);
    }
    
}
