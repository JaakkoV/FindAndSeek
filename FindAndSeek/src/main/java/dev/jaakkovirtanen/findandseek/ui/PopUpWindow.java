package dev.jaakkovirtanen.findandseek.ui;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 * PopUpWindow encapsulates message-window methods for GUI to use.
 */
public class PopUpWindow {

    private final JOptionPane popUpWindow;
    private final ImageIcon findAndSeekIcon;

    /**
     * Constructor for PopUpWindow, creates JOptionPane and icons for
     * notifications.
     */
    public PopUpWindow() {
        this.popUpWindow = new JOptionPane();
        this.findAndSeekIcon = new ImageIcon("assets/congrats.png");
    }

    /**
     * Pops up basic window with given string.
     *
     * @param msg String wanted to display in popup
     */
    public void messageWindow(String msg) {
        JOptionPane.showMessageDialog(popUpWindow, msg);
    }

    /**
     * Pops up special congratulations window with static string and given ints
     * in message.
     *
     * @param howMany Parameter of how many goals hit, shown in the message
     */
    public void congratsWindow(int howMany) {
        JOptionPane.showMessageDialog(popUpWindow, "Congratulations Master, you have hit " + howMany + " goals", "Congratulations", JOptionPane.INFORMATION_MESSAGE, findAndSeekIcon);
    }
}
