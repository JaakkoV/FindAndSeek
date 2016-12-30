
import dev.jaakkovirtanen.findandseek.game.*;
import dev.jaakkovirtanen.findandseek.game.levels.*;
import dev.jaakkovirtanen.findandseek.game.mapobjects.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        BoardObject peluri = new Player();
        BoardObject vastaus = new Answer();
        Board pelilauta = new Level(5, 8, peluri, vastaus);

        pelilauta.drawBoard();

        System.out.println("Pelaajan sijainti\nSarake: " + peluri.getCol() + "\nRivi: " + peluri.getRow());
        System.out.println("pelilaudan korkeus on: " + pelilauta.getHeight());
        System.out.println("pelilaudan leveys on: " + pelilauta.getWidth());

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("liiku (a,s,d,w): ");
            char moveChar = scanner.next().charAt(0);
            peluri.performMove(moveChar);
            pelilauta.drawBoard();
            System.out.print(peluri.getCol() + " : ");
            System.out.println(peluri.getRow());
        }
    }
}
