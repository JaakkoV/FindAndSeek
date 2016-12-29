package dev.jaakkovirtanen.findandseek.game.levels;

import dev.jaakkovirtanen.findandseek.game.levels.Map;
import dev.jaakkovirtanen.findandseek.game.mapObjects.MapObject;
import dev.jaakkovirtanen.findandseek.game.mapObjects.Player;

/**
 *
 */
public class Level extends Map {
    private MapObject player;

    public Level(char[][] level, Player player) {
        this.player = player;
        this.changeMap(level);
    }
    
}
