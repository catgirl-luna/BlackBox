package blackBox;

/**
 * Direction location of the ray buttons row positions. They are:
 * <ul>
 * <li>NORTH - 0
 * <li>SOUTH - 1
 * <li>EAST - 2
 * <li>WEST - 3
 * <li>INVALID - 4 (not a valid direction)
 * </ul>
 *
 * @author noah
 */
public enum Direction {
  /**
   * Direction NORTH (up, negative y-value).
   */
  NORTH(0),
  /**
   * Direction SOUTH (down, positive y-value).
   */
  SOUTH(1),
  /**
   * Direction EAST (right, positive x-value).
   */
  EAST(2),
  /**
   * Direction WEST (left, negative x-value).
   */
  WEST(3),
  /**
   * Not a valid direction.
   */
  INVALID(4);

  /**
   * Value for the direction.
   */
  public final int value;

  private Direction(int value) {
    this.value = value;
  }

  /**
   * Convert the row number to a direction.
   *
   * @param row row number
   * @return direction or INVALID if row not in range
   */
  public static Direction toDirection(int row) {
    switch (row) {
      case 0:
        return Direction.NORTH;
      case 1:
        return Direction.SOUTH;
      case 2:
        return Direction.EAST;
      case 3:
        return Direction.WEST;
      default:
        return Direction.INVALID;
    }
  }

  /**
   * Return the direction string.
   *
   * @param row row value to display
   * @return direction string
   */
  public static String toString(int row) {
    switch (row) {
      case 0:
        return "NORTH";
      case 1:
        return "SOUTH";
      case 2:
        return "EAST";
      case 3:
        return "WEST";
      default:
        return "Invalid direction value: " + row;
    }
  }
}