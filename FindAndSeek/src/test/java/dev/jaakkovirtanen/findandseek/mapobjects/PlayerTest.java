package dev.jaakkovirtanen.findandseek.mapobjects;

import dev.jaakkovirtanen.findandseek.mapobjects.Player;
import dev.jaakkovirtanen.findandseek.mapobjects.BoardObject;
import dev.jaakkovirtanen.findandseek.mapobjects.Location;
import dev.jaakkovirtanen.findandseek.movealgorithms.MoveBehaviour;
import dev.jaakkovirtanen.findandseek.movealgorithms.MoveCardinal;
import dev.jaakkovirtanen.findandseek.movealgorithms.MoveDiagonally;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PlayerTest {

    private Player player;

    public PlayerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        Location location = new Location (3, 1);
        MoveBehaviour moveBehaviour = new MoveCardinal();
        this.player = new Player(location, moveBehaviour);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void playerConstructor() {
        BoardObject b = new Player (new Location(3,4), new MoveCardinal());
        Player p = (Player) b;
        assertEquals(true, new Location(3,4).equals(p.getLocation()));
        assertEquals(new MoveCardinal().getClass(), p.getMoveBehaviour().getClass());
    }

    @Test
    public void getCol() {
        assertEquals(1, this.player.getCol());
    }

    @Test
    public void getRow() {
        assertEquals(3, this.player.getRow());
    }

    @Test
    public void getMoveBehaviour() {
        assertEquals(MoveCardinal.class, this.player.getMoveBehaviour().getClass());
    }

    @Test
    public void changeMoveBehaviour() {
        MoveBehaviour expected = new MoveDiagonally();
        this.player.changeMoveBehaviour(expected);
        assertEquals(expected.getClass(), player.moveBehaviour.getClass());
    }
    
    @Test
    public void isCloneSame() {
        Player clone = this.player.getClonePlayer();
        assertEquals(false, this.player == clone);
        assertEquals(this.player.getCol(), clone.getCol());
        assertEquals(this.player.getRow(), clone.getRow());
    }

    @Test
    public void getMovesPerformed() {
        this.player.performMove('s');
        assertEquals(1, this.player.getMovesPerformed());
    }
    
    @Test
    public void setMovesPerformed() {
        this.player.performMove('s');
        this.player.setMovesPerformed(5);
        assertEquals(5, this.player.getMovesPerformed());
    }
    
    @Test
    public void setLocation() {
        Location expectedLocation = new Location(13,33);
        this.player.setLocation(expectedLocation);
        assertEquals(expectedLocation, this.player.getLocation());
    }
    
       
    @Test
    public void performMoveW() {
        this.player.setLocation(new Location(1,1));
        this.player.performMove('w');
        assertEquals(0, this.player.getRow());
        assertEquals(1, this.player.getCol());
    }
    @Test
    public void performMoveD() {
        this.player.setLocation(new Location(1,1));
        this.player.performMove('d');
        assertEquals(1, this.player.getRow());
        assertEquals(2, this.player.getCol());
    }
    @Test
    public void performMoveS() {
        this.player.setLocation(new Location(1,1));
        this.player.performMove('s');
        assertEquals(2, this.player.getRow());
        assertEquals(1, this.player.getCol());
    }
    @Test
    public void performMoveA() {
        this.player.setLocation(new Location(1,1));
        this.player.performMove('a');
        assertEquals(1, this.player.getRow());
        assertEquals(0, this.player.getCol());
    }
    @Test
    public void performMoveQ() {
        this.player.changeMoveBehaviour(new MoveDiagonally());
        this.player.setLocation(new Location(1,1));
        this.player.performMove('q');
        assertEquals(0, this.player.getRow());
        assertEquals(0, this.player.getCol());
    }
    @Test
    public void performMoveE() {
        this.player.changeMoveBehaviour(new MoveDiagonally());
        this.player.setLocation(new Location(1,1));
        this.player.performMove('e');
        assertEquals(0, this.player.getRow());
        assertEquals(2, this.player.getCol());
    }
    @Test
    public void performMoveC() {
        this.player.changeMoveBehaviour(new MoveDiagonally());
        this.player.setLocation(new Location(1,1));
        this.player.performMove('c');
        assertEquals(2, this.player.getRow());
        assertEquals(2, this.player.getCol());
    }
    @Test
    public void performMoveZ() {
        this.player.changeMoveBehaviour(new MoveDiagonally());
        this.player.setLocation(new Location(1,1));
        this.player.performMove('z');
        assertEquals(2, this.player.getRow());
        assertEquals(0, this.player.getCol());
    }
    
}
