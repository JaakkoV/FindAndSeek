package ui;

import dev.jaakkovirtanen.findandseek.levels.*;
import dev.jaakkovirtanen.findandseek.mapobjects.*;
import java.awt.*;
import javax.swing.*;

public class TopMenu extends JPanel {

    private final GUI gui;

    /**
     * Constructor for TopMenu, needs gui.
     *
     * @param gui Gui which wants TopMenu to be drawn
     */
    public TopMenu(GUI gui) {
        super(new GridLayout(1, 3));
        this.gui = gui;
        createComponents();
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        repaint();
    }

    private void createComponents() {
        InnerTarget targetti = new InnerTarget(gui.getGame().getGameBoard());
        targetti.setPreferredSize(targetti.getPrefSize());
        add(targetti);
    }

    class InnerTarget extends JPanel {

        private Dimension prefSize;

        /**
         * Constructor for DrawBoard.
         *
         * @param gameboard initialized with gameboard
         */
        public InnerTarget(Board gameboard) {
            this.prefSize = new Dimension(40, 40);
        }

        @Override
        public void paintComponent(Graphics g) {
            Graphics2D g2d = (Graphics2D) g;
            for (Answer a : gui.getGame().getGameBoard().getAnswers()) {
                if (isAnswerGoal(a.getRow(), a.getCol())) {
                    RectangleDrawing.drawRectangle(gui.getGame().getGameBoard().getWidth() * 10 - 10, 0, 35, 0, 0, 35, g2d, RectangleDrawing.charToColor(a.getValue()));
                }
            }
        }

        private boolean isAnswerGoal(int i, int j) {
            if (gui.getGame().getGameBoard().getAnswers().stream().filter((a) -> (a.getLocation().equals(new Location(i, j)))).anyMatch((a) -> (a.isTarget()))) {
                return true;
            }
            return false;
        }

        public Dimension getPrefSize() {
            return prefSize;
        }
    }

}
