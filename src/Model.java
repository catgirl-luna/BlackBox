package blackBox;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Contains varibles to store information as the game is played and functions to
 * get and modify the variables.
 * 
 * @author noah
 */
public class Model {

  // Fields

  /**
   * Running score.
   */
  private int score;

  /**
   * Atoms set by the game.
   */
  private ArrayList <Position> atoms;

  /**
   * Two-dimensional array of ray positions, start and end.
   */
  private ArrayList <Position[]> userRays;

  /**
   * Atoms set by the user.
   */
  private ArrayList <Position> userAtoms;

  // Constructors
  /**
   * 
   */
  public Model() {
    score = 0;
    atoms = new ArrayList <Position>();
    userRays = new ArrayList <Position[]>();
    userAtoms = new ArrayList <Position>();
  }

  // Other methods

  /**
   * Increases the score and returns it.
   * 
   * @return int
   * @param value The value to increase the score by.
   */
  public int increaseScore(int value) {
    score += value;
    return score;
  }

  /**
   * Gets the current score.
   * 
   * @return int
   */
  public int getScore() {
    return score;
  }

  /**
   * Add a user ray on the grid.
   * 
   * @param pos The position to add the ray to.
   */
  public void addUserRay(Position[] pos) {
    userRays.add(pos);
  }

  /**
   * Resets the score and clears the array lists of atoms and rays.
   */
  public void resetModel() {
    atoms.clear();
    userAtoms.clear();
    userRays.clear();
    score = 0;
  }

  /**
   * Sets a new atom on the game board.
   * 
   * @param pos The position to add the atom to.
   */
  public void setAtom(Position pos) {
    atoms.add(pos);
  }

  /**
   * Deletes an atom on the game board.
   * 
   * @param pos The position to delete the atom from.
   */
  public void deleteAtom(Position pos) {
    Iterator <Position> itr = atoms.iterator();
    while (itr.hasNext()) {
      Position i = itr.next();
      if (i == pos) {
        itr.remove();
      }
    }
  }

  /**
   * Sets a new user atom guess on the game board.
   * 
   * @param pos
   */
  public void setUserAtom(Position pos) {
    userAtoms.add(pos);
  }

  /**
   * Iterator of user-placed atoms.
   * 
   * @return ArrayList
   */
  public ArrayList <Position> getUserAtoms() {
    return userAtoms;
  }

  /**
   * Gets the game atoms.
   * 
   * @return ArrayList
   */
  public ArrayList <Position> getAtoms() {
    return atoms;
  }

  /**
   * Iterator of user-placed rays.
   * 
   * @return ArrayList
   */
  public ArrayList <Position[]> getUserRays() {
    return userRays;
  }

  /**
   * Deletes a user atom guess on the game board.
   * 
   * @param pos
   */
  public void deleteUserAtom(Position pos) {
    Iterator <Position> itr = userAtoms.iterator();
    while (itr.hasNext()) {
      Position i = itr.next();
      if (i == pos) {
        itr.remove();
      }
    }
  }

}
