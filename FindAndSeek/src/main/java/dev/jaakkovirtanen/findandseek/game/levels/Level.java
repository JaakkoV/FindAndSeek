package dev.jaakkovirtanen.findandseek.game.levels;

import dev.jaakkovirtanen.findandseek.game.*;
import dev.jaakkovirtanen.findandseek.game.levels.*;
import dev.jaakkovirtanen.findandseek.game.mapobjects.*;
import dev.jaakkovirtanen.findandseek.game.movealgorithms.*;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Level is building instructions for the GameBoard, which consist of
 * BoardObjects, Player & answers, Board height and width
 *
 * Level is only a "building instruction" for the Board, a thing to be loaded
 *
 * At the moment offering two constructors, another one is taking txt-files as
 * instructions
 *
 */
public class Level extends Board {

    private int boardHeight;
    private int boardWidth;
    private ArrayList<BoardObject> boardObjects = new ArrayList<>();

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
                    if (levelData.length == 3) {
                        initMapObjects(levelData[i], levelData[i + 1], levelData[i + 2]);
                        i = i + 2;
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

    private boolean initMapObjects(String levelData, String row, String col) {
        switch (levelData) {
            case "player":
                this.boardObjects.add(new Player(new Location(Integer.parseInt(row), Integer.parseInt(col)), new MoveCardinal()));
                return true;
            case "a":
                this.boardObjects.add(new Answer(new Location(Integer.parseInt(row), Integer.parseInt(col)), new MoveNoWay()));
                return true;
            case "!a":
                this.boardObjects.add(new Player(new Location(Integer.parseInt(row), Integer.parseInt(col)), new MoveNoWay()));
                return true;
            default:
                return false;
        }
    }

    public Level(int boardHeight, int boardWidth, ArrayList<BoardObject> boardObjects) {
        this.boardObjects.addAll(boardObjects);
        this.board = new char[boardHeight][boardWidth];
        for (int i = 0; i < boardHeight; i++) {
            for (int j = 0; j < boardWidth; j++) {
                this.board[i][j] = '.';
            }
        }
    }
}
