import java.util.ArrayList;

/*
 * here is another simple Java program that demonstrates how to use an array list to store and 
 * manipulate a list of data:
 * 
 * This program creates an ArrayList of strings and adds some names to it. It then demonstrates 
 * some common operations that can be performed on an ArrayList, such as adding, modifying, and 
 * removing elements, as well as getting the index of an element and checking if the list 
 * contains a particular element. Finally, it prints out the size of the list.
 * 
 * */

public class ArrayListExample {
  public static void main(String[] args) {
    ArrayList<String> names = new ArrayList<>();
    
    names.add("Alice");
    names.add("Bob");
    names.add("Charlie");
    names.add("Dave");
    names.add("Eve");
    
    System.out.println("Original list: " + names);
    
    names.set(3, "Carol"); // Replace "Dave" with "Carol"
    System.out.println("Modified list: " + names);
    
    names.remove(4); // Remove "Eve"
    System.out.println("Modified list: " + names);
    
    names.add(2, "Frank"); // Insert "Frank" at index 2
    System.out.println("Modified list: " + names);
    
    int index = names.indexOf("Bob"); // Get the index of "Bob"
    System.out.println("Index of Bob: " + index);
    
    boolean contains = names.contains("Eve"); // Check if the list contains "Eve"
    System.out.println("List contains Eve: " + contains);
    
    int size = names.size(); // Get the size of the list
    System.out.println("Size of the list: " + size);
  }
}
