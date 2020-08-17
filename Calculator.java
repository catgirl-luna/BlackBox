package blackBox;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.ArrayList;

/**
 * The calculator engine. Uses the atom locations and starting ray position to
 * calculate the end ray state. It returns the positions as a two element array.
 * The first element is always the initial ray position. The second element is
 * either the exit position, a (-1, -1) position if the ray hit an atom or a
 * (-2, -2) position if the ray was reflected back to its start position.
 * 
 * @author noah
 */
public class Calculator {

  // Atom array and atom creation generator.
  private boolean atoms[][];
  private Generator gen;
  private Position currPos;
  private Position hitPos = new Position(-1, -1);
  private Position rfltPos = new Position(-2, -2);

  // Defines the four corners for checking ray conversions.
  private Position NWPos = new Position(0, 0);
  private Position NEPos = new Position(7, 0);
  private Position SWPos = new Position(0, 7);
  private Position SEPos = new Position(7, 7);

  // The directions and current direction for movement.
  private enum Move {
    LEFT, RIGHT, UP, DOWN
  }

  private Move currDir;

  /**
   * Create the atom generator and two dimensional atom array.
   */
  public Calculator() {
    gen = new Generator();
    atoms = new boolean[8][8];
  }

  /**
   * Set all the atoms in the array to false to clear it.
   */
  public final void clearAtoms() {
    for (int x = 0; x < 8; x++) {
      for (int y = 0; y < 8; y++) {
        atoms[x][y] = false;
      }
    }
  }

  /**
   * Create a list of four random atom positions. The X and Y positions range
   * from 0 to 7 to match the atom array size. There are no duplicate positions
   * in the atom list.
   * 
   * @return The list of atoms.
   * @throws NoSuchAlgorithmException atom generation failed
   * @throws NoSuchProviderException  atom generation failed
   */
  public final ArrayList <Position> createAtoms()
      throws NoSuchAlgorithmException, NoSuchProviderException {
    ArrayList <Position> list = new ArrayList <Position>();
    Position[] pos = gen.getAtoms();
    list.add(pos[0]);
    list.add(pos[1]);
    list.add(pos[2]);
    list.add(pos[3]);
    clearAtoms();
    atoms[pos[0].x][pos[0].y] = true;
    atoms[pos[1].x][pos[1].y] = true;
    atoms[pos[2].x][pos[2].y] = true;
    atoms[pos[3].x][pos[3].y] = true;
    return list;
  }

  /**
   * Calculate the ray path using the starting position and atom placements to
   * return the correct response in the two element array. The first element is
   * the initial position while the second element represents the exit position.
   * A hit is represented as a (-1, -1) position in the returned second array
   * element while a reflection is represented as a (-2, -2) position.
   * 
   * @param pos starting position
   * @return The expected response as a two element array of positions.
   */
  public final Position[] calculateRays(Position pos) {
    // Create the return array.
    Position array[] = new Position[] {
        pos, null
    };

    // Set the movement direction depending on the initial position.
    switch (Direction.toDirection(pos.x)) {
      case NORTH:
        currDir = Move.DOWN;
        currPos = new Position(pos.y, 0);
        break;
      case SOUTH:
        currDir = Move.UP;
        currPos = new Position(pos.y, 7);
        break;
      case EAST:
        currDir = Move.LEFT;
        currPos = new Position(7, pos.y);
        break;
      case WEST:
        currDir = Move.RIGHT;
        currPos = new Position(0, pos.y);
        break;
      case INVALID:
      default:
        break;
    }

    // Checks before first move.
    if (checkFirstHit(currPos)) {
      array[1] = hitPos;
      return array;
    }
    if (checkFirstReflection(currPos)) {
      array[1] = rfltPos;
      return array;
    }

    // Check for hit, reflect and detour. Continue to move until run into a
    // grid boundary.
    do {
      if (checkHit()) {
        array[1] = hitPos;
        return array;
      }
      if (checkReflection()) {
        array[1] = rfltPos;
        return array;
      }
      checkDetour();
    } while (!move());

    // Done moving so set exit position and return.
    array[1] = currPos;
    return array;
  }

