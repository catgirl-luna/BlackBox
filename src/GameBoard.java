package blackBox;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

/**
 * Class to handle the GUI.
 * 
 * @author noah
 */
public class GameBoard extends JFrame {

  private static final long serialVersionUID = 1L;
  private final Icon clearIcon;
  private final Icon atomIcon;
  private final Color rayBgndColor;
  private final JButton[][] atomButtons;
  private final JButton[][] rayButtons;
  private final GameBoardListener listener;

  private JButton n0Btn;
  private JButton n1Btn;
  private JButton n2Btn;
  private JButton n3Btn;
  private JButton n4Btn;
  private JButton n5Btn;
  private JButton n6Btn;
  private JButton n7Btn;
  private JButton w0Btn;
  private JButton w1Btn;
  private JButton w2Btn;
  private JButton w3Btn;
  private JButton w4Btn;
  private JButton w5Btn;
  private JButton w6Btn;
  private JButton w7Btn;
  private JButton e0Btn;
  private JButton e1Btn;
  private JButton e2Btn;
  private JButton e3Btn;
  private JButton e4Btn;
  private JButton e5Btn;
  private JButton e6Btn;
  private JButton e7Btn;
  private JButton s0Btn;
  private JButton s1Btn;
  private JButton s2Btn;
  private JButton s3Btn;
  private JButton s4Btn;
  private JButton s5Btn;
  private JButton s6Btn;
  private JButton s7Btn;
  private JButton a0x0Btn;
  private JButton a0x1Btn;
  private JButton a0x2Btn;
  private JButton a0x3Btn;
  private JButton a0x4Btn;
  private JButton a0x5Btn;
  private JButton a0x6Btn;
  private JButton a0x7Btn;
  private JButton a1x0Btn;
  private JButton a1x1Btn;
  private JButton a1x2Btn;
  private JButton a1x3Btn;
  private JButton a1x4Btn;
  private JButton a1x5Btn;
  private JButton a1x6Btn;
  private JButton a1x7Btn;
  private JButton a2x0Btn;
  private JButton a2x1Btn;
  private JButton a2x2Btn;
  private JButton a2x3Btn;
  private JButton a2x4Btn;
  private JButton a2x5Btn;
  private JButton a2x6Btn;
  private JButton a2x7Btn;
  private JButton a3x0Btn;
  private JButton a3x1Btn;
  private JButton a3x2Btn;
  private JButton a3x3Btn;
  private JButton a3x4Btn;
  private JButton a3x5Btn;
  private JButton a3x6Btn;
  private JButton a3x7Btn;
  private JButton a4x0Btn;
  private JButton a4x1Btn;
  private JButton a4x2Btn;
  private JButton a4x3Btn;
  private JButton a5x0Btn;
  private JButton a5x1Btn;
  private JButton a5x2Btn;
  private JButton a5x3Btn;
  private JButton a6x0Btn;
  private JButton a6x1Btn;
  private JButton a6x2Btn;
  private JButton a6x3Btn;
  private JButton a7x0Btn;
  private JButton a7x1Btn;
  private JButton a7x2Btn;
  private JButton a7x3Btn;
  private JButton a4x4Btn;
  private JButton a4x5Btn;
  private JButton a4x6Btn;
  private JButton a4x7Btn;
  private JButton a5x4Btn;
  private JButton a5x5Btn;
  private JButton a5x6Btn;
  private JButton a5x7Btn;
  private JButton a6x4Btn;
  private JButton a6x5Btn;
  private JButton a6x6Btn;
  private JButton a6x7Btn;
  private JButton a7x4Btn;
  private JButton a7x5Btn;
  private JButton a7x6Btn;
  private JButton a7x7Btn;
  private JMenuBar menuBar;
  private JMenu mnFile;
  private JMenuItem mntmQuit;
  private JMenuItem mntmSolve;
  private JMenuItem mntmNewGame;
  private JMenu mnHelp;
  private JMenuItem mntmAbout;
  private JPanel pnlNorth;
  private JLabel lblScore;
  private JTextField txtFldScore;
  private JMenuItem mntmHelp;

