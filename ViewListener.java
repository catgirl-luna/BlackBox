package blackBox;

/**
 * Listener so View can invoke methods on Controller.
 * 
 * @author noah
 */
public interface ViewListener {

  /**
   * Invoked when a atom button is pressed.
   *
   * @param pos       button position in grid
   * @param atomState state of atom; default is false (no atom)
   */
  public abstract void atomButton(Position pos, boolean atomState);

  /**
   * Invoked when a ray button is pressed.
   *
   * @param pos    button position in direction and column
   * @param number current ray number; default is 0 (no ray assigned)
   */
  public abstract void rayButton(Position pos, int number);

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
}
