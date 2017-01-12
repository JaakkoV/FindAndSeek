package ui;

import dev.jaakkovirtanen.findandseek.levels.*;
import dev.jaakkovirtanen.findandseek.mapobjects.*;
import java.awt.*;
import javax.swing.*;

public class SidePanel extends JPanel {

    private final Player p;
    private final Level l;
    private JLabel goalsHit;
    private JLabel optimal;
    private JLabel optimalCumulative;
    private JLabel playerMoves;
    private JLabel playerMovesSinceHit;
    private JLabel movesBehindTheOptimal;
    private JLabel percentageOfExtraMoves;

    /**
     * Constructor for SidePanel, needs gui.
     *
     * @param gui Gui, which wants SidePanel to be drawn
     */
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
        setPercentageOfExtraMoves();
        repaint();
    }

    private void createComponents() {
        String stars = "***********************************";
        JLabel empty = new JLabel(stars);

        JLabel gameStats = new JLabel("Game Statistics");
        gameStats.setFont(new Font("Courier New", Font.BOLD, 18));
        add(gameStats);
        add(empty);

        this.goalsHit = new JLabel("Goals: 0");
        add(goalsHit);

        this.playerMoves = new JLabel("Total moves: 0");
        add(playerMoves);

        this.optimalCumulative = new JLabel("Cumulative optimal 0");
        add(optimalCumulative);

        this.playerMovesSinceHit = new JLabel("Moves from last goal: 0");
        add(playerMovesSinceHit);

        this.optimal = new JLabel("optimal: " + l.getOptimalMoves());
        add(optimal);

        this.movesBehindTheOptimal = new JLabel("You are 0 behind the optimal");
        add(movesBehindTheOptimal);
        JLabel secEmpty = new JLabel(stars);
        add(secEmpty);

        JLabel percentageBelowThis = new JLabel("Additional moves %: ");
        percentageBelowThis.setFont(new Font("Courier New", Font.BOLD, 18));
        add(percentageBelowThis);

        this.percentageOfExtraMoves = new JLabel();
        this.percentageOfExtraMoves.setFont(new Font("Courier New", Font.BOLD, 20));
        this.percentageOfExtraMoves.setPreferredSize(new Dimension(100, 100));
        this.percentageOfExtraMoves.setForeground(Color.red);
        add(percentageOfExtraMoves);
        JLabel thirdEmpty = new JLabel(stars);
        add(thirdEmpty);

    }

    /**
     * Asks SidePanel to update GoalsHit-gameStats.
     *
     * GUI uses this
     *
     * @param goalsHit Which number to be set
     */
    public void setGoalsHit(int goalsHit) {
        this.goalsHit.setText("Goals hit: " + goalsHit);
    }

    /**
     * Asks SidePanel to update OptimalMoves-gameStats.
     *
     * GUI uses this
     *
     * @param optimal Which number to be set
     */
    public void setOptimalMoves(int optimal) {
        this.optimal.setText("Optimal distance to next: " + optimal);
    }

    /**
     * Asks SidePanel to update CumulativeOptimal-gameStats.
     *
     * GUI uses this
     *
     * @param cumuOptimal Which number to be set
     */
    public void setCumulativeOptimalMoves(int cumuOptimal) {
        this.optimalCumulative.setText("Cumulative optimal " + cumuOptimal);
    }

    /**
     * Asks SidePanel to update PlayerMoves-gameStats.
     *
     * GUI uses this
     */
    public void setPlayerMoves() {
        this.playerMoves.setText("Moves: " + p.getMovesPerformed());
    }

    /**
     * Asks SidePanel to update playerMovesSinceHit-gameStats.
     *
     * GUI uses this
     */
    public void setPlayerMovesSinceHit() {
        this.playerMovesSinceHit.setText("Moves from last Goal: " + p.getMovesSinceHit());
    }

    /**
     * Asks SidePanel to update BehindOptimal-gameStats.
     *
     * GUI uses this
     */
    public void setBehindOptimal() {
        int behindOptimal = (p.getMovesPerformed() - p.getMovesSinceHit()) - l.getOptimalMovesCumulative() + Math.max(0, p.getMovesSinceHit() - l.getOptimalMoves());
        this.movesBehindTheOptimal.setText("You are " + behindOptimal + " behind the optimal");
    }

    private void setPercentageOfExtraMoves() {
        int behindOptimal = (p.getMovesPerformed() - p.getMovesSinceHit()) - l.getOptimalMovesCumulative() + Math.max(0, p.getMovesSinceHit() - l.getOptimalMoves());
        int playerMovesLoc = p.getMovesPerformed();
        if (playerMovesLoc == 0) {
            this.percentageOfExtraMoves.setText("\n       0,00");
        } else {
            float percentage = (float) behindOptimal / playerMovesLoc * 100;
            this.percentageOfExtraMoves.setText(String.format("\n       %.2f", percentage));
        }
    }
}
