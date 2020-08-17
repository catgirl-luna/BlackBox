package blackBox;

import java.awt.EventQueue;

/**
 * The Black Box game main class. It takes one optional argument for testing the
 * ray routing. When true the game does not generate atoms. Instead placing a
 * user atom on the grid also places it into the model as a computer generated
 * atom. This way the user can place up to four atoms and check the ray routing
 * of the game. The argument must be "test=true" to activate the ray routing
 * feature.
 * 
 * @author noah
 */
public class BlackBox {

  /**
   * Global package variables for user testing.
   */
  protected static boolean TEST = false;

  /**
   * Global package variables for running the robot. This gets changed by the
   * robot class.
   */

  protected static boolean ROBOT = false;

  /**
   * The game invocation method.
   * 
   * @param args optional "test=true" to activate ray route testing
   */
  public static void main(String[] args) {
    // Check for the testing argument.
    if ( (args.length == 1) && args[0].equals("test=true")) {
      TEST = true;
    }
    EventQueue.invokeLater(new Runnable() {
      @Override
      public void run() {
        try {
          new Controller();
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }
}
