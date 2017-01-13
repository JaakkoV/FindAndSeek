package dev.jaakkovirtanen.findandseek.utils;

import dev.jaakkovirtanen.findandseek.game.Game;
import dev.jaakkovirtanen.findandseek.mapobjects.*;
import dev.jaakkovirtanen.findandseek.levels.*;
import dev.jaakkovirtanen.findandseek.ui.GUI;

/**
 * This class provides ai-player, which is dump and moves only cardinally.
 *
 * Class can be extended to provide more intelligent gameplays
 *
 */
public class IntelligentPlayer {

    private GUI gui;
    private Game game;
    private Player p;
    private Board b;

    /**
     * Constructor for ai-player, needs gui.
     *
     * @param gui current gui, which needs ai-player
     */
    public IntelligentPlayer(GUI gui) {
        this.gui = gui;
        this.game = gui.getGame();
        this.p = gui.getGame().getGameBoard().getPlayer();
        this.b = gui.getGame().getGameBoard();
    }

    /**
     * Performs moves in game.
     *
     * This is called in ver 1.0. from keyListener
     */
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
}
