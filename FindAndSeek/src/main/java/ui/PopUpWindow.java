package ui;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class PopUpWindow {

    private JOptionPane popUpWindow;
    private final ImageIcon findAndSeekIcon;

    public PopUpWindow() {
        this.popUpWindow = new JOptionPane();
        this.findAndSeekIcon = new ImageIcon("assets/congrats.png");
    }

    public void messageWindow(String msg) {
        JOptionPane.showMessageDialog(popUpWindow, msg);
    }

    public void congratsWindow(int howMany) {
        JOptionPane.showMessageDialog(popUpWindow, "Congratulations Master, you have hit " + howMany + " goals", "Congratulations", JOptionPane.INFORMATION_MESSAGE, findAndSeekIcon);
    }
}
