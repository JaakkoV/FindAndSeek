package dev.jaakkovirtanen.findandseek.game.levels;

import dev.jaakkovirtanen.findandseek.game.mapObjects.MapObject;

/**
 * Map-class is abstract class to provide map for the Game-class
 * Maps are generated from Levels, which is class to extend this class
 */
public abstract class Map {
    private char[][] map;

    public Map() {
        
        this.map = new char[][]{
            {'.', '.', '.', '.'},
            {'.', '@', '.', '.'},
            {'.', '.', '.', '.'}};
    }

    public void changeMap(char[][] level) {
        this.map = level;
    }
    public void createMap() {
        for (int i = 0; i < this.getHeight(); i++) {
            for (int j = 0; j < this.getWidth(); j++) {
                System.out.print(this.map[i][j]);
            }
            System.out.println();
        }
    }

    public int getWidth() {
        return this.map[0].length;
    }

    public int getHeight() {
        return this.map.length;
    }

    public char[][] getMap() {
        return map;
    }
    
}
