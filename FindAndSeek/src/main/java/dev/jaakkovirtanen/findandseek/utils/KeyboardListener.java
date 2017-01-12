package dev.jaakkovirtanen.findandseek.game.utils;

import dev.jaakkovirtanen.findandseek.movealgorithms.*;
import java.awt.event.*;
import dev.jaakkovirtanen.findandseek.ui.BottomMenu;
import dev.jaakkovirtanen.findandseek.ui.GUI;

/**
 *
 * Utility for the application, encapsulated keylistener.
 *
 */
public class KeyboardListener implements KeyListener {

    private final GUI gui;
    private final BottomMenu bottomMenu;

    /**
     * Constructor, which needs gui.
     *
     * @param gui which needs the listener
     */
    public KeyboardListener(GUI gui) {
        this.gui = gui;
        this.bottomMenu = gui.getBottomMenu();
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        checkIfMixedAnswersWanted();
        performKeyTyped(ke);
        checkIfDiagonalMovesSelected();
        gui.repaint();
        checkIfPopUpsWanted();
    }

    private void performKeyTyped(KeyEvent ke) {
        if (bottomMenu.getRoboPlayer().isSelected()) {
            performRoboMove();
        } else {
            /* If RoboMoves not selected, check if moving algo changed 
             * with '5', otherwise try to executePlayerCommand with KeyTyped's char
             */
            char moveChar = ke.getKeyChar();
            if (moveChar == '5') {
                gui.getGame().changePlayerMoveAlgo();
            }
            gui.getGame().executePlayerCommand(moveChar);
        }
    }

    private void performRoboMove() {
        // If moveBehaviour is set to diagonal, robo will change it to cardinal first
        gui.getGame().getGameBoard().getPlayer().changeMoveBehaviour(new MoveCardinal());
        IntelligentPlayer p = new IntelligentPlayer(gui);
        p.makeMoves();
    }

    private void checkIfPopUpsWanted() {
        if (bottomMenu.getIsPopUps().isSelected()) {
            gui.checkGameStatus();
        }
    }

    private void checkIfDiagonalMovesSelected() {
        if (gui.getGame().getGameBoard().getPlayer().getMoveBehaviour().getClass() == MoveDiagonally.class) {
            bottomMenu.changeDiag(true);
        } else {
            bottomMenu.changeDiag(false);
        }
    }

    private void checkIfMixedAnswersWanted() {
        if (bottomMenu.getMixUpAnswers().isSelected()) {
            this.gui.getGame().getGameBoard().setMixAnswers(true);
        } else {
            this.gui.getGame().getGameBoard().setMixAnswers(false);
        }
    }

    @Override
    public void keyPressed(KeyEvent ke) {

    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }
}
