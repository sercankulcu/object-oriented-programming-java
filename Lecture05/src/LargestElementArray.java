/*
 * Here is a Java code that demonstrates how to find the largest element of a 
 * given array of integers:
 * 
 * This code first declares and initializes an array of integers. It then 
 * initializes a variable called largest to store the largest element, and 
 * sets it to the first element of the array.
 * */

public class LargestElementArray {
	
  public static void main(String[] args) {
	  
    // Declare and initialize an array of integers
    int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    // Initialize a variable to store the largest element
    int largest = numbers[0];

    // Loop through the array and compare each element to the largest element
    for (int i = 1; i < numbers.length; i++) {
      if (numbers[i] > largest) {
        largest = numbers[i];
      }
    }

    // Print the largest element
    System.out.println("The largest element is: " + largest);
  }
}
