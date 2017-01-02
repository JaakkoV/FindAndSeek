
import dev.jaakkovirtanen.findandseek.game.*;
import dev.jaakkovirtanen.findandseek.game.levels.*;
import dev.jaakkovirtanen.findandseek.game.mapobjects.*;
import dev.jaakkovirtanen.findandseek.game.movealgorithms.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Level level = new Level("C:\\Users\\User\\Desktop\\javaLabra\\find-and-seek\\FindAndSeek\\src\\main\\java\\dev\\jaakkovirtanen\\findandseek\\game\\levels\\TxtTestLevel.txt");
        Board lauta = new Board();
        lauta.loadLevel(level);

        Player peluri = lauta.getPlayer();

        Game peli = new Game();
        peli.loadLevel(level);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("liiku (a,s,d,w), vaihda liikkumisalgoritmi painamalla 5 (q,e,z,c): ");
            char moveChar = scanner.next().charAt(0);
            if (moveChar == '5') peli.changePlayerMoveAlgo();
            peli.executePlayerCommand(moveChar);
            peluri.printLocation();
        }
    }
}
