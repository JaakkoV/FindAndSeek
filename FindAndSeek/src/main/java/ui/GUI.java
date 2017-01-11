package ui;

import dev.jaakkovirtanen.findandseek.levels.*;
import dev.jaakkovirtanen.findandseek.game.Game;
import dev.jaakkovirtanen.findandseek.mapobjects.Answer;
import dev.jaakkovirtanen.findandseek.mapobjects.Location;
import java.awt.*;
import static java.awt.Component.LEFT_ALIGNMENT;
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

    }

    public void initializeFrame() {
        frame.getContentPane().removeAll();
        createComponents(frame.getContentPane());
//        frame.setSize(new Dimension(1000, 600));
    }

    private void createComponents(Container container) {
        BoardPanel pelilauta = new BoardPanel(this);
        pelilauta.setPreferredSize(pelilauta.getPrefSize());

        TopMenu topMenu = new TopMenu(this);

        BottomMenu bottomMenu = new BottomMenu(this);

        SidePanel sidePanel = new SidePanel(this);
        sidePanel.setPreferredSize(new Dimension(200, 400));
        container.add(sidePanel, BorderLayout.EAST);
        container.add(topMenu, BorderLayout.NORTH);
        container.add(pelilauta, BorderLayout.CENTER);
        container.add(bottomMenu, BorderLayout.SOUTH);
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

    public void initGame() {
        this.game = new Game();
    }

}
