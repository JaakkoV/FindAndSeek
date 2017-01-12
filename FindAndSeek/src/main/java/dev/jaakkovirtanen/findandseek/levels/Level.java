package dev.jaakkovirtanen.findandseek.levels;

import dev.jaakkovirtanen.findandseek.mapobjects.*;
import dev.jaakkovirtanen.findandseek.movealgorithms.*;
import java.io.*;
import java.util.*;

/**
 * Level is building instructions for the GameBoard.
 *
 * Level is only a "building instruction" for the Board, a thing to be loaded
 *
 * At the moment offering two constructors, another one is taking txt-files as
 * instructions
 *
 */
public class Level {

    private int boardHeight;
    private int boardWidth;
    private int howManyGoals;
    private ArrayList<BoardObject> boardObjects = new ArrayList<>();
    private int optimalMovesCumulative;
    private int optimalMoves;

    /**
     * Reference to txt-file, which contains level-data.
     *
     * @param filePath path to level's textfile
     */
    public Level(String filePath) {
        try {
            Scanner file = new Scanner(new FileReader(filePath));
            while (file.hasNext()) {
                String line = file.next();
                String[] levelData = line.split(":");
                for (int i = 0; i < levelData.length; i++) {
                    if (initParams(levelData[i], levelData[i + 1])) {
                        i++;
                    }
                    if (levelData.length == 4) {
                        initMapObjects(levelData[i], levelData[i + 1], levelData[i + 2], levelData[i + 3]);
                        i = i + 3;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("level file was not readable, caught exception: " + e.toString());
        }
    }

    private boolean initParams(String levelData, String levelDataParam) {
        switch (levelData) {
            case "boardHeight":
                this.boardHeight = Integer.parseInt(levelDataParam);
                return true;
            case "boardWidth":
                this.boardWidth = Integer.parseInt(levelDataParam);
                return true;
            default:
                return false;
        }
    }

    private boolean initMapObjects(String levelData, String value, String row, String col) {
        switch (levelData) {
            case "player":
                Player p = new Player(new Location(Integer.parseInt(row), Integer.parseInt(col)), new MoveCardinal());
                p.setValue(value.charAt(0));
                this.boardObjects.add(p);
                return true;
            case "a":
                Answer a = new Answer(new Location(Integer.parseInt(row), Integer.parseInt(col)), new MoveNoWay());
                a.setValue(value.charAt(0));
                this.boardObjects.add(a);
                return true;
            case "!":
                a = new Answer(new Location(Integer.parseInt(row), Integer.parseInt(col)), new MoveNoWay());
                a.setValue(value.charAt(0));
                a.setIsTarget(true);
                this.boardObjects.add(a);
                return true;
            default:
                return false;
        }
    }

    /**
     * Provides list of levels to GUI. This constructs many levels from given
     * array of txt-file paths
     *
     * @param listOfPaths Gets Array of String-paths to txt-files, which are
     * level building instructions
     * @return ArrayList of constructed levels
     */
    public static ArrayList<Level> getListOfLevels(String[] listOfPaths) {
        ArrayList<Level> listOfLevels = new ArrayList<>();
        for (String path : listOfPaths) {
            listOfLevels.add(new Level(path));
        }
        return listOfLevels;
    }

    /**
     * Adds value of cumulative optimal moves.
     *
     * @param optimalMoves Integer value of last distance from player to goal
     */
    public void addOptimalMoves(int optimalMoves) {
        this.optimalMovesCumulative += optimalMoves;
    }

    public ArrayList<BoardObject> getBoardObjects() {
        return boardObjects;
    }

    public int getBoardHeight() {
        return boardHeight;
    }

    public int getBoardWidth() {
        return boardWidth;
    }

    public int getHowManyGoals() {
        return howManyGoals;
    }

    public void setHowManyGoals(int howManyGoals) {
        this.howManyGoals = howManyGoals;
    }

    public int getOptimalMovesCumulative() {
        return optimalMovesCumulative;
    }

    public void setOptimalMoves(int optimalMoves) {
        this.optimalMoves = optimalMoves;
    }

    public int getOptimalMoves() {
        return optimalMoves;
    }

}
