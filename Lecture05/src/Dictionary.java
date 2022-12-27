import java.util.Map;
import java.util.HashMap;

/*
 * In Java, you can use a Map to create a basic dictionary. Here is an example 
 * of how you can use a HashMap to create a dictionary that stores words and 
 * their definitions:
 * 
 * 
 * */

public class Dictionary {
	
  public static void main(String[] args) {
	  
    Map<String, String> dictionary = new HashMap<>();
    
    // Add some entries to the dictionary
    dictionary.put("apple", "a round fruit with a red, yellow, or green skin and a firm white inside");
    dictionary.put("book", "a set of printed sheets of paper bound together inside a cover");
    dictionary.put("desk", "a piece of furniture with a flat top and usually drawers, at which one can read, write, or do other work");
    
    // Get the definition of a word from the dictionary
    String definition = dictionary.get("apple");
    System.out.println("The definition of apple is: " + definition);
    
    // Check if a word is in the dictionary
    if (dictionary.containsKey("dog")) {
      System.out.println("The word 'dog' is in the dictionary.");
    } else {
      System.out.println("The word 'dog' is not in the dictionary.");
    }
    
    dictionary.put("apple", "a fruit that is typically round, red or green in color, and has a skin and a core containing seeds");
    
    definition = dictionary.get("apple");
    System.out.println("The definition of apple is: " + definition);
  }
}
