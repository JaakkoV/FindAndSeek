package ui;

import dev.jaakkovirtanen.findandseek.levels.*;
import dev.jaakkovirtanen.findandseek.game.*;
import dev.jaakkovirtanen.findandseek.game.utils.IntelligentPlayer;
import dev.jaakkovirtanen.findandseek.game.utils.KeyboardListener;
import dev.jaakkovirtanen.findandseek.mapobjects.*;
import dev.jaakkovirtanen.findandseek.movealgorithms.MoveCardinal;
import dev.jaakkovirtanen.findandseek.movealgorithms.MoveDiagonally;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.logging.Logger;
import javax.swing.*;

/**
 * GUI creates JFrame and adds widgets to it to be drawn.
 */
public class GUI implements Runnable {

    private Game game;
    private JFrame frame;
    private ArrayList<Level> gameLevels;
    private static KeyboardListener keyListener;
    private BottomMenu bottomMenu;
    private TopMenu topMenu;
    private SidePanel sidePanel;

    public GUI() {
        this.game = new Game();
        String[] levels = {"assets/TxtTestLevel.txt", "assets/TxtTestLevel2.txt", "assets/TxtTestLevel3.txt", "assets/TxtTestLevel4.txt", "assets/TxtTestLevel5.txt"};
        this.gameLevels = Level.getListOfLevels(levels);
        this.game.loadLevel(gameLevels.get(0));
        this.bottomMenu = new BottomMenu(this);
        this.topMenu = new TopMenu(this);
        this.sidePanel = new SidePanel(this);
        keyListener = new KeyboardListener(this);
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
        frame.addKeyListener(keyListener);
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

        sidePanel = new SidePanel(this);
        sidePanel.setPreferredSize(new Dimension(250, 400));

        sidePanel.setFocusable(false);
        topMenu.setFocusable(false);
        pelilauta.setFocusable(false);
        bottomMenu.setFocusable(false);

        container.add(sidePanel, BorderLayout.EAST);
        container.add(topMenu, BorderLayout.NORTH);
        container.add(pelilauta, BorderLayout.CENTER);
        container.add(bottomMenu, BorderLayout.SOUTH);

        frame.setFocusable(true);
        frame.pack();
        frame.repaint();
    }

    public void repaint() {
        frame.repaint();
        frame.requestFocus();
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

    public BottomMenu getBottomMenu() {
        return bottomMenu;
    }
}
