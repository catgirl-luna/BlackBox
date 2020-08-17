package blackBox;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 * Class that handles changing the display on the game board. The game board
 * controls the graphics.
 * 
 * @author noah
 */
public class View implements GameBoardListener {

  private GameBoard board;
  private ViewListener listener;

  // The array of colors and color counter.
  private final Color[] colors;
  private final Color[] hitColors = {
      Color.RED, Color.WHITE
  };
  private final Color[] reflectColors = {
      Color.BLUE, Color.WHITE
  };
  private int numColors;
  private int nextColor;

  /**
   * Run the view for testing purposes.
   * 
   * @param args not used
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      @Override
      public void run() {
        try {
          new View(null);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  /**
   * Create and display the button GUI.
   *
   * @param viewListener listener for view events
   */
  public View(ViewListener viewListener) {
    nextColor = 0;
    colors = new Color[] {
        Color.WHITE, Color.CYAN, Color.GREEN, Color.MAGENTA, Color.ORANGE,
        Color.PINK, Color.YELLOW
    };
    numColors = colors.length;
    listener = viewListener;
    // Create and display the form
    board = new GameBoard(this);
  }

  /**
   * Get the next ray button color. It cycles to the start when it reaches the
   * end.
   *
   * @return The next color.
   */
  public final Color getNextColor() {
    return colors[nextColor++ % numColors];
  }

  /**
   * Get the hit background and foreground colors.
   * 
   * @return hitColors The two hit colors.
   */
  public final Color[] getHitColor() {
    return hitColors;
  }

  /**
   * Get the reflect background and foreground colors.
   * 
   * @return The two reflect colors.
   */
  public final Color[] getReflectColor() {
    return reflectColors;
  }

  /**
   * Sets an atom's background color to green.
   * 
   * @param pos the position of the target button
   */
  public final void setAtomGreen(Position pos) {
    board.setAtomGreen(pos);
  }

  /**
   * Sets an atom's background color to red.
   * 
   * @param pos the position of the target button
   */
  public final void setAtomRed(Position pos) {
    board.setAtomRed(pos);
  }

  /**
   * Error message called when user attempts to place atom when four already
   * exist. Four is the current maximum.
   */
  public void atomSizeMessage() {
    JOptionPane.showMessageDialog(board,
        "There is already the maximum amount of atoms! Please delete one first.",
        "Error", JOptionPane.ERROR_MESSAGE);
  }

  /**
   * Error message called when user attempts to place a ray at a location where
   * one already exists.
   */
  public void rayInUseMessage() {
    JOptionPane.showMessageDialog(board,
        "There is already a ray here! Please choose a different location.",
        "Error", JOptionPane.ERROR_MESSAGE);
  }

  /**
   * Error message called when user attempts to solve game with less than four
   * atoms.
   * 
   * @return True is OK; false is cancel.
   */
  public boolean missingAtomsMessage() {
    int result = JOptionPane.showConfirmDialog(board,
        "You have not guessed the maximum amount of atoms.\n"
            + "Missing atoms will be counted as incorrect. Proceed?",
        "Error", JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
    // 0 = yes, 2 = cancel.
    return (result == 0) ? true : false;
  }

  /**
   * Error message called when user attempts to quit with an unsolved game.
   * 
   * @return True is OK; false is cancel.
   */
  public boolean quitMessage() {
    int result = JOptionPane.showConfirmDialog(board,
        "You have not solved the game yet.\n" + "Proceed to quit?", "Error",
        JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
    // 0 = yes, 2 = cancel.
    return (result == 0) ? true : false;
  }

  /**
   * Error message called when user attempts to start new game with an unsolved
   * game.
   * 
   * @return True is OK; false is cancel.
   */
  public boolean newGameNotSolved() {
    int result = JOptionPane.showConfirmDialog(board,
        "You have not solved the game yet.\n" + "Proceed to start new game?",
        "Error", JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
    // 0 = yes, 2 = cancel.
    return (result == 0) ? true : false;
  }

  /**
   * Set all the atom buttons to default.
   */
  public final void setAtomDefault() {
    board.setAtomDefault();
  }

  /**
   * Get the specified atom button state.
   *
   * @param pos grid position
   * @return The button state.
   */
  public final boolean getAtom(Position pos) {
    return board.getAtomButton(pos);
  }

  /**
   * Set the specified atom button state.
   *
   * @param pos   atom position
   * @param state button atom state
   */
  public final void setAtom(Position pos, boolean state) {
    board.setAtomButton(pos, state);
  }

  /**
   * Set all the ray buttons to default.
   */
  public final void setRayDefault() {
    board.setRayDefault();
    nextColor = 0;
  }

  /**
   * Set the specified ray button number and background color. If the number is
   * zero or less it resets the button to its default state.
   *
   * @param pos       ray position
   * @param number    ray number; zero or less clears the text
   * @param bgndColor background color; null sets to background color
   */
  public final void setRayData(Position pos, int number, Color bgndColor) {
    setRayData(pos, number, bgndColor, null);
  }

  /**
   * Set the specified ray button number and background color. If the number is
   * zero or less it resets the button to its default state.
   *
   * @param pos       ray position
   * @param number    ray number; zero or less clears the text
   * @param bgndColor background color
   */
  public final void setRayData(Position pos, int number, Color bgndColor,
      Color fgndColor) {
    if (number != 0) {
      board.setRayData(pos, number, bgndColor);
    } else {
      board.setRayData(pos, 0, null);
    }
  }

  // GameBoardListener methods.

  /**
   * Invoked when a atom button is pressed.
   *
   * @param button calling button
   */
  @Override
  public final void atomButtonEvent(JButton button) {
    AtomJButton gButton = (AtomJButton) button;
    listener.atomButton(gButton.getPosition(), gButton.isAtom());
  }

  /**
   * Invoked when a ray button is pressed.
   *
   * @param button calling button
   */
  @Override
  public final void rayButtonEvent(JButton button) {
    RayJButton rButton = (RayJButton) button;
    listener.rayButton(rButton.getPosition(), rButton.getNumber());
  }

  /**
   * Invoked when the quit button is pressed.
   */
  @Override
  public void quit() {
    listener.quit();

  }

  /**
   * Invoked when the new game button is pressed.
   */
  @Override
  public void newGame() {
    listener.newGame();

  }

  /**
   * Invoked when the solve button is pressed.
   */
  @Override
  public void solve() {
    listener.solve();
  }

  /**
   * Set the score on the game board.
   * 
   * @param score new score
   */
  public final void setScore(int score) {
    board.setScore(score);
  }

  /**
   * Reset the score on the game board.
   */
  public final void resetScore() {
    board.resetScore();
  }

  /**
   * Close the game board.
   */
  public final void close() {
    board.setVisible(false);
    board.dispose();
  }

  /**
   * Creates the help window when the help button is pressed.
   */
  @Override
  public void help() {
    EventQueue.invokeLater(new Runnable() {
      @Override
      public void run() {
        try {
          new HelpWindow(100, 50);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }
}
