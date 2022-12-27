import java.util.HashSet;
import java.util.Set;

/*
 * Here is a Java code example that prints the duplicate elements of an array:
 * 
 * */

public class DuplicateFinderInArray {
	
  public static void findDuplicatesByUsingSet(int[] array) {
  	
    // Create a set to store the unique elements
    Set<Integer> uniqueElements = new HashSet<>();
    // Iterate over the array and add each element to the set
    for (int element : array) {
      if (!uniqueElements.add(element)) {
        // If the element was already in the set, it is a duplicate
        System.out.println(element);
      }
    }
  }
  
  public static void findDuplicates(int[] array) {
    // Create an array to store the counts of the elements
    int[] counts = new int[array.length];
    for (int element : array) {
      counts[element]++;
    }
    // Print the elements that appear more than once
    for (int i = 0; i < counts.length; i++) {
      if (counts[i] > 1) {
        System.out.println(i);
      }
    }
  }

  public static void main(String[] args) {
    int[] array = {1, 2, 3, 1, 2, 3, 3, 3, 4, 5, 5};
    findDuplicatesByUsingSet(array);
    findDuplicates(array);
  }
}
