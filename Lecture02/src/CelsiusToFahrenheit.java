import java.util.Scanner;

/*
 * Here is a Java code that converts Celsius to Fahrenheit:
 * 
 * To use this code, you will need to import the Scanner class from the 
 * java.util package. The Scanner class allows you to read input from the console. 
 * The code prompts the user to enter a temperature in Celsius, reads the input 
 * using the nextDouble method of the Scanner class, and stores it in the celsius 
 * variable. Then, the code converts the temperature from Celsius to Fahrenheit 
 * using the formula F = (C * 1.8) + 32 and prints the result to the console.
 * 
 * */

public class CelsiusToFahrenheit {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter a temperature in Celsius: ");
		double celsius = scanner.nextDouble();
		scanner.close();

		// Convert Celsius to Fahrenheit
		double fahrenheit = (celsius * 1.8) + 32;

		System.out.println(celsius + " Celsius is " + fahrenheit + " Fahrenheit");
	}
}
