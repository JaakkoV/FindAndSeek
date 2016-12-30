package dev.jaakkovirtanen.findandseek.game.levels;

import dev.jaakkovirtanen.findandseek.game.Location;
import dev.jaakkovirtanen.findandseek.game.mapobjects.Answer;
import dev.jaakkovirtanen.findandseek.game.mapobjects.BoardObject;
import dev.jaakkovirtanen.findandseek.game.mapobjects.Player;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jaakvirt
 */
public class LevelTest {

    private char[][] testMap;
    private Board level;

    public LevelTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        int height = 5;
        int widht = 4;
        this.testMap = new char[height][widht];
        this.level = new Level(height, widht, new Player(), new Answer());
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < widht; j++) {
                this.testMap[i][j] = '.';
            }
        }
    }

    @After
    public void tearDown() {
    }

    @Test
    public void constructorMap() {
        assertEquals(this.testMap, this.level.getBoard());
    }

    @Test
    public void changeBoard() {
        char[][] expectedMap = this.testMap;
        this.level.loadLevel(expectedMap);
        assertEquals(expectedMap, this.level.getBoard());
    }
}
