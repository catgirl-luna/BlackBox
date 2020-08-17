package blackBox;

import java.awt.Color;
import java.awt.EventQueue;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Controls what happens on the game board. Instructions are sent to class View
 * for displaying, class Model for storing and class Calculator for routing the
 * rays.
 * 
 * @author noah
 */
public class Controller implements ViewListener {

  /**
   * 
   */
  boolean lock; // True if solve in progress.
  private View view;
  private Model model;
  private Calculator calculator;
  private int currNum;
  private Position hitPos = new Position(-1, -1);
  private Position reflectPos = new Position(-2, -2);

  /**
   * Run the controller for testing purposes.
   * 
   * @param args not used
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      @Override
      public void run() {
        try {
          new Controller();
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });

  }

  /**
   * Initializes important variables and starts a new game.
   */
  public Controller() {
    view = new View(this);
    model = new Model();
    calculator = new Calculator();
    currNum = 1;
    lock = true;
    newGame();
  }

  /**
   * Adds or deletes an atom. If TEST active (see class BlackBoxRobot) user
   * placed atoms also become "generated" atoms.
   * 
   * @param pos       where the atom is located
   * @param atomState true if atom in grid
   */
  @Override
  public void atomButton(Position pos, boolean atomState) {
    if (lock) {
      return;
    }

    // If TEST active user placed atoms also become "generated" atoms.
    ArrayList <Position> userAtoms = model.getUserAtoms();
    if (atomState) {
      model.deleteUserAtom(pos);
      if (BlackBox.TEST) {
        model.deleteAtom(pos);
        calculator.setAtom(pos, false);
      }
      view.setAtom(pos, false);
      return;
    }
    if (userAtoms.size() >= 4) {
      view.atomSizeMessage();
      return;
    }
    model.setUserAtom(pos);
    if (BlackBox.TEST) {
      model.setAtom(pos);
      calculator.setAtom(pos, true);
    }
    view.setAtom(pos, true);
  }

  /**
   * Set the ray position and number. The number is displayed on the ray to help
   * the user identify where the ray entered and exited.
   * 
   * @param pos    location of the ray
   * @param number number of the ray
   */
  @Override
  public void rayButton(Position pos, int number) {
    if (lock) {
      return;
    }
    Position[] upos;
    Iterator <Position[]> itr = model.getUserRays().iterator();
    while (itr.hasNext()) {
      upos = itr.next();
      if (pos.equals(upos[0]) || pos.equals(upos[1])) {
        view.rayInUseMessage();
        return;
      }
    }
    Position[] apos = calculator.calculateRays(pos);
    model.addUserRay(apos);
    Color[] p;
    int score = 1;
    if (hitPos.equals(apos[1])) {
      p = view.getHitColor();
      view.setRayData(pos, -1, p[0], p[1]);
    } else if (reflectPos.equals(apos[1])) {
      p = view.getReflectColor();
      view.setRayData(pos, -2, p[0], p[1]);
    } else {
      Color color = view.getNextColor();
      view.setRayData(apos[0], currNum, color);
      view.setRayData(apos[1], currNum, color);
      score++;
      currNum++;
    }
    view.setScore(model.increaseScore(score));
  }

  /**
   * Quits the game after checking whether it has been solved and asking the
   * user for confirmation if it has not been solved.
   */
  @Override
  public void quit() {
    if (!lock) {
      if (!view.quitMessage()) {
        return;
      }
    }
    System.exit(0);
  }

  /**
   * Clears the board for a new game after checking whether it has been solved
   * and asking the user for confirmation if it has not been solved.
   */
  @Override
  public void newGame() {
    if (!lock) {
      if (!view.newGameNotSolved()) {
        return;
      }
    }
    view.setAtomDefault();
    view.setRayDefault();
    view.resetScore();
    currNum = 1;
    model.resetModel();
    // If the TEST and ROBOT are not active generate random atoms.
    if (!BlackBox.TEST && !BlackBox.ROBOT) {
      ArrayList <Position> list = null;
      try {
        list = calculator.createAtoms();
      } catch (NoSuchAlgorithmException | NoSuchProviderException e) {
        e.printStackTrace();
      }
      @SuppressWarnings ("null")
      Iterator <Position> itr = list.iterator();
      while (itr.hasNext()) {
        model.setAtom(itr.next());
      }
    } else {
      calculator.clearAtoms();
    }
    lock = false;
  }

  /**
   * Solves the game, shows incorrect atom guesses, updates the score for each
   * incorrect guess, and locks the board so it cannot be messed with.
   */
  @Override
  public void solve() {
    if (lock) {
      return;
    }
    ArrayList <Position> userAtoms = model.getUserAtoms();
    if (userAtoms.size() != 4) {
      boolean result = view.missingAtomsMessage();
      if (result) {
      } else {
        return;
      }
    }
    model.increaseScore( (4 - userAtoms.size()) * 5);
    ArrayList <Position> atoms = model.getAtoms();
    Iterator <Position> itr = atoms.iterator();
    Iterator <Position> uitr = userAtoms.iterator();
    Position pos;
    boolean match;
    while (itr.hasNext()) {
      view.setAtomGreen(itr.next());
    }
    while (uitr.hasNext()) {
      pos = uitr.next();
      itr = atoms.iterator();
      match = false;
      while (itr.hasNext()) {
        if (pos.equals(itr.next())) {
          match = true;
          break;
        }
      }
      if (!match) {
        view.setAtomRed(pos);
        model.increaseScore(5);
      }
    }
    view.setScore(model.getScore());
    lock = true;
  }

  /**
   * Sets the "generated" atom to true. Used by the BlackBoxRobot class.
   * 
   * @param pos atom position to set true
   */
  protected void setAtom(Position pos) {
    model.setAtom(pos);
    calculator.setAtom(pos, true);
  }
}
