package LinkedList;
import java.util.LinkedList;

/*
 * Here is a code sample that demonstrates how to use a LinkedList in Java:
 * 
 * This code creates a new LinkedList of type String, adds three elements to 
 * the list, accesses and prints the first element, removes the second element, 
 * and then iterates over the list and prints each remaining element.
 * */

public class LinkedListExample {
	
  public static void main(String[] args) {
	  
    // Create a new LinkedList
    LinkedList<String> list = new LinkedList<>();
    
    // Add elements to the list
    list.add("Item 1");
    list.add("Item 2");
    list.add("Item 3");
    
    // Access and print an element in the list
    String firstItem = list.get(0);
    System.out.println("First item: " + firstItem);
    
    // Remove an element from the list
    list.remove(1);
    
    // Iterate over the list and print each element
    for (String item : list) {
      System.out.println(item);
    }
  }
}
