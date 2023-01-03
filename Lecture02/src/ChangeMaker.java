import java.util.Scanner;

/*
 * Here is a Java program that calculates the minimum number of coins needed to make a given amount of change:
 * 
 * */

public class ChangeMaker {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    // Prompt the user to enter the amount of change
    System.out.print("Enter the amount of change: ");
    double change = sc.nextDouble();
    sc.close();

    // Calculate the number of each type of coin needed
    int numQuarters = (int) (change / 0.25);
    change = change % 0.25;
    int numDimes = (int) (change / 0.1);
    change = change % 0.1;
    int numNickels = (int) (change / 0.05);
    change = change % 0.05;
    int numPennies = (int) (change / 0.01);
    change = change % 0.01;

    // Print the result
    System.out.println("Quarters: " + numQuarters);
    System.out.println("Dimes: " + numDimes);
    System.out.println("Nickels: " + numNickels);
    System.out.println("Pennies: " + numPennies);
  }
}
