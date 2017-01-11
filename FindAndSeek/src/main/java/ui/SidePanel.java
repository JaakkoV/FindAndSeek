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
import javax.swing.BoxLayout;
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
    private JLabel playerMoves;

    public SidePanel(GUI gui) {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.gui = gui;
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
        super.paintComponent(grphcs);
        this.setBackground(Color.WHITE);
        setGoalsHit(gui.getGame().getGameBoard().getLevel().getHowManyGoals());
        setOptimalMoves(gui.getGame().getGameBoard().getLevel().getOptimalMoves());
        setCumulativeOptimalMoves(gui.getGame().getGameBoard().getLevel().getOptimalMovesCumulative());
        setPlayerMoves(gui.getGame().getGameBoard().getPlayer().getMovesPerformed());
        repaint();
    }

    private void createComponents() {
        this.goalsHit = new JLabel("Goals: 0");
        add(goalsHit);

        this.optimal = new JLabel("optimal: " + gui.getGame().getGameBoard().getLevel().getOptimalMoves());
        add(optimal);

        this.optimalCumulative = new JLabel("Cumulative optimal " + gui.getGame().getGameBoard().getLevel().getOptimalMovesCumulative());
        add(optimalCumulative);

        this.playerMoves = new JLabel("Moves: 0");
        add(playerMoves);
    }

    public void setPlayerMoves(int playerMoves) {
        this.playerMoves.setText("Moves: " + playerMoves);
    }

    public JLabel getPlayerMoves() {
        return playerMoves;
    }

}
