import javax.swing.*;
import java.awt.*;

/*
 * Here is a Java code using the Swing library that can be used to create a graphical user 
 * interface (GUI) for the Tower of Hanoi puzzle:
 * 
 * This code uses a recursive algorithm to solve the Tower of Hanoi puzzle. The basic idea is 
 * to move the top numDisks - 1 disks from the fromPeg to the auxPeg using the toPeg as the 
 * auxiliary peg, then move the remaining disk from the fromPeg to the toPeg, and finally move 
 * the numDisks - 1 disks from the auxPeg to the toPeg using the fromPeg as the auxiliary peg.
 * 
 * */

public class HanoiTowersGUI extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private static final int WINDOW_WIDTH = 600;
    private static final int WINDOW_HEIGHT = 400;

    private static final int PEG_WIDTH = 20;
    private static final int PEG_HEIGHT = 300;
    private static final int DISK_HEIGHT = 30;

    private static final int NUM_DISKS = 6;
    private static final int NUM_PEGS = 4;

    private int[] pegHeights;
    private JPanel[] pegs;
    private JPanel[] disks;

    public HanoiTowersGUI() {
        pegHeights = new int[NUM_PEGS];

        // create the pegs as vertical panels
        pegs = new JPanel[NUM_PEGS];
        for (int i = 0; i < NUM_PEGS; i++) {
            pegs[i] = new JPanel();
            pegs[i].setPreferredSize(new Dimension(PEG_WIDTH, PEG_HEIGHT));
            pegs[i].setBackground(Color.BLACK);
        }

        // create the disks as horizontal panels
        disks = new JPanel[NUM_DISKS];
        for (int i = 0; i < NUM_DISKS; i++) {
            disks[i] = new JPanel();
            disks[i].setPreferredSize(new Dimension((i + 1) * PEG_WIDTH, DISK_HEIGHT));
            disks[i].setBackground(Color.RED);
        }

        // add the disks to the first peg
        pegHeights[0] = NUM_DISKS;
        for (int i = 0; i < NUM_DISKS; i++) {
            pegs[0].add(disks[i]);
        }

        // add the pegs to the main panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        for (int i = 0; i < NUM_PEGS; i++) {
            mainPanel.add(pegs[i]);
        }

        // set up the main window
        setTitle("Tower of Hanoi");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setLocationRelativeTo(null);
        setResizable(false);
        add(mainPanel);
    }

    public void moveDisk(int fromPeg, int toPeg) {
        // remove the top disk from the fromPeg
        JPanel disk = (JPanel) pegs[fromPeg].getComponent(--pegHeights[fromPeg]);
        pegs[fromPeg].remove(disk);

        // add the disk to the toPeg
        pegs[toPeg].add(disk, pegHeights[toPeg]++);

        // update the display
        revalidate();
        repaint();
    }

    public static void main(String[] args) throws InterruptedException {
    	
      HanoiTowersGUI gui = new HanoiTowersGUI();
      gui.setVisible(true);

      // solve the puzzle using the recursive algorithm
      solveTowerOfHanoi(NUM_DISKS, 0, 1, 2, gui);
  }
    
    public static void solveTowerOfHanoi(int numDisks, int fromPeg, int toPeg, int auxPeg, HanoiTowersGUI gui) throws InterruptedException {
      
    	if (numDisks == 1) {
          // move the top disk from the fromPeg to the toPeg
          gui.moveDisk(fromPeg, toPeg);
          Thread.sleep(1000);
      } else {
          // move the top numDisks - 1 disks from the fromPeg to the auxPeg using the toPeg as the auxiliary peg
          solveTowerOfHanoi(numDisks - 1, fromPeg, auxPeg, toPeg, gui);
          // move the remaining disk from the fromPeg to the toPeg
          gui.moveDisk(fromPeg, toPeg);
          // move the numDisks - 1 disks from the auxPeg to the toPeg using the fromPeg as the auxiliary peg
          solveTowerOfHanoi(numDisks - 1, auxPeg, toPeg, fromPeg, gui);
      }
  }
}