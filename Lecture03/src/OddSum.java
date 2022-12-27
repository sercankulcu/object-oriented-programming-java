import java.util.Scanner;

/*
 * Here is a sample Java code that adds up the odd numbers up to a given number:
 * 
 * This code prompts the user to enter a number, and then it uses a for loop to 
 * iterate through the numbers from 1 to the entered number. For each number, it 
 * checks if it is odd using the modulo operator (%). If it is odd, it adds it to 
 * the sum variable. Finally, it prints out the sum of the odd numbers.
 * 
 * */

public class OddSum {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a number: ");
		int num = scanner.nextInt();
		scanner.close();
		int sum = 0;
		for (int i = 1; i <= num; i++) {
			if (i % 2 == 1) {
				sum += i;
			}
		}
		System.out.println("Sum of odd numbers up to " + num + ": " + sum);
	}
}
