package Searching;
/*
 * 
 * Here is a Java code example that performs a linear search:
 * 
 * */

public class LinearSearcher {
	
  public static int linearSearch(int[] array, int target) {
  	
    // Iterate over the array and return the index of the target element
    for (int i = 0; i < array.length; i++) {
      if (array[i] == target) {
        return i;
      }
    }
    // If the target element is not found, return -1
    return -1;
  }

  public static void main(String[] args) {
    int[] array = {1, 2, 3, 4, 5};
    int target = 3;
    int index = linearSearch(array, target);
    System.out.println(index);
  }
}
