import java.util.Scanner;

/*
 * Here is an example code that takes three integers as input from the user and 
 * calculates the average:
 * 
 * This code uses the Scanner class to get input from the user, calculates the sum 
 * of the three numbers, and then divides the sum by 3 to get the average. 
 * The result is then printed to the console.
 * 
 * */

public class AverageCalculator {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// Get inputs from the user
		System.out.println("Enter the first number: ");
		int num1 = scanner.nextInt();
		System.out.println("Enter the second number: ");
		int num2 = scanner.nextInt();
		System.out.println("Enter the third number: ");
		int num3 = scanner.nextInt();
		scanner.close();

		// Calculate the average
		int sum = num1 + num2 + num3;
		double average = sum / 3.0;

		// Print the result
		System.out.println("The average of the numbers is: " + average);
	}
}
