import java.util.Scanner;

/*
 * Here is a Java program that simulates a bouncing ball by computing its height at each second as time passes:
 * 
 * The ball's velocity is decreased by an amount proportional to the acceleration due to gravity 
 * and the elapsed time. If the ball's height becomes negative, the program reverses the ball's 
 * velocity and reduces it by 50% to simulate the bounce.
 * 
 * */

public class Bounce {
	
  public static void main(String[] args) {
	  
    Scanner sc = new Scanner(System.in);

    // Prompt the user to enter the initial velocity
    System.out.print("Enter the initial velocity: ");
    double velocity = sc.nextDouble();
    sc.close();

    // Set the initial height to 0
    double height = 0;

    // Set the initial time to 0
    double time = 0;

    // Set the bounce counter to 0
    int bounce = 0;

    // Simulate the bouncing ball until the fifth bounce
    while (bounce < 5) {
      // Print the current time and height
      System.out.println("Time: " + time + " seconds" + " Height: " + height + " feet" + " Velocity: " + velocity);

      // Update the height and velocity
      height += velocity;
      velocity -= 32;

      // Check if the ball has bounced
      if (height < 0) {
        // Reverse the velocity and reduce it by 50%
        velocity *= -0.5;

        // Reset the height to 0
        height = 0;

        // Increment the bounce counter
        bounce++;
      }

      // Increment the time
      time++;
    }
  }
}
