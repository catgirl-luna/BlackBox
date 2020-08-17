package blackBox;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;

/**
 * Class to handle generating random numbers.
 * 
 * @author noah
 */
public class Generator {

  /**
   * Launch the application.
   * 
   * @param args
   */
  @SuppressWarnings ("null")
  public static void main(String[] args) {
    Generator gen = new Generator();
    Position[] pos = null;
    try {
      pos = gen.getAtoms();
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    } catch (NoSuchProviderException e) {
      e.printStackTrace();
    }
    System.out.println(pos[0] + " " + pos[1] + " " + pos[2] + " " + pos[3]);
  }

  /**
   * Generates a random Position between 0 and 7
   * 
   * @return pos a random Position
   */
  private Position generate()
      throws NoSuchAlgorithmException, NoSuchProviderException {
    SecureRandom secureRandomGenerator = null;
    secureRandomGenerator = SecureRandom.getInstance("SHA1PRNG", "SUN");

    // Get random integer in range
    int randInRange1 = secureRandomGenerator.nextInt(8);
    int randInRange2 = secureRandomGenerator.nextInt(8);
    int x = randInRange1;
    int y = randInRange2;
    Position pos = new Position(x, y);
    return pos;
  }

  /**
   * Uses generate() to generate four random positions between 0 and 7 and
   * checks to make sure each position group is different.
   * 
   * @return listOfAtoms four random positions between 0 and 7
   * @throws NoSuchAlgorithmException
   * @throws NoSuchProviderException
   */
  public Position[] getAtoms()
      throws NoSuchAlgorithmException, NoSuchProviderException {
    Position[] listOfAtoms = new Position[4];
    int count = 0;
    boolean invalid;
    Position pos;
    while (count < 4) {
      invalid = false;
      pos = generate();
      for (int i = 0; i < count; i++) {
        if (pos.equals(listOfAtoms[i])) {
          invalid = true;
        }
      }
      if (!invalid) {
        listOfAtoms[count++] = pos;
      }
    }
    return listOfAtoms;
  }
}