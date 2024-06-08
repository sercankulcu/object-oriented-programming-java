import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
 * Here is a sample code that demonstrates reading from a file and performing operations 
 * based on the data in the file:
 * 
 * This code reads lines from the "operations.txt" file, splits the line into tokens 
 * separated by spaces, and performs the operation specified by the operator. The 
 * result is then printed to the console.
 * */

public class Calculator {

	public static void main(String[] args) {

		try {
			BufferedReader reader = new BufferedReader(new FileReader("operations.txt"));
			String line;
			while ((line = reader.readLine()) != null) {
				String[] tokens = line.split(" ");
				int num1 = Integer.parseInt(tokens[0]);
				int num2 = Integer.parseInt(tokens[2]);
				char operator = tokens[1].charAt(0);
				int result = 0;
				switch (operator) {
				case '+':
					result = num1 + num2;
					break;
				case '-':
					result = num1 - num2;
					break;
				case '*':
					result = num1 * num2;
					break;
				case '/':
					result = num1 / num2;
					break;
				default:
					result = 0;
					break;
				}
				System.out.println(num1 + " " + operator + " " + num2 + " = " + result);
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("Error reading from file: " + e.getMessage());
		} catch (NumberFormatException e) {
			System.out.println("Error parsing numbers: " + e.getMessage());
		}
	}
}
