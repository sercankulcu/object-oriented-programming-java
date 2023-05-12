package Set;
import java.util.HashSet;

/*
 * Here is an example of a Java code that demonstrates the use of the Set interface:
 * 
 * This code creates a Set using the HashSet implementation, which is a class that 
 * implements the Set interface. It then adds several elements to the set, including 
 * a duplicate element. When the set is printed, only the unique elements are included, 
 * as sets do not allow duplicate elements. The output of this code would be: 
 * [Pear, Grape, Orange, Banana, Apple]
 * */

public class HashSetDemo {

    public static void main(String[] args) {
        // Declare a HashSet of strings
        HashSet<String> mySet = new HashSet<>();

        // Add elements to the HashSet
        mySet.add("Apple");
        mySet.add("Banana");
        mySet.add("Orange");

        // Print the size of the HashSet
        System.out.println("The size of the HashSet is: " + mySet.size());

        // Check if an element is present in the HashSet
        System.out.println("Is 'Apple' present in the HashSet? " + mySet.contains("Apple"));
        
        // Check if an element is present in the HashSet
        System.out.println("Is 'Grape' present in the HashSet? " + mySet.contains("Grape"));

        // Remove an element from the HashSet
        mySet.remove("Banana");

        // Print the HashSet
        System.out.println("The HashSet is now: " + mySet);
    }
}
