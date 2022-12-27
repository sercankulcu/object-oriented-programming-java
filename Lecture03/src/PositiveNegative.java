import java.util.Scanner;

/*
 * Here is a code snippet that you can use to find whether a given number 
 * is positive or negative:
 * 
 * To use this code, you will need to import the Scanner class from the 
 * java.util package and create a Scanner object to read input from the 
 * console. Then, you can use the nextInt() method to read an integer from 
 * the console and store it in the num variable. Finally, you can use an if-else 
 * statement to determine whether the number is positive, negative, or zero, 
 * and print the appropriate message to the console.
 * 
 * */

public class PositiveNegative {
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a number: ");
		int num = input.nextInt();
		input.close();

		if (num > 0) {
			System.out.println(num + " is a positive number.");
		} else if (num < 0) {
			System.out.println(num + " is a negative number.");
		} else {
			System.out.println(num + " is zero.");
		}
	}
}
