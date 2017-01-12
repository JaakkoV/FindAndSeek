package dev.jaakkovirtanen.findandseek.ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BottomMenu extends JPanel implements ActionListener {

    private final GUI gui;
    private final JComboBox<Integer> levels;
    private final JCheckBox mixUpAnswers;
    private final JCheckBox roboPlayer;
    private final JCheckBox isDiagonal;
    private final JCheckBox isPopUps;

    /**
     * Constructor for bottom menupanel to be added to gui.
     *
     * @param gui Gui, which wants bottom menu to be drawn
     */
    public BottomMenu(GUI gui) {
        super(new GridLayout(1, 3));
        this.gui = gui;
        mixUpAnswers = new JCheckBox("Mix Answers?");
        mixUpAnswers.setSelected(false);
        roboPlayer = new JCheckBox("Roboplayer?");
        isDiagonal = new JCheckBox("Diagonal Moves?");
        isPopUps = new JCheckBox("Pop Ups?");
        isPopUps.setSelected(true);
        levels = new JComboBox<>();
        createComponents();
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
    }

    private void createComponents() {
        JLabel level = new JLabel("Level: ");
        add(level);

        for (int i = 0; i < gui.getGameLevels().size(); i++) {
            levels.addItem(i);
        }
        levels.addActionListener(this);
        levels.setFocusable(false);
        add(levels);

        mixUpAnswers.setFocusable(false);
        add(mixUpAnswers);

        roboPlayer.setFocusable(false);
        add(roboPlayer);

        isPopUps.setFocusable(false);
        add(isPopUps);

        isDiagonal.setEnabled(false);
        add(isDiagonal);

        JButton exit = new JButton("Exit");
        exit.setFocusable(false);
        exit.addActionListener(this);
        add(exit);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("Exit")) {
            System.exit(0);
        } else if (ae.getSource().equals(levels)) {
            gui.initGame();
            gui.getGame().loadLevel(gui.getGameLevels().get((Integer) this.levels.getSelectedItem()));
            this.levels.setSelectedItem(this.levels.getSelectedItem());
            gui.initializeFrame();
        }
    }

    /**
     * Returns checkbox to see if robo wanted.
     *
     * @return Checkbox roboplayer
     */
    public JCheckBox getRoboPlayer() {
        return roboPlayer;
    }

    /**
     * Change checkbox isDiagonal, if diagonal moves are wanted / not.
     *
     * @param isDiag Boolean if diagonal movement is wanted
     */
    public void changeDiag(boolean isDiag) {
        this.isDiagonal.setSelected(isDiag);
    }

    /**
     * Set if mixed answers are wanted.
     *
     * @param isActive Boolean if mixed answers are wanted
     */
    public void setMixUpAnswers(boolean isActive) {
        this.mixUpAnswers.setSelected(isActive);
    }

    /**
     * Set if robo moves are wanted.
     *
     * @param isActive Boolean if robo moves are wanted
     */
    public void setRoboPlayer(boolean isActive) {
        this.roboPlayer.setSelected(isActive);
    }

    public JCheckBox getMixUpAnswers() {
        return mixUpAnswers;
    }

    public JCheckBox getIsPopUps() {
        return isPopUps;
    }

}
