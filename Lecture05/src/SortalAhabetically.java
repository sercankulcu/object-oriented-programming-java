import java.util.Scanner;

public class SortalAhabetically {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    // Prompt the user to enter a line of words
    System.out.print("Enter a line of words: ");
    String line = sc.nextLine();
    sc.close();

    // Split the line into an array of words
    String[] words = line.split("\\s+");

    // Sort the words alphabetically
    for (int i = 0; i < words.length - 1; i++) {
      for (int j = i + 1; j < words.length; j++) {
        if (words[j].compareTo(words[i]) < 0) {
          String temp = words[i];
          words[i] = words[j];
          words[j] = temp;
        }
      }
    }

    // Print the sorted words line by line
    for (String word : words) {
      System.out.println(word);
    }
  }
}
