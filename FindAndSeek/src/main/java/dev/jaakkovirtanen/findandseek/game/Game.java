package dev.jaakkovirtanen.findandseek.game;

import dev.jaakkovirtanen.findandseek.game.levels.*;
import dev.jaakkovirtanen.findandseek.game.mapobjects.Player;

/**
 * Game is a class which consist of: Board, which is initialized with a Level
 * 
*/
public class Game {

    private Board gameBoard;

    public Game() {
        this.gameBoard = new Board();
    }

    public void loadLevel(Level level) {
        gameBoard.loadLevel(level);
    }

    public void drawBoard() {
        gameBoard.drawBoard();
    }

    public void executePlayerCommand(char moveChar) {
        Player testPlayer = this.gameBoard.getPlayer().getClonePlayer();
        testPlayer.performMove(moveChar);
        if (testPlayer.getLocation().isInside(this.gameBoard.getHeight(), this.gameBoard.getWidth())) {
            this.gameBoard.getPlayer().performMove(moveChar);
        }
    }

    public void checkGameStatus() {
        if (this.gameBoard.getTargeAnswer().getLocation().equals(this.gameBoard.getPlayer().getLocation())) {
            System.out.println("YOU WON THE GAME!");
            System.exit(0);
        }
    }

}
