import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/*
 * Here is an example of a Java program that simulates a ball bouncing around a window:
 * 
 * This code defines a class called Bounce that extends JPanel and implements the ActionListener 
 * interface. The Bounce class has a timer that calls the actionPerformed method every DELAY 
 * milliseconds, which updates the position of the ball and redraws it on the panel. The ball 
 * bounces off the edges of the panel by reversing its direction when it hits an edge.
 * */

public class Bounce extends JPanel implements ActionListener {
  /**
	 * 
	 */
	private static final long serialVersionUID = -6368396547703393842L;
	private static final int WIDTH = 600;
  private static final int HEIGHT = 600;
  private static final int INITIAL_X = 50;
  private static final int INITIAL_Y = 50;
  private static final int DELAY = 10;

  private int x;
  private int y;
  private int dx;
  private int dy;

  public Bounce() {
    x = INITIAL_X;
    y = INITIAL_Y;
    dx = 2;
    dy = 2;

    Timer timer = new Timer(DELAY, this);
    timer.start();
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.fillOval(x, y, 50, 50);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    x += dx;
    y += dy;

    if (x < 0 || x > WIDTH - 50) {
      dx *= -1;
    }
    if (y < 0 || y > HEIGHT - 50) {
      dy *= -1;
    }

    repaint();
  }

  public static void main(String[] args) {
    JFrame frame = new JFrame("Bounce");
    frame.add(new Bounce());
    frame.setSize(WIDTH, HEIGHT);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }
}
