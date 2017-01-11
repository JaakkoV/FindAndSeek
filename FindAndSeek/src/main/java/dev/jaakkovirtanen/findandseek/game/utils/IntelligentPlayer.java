package dev.jaakkovirtanen.findandseek.game.utils;

import dev.jaakkovirtanen.findandseek.game.Game;
import dev.jaakkovirtanen.findandseek.mapobjects.*;
import dev.jaakkovirtanen.findandseek.levels.*;
import java.util.logging.Logger;
import ui.GUI;

public class IntelligentPlayer implements Runnable {

    private GUI gui;
    private Game game;
    private Player p;
    private Board b;
    private boolean onOff = false;

    public IntelligentPlayer(GUI gui) {
        this.gui = gui;
        this.game = gui.getGame();
        this.p = gui.getGame().getGameBoard().getPlayer();
        this.b = gui.getGame().getGameBoard();
    }

    @Override
    public void run() {
        while (onOff) {
            makeMoves();
            gui.initializeFrame();
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(IntelligentPlayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
        }
    }

    public void makeMoves() {
        if (p.getRow() > b.getTargetAnswer().getRow()) {
            game.executePlayerCommand('w');
        } else if (p.getRow() < b.getTargetAnswer().getRow()) {
            game.executePlayerCommand('s');
        } else if (p.getCol() > b.getTargetAnswer().getCol()) {
            game.executePlayerCommand('a');
        } else if (p.getCol() < b.getTargetAnswer().getCol()) {
            game.executePlayerCommand('d');
        }
    }

    public void setOnOff(boolean onOff) {
        this.onOff = onOff;
    }
}
