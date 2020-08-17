package blackBox;

import java.io.Serializable;
import java.util.Objects;

/**
 * Contains functions for managing the position of the atoms and rays.
 * 
 * @author noah
 */
public class Position implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  /**
   * Position X value (going from left the right).
   */
  public int x;

  /**
   * Position Y value (going from top to bottom).
   */
  public int y;

  // Determines position display format.
  private boolean useDirection = false;

  /**
   * The position as X and Y. Once set the values cannot be changed.
   *
   * @param x X value
   * @param y Y value
   */
  public Position(int x, int y) {
    this.x = x;
    this.y = y;
  }

  /**
   * The position as direction row and column. Once set the values cannot be
   * changed.
   *
   * @param row row value
   * @param col column value
   */
  public Position(Direction row, int col) {
    this.x = row.value;
    this.y = col;
    useDirection = true;
  }

  /**
   * Compares the values of the two positions and not the objects.
   *
   * @param o object to compare with
   * @return true if positions are identical
   */
  @Override
  public final boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (! (o instanceof Position)) {
      return false;
    }
    Position pos = (Position) o;
    return (x == pos.x) && (y == pos.y);
  }

  /**
   * Compares hashes of the position values.
   *
   * @return true if positions are identical
   */
  @SuppressWarnings ("boxing")
  @Override
  public final int hashCode() {
    return Objects.hash(x, y);
  }

  /**
   * Return the positions as a string.
   *
   * @return the positions
   */
  @Override
  public final String toString() {
    if (useDirection) {
      return "Position: " + Direction.toString(x) + '(' + y + ')';
    }
    return "Position: (" + x + ',' + y + ')';
  }
}
