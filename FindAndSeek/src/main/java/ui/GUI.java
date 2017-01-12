package ui;

import dev.jaakkovirtanen.findandseek.levels.*;
import dev.jaakkovirtanen.findandseek.game.*;
import dev.jaakkovirtanen.findandseek.game.utils.*;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

/**
 * GUI creates JFrame and adds widgets to it to be drawn.
 */
public class GUI implements Runnable {

    private Game game;
    private JFrame frame;
    private final ArrayList<Level> gameLevels;
    private static KeyboardListener keyListener;
    private final BottomMenu bottomMenu;
    private final TopMenu topMenu;
    private SidePanel sidePanel;
    private final PopUpWindow msgWindow;

    /**
     * Constructor for the GUI, also wanted levels are specified here.
     */
    public GUI() {
        this.game = new Game();
        String[] levels = {"assets/TxtTestLevel.txt", "assets/TxtTestLevel2.txt", "assets/TxtTestLevel4.txt", "assets/TxtTestLevel4.txt", "assets/TxtTestLevel5.txt"};
        this.gameLevels = Level.getListOfLevels(levels);
        this.game.loadLevel(gameLevels.get(0));
        this.bottomMenu = new BottomMenu(this);
        this.topMenu = new TopMenu(this);
        this.sidePanel = new SidePanel(this);
        this.keyListener = new KeyboardListener(this);
        this.msgWindow = new PopUpWindow();
    }

    @Override
    public void run() {
        drawGui();
    }

    /**
     * Draws widgets to the frame.
     *
     * @throws InterruptedException ThreadSleep is used in the method
     */
    private void drawGui() {

        this.frame = new JFrame("Find and Seek Game");
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setLayout(new BorderLayout());
        frame.addKeyListener(keyListener);
        initializeFrame();
        this.frame.setVisible(true);

    }

    /**
     * Initializes frame again, builds all components again.
     *
     * Also Fixed window size can be set here
     */
    public void initializeFrame() {
        frame.getContentPane().removeAll();
        createComponents(frame.getContentPane());
//        frame.setSize(new Dimension(1000, 600));
    }

    private void createComponents(Container container) {
        BoardPanel pelilauta = new BoardPanel(this);
        pelilauta.setPreferredSize(pelilauta.getPrefSize());

        sidePanel = new SidePanel(this);
        sidePanel.setPreferredSize(new Dimension(250, 400));

        sidePanel.setFocusable(false);
        topMenu.setFocusable(false);
        pelilauta.setFocusable(false);
        bottomMenu.setFocusable(false);

        container.add(sidePanel, BorderLayout.EAST);
        container.add(topMenu, BorderLayout.NORTH);
        container.add(pelilauta, BorderLayout.CENTER);
        container.add(bottomMenu, BorderLayout.SOUTH);

        frame.setFocusable(true);
        frame.pack();
        frame.repaint();
    }

    /**
     * Gives possibility to outside-classes to repaint the frame.
     */
    public void repaint() {
        frame.repaint();
        frame.requestFocus();
    }

    /**
     * Checks gameStatus if e.g. popUpWindows are wanted to display.
     *
     * This is the method to add interaction after specific game status
     */
    public void checkGameStatus() {
        boolean everyTenth = game.getGameBoard().getLevel().getHowManyGoals() % 10 == 0 && game.getGameBoard().getLevel().getHowManyGoals() != 0 && game.getGameBoard().getPlayer().getMovesSinceHit() == 0;
        if (everyTenth) {
            this.msgWindow.congratsWindow(game.getGameBoard().getLevel().getHowManyGoals());
        }
        boolean random = Randomizer.getRandomNumber(100) > 99;
        if (random) {
            this.msgWindow.messageWindow("This is just crazy annoying reminder with probab of 1% to pop up");
        }
    }

    /**
     * Initializes new Game object, to force gui frame to refresh.
     */
    public void initGame() {
        this.game = new Game();
    }

    public Game getGame() {
        return game;
    }

    public ArrayList<Level> getGameLevels() {
        return gameLevels;
    }

    public BottomMenu getBottomMenu() {
        return bottomMenu;
    }
}
