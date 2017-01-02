package dev.jaakkovirtanen.findandseek.game;

import dev.jaakkovirtanen.findandseek.game.levels.*;

/**
* Game is a class which consist of:
*       - Board, which is initialized with a Level
* 
*/
public class Game {
    private Board gameBoard;

    public Game() {
        this.gameBoard = new Board();
    }
    
    public void drawBoard() {
        gameBoard.drawBoard();
    }
    
    public void loadLevel(Level level) {
        gameBoard.loadLevel(level);
    }
    
}
