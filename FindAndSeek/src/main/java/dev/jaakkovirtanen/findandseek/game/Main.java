package dev.jaakkovirtanen.findandseek.game;

import ui.*;

public class Main {

    /**
     * place to start the game.
     *
     * @param args no args needed
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        GUI gui = new GUI();
        PopUpWindow wndw = new PopUpWindow();
        wndw.messageWindow("gfjasodgjoi");
        wndw.congratsWindow(10);
        gui.run();
    }
}
