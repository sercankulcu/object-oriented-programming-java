package dizi;
import java.util.Arrays;

public class ThirdLargestFinder {
	
  public static int findThirdLargest(int[] array) {
  	
    // Sort the array in descending order
    Arrays.sort(array);
    // Return the third element (index 2)
    return array[array.length - 3];
  }
  
  public static int findThirdLargestVanilla(int[] array) {
    // Initialize variables to store the three largest numbers
    int firstLargest = Integer.MIN_VALUE;
    int secondLargest = Integer.MIN_VALUE;
    int thirdLargest = Integer.MIN_VALUE;
    // Iterate over the array and update the largest numbers
    for (int element : array) {
      if (element > firstLargest) {
        thirdLargest = secondLargest;
        secondLargest = firstLargest;
        firstLargest = element;
      } else if (element > secondLargest) {
        thirdLargest = secondLargest;
        secondLargest = element;
      } else if (element > thirdLargest) {
        thirdLargest = element;
      }
    }
    // Return the third largest number
    return thirdLargest;
  }

  public static void main(String[] args) {
    int[] array = {1, 12, 13, 4, 5, 6};
    int thirdLargest = findThirdLargest(array);
    System.out.println(thirdLargest);
    
    thirdLargest = findThirdLargestVanilla(array);
    System.out.println(thirdLargest);
  }
}
