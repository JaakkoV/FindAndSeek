import dev.jaakkovirtanen.findandseek.game.mapobjects.Player;
import dev.jaakkovirtanen.findandseek.game.*;
import dev.jaakkovirtanen.findandseek.game.levels.*;

public class Main {

    public static void main(String[] args) {
        char[][] newLevel1 = new char[][]{
            {'.', '.', '.', '@', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.'}};
        char[][] newLevel2 = new char[][]{
            {'.', '.', '.', '@'},
            {'.', '.', '.', '@'},
            {'.', '.', '.', '@'}};
        
        Level gameLevel = new Level(newLevel1, new Player());
        Game game = new Game(gameLevel);
        game.drawBoard();
        gameLevel.loadLevel(newLevel2);
        game = new Game(gameLevel);
        game.drawBoard();
        
    }
}
