import java.awt.*;

import static javax.swing.JOptionPane.*;

/**
 * Project "TypeRacerTyper"
 * "Main.java" created by David Wu on Thu,18.05.17.
 */

public class Main {
    private static CustomRobot robot;
    private static String text;
    private static int cpm;


    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, AWTException, InterruptedException {
        while (true) {
            try {
                cpm = Integer.parseInt(showInputDialog("Buchstaben pro Minute:"));
                text = showInputDialog(null, "Text");
                cpm = 60000 / cpm;
                robot = new CustomRobot();
                Thread.sleep(1500);
                CustomRobot.typeCharacter(robot, text, cpm);
            } catch (NumberFormatException nfE) {
                showMessageDialog(null, "Bitte eine positive Ganzzahl eingeben", "Warnung", ERROR_MESSAGE);
            }
        }

    }


}
/**
 * End of Main.java
 */