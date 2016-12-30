
import dev.jaakkovirtanen.findandseek.game.mapobjects.Player;
import dev.jaakkovirtanen.findandseek.game.*;
import dev.jaakkovirtanen.findandseek.game.levels.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//        char[][] newLevel1 = new char[][]{
//            {'.', '.', '.', '@', '.', '.', '.'},
//            {'.', '.', '.', '.', '.', '.', '.'},
//            {'.', '.', '.', '.', '.', '.', '.'}};
//        char[][] newLevel2 = new char[][]{
//            {'.', '.', '.', '@'},
//            {'.', '.', '.', '@'},
//            {'.', '.', '.', '@'}};
//        
//        Level gameLevel = new Level(newLevel1, new Player());
//        Game game = new Game(gameLevel);
//        game.drawBoard();
//        gameLevel.loadLevel(newLevel2);
//        game = new Game(gameLevel);
//        game.drawBoard();

        Player pelaaja = new Player();
        System.out.println(pelaaja.getCol());
        System.out.println(pelaaja.getRow());
        pelaaja.performMove('w');
        System.out.println(pelaaja.getCol());
        System.out.println(pelaaja.getRow());

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("liiku: ");
            char moveChar = scanner.next().charAt(0);
            pelaaja.performMove(moveChar);
            System.out.println(pelaaja.getCol());
            System.out.println(pelaaja.getRow());

        }
    }
}
