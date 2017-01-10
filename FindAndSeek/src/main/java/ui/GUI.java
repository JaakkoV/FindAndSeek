package ui;

import dev.jaakkovirtanen.findandseek.levels.*;
import dev.jaakkovirtanen.findandseek.game.Game;
import dev.jaakkovirtanen.findandseek.mapobjects.Answer;
import dev.jaakkovirtanen.findandseek.mapobjects.Location;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        String[] levels = {"assets/TxtTestLevel.txt", "assets/TxtTestLevel2.txt"};
        this.gameLevels = Level.getListOfLevels(levels);
        this.game.loadLevel(gameLevels.get(0));
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
        createComponents(frame.getContentPane());
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

    private void createComponents(Container container) {
        InnerBoard pelilauta = new InnerBoard(this.game.getGameBoard());
        pelilauta.setPreferredSize(pelilauta.getPrefSize());

        InnerNorthMenu northMenu = new InnerNorthMenu();

        InnerSouthMenu southMenu = new InnerSouthMenu();

        container.add(northMenu, BorderLayout.NORTH);
        container.add(pelilauta, BorderLayout.CENTER);
        container.add(southMenu, BorderLayout.SOUTH);
        frame.setFocusable(true);
        this.frame.pack();
        frame.addKeyListener(this);
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

    private void drawRectangle(int xOffset, int j, int cellWidth, int yOffset, int i, int cellHeight, Graphics2D g2d, Color color) {
        Rectangle rectangle = new Rectangle(xOffset + (j * cellWidth), yOffset + (i * cellHeight), cellWidth, cellHeight);
        g2d.setColor(color);
        g2d.fill(rectangle);
        g2d.setColor(Color.black);
        g2d.draw(rectangle);
    }

    private boolean isPlayer(int i, int j) {
        return game.getGameBoard().getPlayer().getLocation().equals(new Location(i, j));
    }

    private boolean isAnswer(int i, int j) {
        for (Answer a : game.getGameBoard().getAnswers()) {
            if (a.getLocation().equals(new Location(i, j))) {
                charToColor(a.getValue());
                return true;
            }
        }
        return false;
    }

    private void charToColor(char c) {
        switch (c) {
            case 'A':
                setAnswerColor(Color.BLUE);
                break;
            case 'B':
                setAnswerColor(Color.GREEN);
                break;
            case 'C':
                setAnswerColor(Color.PINK);
                break;
            case 'D':
                setAnswerColor(Color.ORANGE);
                break;
            case 'E':
                setAnswerColor(Color.YELLOW);
                break;
            case 'F':
                setAnswerColor(Color.MAGENTA);
                break;
            case 'X':
                setAnswerColor(Color.CYAN);
                break;
            default:
                setAnswerColor(Color.BLUE);
                break;
        }
    }

    private void setAnswerColor(Color answerColor) {
        this.answerColor = answerColor;
    }

    class InnerBoard extends JPanel {

        private Dimension prefSize;

        /**
         * Constructor for DrawBoard.
         *
         * @param gameboard initialized with gameboard
         */
        public InnerBoard(Board gameboard) {
            this.prefSize = new Dimension(game.getGameBoard().getWidth() * 20 + 10, game.getGameBoard().getHeight() * 20 + 10);
            answerColor = Color.WHITE;
        }

        @Override
        public void paintComponent(Graphics g) {
            Graphics2D g2d = (Graphics2D) g;
            int width = game.getGameBoard().getWidth() * 10;
            int height = game.getGameBoard().getHeight() * 10;

            int cellWidth = width / (game.getGameBoard().getWidth()) * 2;
            int cellHeight = height / (game.getGameBoard().getHeight()) * 2;

            int xOffset = (width - (game.getGameBoard().getWidth() * cellWidth)) / 1000;
            int yOffset = (height - (game.getGameBoard().getHeight() * cellHeight)) / 1000;
            for (int i = 0; i < game.getGameBoard().getHeight(); i++) {
                for (int j = 0; j < game.getGameBoard().getWidth(); j++) {
                    if (isPlayer(i, j)) {
                        drawRectangle(xOffset, j, cellWidth, yOffset, i, cellHeight, g2d, Color.red);
                    } else if (isAnswer(i, j)) {
                        drawRectangle(xOffset, j, cellWidth, yOffset, i, cellHeight, g2d, answerColor);
                    } else {
                        drawRectangle(xOffset, j, cellWidth, yOffset, i, cellHeight, g2d, Color.gray);
                    }
                }
            }
        }

        public Dimension getPrefSize() {
            return prefSize;
        }

    }

    class InnerTarget extends JPanel {

        private Dimension prefSize;

        /**
         * Constructor for DrawBoard.
         *
         * @param gameboard initialized with gameboard
         */
        public InnerTarget(Board gameboard) {
            this.prefSize = new Dimension(30, 30);
        }

        @Override
        public void paintComponent(Graphics g) {
            Graphics2D g2d = (Graphics2D) g;
            for (Answer a : game.getGameBoard().getAnswers()) {
                if (isAnswerGoal(a.getRow(), a.getCol())) {
                    drawRectangle(0, 0, 25, 0, 0, 25, g2d, answerColor);
                }
            }
        }

        private boolean isAnswerGoal(int i, int j) {
            for (Answer a : game.getGameBoard().getAnswers()) {
                if (a.getLocation().equals(new Location(i, j))) {
                    if (a.isTarget()) {
                        charToColor(a.getValue());
                        return true;
                    }
                }
            }
            return false;
        }

        public Dimension getPrefSize() {
            return prefSize;
        }
    }

    class InnerSouthMenu extends JPanel implements ActionListener {

        private JLabel playerMoves;
        JComboBox<Level> levels;

        public InnerSouthMenu() {
            super(new GridLayout(1, 3));
            createComponents();
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

        private void createComponents() {
            levels = new JComboBox<>();
            for (Level level : gameLevels) {
                levels.addItem(level);
            }
            levels.addActionListener(this);
            add(levels);

            this.playerMoves = new JLabel("Moves: 0", SwingConstants.CENTER);
            add(playerMoves);

            JButton exit = new JButton("Exit");
            exit.addActionListener(this);
            add(exit);
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            game.loadLevel((Level) this.levels.getSelectedItem());
            createComponents();
            run();
        }

    }

    class InnerNorthMenu extends JPanel {

        private JLabel goalsHit;

        public InnerNorthMenu() {
            super(new GridLayout(1, 3));
            createComponents();
        }

        public void setGoalsHit(int goalsHit) {
            this.goalsHit.setText("Goals: " + goalsHit);
        }

        @Override
        protected void paintComponent(Graphics grphcs) {
            setGoalsHit(game.getHowManyGoals());
        }

        private void createComponents() {
            this.goalsHit = new JLabel("Goals: 0");
            add(goalsHit);

            InnerTarget targetti = new InnerTarget(game.getGameBoard());
            targetti.setPreferredSize(targetti.getPrefSize());
            add(targetti);
            JLabel optimal = new JLabel("optimal: 15");
            add(optimal);
        }

    }
}
