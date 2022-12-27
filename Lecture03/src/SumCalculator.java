import java.util.Scanner;

/*
 * Here is a code that takes two input numbers from the user and prints their sum:
 * 
 * */

public class SumCalculator {
	
	public static void main(String[] args) {
		// Create a Scanner object to read input from the command line
		Scanner scanner = new Scanner(System.in);

		// Prompt the user to enter two numbers
		System.out.print("Enter the first number: ");
		double num1 = scanner.nextDouble();
		System.out.print("Enter the second number: ");
		double num2 = scanner.nextDouble();
		scanner.close();

		// Calculate the sum of the two numbers
		double sum = num1 + num2;

		// Print the result
		System.out.println("The sum of the two numbers is: " + sum);
	}
}
