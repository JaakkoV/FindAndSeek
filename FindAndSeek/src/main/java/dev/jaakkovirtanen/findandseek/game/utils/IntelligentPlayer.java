package dev.jaakkovirtanen.findandseek.game.utils;

import dev.jaakkovirtanen.findandseek.game.Game;
import dev.jaakkovirtanen.findandseek.mapobjects.*;
import dev.jaakkovirtanen.findandseek.levels.*;
import ui.GUI;

public class IntelligentPlayer {

    private GUI gui;
    private Game game;
    private Player p;
    private Board b;

    public IntelligentPlayer(GUI gui) {
        this.gui = gui;
        this.game = gui.getGame();
        this.p = gui.getGame().getGameBoard().getPlayer();
        this.b = gui.getGame().getGameBoard();
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
}
