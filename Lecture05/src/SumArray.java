/*
 * Here is a Java code that demonstrates how to find the sum of elements of a 
 * given array of integers:
 * 
 * The code then iterates over the array using a for-each loop and adds each 
 * element to the sum variable. Finally, it prints the value of sum. 
 * */

public class SumArray {
	
	public static void main(String[] args) {
		
		// Declare and initialize an array of integers
		int[] numbers = {1, 2, 3, 4, 5};

		// Initialize a variable to hold the sum
		int sum = 0;

		// Iterate over the array and sum up the elements
		for (int number : numbers) {
			sum += number;
		}

		// Print the sum
		System.out.println("The sum of the elements of the array is: " + sum);
	}
}
