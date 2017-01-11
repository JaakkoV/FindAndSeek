/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import dev.jaakkovirtanen.findandseek.game.Game;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author User
 */
public class BottomMenu extends JPanel implements ActionListener, ItemListener {

    private GUI gui;
    private JComboBox<Integer> levels;
    private JCheckBox mixUpAnswers;

    public BottomMenu(GUI gui) {
        super(new GridLayout(1, 3));
        this.gui = gui;
        mixUpAnswers = new JCheckBox("Mix Answers?");
        mixUpAnswers.setSelected(false);
        createComponents();
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
    }

    private void createComponents() {
        JLabel level = new JLabel("Level: ");
        add(level);
        levels = new JComboBox<>();
        for (int i = 0; i < gui.getGameLevels().size(); i++) {
            levels.addItem(i);
        }
        levels.addActionListener(this);
        levels.setFocusable(false);
        add(levels);

        mixUpAnswers.addItemListener(this);
        mixUpAnswers.setFocusable(false);
        add(mixUpAnswers);

        JButton exit = new JButton("Exit");
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

    @Override
    public void itemStateChanged(ItemEvent ie) {
        if (ie.getStateChange() == 1) {
            gui.getGame().getGameBoard().setMixAnswers(true);
            mixUpAnswers.setSelected(true);
        } else {
            mixUpAnswers.setSelected(false);
            gui.getGame().getGameBoard().setMixAnswers(false);
        }

    }
}
