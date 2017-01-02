package dev.jaakkovirtanen.findandseek.game.levels;

import dev.jaakkovirtanen.findandseek.game.Location;
import dev.jaakkovirtanen.findandseek.game.mapobjects.*;
import java.util.ArrayList;

/**
 * Board-class is abstract class to provide board for the Game-class Boards are
 * generated from Levels, which is a class to extend this class
 *
 * Player is on the board, not on the level (even though the level tells where
 * the player is at the beginning of the game)
 */
public class Board {

    private Level level;
    private Player player;
    private ArrayList<Answer> answers = new ArrayList<>();
    private Answer targeAnswer;

    public Board() {
    }

    public void loadLevel(Level level) {
        this.level = level;
        this.initAll();
    }

    public void drawBoard() {
        for (int i = 0; i < this.level.getBoardHeight(); i++) {
            for (int j = 0; j < this.level.getBoardWidth(); j++) {
                if (isPlayer(i, j)) {
                    System.out.print('@');
                } else {
                    System.out.print(isAnswer(i, j));
                }
            }
            System.out.println("");
        }
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

    public void initAll() {
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
                answers.add(
                        (Answer) b);
            }
        }
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

}
