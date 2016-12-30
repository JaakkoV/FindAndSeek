package dev.jaakkovirtanen.findandseek.game.levels;

import dev.jaakkovirtanen.findandseek.game.levels.Board;
import dev.jaakkovirtanen.findandseek.game.mapobjects.*;
/**
 * Level is building instructions for the GameBoard, which consist of 
 *      - BoardObjects Player & answers
 *      - Board height and width
 *
 * Level is only a "building instruction" for the Board, a thing to be loaded
 */
public class Level extends Board {

    public Level(int boardHeight, int boardWidth, BoardObject player, BoardObject answer) {
        this.player = player;
        this.board = new char[boardHeight][boardWidth];
        for (int i = 0; i < boardHeight; i++) {
            for (int j = 0; j < boardWidth; j++) {
                this.board[i][j] = '.';
            }
        }
    }
}
