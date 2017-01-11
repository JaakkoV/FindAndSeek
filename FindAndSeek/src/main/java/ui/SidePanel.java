/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import dev.jaakkovirtanen.findandseek.levels.*;
import dev.jaakkovirtanen.findandseek.mapobjects.*;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author User
 */
public class SidePanel extends JPanel {

    private Player p;
    private Level l;
    private JLabel goalsHit;
    private JLabel optimal;
    private JLabel optimalCumulative;
    private JLabel playerMoves;
    private JLabel playerMovesSinceHit;
    private JLabel movesBehindTheOptimal;

    public SidePanel(GUI gui) {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.p = gui.getGame().getGameBoard().getPlayer();
        this.l = gui.getGame().getGameBoard().getLevel();
        createComponents();
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        super.paintComponent(grphcs);
        this.setBackground(Color.WHITE);
        setGoalsHit(l.getHowManyGoals());
        setOptimalMoves(l.getOptimalMoves());
        setCumulativeOptimalMoves(l.getOptimalMovesCumulative());
        setPlayerMoves();
        setPlayerMovesSinceHit();
        setBehindOptimal();
        repaint();
    }

    private void createComponents() {
        this.goalsHit = new JLabel("Goals: 0");
        add(goalsHit);

        this.optimal = new JLabel("optimal: " + l.getOptimalMoves());
        add(optimal);

        this.optimalCumulative = new JLabel("Cumulative optimal 0");
        add(optimalCumulative);

        this.playerMoves = new JLabel("Moves: 0");
        add(playerMoves);

        this.playerMovesSinceHit = new JLabel("Moves from last goal: 0");
        add(playerMovesSinceHit);

        this.movesBehindTheOptimal = new JLabel("You are 0 behind the optimal");
        add(movesBehindTheOptimal);
    }

    public void setGoalsHit(int goalsHit) {
        this.goalsHit.setText("Goals hit: " + goalsHit);
    }

    public void setOptimalMoves(int optimal) {
        this.optimal.setText("Optimal distance to next: " + optimal);
    }

    public void setCumulativeOptimalMoves(int cumuOptimal) {
        this.optimalCumulative.setText("Cumulative optimal " + cumuOptimal);
    }

    public void setPlayerMoves() {
        this.playerMoves.setText("Moves: " + p.getMovesPerformed());
    }

    public void setPlayerMovesSinceHit() {
        this.playerMovesSinceHit.setText("Moves from last Goal: " + p.getMovesSinceHit());
    }

    public void setBehindOptimal() {

        int behindOptimal = (p.getMovesPerformed() - p.getMovesSinceHit()) - l.getOptimalMovesCumulative() + Math.max(0, p.getMovesSinceHit() - l.getOptimalMoves());
        this.movesBehindTheOptimal.setText("You are " + behindOptimal + " behind the optimal");
    }

}
