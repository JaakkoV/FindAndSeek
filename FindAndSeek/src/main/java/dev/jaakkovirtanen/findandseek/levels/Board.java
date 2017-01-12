package dev.jaakkovirtanen.findandseek.levels;

import dev.jaakkovirtanen.findandseek.game.utils.Randomizer;
import dev.jaakkovirtanen.findandseek.mapobjects.BoardObject;
import dev.jaakkovirtanen.findandseek.mapobjects.Player;
import dev.jaakkovirtanen.findandseek.mapobjects.Answer;
import dev.jaakkovirtanen.findandseek.mapobjects.Location;
import java.util.ArrayList;

/**
 * Board-class is abstract class to provide board for the Game-class Boards are
 * generated from Levels, which is a class to extend this class.
 *
 * Player is on the board, not on the level (even though the level tells where
 * the player is at the beginning of the game)
 */
public class Board {

    private Level level;
    private Player player;
    private ArrayList<Answer> answers = new ArrayList<>();
    private Answer targetAnswer;
    private ArrayList<Character> boardOfChars = new ArrayList<>();
    private boolean mixAnswers = false;

    /**
     * Empty constructor.
     */
    public Board() {
    }

    /**
     * Load level to this Board.
     *
     * @param level level to be uploaded
     */
    public void loadLevel(Level level) {
        this.level = level;
        this.initAll();
        this.initBoardChar();
        this.level.setOptimalMoves(optimalDistance());
    }

    private boolean isPlayer(int i, int j) {
        return this.player.getLocation().equals(new Location(i, j));
    }

    private char isAnswer(int i, int j) {
        for (Answer a : this.answers) {
            if (a.getLocation().equals(new Location(i, j))) {
                return a.getValue();
            }
        }
        return '.';
    }

    private void initAll() {
        this.initPlayer();
        this.initAnswers();
    }

    private void initPlayer() {
        for (BoardObject b : this.level.getBoardObjects()) {
            if (b.getClass() == Player.class) {
                setPlayer(
                        (Player) b);
            }
        }
    }

    private void initAnswers() {
        for (BoardObject b : this.level.getBoardObjects()) {
            if (b.getClass() == Answer.class) {
                Answer a = (Answer) b;
                answers.add(a);
                if (a.isTarget()) {
                    this.targetAnswer = a;
                }
            }
        }
    }

    private void initBoardChar() {
        ArrayList<Character> boardCharsToDraw = new ArrayList<>();
        for (int i = 0; i < this.level.getBoardHeight(); i++) {
            for (int j = 0; j < this.level.getBoardWidth(); j++) {
                if (isPlayer(i, j)) {
                    boardCharsToDraw.add(this.player.getValue());
                } else {
                    boardCharsToDraw.add(isAnswer(i, j));
                }
            }
            boardCharsToDraw.add('\n');
        }
        this.boardOfChars = boardCharsToDraw;
    }

    public void changeTargetAnswer(int indexOfAnswerArray) {
        level.addOptimalMoves(level.getOptimalMoves());
        this.targetAnswer.setIsTarget(false);
        if (!player.getLocation().equals(this.answers.get(indexOfAnswerArray).getLocation())) {
            this.answers.get(indexOfAnswerArray).setIsTarget(true);
        } else {
            if (indexOfAnswerArray == 0) {
                this.answers.get(indexOfAnswerArray + 1).setIsTarget(true);
            } else {
                this.answers.get(indexOfAnswerArray - 1).setIsTarget(true);
            }
        }
        if (mixAnswers) {
            mixUpAnswers();
        }
        initAnswers();
        level.setOptimalMoves(optimalDistance());
        player.setMovesSinceHit(0);
    }

    private void mixUpAnswers() {
        for (Answer a : answers) {
            Location tryLoc = new Location(Randomizer.getRandomNumber(getHeight() - 1), Randomizer.getRandomNumber(getWidth() - 1));
            if (isFree(tryLoc)) {
                a.setLocation(tryLoc);
            } else {
                for (int i = 0; i < 1000; i++) {
                    tryLoc = new Location(Randomizer.getRandomNumber(getHeight() - 1), Randomizer.getRandomNumber(getWidth() - 1));
                    a.setLocation(tryLoc);
                    if (isFree(tryLoc)) {
                        break;
                    }
                }
            }

        }
    }

    private boolean isFree(Location location) {
        for (Answer a : answers) {
            if (a.getLocation().equals(location)) {
                return false;
            }
            if (a.getLocation().equals(player.getLocation())) {
                return false;
            }
        }
        return true;
    }

    private int optimalDistance() {
        int xDist = Math.abs(player.getLocation().getCol() - targetAnswer.getLocation().getCol());
        int yDist = Math.abs(targetAnswer.getLocation().getRow() - player.getLocation().getRow());
        return Math.max(xDist, yDist);
    }

    public ArrayList<Character> getBoardOfChars() {
        return boardOfChars;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    public void setAnswers(ArrayList<Answer> answers) {
        this.answers = answers;
    }

    public ArrayList<Answer> getAnswers() {
        return answers;
    }

    public int getHeight() {
        return level.getBoardHeight();
    }

    public int getWidth() {
        return level.getBoardWidth();
    }

    public Answer getTargetAnswer() {
        return targetAnswer;
    }

    public void setTargetAnswer(Answer targeAnswer) {
        this.targetAnswer = targeAnswer;
    }

    public Level getLevel() {
        return level;
    }

    public void setMixAnswers(boolean mixAnswers) {
        this.mixAnswers = mixAnswers;
    }

    public boolean isMixAnswers() {
        return mixAnswers;
    }

}
