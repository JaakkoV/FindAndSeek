package dev.jaakkovirtanen.findandseek.game;

import dev.jaakkovirtanen.findandseek.game.utils.Randomizer;
import dev.jaakkovirtanen.findandseek.mapobjects.Player;
import dev.jaakkovirtanen.findandseek.movealgorithms.MoveDiagonally;
import dev.jaakkovirtanen.findandseek.movealgorithms.MoveCardinal;
import dev.jaakkovirtanen.findandseek.levels.Board;
import dev.jaakkovirtanen.findandseek.levels.Level;

/**
 * Game is a class which consist of: Board, which is initialized with a Level.
 * 
*/
public class Game {

    private Board gameBoard;
    private int howManyGoals;
    private boolean victory;

    /**
     * Constructor.
     */
    public Game() {
        this.gameBoard = new Board();
        this.victory = false;
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
        if (testPlayer.getLocation().isInside(this.gameBoard.getHeight(), this.gameBoard.getWidth())) {
            this.gameBoard.getPlayer().performMove(moveChar);
        }
        checkGameStatus();
    }

    /**
     * checks if victory is true and sets victory-parameter to true.
     */
    public void checkGameStatus() {
        if (this.gameBoard.getTargetAnswer().getLocation().equals(this.gameBoard.getPlayer().getLocation())) {
            howManyGoals++;
            gameBoard.changeTargetAnswer(Randomizer.getRandomNumber(gameBoard.getAnswers().size() - 1));
            System.out.println(howManyGoals);
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

    /**
     * returns boolean victory.
     *
     * @return this.victory true or false
     */
    public boolean isVictory() {
        return victory;
    }

    /**
     * sets victory.
     *
     * @param victory boolean value
     */
    public void setVictory(boolean victory) {
        this.victory = victory;
    }

    public int getHowManyGoals() {
        return howManyGoals;
    }

}