  /**
   * Move the location one step in the current direction. If the X or Y are
   * either 0 or 7 after the move the ray has reached a boundary. Hitting a
   * boundary ends the move and converts the point to a ray position.
   * 
   * @return True if done moving; false otherwise.
   */
  private boolean move() {
    switch (currDir) {
      case UP:
        if (currPos.y == 0) {
          currPos = toRayPosition();
          return true;
        }
        currPos.y--;
        break;
      case DOWN:
        if (currPos.y == 7) {
          currPos = toRayPosition();
          return true;
        }
        currPos.y++;
        break;
      case LEFT:
        if (currPos.x == 0) {
          currPos = toRayPosition();
          return true;
        }
        currPos.x--;
        break;
      case RIGHT:
        if (currPos.x == 7) {
          currPos = toRayPosition();
          return true;
        }
        currPos.x++;
        break;
      default:
        break;
    }
    return false;
  }

  /**
   * If it is at an atom boundary return the associated ray location for use in
   * the returned position array second element.
   * 
   * @return Null if not at boundary and ray position if at boundary.
   */
  private Position toRayPosition() {

    if (currPos.equals(NWPos)) {
      switch (currDir) {
        case UP:
          return new Position(Direction.NORTH, 0);
        case LEFT:
          return new Position(Direction.WEST, 0);
        // $CASES-OMITTED$
        default:
          break;
      }
    } else if (currPos.equals(NEPos)) {
      switch (currDir) {
        case UP:
          return new Position(Direction.NORTH, 7);
        case RIGHT:
          return new Position(Direction.EAST, 0);
        // $CASES-OMITTED$
        default:
          break;
      }
    } else if (currPos.equals(SWPos)) {
      switch (currDir) {
        case DOWN:
          return new Position(Direction.SOUTH, 0);
        case LEFT:
          return new Position(Direction.WEST, 7);
        // $CASES-OMITTED$
        default:
          break;
      }
    } else if (currPos.equals(SEPos)) {
      switch (currDir) {
        case DOWN:
          return new Position(Direction.SOUTH, 7);
        case RIGHT:
          return new Position(Direction.EAST, 7);
        // $CASES-OMITTED$
        default:
          break;
      }
    }

    // Not in a corner so check each of the boundaries.
    if (currPos.x == 0) {
      return new Position(Direction.WEST, currPos.y);
    } else if (currPos.x == 7) {
      return new Position(Direction.EAST, currPos.y);
    } else if (currPos.y == 0) {
      return new Position(Direction.NORTH, currPos.x);
    } else if (currPos.y == 7) {
      return new Position(Direction.SOUTH, currPos.x);
    } else {
      return null;
    }
  }

  /**
   * Check for an atom hit. A hit is when an atom is directly in front of the
   * position in the current direction of movement.
   * 
   * @return True if found a hit; false otherwise.
   */
  private boolean checkHit() {
    switch (currDir) {
      case UP:
        if (currPos.y == 0) {
          return false;
        }
        return atoms[currPos.x][currPos.y - 1];
      case DOWN:
        if (currPos.y == 7) {
          return false;
        }
        return atoms[currPos.x][currPos.y + 1];
      case LEFT:
        if (currPos.x == 0) {
          return false;
        }
        return atoms[currPos.x - 1][currPos.y];
      case RIGHT:
        if (currPos.x == 7) {
          return false;
        }
        return atoms[currPos.x + 1][currPos.y];
      default:
        return false;
    }
  }

  /**
   * Check for an atom first hit. A hit is when an atom is directly in front of
   * the position in the current direction of movement.
   * 
   * @param pos current position
   * @return True if found a hit; false otherwise.
   */
  private boolean checkFirstHit(Position pos) {
    return atoms[pos.x][pos.y];
  }

