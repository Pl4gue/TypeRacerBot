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
    private static Robot robot;
    private static final String EXIT = "exit";
    private static String text;
    private static int cpm;


    public static void main(String[] args) {
        while (true) {
            cpm = Integer.parseInt(JOptionPane.showInputDialog(null, "Buchstaben pro Minute:"));
            text = JOptionPane.showInputDialog(null, "Text");
            cpm = 60000 / cpm;
            try {
                robot = new Robot();
                Thread.sleep(1500);
                typeCharacter(robot, text);
            } catch (AWTException awtE) {
                awtE.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void typeCharacter(Robot robot, String letter) {

        for (int i = 0; i < letter.length(); i++) {
            try {
                boolean upperCase = Character.isUpperCase(letter.charAt(i));
                String KeyVal = Character.toString(letter.charAt(i));
                String variableName;
                switch (KeyVal) {
                    case "-":
                        variableName = "VK_MINUS";
                        break;
                    case "'":
                        variableName = "VK_QUOTE";
                        upperCase = true;
                        break;
                    case ".":
                        variableName = "VK_PERIOD";
                        break;
                    case ",":
                        variableName = "VK_COMMA";
                        break;
                    case ":":
                        variableName = "VK_PERIOD";
                        upperCase = true;
                        break;
                    case ";":
                        variableName = "VK_COMMA";
                        upperCase = true;
                        break;
                    case " ":
                        variableName = "VK_SPACE";
                        break;
                    case "!":
                        variableName = "VK_1";
                        upperCase = true;
                        break;
                    case "\"":
                        variableName = "VK_2";
                        upperCase = true;
                        break;
                    case "§":
                        variableName = "VK_3";
                        upperCase = true;
                        break;
                    case "$":
                        variableName = "VK_4";
                        upperCase = true;
                        break;
                    case "%":
                        variableName = "VK_5";
                        upperCase = true;
                        break;
                    case "&":
                        variableName = "VK_6";
                        upperCase = true;
                        break;
                    case "/":
                        variableName = "VK_7";
                        upperCase = true;
                        break;
                    case "(":
                        variableName = "VK_8";
                        upperCase = true;
                        break;
                    case ")":
                        variableName = "VK_9";
                        upperCase = true;
                        break;
                    case "=":
                        variableName = "VK_0";
                        upperCase = true;
                        break;
                    case "?":
                        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                        StringSelection stringSelection = new StringSelection("?");
                        clipboard.setContents(stringSelection, null);
                        robot.keyPress(KeyEvent.VK_CONTROL);
                        robot.keyPress(KeyEvent.VK_V);
                        robot.keyRelease(KeyEvent.VK_V);
                        robot.keyRelease(KeyEvent.VK_CONTROL);
                        variableName = EXIT;
                        break;
                    default:
                        variableName = "VK_" + KeyVal.toUpperCase();
                }

                if (!variableName.equals(EXIT)) {
                    Class clazz = KeyEvent.class;
                    Field field = clazz.getField(variableName);
                    int keyCode = field.getInt(null);

                    if (upperCase) robot.keyPress(KeyEvent.VK_SHIFT);

                    robot.keyPress(keyCode);
                    robot.keyRelease(keyCode);

                    if (upperCase) robot.keyRelease(KeyEvent.VK_SHIFT);
                }
                Thread.sleep(cpm);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
/**
 * End of Main.java
 */