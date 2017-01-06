package ui;

import dev.jaakkovirtanen.findandseek.levels.*;
import dev.jaakkovirtanen.findandseek.game.Game;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Scanner;
import javax.swing.*;

/**
 * GUI creates JFrame and adds widgets to it to be drawn
 */
public class GUI implements KeyListener {

    private DrawBoard board;
    private char keyPressed;
    private Game game;
    private JFrame frame;

    public void drawGui() throws InterruptedException {
        this.frame = new JFrame();
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setSize(400, 430);
        this.frame.setLayout(new BorderLayout());

        Level level = new Level("assets/TxtTestLevel2.txt");
        Board lauta = new Board();
        lauta.loadLevel(level);
        this.game = new Game();
        this.game.loadLevel(level);
        DrawBoard pelilauta = new DrawBoard(this.game.getGameBoard());
        pelilauta.addKeyListener(this);

        this.frame.getContentPane().add(pelilauta);
        this.frame.setLocationRelativeTo(null);
        this.frame.setVisible(true);
        pelilauta.requestFocusInWindow();

        System.out.print("liiku (a,s,d,w), vaihda liikkumisalgoritmi painamalla 5 (q,e,z,c): ");
        while (true) {
            if (this.game.isVictory()) {
                System.out.println("YOU WON THE GAME");
                System.out.println("MOVES USED: " + this.game.getGameBoard().getPlayer().getMovesPerformed());
                System.exit(0);
            }
            Thread.sleep(0,1);
        }
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        char moveChar = ke.getKeyChar();
        if (moveChar == '5') {
            game.changePlayerMoveAlgo();
        }
        game.executePlayerCommand(moveChar);
        frame.repaint();
    }

    @Override
    public void keyPressed(KeyEvent ke) {

    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }
}
