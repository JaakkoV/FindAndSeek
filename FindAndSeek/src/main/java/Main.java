
import dev.jaakkovirtanen.findandseek.game.*;
import dev.jaakkovirtanen.findandseek.game.levels.*;
import dev.jaakkovirtanen.findandseek.game.mapobjects.*;
import dev.jaakkovirtanen.findandseek.game.movealgorithms.MoveBehaviour;
import dev.jaakkovirtanen.findandseek.game.movealgorithms.MoveDiagonally;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


//        System.out.println("Pelaajan sijainti\nSarake: " + peluri.getCol() + "\nRivi: " + peluri.getRow());
//        System.out.println("pelilaudan korkeus on: " + pelilauta.getHeight());
//        System.out.println("pelilaudan leveys on: " + pelilauta.getWidth());
//
//        Scanner scanner = new Scanner(System.in);
//        while (true) {
//            System.out.println("liiku (a,s,d,w): ");
//            char moveChar = scanner.next().charAt(0);
//            peluri.performMove(moveChar);
//            pelilauta.drawBoard();
//            System.out.print(peluri.getCol() + " : ");
//            System.out.println(peluri.getRow());
//        }
        Level level = new Level("C:\\Users\\User\\Desktop\\javaLabra\\find-and-seek\\FindAndSeek\\src\\main\\java\\dev\\jaakkovirtanen\\findandseek\\game\\levels\\TxtTestLevel.txt");
        Board lauta = new Board();
        lauta.loadLevel(level);
        lauta.initPlayer();
        lauta.getPlayer().printLocation();
        lauta.setPlayer(new Player(new Location(4,1), new MoveDiagonally()));
        lauta.getPlayer().printLocation();
        
        for (BoardObject b : level.getBoardObjects()) {
            if(b.getClass() == Player.class) {
                b.printLocation();
            }
        }
        
        System.out.println("ANSWERS: ");
        lauta.initAnswers();
        for (BoardObject b : lauta.getAnswers()) {
            System.out.println(b);
            if(b.getClass() == Answer.class) {
                System.out.println(b.getLocation().equals(lauta.getPlayer().getLocation()));
            }
        }
        
    }
}
