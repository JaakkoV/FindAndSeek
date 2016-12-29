import dev.jaakkovirtanen.findandseek.game.mapObjects.MapObject;
import dev.jaakkovirtanen.findandseek.game.mapObjects.Answer;
import dev.jaakkovirtanen.findandseek.game.mapObjects.Player;
import dev.jaakkovirtanen.findandseek.game.moveAlgorithms.MoveDiagonally;
import dev.jaakkovirtanen.findandseek.game.*;
import dev.jaakkovirtanen.findandseek.game.levels.Level;
import dev.jaakkovirtanen.findandseek.game.levels.Map;

public class Main {

    public static void main(String[] args) {
        char[][] newLevel = new char[][]{
            {'.', '.', '.', '@', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.'}};
        Map map = new Level(newLevel, new Player());
        map.createMap();
        
    }
}
