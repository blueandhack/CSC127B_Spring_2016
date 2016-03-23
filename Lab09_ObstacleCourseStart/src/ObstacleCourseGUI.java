import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * @author Muharez Jabeer with modifications by Rick Mercer
 */
public class ObstacleCourseGUI extends ObstacleCourse {
  public static void main(String[] args) {
    String name = JOptionPane.showInputDialog(
        "Enter name of file containing the obstacle course", null);
    ObstacleCourse aCourse = new ObstacleCourseGUI(name);

    // Call the method that calls your private method tryThisWay
    boolean foundExit = aCourse.findTheExit(aCourse.getStartRow(),
        aCourse.getStartColumn());

    if (!foundExit)
      JOptionPane.showMessageDialog(null, "Could not solve");
  }

  private JButton[][] displayBs;

  private int myDelay;

  private boolean hasCleared = false;

  public ObstacleCourseGUI(String fName) {
    super(fName);
    JFrame f = new JFrame();
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container cp = f.getContentPane();
    try {
      UIManager.setLookAndFeel(
          "javax.swing.plaf.metal.MetalLookAndFeel");
    } catch (ClassNotFoundException | InstantiationException
        | IllegalAccessException | UnsupportedLookAndFeelException e1) {
      // TODO Auto-generated catch block
      e1.printStackTrace();
    }

    final int maxPause = 1000; // milliseconds
    final JSlider slider = new JSlider(0, maxPause - 20);
    myDelay = slider.getValue();
    slider.addChangeListener(new ChangeListener() {
      public void stateChanged(ChangeEvent e) {
        myDelay = maxPause - slider.getValue();
      }
    });
    JPanel p = new JPanel();
    p.add(new JLabel("slow"));
    p.add(slider);
    p.add(new JLabel("fast"));
    cp.add(p, "South");

    p = new JPanel(new GridLayout(course.length, course[0].length, 1, 1));
    cp.add(p, BorderLayout.CENTER);

    displayBs = new JButton[course.length][course[0].length];
    for (int i = 0; i < course.length; i++) {
      for (int j = 0; j < course[0].length; j++) {
        JButton b = new JButton(); // pack uses it
        b.setPreferredSize(new Dimension(30, 30));
        b.setFont(new Font("SansSerif", Font.BOLD, 16));
        if (course[i][j] == '+') {
          b.setBackground(Color.RED);
          b.setBorderPainted(true);
          b.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
        } else {
          b.setBackground(Color.WHITE);
          b.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.WHITE));

        }

        if (getStartRow() == i && getStartColumn() == j) {
          b.setText("S");
          b.setBackground(Color.GREEN);
        }
        displayBs[i][j] = b;
        p.add(b);
      }
    }
    f.pack();
    f.setVisible(true);
  }

  public boolean findTheExit(int row, int col) {
    boolean escaped = false;

    if (possible(row, col)) {
      displayBs[row][col].setText(".");
      pause();

      escaped = super.findTheExit(row, col);

      if (escaped) {
        if (!hasCleared) {
          clearAll();
          hasCleared = true;
        }
        displayBs[row][col].setForeground(Color.BLUE);
        displayBs[row][col].setText("0");
      } else {
        displayBs[row][col].setText("B");
        pause();
        displayBs[row][col].setText(".");
      }
    }

    return escaped;
  }

  private void clearAll() {
    for (int r = 0; r < displayBs.length; r++)
      for (int c = 0; c < displayBs[0].length; c++)
        displayBs[r][c].setText(" ");
  }

  private void pause() {
    try {
      Thread.sleep(myDelay);
    } catch (Exception e) {
      throw new InternalError();
    }
  }
}