package Searching;
/*
 * Here is a Java code example that performs a binary search:
 * 
 * */

public class BinarySearcher {
	
  public static int binarySearch(int[] array, int target) {
  	
    // Set the indices for the search range
    int left = 0;
    int right = array.length - 1;
    // Iterate until the search range is reduced to a single element
    while (left <= right) {
      // Find the middle index of the search range
      int middle = (left + right) / 2;
      // Check if the middle element is the target
      if (array[middle] == target) {
        return middle;
      }
      // If the middle element is less than the target, search the right half of the array
      else if (array[middle] < target) {
        left = middle + 1;
      }
      // If the middle element is greater than the target, search the left half of the array
      else {
        right = middle - 1;
      }
    }
    // If the target element is not found, return -1
    return -1;
  }

  public static void main(String[] args) {
    int[] array = {1, 2, 3, 4, 5};
    int target = 3;
    int index = binarySearch(array, target);
    System.out.println(index);
  }
}
