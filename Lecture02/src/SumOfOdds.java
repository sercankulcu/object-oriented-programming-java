import java.util.Scanner;

/*
 * Here is a Java program that calculates the sum of the first n positive odd integers:
 * 
 * This code defines a class called SumOfOdds with a main method that reads in the value of n 
 * from the user, calculates the sum of the first n positive odd integers using a for loop, and 
 * then prints the result to the console. 
 * */

public class SumOfOdds {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    // Prompt the user to enter the value of n
    System.out.print("Enter the value of n: ");
    int n = sc.nextInt();
    sc.close();

    // Calculate the sum of the first n positive odd integers
    int sum = 0;
    for (int i = 1; i <= n; i++) {
      sum += 2 * i - 1;
    }

    // Print the result
    System.out.println("The sum of the first " + n + " positive odd integers is: " + sum);
  }
}
