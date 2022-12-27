import java.util.Scanner;

/*
 * Here is a simple Java code to find if a given number is odd or even:
 * 
 * we use the modulo operator (%) to check if the number is evenly divisible 
 * by 2. If it is, then the number is even and we print a message saying so. 
 * If not, then the number is odd and we print a message saying so.
 * 
 * */

public class OddOrEven {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		// Prompt user to enter a number
		System.out.println("Enter a number: ");
		int num = scan.nextInt();
		scan.close();

		// Check if the number is odd or even
		if (num % 2 == 0) {
			System.out.println(num + " is even.");
		} else {
			System.out.println(num + " is odd.");
		}
	}
}
