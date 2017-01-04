/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.jaakkovirtanen.findandseek.game.mapobjects;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import dev.jaakkovirtanen.findandseek.game.levels.*;
/**
 *
 * @author User
 */
public class LocationTest {

    private int row, col;
    private Location location;

    public LocationTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        this.row = 5;
        this.col = 3;
        this.location = new Location(this.row, this.col);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testNegativeOutsideIsInside() {
        int row = -1;
        int col = -1;
        assertEquals(false, this.location.isInside(row, col));
    }
    
    @Test
    public void testPositiveOutsideIsInside() {
        int row = 1000;
        int col = 1000;
        assertEquals(false, this.location.isInside(1, 1));
    }
    @Test
    public void testInsideIsInside() {
        int row = 100;
        int col = 20;
        assertEquals(true, this.location.isInside(row, col));
    }
    @Test
    public void testPosNegInsideIsInside() {
        int row = 100;
        int col = -20;
        assertEquals(false, this.location.isInside(row, col));
    }
    @Test
    public void testNegPosIsInside() {
        int row = -100;
        int col = 20;
        assertEquals(false, this.location.isInside(row, col));
    }
    
    @Test
    public void cloneNotSame() {
        assertEquals(false, this.location.getCloneLocation() == this.location);
    }
    
    @Test
    public void setters() {
        int expectedCol = 5;
        int expectedRow = 5;
        this.location.setCol(expectedCol);
        this.location.setRow(expectedRow);
        assertEquals(expectedRow, this.location.getRow());
        assertEquals(expectedCol, this.location.getCol());
    }
}
