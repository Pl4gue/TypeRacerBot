import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.lang.reflect.Field;

/**
 * Project "TypeRacerTyper"
 * "Main.java" created by David Wu on Thu,18.05.17.
 */

public class Main {
    private static CustomRobot robot;
    private static String text;
    private static int cpm;


    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, AWTException, InterruptedException {
        JOptionPane pane = new JOptionPane();
        while (true) {
            try {
                cpm = Integer.parseInt(pane.showInputDialog("Buchstaben pro Minute:"));
                text = pane.showInputDialog(null, "Text");
                cpm = 60000 / cpm;
                robot = new CustomRobot();
                Thread.sleep(1500);
                robot.typeCharacter(robot, text, cpm);
            } catch (NumberFormatException nfE) {
                pane.showMessageDialog(null, "Bitte eine positive Ganzzahl eingeben", "Warnung", JOptionPane.ERROR_MESSAGE);
            }
        }

    }


}
/**
 * End of Main.java
 */