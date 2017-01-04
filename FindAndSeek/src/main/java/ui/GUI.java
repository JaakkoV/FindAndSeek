package ui;

import dev.jaakkovirtanen.findandseek.levels.Board;
import dev.jaakkovirtanen.findandseek.levels.Level;
import dev.jaakkovirtanen.findandseek.game.Game;
import java.awt.*;
import java.util.Scanner;
import javax.swing.*;

public class GUI {

    public void drawGui() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.getContentPane().add(box);
//        frame.getContentPane().add(button);
        frame.setSize(400, 430);
//        StartScreen paneeli = new StartScreen();
//        frame.getContentPane().add(paneeli);

        Level level = new Level("assets/TxtTestLevel.txt");
        Board lauta = new Board();
        lauta.loadLevel(level);
        Game peli = new Game();
        peli.loadLevel(level);
        DrawBoard pelilauta = new DrawBoard(peli.getGameBoard());

        frame.setLayout(new BorderLayout());
        frame.getContentPane().add(pelilauta);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        Scanner scanner = new Scanner(System.in);

        System.out.print("liiku (a,s,d,w), vaihda liikkumisalgoritmi painamalla 5 (q,e,z,c): ");
        while (true) {
            if (peli.isVictory()) {
                System.out.println("YOU WON THE GAME");
                System.out.println("MOVES USED: " + peli.getGameBoard().getPlayer().getMovesPerformed());
                System.exit(0);
            }
            char moveChar = scanner.next().charAt(0);
            if (moveChar == '5') {
                peli.changePlayerMoveAlgo();
            }
            peli.executePlayerCommand(moveChar);
        }
    }
}
