package ui;

import dev.jaakkovirtanen.findandseek.levels.*;
import dev.jaakkovirtanen.findandseek.game.Game;
import dev.jaakkovirtanen.findandseek.mapobjects.Answer;
import dev.jaakkovirtanen.findandseek.mapobjects.Location;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Scanner;
import javax.swing.*;

/**
 * GUI creates JFrame and adds widgets to it to be drawn.
 */
public class GUI implements KeyListener {

    private Game game;
    private JFrame frame;

    /**
     * Draws widgets to the frame.
     *
     * @throws InterruptedException ThreadSleep is used in the method
     */
    public void drawGui() throws InterruptedException {
        Level level = new Level("assets/TxtTestLevel.txt");
        Board lauta = new Board();
        lauta.loadLevel(level);
        this.game = new Game();
        this.game.loadLevel(level);
        innerDrawBoard pelilauta = new innerDrawBoard(this.game.getGameBoard());
        pelilauta.addKeyListener(this);
        DrawTarget goal = new DrawTarget(this.game.getGameBoard());
        JTextArea text = new JTextArea("gfsdakjgölks");
        
        this.frame = new JFrame();
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setLayout(new BorderLayout());

        pelilauta.setPreferredSize(pelilauta.getPrefSize());
        goal.setPreferredSize(goal.getPrefSize());
        this.frame.add(goal, BorderLayout.NORTH);
        this.frame.add(pelilauta, BorderLayout.CENTER);
        this.frame.pack();
//        this.frame.setLocationRelativeTo(null);
        this.frame.setVisible(true);
        pelilauta.requestFocusInWindow();

        System.out.print("liiku (a,s,d,w), vaihda liikkumisalgoritmi painamalla 5 (q,e,z,c): ");
        while (true) {
            if (this.game.isVictory()) {
                System.out.println("YOU WON THE GAME");
                System.out.println("MOVES USED: " + this.game.getGameBoard().getPlayer().getMovesPerformed());
                System.exit(0);
            }
            Thread.sleep(0, 1);
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

    class innerDrawBoard extends JPanel {

        private Board gameboard;
        private Dimension prefSize;
        private Color answerColor;

        /**
         * Constructor for DrawBoard.
         *
         * @param gameboard initialized with gameboard
         */
        public innerDrawBoard(Board gameboard) {
            this.gameboard = gameboard;
            this.prefSize = new Dimension(this.gameboard.getWidth() * 20 + 10, this.gameboard.getHeight() * 20 + 10);
            this.answerColor = Color.WHITE;
        }

        @Override
        public void paintComponent(Graphics g) {
            Graphics2D g2d = (Graphics2D) g;
            int width = this.gameboard.getWidth() * 10;
            int height = this.gameboard.getHeight() * 10;

            int cellWidth = width / (this.gameboard.getWidth()) * 2;
            int cellHeight = height / (this.gameboard.getHeight()) * 2;

            int xOffset = (width - (this.gameboard.getWidth() * cellWidth)) / 1000;
            int yOffset = (height - (this.gameboard.getHeight() * cellHeight)) / 1000;
            for (int i = 0; i < this.gameboard.getHeight(); i++) {
                for (int j = 0; j < this.gameboard.getWidth(); j++) {
                    if (isPlayer(i, j)) {
                        drawRectangle(xOffset, j, cellWidth, yOffset, i, cellHeight, g2d, Color.red);
                    } else if (isAnswer(i, j)) {
                        drawRectangle(xOffset, j, cellWidth, yOffset, i, cellHeight, g2d, this.answerColor);
                    } else {
                        drawRectangle(xOffset, j, cellWidth, yOffset, i, cellHeight, g2d, Color.gray);
                    }
                }
            }
        }

        private void drawRectangle(int xOffset, int j, int cellWidth, int yOffset, int i, int cellHeight, Graphics2D g2d, Color color) {
            Rectangle rectangle = new Rectangle(xOffset + (j * cellWidth), yOffset + (i * cellHeight), cellWidth, cellHeight);
            g2d.setColor(color);
            g2d.fill(rectangle);
            g2d.setColor(Color.black);
            g2d.draw(rectangle);
        }

        private boolean isPlayer(int i, int j) {
            return this.gameboard.getPlayer().getLocation().equals(new Location(i, j));
        }

        private boolean isAnswer(int i, int j) {
            for (Answer a : this.gameboard.getAnswers()) {
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
                case 'X':
                    setAnswerColor(Color.CYAN);
                    break;
                default:
                    setAnswerColor(Color.BLUE);
                    break;
            }
        }

        public Dimension getPrefSize() {
            return prefSize;
        }

        public void setAnswerColor(Color answerColor) {
            this.answerColor = answerColor;
        }

    }

}
