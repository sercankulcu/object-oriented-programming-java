package random;
import java.util.Random;
import java.util.Scanner;

/*
 * Here is a simple example of a Java program that generates a random number 
 * between 1 and 10 and allows the user to guess the number:
 * 
 * This program uses the java.util.Random class to generate a random number, and 
 * the java.util.Scanner class to read in the user's guess from the command line. 
 * It then compares the guess to the secret number and prints the appropriate 
 * message.
 * */

public class GameOfChance {
	
	public static void main(String[] args) {
		
		// Generate a random number between 1 and 10
		Random rand = new Random();
		int secretNumber = rand.nextInt(10) + 1;

		// Read in user's guess
		Scanner input = new Scanner(System.in);
		System.out.println("Enter your guess (1-10):");
		int guess = input.nextInt();
		input.close();

		// Check if guess is correct
		if (guess == secretNumber) {
			System.out.println("Congratulations! You guessed the correct number!");
		} else {
			System.out.println("Sorry, the correct number was " + secretNumber + ".");
		}
	}
}
