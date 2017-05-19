/**
 * Project "TypeRacerTyper"
 * "SimpleRobot.java" created by David Wu on Thu,18.05.17.
 */


import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class SimpleRobot {
    public static void main(String[] args) {
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        robot.keyPress(KeyEvent.VK_MINUS);
        robot.keyRelease(KeyEvent.VK_MINUS);

    }
}

/**
 * End of SimpleRobot.java
 */