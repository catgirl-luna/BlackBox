package blackBox;

import javax.swing.JButton;

/**
 * Contains functions for the atom buttons.
 * 
 * @author noah
 */
public class AtomJButton extends JButton {

  private static final long serialVersionUID = 1L;
  private final Position pos;
  private boolean atomState;

  /**
   * Creates an atom button at the position specified. Default visiblity (state)
   * is false.
   *
   * @param x X position
   * @param y Y position
   */
  public AtomJButton(int x, int y) {
    pos = new Position(x, y);
    atomState = false;
  }

  /**
   * Get the atom button's grid position.
   *
   * @return pos the buttons grid position
   */
  public final Position getPosition() {
    return pos;
  }

  /**
   * Returns whether the atom is visible.
   *
   * @return true if atom in grid
   */
  public final boolean isAtom() {
    return atomState;
  }

  /**
   * Sets whether the atom is visible.
   *
   * @param atomState true places atom in grid
   */
  public final void setAtom(boolean atomState) {
    this.atomState = atomState;
  }
}
