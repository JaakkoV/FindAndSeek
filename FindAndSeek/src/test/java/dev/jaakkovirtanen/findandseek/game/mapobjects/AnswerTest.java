/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.jaakkovirtanen.findandseek.game.mapobjects;

import dev.jaakkovirtanen.findandseek.game.movealgorithms.MoveBehaviour;
import dev.jaakkovirtanen.findandseek.game.movealgorithms.MoveCardinal;
import dev.jaakkovirtanen.findandseek.game.movealgorithms.MoveDiagonally;
import dev.jaakkovirtanen.findandseek.game.movealgorithms.MoveNoWay;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class AnswerTest {
    private BoardObject answer;
    
    public AnswerTest() {
        Location location = new Location(3,1);
        MoveBehaviour moveBehaviour = new MoveNoWay();
        this.answer = new Answer(location, moveBehaviour);
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
    }
    
    @After
    public void tearDown() {
    }    
    
    @Test
    public void answerConstructor() {
        assertEquals(1, this.answer.getCol());
        assertEquals(3, this.answer.getRow());
        MoveBehaviour expected = new MoveNoWay();
        assertEquals(expected.getClass(), this.answer.moveBehaviour.getClass());
    }

    @Test
    public void getCol() {
        assertEquals(1, this.answer.getCol());
    }

    @Test
    public void getRow() {
        assertEquals(3, this.answer.getRow());
    }

    @Test
    public void changeMoveBehaviour() {
        MoveBehaviour expected = new MoveDiagonally();
        this.answer.changeMoveBehaviour(expected);
        assertEquals(expected.getClass(), answer.moveBehaviour.getClass());
    }

}
