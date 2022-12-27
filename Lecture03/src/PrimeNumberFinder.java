import java.util.Scanner;

/*
 * Here is a Java code that will find and print the prime numbers after a given input:
 * 
 * This code first prompts the user to enter a number, then it loops through all 
 * the numbers starting from that number. For each number, it checks if it is prime 
 * by dividing it by all the numbers between 2 and itself-1. If the number is not 
 * divisible by any of these numbers, it is marked as prime and printed to the 
 * console. The loop continues until a prime number is found.
 * */

public class PrimeNumberFinder {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter a number: ");
		int num = sc.nextInt();
		sc.close();

		// Loop through all numbers starting from the input number
		for (int i = num + 1; ; i++) {
			boolean isPrime = true;

			// Check if the number is prime
			for (int j = 2; j < i; j++) {
				if (i % j == 0) {
					isPrime = false;
					break;
				}
			}

			if (isPrime) {
				System.out.println(i);
				break;
			}
		}
	}
}
