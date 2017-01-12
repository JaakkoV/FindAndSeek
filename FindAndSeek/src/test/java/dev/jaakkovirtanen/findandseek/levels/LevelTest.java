package dev.jaakkovirtanen.findandseek.levels;

import dev.jaakkovirtanen.findandseek.mapobjects.Player;
import dev.jaakkovirtanen.findandseek.mapobjects.Answer;
import dev.jaakkovirtanen.findandseek.mapobjects.BoardObject;
import dev.jaakkovirtanen.findandseek.mapobjects.Location;
import dev.jaakkovirtanen.findandseek.movealgorithms.MoveNoWay;
import java.util.ArrayList;
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

    private int expectedCols, expectedRows;
    private Level setUpLevel;
    private Location playerExpectedLocation;
    private char playerExpectedValue;
    private ArrayList<Answer> answers;

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
        this.setUpLevel = new Level("assets/TxtTestLevel.txt");
        this.expectedCols = 10;
        this.expectedRows = 10;
        this.playerExpectedLocation = new Location(2, 5);
        this.playerExpectedValue = '@';
        this.answers = createArrayListOfAnswersForTests();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void initParams() {
        assertEquals(setUpLevel.getBoardHeight(), this.expectedRows);
        assertEquals(setUpLevel.getBoardWidth(), this.expectedCols);
    }

    @Test
    public void playerValueAfterInit() {
        assertEquals(this.playerExpectedValue, getPlayerFromBoardObjects().getValue());
    }

    @Test
    public void playerLocationAfterInit() {
        assertEquals(true, this.playerExpectedLocation.equals(getPlayerFromBoardObjects().getLocation()));
    }

    @Test
    public void answerValuesAfterInit() {
        ArrayList<Answer> answers = getAnswersFromBoardObjects();
        for (int i = 0; i < 4; i++) {
            assertEquals(this.answers.get(i).getValue(), answers.get(i).getValue());
        }
    }

    @Test
    public void answerLocationsAfterInit() {
        ArrayList<Answer> answers = getAnswersFromBoardObjects();
        for (int i = 0; i < 4; i++) {
            assertEquals(true, this.answers.get(i).getLocation().equals(answers.get(i).getLocation()));
        }
    }

    @Test
    public void targetAnswer() {
        ArrayList<Answer> answers = getAnswersFromBoardObjects();
        assertEquals(this.answers.get(3).isTarget(), answers.get(3).isTarget());
    }

    private ArrayList<Answer> getAnswersFromBoardObjects() {
        ArrayList<Answer> answers = new ArrayList<>();
        for (BoardObject b : this.setUpLevel.getBoardObjects()) {
            if (b.getClass() == Answer.class) {
                answers.add((Answer) b);
            }
        }
        return answers;
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

    private Player getPlayerFromBoardObjects() {
        for (BoardObject b : this.setUpLevel.getBoardObjects()) {
            if (b.getClass() == Player.class) {
                return (Player) b;
            }
        }
        return null;
    }
}
