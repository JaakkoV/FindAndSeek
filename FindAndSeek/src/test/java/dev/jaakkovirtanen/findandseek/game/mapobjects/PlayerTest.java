package dev.jaakkovirtanen.findandseek.game.mapobjects;

import dev.jaakkovirtanen.findandseek.game.movealgorithms.MoveBehaviour;
import dev.jaakkovirtanen.findandseek.game.mapobjects.Player;
import dev.jaakkovirtanen.findandseek.game.movealgorithms.MoveCardinal;
import dev.jaakkovirtanen.findandseek.game.movealgorithms.MoveDiagonally;
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
        this.player = new Player();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void playerConstructor() {
        assertEquals(1, this.player.getCol());
        assertEquals(1, this.player.getRow());
        MoveBehaviour expected = new MoveCardinal();
        assertEquals(expected.getClass(), this.player.moveBehaviour.getClass());
    }

    @Test
    public void getCol() {
        assertEquals(1, this.player.getCol());
    }

    @Test
    public void getRow() {
        assertEquals(1, this.player.getRow());
    }

    @Test
    public void changeMoveBehaviour() {
        MoveBehaviour expected = new MoveDiagonally();
        this.player.changeMoveBehaviour(expected);
        assertEquals(expected.getClass(), player.moveBehaviour.getClass());
    }

}
