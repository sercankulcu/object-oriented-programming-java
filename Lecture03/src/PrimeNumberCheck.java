import java.util.Scanner;

/*
 * Here is a Java code that takes an integer as input and checks if it is a 
 * prime number:
 * 
 * This code first takes an integer as input using a Scanner object. It then 
 * initializes a boolean variable isPrime to true. It then checks if the number 
 * is either 0 or 1, in which case it sets isPrime to false. If the number is 
 * not 0 or 1, it loops through the numbers from 2 to half of the number and 
 * checks if the number is divisible by any of these numbers. If it is, it sets 
 * isPrime to false and breaks out of the loop. Finally, it prints a message 
 * indicating whether the number is a prime number or not based on the value of 
 * isPrime.
 * */

public class PrimeNumberCheck {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a number: ");
		int number = sc.nextInt();
		sc.close();
		boolean isPrime = true;

		if (number == 0 || number == 1) {
			isPrime = false;
		} else {
			for (int i = 2; i <= number/2; i++) {
				if (number % i == 0) {
					isPrime = false;
					break;
				}
			}
		}

		if (isPrime) {
			System.out.println(number + " is a prime number.");
		} else {
			System.out.println(number + " is not a prime number.");
		}
	}
}
