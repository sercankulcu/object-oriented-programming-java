import java.util.Scanner;

/*
 * Here is a Java program that reads a word and determines whether it has the property described:
 * 
 * If the word is long enough, the program constructs a modified version of the word by moving 
 * the first letter to the end and then reverses it.
 * 
 * banana	dresser	grammar	potato	revive	uneven	assess
 * */

public class WordBackwards {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    // Prompt the user to enter a word
    System.out.print("Enter a word: ");
    String word = sc.next();
    sc.close();

    // Check if the word has the desired property
    boolean hasProperty = false;
    int n = word.length();
    if (n > 1) {
      String modified = word.substring(1) + word.charAt(0);
      String reversed = new StringBuilder(modified).reverse().toString();
      if (word.equals(reversed)) {
        hasProperty = true;
      }
    }

    // Print the result
    if (hasProperty) {
      System.out.println("The word has the desired property.");
    } else {
      System.out.println("The word does not have the desired property.");
    }
  }
}
