
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.WindowConstants;

public class SwingBallAnimation extends JFrame {

	private static final long serialVersionUID = 3305372670620496856L;
	private static final int WIDTH = 600;
	private static final int HEIGHT = 400;
	private static final int BALL_RADIUS = 20;
	Random random = new Random();

	private transient List<Ball> balls = new ArrayList<>();

	private static class Ball {
		int x;
		int y;
		int xDirection;
		int yDirection;

		public Ball(int x, int y, int xDirection, int yDirection) {
			this.x = x;
			this.y = y;
			this.xDirection = xDirection;
			this.yDirection = yDirection;
		}

		public void move() {
			x += xDirection;
			y += yDirection;

			// Bounce off walls
			if (x <= 0 || x >= WIDTH - 2 * BALL_RADIUS) {
				xDirection *= -1;
			}
			if (y <= 0 || y >= HEIGHT - 2 * BALL_RADIUS) {
				yDirection *= -1;
			}
		}
	}

	public SwingBallAnimation() {
		setTitle("Ball Animation");
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		// Create balls
		createBalls();

		// Timer for animation
		Timer timer = new Timer(30, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				moveBalls();
				repaint();
			}
		});
		timer.start();
	}

	private void createBalls() {
		for (int i = 0; i < 5; i++) {
			balls.add(new Ball(random.nextInt(getWidth() - 2 * BALL_RADIUS), random.nextInt(HEIGHT - 2 * BALL_RADIUS),
					random.nextInt(5) + 1, random.nextInt(5) + 1));
		}
	}

	private void moveBalls() {
		for (Ball ball : balls) {
			ball.move();
		}
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		for (Ball ball : balls) {
			g.setColor(Color.BLUE);
			g.fillOval(ball.x, ball.y, 2 * BALL_RADIUS, 2 * BALL_RADIUS);
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new SwingBallAnimation().setVisible(true);
			}
		});
	}
}
