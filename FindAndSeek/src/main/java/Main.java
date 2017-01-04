
import dev.jaakkovirtanen.findandseek.mapobjects.Player;
import dev.jaakkovirtanen.findandseek.levels.Board;
import dev.jaakkovirtanen.findandseek.levels.Level;
import dev.jaakkovirtanen.findandseek.game.*;
import java.util.Scanner;
import ui.*;

public class Main {

    public static void main(String[] args) {

        Level level = new Level("assets/TxtTestLevel.txt");
        Board lauta = new Board();
        lauta.loadLevel(level);

        GUI gui = new GUI();
        gui.drawGui();
    }
}
