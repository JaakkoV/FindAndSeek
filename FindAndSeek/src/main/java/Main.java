import dev.jaakkovirtanen.findandseek.game.*;
import dev.jaakkovirtanen.findandseek.game.levels.*;
import dev.jaakkovirtanen.findandseek.game.mapObjects.*;

public class Main {

    public static void main(String[] args) {
        char[][] newLevel1 = new char[][]{
            {'.', '.', '.', '@', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.'}};
        Map map = new Level(newLevel1, new Player());
        char[][] newLevel2 = new char[][]{
            {'.', '.', '.', '@', '.', '.', '.'},
            {'.', '.', '.', '@', '.', '.', '.'},
            {'.', '.', '.', '@', '.', '.', '.'}};
        map.createMap();
        map.changeMap(newLevel2);
        map.createMap();
        
    }
}
