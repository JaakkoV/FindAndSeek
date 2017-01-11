/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import dev.jaakkovirtanen.findandseek.levels.Board;
import dev.jaakkovirtanen.findandseek.mapobjects.Answer;
import dev.jaakkovirtanen.findandseek.mapobjects.Location;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author User
 */
public class SidePanel extends JPanel {

    private GUI gui;
    private JLabel goalsHit;
    private JLabel optimal;
    private JLabel optimalCumulative;
    private RectangleDrawing rectum;

    public SidePanel(GUI gui) {
//        super(new GridLayout(1, 3));
        this.gui = gui;
        this.rectum = new RectangleDrawing(gui.getGame());
        createComponents();
    }

    public void setGoalsHit(int goalsHit) {
        this.goalsHit.setText("Goals: " + goalsHit);
    }

    public void setOptimalMoves(int optimal) {
        this.optimal.setText("optimal " + optimal);
    }

    public void setCumulativeOptimalMoves(int cumuOptimal) {
        this.optimalCumulative.setText("cumulative optimal " + cumuOptimal);
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        setGoalsHit(gui.getGame().getGameBoard().getLevel().getHowManyGoals());
        setOptimalMoves(gui.getGame().getGameBoard().getLevel().getOptimalMoves());
        setCumulativeOptimalMoves(gui.getGame().getGameBoard().getLevel().getOptimalMovesCumulative());
        repaint();
    }

    private void createComponents() {
        this.goalsHit = new JLabel("Goals: 0");
        add(goalsHit);

        InnerTarget targetti = new InnerTarget(gui.getGame().getGameBoard());
        targetti.setPreferredSize(targetti.getPrefSize());
        add(targetti);

        this.optimal = new JLabel("optimal: " + gui.getGame().getGameBoard().getLevel().getOptimalMoves());
        add(optimal);

        this.optimalCumulative = new JLabel("Cumulative optimal " + gui.getGame().getGameBoard().getLevel().getOptimalMovesCumulative());
        add(optimalCumulative);
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
            for (Answer a : gui.getGame().getGameBoard().getAnswers()) {
                if (isAnswerGoal(a.getRow(), a.getCol())) {
                    RectangleDrawing.drawRectangle(0, 0, 25, 0, 0, 25, g2d, RectangleDrawing.charToColor(a.getValue()));
                }
            }
        }

        private boolean isAnswerGoal(int i, int j) {
            for (Answer a : gui.getGame().getGameBoard().getAnswers()) {
                if (a.getLocation().equals(new Location(i, j))) {
                    if (a.isTarget()) {
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

}
