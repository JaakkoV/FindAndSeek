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

        UpperMenu northMenu = new UpperMenu(this);

        InnerSouthMenu southMenu = new InnerSouthMenu();

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

    class InnerSouthMenu extends JPanel implements ActionListener {

        private JLabel playerMoves;
        JComboBox<Integer> levels;
        JCheckBox mixUpAnswers;

        public InnerSouthMenu() {
            super(new GridLayout(1, 3));
            mixUpAnswers = new JCheckBox("Mix Answers?");
            mixUpAnswers.setSelected(false);
            innerCreateComponents();
        }

        public void setPlayerMoves(int playerMoves) {
            this.playerMoves.setText("Moves: " + playerMoves);
        }

        public JLabel getPlayerMoves() {
            return playerMoves;
        }

        @Override
        protected void paintComponent(Graphics grphcs) {
            setPlayerMoves(game.getGameBoard().getPlayer().getMovesPerformed());
        }

        private void innerCreateComponents() {
            JLabel level = new JLabel("Level: ");
            add(level);
            levels = new JComboBox<>();
            for (int i = 0; i < gameLevels.size(); i++) {
                levels.addItem(i);
            }
            levels.addActionListener(this);
            add(levels);

            mixUpAnswers.addItemListener(new ItemListener() {
                public void itemStateChanged(ItemEvent e) {
                    if (e.getStateChange() == 1) {
                        game.getGameBoard().setMixAnswers(true);
                        initializeFrame();
                    } else {
                        game.getGameBoard().setMixAnswers(false);
                    }
                }
            });

            add(mixUpAnswers);
            this.playerMoves = new JLabel("Moves: 0");
            add(playerMoves);

            JButton exit = new JButton("Exit");
            exit.addActionListener(this);
            add(exit);
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            if (ae.getActionCommand().equals("Exit")) {
                System.exit(0);
            } else if (ae.getActionCommand().equals("comboBoxChanged")) {
                game = new Game();
                game.loadLevel(gameLevels.get((Integer) this.levels.getSelectedItem()));
                this.levels.setSelectedItem(this.levels.getSelectedItem());
                initializeFrame();
            }
        }
    }

}
