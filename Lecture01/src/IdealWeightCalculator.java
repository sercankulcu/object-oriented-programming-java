import java.util.Scanner;

/*
 * Here is some code for a simple Ideal Weight Calculator in Java: uses the International System 
 * of Units (SI) units of meters and kilograms:
 * 
 * This code prompts the user to enter their height in meters, and then calculates their ideal 
 * weight based on the following formula:
 * */

public class IdealWeightCalculator {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    // Prompt the user to enter their height in meters
    System.out.print("Enter your height in meters: ");
    double height = scanner.nextDouble();
    scanner.close();

    // Calculate the ideal weight based on the user's height
    double idealWeight = 0;
    if (height > 1.5) {
      idealWeight = (height - 1.5) * 90 + 50;
    } else {
      idealWeight = 50;
    }

    // Print the ideal weight
    System.out.println("Your ideal weight is: " + idealWeight + " kilograms");
  }
}