  /**
   * Launch the application.
   * 
   * @param args
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      @Override
      public void run() {
        try {
          new GameBoard(null);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  /**
   * Create the application.
   * 
   * @param boardListener
   */
  public GameBoard(GameBoardListener boardListener) {
    // Set listener and capture close event to redirect to controller quit.
    listener = boardListener;
    setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
    addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        listener.quit();
      }
    });

    setTitle("BlackBox Game");
    clearIcon = new ImageIcon(getClass().getResource("/Clear.png"));
    atomIcon = new ImageIcon(getClass().getResource("/Atom.png"));
    rayBgndColor = Color.LIGHT_GRAY;
    atomButtons = new AtomJButton[8][8];
    rayButtons = new RayJButton[4][8];
    initialize();
    setRayDefault();
    setAtomDefault();
    pack();
    setVisible(true);
  }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    setResizable(false);
    setMinimumSize(new Dimension(540, 580));
    setMaximumSize(new Dimension(540, 580));
    setBounds(100, 100, 540, 580);
    JPanel board = new JPanel();
    getContentPane().add(board, BorderLayout.CENTER);
    board.setLayout(new BorderLayout(0, 0));

    pnlNorth = new JPanel();
    FlowLayout flowLayout = (FlowLayout) pnlNorth.getLayout();
    flowLayout.setAlignment(FlowLayout.RIGHT);
    pnlNorth.setRequestFocusEnabled(false);
    board.add(pnlNorth, BorderLayout.NORTH);

    lblScore = new JLabel("Score:");
    pnlNorth.add(lblScore);

    txtFldScore = new JTextField();
    txtFldScore.setRequestFocusEnabled(false);
    txtFldScore.setEditable(false);
    pnlNorth.add(txtFldScore);
    txtFldScore.setColumns(10);

    JPanel grid = new JPanel();
    board.add(grid, BorderLayout.CENTER);
    GridBagLayout gbl_grid = new GridBagLayout();
    gbl_grid.columnWeights = new double[] {
        0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0
    };
    gbl_grid.rowWeights = new double[] {
        0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0
    };
    grid.setLayout(gbl_grid);

    // Create the atom and ray buttons.
    n0Btn = new RayJButton(Direction.NORTH, 0);
    rayButtons[Direction.NORTH.value][0] = n0Btn;
    n0Btn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        n0BtnActionPerformed(arg0);
      }
    });
    n0Btn.setMargin(new Insets(2, 2, 2, 2));
    n0Btn.setHorizontalTextPosition(SwingConstants.CENTER);
    n0Btn.setMinimumSize(new Dimension(40, 40));
    n0Btn.setMaximumSize(new Dimension(40, 40));
    n0Btn.setPreferredSize(new Dimension(40, 40));
    GridBagConstraints gbc_n0Btn = new GridBagConstraints();
    gbc_n0Btn.fill = GridBagConstraints.BOTH;
    gbc_n0Btn.insets = new Insets(0, 0, 5, 5);
    gbc_n0Btn.gridx = 1;
    gbc_n0Btn.gridy = 0;
    grid.add(n0Btn, gbc_n0Btn);

    n1Btn = new RayJButton(Direction.NORTH, 1);
    rayButtons[Direction.NORTH.value][1] = n1Btn;
    n1Btn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        n1BtnActionPerformed(arg0);
      }
    });
    n1Btn.setMargin(new Insets(2, 2, 2, 2));
    n1Btn.setHorizontalTextPosition(SwingConstants.CENTER);
    n1Btn.setMinimumSize(new Dimension(40, 40));
    n1Btn.setMaximumSize(new Dimension(40, 40));
    n1Btn.setPreferredSize(new Dimension(40, 40));
    GridBagConstraints gbc_n1Btn = new GridBagConstraints();
    gbc_n1Btn.fill = GridBagConstraints.BOTH;
    gbc_n1Btn.insets = new Insets(0, 0, 5, 5);
    gbc_n1Btn.gridx = 2;
    gbc_n1Btn.gridy = 0;
    grid.add(n1Btn, gbc_n1Btn);

    n2Btn = new RayJButton(Direction.NORTH, 2);
    rayButtons[Direction.NORTH.value][2] = n2Btn;
    n2Btn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        n2BtnActionPerformed(arg0);
      }
    });
    n2Btn.setMargin(new Insets(2, 2, 2, 2));
    n2Btn.setHorizontalTextPosition(SwingConstants.CENTER);
    n2Btn.setMinimumSize(new Dimension(40, 40));
    n2Btn.setMaximumSize(new Dimension(40, 40));
    n2Btn.setPreferredSize(new Dimension(40, 40));
    GridBagConstraints gbc_n2Btn = new GridBagConstraints();
    gbc_n2Btn.fill = GridBagConstraints.BOTH;
    gbc_n2Btn.insets = new Insets(0, 0, 5, 5);
    gbc_n2Btn.gridx = 3;
    gbc_n2Btn.gridy = 0;
    grid.add(n2Btn, gbc_n2Btn);

    n3Btn = new RayJButton(Direction.NORTH, 3);
    rayButtons[Direction.NORTH.value][3] = n3Btn;
    n3Btn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        n3BtnActionPerformed(arg0);
      }
    });
    n3Btn.setMargin(new Insets(2, 2, 2, 2));
    n3Btn.setHorizontalTextPosition(SwingConstants.CENTER);
    n3Btn.setMinimumSize(new Dimension(40, 40));
    n3Btn.setMaximumSize(new Dimension(40, 40));
    n3Btn.setPreferredSize(new Dimension(40, 40));
    GridBagConstraints gbc_n3Btn = new GridBagConstraints();
    gbc_n3Btn.fill = GridBagConstraints.BOTH;
    gbc_n3Btn.insets = new Insets(0, 0, 5, 5);
    gbc_n3Btn.gridx = 4;
    gbc_n3Btn.gridy = 0;
    grid.add(n3Btn, gbc_n3Btn);

    n4Btn = new RayJButton(Direction.NORTH, 4);
    rayButtons[Direction.NORTH.value][4] = n4Btn;
    n4Btn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        n4BtnActionPerformed(arg0);
      }
    });
    n4Btn.setMargin(new Insets(2, 2, 2, 2));
    n4Btn.setHorizontalTextPosition(SwingConstants.CENTER);
    n4Btn.setMinimumSize(new Dimension(40, 40));
    n4Btn.setMaximumSize(new Dimension(40, 40));
    n4Btn.setPreferredSize(new Dimension(40, 40));
    GridBagConstraints gbc_n4Btn = new GridBagConstraints();
    gbc_n4Btn.fill = GridBagConstraints.BOTH;
    gbc_n4Btn.insets = new Insets(0, 0, 5, 5);
    gbc_n4Btn.gridx = 5;
    gbc_n4Btn.gridy = 0;
    grid.add(n4Btn, gbc_n4Btn);

    n5Btn = new RayJButton(Direction.NORTH, 5);
    rayButtons[Direction.NORTH.value][5] = n5Btn;
    n5Btn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        n5BtnActionPerformed(arg0);
      }
    });
    n5Btn.setMargin(new Insets(2, 2, 2, 2));
    n5Btn.setHorizontalTextPosition(SwingConstants.CENTER);
    n5Btn.setMinimumSize(new Dimension(40, 40));
    n5Btn.setMaximumSize(new Dimension(40, 40));
    n5Btn.setPreferredSize(new Dimension(40, 40));
    GridBagConstraints gbc_n5Btn = new GridBagConstraints();
    gbc_n5Btn.fill = GridBagConstraints.BOTH;
    gbc_n5Btn.insets = new Insets(0, 0, 5, 5);
    gbc_n5Btn.gridx = 6;
    gbc_n5Btn.gridy = 0;
    grid.add(n5Btn, gbc_n5Btn);

    n6Btn = new RayJButton(Direction.NORTH, 6);
    rayButtons[Direction.NORTH.value][6] = n6Btn;
    n6Btn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        n6BtnActionPerformed(arg0);
      }
    });
    n6Btn.setMargin(new Insets(2, 2, 2, 2));
    n6Btn.setHorizontalTextPosition(SwingConstants.CENTER);
    n6Btn.setMinimumSize(new Dimension(40, 40));
    n6Btn.setMaximumSize(new Dimension(40, 40));
    n6Btn.setPreferredSize(new Dimension(40, 40));
    GridBagConstraints gbc_n6Btn = new GridBagConstraints();
    gbc_n6Btn.fill = GridBagConstraints.BOTH;
    gbc_n6Btn.insets = new Insets(0, 0, 5, 5);
    gbc_n6Btn.gridx = 7;
    gbc_n6Btn.gridy = 0;
    grid.add(n6Btn, gbc_n6Btn);

    n7Btn = new RayJButton(Direction.NORTH, 7);
    rayButtons[Direction.NORTH.value][7] = n7Btn;
    n7Btn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        n7BtnActionPerformed(arg0);
      }
    });
    n7Btn.setMargin(new Insets(2, 2, 2, 2));
    n7Btn.setHorizontalTextPosition(SwingConstants.CENTER);
    n7Btn.setMinimumSize(new Dimension(40, 40));
    n7Btn.setMaximumSize(new Dimension(40, 40));
    n7Btn.setPreferredSize(new Dimension(40, 40));
    GridBagConstraints gbc_n7Btn = new GridBagConstraints();
    gbc_n7Btn.fill = GridBagConstraints.BOTH;
    gbc_n7Btn.insets = new Insets(0, 0, 5, 5);
    gbc_n7Btn.gridx = 8;
    gbc_n7Btn.gridy = 0;
    grid.add(n7Btn, gbc_n7Btn);

    w0Btn = new RayJButton(Direction.WEST, 0);
    rayButtons[Direction.WEST.value][0] = w0Btn;
    w0Btn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        w0BtnActionPerformed(arg0);
      }
    });
    w0Btn.setMargin(new Insets(2, 2, 2, 2));
    w0Btn.setHorizontalTextPosition(SwingConstants.CENTER);
    w0Btn.setMinimumSize(new Dimension(40, 40));
    w0Btn.setMaximumSize(new Dimension(40, 40));
    w0Btn.setPreferredSize(new Dimension(40, 40));
    GridBagConstraints gbc_w0Btn = new GridBagConstraints();
    gbc_w0Btn.fill = GridBagConstraints.BOTH;
    gbc_w0Btn.insets = new Insets(0, 0, 5, 5);
    gbc_w0Btn.gridx = 0;
    gbc_w0Btn.gridy = 1;
    grid.add(w0Btn, gbc_w0Btn);

    w1Btn = new RayJButton(Direction.WEST, 1);
    rayButtons[Direction.WEST.value][1] = w1Btn;
    w1Btn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        w1BtnActionPerformed(arg0);
      }
    });
    w1Btn.setMargin(new Insets(2, 2, 2, 2));
    w1Btn.setHorizontalTextPosition(SwingConstants.CENTER);
    w1Btn.setMinimumSize(new Dimension(40, 40));
    w1Btn.setMaximumSize(new Dimension(40, 40));
    w1Btn.setPreferredSize(new Dimension(40, 40));
    GridBagConstraints gbc_w1Btn = new GridBagConstraints();
    gbc_w1Btn.fill = GridBagConstraints.BOTH;
    gbc_w1Btn.insets = new Insets(0, 0, 5, 5);
    gbc_w1Btn.gridx = 0;
    gbc_w1Btn.gridy = 2;
    grid.add(w1Btn, gbc_w1Btn);

    w2Btn = new RayJButton(Direction.WEST, 2);
    rayButtons[Direction.WEST.value][2] = w2Btn;
    w2Btn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        w2BtnActionPerformed(arg0);
      }
    });
    w2Btn.setMargin(new Insets(2, 2, 2, 2));
    w2Btn.setHorizontalTextPosition(SwingConstants.CENTER);
    w2Btn.setMinimumSize(new Dimension(40, 40));
    w2Btn.setMaximumSize(new Dimension(40, 40));
    w2Btn.setPreferredSize(new Dimension(40, 40));
    GridBagConstraints gbc_w2Btn = new GridBagConstraints();
    gbc_w2Btn.fill = GridBagConstraints.BOTH;
    gbc_w2Btn.insets = new Insets(0, 0, 5, 5);
    gbc_w2Btn.gridx = 0;
    gbc_w2Btn.gridy = 3;
    grid.add(w2Btn, gbc_w2Btn);

    w3Btn = new RayJButton(Direction.WEST, 3);
    rayButtons[Direction.WEST.value][3] = w3Btn;
    w3Btn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        w3BtnActionPerformed(arg0);
      }
    });
    w3Btn.setMargin(new Insets(2, 2, 2, 2));
    w3Btn.setHorizontalTextPosition(SwingConstants.CENTER);
    w3Btn.setMinimumSize(new Dimension(40, 40));
    w3Btn.setMaximumSize(new Dimension(40, 40));
    w3Btn.setPreferredSize(new Dimension(40, 40));
    GridBagConstraints gbc_w3Btn = new GridBagConstraints();
    gbc_w3Btn.fill = GridBagConstraints.BOTH;
    gbc_w3Btn.insets = new Insets(0, 0, 5, 5);
    gbc_w3Btn.gridx = 0;
    gbc_w3Btn.gridy = 4;
    grid.add(w3Btn, gbc_w3Btn);

    w4Btn = new RayJButton(Direction.WEST, 4);
    rayButtons[Direction.WEST.value][4] = w4Btn;
    w4Btn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        w4BtnActionPerformed(arg0);
      }
    });
    w4Btn.setMargin(new Insets(2, 2, 2, 2));
    w4Btn.setHorizontalTextPosition(SwingConstants.CENTER);
    w4Btn.setMinimumSize(new Dimension(40, 40));
    w4Btn.setMaximumSize(new Dimension(40, 40));
    w4Btn.setPreferredSize(new Dimension(40, 40));
    GridBagConstraints gbc_w4Btn = new GridBagConstraints();
    gbc_w4Btn.fill = GridBagConstraints.BOTH;
    gbc_w4Btn.insets = new Insets(0, 0, 5, 5);
    gbc_w4Btn.gridx = 0;
    gbc_w4Btn.gridy = 5;
    grid.add(w4Btn, gbc_w4Btn);

    w5Btn = new RayJButton(Direction.WEST, 5);
    rayButtons[Direction.WEST.value][5] = w5Btn;
    w5Btn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        w5BtnActionPerformed(arg0);
      }
    });
    w5Btn.setMargin(new Insets(2, 2, 2, 2));
    w5Btn.setHorizontalTextPosition(SwingConstants.CENTER);
    w5Btn.setMinimumSize(new Dimension(40, 40));
    w5Btn.setMaximumSize(new Dimension(40, 40));
    w5Btn.setPreferredSize(new Dimension(40, 40));
    GridBagConstraints gbc_w5Btn = new GridBagConstraints();
    gbc_w5Btn.fill = GridBagConstraints.BOTH;
    gbc_w5Btn.insets = new Insets(0, 0, 5, 5);
    gbc_w5Btn.gridx = 0;
    gbc_w5Btn.gridy = 6;
    grid.add(w5Btn, gbc_w5Btn);

    w6Btn = new RayJButton(Direction.WEST, 6);
    rayButtons[Direction.WEST.value][6] = w6Btn;
    w6Btn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        w6BtnActionPerformed(arg0);
      }
    });
    w6Btn.setMargin(new Insets(2, 2, 2, 2));
    w6Btn.setHorizontalTextPosition(SwingConstants.CENTER);
    w6Btn.setMinimumSize(new Dimension(40, 40));
    w6Btn.setMaximumSize(new Dimension(40, 40));
    w6Btn.setPreferredSize(new Dimension(40, 40));
    GridBagConstraints gbc_w6Btn = new GridBagConstraints();
    gbc_w6Btn.fill = GridBagConstraints.BOTH;
    gbc_w6Btn.insets = new Insets(0, 0, 5, 5);
    gbc_w6Btn.gridx = 0;
    gbc_w6Btn.gridy = 7;
    grid.add(w6Btn, gbc_w6Btn);

    w7Btn = new RayJButton(Direction.WEST, 7);
    rayButtons[Direction.WEST.value][7] = w7Btn;
    w7Btn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        w7BtnActionPerformed(arg0);
      }
    });
    w7Btn.setMargin(new Insets(2, 2, 2, 2));
    w7Btn.setHorizontalTextPosition(SwingConstants.CENTER);
    w7Btn.setMinimumSize(new Dimension(40, 40));
    w7Btn.setMaximumSize(new Dimension(40, 40));
    w7Btn.setPreferredSize(new Dimension(40, 40));
    GridBagConstraints gbc_w7Btn = new GridBagConstraints();
    gbc_w7Btn.fill = GridBagConstraints.BOTH;
    gbc_w7Btn.insets = new Insets(0, 0, 5, 5);
    gbc_w7Btn.gridx = 0;
    gbc_w7Btn.gridy = 8;
    grid.add(w7Btn, gbc_w7Btn);

    e0Btn = new RayJButton(Direction.EAST, 0);
    rayButtons[Direction.EAST.value][0] = e0Btn;
    e0Btn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        e0BtnActionPerformed(arg0);
      }
    });
    e0Btn.setMargin(new Insets(2, 2, 2, 2));
    e0Btn.setHorizontalTextPosition(SwingConstants.CENTER);
    e0Btn.setMinimumSize(new Dimension(40, 40));
    e0Btn.setMaximumSize(new Dimension(40, 40));
    e0Btn.setPreferredSize(new Dimension(40, 40));
    GridBagConstraints gbc_e0Btn = new GridBagConstraints();
    gbc_e0Btn.fill = GridBagConstraints.BOTH;
    gbc_e0Btn.insets = new Insets(0, 0, 5, 0);
    gbc_e0Btn.gridx = 9;
    gbc_e0Btn.gridy = 1;
    grid.add(e0Btn, gbc_e0Btn);

    e1Btn = new RayJButton(Direction.EAST, 1);
    rayButtons[Direction.EAST.value][1] = e1Btn;
    e1Btn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        e1BtnActionPerformed(arg0);
      }
    });
    e1Btn.setMargin(new Insets(2, 2, 2, 2));
    e1Btn.setHorizontalTextPosition(SwingConstants.CENTER);
    e1Btn.setMinimumSize(new Dimension(40, 40));
    e1Btn.setMaximumSize(new Dimension(40, 40));
    e1Btn.setPreferredSize(new Dimension(40, 40));
    GridBagConstraints gbc_e1Btn = new GridBagConstraints();
    gbc_e1Btn.fill = GridBagConstraints.BOTH;
    gbc_e1Btn.insets = new Insets(0, 0, 5, 0);
    gbc_e1Btn.gridx = 9;
    gbc_e1Btn.gridy = 2;
    grid.add(e1Btn, gbc_e1Btn);

    e2Btn = new RayJButton(Direction.EAST, 2);
    rayButtons[Direction.EAST.value][2] = e2Btn;
    e2Btn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        e2BtnActionPerformed(arg0);
      }
    });
    e2Btn.setMargin(new Insets(2, 2, 2, 2));
    e2Btn.setHorizontalTextPosition(SwingConstants.CENTER);
    e2Btn.setMinimumSize(new Dimension(40, 40));
    e2Btn.setMaximumSize(new Dimension(40, 40));
    e2Btn.setPreferredSize(new Dimension(40, 40));
    GridBagConstraints gbc_e2Btn = new GridBagConstraints();
    gbc_e2Btn.fill = GridBagConstraints.BOTH;
    gbc_e2Btn.insets = new Insets(0, 0, 5, 0);
    gbc_e2Btn.gridx = 9;
    gbc_e2Btn.gridy = 3;
    grid.add(e2Btn, gbc_e2Btn);

    e3Btn = new RayJButton(Direction.EAST, 3);
    rayButtons[Direction.EAST.value][3] = e3Btn;
    e3Btn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        e3BtnActionPerformed(arg0);
      }
    });
    e3Btn.setMargin(new Insets(2, 2, 2, 2));
    e3Btn.setHorizontalTextPosition(SwingConstants.CENTER);
    e3Btn.setMinimumSize(new Dimension(40, 40));
    e3Btn.setMaximumSize(new Dimension(40, 40));
    e3Btn.setPreferredSize(new Dimension(40, 40));
    GridBagConstraints gbc_e3Btn = new GridBagConstraints();
    gbc_e3Btn.fill = GridBagConstraints.BOTH;
    gbc_e3Btn.insets = new Insets(0, 0, 5, 0);
    gbc_e3Btn.gridx = 9;
    gbc_e3Btn.gridy = 4;
    grid.add(e3Btn, gbc_e3Btn);

    e4Btn = new RayJButton(Direction.EAST, 4);
    rayButtons[Direction.EAST.value][4] = e4Btn;
    e4Btn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        e4BtnActionPerformed(arg0);
      }
    });
    e4Btn.setMargin(new Insets(2, 2, 2, 2));
    e4Btn.setHorizontalTextPosition(SwingConstants.CENTER);
    e4Btn.setMinimumSize(new Dimension(40, 40));
    e4Btn.setMaximumSize(new Dimension(40, 40));
    e4Btn.setPreferredSize(new Dimension(40, 40));
    GridBagConstraints gbc_e4Btn = new GridBagConstraints();
    gbc_e4Btn.fill = GridBagConstraints.BOTH;
    gbc_e4Btn.insets = new Insets(0, 0, 5, 0);
    gbc_e4Btn.gridx = 9;
    gbc_e4Btn.gridy = 5;
    grid.add(e4Btn, gbc_e4Btn);

    e5Btn = new RayJButton(Direction.EAST, 5);
    rayButtons[Direction.EAST.value][5] = e5Btn;
    e5Btn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        e5BtnActionPerformed(arg0);
      }
    });
    e5Btn.setMargin(new Insets(2, 2, 2, 2));
    e5Btn.setHorizontalTextPosition(SwingConstants.CENTER);
    e5Btn.setMinimumSize(new Dimension(40, 40));
    e5Btn.setMaximumSize(new Dimension(40, 40));
    e5Btn.setPreferredSize(new Dimension(40, 40));
    GridBagConstraints gbc_e5Btn = new GridBagConstraints();
    gbc_e5Btn.fill = GridBagConstraints.BOTH;
    gbc_e5Btn.insets = new Insets(0, 0, 5, 0);
    gbc_e5Btn.gridx = 9;
    gbc_e5Btn.gridy = 6;
    grid.add(e5Btn, gbc_e5Btn);

    e6Btn = new RayJButton(Direction.EAST, 6);
    rayButtons[Direction.EAST.value][6] = e6Btn;
    e6Btn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        e6BtnActionPerformed(arg0);
      }
    });
    e6Btn.setMargin(new Insets(2, 2, 2, 2));
    e6Btn.setHorizontalTextPosition(SwingConstants.CENTER);
    e6Btn.setMinimumSize(new Dimension(40, 40));
    e6Btn.setMaximumSize(new Dimension(40, 40));
    e6Btn.setPreferredSize(new Dimension(40, 40));
    GridBagConstraints gbc_e6Btn = new GridBagConstraints();
    gbc_e6Btn.fill = GridBagConstraints.BOTH;
    gbc_e6Btn.insets = new Insets(0, 0, 5, 0);
    gbc_e6Btn.gridx = 9;
    gbc_e6Btn.gridy = 7;
    grid.add(e6Btn, gbc_e6Btn);

    e7Btn = new RayJButton(Direction.EAST, 7);
    rayButtons[Direction.EAST.value][7] = e7Btn;
    e7Btn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        e7BtnActionPerformed(arg0);
      }
    });
    e7Btn.setMargin(new Insets(2, 2, 2, 2));
    e7Btn.setHorizontalTextPosition(SwingConstants.CENTER);
    e7Btn.setMinimumSize(new Dimension(40, 40));
    e7Btn.setMaximumSize(new Dimension(40, 40));
    e7Btn.setPreferredSize(new Dimension(40, 40));
    GridBagConstraints gbc_e7Btn = new GridBagConstraints();
    gbc_e7Btn.fill = GridBagConstraints.BOTH;
    gbc_e7Btn.insets = new Insets(0, 0, 5, 0);
    gbc_e7Btn.gridx = 9;
    gbc_e7Btn.gridy = 8;
    grid.add(e7Btn, gbc_e7Btn);

    s0Btn = new RayJButton(Direction.SOUTH, 0);
    rayButtons[Direction.SOUTH.value][0] = s0Btn;
    s0Btn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        s0BtnActionPerformed(arg0);
      }
    });
    s0Btn.setMargin(new Insets(2, 2, 2, 2));
    s0Btn.setHorizontalTextPosition(SwingConstants.CENTER);
    s0Btn.setMinimumSize(new Dimension(40, 40));
    s0Btn.setMaximumSize(new Dimension(40, 40));
    s0Btn.setPreferredSize(new Dimension(40, 40));
    GridBagConstraints gbc_s0Btn = new GridBagConstraints();
    gbc_s0Btn.fill = GridBagConstraints.BOTH;
    gbc_s0Btn.insets = new Insets(0, 0, 0, 5);
    gbc_s0Btn.gridx = 1;
    gbc_s0Btn.gridy = 9;
    grid.add(s0Btn, gbc_s0Btn);

    s1Btn = new RayJButton(Direction.SOUTH, 1);
    rayButtons[Direction.SOUTH.value][1] = s1Btn;
    s1Btn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        s1BtnActionPerformed(arg0);
      }
    });
    s1Btn.setMargin(new Insets(2, 2, 2, 2));
    s1Btn.setHorizontalTextPosition(SwingConstants.CENTER);
    s1Btn.setMinimumSize(new Dimension(40, 40));
    s1Btn.setMaximumSize(new Dimension(40, 40));
    s1Btn.setPreferredSize(new Dimension(40, 40));
    GridBagConstraints gbc_s1Btn = new GridBagConstraints();
    gbc_s1Btn.fill = GridBagConstraints.BOTH;
    gbc_s1Btn.insets = new Insets(0, 0, 0, 5);
    gbc_s1Btn.gridx = 2;
    gbc_s1Btn.gridy = 9;
    grid.add(s1Btn, gbc_s1Btn);

    s2Btn = new RayJButton(Direction.SOUTH, 2);
    rayButtons[Direction.SOUTH.value][2] = s2Btn;
    s2Btn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        s2BtnActionPerformed(arg0);
      }
    });
    s2Btn.setMargin(new Insets(2, 2, 2, 2));
    s2Btn.setHorizontalTextPosition(SwingConstants.CENTER);
    s2Btn.setMinimumSize(new Dimension(40, 40));
    s2Btn.setMaximumSize(new Dimension(40, 40));
    s2Btn.setPreferredSize(new Dimension(40, 40));
    GridBagConstraints gbc_s2Btn = new GridBagConstraints();
    gbc_s2Btn.fill = GridBagConstraints.BOTH;
    gbc_s2Btn.insets = new Insets(0, 0, 0, 5);
    gbc_s2Btn.gridx = 3;
    gbc_s2Btn.gridy = 9;
    grid.add(s2Btn, gbc_s2Btn);

    s3Btn = new RayJButton(Direction.SOUTH, 3);
    rayButtons[Direction.SOUTH.value][3] = s3Btn;
    s3Btn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        s3BtnActionPerformed(arg0);
      }
    });
    s3Btn.setMargin(new Insets(2, 2, 2, 2));
    s3Btn.setHorizontalTextPosition(SwingConstants.CENTER);
    s3Btn.setMinimumSize(new Dimension(40, 40));
    s3Btn.setMaximumSize(new Dimension(40, 40));
    s3Btn.setPreferredSize(new Dimension(40, 40));
    GridBagConstraints gbc_s3Btn = new GridBagConstraints();
    gbc_s3Btn.fill = GridBagConstraints.BOTH;
    gbc_s3Btn.insets = new Insets(0, 0, 0, 5);
    gbc_s3Btn.gridx = 4;
    gbc_s3Btn.gridy = 9;
    grid.add(s3Btn, gbc_s3Btn);

    s4Btn = new RayJButton(Direction.SOUTH, 4);
    rayButtons[Direction.SOUTH.value][4] = s4Btn;
    s4Btn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        s4BtnActionPerformed(arg0);
      }
    });
    s4Btn.setMargin(new Insets(2, 2, 2, 2));
    s4Btn.setHorizontalTextPosition(SwingConstants.CENTER);
    s4Btn.setMinimumSize(new Dimension(40, 40));
    s4Btn.setMaximumSize(new Dimension(40, 40));
    s4Btn.setPreferredSize(new Dimension(40, 40));
    GridBagConstraints gbc_s4Btn = new GridBagConstraints();
    gbc_s4Btn.fill = GridBagConstraints.BOTH;
    gbc_s4Btn.insets = new Insets(0, 0, 0, 5);
    gbc_s4Btn.gridx = 5;
    gbc_s4Btn.gridy = 9;
    grid.add(s4Btn, gbc_s4Btn);

    s5Btn = new RayJButton(Direction.SOUTH, 5);
    rayButtons[Direction.SOUTH.value][5] = s5Btn;
    s5Btn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        s5BtnActionPerformed(arg0);
      }
    });
    s5Btn.setMargin(new Insets(2, 2, 2, 2));
    s5Btn.setHorizontalTextPosition(SwingConstants.CENTER);
    s5Btn.setMinimumSize(new Dimension(40, 40));
    s5Btn.setMaximumSize(new Dimension(40, 40));
    s5Btn.setPreferredSize(new Dimension(40, 40));
    GridBagConstraints gbc_s5Btn = new GridBagConstraints();
    gbc_s5Btn.fill = GridBagConstraints.BOTH;
    gbc_s5Btn.insets = new Insets(0, 0, 0, 5);
    gbc_s5Btn.gridx = 6;
    gbc_s5Btn.gridy = 9;
    grid.add(s5Btn, gbc_s5Btn);

    s6Btn = new RayJButton(Direction.SOUTH, 6);
    rayButtons[Direction.SOUTH.value][6] = s6Btn;
    s6Btn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        s6BtnActionPerformed(arg0);
      }
    });
    s6Btn.setMargin(new Insets(2, 2, 2, 2));
    s6Btn.setHorizontalTextPosition(SwingConstants.CENTER);
    s6Btn.setMinimumSize(new Dimension(40, 40));
    s6Btn.setMaximumSize(new Dimension(40, 40));
    s6Btn.setPreferredSize(new Dimension(40, 40));
    GridBagConstraints gbc_s6Btn = new GridBagConstraints();
    gbc_s6Btn.fill = GridBagConstraints.BOTH;
    gbc_s6Btn.insets = new Insets(0, 0, 0, 5);
    gbc_s6Btn.gridx = 7;
    gbc_s6Btn.gridy = 9;
    grid.add(s6Btn, gbc_s6Btn);

    s7Btn = new RayJButton(Direction.SOUTH, 7);
    rayButtons[Direction.SOUTH.value][7] = s7Btn;
    s7Btn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        s7BtnActionPerformed(arg0);
      }
    });
    s7Btn.setMargin(new Insets(2, 2, 2, 2));
    s7Btn.setHorizontalTextPosition(SwingConstants.CENTER);
    s7Btn.setMinimumSize(new Dimension(40, 40));
    s7Btn.setMaximumSize(new Dimension(40, 40));
    s7Btn.setPreferredSize(new Dimension(40, 40));
    GridBagConstraints gbc_s7Btn = new GridBagConstraints();
    gbc_s7Btn.fill = GridBagConstraints.BOTH;
    gbc_s7Btn.insets = new Insets(0, 0, 0, 5);
    gbc_s7Btn.gridx = 8;
    gbc_s7Btn.gridy = 9;
    grid.add(s7Btn, gbc_s7Btn);

    a0x0Btn = new AtomJButton(0, 0);
    atomButtons[0][0] = a0x0Btn;
    a0x0Btn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        a0x0BtnActionPerformed(arg0);
      }
    });
    a0x0Btn.setBackground(Color.BLACK);
    a0x0Btn.setMargin(new Insets(2, 2, 2, 2));
    a0x0Btn.setPreferredSize(new Dimension(40, 40));
    a0x0Btn.setMinimumSize(new Dimension(40, 40));
    a0x0Btn.setMaximumSize(new Dimension(40, 40));
    a0x0Btn.setHorizontalTextPosition(SwingConstants.CENTER);
    GridBagConstraints gbc_a0x0Btn = new GridBagConstraints();
    gbc_a0x0Btn.insets = new Insets(0, 0, 5, 5);
    gbc_a0x0Btn.gridx = 1;
    gbc_a0x0Btn.gridy = 1;
    grid.add(a0x0Btn, gbc_a0x0Btn);

    a0x1Btn = new AtomJButton(0, 1);
    atomButtons[0][1] = a0x1Btn;
    a0x1Btn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        a0x1BtnActionPerformed(arg0);
      }
    });
    a0x1Btn.setBackground(Color.BLACK);
    a0x1Btn.setMargin(new Insets(2, 2, 2, 2));
    a0x1Btn.setPreferredSize(new Dimension(40, 40));
    a0x1Btn.setMinimumSize(new Dimension(40, 40));
    a0x1Btn.setMaximumSize(new Dimension(40, 40));
    a0x1Btn.setHorizontalTextPosition(SwingConstants.CENTER);
    GridBagConstraints gbc_a0x1Btn = new GridBagConstraints();
    gbc_a0x1Btn.insets = new Insets(0, 0, 5, 5);
    gbc_a0x1Btn.gridx = 1;
    gbc_a0x1Btn.gridy = 2;
    grid.add(a0x1Btn, gbc_a0x1Btn);

    a0x2Btn = new AtomJButton(0, 2);
    atomButtons[0][2] = a0x2Btn;
    a0x2Btn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        a0x2BtnActionPerformed(arg0);
      }
    });
    a0x2Btn.setBackground(Color.BLACK);
    a0x2Btn.setMargin(new Insets(2, 2, 2, 2));
    a0x2Btn.setPreferredSize(new Dimension(40, 40));
    a0x2Btn.setMinimumSize(new Dimension(40, 40));
    a0x2Btn.setMaximumSize(new Dimension(40, 40));
    a0x2Btn.setHorizontalTextPosition(SwingConstants.CENTER);
    GridBagConstraints gbc_a0x2Btn = new GridBagConstraints();
    gbc_a0x2Btn.insets = new Insets(0, 0, 5, 5);
    gbc_a0x2Btn.gridx = 1;
    gbc_a0x2Btn.gridy = 3;
    grid.add(a0x2Btn, gbc_a0x2Btn);

    a0x3Btn = new AtomJButton(0, 3);
    atomButtons[0][3] = a0x3Btn;
    a0x3Btn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        a0x3BtnActionPerformed(arg0);
      }
    });
    a0x3Btn.setBackground(Color.BLACK);
    a0x3Btn.setMargin(new Insets(2, 2, 2, 2));
    a0x3Btn.setPreferredSize(new Dimension(40, 40));
    a0x3Btn.setMinimumSize(new Dimension(40, 40));
    a0x3Btn.setMaximumSize(new Dimension(40, 40));
    a0x3Btn.setHorizontalTextPosition(SwingConstants.CENTER);
    GridBagConstraints gbc_a0x3Btn = new GridBagConstraints();
    gbc_a0x3Btn.insets = new Insets(0, 0, 5, 5);
    gbc_a0x3Btn.gridx = 1;
    gbc_a0x3Btn.gridy = 4;
    grid.add(a0x3Btn, gbc_a0x3Btn);

    a0x4Btn = new AtomJButton(0, 4);
    atomButtons[0][4] = a0x4Btn;
    a0x4Btn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        a0x4BtnActionPerformed(arg0);
      }
    });
    a0x4Btn.setBackground(Color.BLACK);
    a0x4Btn.setMargin(new Insets(2, 2, 2, 2));
    a0x4Btn.setPreferredSize(new Dimension(40, 40));
    a0x4Btn.setMinimumSize(new Dimension(40, 40));
    a0x4Btn.setMaximumSize(new Dimension(40, 40));
    GridBagConstraints gbc_a0x4Btn = new GridBagConstraints();
    gbc_a0x4Btn.insets = new Insets(0, 0, 5, 5);
    gbc_a0x4Btn.gridx = 1;
    gbc_a0x4Btn.gridy = 5;
    grid.add(a0x4Btn, gbc_a0x4Btn);

    a0x5Btn = new AtomJButton(0, 5);
    atomButtons[0][5] = a0x5Btn;
    a0x5Btn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        a0x5BtnActionPerformed(arg0);
      }
    });
    a0x5Btn.setBackground(Color.BLACK);
    a0x5Btn.setMargin(new Insets(2, 2, 2, 2));
    a0x5Btn.setPreferredSize(new Dimension(40, 40));
    a0x5Btn.setMinimumSize(new Dimension(40, 40));
    a0x5Btn.setMaximumSize(new Dimension(40, 40));
    GridBagConstraints gbc_a0x5Btn = new GridBagConstraints();
    gbc_a0x5Btn.insets = new Insets(0, 0, 5, 5);
    gbc_a0x5Btn.gridx = 1;
    gbc_a0x5Btn.gridy = 6;
    grid.add(a0x5Btn, gbc_a0x5Btn);

    a0x6Btn = new AtomJButton(0, 6);
    atomButtons[0][6] = a0x6Btn;
    a0x6Btn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        a0x6BtnActionPerformed(arg0);
      }
    });
    a0x6Btn.setBackground(Color.BLACK);
    a0x6Btn.setMargin(new Insets(2, 2, 2, 2));
    a0x6Btn.setPreferredSize(new Dimension(40, 40));
    a0x6Btn.setMinimumSize(new Dimension(40, 40));
    a0x6Btn.setMaximumSize(new Dimension(40, 40));
    GridBagConstraints gbc_a0x6Btn = new GridBagConstraints();
    gbc_a0x6Btn.insets = new Insets(0, 0, 5, 5);
    gbc_a0x6Btn.gridx = 1;
    gbc_a0x6Btn.gridy = 7;
    grid.add(a0x6Btn, gbc_a0x6Btn);

    a0x7Btn = new AtomJButton(0, 7);
    atomButtons[0][7] = a0x7Btn;
    a0x7Btn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        a0x7BtnActionPerformed(arg0);
      }
    });
    a0x7Btn.setBackground(Color.BLACK);
    a0x7Btn.setMargin(new Insets(2, 2, 2, 2));
    a0x7Btn.setPreferredSize(new Dimension(40, 40));
    a0x7Btn.setMinimumSize(new Dimension(40, 40));
    a0x7Btn.setMaximumSize(new Dimension(40, 40));
    GridBagConstraints gbc_a0x7Btn = new GridBagConstraints();
    gbc_a0x7Btn.insets = new Insets(0, 0, 5, 5);
    gbc_a0x7Btn.gridx = 1;
    gbc_a0x7Btn.gridy = 8;
    grid.add(a0x7Btn, gbc_a0x7Btn);

    a1x0Btn = new AtomJButton(1, 0);
    atomButtons[1][0] = a1x0Btn;
    a1x0Btn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        a1x0BtnActionPerformed(arg0);
      }
    });
    a1x0Btn.setBackground(Color.BLACK);
    a1x0Btn.setMargin(new Insets(2, 2, 2, 2));
    a1x0Btn.setPreferredSize(new Dimension(40, 40));
    a1x0Btn.setMinimumSize(new Dimension(40, 40));
    a1x0Btn.setMaximumSize(new Dimension(40, 40));
    a1x0Btn.setHorizontalTextPosition(SwingConstants.CENTER);
    GridBagConstraints gbc_a1x0Btn = new GridBagConstraints();
    gbc_a1x0Btn.insets = new Insets(0, 0, 5, 5);
    gbc_a1x0Btn.gridx = 2;
    gbc_a1x0Btn.gridy = 1;
    grid.add(a1x0Btn, gbc_a1x0Btn);

    a1x1Btn = new AtomJButton(1, 1);
    atomButtons[1][1] = a1x1Btn;
    a1x1Btn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        a1x1BtnActionPerformed(arg0);
      }
    });
    a1x1Btn.setBackground(Color.BLACK);
    a1x1Btn.setMargin(new Insets(2, 2, 2, 2));
    a1x1Btn.setPreferredSize(new Dimension(40, 40));
    a1x1Btn.setMinimumSize(new Dimension(40, 40));
    a1x1Btn.setMaximumSize(new Dimension(40, 40));
    a1x1Btn.setHorizontalTextPosition(SwingConstants.CENTER);
    GridBagConstraints gbc_a1x1Btn = new GridBagConstraints();
    gbc_a1x1Btn.insets = new Insets(0, 0, 5, 5);
    gbc_a1x1Btn.gridx = 2;
    gbc_a1x1Btn.gridy = 2;
    grid.add(a1x1Btn, gbc_a1x1Btn);

    a1x2Btn = new AtomJButton(1, 2);
    atomButtons[1][2] = a1x2Btn;
    a1x2Btn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        a1x2BtnActionPerformed(arg0);
      }
    });
    a1x2Btn.setBackground(Color.BLACK);
    a1x2Btn.setMargin(new Insets(2, 2, 2, 2));
    a1x2Btn.setPreferredSize(new Dimension(40, 40));
    a1x2Btn.setMinimumSize(new Dimension(40, 40));
    a1x2Btn.setMaximumSize(new Dimension(40, 40));
    a1x2Btn.setHorizontalTextPosition(SwingConstants.CENTER);
    GridBagConstraints gbc_a1x2Btn = new GridBagConstraints();
    gbc_a1x2Btn.insets = new Insets(0, 0, 5, 5);
    gbc_a1x2Btn.gridx = 2;
    gbc_a1x2Btn.gridy = 3;
    grid.add(a1x2Btn, gbc_a1x2Btn);

    a1x3Btn = new AtomJButton(1, 3);
    atomButtons[1][3] = a1x3Btn;
    a1x3Btn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        a1x3BtnActionPerformed(arg0);
      }
    });
    a1x3Btn.setBackground(Color.BLACK);
    a1x3Btn.setMargin(new Insets(2, 2, 2, 2));
    a1x3Btn.setPreferredSize(new Dimension(40, 40));
    a1x3Btn.setMinimumSize(new Dimension(40, 40));
    a1x3Btn.setMaximumSize(new Dimension(40, 40));
    a1x3Btn.setHorizontalTextPosition(SwingConstants.CENTER);
    GridBagConstraints gbc_a1x3Btn = new GridBagConstraints();
    gbc_a1x3Btn.insets = new Insets(0, 0, 5, 5);
    gbc_a1x3Btn.gridx = 2;
    gbc_a1x3Btn.gridy = 4;
    grid.add(a1x3Btn, gbc_a1x3Btn);

    a1x4Btn = new AtomJButton(1, 4);
    atomButtons[1][4] = a1x4Btn;
    a1x4Btn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        a1x4BtnActionPerformed(arg0);
      }
    });
    a1x4Btn.setBackground(Color.BLACK);
    a1x4Btn.setMargin(new Insets(2, 2, 2, 2));
    a1x4Btn.setPreferredSize(new Dimension(40, 40));
    a1x4Btn.setMinimumSize(new Dimension(40, 40));
    a1x4Btn.setMaximumSize(new Dimension(40, 40));
    GridBagConstraints gbc_a1x4Btn = new GridBagConstraints();
    gbc_a1x4Btn.insets = new Insets(0, 0, 5, 5);
    gbc_a1x4Btn.gridx = 2;
    gbc_a1x4Btn.gridy = 5;
    grid.add(a1x4Btn, gbc_a1x4Btn);

    a1x5Btn = new AtomJButton(1, 5);
    atomButtons[1][5] = a1x5Btn;
    a1x5Btn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        a1x5BtnActionPerformed(arg0);
      }
    });
    a1x5Btn.setBackground(Color.BLACK);
    a1x5Btn.setMargin(new Insets(2, 2, 2, 2));
    a1x5Btn.setPreferredSize(new Dimension(40, 40));
    a1x5Btn.setMinimumSize(new Dimension(40, 40));
    a1x5Btn.setMaximumSize(new Dimension(40, 40));
    GridBagConstraints gbc_a1x5Btn = new GridBagConstraints();
    gbc_a1x5Btn.insets = new Insets(0, 0, 5, 5);
    gbc_a1x5Btn.gridx = 2;
    gbc_a1x5Btn.gridy = 6;
    grid.add(a1x5Btn, gbc_a1x5Btn);

    a1x6Btn = new AtomJButton(1, 6);
    atomButtons[1][6] = a1x6Btn;
    a1x6Btn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        a1x6BtnActionPerformed(arg0);
      }
    });
    a1x6Btn.setBackground(Color.BLACK);
    a1x6Btn.setMargin(new Insets(2, 2, 2, 2));
    a1x6Btn.setPreferredSize(new Dimension(40, 40));
    a1x6Btn.setMinimumSize(new Dimension(40, 40));
    a1x6Btn.setMaximumSize(new Dimension(40, 40));
    GridBagConstraints gbc_a1x6Btn = new GridBagConstraints();
    gbc_a1x6Btn.insets = new Insets(0, 0, 5, 5);
    gbc_a1x6Btn.gridx = 2;
    gbc_a1x6Btn.gridy = 7;
    grid.add(a1x6Btn, gbc_a1x6Btn);

    a1x7Btn = new AtomJButton(1, 7);
    atomButtons[1][7] = a1x7Btn;
    a1x7Btn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        a1x7BtnActionPerformed(arg0);
      }
    });
    a1x7Btn.setBackground(Color.BLACK);
    a1x7Btn.setMargin(new Insets(2, 2, 2, 2));
    a1x7Btn.setPreferredSize(new Dimension(40, 40));
    a1x7Btn.setMinimumSize(new Dimension(40, 40));
    a1x7Btn.setMaximumSize(new Dimension(40, 40));
    GridBagConstraints gbc_a1x7Btn = new GridBagConstraints();
    gbc_a1x7Btn.insets = new Insets(0, 0, 5, 5);
    gbc_a1x7Btn.gridx = 2;
    gbc_a1x7Btn.gridy = 8;
    grid.add(a1x7Btn, gbc_a1x7Btn);

    a2x0Btn = new AtomJButton(2, 0);
    atomButtons[2][0] = a2x0Btn;
    a2x0Btn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        a2x0BtnActionPerformed(arg0);
      }
    });
    a2x0Btn.setBackground(Color.BLACK);
    a2x0Btn.setMargin(new Insets(2, 2, 2, 2));
    a2x0Btn.setPreferredSize(new Dimension(40, 40));
    a2x0Btn.setMinimumSize(new Dimension(40, 40));
    a2x0Btn.setMaximumSize(new Dimension(40, 40));
    a2x0Btn.setHorizontalTextPosition(SwingConstants.CENTER);
    GridBagConstraints gbc_a2x0Btn = new GridBagConstraints();
    gbc_a2x0Btn.insets = new Insets(0, 0, 5, 5);
    gbc_a2x0Btn.gridx = 3;
    gbc_a2x0Btn.gridy = 1;
    grid.add(a2x0Btn, gbc_a2x0Btn);

    a2x1Btn = new AtomJButton(2, 1);
    atomButtons[2][1] = a2x1Btn;
    a2x1Btn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        a2x1BtnActionPerformed(arg0);
      }
    });
    a2x1Btn.setBackground(Color.BLACK);
    a2x1Btn.setMargin(new Insets(2, 2, 2, 2));
    a2x1Btn.setPreferredSize(new Dimension(40, 40));
    a2x1Btn.setMinimumSize(new Dimension(40, 40));
    a2x1Btn.setMaximumSize(new Dimension(40, 40));
    a2x1Btn.setHorizontalTextPosition(SwingConstants.CENTER);
    GridBagConstraints gbc_a2x1Btn = new GridBagConstraints();
    gbc_a2x1Btn.insets = new Insets(0, 0, 5, 5);
    gbc_a2x1Btn.gridx = 3;
    gbc_a2x1Btn.gridy = 2;
    grid.add(a2x1Btn, gbc_a2x1Btn);

    a2x2Btn = new AtomJButton(2, 2);
    atomButtons[2][2] = a2x2Btn;
    a2x2Btn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        a2x2BtnActionPerformed(arg0);
      }
    });
    a2x2Btn.setBackground(Color.BLACK);
    a2x2Btn.setMargin(new Insets(2, 2, 2, 2));
    a2x2Btn.setPreferredSize(new Dimension(40, 40));
    a2x2Btn.setMinimumSize(new Dimension(40, 40));
    a2x2Btn.setMaximumSize(new Dimension(40, 40));
    a2x2Btn.setHorizontalTextPosition(SwingConstants.CENTER);
    GridBagConstraints gbc_a2x2Btn = new GridBagConstraints();
    gbc_a2x2Btn.insets = new Insets(0, 0, 5, 5);
    gbc_a2x2Btn.gridx = 3;
    gbc_a2x2Btn.gridy = 3;
    grid.add(a2x2Btn, gbc_a2x2Btn);

    a2x3Btn = new AtomJButton(2, 3);
    atomButtons[2][3] = a2x3Btn;
    a2x3Btn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        a2x3BtnActionPerformed(arg0);
      }
    });
    a2x3Btn.setBackground(Color.BLACK);
    a2x3Btn.setMargin(new Insets(2, 2, 2, 2));
    a2x3Btn.setPreferredSize(new Dimension(40, 40));
    a2x3Btn.setMinimumSize(new Dimension(40, 40));
    a2x3Btn.setMaximumSize(new Dimension(40, 40));
    a2x3Btn.setHorizontalTextPosition(SwingConstants.CENTER);
    GridBagConstraints gbc_a2x3Btn = new GridBagConstraints();
    gbc_a2x3Btn.insets = new Insets(0, 0, 5, 5);
    gbc_a2x3Btn.gridx = 3;
    gbc_a2x3Btn.gridy = 4;
    grid.add(a2x3Btn, gbc_a2x3Btn);

    a2x4Btn = new AtomJButton(2, 4);
    atomButtons[2][4] = a2x4Btn;
    a2x4Btn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        a2x4BtnActionPerformed(arg0);
      }
    });
    a2x4Btn.setBackground(Color.BLACK);
    a2x4Btn.setMargin(new Insets(2, 2, 2, 2));
    a2x4Btn.setPreferredSize(new Dimension(40, 40));
    a2x4Btn.setMinimumSize(new Dimension(40, 40));
    a2x4Btn.setMaximumSize(new Dimension(40, 40));
    GridBagConstraints gbc_a2x4Btn = new GridBagConstraints();
    gbc_a2x4Btn.insets = new Insets(0, 0, 5, 5);
    gbc_a2x4Btn.gridx = 3;
    gbc_a2x4Btn.gridy = 5;
    grid.add(a2x4Btn, gbc_a2x4Btn);

    a2x5Btn = new AtomJButton(2, 5);
    atomButtons[2][5] = a2x5Btn;
    a2x5Btn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        a2x5BtnActionPerformed(arg0);
      }
    });
    a2x5Btn.setBackground(Color.BLACK);
    a2x5Btn.setMargin(new Insets(2, 2, 2, 2));
    a2x5Btn.setPreferredSize(new Dimension(40, 40));
    a2x5Btn.setMinimumSize(new Dimension(40, 40));
    a2x5Btn.setMaximumSize(new Dimension(40, 40));
    GridBagConstraints gbc_a2x5Btn = new GridBagConstraints();
    gbc_a2x5Btn.insets = new Insets(0, 0, 5, 5);
    gbc_a2x5Btn.gridx = 3;
    gbc_a2x5Btn.gridy = 6;
    grid.add(a2x5Btn, gbc_a2x5Btn);

    a2x6Btn = new AtomJButton(2, 6);
    atomButtons[2][6] = a2x6Btn;
    a2x6Btn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        a2x6BtnActionPerformed(arg0);
      }
    });
    a2x6Btn.setBackground(Color.BLACK);
    a2x6Btn.setMargin(new Insets(2, 2, 2, 2));
    a2x6Btn.setPreferredSize(new Dimension(40, 40));
    a2x6Btn.setMinimumSize(new Dimension(40, 40));
    a2x6Btn.setMaximumSize(new Dimension(40, 40));
    GridBagConstraints gbc_a2x6Btn = new GridBagConstraints();
    gbc_a2x6Btn.insets = new Insets(0, 0, 5, 5);
    gbc_a2x6Btn.gridx = 3;
    gbc_a2x6Btn.gridy = 7;
    grid.add(a2x6Btn, gbc_a2x6Btn);

    a2x7Btn = new AtomJButton(2, 7);
    atomButtons[2][7] = a2x7Btn;
    a2x7Btn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        a2x7BtnActionPerformed(arg0);
      }
    });
    a2x7Btn.setBackground(Color.BLACK);
    a2x7Btn.setMargin(new Insets(2, 2, 2, 2));
    a2x7Btn.setPreferredSize(new Dimension(40, 40));
    a2x7Btn.setMinimumSize(new Dimension(40, 40));
    a2x7Btn.setMaximumSize(new Dimension(40, 40));
    GridBagConstraints gbc_a2x7Btn = new GridBagConstraints();
    gbc_a2x7Btn.insets = new Insets(0, 0, 5, 5);
    gbc_a2x7Btn.gridx = 3;
    gbc_a2x7Btn.gridy = 8;
    grid.add(a2x7Btn, gbc_a2x7Btn);

    a3x0Btn = new AtomJButton(3, 0);
    atomButtons[3][0] = a3x0Btn;
    a3x0Btn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        a3x0BtnActionPerformed(arg0);
      }
    });
    a3x0Btn.setBackground(Color.BLACK);
    a3x0Btn.setMargin(new Insets(2, 2, 2, 2));
    a3x0Btn.setPreferredSize(new Dimension(40, 40));
    a3x0Btn.setMinimumSize(new Dimension(40, 40));
    a3x0Btn.setMaximumSize(new Dimension(40, 40));
    GridBagConstraints gbc_a3x0Btn = new GridBagConstraints();
    gbc_a3x0Btn.insets = new Insets(0, 0, 5, 5);
    gbc_a3x0Btn.gridx = 4;
    gbc_a3x0Btn.gridy = 1;
    grid.add(a3x0Btn, gbc_a3x0Btn);

    a3x1Btn = new AtomJButton(3, 1);
    atomButtons[3][1] = a3x1Btn;
    a3x1Btn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        a3x1BtnActionPerformed(arg0);
      }
    });
    a3x1Btn.setBackground(Color.BLACK);
    a3x1Btn.setMargin(new Insets(2, 2, 2, 2));
    a3x1Btn.setPreferredSize(new Dimension(40, 40));
    a3x1Btn.setMinimumSize(new Dimension(40, 40));
    a3x1Btn.setMaximumSize(new Dimension(40, 40));
    GridBagConstraints gbc_a3x1Btn = new GridBagConstraints();
    gbc_a3x1Btn.insets = new Insets(0, 0, 5, 5);
    gbc_a3x1Btn.gridx = 4;
    gbc_a3x1Btn.gridy = 2;
    grid.add(a3x1Btn, gbc_a3x1Btn);

    a3x2Btn = new AtomJButton(3, 2);
    atomButtons[3][2] = a3x2Btn;
    a3x2Btn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        a3x2BtnActionPerformed(arg0);
      }
    });
    a3x2Btn.setBackground(Color.BLACK);
    a3x2Btn.setMargin(new Insets(2, 2, 2, 2));
    a3x2Btn.setPreferredSize(new Dimension(40, 40));
    a3x2Btn.setMinimumSize(new Dimension(40, 40));
    a3x2Btn.setMaximumSize(new Dimension(40, 40));
    GridBagConstraints gbc_a3x2Btn = new GridBagConstraints();
    gbc_a3x2Btn.insets = new Insets(0, 0, 5, 5);
    gbc_a3x2Btn.gridx = 4;
    gbc_a3x2Btn.gridy = 3;
    grid.add(a3x2Btn, gbc_a3x2Btn);

    a3x3Btn = new AtomJButton(3, 3);
    atomButtons[3][3] = a3x3Btn;
    a3x3Btn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        a3x3BtnActionPerformed(arg0);
      }
    });
    a3x3Btn.setBackground(Color.BLACK);
    a3x3Btn.setMargin(new Insets(2, 2, 2, 2));
    a3x3Btn.setPreferredSize(new Dimension(40, 40));
    a3x3Btn.setMinimumSize(new Dimension(40, 40));
    a3x3Btn.setMaximumSize(new Dimension(40, 40));
    GridBagConstraints gbc_a3x3Btn = new GridBagConstraints();
    gbc_a3x3Btn.insets = new Insets(0, 0, 5, 5);
    gbc_a3x3Btn.gridx = 4;
    gbc_a3x3Btn.gridy = 4;
    grid.add(a3x3Btn, gbc_a3x3Btn);

    a3x4Btn = new AtomJButton(3, 4);
    atomButtons[3][4] = a3x4Btn;
    a3x4Btn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        a3x4BtnActionPerformed(arg0);
      }
    });
    a3x4Btn.setBackground(Color.BLACK);
    a3x4Btn.setMargin(new Insets(2, 2, 2, 2));
    a3x4Btn.setPreferredSize(new Dimension(40, 40));
    a3x4Btn.setMinimumSize(new Dimension(40, 40));
    a3x4Btn.setMaximumSize(new Dimension(40, 40));
    GridBagConstraints gbc_a3x4Btn = new GridBagConstraints();
    gbc_a3x4Btn.insets = new Insets(0, 0, 5, 5);
    gbc_a3x4Btn.gridx = 4;
    gbc_a3x4Btn.gridy = 5;
    grid.add(a3x4Btn, gbc_a3x4Btn);

    a3x5Btn = new AtomJButton(3, 5);
    atomButtons[3][5] = a3x5Btn;
    a3x5Btn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        a3x5BtnActionPerformed(arg0);
      }
    });
    a3x5Btn.setBackground(Color.BLACK);
    a3x5Btn.setMargin(new Insets(2, 2, 2, 2));
    a3x5Btn.setPreferredSize(new Dimension(40, 40));
    a3x5Btn.setMinimumSize(new Dimension(40, 40));
    a3x5Btn.setMaximumSize(new Dimension(40, 40));
    GridBagConstraints gbc_a3x5Btn = new GridBagConstraints();
    gbc_a3x5Btn.insets = new Insets(0, 0, 5, 5);
    gbc_a3x5Btn.gridx = 4;
    gbc_a3x5Btn.gridy = 6;
    grid.add(a3x5Btn, gbc_a3x5Btn);

    a3x6Btn = new AtomJButton(3, 6);
    atomButtons[3][6] = a3x6Btn;
    a3x6Btn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        a3x6BtnActionPerformed(arg0);
      }
    });
    a3x6Btn.setBackground(Color.BLACK);
    a3x6Btn.setMargin(new Insets(2, 2, 2, 2));
    a3x6Btn.setPreferredSize(new Dimension(40, 40));
    a3x6Btn.setMinimumSize(new Dimension(40, 40));
    a3x6Btn.setMaximumSize(new Dimension(40, 40));
    GridBagConstraints gbc_a3x6Btn = new GridBagConstraints();
    gbc_a3x6Btn.insets = new Insets(0, 0, 5, 5);
    gbc_a3x6Btn.gridx = 4;
    gbc_a3x6Btn.gridy = 7;
    grid.add(a3x6Btn, gbc_a3x6Btn);

    a3x7Btn = new AtomJButton(3, 7);
    atomButtons[3][7] = a3x7Btn;
    a3x7Btn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        a3x7BtnActionPerformed(arg0);
      }
    });
    a3x7Btn.setBackground(Color.BLACK);
    a3x7Btn.setMargin(new Insets(2, 2, 2, 2));
    a3x7Btn.setPreferredSize(new Dimension(40, 40));
    a3x7Btn.setMinimumSize(new Dimension(40, 40));
    a3x7Btn.setMaximumSize(new Dimension(40, 40));
    GridBagConstraints gbc_a3x7Btn = new GridBagConstraints();
    gbc_a3x7Btn.insets = new Insets(0, 0, 5, 5);
    gbc_a3x7Btn.gridx = 4;
    gbc_a3x7Btn.gridy = 8;
    grid.add(a3x7Btn, gbc_a3x7Btn);

    a4x0Btn = new AtomJButton(4, 0);
    atomButtons[4][0] = a4x0Btn;
    a4x0Btn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        a4x0BtnActionPerformed(arg0);
      }
    });
    a4x0Btn.setBackground(Color.BLACK);
    a4x0Btn.setMargin(new Insets(2, 2, 2, 2));
    a4x0Btn.setPreferredSize(new Dimension(40, 40));
    a4x0Btn.setMinimumSize(new Dimension(40, 40));
    a4x0Btn.setMaximumSize(new Dimension(40, 40));
    GridBagConstraints gbc_a4x0Btn = new GridBagConstraints();
    gbc_a4x0Btn.insets = new Insets(0, 0, 5, 5);
    gbc_a4x0Btn.gridx = 5;
    gbc_a4x0Btn.gridy = 1;
    grid.add(a4x0Btn, gbc_a4x0Btn);

    a4x1Btn = new AtomJButton(4, 1);
    atomButtons[4][1] = a4x1Btn;
    a4x1Btn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        a4x1BtnActionPerformed(arg0);
      }
    });
    a4x1Btn.setBackground(Color.BLACK);
    a4x1Btn.setMargin(new Insets(2, 2, 2, 2));
    a4x1Btn.setPreferredSize(new Dimension(40, 40));
    a4x1Btn.setMinimumSize(new Dimension(40, 40));
    a4x1Btn.setMaximumSize(new Dimension(40, 40));
    GridBagConstraints gbc_a4x1Btn = new GridBagConstraints();
    gbc_a4x1Btn.insets = new Insets(0, 0, 5, 5);
    gbc_a4x1Btn.gridx = 5;
    gbc_a4x1Btn.gridy = 2;
    grid.add(a4x1Btn, gbc_a4x1Btn);

    a4x2Btn = new AtomJButton(4, 2);
    atomButtons[4][2] = a4x2Btn;
    a4x2Btn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        a4x2BtnActionPerformed(arg0);
      }
    });
    a4x2Btn.setBackground(Color.BLACK);
    a4x2Btn.setMargin(new Insets(2, 2, 2, 2));
    a4x2Btn.setPreferredSize(new Dimension(40, 40));
    a4x2Btn.setMinimumSize(new Dimension(40, 40));
    a4x2Btn.setMaximumSize(new Dimension(40, 40));
    GridBagConstraints gbc_a4x2Btn = new GridBagConstraints();
    gbc_a4x2Btn.insets = new Insets(0, 0, 5, 5);
    gbc_a4x2Btn.gridx = 5;
    gbc_a4x2Btn.gridy = 3;
    grid.add(a4x2Btn, gbc_a4x2Btn);

    a4x3Btn = new AtomJButton(4, 3);
    atomButtons[4][3] = a4x3Btn;
    a4x3Btn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        a4x3BtnActionPerformed(arg0);
      }
    });
    a4x3Btn.setBackground(Color.BLACK);
    a4x3Btn.setMargin(new Insets(2, 2, 2, 2));
    a4x3Btn.setPreferredSize(new Dimension(40, 40));
    a4x3Btn.setMinimumSize(new Dimension(40, 40));
    a4x3Btn.setMaximumSize(new Dimension(40, 40));
    GridBagConstraints gbc_a4x3Btn = new GridBagConstraints();
    gbc_a4x3Btn.insets = new Insets(0, 0, 5, 5);
    gbc_a4x3Btn.gridx = 5;
    gbc_a4x3Btn.gridy = 4;
    grid.add(a4x3Btn, gbc_a4x3Btn);

    a4x4Btn = new AtomJButton(4, 4);
    atomButtons[4][4] = a4x4Btn;
    a4x4Btn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        a4x4BtnActionPerformed(arg0);
      }
    });
    a4x4Btn.setBackground(Color.BLACK);
    a4x4Btn.setMargin(new Insets(2, 2, 2, 2));
    a4x4Btn.setPreferredSize(new Dimension(40, 40));
    a4x4Btn.setMinimumSize(new Dimension(40, 40));
    a4x4Btn.setMaximumSize(new Dimension(40, 40));
    GridBagConstraints gbc_a4x4Btn = new GridBagConstraints();
    gbc_a4x4Btn.insets = new Insets(0, 0, 5, 5);
    gbc_a4x4Btn.gridx = 5;
    gbc_a4x4Btn.gridy = 5;
    grid.add(a4x4Btn, gbc_a4x4Btn);

    a4x5Btn = new AtomJButton(4, 5);
    atomButtons[4][5] = a4x5Btn;
    a4x5Btn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        a4x5BtnActionPerformed(arg0);
      }
    });
    a4x5Btn.setBackground(Color.BLACK);
    a4x5Btn.setMargin(new Insets(2, 2, 2, 2));
    a4x5Btn.setPreferredSize(new Dimension(40, 40));
    a4x5Btn.setMinimumSize(new Dimension(40, 40));
    a4x5Btn.setMaximumSize(new Dimension(40, 40));
    GridBagConstraints gbc_a4x5Btn = new GridBagConstraints();
    gbc_a4x5Btn.insets = new Insets(0, 0, 5, 5);
    gbc_a4x5Btn.gridx = 5;
    gbc_a4x5Btn.gridy = 6;
    grid.add(a4x5Btn, gbc_a4x5Btn);

    a4x6Btn = new AtomJButton(4, 6);
    atomButtons[4][6] = a4x6Btn;
    a4x6Btn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        a4x6BtnActionPerformed(arg0);
      }
    });
    a4x6Btn.setBackground(Color.BLACK);
    a4x6Btn.setMargin(new Insets(2, 2, 2, 2));
    a4x6Btn.setPreferredSize(new Dimension(40, 40));
    a4x6Btn.setMinimumSize(new Dimension(40, 40));
    a4x6Btn.setMaximumSize(new Dimension(40, 40));
    GridBagConstraints gbc_a4x6Btn = new GridBagConstraints();
    gbc_a4x6Btn.insets = new Insets(0, 0, 5, 5);
    gbc_a4x6Btn.gridx = 5;
    gbc_a4x6Btn.gridy = 7;
    grid.add(a4x6Btn, gbc_a4x6Btn);

    a4x7Btn = new AtomJButton(4, 7);
    atomButtons[4][7] = a4x7Btn;
    a4x7Btn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        a4x7BtnActionPerformed(arg0);
      }
    });
    a4x7Btn.setBackground(Color.BLACK);
    a4x7Btn.setMargin(new Insets(2, 2, 2, 2));
    a4x7Btn.setPreferredSize(new Dimension(40, 40));
    a4x7Btn.setMinimumSize(new Dimension(40, 40));
    a4x7Btn.setMaximumSize(new Dimension(40, 40));
    GridBagConstraints gbc_a4x7Btn = new GridBagConstraints();
    gbc_a4x7Btn.insets = new Insets(0, 0, 5, 5);
    gbc_a4x7Btn.gridx = 5;
    gbc_a4x7Btn.gridy = 8;
    grid.add(a4x7Btn, gbc_a4x7Btn);

    a5x0Btn = new AtomJButton(5, 0);
    atomButtons[5][0] = a5x0Btn;
    a5x0Btn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        a5x0BtnActionPerformed(arg0);
      }
    });
    a5x0Btn.setBackground(Color.BLACK);
    a5x0Btn.setMargin(new Insets(2, 2, 2, 2));
    a5x0Btn.setPreferredSize(new Dimension(40, 40));
    a5x0Btn.setMinimumSize(new Dimension(40, 40));
    a5x0Btn.setMaximumSize(new Dimension(40, 40));
    GridBagConstraints gbc_a5x0Btn = new GridBagConstraints();
    gbc_a5x0Btn.insets = new Insets(0, 0, 5, 5);
    gbc_a5x0Btn.gridx = 6;
    gbc_a5x0Btn.gridy = 1;
    grid.add(a5x0Btn, gbc_a5x0Btn);

    a5x1Btn = new AtomJButton(5, 1);
    atomButtons[5][1] = a5x1Btn;
    a5x1Btn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        a5x1BtnActionPerformed(arg0);
      }
    });
    a5x1Btn.setBackground(Color.BLACK);
    a5x1Btn.setMargin(new Insets(2, 2, 2, 2));
    a5x1Btn.setPreferredSize(new Dimension(40, 40));
    a5x1Btn.setMinimumSize(new Dimension(40, 40));
    a5x1Btn.setMaximumSize(new Dimension(40, 40));
    GridBagConstraints gbc_a5x1Btn = new GridBagConstraints();
    gbc_a5x1Btn.insets = new Insets(0, 0, 5, 5);
    gbc_a5x1Btn.gridx = 6;
    gbc_a5x1Btn.gridy = 2;
    grid.add(a5x1Btn, gbc_a5x1Btn);

    a5x2Btn = new AtomJButton(5, 2);
    atomButtons[5][2] = a5x2Btn;
    a5x2Btn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        a5x2BtnActionPerformed(arg0);
      }
    });
    a5x2Btn.setBackground(Color.BLACK);
    a5x2Btn.setMargin(new Insets(2, 2, 2, 2));
    a5x2Btn.setPreferredSize(new Dimension(40, 40));
    a5x2Btn.setMinimumSize(new Dimension(40, 40));
    a5x2Btn.setMaximumSize(new Dimension(40, 40));
    GridBagConstraints gbc_a5x2Btn = new GridBagConstraints();
    gbc_a5x2Btn.insets = new Insets(0, 0, 5, 5);
    gbc_a5x2Btn.gridx = 6;
    gbc_a5x2Btn.gridy = 3;
    grid.add(a5x2Btn, gbc_a5x2Btn);

    a5x3Btn = new AtomJButton(5, 3);
    atomButtons[5][3] = a5x3Btn;
    a5x3Btn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        a5x3BtnActionPerformed(arg0);
      }
    });
    a5x3Btn.setBackground(Color.BLACK);
    a5x3Btn.setMargin(new Insets(2, 2, 2, 2));
    a5x3Btn.setPreferredSize(new Dimension(40, 40));
    a5x3Btn.setMinimumSize(new Dimension(40, 40));
    a5x3Btn.setMaximumSize(new Dimension(40, 40));
    GridBagConstraints gbc_a5x3Btn = new GridBagConstraints();
    gbc_a5x3Btn.insets = new Insets(0, 0, 5, 5);
    gbc_a5x3Btn.gridx = 6;
    gbc_a5x3Btn.gridy = 4;
    grid.add(a5x3Btn, gbc_a5x3Btn);

    a5x4Btn = new AtomJButton(5, 4);
    atomButtons[5][4] = a5x4Btn;
    a5x4Btn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        a5x4BtnActionPerformed(arg0);
      }
    });
    a5x4Btn.setBackground(Color.BLACK);
    a5x4Btn.setMargin(new Insets(2, 2, 2, 2));
    a5x4Btn.setPreferredSize(new Dimension(40, 40));
    a5x4Btn.setMinimumSize(new Dimension(40, 40));
    a5x4Btn.setMaximumSize(new Dimension(40, 40));
    GridBagConstraints gbc_a5x4Btn = new GridBagConstraints();
    gbc_a5x4Btn.insets = new Insets(0, 0, 5, 5);
    gbc_a5x4Btn.gridx = 6;
    gbc_a5x4Btn.gridy = 5;
    grid.add(a5x4Btn, gbc_a5x4Btn);

    a5x5Btn = new AtomJButton(5, 5);
    atomButtons[5][5] = a5x5Btn;
    a5x5Btn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        a5x5BtnActionPerformed(arg0);
      }
    });
    a5x5Btn.setBackground(Color.BLACK);
    a5x5Btn.setMargin(new Insets(2, 2, 2, 2));
    a5x5Btn.setPreferredSize(new Dimension(40, 40));
    a5x5Btn.setMinimumSize(new Dimension(40, 40));
    a5x5Btn.setMaximumSize(new Dimension(40, 40));
    GridBagConstraints gbc_a5x5Btn = new GridBagConstraints();
    gbc_a5x5Btn.insets = new Insets(0, 0, 5, 5);
    gbc_a5x5Btn.gridx = 6;
    gbc_a5x5Btn.gridy = 6;
    grid.add(a5x5Btn, gbc_a5x5Btn);

    a5x6Btn = new AtomJButton(5, 6);
    atomButtons[5][6] = a5x6Btn;
    a5x6Btn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        a5x6BtnActionPerformed(arg0);
      }
    });
    a5x6Btn.setBackground(Color.BLACK);
    a5x6Btn.setMargin(new Insets(2, 2, 2, 2));
    a5x6Btn.setPreferredSize(new Dimension(40, 40));
    a5x6Btn.setMinimumSize(new Dimension(40, 40));
    a5x6Btn.setMaximumSize(new Dimension(40, 40));
    GridBagConstraints gbc_a5x6Btn = new GridBagConstraints();
    gbc_a5x6Btn.insets = new Insets(0, 0, 5, 5);
    gbc_a5x6Btn.gridx = 6;
    gbc_a5x6Btn.gridy = 7;
    grid.add(a5x6Btn, gbc_a5x6Btn);

    a5x7Btn = new AtomJButton(5, 7);
    atomButtons[5][7] = a5x7Btn;
    a5x7Btn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        a5x7BtnActionPerformed(arg0);
      }
    });
    a5x7Btn.setBackground(Color.BLACK);
    a5x7Btn.setMargin(new Insets(2, 2, 2, 2));
    a5x7Btn.setPreferredSize(new Dimension(40, 40));
    a5x7Btn.setMinimumSize(new Dimension(40, 40));
    a5x7Btn.setMaximumSize(new Dimension(40, 40));
    GridBagConstraints gbc_a5x7Btn = new GridBagConstraints();
    gbc_a5x7Btn.insets = new Insets(0, 0, 5, 5);
    gbc_a5x7Btn.gridx = 6;
    gbc_a5x7Btn.gridy = 8;
    grid.add(a5x7Btn, gbc_a5x7Btn);

    a6x0Btn = new AtomJButton(6, 0);
    atomButtons[6][0] = a6x0Btn;
    a6x0Btn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        a6x0BtnActionPerformed(arg0);
      }
    });
    a6x0Btn.setBackground(Color.BLACK);
    a6x0Btn.setMargin(new Insets(2, 2, 2, 2));
    a6x0Btn.setPreferredSize(new Dimension(40, 40));
    a6x0Btn.setMinimumSize(new Dimension(40, 40));
    a6x0Btn.setMaximumSize(new Dimension(40, 40));
    GridBagConstraints gbc_a6x0Btn = new GridBagConstraints();
    gbc_a6x0Btn.insets = new Insets(0, 0, 5, 5);
    gbc_a6x0Btn.gridx = 7;
    gbc_a6x0Btn.gridy = 1;
    grid.add(a6x0Btn, gbc_a6x0Btn);

    a6x1Btn = new AtomJButton(6, 1);
    atomButtons[6][1] = a6x1Btn;
    a6x1Btn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        a6x1BtnActionPerformed(arg0);
      }
    });
    a6x1Btn.setBackground(Color.BLACK);
    a6x1Btn.setMargin(new Insets(2, 2, 2, 2));
    a6x1Btn.setPreferredSize(new Dimension(40, 40));
    a6x1Btn.setMinimumSize(new Dimension(40, 40));
    a6x1Btn.setMaximumSize(new Dimension(40, 40));
    GridBagConstraints gbc_a6x1Btn = new GridBagConstraints();
    gbc_a6x1Btn.insets = new Insets(0, 0, 5, 5);
    gbc_a6x1Btn.gridx = 7;
    gbc_a6x1Btn.gridy = 2;
    grid.add(a6x1Btn, gbc_a6x1Btn);

    a6x2Btn = new AtomJButton(6, 2);
    atomButtons[6][2] = a6x2Btn;
    a6x2Btn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        a6x2BtnActionPerformed(arg0);
      }
    });
    a6x2Btn.setBackground(Color.BLACK);
    a6x2Btn.setMargin(new Insets(2, 2, 2, 2));
    a6x2Btn.setPreferredSize(new Dimension(40, 40));
    a6x2Btn.setMinimumSize(new Dimension(40, 40));
    a6x2Btn.setMaximumSize(new Dimension(40, 40));
    GridBagConstraints gbc_a6x2Btn = new GridBagConstraints();
    gbc_a6x2Btn.insets = new Insets(0, 0, 5, 5);
    gbc_a6x2Btn.gridx = 7;
    gbc_a6x2Btn.gridy = 3;
    grid.add(a6x2Btn, gbc_a6x2Btn);

    a6x3Btn = new AtomJButton(6, 3);
    atomButtons[6][3] = a6x3Btn;
    a6x3Btn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        a6x3BtnActionPerformed(arg0);
      }
    });
    a6x3Btn.setBackground(Color.BLACK);
    a6x3Btn.setMargin(new Insets(2, 2, 2, 2));
    a6x3Btn.setPreferredSize(new Dimension(40, 40));
    a6x3Btn.setMinimumSize(new Dimension(40, 40));
    a6x3Btn.setMaximumSize(new Dimension(40, 40));
    GridBagConstraints gbc_a6x3Btn = new GridBagConstraints();
    gbc_a6x3Btn.insets = new Insets(0, 0, 5, 5);
    gbc_a6x3Btn.gridx = 7;
    gbc_a6x3Btn.gridy = 4;
    grid.add(a6x3Btn, gbc_a6x3Btn);

    a6x4Btn = new AtomJButton(6, 4);
    atomButtons[6][4] = a6x4Btn;
    a6x4Btn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        a6x4BtnActionPerformed(arg0);
      }
    });
    a6x4Btn.setBackground(Color.BLACK);
    a6x4Btn.setMargin(new Insets(2, 2, 2, 2));
    a6x4Btn.setPreferredSize(new Dimension(40, 40));
    a6x4Btn.setMinimumSize(new Dimension(40, 40));
    a6x4Btn.setMaximumSize(new Dimension(40, 40));
    GridBagConstraints gbc_a6x4Btn = new GridBagConstraints();
    gbc_a6x4Btn.insets = new Insets(0, 0, 5, 5);
    gbc_a6x4Btn.gridx = 7;
    gbc_a6x4Btn.gridy = 5;
    grid.add(a6x4Btn, gbc_a6x4Btn);

    a6x5Btn = new AtomJButton(6, 5);
    atomButtons[6][5] = a6x5Btn;
    a6x5Btn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        a6x5BtnActionPerformed(arg0);
      }
    });
    a6x5Btn.setBackground(Color.BLACK);
    a6x5Btn.setMargin(new Insets(2, 2, 2, 2));
    a6x5Btn.setPreferredSize(new Dimension(40, 40));
    a6x5Btn.setMinimumSize(new Dimension(40, 40));
    a6x5Btn.setMaximumSize(new Dimension(40, 40));
    GridBagConstraints gbc_a6x5Btn = new GridBagConstraints();
    gbc_a6x5Btn.insets = new Insets(0, 0, 5, 5);
    gbc_a6x5Btn.gridx = 7;
    gbc_a6x5Btn.gridy = 6;
    grid.add(a6x5Btn, gbc_a6x5Btn);

    a6x6Btn = new AtomJButton(6, 6);
    atomButtons[6][6] = a6x6Btn;
    a6x6Btn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        a6x6BtnActionPerformed(arg0);
      }
    });
    a6x6Btn.setBackground(Color.BLACK);
    a6x6Btn.setMargin(new Insets(2, 2, 2, 2));
    a6x6Btn.setPreferredSize(new Dimension(40, 40));
    a6x6Btn.setMinimumSize(new Dimension(40, 40));
    a6x6Btn.setMaximumSize(new Dimension(40, 40));
    GridBagConstraints gbc_a6x6Btn = new GridBagConstraints();
    gbc_a6x6Btn.insets = new Insets(0, 0, 5, 5);
    gbc_a6x6Btn.gridx = 7;
    gbc_a6x6Btn.gridy = 7;
    grid.add(a6x6Btn, gbc_a6x6Btn);

    a6x7Btn = new AtomJButton(6, 7);
    atomButtons[6][7] = a6x7Btn;
    a6x7Btn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        a6x7BtnActionPerformed(arg0);
      }
    });
    a6x7Btn.setBackground(Color.BLACK);
    a6x7Btn.setMargin(new Insets(2, 2, 2, 2));
    a6x7Btn.setPreferredSize(new Dimension(40, 40));
    a6x7Btn.setMinimumSize(new Dimension(40, 40));
    a6x7Btn.setMaximumSize(new Dimension(40, 40));
    GridBagConstraints gbc_a6x7Btn = new GridBagConstraints();
    gbc_a6x7Btn.insets = new Insets(0, 0, 5, 5);
    gbc_a6x7Btn.gridx = 7;
    gbc_a6x7Btn.gridy = 8;
    grid.add(a6x7Btn, gbc_a6x7Btn);

    a7x0Btn = new AtomJButton(7, 0);
    atomButtons[7][0] = a7x0Btn;
    a7x0Btn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        a7x0BtnActionPerformed(arg0);
      }
    });
    a7x0Btn.setBackground(Color.BLACK);
    a7x0Btn.setMargin(new Insets(2, 2, 2, 2));
    a7x0Btn.setPreferredSize(new Dimension(40, 40));
    a7x0Btn.setMinimumSize(new Dimension(40, 40));
    a7x0Btn.setMaximumSize(new Dimension(40, 40));
    GridBagConstraints gbc_a7x0Btn = new GridBagConstraints();
    gbc_a7x0Btn.insets = new Insets(0, 0, 5, 5);
    gbc_a7x0Btn.gridx = 8;
    gbc_a7x0Btn.gridy = 1;
    grid.add(a7x0Btn, gbc_a7x0Btn);

    a7x1Btn = new AtomJButton(7, 1);
    atomButtons[7][1] = a7x1Btn;
    a7x1Btn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        a7x1BtnActionPerformed(arg0);
      }
    });
    a7x1Btn.setBackground(Color.BLACK);
    a7x1Btn.setMargin(new Insets(2, 2, 2, 2));
    a7x1Btn.setPreferredSize(new Dimension(40, 40));
    a7x1Btn.setMinimumSize(new Dimension(40, 40));
    a7x1Btn.setMaximumSize(new Dimension(40, 40));
    GridBagConstraints gbc_a7x1Btn = new GridBagConstraints();
    gbc_a7x1Btn.insets = new Insets(0, 0, 5, 5);
    gbc_a7x1Btn.gridx = 8;
    gbc_a7x1Btn.gridy = 2;
    grid.add(a7x1Btn, gbc_a7x1Btn);

    a7x2Btn = new AtomJButton(7, 2);
    atomButtons[7][2] = a7x2Btn;
    a7x2Btn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        a7x2BtnActionPerformed(arg0);
      }
    });
    a7x2Btn.setBackground(Color.BLACK);
    a7x2Btn.setMargin(new Insets(2, 2, 2, 2));
    a7x2Btn.setPreferredSize(new Dimension(40, 40));
    a7x2Btn.setMinimumSize(new Dimension(40, 40));
    a7x2Btn.setMaximumSize(new Dimension(40, 40));
    GridBagConstraints gbc_a7x2Btn = new GridBagConstraints();
    gbc_a7x2Btn.insets = new Insets(0, 0, 5, 5);
    gbc_a7x2Btn.gridx = 8;
    gbc_a7x2Btn.gridy = 3;
    grid.add(a7x2Btn, gbc_a7x2Btn);

    a7x3Btn = new AtomJButton(7, 3);
    atomButtons[7][3] = a7x3Btn;
    a7x3Btn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        a7x3BtnActionPerformed(arg0);
      }
    });
    a7x3Btn.setBackground(Color.BLACK);
    a7x3Btn.setMargin(new Insets(2, 2, 2, 2));
    a7x3Btn.setPreferredSize(new Dimension(40, 40));
    a7x3Btn.setMinimumSize(new Dimension(40, 40));
    a7x3Btn.setMaximumSize(new Dimension(40, 40));
    GridBagConstraints gbc_a7x3Btn = new GridBagConstraints();
    gbc_a7x3Btn.insets = new Insets(0, 0, 5, 5);
    gbc_a7x3Btn.gridx = 8;
    gbc_a7x3Btn.gridy = 4;
    grid.add(a7x3Btn, gbc_a7x3Btn);

    a7x4Btn = new AtomJButton(7, 4);
    atomButtons[7][4] = a7x4Btn;
    a7x4Btn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        a7x4BtnActionPerformed(arg0);
      }
    });
    a7x4Btn.setBackground(Color.BLACK);
    a7x4Btn.setMargin(new Insets(2, 2, 2, 2));
    a7x4Btn.setPreferredSize(new Dimension(40, 40));
    a7x4Btn.setMinimumSize(new Dimension(40, 40));
    a7x4Btn.setMaximumSize(new Dimension(40, 40));
    GridBagConstraints gbc_a7x4Btn = new GridBagConstraints();
    gbc_a7x4Btn.insets = new Insets(0, 0, 5, 5);
    gbc_a7x4Btn.gridx = 8;
    gbc_a7x4Btn.gridy = 5;
    grid.add(a7x4Btn, gbc_a7x4Btn);

    a7x5Btn = new AtomJButton(7, 5);
    atomButtons[7][5] = a7x5Btn;
    a7x5Btn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        a7x5BtnActionPerformed(arg0);
      }
    });
    a7x5Btn.setBackground(Color.BLACK);
    a7x5Btn.setMargin(new Insets(2, 2, 2, 2));
    a7x5Btn.setPreferredSize(new Dimension(40, 40));
    a7x5Btn.setMinimumSize(new Dimension(40, 40));
    a7x5Btn.setMaximumSize(new Dimension(40, 40));
    GridBagConstraints gbc_a7x5Btn = new GridBagConstraints();
    gbc_a7x5Btn.insets = new Insets(0, 0, 5, 5);
    gbc_a7x5Btn.gridx = 8;
    gbc_a7x5Btn.gridy = 6;
    grid.add(a7x5Btn, gbc_a7x5Btn);

    a7x6Btn = new AtomJButton(7, 6);
    atomButtons[7][6] = a7x6Btn;
    a7x6Btn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        a7x6BtnActionPerformed(arg0);
      }
    });
    a7x6Btn.setBackground(Color.BLACK);
    a7x6Btn.setMargin(new Insets(2, 2, 2, 2));
    a7x6Btn.setPreferredSize(new Dimension(40, 40));
    a7x6Btn.setMinimumSize(new Dimension(40, 40));
    a7x6Btn.setMaximumSize(new Dimension(40, 40));
    GridBagConstraints gbc_a7x6Btn = new GridBagConstraints();
    gbc_a7x6Btn.insets = new Insets(0, 0, 5, 5);
    gbc_a7x6Btn.gridx = 8;
    gbc_a7x6Btn.gridy = 7;
    grid.add(a7x6Btn, gbc_a7x6Btn);

    a7x7Btn = new AtomJButton(7, 7);
    atomButtons[7][7] = a7x7Btn;
    a7x7Btn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        a7x7BtnActionPerformed(arg0);
      }
    });
    a7x7Btn.setBackground(Color.BLACK);
    a7x7Btn.setMargin(new Insets(2, 2, 2, 2));
    a7x7Btn.setPreferredSize(new Dimension(40, 40));
    a7x7Btn.setMinimumSize(new Dimension(40, 40));
    a7x7Btn.setMaximumSize(new Dimension(40, 40));
    GridBagConstraints gbc_a7x7Btn = new GridBagConstraints();
    gbc_a7x7Btn.insets = new Insets(0, 0, 5, 5);
    gbc_a7x7Btn.gridx = 8;
    gbc_a7x7Btn.gridy = 8;
    grid.add(a7x7Btn, gbc_a7x7Btn);

    // Creates a menu bar, menu categories, and menu items.
    menuBar = new JMenuBar();
    menuBar.setFocusable(false);
    menuBar.setRequestFocusEnabled(false);
    setJMenuBar(menuBar);

    mnFile = new JMenu("File");
    mnFile.setMnemonic('F');
    menuBar.add(mnFile);

    mntmNewGame = new JMenuItem("New Game");
    mntmNewGame.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        try {
          listener.newGame();
        } catch (@SuppressWarnings ("unused")
        NullPointerException ex) {
          System.out.println("New Game selected.");
        }
      }
    });
    mntmNewGame.setAccelerator(
        KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
    mnFile.add(mntmNewGame);

    mntmSolve = new JMenuItem("Solve");
    mntmSolve.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        try {
          listener.solve();
        } catch (@SuppressWarnings ("unused")
        NullPointerException ex) {
          System.out.println("Solve selected.");
        }
      }
    });
    mntmSolve.setAccelerator(
        KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, ActionEvent.CTRL_MASK));
    mnFile.add(mntmSolve);

    mntmQuit = new JMenuItem("Quit");
    mntmQuit.setAccelerator(
        KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK));
    mntmQuit.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        try {
          listener.quit();
        } catch (@SuppressWarnings ("unused")
        NullPointerException ex) {
          System.exit(0);
        }
      }
    });
    mnFile.add(mntmQuit);

    mnHelp = new JMenu("Help");
    mnHelp.setMnemonic('H');
    menuBar.add(mnHelp);

    mntmHelp = new JMenuItem("Help");
    mntmHelp.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        listener.help();
      }
    });
    mnHelp.add(mntmHelp);

    mntmAbout = new JMenuItem("About");
    mntmAbout.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        aboutMessage();
      }
    });
    mnHelp.add(mntmAbout);

  }

  // The next methods are the action methods for the ray and atom buttons. They
  // trigger whenever the corresponding button is clicked.

  /**
   * North 0 button action.
   * 
   * @param evt button event
   */
  private void n0BtnActionPerformed(java.awt.event.ActionEvent evt) {
    listener.rayButtonEvent(n0Btn);
  }

  /**
   * North 1 button action.
   * 
   * @param evt button event
   */
  private void n1BtnActionPerformed(java.awt.event.ActionEvent evt) {
    listener.rayButtonEvent(n1Btn);
  }

  /**
   * North 2 button action.
   * 
   * @param evt button event
   */
  private void n2BtnActionPerformed(java.awt.event.ActionEvent evt) {
    listener.rayButtonEvent(n2Btn);
  }

  /**
   * North 3 button action.
   * 
   * @param evt button event
   */
  private void n3BtnActionPerformed(java.awt.event.ActionEvent evt) {
    listener.rayButtonEvent(n3Btn);
  }

  /**
   * North 4 button action.
   * 
   * @param evt button event
   */
  private void n4BtnActionPerformed(java.awt.event.ActionEvent evt) {
    listener.rayButtonEvent(n4Btn);
  }

  /**
   * North 5 button action.
   * 
   * @param evt button event
   */
  private void n5BtnActionPerformed(java.awt.event.ActionEvent evt) {
    listener.rayButtonEvent(n5Btn);
  }

  /**
   * North 6 button action.
   * 
   * @param evt button event
   */
  private void n6BtnActionPerformed(java.awt.event.ActionEvent evt) {
    listener.rayButtonEvent(n6Btn);
  }

  /**
   * North 7 button action.
   * 
   * @param evt button event
   */
  private void n7BtnActionPerformed(java.awt.event.ActionEvent evt) {
    listener.rayButtonEvent(n7Btn);
  }

  /**
   * West 0 button action.
   * 
   * @param evt button event
   */
  private void w0BtnActionPerformed(java.awt.event.ActionEvent evt) {
    listener.rayButtonEvent(w0Btn);
  }

  /**
   * West 1 button action.
   * 
   * @param evt button event
   */
  private void w1BtnActionPerformed(java.awt.event.ActionEvent evt) {
    listener.rayButtonEvent(w1Btn);
  }

  /**
   * West 2 button action.
   * 
   * @param evt button event
   */
  private void w2BtnActionPerformed(java.awt.event.ActionEvent evt) {
    listener.rayButtonEvent(w2Btn);
  }

  /**
   * West 3 button action.
   * 
   * @param evt button event
   */
  private void w3BtnActionPerformed(java.awt.event.ActionEvent evt) {
    listener.rayButtonEvent(w3Btn);
  }

  /**
   * West 4 button action.
   * 
   * @param evt button event
   */
  private void w4BtnActionPerformed(java.awt.event.ActionEvent evt) {
    listener.rayButtonEvent(w4Btn);
  }

  /**
   * West 5 button action.
   * 
   * @param evt button event
   */
  private void w5BtnActionPerformed(java.awt.event.ActionEvent evt) {
    listener.rayButtonEvent(w5Btn);
  }

  /**
   * West 6 button action.
   * 
   * @param evt button event
   */
  private void w6BtnActionPerformed(java.awt.event.ActionEvent evt) {
    listener.rayButtonEvent(w6Btn);
  }

  /**
   * West 7 button action.
   * 
   * @param evt button event
   */
  private void w7BtnActionPerformed(java.awt.event.ActionEvent evt) {
    listener.rayButtonEvent(w7Btn);
  }

  /**
   * East 0 button action.
   * 
   * @param evt button event
   */
  private void e0BtnActionPerformed(java.awt.event.ActionEvent evt) {
    listener.rayButtonEvent(e0Btn);
  }

  /**
   * East 1 button action.
   * 
   * @param evt button event
   */
  private void e1BtnActionPerformed(java.awt.event.ActionEvent evt) {
    listener.rayButtonEvent(e1Btn);
  }

  /**
   * East 2 button action.
   * 
   * @param evt button event
   */
  private void e2BtnActionPerformed(java.awt.event.ActionEvent evt) {
    listener.rayButtonEvent(e2Btn);
  }

  /**
   * East 3 button action.
   * 
   * @param evt button event
   */
  private void e3BtnActionPerformed(java.awt.event.ActionEvent evt) {
    listener.rayButtonEvent(e3Btn);
  }

  /**
   * East 4 button action.
   * 
   * @param evt button event
   */
  private void e4BtnActionPerformed(java.awt.event.ActionEvent evt) {
    listener.rayButtonEvent(e4Btn);
  }

  /**
   * East 5 button action.
   * 
   * @param evt button event
   */
  private void e5BtnActionPerformed(java.awt.event.ActionEvent evt) {
    listener.rayButtonEvent(e5Btn);
  }

  /**
   * East 6 button action.
   * 
   * @param evt button event
   */
  private void e6BtnActionPerformed(java.awt.event.ActionEvent evt) {
    listener.rayButtonEvent(e6Btn);
  }

  /**
   * East 7 button action.
   * 
   * @param evt button event
   */
  private void e7BtnActionPerformed(java.awt.event.ActionEvent evt) {
    listener.rayButtonEvent(e7Btn);
  }

  /**
   * South 0 button action.
   * 
   * @param evt button event
   */
  private void s0BtnActionPerformed(java.awt.event.ActionEvent evt) {
    listener.rayButtonEvent(s0Btn);
  }

  /**
   * South 1 button action.
   * 
   * @param evt button event
   */
  private void s1BtnActionPerformed(java.awt.event.ActionEvent evt) {
    listener.rayButtonEvent(s1Btn);
  }

  /**
   * South 2 button action.
   * 
   * @param evt button event
   */
  private void s2BtnActionPerformed(java.awt.event.ActionEvent evt) {
    listener.rayButtonEvent(s2Btn);
  }

  /**
   * South 3 button action.
   * 
   * @param evt button event
   */
  private void s3BtnActionPerformed(java.awt.event.ActionEvent evt) {
    listener.rayButtonEvent(s3Btn);
  }

  /**
   * South 4 button action.
   * 
   * @param evt button event
   */
  private void s4BtnActionPerformed(java.awt.event.ActionEvent evt) {
    listener.rayButtonEvent(s4Btn);
  }

  /**
   * South 5 button action.
   * 
   * @param evt button event
   */
  private void s5BtnActionPerformed(java.awt.event.ActionEvent evt) {
    listener.rayButtonEvent(s5Btn);
  }

  /**
   * South 6 button action.
   * 
   * @param evt button event
   */
  private void s6BtnActionPerformed(java.awt.event.ActionEvent evt) {
    listener.rayButtonEvent(s6Btn);
  }

  /**
   * South 7 button action.
   * 
   * @param evt button event
   */
  private void s7BtnActionPerformed(java.awt.event.ActionEvent evt) {
    listener.rayButtonEvent(s7Btn);
  }

  /**
   * Atom 0x0 button action.
   * 
   * @param evt button event
   */
  private void a0x0BtnActionPerformed(java.awt.event.ActionEvent evt) {
    listener.atomButtonEvent(a0x0Btn);
  }

  /**
   * Atom 0x1 button action.
   * 
   * @param evt button event
   */
  private void a0x1BtnActionPerformed(java.awt.event.ActionEvent evt) {
    listener.atomButtonEvent(a0x1Btn);
  }

  /**
   * Atom 0x2 button action.
   * 
   * @param evt button event
   */
  private void a0x2BtnActionPerformed(java.awt.event.ActionEvent evt) {
    listener.atomButtonEvent(a0x2Btn);
  }

  /**
   * Atom 0x3 button action.
   * 
   * @param evt button event
   */
  private void a0x3BtnActionPerformed(java.awt.event.ActionEvent evt) {
    listener.atomButtonEvent(a0x3Btn);
  }

  /**
   * Atom 0x4 button action.
   * 
   * @param evt button event
   */
  private void a0x4BtnActionPerformed(java.awt.event.ActionEvent evt) {
    listener.atomButtonEvent(a0x4Btn);
  }

  /**
   * Atom 0x5 button action.
   * 
   * @param evt button event
   */
  private void a0x5BtnActionPerformed(java.awt.event.ActionEvent evt) {
    listener.atomButtonEvent(a0x5Btn);
  }

  /**
   * Atom 0x6 button action.
   * 
   * @param evt button event
   */
  private void a0x6BtnActionPerformed(java.awt.event.ActionEvent evt) {
    listener.atomButtonEvent(a0x6Btn);
  }

  /**
   * Atom 0x7 button action.
   * 
   * @param evt button event
   */
  private void a0x7BtnActionPerformed(java.awt.event.ActionEvent evt) {
    listener.atomButtonEvent(a0x7Btn);
  }

  /**
   * Atom 1x0 button action.
   * 
   * @param evt button event
   */
  private void a1x0BtnActionPerformed(java.awt.event.ActionEvent evt) {
    listener.atomButtonEvent(a1x0Btn);
  }

  /**
   * Atom 1x1 button action.
   * 
   * @param evt button event
   */
  private void a1x1BtnActionPerformed(java.awt.event.ActionEvent evt) {
    listener.atomButtonEvent(a1x1Btn);
  }

  /**
   * Atom 1x2 button action.
   * 
   * @param evt button event
   */
  private void a1x2BtnActionPerformed(java.awt.event.ActionEvent evt) {
    listener.atomButtonEvent(a1x2Btn);
  }

  /**
   * Atom 1x3 button action.
   * 
   * @param evt button event
   */
  private void a1x3BtnActionPerformed(java.awt.event.ActionEvent evt) {
    listener.atomButtonEvent(a1x3Btn);
  }

  /**
   * Atom 1x4 button action.
   * 
   * @param evt button event
   */
  private void a1x4BtnActionPerformed(java.awt.event.ActionEvent evt) {
    listener.atomButtonEvent(a1x4Btn);
  }

  /**
   * Atom 1x5 button action.
   * 
   * @param evt button event
   */
  private void a1x5BtnActionPerformed(java.awt.event.ActionEvent evt) {
    listener.atomButtonEvent(a1x5Btn);
  }

  /**
   * Atom 1x6 button action.
   * 
   * @param evt button event
   */
  private void a1x6BtnActionPerformed(java.awt.event.ActionEvent evt) {
    listener.atomButtonEvent(a1x6Btn);
  }

  /**
   * Atom 1x7 button action.
   * 
   * @param evt button event
   */
  private void a1x7BtnActionPerformed(java.awt.event.ActionEvent evt) {
    listener.atomButtonEvent(a1x7Btn);
  }

  /**
   * Atom 2x0 button action.
   * 
   * @param evt button event
   */
  private void a2x0BtnActionPerformed(java.awt.event.ActionEvent evt) {
    listener.atomButtonEvent(a2x0Btn);
  }

  /**
   * Atom 2x1 button action.
   * 
   * @param evt button event
   */
  private void a2x1BtnActionPerformed(java.awt.event.ActionEvent evt) {
    listener.atomButtonEvent(a2x1Btn);
  }

  /**
   * Atom 2x2 button action.
   * 
   * @param evt button event
   */
  private void a2x2BtnActionPerformed(java.awt.event.ActionEvent evt) {
    listener.atomButtonEvent(a2x2Btn);
  }

  /**
   * Atom 2x3 button action.
   * 
   * @param evt button event
   */
  private void a2x3BtnActionPerformed(java.awt.event.ActionEvent evt) {
    listener.atomButtonEvent(a2x3Btn);
  }

  /**
   * Atom 2x4 button action.
   * 
   * @param evt button event
   */
  private void a2x4BtnActionPerformed(java.awt.event.ActionEvent evt) {
    listener.atomButtonEvent(a2x4Btn);
  }

  /**
   * Atom 2x5 button action.
   * 
   * @param evt button event
   */
  private void a2x5BtnActionPerformed(java.awt.event.ActionEvent evt) {
    listener.atomButtonEvent(a2x5Btn);
  }

  /**
   * Atom 2x6 button action.
   * 
   * @param evt button event
   */
  private void a2x6BtnActionPerformed(java.awt.event.ActionEvent evt) {
    listener.atomButtonEvent(a2x6Btn);
  }

  /**
   * Atom 2x7 button action.
   * 
   * @param evt button event
   */
  private void a2x7BtnActionPerformed(java.awt.event.ActionEvent evt) {
    listener.atomButtonEvent(a2x7Btn);
  }

  /**
   * Atom 3x0 button action.
   * 
   * @param evt button event
   */
  private void a3x0BtnActionPerformed(java.awt.event.ActionEvent evt) {
    listener.atomButtonEvent(a3x0Btn);
  }

  /**
   * Atom 3x1 button action.
   * 
   * @param evt button event
   */
  private void a3x1BtnActionPerformed(java.awt.event.ActionEvent evt) {
    listener.atomButtonEvent(a3x1Btn);
  }

  /**
   * Atom 3x2 button action.
   * 
   * @param evt button event
   */
  private void a3x2BtnActionPerformed(java.awt.event.ActionEvent evt) {
    listener.atomButtonEvent(a3x2Btn);
  }

  /**
   * Atom 3x3 button action.
   * 
   * @param evt button event
   */
  private void a3x3BtnActionPerformed(java.awt.event.ActionEvent evt) {
    listener.atomButtonEvent(a3x3Btn);
  }

  /**
   * Atom 3x4 button action.
   * 
   * @param evt button event
   */
  private void a3x4BtnActionPerformed(java.awt.event.ActionEvent evt) {
    listener.atomButtonEvent(a3x4Btn);
  }

  /**
   * Atom 3x5 button action.
   * 
   * @param evt button event
   */
  private void a3x5BtnActionPerformed(java.awt.event.ActionEvent evt) {
    listener.atomButtonEvent(a3x5Btn);
  }

  /**
   * Atom 3x6 button action.
   * 
   * @param evt button event
   */
  private void a3x6BtnActionPerformed(java.awt.event.ActionEvent evt) {
    listener.atomButtonEvent(a3x6Btn);
  }

  /**
   * Atom 3x7 button action.
   * 
   * @param evt button event
   */
  private void a3x7BtnActionPerformed(java.awt.event.ActionEvent evt) {
    listener.atomButtonEvent(a3x7Btn);
  }

  /**
   * Atom 4x0 button action.
   * 
   * @param evt button event
   */
  private void a4x0BtnActionPerformed(java.awt.event.ActionEvent evt) {
    listener.atomButtonEvent(a4x0Btn);
  }

  /**
   * Atom 4x1 button action.
   * 
   * @param evt button event
   */
  private void a4x1BtnActionPerformed(java.awt.event.ActionEvent evt) {
    listener.atomButtonEvent(a4x1Btn);
  }

  /**
   * Atom 4x2 button action.
   * 
   * @param evt button event
   */
  private void a4x2BtnActionPerformed(java.awt.event.ActionEvent evt) {
    listener.atomButtonEvent(a4x2Btn);
  }

  /**
   * Atom 4x3 button action.
   * 
   * @param evt button event
   */
  private void a4x3BtnActionPerformed(java.awt.event.ActionEvent evt) {
    listener.atomButtonEvent(a4x3Btn);
  }

  /**
   * Atom 4x4 button action.
   * 
   * @param evt button event
   */
  private void a4x4BtnActionPerformed(java.awt.event.ActionEvent evt) {
    listener.atomButtonEvent(a4x4Btn);
  }

  /**
   * Atom 4x5 button action.
   * 
   * @param evt button event
   */
  private void a4x5BtnActionPerformed(java.awt.event.ActionEvent evt) {
    listener.atomButtonEvent(a4x5Btn);
  }

  /**
   * Atom 4x6 button action.
   * 
   * @param evt button event
   */
  private void a4x6BtnActionPerformed(java.awt.event.ActionEvent evt) {
    listener.atomButtonEvent(a4x6Btn);
  }

  /**
   * Atom 4x7 button action.
   * 
   * @param evt button event
   */
  private void a4x7BtnActionPerformed(java.awt.event.ActionEvent evt) {
    listener.atomButtonEvent(a4x7Btn);
  }

  /**
   * Atom 5x0 button action.
   * 
   * @param evt button event
   */
  private void a5x0BtnActionPerformed(java.awt.event.ActionEvent evt) {
    listener.atomButtonEvent(a5x0Btn);
  }

  /**
   * Atom 5x1 button action.
   * 
   * @param evt button event
   */
  private void a5x1BtnActionPerformed(java.awt.event.ActionEvent evt) {
    listener.atomButtonEvent(a5x1Btn);
  }

  /**
   * Atom 5x2 button action.
   * 
   * @param evt button event
   */
  private void a5x2BtnActionPerformed(java.awt.event.ActionEvent evt) {
    listener.atomButtonEvent(a5x2Btn);
  }

  /**
   * Atom 5x3 button action.
   * 
   * @param evt button event
   */
  private void a5x3BtnActionPerformed(java.awt.event.ActionEvent evt) {
    listener.atomButtonEvent(a5x3Btn);
  }

  /**
   * Atom 5x4 button action.
   * 
   * @param evt button event
   */
  private void a5x4BtnActionPerformed(java.awt.event.ActionEvent evt) {
    listener.atomButtonEvent(a5x4Btn);
  }

  /**
   * Atom 5x5 button action.
   * 
   * @param evt button event
   */
  private void a5x5BtnActionPerformed(java.awt.event.ActionEvent evt) {
    listener.atomButtonEvent(a5x5Btn);
  }

  /**
   * Atom 5x6 button action.
   * 
   * @param evt button event
   */
  private void a5x6BtnActionPerformed(java.awt.event.ActionEvent evt) {
    listener.atomButtonEvent(a5x6Btn);
  }

  /**
   * Atom 5x7 button action.
   * 
   * @param evt button event
   */
  private void a5x7BtnActionPerformed(java.awt.event.ActionEvent evt) {
    listener.atomButtonEvent(a5x7Btn);
  }

  /**
   * Atom 6x0 button action.
   * 
   * @param evt button event
   */
  private void a6x0BtnActionPerformed(java.awt.event.ActionEvent evt) {
    listener.atomButtonEvent(a6x0Btn);
  }

  /**
   * Atom 6x1 button action.
   * 
   * @param evt button event
   */
  private void a6x1BtnActionPerformed(java.awt.event.ActionEvent evt) {
    listener.atomButtonEvent(a6x1Btn);
  }

  /**
   * Atom 6x2 button action.
   * 
   * @param evt button event
   */
  private void a6x2BtnActionPerformed(java.awt.event.ActionEvent evt) {
    listener.atomButtonEvent(a6x2Btn);
  }

  /**
   * Atom 6x3 button action.
   * 
   * @param evt button event
   */
  private void a6x3BtnActionPerformed(java.awt.event.ActionEvent evt) {
    listener.atomButtonEvent(a6x3Btn);
  }

  /**
   * Atom 6x4 button action.
   * 
   * @param evt button event
   */
  private void a6x4BtnActionPerformed(java.awt.event.ActionEvent evt) {
    listener.atomButtonEvent(a6x4Btn);
  }

  /**
   * Atom 6x5 button action.
   * 
   * @param evt button event
   */
  private void a6x5BtnActionPerformed(java.awt.event.ActionEvent evt) {
    listener.atomButtonEvent(a6x5Btn);
  }

  /**
   * Atom 6x6 button action.
   * 
   * @param evt button event
   */
  private void a6x6BtnActionPerformed(java.awt.event.ActionEvent evt) {
    listener.atomButtonEvent(a6x6Btn);
  }

  /**
   * Atom 6x7 button action.
   * 
   * @param evt button event
   */
  private void a6x7BtnActionPerformed(java.awt.event.ActionEvent evt) {
    listener.atomButtonEvent(a6x7Btn);
  }

  /**
   * Atom 7x0 button action.
   * 
   * @param evt button event
   */
  private void a7x0BtnActionPerformed(java.awt.event.ActionEvent evt) {
    listener.atomButtonEvent(a7x0Btn);
  }

  /**
   * Atom 7x1 button action.
   * 
   * @param evt button event
   */
  private void a7x1BtnActionPerformed(java.awt.event.ActionEvent evt) {
    listener.atomButtonEvent(a7x1Btn);
  }

  /**
   * Atom 7x2 button action.
   * 
   * @param evt button event
   */
  private void a7x2BtnActionPerformed(java.awt.event.ActionEvent evt) {
    listener.atomButtonEvent(a7x2Btn);
  }

  /**
   * Atom 7x3 button action.
   * 
   * @param evt button event
   */
  private void a7x3BtnActionPerformed(java.awt.event.ActionEvent evt) {
    listener.atomButtonEvent(a7x3Btn);
  }

  /**
   * Atom 7x4 button action.
   * 
   * @param evt button event
   */
  private void a7x4BtnActionPerformed(java.awt.event.ActionEvent evt) {
    listener.atomButtonEvent(a7x4Btn);
  }

  /**
   * Atom 7x5 button action.
   * 
   * @param evt button event
   */
  private void a7x5BtnActionPerformed(java.awt.event.ActionEvent evt) {
    listener.atomButtonEvent(a7x5Btn);
  }

  /**
   * Atom 7x6 button action.
   * 
   * @param evt button event
   */
  private void a7x6BtnActionPerformed(java.awt.event.ActionEvent evt) {
    listener.atomButtonEvent(a7x6Btn);
  }

  /**
   * Atom 7x7 button action.
   * 
   * @param evt button event
   */
  private void a7x7BtnActionPerformed(java.awt.event.ActionEvent evt) {
    listener.atomButtonEvent(a7x7Btn);
  }

  /**
   * Display the about dialog.
   */
  private void aboutMessage() {
    JOptionPane.showMessageDialog(this,
        "Credits:\nDeveloper: Noah Ando\nMentor: Scott Reinhart\nInventor: Eric Soloman\nPublisher: Waddingtons\nPublisher: Parker Brothers",
        "About Blackbox Game", JOptionPane.PLAIN_MESSAGE);
  }

  /**
   * Set all the atom buttons to default.
   */
  public final void setAtomDefault() {
    for (int x = 0; x <= 7; x++) {
      for (int y = 0; y <= 7; y++) {
        setAtomButton(new Position(x, y), false);
        atomButtons[x][y].setBackground(Color.BLACK);
      }
    }
  }

  /**
   * Set the specified atom button state.
   *
   * @param pos   grid position
   * @param state button atom state
   */
  public final void setAtomButton(Position pos, boolean state) {
    AtomJButton button = (AtomJButton) atomButtons[pos.x][pos.y];
    button.setAtom(state);
    button.setIcon( (state) ? atomIcon : clearIcon);
  }

  /**
   * Sets an atom's background color to green.
   * 
   * @param pos the position of the target button
   */
  public final void setAtomGreen(Position pos) {
    atomButtons[pos.x][pos.y].setBackground(Color.GREEN);
  }

  /**
   * Sets an atom's background color to red.
   * 
   * @param pos the position of the target button
   */
  public final void setAtomRed(Position pos) {
    atomButtons[pos.x][pos.y].setBackground(Color.RED);
  }

  /**
   * Get the specified atom button state.
   *
   * @param pos location of button
   * @return Button atom state.
   */
  public final boolean getAtomButton(Position pos) {
    return ((AtomJButton) atomButtons[pos.x][pos.y]).isAtom();
  }

  /**
   * Set all the ray buttons to default.
   */
  public final void setRayDefault() {
    for (int x = 0; x <= 3; x++) {
      for (int y = 0; y <= 7; y++) {
        setRayData(new Position(x, y), 0, rayBgndColor);
      }
    }
  }

  /**
   * Set the specified ray button data and background color.
   *
   * @param pos       ray position
   * @param number    ray number
   * @param bgndColor background color; null sets to default color
   */
  public final void setRayData(Position pos, int number, Color bgndColor) {
    RayJButton button = (RayJButton) rayButtons[pos.x][pos.y];
    button.setNumber(number, ( (bgndColor == null) ? rayBgndColor : bgndColor));
  }

  /**
   * Get the specified ray button background color.
   *
   * @param pos location of button
   * @return Button background color.
   */
  public final Color getRayButtonBackground(Position pos) {
    return ((RayJButton) rayButtons[pos.x][pos.y]).getBackground();
  }

  /**
   * Sets the score and displays it.
   * 
   * @param score the score to display
   */
  public final void setScore(int score) {
    txtFldScore.setText(Integer.toString(score));
  }

  /**
   * Resets the score to zero.
   */
  public final void resetScore() {
    txtFldScore.setText("");
  }
}
