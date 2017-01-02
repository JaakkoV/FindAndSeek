package dev.jaakkovirtanen.findandseek.game.levels;

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
    private ArrayList<Answer> answers = new ArrayList<>();;
    private Answer targeAnswer;

    public Board() {
    }

    public void loadLevel(Level level) {
        this.level = level;
    }

    public Board(Level level, Player player) {
        this.level = level;
        this.player = player;
    }

//    public void drawBoard() {
//        for (int i = 0; i < this.level.getHeight(); i++) {
//            for (int j = 0; j < this.level.getWidth(); j++) {
//                if (this.player.getCol() == j && this.player.getRow() == i) {
//                    System.out.print('@');
//                } else {
//                    System.out.print(this.board[i][j]);
//                }
//            }
//            System.out.println();
//        }
//    }
    public void initPlayer() {
        for (BoardObject b : this.level.getBoardObjects()) {
            if (b.getClass() == Player.class) {
                setPlayer((Player) b);
            }
        }
    }

    public void initAnswers() {
        for (BoardObject b : this.level.getBoardObjects()) {
            if (b.getClass() == Answer.class) {
                answers.add((Answer) b);
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
