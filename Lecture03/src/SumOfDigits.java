import java.util.Scanner;

/*
 * Here is a Java code that finds the sum of digits of a number:
 * 
 * This code first prompts the user to enter a number, then it uses a while loop 
 * to iterate over the digits of the number. For each iteration, it extracts the 
 * last digit of the number using the modulus operator (%), adds it to the sum 
 * variable, and then removes it from the number by dividing the number by 10 
 * using integer division (/). This process continues until the number becomes 0, 
 * at which point the loop stops and the final value of sum is printed 
 * to the console.
 * */

public class SumOfDigits {
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a number: ");
		int number = input.nextInt();
		input.close();
		int sum = 0;

		while (number > 0) {
			int digit = number % 10;
			sum += digit;
			number /= 10;
		}

		System.out.println("Sum of digits: " + sum);
	}
}
