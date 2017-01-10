package ui;

import dev.jaakkovirtanen.findandseek.levels.*;
import dev.jaakkovirtanen.findandseek.game.Game;
import dev.jaakkovirtanen.findandseek.mapobjects.Answer;
import dev.jaakkovirtanen.findandseek.mapobjects.Location;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*;

/**
 * GUI creates JFrame and adds widgets to it to be drawn.
 */
public class GUI implements KeyListener, Runnable {

    private Game game;
    private JFrame frame;
    private Color answerColor;
    private ArrayList<Level> gameLevels;

    public GUI() {
        this.game = new Game();
        String[] levels = {"assets/TxtTestLevel.txt", "assets/TxtTestLevel2.txt", "assets/TxtTestLevel3.txt", "assets/TxtTestLevel4.txt"};
        this.gameLevels = Level.getListOfLevels(levels);
        this.game.loadLevel(gameLevels.get(1));
    }

    @Override
    public void run() {
        drawGui();
    }

    /**
     * Draws widgets to the frame.
     *
     * @throws InterruptedException ThreadSleep is used in the method
     */
    private void drawGui() {

        this.frame = new JFrame();
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setLayout(new BorderLayout());
        frame.addKeyListener(this);
        initializeFrame();

        this.frame.setVisible(true);

        System.out.print("liiku (a,s,d,w), vaihda liikkumisalgoritmi painamalla 5 (q,e,z,c): ");
        while (true) {
            if (this.game.isVictory()) {
                System.out.println("YOU WON THE GAME");
                System.out.println("MOVES USED: " + this.game.getGameBoard().getPlayer().getMovesPerformed());
                System.exit(0);
            }
            try {
                Thread.sleep(0, 1);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void initializeFrame() {
        frame.getContentPane().removeAll();
        createComponents(frame.getContentPane());
        frame.setSize(new Dimension(800, 600));
    }

    private void createComponents(Container container) {
        BoardPanel pelilauta = new BoardPanel(this);
        pelilauta.setPreferredSize(pelilauta.getPrefSize());

        TopMenu northMenu = new TopMenu(this);

        BottomMenu southMenu = new BottomMenu(this);

        container.add(northMenu, BorderLayout.NORTH);
        container.add(pelilauta, BorderLayout.CENTER);
        container.add(southMenu, BorderLayout.SOUTH);
        frame.setFocusable(true);
        frame.pack();
        frame.repaint();
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

    public Game getGame() {
        return game;
    }

    public ArrayList<Level> getGameLevels() {
        return gameLevels;
    }
    
    
}
