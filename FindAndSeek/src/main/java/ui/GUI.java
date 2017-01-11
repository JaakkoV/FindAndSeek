package ui;

import dev.jaakkovirtanen.findandseek.levels.*;
import dev.jaakkovirtanen.findandseek.game.*;
import dev.jaakkovirtanen.findandseek.game.utils.IntelligentPlayer;
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
public class GUI implements KeyListener, Runnable {
    
    private Game game;
    private JFrame frame;
    private ArrayList<Level> gameLevels;
    private BottomMenu bottomMenu;
    private TopMenu topMenu;
    SidePanel sidePanel;
    
    public GUI() {
        this.game = new Game();
        String[] levels = {"assets/TxtTestLevel.txt", "assets/TxtTestLevel2.txt", "assets/TxtTestLevel3.txt", "assets/TxtTestLevel4.txt"};
        this.gameLevels = Level.getListOfLevels(levels);
        this.game.loadLevel(gameLevels.get(0));
        this.bottomMenu = new BottomMenu(this);
        this.topMenu = new TopMenu(this);
        this.sidePanel = new SidePanel(this);
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
        
        sidePanel = new SidePanel(this);
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
        if (bottomMenu.getMixUpAnswers().isSelected()) {
            this.game.getGameBoard().setMixAnswers(true);
        } else {
            this.game.getGameBoard().setMixAnswers(false);
        }
        if (bottomMenu.getRoboPlayer().isSelected()) {
            game.getGameBoard().getPlayer().changeMoveBehaviour(new MoveCardinal());
            IntelligentPlayer p = new IntelligentPlayer(this);
            p.makeMoves();
        } else {
            char moveChar = ke.getKeyChar();
            if (moveChar == '5') {
                game.changePlayerMoveAlgo();
            }
            game.executePlayerCommand(moveChar);
        }
        if (game.getGameBoard().getPlayer().getMoveBehaviour().getClass() == MoveDiagonally.class) {
            bottomMenu.changeDiag(true);
        } else {
            bottomMenu.changeDiag(false);
        }
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
