package recursive;
import java.util.Scanner;

/*
 * Here is an example code for finding the factorial of a given input in Java:
 * 
 * This code prompts the user to enter a number, and then calculates the 
 * factorial of that number using a loop. The result is then printed to the console.
 * 
 * */

public class Factorial {

	public static int recursiveFactorial(int number) {
		int initial = 0;
		if (number == initial) {
			return initial + 1;
		}
		return number * recursiveFactorial(number - 1);
	}

	public static int factorial(int number) {
		int result = 1;

		for (int i = 1; i <= number; i++) {
			result *= i;
		}
		return result;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a number to find the factorial: ");
		int num = sc.nextInt();
		sc.close();

		System.out.println("The factorial of " + num + " is " + Factorial.factorial(num));
		System.out.println("The factorial of " + num + " is " + Factorial.recursiveFactorial(num));
	}
}
