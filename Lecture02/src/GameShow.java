import java.util.Random;
import java.util.Scanner;

/*
 * Here is a Java program that simulates the game show problem:
 * 
 * This code defines a class called GameShow with a main method that randomly selects the 
 * locations of the prizes, randomly selects a door chosen by the contestant, and then determines
 *  whether the contestant would win or lose if sticking with the original choice or switching 
 *  to the remaining door. The program uses a Random object to generate random integers for the 
 *  prize locations and the contestant's choice. The program then uses simple conditional 
 *  statements to determine the outcome of the game for each of the two strategies.
 *  
 *  You have the chance to win $1,000,000 in cash on a game show by choosing one of three doors. 
 *  Behind one door is the grand prize, while the other two doors contain consolation prizes. 
 *  You randomly select a door, but before the prize behind your door is revealed, the game show 
 *  host reveals one of the other doors that contains a consolation prize. The host then gives 
 *  you the option to either stick with your original choice or switch to the remaining door.
 *  
 *  */

public class GameShow {
  public static void main(String[] args) {
    Random rand = new Random();

    // Randomly select locations for the prizes
    int prize1 = rand.nextInt(3) + 1;
    int prize2 = rand.nextInt(3) + 1;
    while (prize2 == prize1) {
      prize2 = rand.nextInt(3) + 1;
    }
    int prize3 = rand.nextInt(3) + 1;
    while (prize3 == prize1 || prize3 == prize2) {
      prize3 = rand.nextInt(3) + 1;
    }

    // Randomly select a door chosen by the contestant
    //int choice = rand.nextInt(3) + 1;
    Scanner sc = new Scanner(System.in);

    // Prompt the user to enter the choice
    System.out.print("Enter the amount of change: ");
    int choice = sc.nextInt();
    sc.close();

    // Determine if the contestant would win or lose if sticking with the original choice
    if (choice == prize1 || choice == prize2 || choice == prize3) {
      System.out.println("You would win if you stick with your original choice.");
    } else {
      System.out.println("You would lose if you stick with your original choice.");
    }

    // Determine the remaining door
    int remainingDoor = 6 - choice - prize1;

    // Determine if the contestant would win or lose if switching to the remaining door
    if (remainingDoor == prize2 || remainingDoor == prize3) {
      System.out.println("You would win if you switch to the remaining door.");
    } else {
      System.out.println("You would lose if you switch to the remaining door.");
    }
  }
}
