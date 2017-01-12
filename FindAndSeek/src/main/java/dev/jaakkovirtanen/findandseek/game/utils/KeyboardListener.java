package dev.jaakkovirtanen.findandseek.game.utils;

import dev.jaakkovirtanen.findandseek.movealgorithms.*;
import java.awt.event.*;
import ui.BottomMenu;
import ui.GUI;

/**
 *
 * @author User
 */
public class KeyboardListener implements KeyListener {

    private GUI gui;
    private BottomMenu bottomMenu;

    public KeyboardListener(GUI gui) {
        this.gui = gui;
        this.bottomMenu = gui.getBottomMenu();
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        if (bottomMenu.getMixUpAnswers().isSelected()) {
            this.gui.getGame().getGameBoard().setMixAnswers(true);
        } else {
            this.gui.getGame().getGameBoard().setMixAnswers(false);
        }
        if (bottomMenu.getRoboPlayer().isSelected()) {
            gui.getGame().getGameBoard().getPlayer().changeMoveBehaviour(new MoveCardinal());
            IntelligentPlayer p = new IntelligentPlayer(gui);
            p.makeMoves();
        } else {
            char moveChar = ke.getKeyChar();
            if (moveChar == '5') {
                gui.getGame().changePlayerMoveAlgo();
            }
            gui.getGame().executePlayerCommand(moveChar);
        }
        if (gui.getGame().getGameBoard().getPlayer().getMoveBehaviour().getClass() == MoveDiagonally.class) {
            bottomMenu.changeDiag(true);
        } else {
            bottomMenu.changeDiag(false);
        }
        gui.repaint();
        if (bottomMenu.getIsPopUps().isSelected()) {
            gui.checkGameStatus();
        }
    }

    @Override
    public void keyPressed(KeyEvent ke) {

    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }
}
