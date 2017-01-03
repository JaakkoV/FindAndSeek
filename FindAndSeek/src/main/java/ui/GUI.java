package ui;

import dev.jaakkovirtanen.findandseek.game.Game;
import dev.jaakkovirtanen.findandseek.game.levels.*;
import java.awt.*;
import java.util.Scanner;
import javax.swing.*;

public class GUI {

    public void drawGui() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.getContentPane().add(box);
//        frame.getContentPane().add(button);
        frame.setSize(400, 400);
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

        while (true) {
            char moveChar = scanner.next().charAt(0);
            if (moveChar == '5') {
                peli.changePlayerMoveAlgo();
            }
            peli.executePlayerCommand(moveChar);
            frame.repaint();
        }
    }
}
