import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ConsoleBallAnimation {
    private static final int WIDTH = 50;
    private static final int HEIGHT = 20;

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
            if (x <= 0 || x >= WIDTH - 1) {
                xDirection *= -1;
            }
            if (y <= 0 || y >= HEIGHT - 1) {
                yDirection *= -1;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        List<Ball> balls = new ArrayList<>();

        // Create balls
        createBalls(balls);

        // Animation loop
        while (true) {
            moveBalls(balls);
            printScreen(balls);
            Thread.sleep(100); // Delay for better visualization
        }
    }

    private static void createBalls(List<Ball> balls) {
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            balls.add(new Ball(random.nextInt(WIDTH), random.nextInt(HEIGHT), random.nextBoolean() ? 1 : -1, random.nextBoolean() ? 1 : -1));
        }
    }

    private static void moveBalls(List<Ball> balls) {
        for (Ball ball : balls) {
            ball.move();
        }
    }

    private static void printScreen(List<Ball> balls) {
        System.out.print("\033[H\033[2J"); // Clear console
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                char symbol = ' ';
                for (Ball ball : balls) {
                    if (ball.x == j && ball.y == i) {
                        symbol = 'O';
                    }
                }
                System.out.print(symbol);
            }
            System.out.println();
        }
    }
}
