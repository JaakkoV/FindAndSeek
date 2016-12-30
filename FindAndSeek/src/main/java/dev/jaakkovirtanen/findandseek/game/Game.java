package dev.jaakkovirtanen.findandseek.game;

import dev.jaakkovirtanen.findandseek.game.levels.*;

/**
* Game is a class which consist of:
*       - Board, which is initialized with a Level
* 
*/
public class Game {
    private Board gameBoard;

    public Game(Level gameBoard) {
        this.gameBoard = gameBoard;
    }
    
    public void drawBoard() {
        this.gameBoard.drawBoard();
    }
    
}
