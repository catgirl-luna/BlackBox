package blackBox;

import java.awt.AWTException;
import java.awt.EventQueue;
import java.awt.Robot;
import java.awt.event.InputEvent;

/**
 * The Black Box robot class. It "plays" a game automatically by loading
 * "generated" atoms and then clicking rays and atoms. It stops when it
 * completes the play so the user can solve the game.
 * 
 * @author noah
 */
public class BlackBoxRobot {

  private static Controller controller = null;
  private static Robot robot;
  private static final int X_OFFSET = 170;
  private static final int Y_OFFSET = 220;

  /**
   * The game invocation method.
   * 
   * @param args not used
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      @Override
      public void run() {
        try {
          // Activate the ROBOT so it does not generate random atoms.
          BlackBox.TEST = false;
          BlackBox.ROBOT = true;

          // Create the controller.
          controller = new Controller();
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });

    // Create the robot.
    try {
      robot = new Robot();
      robot.setAutoDelay(40);
      robot.setAutoWaitForIdle(true);
    } catch (AWTException e1) {
      e1.printStackTrace();
    }

    // Wait until the controller completes initialization.
    while (controller == null) {
      try {
        Thread.sleep(20);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

    // Set the four "generated" atoms.
    controller.setAtom(new Position(4, 3));
    controller.setAtom(new Position(0, 7));
    controller.setAtom(new Position(3, 7));
    controller.setAtom(new Position(6, 7));

    // Use the robot to play the game.
    robot.delay(100);
    leftClickRay(Direction.NORTH, 1);
    leftClickRay(Direction.WEST, 1);
    leftClickRay(Direction.WEST, 2);
    leftClickRay(Direction.WEST, 3);
    leftClickAtom(4, 3);
    leftClickRay(Direction.EAST, 3);
    leftClickRay(Direction.WEST, 4);
    leftClickRay(Direction.EAST, 4);
    leftClickRay(Direction.SOUTH, 0);
    leftClickRay(Direction.SOUTH, 1);
    leftClickAtom(0, 7);
    leftClickRay(Direction.SOUTH, 2);
    leftClickRay(Direction.SOUTH, 3);
    leftClickAtom(3, 7);
    leftClickRay(Direction.SOUTH, 4);
    leftClickRay(Direction.SOUTH, 6);
    leftClickAtom(6, 6);
  }

  /**
   * Do a left click at the specified X and Y absolute screen location.
   * 
   * @param x screen X location
   * @param y screen Y location
   */
  private static void leftClick(int x, int y) {
    robot.mouseMove(x, y);
    robot.delay(50);
    robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
    robot.delay(20);
    robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    robot.delay(500);
  }

  /**
   * Given the atom X and Y grid location click the corresponding atom button.
   * 
   * @param x button X location
   * @param y button Y location
   */
  private static void leftClickAtom(int x, int y) {
    leftClick(X_OFFSET + 50 + ( (x * 40) + (x * 5)),
        Y_OFFSET + 50 + ( (y * 40) + (y * 5)));
  }

  /**
   * Given the direction and number click the corresponding ray button.
   * 
   * @param direction button direction
   * @param number    button number starting from 0
   */
  private static void leftClickRay(Direction direction, int number) {
    int num = number + 1;
    switch (direction) {
      case NORTH:
        leftClick(X_OFFSET + (num * 40) + (num * 5), Y_OFFSET);
        break;
      case SOUTH:
        leftClick(X_OFFSET + (num * 40) + (num * 5), Y_OFFSET + 405);
        break;
      case EAST:
        leftClick(X_OFFSET + 405, Y_OFFSET + (num * 40) + (number * 5));
        break;
      case WEST:
        leftClick(X_OFFSET, Y_OFFSET + (num * 40) + (number * 5));
        break;
      // $CASES-OMITTED$
      default:
        break;
    }
  }
}
