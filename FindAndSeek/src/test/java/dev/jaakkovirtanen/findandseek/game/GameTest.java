package dev.jaakkovirtanen.findandseek.game;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import dev.jaakkovirtanen.findandseek.game.*;
import dev.jaakkovirtanen.findandseek.levels.*;
import dev.jaakkovirtanen.findandseek.mapobjects.*;
import dev.jaakkovirtanen.findandseek.movealgorithms.MoveCardinal;
import dev.jaakkovirtanen.findandseek.movealgorithms.MoveDiagonally;

/**
 *
 * @author User
 */
public class GameTest {

    private Game game;
    private Level setUpLevel;

    public GameTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        this.setUpLevel = new Level("assets/TxtTestLevel.txt");
        this.game = new Game();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void constructorBoard() {
        assertEquals(Board.class, this.game.getGameBoard().getClass());
    }

    @Test
    public void loadLevel() {
        this.game.loadLevel(setUpLevel);
        assertEquals(this.setUpLevel, this.game.getGameBoard().getLevel());
    }

    @Test
    public void changePlayerMoveAlgo() {
        this.game.loadLevel(setUpLevel);
        this.game.changePlayerMoveAlgo();
        assertEquals(MoveDiagonally.class, this.game.getGameBoard().getPlayer().getMoveBehaviour().getClass());
        this.game.changePlayerMoveAlgo();
        assertEquals(MoveCardinal.class, this.game.getGameBoard().getPlayer().getMoveBehaviour().getClass());
    }

    @Test
    public void executePlayerCommand() {
        this.game.loadLevel(setUpLevel);
        Location expected = new Location(this.game.getGameBoard().getPlayer().getLocation().getRow() + 1, this.game.getGameBoard().getPlayer().getLocation().getCol());
        this.game.executePlayerCommand('s');
        assertEquals(true, expected.equals(this.game.getGameBoard().getPlayer().getLocation()));
    }

}
