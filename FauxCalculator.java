package blackBox;

import static org.junit.jupiter.api.Assertions.fail;
import java.util.ArrayList;

/**
 * A test version of the Calculator class for testing the TestCalculator JUnit
 * test. It uses the move patterns from the Parker Brothers game manual for the
 * tests. The moves 10 and 11 are left out because they are duplicates.
 * 
 * @author noah
 */
public class FauxCalculator {

  private boolean atoms[][];
  private Position hitPos = new Position(-1, -1);
  private Position rfltPos = new Position(-2, -2);

  /**
   * Create the 8 by 8 atom array.
   */
  public FauxCalculator() {
    atoms = new boolean[8][8];
  }

  /**
   * Create a list of four atoms.
   * 
   * @return The atom list.
   */
  public final ArrayList <Position> createAtoms() {
    ArrayList <Position> list = new ArrayList <Position>();
    list.add(new Position(0, 0));
    list.add(new Position(1, 1));
    list.add(new Position(2, 2));
    list.add(new Position(3, 3));
    return list;
  }

  /**
   * Calculate the ray path using the starting position and atom placements to
   * return the correct response position. A hit is represented as a -1 position
   * in the second array element while a reflection is represented as a -2
   * position.
   * 
   * @param pos starting position
   * @return The expected response position.
   */
  public final Position[] calculateRays(Position pos) {
    if (atoms[0][3]) {
      // testCalculateRays1
      if (pos.equals(new Position(Direction.WEST, 3))) {
        return new Position[] {
            pos, hitPos
        };
      }
    }

    if (atoms[4][3] && atoms[5][3]) {
      // testCalculateRays22
      if (pos.equals(new Position(Direction.SOUTH, 4))) {
        return new Position[] {
            pos, hitPos
        };
      }
    }

    if (atoms[4][3] && atoms[5][4]) {
      // testCalculateRays23
      if (pos.equals(new Position(Direction.SOUTH, 4))) {
        return new Position[] {
            pos, new Position(Direction.WEST, 5)
        };
      }
    }

    if (atoms[4][3] && atoms[5][3] && atoms[6][3]) {
      // testCalculateRays24
      if (pos.equals(new Position(Direction.SOUTH, 5))) {
        return new Position[] {
            pos, hitPos
        };
      }
    }

    if (atoms[4][3] && atoms[5][2] && atoms[6][3]) {
      // testCalculateRays25
      if (pos.equals(new Position(Direction.SOUTH, 5))) {
        return new Position[] {
            pos, rfltPos
        };
      }
    }

    if (atoms[4][3] && atoms[6][3]) {
      // testCalculateRays14 and 14A
      if (pos.equals(new Position(Direction.SOUTH, 5))
          || pos.equals(new Position(Direction.NORTH, 5))) {
        return new Position[] {
            pos, rfltPos
        };
      }
    }
    if (atoms[4][3] && atoms[4][5]) {
      // testCalculateRays14B and 14C
      if (pos.equals(new Position(Direction.WEST, 4))
          || pos.equals(new Position(Direction.EAST, 4))) {
        return new Position[] {
            pos, rfltPos
        };
      }
    }

    if (atoms[4][3] && atoms[7][3]) {
      // testCalculateRays15
      if (pos.equals(new Position(Direction.SOUTH, 5))) {
        return new Position[] {
            pos, new Position(Direction.SOUTH, 6)
        };
      }
    }

    if (atoms[4][3] || atoms[4][7]) {
      // testCalculateRays2 and 2A
      if (pos.equals(new Position(Direction.SOUTH, 4))) {
        return new Position[] {
            pos, hitPos
        };
      }
    }

    if (atoms[4][3] || atoms[0][3]) {
      // testCalculateRays3 and 3A
      if (pos.equals(new Position(Direction.WEST, 3))) {
        return new Position[] {
            pos, hitPos
        };
      }
    }

    if (atoms[4][3] || atoms[4][0]) {
      // testCalculateRays4 and 4A
      if (pos.equals(new Position(Direction.NORTH, 4))) {
        return new Position[] {
            pos, hitPos
        };
      }
    }
    if (atoms[4][3] || atoms[7][3]) {
      // testCalculateRays5 and 5A
      if (pos.equals(new Position(Direction.EAST, 3))) {
        return new Position[] {
            pos, hitPos
        };
      }
    }

    if (atoms[0][0]) {
      // testCalculateRays13A
      if (pos.equals(new Position(Direction.NORTH, 1))) {
        return new Position[] {
            pos, rfltPos
        };
      }
      if (pos.equals(new Position(Direction.WEST, 1))) {
        return new Position[] {
            pos, rfltPos
        };
      }
    }

    if (atoms[7][0]) {
      // testCalculateRays13B
      if (pos.equals(new Position(Direction.NORTH, 6))) {
        return new Position[] {
            pos, rfltPos
        };
      }
      if (pos.equals(new Position(Direction.EAST, 1))) {
        return new Position[] {
            pos, rfltPos
        };
      }
    }

    if (atoms[0][7]) {
      // testCalculateRays13C
      if (pos.equals(new Position(Direction.SOUTH, 1))) {
        return new Position[] {
            pos, rfltPos
        };
      }
      if (pos.equals(new Position(Direction.WEST, 6))) {
        return new Position[] {
            pos, rfltPos
        };
      }
    }

    if (atoms[7][7]) {
      // testCalculateRays13D
      if (pos.equals(new Position(Direction.SOUTH, 6))) {
        return new Position[] {
            pos, rfltPos
        };
      }
      if (pos.equals(new Position(Direction.EAST, 6))) {
        return new Position[] {
            pos, rfltPos
        };
      }
    }

    if (atoms[4][3]) {
      // testCalculateRays6 and 6A
      if (pos.equals(new Position(Direction.SOUTH, 3))) {
        return new Position[] {
            pos, new Position(Direction.WEST, 4)
        };
      }
      if (pos.equals(new Position(Direction.WEST, 4))) {
        return new Position[] {
            pos, new Position(Direction.SOUTH, 3)
        };
      }

      // testCalculateRays7 and 7A
      if (pos.equals(new Position(Direction.NORTH, 3))) {
        return new Position[] {
            pos, new Position(Direction.WEST, 2)
        };
      }
      if (pos.equals(new Position(Direction.WEST, 2))) {
        return new Position[] {
            pos, new Position(Direction.NORTH, 3)
        };
      }

      // testCalculateRays8 and 8A
      if (pos.equals(new Position(Direction.NORTH, 5))) {
        return new Position[] {
            pos, new Position(Direction.EAST, 2)
        };
      }
      if (pos.equals(new Position(Direction.EAST, 2))) {
        return new Position[] {
            pos, new Position(Direction.NORTH, 5)
        };
      }

      // testCalculateRays9 and 9A
      if (pos.equals(new Position(Direction.SOUTH, 5))) {
        return new Position[] {
            pos, new Position(Direction.EAST, 4)
        };
      }
      if (pos.equals(new Position(Direction.EAST, 4))) {
        return new Position[] {
            pos, new Position(Direction.SOUTH, 5)
        };
      }

      // testCalculateRays18
      if (pos.equals(new Position(Direction.SOUTH, 2))) {
        return new Position[] {
            pos, new Position(Direction.NORTH, 2)
        };
      }

      // testCalculateRays19
      if (pos.equals(new Position(Direction.WEST, 1))) {
        return new Position[] {
            pos, new Position(Direction.EAST, 1)
        };
      }

      // testCalculateRays20
      if (pos.equals(new Position(Direction.NORTH, 6))) {
        return new Position[] {
            pos, new Position(Direction.SOUTH, 6)
        };
      }

      // testCalculateRays21
      if (pos.equals(new Position(Direction.EAST, 5))) {
        return new Position[] {
            pos, new Position(Direction.WEST, 5)
        };
      }
    }

    if (atoms[6][3])

    {
      // testCalculateRays12
      if (pos.equals(new Position(Direction.SOUTH, 5))) {
        return new Position[] {
            pos, new Position(Direction.WEST, 4)
        };
      }
    }

    if (atoms[4][7]) {
      // testCalculateRays13
      if (pos.equals(new Position(Direction.SOUTH, 5))) {
        return new Position[] {
            pos, rfltPos
        };
      }
    }

    if (atoms[5][7]) {
      // testCalculateRays16
      if (pos.equals(new Position(Direction.SOUTH, 4))) {
        return new Position[] {
            pos, rfltPos
        };
      }
    }

    if (atoms[5][6]) {
      // testCalculateRays17
      if (pos.equals(new Position(Direction.SOUTH, 4))) {
        return new Position[] {
            pos, new Position(Direction.WEST, 7)
        };
      }

      // testCalculateRays17A
      if (pos.equals(new Position(Direction.SOUTH, 6))) {
        return new Position[] {
            pos, new Position(Direction.EAST, 7)
        };
      }
    }

    if (atoms[4][0] && atoms[0][2] && atoms[4][4]) {
      // testCalculateRays26
      if (pos.equals(new Position(Direction.NORTH, 1))) {
        return new Position[] {
            pos, new Position(Direction.SOUTH, 1)
        };
      }
    }

    if (atoms[4][0] && atoms[4][4] && atoms[6][4]) {
      // testCalculateRays27
      if (pos.equals(new Position(Direction.EAST, 1))) {
        return new Position[] {
            pos, rfltPos
        };
      }
    }

    if (atoms[0][2] && atoms[7][2] && atoms[5][5] && atoms[6][5]
        && atoms[0][7]) {
      // testCalculateRays28
      if (pos.equals(new Position(Direction.SOUTH, 4))) {
        return new Position[] {
            pos, hitPos
        };
      }
    }

    if (atoms[0][0] && atoms[6][0] && atoms[6][2] && atoms[0][4]
        && atoms[6][6]) {
      // testCalculateRays29
      if (pos.equals(new Position(Direction.SOUTH, 1))) {
        return new Position[] {
            pos, rfltPos
        };
      }
    }

    fail("Invalid test case");
    return null;
  }

  /**
   * Set all the atoms in the array to false to clear it.
   */
  private void clearAtoms() {
    for (int x = 0; x < 8; x++) {
      for (int y = 0; y < 8; y++) {
        atoms[x][y] = false;
      }
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
}
