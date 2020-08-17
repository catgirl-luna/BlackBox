package blackBox;

import java.awt.Color;
import javax.swing.JButton;

/**
 * Contains functions for the ray buttons.
 * 
 * @author noah
 */
public class RayJButton extends JButton {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  private final Position pos;
  private int number;

  /**
   * Ray button default number is zero which means it has not been used yet.
   *
   * @param row row position (NORTH, SOUTH, EAST, WEST)
   * @param col column position
   */
  public RayJButton(Direction row, int col) {
    pos = new Position(row, col);
    number = 0;
  }

  /**
   * Get the button position.
   *
   * @return The button position.
   */
  public final Position getPosition() {
    return pos;
  }

  /**
   * Get the button number. Default is zero which means it is not set.
   *
   * @return The button number.
   */
  public final int getNumber() {
    return number;
  }

  /**
   * Set the button number. This could be caused by the user or an end. If
   * number greater than one it sets the button text to the number. If the color
   * is not null it sets the new background color.
   *
   * @param num    number to set
   * @param bColor new background color; may be null
   */
  public final void setNumber(int num, Color bColor) {
    number = num;
    if (num > 0) {
      setText(String.valueOf(num));
      setForeground(Color.BLACK);
    } else if (num == -1) {
      setText("H");
      setForeground(Color.WHITE);
    } else if (num == -2) {
      setText("R");
      setForeground(Color.WHITE);
    } else {
      setText("");
    }
    if (bColor != null) {
      setBackground(bColor);
    }
  }
}
