package dev.jaakkovirtanen.findandseek.game.levels;

import dev.jaakkovirtanen.findandseek.game.mapobjects.*;

/**
 * Board-class is abstract class to provide board for the Game-class Boards are
 * generated from Levels, which is a class to extend this class
 *
 * Player is on the board, not on the level (even though the level tells where
 * the player is at the beginning of the game)
 */
public abstract class Board {

    char[][] board;
    BoardObject player;
    BoardObject answer;

    public Board() {
    }

    public void loadLevel(char[][] level) {
        this.board = level;
    }

    public void drawBoard() {
        for (int i = 0; i < this.getHeight(); i++) {
            for (int j = 0; j < this.getWidth(); j++) {
                if (this.player.getCol() == j && this.player.getRow() == i) {
                    System.out.print('@');
                } else {
                    System.out.print(this.board[i][j]);
                }
            }
            System.out.println();
        }
    }

    public int getWidth() {
        return this.board[0].length;
    }

    public int getHeight() {
        return this.board.length;
    }

    public char[][] getBoard() {
        return board;
    }

    public BoardObject getAnswer() {
        return answer;
    }

    public BoardObject getPlayer() {
        return player;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

}
