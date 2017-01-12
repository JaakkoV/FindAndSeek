package dev.jaakkovirtanen.findandseek.game;

import dev.jaakkovirtanen.findandseek.ui.GUI;

public class Main {

    /**
     * place to start the game.
     *
     * @param args no args needed
     * @throws InterruptedException
     */
    public static void main(String[] args) {
        GUI gui = new GUI();
        gui.run();
    }
}