  /**
   * Check for an atom reflection. A reflection is when there are two atoms on
   * each diagonal in front of the position in the current direction of
   * movement. If there is also an atom directly in front of the position it is
   * a hit and takes precedence over the reflection.
   * 
   * @return True if found a reflection; false otherwise.
   */
  private boolean checkReflection() {
    switch (currDir) {
      case UP:
        if ( (currPos.y > 0) && (currPos.x > 0) && (currPos.x < 7)
            && (atoms[currPos.x + 1][currPos.y - 1])
            && (atoms[currPos.x - 1][currPos.y - 1])) {
          return true;
        }
        break;
      case DOWN:
        if ( (currPos.y < 7) && (currPos.x > 0) && (currPos.x < 7)
            && (atoms[currPos.x + 1][currPos.y + 1])
            && (atoms[currPos.x - 1][currPos.y + 1])) {
          return true;
        }
        break;
      case LEFT:
        if ( (currPos.x > 0) && (currPos.y > 0) && (currPos.y < 7)
            && (atoms[currPos.x - 1][currPos.y + 1])
            && (atoms[currPos.x - 1][currPos.y - 1])) {
          return true;
        }
        break;
      case RIGHT:
        if ( (currPos.x < 7) && (currPos.y > 0) && (currPos.y < 7)
            && (atoms[currPos.x + 1][currPos.y + 1])
            && (atoms[currPos.x + 1][currPos.y - 1])) {
          return true;
        }
        break;
      default:
        return false;
    }
    return false;
  }

  /**
   * Check for an atom first reflection. For the starting position on an atom
   * grid boundary a reflection is when an atom is diagonal in front of the
   * position in the current direction of movement. If there is also an atom
   * directly in front of the position it is a hit which should takes precedence
   * over the reflection.
   * 
   * @param pos current position
   * @return True if found a reflection; false otherwise.
   */
  private boolean checkFirstReflection(Position pos) {
    switch (currDir) {
      case UP:
      case DOWN:
        if ( (pos.x > 0) && (atoms[pos.x - 1][pos.y])) {
          return true;
        }
        if ( (pos.x < 7) && (atoms[pos.x + 1][pos.y])) {
          return true;
        }
        break;
      case LEFT:
      case RIGHT:
        if ( (pos.y > 0) && (atoms[pos.x][pos.y - 1])) {
          return true;
        }
        if ( (pos.y < 7) && (atoms[pos.x][pos.y + 1])) {
          return true;
        }
        break;
      default:
        return false;
    }
    return false;
  }

  /**
   * Check for a detour direction change.
   */
  private void checkDetour() {
    switch (currDir) {
      case UP:
        if ( (currPos.y > 0) && (currPos.x < 7)
            && (atoms[currPos.x + 1][currPos.y - 1])) {
          currDir = Move.LEFT;
        }
        if ( (currPos.y > 0) && (currPos.x > 0)
            && (atoms[currPos.x - 1][currPos.y - 1])) {
          currDir = Move.RIGHT;
        }
        break;
      case DOWN:
        if ( (currPos.y < 7) && (currPos.x < 7)
            && (atoms[currPos.x + 1][currPos.y + 1])) {
          currDir = Move.LEFT;
        }
        if ( (currPos.y < 7) && (currPos.x > 0)
            && (atoms[currPos.x - 1][currPos.y + 1])) {
          currDir = Move.RIGHT;
        }
        break;
      case LEFT:
        if ( (currPos.y < 7) && (currPos.x > 0)
            && (atoms[currPos.x - 1][currPos.y + 1])) {
          currDir = Move.UP;
        }
        if ( (currPos.y > 0) && (currPos.x > 0)
            && (atoms[currPos.x - 1][currPos.y - 1])) {
          currDir = Move.DOWN;
        }
        break;
      case RIGHT:
        if ( (currPos.y > 0) && (currPos.x < 7)
            && (atoms[currPos.x + 1][currPos.y - 1])) {
          currDir = Move.DOWN;
        }
        if ( (currPos.y < 7) && (currPos.x < 7)
            && (atoms[currPos.x + 1][currPos.y + 1])) {
          currDir = Move.UP;
        }
        break;
      default:
        break;
    }
  }

  /**
   * It clears the atom array and sets an arbitrary number of atom positions.
   * This is used by the unit test to setup the atom grid.
   * 
   * @param pos atom positions
   */
  final void setAtoms(Position[] pos) {
    clearAtoms();
    for (int i = 0; i < pos.length; i++) {
      atoms[pos[i].x][pos[i].y] = true;
    }
  }

  /**
   * It sets an atom position. Used during user testing.
   * 
   * @param pos   atom position
   * @param state atom state
   */
  final void setAtom(Position pos, boolean state) {
    atoms[pos.x][pos.y] = state;
  }
}
