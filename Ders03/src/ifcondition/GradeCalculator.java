package ifcondition;
import java.util.Scanner;

/*
 * Here is an example of a Java program that calculates a student's grade based on their score on a test:
 * 
 * This code defines a class called GradeCalculator with a main method that reads in a score from 
 * the user and calculates the corresponding grade. The grade is determined by the score as follows:
 * Scores 90 or above receive an A
 * Scores between 80 and 89 receive a B
 * Scores between 70 and 79 receive a C
 * Scores between 60 and 69 receive a D
 * Scores below 60 receive an F
 * 
 * */

public class GradeCalculator {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    // Prompt the user to enter their score
    System.out.print("Enter your score: ");
    double score = sc.nextDouble();
    sc.close();

    // Calculate the grade
    char grade;
    if (score >= 90) {
      grade = 'A';
    } else if (score >= 80) {
      grade = 'B';
    } else if (score >= 70) {
      grade = 'C';
    } else if (score >= 60) {
      grade = 'D';
    } else {
      grade = 'F';
    }

    // Print the result
    System.out.println("Your grade is: " + grade);
  }
}
