package blackBox;

import javax.swing.JButton;

/**
 * Listener interface so GameBoard can invoke methods on view.
 * 
 * @author noah
 */
public interface GameBoardListener {

  /**
   * Invoked when a atom button is pressed.
   *
   * @param button calling button
   */
  public abstract void atomButtonEvent(JButton button);

  /**
   * Invoked when a ray button is pressed.
   *
   * @param button calling button
   */
  public abstract void rayButtonEvent(JButton button);

  /**
   * Invoked when the user quits the game.
   */
  public abstract void quit();

  /**
   * Invoked when the user starts a new game.
   */
  public abstract void newGame();

  /**
   * Invoked when the user solves a game.
   */
  public abstract void solve();

  /**
   * Invoked when the user requests the help menu.
   */
  public abstract void help();

}
