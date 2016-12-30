package dev.jaakkovirtanen.findandseek.game.levels;

import dev.jaakkovirtanen.findandseek.game.mapobjects.MapObject;
import dev.jaakkovirtanen.findandseek.game.mapobjects.*;

/**
 * Board-class is abstract class to provide board for the Game-class
 * Boards are generated from Levels, which is class to extend this class
 */
public abstract class Board {
    char[][] board;
    Player player;
    Answer answer;

    public Board() {
    }

    public void loadLevel(char[][] level) {
        this.board = level;
    }
    
    public void drawBoard() {
        for (int i = 0; i < this.getHeight(); i++) {
            for (int j = 0; j < this.getWidth(); j++) {
                System.out.print(this.board[i][j]);
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

    public Answer getAnswer() {
        return answer;
    }

    public Player getPlayer() {
        return player;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
    
}
