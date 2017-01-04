package dev.jaakkovirtanen.findandseek.game.levels;

import dev.jaakkovirtanen.findandseek.game.Location;
import dev.jaakkovirtanen.findandseek.game.mapobjects.Answer;
import dev.jaakkovirtanen.findandseek.game.movealgorithms.MoveNoWay;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author User
 */
public class BoardTest {

    private int expectedCols, expectedRows;
    private Level setUpLevel;
    private Location playerExpectedLocation;
    private char playerExpectedValue;
    private ArrayList<Answer> answers;
    private Board board;

    public BoardTest() {
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
        this.expectedCols = 10;
        this.expectedRows = 10;
        this.playerExpectedLocation = new Location(2, 5);
        this.playerExpectedValue = '@';
        this.answers = createArrayListOfAnswersForTests();
        this.board = new Board();
        this.board.loadLevel(setUpLevel);
    }

    @After
    public void tearDown() {
    }

    private ArrayList<Answer> createArrayListOfAnswersForTests() {
        ArrayList<Answer> arrayOfAnswers = new ArrayList<>();
        boolean[] answers = {false, false, false, true};
        char[] values = {'A', 'B', 'C', 'X'};
        Location[] locations = {new Location(4, 4), new Location(6, 1), new Location(5, 2), new Location(7, 3)};
        for (int i = 0; i < 4; i++) {
            Answer addAnswer = new Answer(locations[i], new MoveNoWay());
            addAnswer.setValue(values[i]);
            addAnswer.setIsTarget(answers[i]);
            arrayOfAnswers.add(addAnswer);
        }
        return arrayOfAnswers;
    }

    @Test
    public void loadLevel() {
        assertEquals(true, this.setUpLevel == this.board.getLevel());
    }

    @Test
    public void boardSizeCorrect() {
        assertEquals(expectedCols, this.board.getWidth());
        assertEquals(expectedRows, this.board.getHeight());
    }

    @Test
    public void isPlayerValueCorrect() {
        assertEquals(this.playerExpectedValue, this.board.getPlayer().getValue());
    }

    @Test
    public void isPlayerLocationCorrect() {
        assertEquals(true, this.playerExpectedLocation.equals(this.board.getPlayer().getLocation()));
    }

    @Test
    public void boardOfCharsCorrect() {
        assertArrayEquals(this.getBoardOfCharsToTest().toArray(), this.board.getBoardOfChars().toArray());
    }

    private ArrayList<Character> getBoardOfCharsToTest() {
        ArrayList<Character> boardOfChars = new ArrayList<>();
        char[] board = {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '\n', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '\n', '.', '.', '.', '.', '.', '@', '.', '.', '.', '.', '\n', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '\n', '.', '.', '.', '.', 'A', '.', '.', '.', '.', '.', '\n', '.', '.', 'C', '.', '.', '.', '.', '.', '.', '.', '\n', '.', 'B', '.', '.', '.', '.', '.', '.', '.', '.', '\n', '.', '.', '.', 'X', '.', '.', '.', '.', '.', '.', '\n', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '\n', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '\n'};
        for (char c : board) {
            boardOfChars.add(c);
        }
        return boardOfChars;
    }

    @Test
    public void areAnswersValuesCorrect() {
        for (int i = 0; i < 4; i++) {
            assertEquals(this.answers.get(i).getValue(), this.board.getAnswers().get(i).getValue());
        }
    }

    @Test
    public void areAnswersLocationsCorrect() {
        for (int i = 0; i < 4; i++) {
            assertEquals(true, this.answers.get(i).getLocation().equals(this.board.getAnswers().get(i).getLocation()));
        }
    }

}
