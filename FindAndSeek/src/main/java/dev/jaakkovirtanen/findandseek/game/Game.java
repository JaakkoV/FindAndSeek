package dev.jaakkovirtanen.findandseek.game;

import dev.jaakkovirtanen.findandseek.mapobjects.Player;
import dev.jaakkovirtanen.findandseek.movealgorithms.MoveDiagonally;
import dev.jaakkovirtanen.findandseek.movealgorithms.MoveCardinal;
import dev.jaakkovirtanen.findandseek.levels.Board;
import dev.jaakkovirtanen.findandseek.levels.Level;

/**
 * Game is a class which consist of: Board, which is initialized with a Level
 * 
*/
public class Game {

    private Board gameBoard;
    private boolean victory;

    public Game() {
        this.gameBoard = new Board();
        this.victory = false;
    }

    public void loadLevel(Level level) {
        gameBoard.loadLevel(level);
    }

    public void executePlayerCommand(char moveChar) {
        Player testPlayer = this.gameBoard.getPlayer().getClonePlayer();
        testPlayer.performMove(moveChar);
        if (testPlayer.getLocation().isInside(this.gameBoard.getHeight(), this.gameBoard.getWidth())) {
            this.gameBoard.getPlayer().performMove(moveChar);
        }
        checkGameStatus();
    }

    public void checkGameStatus() {
        if (this.gameBoard.getTargetAnswer().getLocation().equals(this.gameBoard.getPlayer().getLocation())) {
            setVictory(true);
        }
    }

    /**
     * Test class for changing moveBehaviour during runtime, idea can be used
     * better with further implementations (change moveBehaviour with special
     * BoardObjects etc)
     */
    public void changePlayerMoveAlgo() {
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

    public boolean isVictory() {
        return victory;
    }

    public void setVictory(boolean victory) {
        this.victory = victory;
    }

}
