import java.util.ArrayList;

/*
 * Here is a code that demonstrates the use of the ArrayList class in Java:
 * 
 * This code creates an ArrayList of strings called names, adds three names 
 * to the list, and then removes one of them.
 * */

public class ArrayListDemo {
	
  public static void main(String[] args) {
	  
    // Create a new ArrayList of strings
    ArrayList<String> names = new ArrayList<>();
    
    // Add some names to the list
    names.add("Alice");
    names.add("Bob");
    names.add("Charlie");
    
    // Print out the list
    System.out.println("Original list: " + names);
    
    // Remove an element from the list
    names.remove("Bob");
    
    // Print out the updated list
    System.out.println("Updated list: " + names);
  }
}
