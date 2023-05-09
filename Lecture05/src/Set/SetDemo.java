package Set;
import java.util.HashSet;
import java.util.Set;

/*
 * Here is an example of a Java code that demonstrates the use of the Set interface:
 * 
 * This code creates a Set using the HashSet implementation, which is a class that 
 * implements the Set interface. It then adds several elements to the set, including 
 * a duplicate element. When the set is printed, only the unique elements are included, 
 * as sets do not allow duplicate elements. The output of this code would be: 
 * [Pear, Grape, Orange, Banana, Apple]
 * */

public class SetDemo {
	
  public static void main(String[] args) {
	  
    // Create a Set using the HashSet implementation
    Set<String> set = new HashSet<>();

    // Add elements to the set
    set.add("Apple");
    set.add("Banana");
    set.add("Orange");
    set.add("Grape");
    set.add("Pear");

    // Try to add a duplicate element
    set.add("Orange");

    // Print the set
    System.out.println(set);
  }
}
