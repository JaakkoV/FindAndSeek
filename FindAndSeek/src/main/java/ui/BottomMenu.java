/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author User
 */
public class BottomMenu extends JPanel implements ActionListener {

    private GUI gui;
    private JComboBox<Integer> levels;
    private JCheckBox mixUpAnswers;
    private JCheckBox roboPlayer;
    private JCheckBox isDiagonal;
    private JCheckBox isPopUps;

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
        } else if (ae.getActionCommand().equals("comboBoxChanged")) {
            gui.initGame();
            gui.getGame().loadLevel(gui.getGameLevels().get((Integer) this.levels.getSelectedItem()));
            this.levels.setSelectedItem(this.levels.getSelectedItem());
            gui.initializeFrame();
        }
    }

    public JCheckBox getRoboPlayer() {
        return roboPlayer;
    }

    public void changeDiag(boolean isDiag) {
        this.isDiagonal.setSelected(isDiag);
    }

    public void setMixUpAnswers(boolean isActive) {
        this.mixUpAnswers.setSelected(isActive);
    }

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
