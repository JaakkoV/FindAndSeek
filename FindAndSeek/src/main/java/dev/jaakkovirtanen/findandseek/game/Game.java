package dev.jaakkovirtanen.findandseek.game;

import dev.jaakkovirtanen.findandseek.game.utils.*;
import dev.jaakkovirtanen.findandseek.mapobjects.Player;
import dev.jaakkovirtanen.findandseek.movealgorithms.*;
import dev.jaakkovirtanen.findandseek.levels.*;

/**
 * Game is a class which consist of: Board, which is initialized with a Level.
 *
 */
public class Game {

    private final Board gameBoard;

    /**
     * Constructor.
     */
    public Game() {
        this.gameBoard = new Board();
    }

    /**
     * This method loads level to gameboard.
     *
     * @param level level to be uploaded
     */
    public void loadLevel(Level level) {
        gameBoard.loadLevel(level);
    }

    /**
     * method tries to execute player command and moves player & increase
     * moveCount if move is allowed.
     *
     * @param moveChar character from player
     */
    public void executePlayerCommand(char moveChar) {
        Player testPlayer = this.gameBoard.getPlayer().getClonePlayer();
        testPlayer.performMove(moveChar);
        if (testPlayer.getLocation().isInside(this.gameBoard.getHeight(), this.gameBoard.getWidth()) && !testPlayer.getLocation().equals(this.gameBoard.getPlayer().getLocation())) {
            this.gameBoard.getPlayer().performMove(moveChar);
        }
        checkGameStatus();
    }

    /**
     * checks if Player has hit the targetAnswer and change game parameters
     * (e.g. goals hit).
     */
    public void checkGameStatus() {
        if (this.gameBoard.getTargetAnswer().getLocation().equals(this.gameBoard.getPlayer().getLocation())) {
            gameBoard.getLevel().setHowManyGoals(gameBoard.getLevel().getHowManyGoals() + 1);
            gameBoard.changeTargetAnswer(Randomizer.getRandomNumber(gameBoard.getAnswers().size() - 1));
        }
    }

    /**
     * Test class for changing moveBehaviour during runtime, idea can be used
     * better with further implementations (change moveBehaviour with special
     * BoardObjects etc).
     */
    public void changePlayerMoveAlgo() {
        if (this.gameBoard.getPlayer().getMoveBehaviour().getClass() == MoveCardinal.class) {
            this.gameBoard.getPlayer().changeMoveBehaviour(new MoveDiagonally());
        } else {
            this.gameBoard.getPlayer().changeMoveBehaviour(new MoveCardinal());
        }
        System.out.println("Liikkumisalgoritmi vaihdettu onnistuneesti");
    }

    /**
     * returns gameboard.
     *
     * @return this.gameBoard
     */
    public Board getGameBoard() {
        return gameBoard;
    }

}
