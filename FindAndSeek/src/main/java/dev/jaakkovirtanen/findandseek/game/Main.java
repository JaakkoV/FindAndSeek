package dev.jaakkovirtanen.findandseek.game;

import dev.jaakkovirtanen.findandseek.mapobjects.Player;
import dev.jaakkovirtanen.findandseek.levels.Board;
import dev.jaakkovirtanen.findandseek.levels.Level;
import dev.jaakkovirtanen.findandseek.game.*;
import java.util.Scanner;
import ui.*;

public class Main {

    /**
     * place to start the game.
     * @param args no args needed
     * @throws InterruptedException 
     */
    public static void main(String[] args) throws InterruptedException {
        GUI gui = new GUI();
        gui.drawGui();
    }
}
