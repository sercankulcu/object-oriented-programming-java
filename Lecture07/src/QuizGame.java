import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/*
 * Here is a sample code for a simple game that reads a list of questions and answers 
 * from a text file and asks the player to guess the correct answer. The player has 3 
 * chances to guess the correct answer, and the game keeps track of the number of 
 * correct and incorrect answers. At the end, the game prints out the player's score.
 * 
 * The text file questions.txt should contain a list of questions and answers, with 
 * each question and answer separated by a colon.
 * */

public class QuizGame {
	
    public static void main(String[] args) {
    	
        int correctAnswers = 0;
        int incorrectAnswers = 0;

        // Read the questions and answers from the text file
        try (BufferedReader reader = new BufferedReader(new FileReader("questions.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Split the line into the question and answer
                String[] parts = line.split(":");
                String question = parts[0];
                String answer = parts[1];

                // Ask the player to guess the answer
                Scanner scanner = new Scanner(System.in);
                System.out.println(question);
                for (int i = 0; i < 3; i++) {
                    System.out.print("Enter your guess: ");
                    String guess = scanner.nextLine();
                    if (guess.equalsIgnoreCase(answer)) {
                        System.out.println("Correct!");
                        correctAnswers++;
                        break;
                    } else {
                        System.out.println("Incorrect. Try again.");
                    }
                }
                incorrectAnswers++;
            }
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }

        // Print out the player's score
        System.out.println("You got " + correctAnswers + " correct answers and " + incorrectAnswers + " incorrect answers.");
    }
}
