package dev.jaakkovirtanen.findandseek.game;

import dev.jaakkovirtanen.findandseek.game.levels.*;
import dev.jaakkovirtanen.findandseek.game.mapobjects.*;
import dev.jaakkovirtanen.findandseek.game.movealgorithms.*;
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
            this.drawBoard();
        }
        checkGameStatus();
    }

    public void checkGameStatus() {
        if (this.gameBoard.getTargetAnswer().getLocation().equals(this.gameBoard.getPlayer().getLocation())) {
            System.out.println("YOU WON THE GAME!");
            System.out.println("Moves used: " + this.gameBoard.getPlayer().getMovesPerformed());
            System.exit(0);
        }
    }

    public void changePlayerMoveAlgo() {
        /**
         * Test class for changing moveBehaviour during runtime, idea can be
         * used better with further implementations (change moveBehaviour with
         * special BoardObjects etc)
         */
        if (this.gameBoard.getPlayer().getMoveBehaviour().getClass() == MoveCardinal.class) {
            this.gameBoard.getPlayer().changeMoveBehaviour(new MoveDiagonally());
        } else {
            this.gameBoard.getPlayer().changeMoveBehaviour(new MoveCardinal());
        }
        System.out.println("Liikkumisalgoritmi vaihdettu onnistuneesti");
    }

    public Board getGameBoard() {
        return gameBoard;
    }

}
