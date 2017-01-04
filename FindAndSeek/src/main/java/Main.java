
import dev.jaakkovirtanen.findandseek.game.*;
import dev.jaakkovirtanen.findandseek.game.levels.*;
import dev.jaakkovirtanen.findandseek.game.mapobjects.*;
import dev.jaakkovirtanen.findandseek.game.movealgorithms.*;
import java.util.Scanner;
import ui.*;

public class Main {

    public static void main(String[] args) {

        Level level = new Level("assets/TxtTestLevel2.txt");
        Board lauta = new Board();
        lauta.loadLevel(level);

        Player peluri = lauta.getPlayer();

        Game peli = new Game();
        peli.loadLevel(level);
        
        GUI gui = new GUI();
        gui.drawGui();
        

        Scanner scanner = new Scanner(System.in);
        System.out.print("liiku (a,s,d,w), vaihda liikkumisalgoritmi painamalla 5 (q,e,z,c): ");
        while (true) {
            char moveChar = scanner.next().charAt(0);
            if (moveChar == '5') {
                peli.changePlayerMoveAlgo();
            }
            peli.executePlayerCommand(moveChar);
            peluri.printLocation();
        }
    }
}
