package dev.jaakkovirtanen.findandseek.game.levels;

import dev.jaakkovirtanen.findandseek.game.mapObjects.Player;
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
    private Map level;
    private char[][] testMap;
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
        this.testMap = new char[][] {
            {'.','.','.'},
            {'.','.','.'},
            {'.','.','.'}}; 
        this.level = new Level(testMap, new Player());
    }
    
    @After
    public void tearDown() {
    }

    @Test 
    public void constructorMap() {
        assertEquals(this.testMap, this.level.getMap());
    }
    
    @Test 
    public void changeMap() {
        char[][] expectedMap = new char[][] {
            {'.','.','.'},
            {'.','@','.'},
            {'.','.','.'}};
        this.level.changeMap(expectedMap);
        assertEquals(expectedMap, this.level.getMap());
    }
}
