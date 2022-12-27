/*
 * Here is a Java code that demonstrates how to find the largest element of a 
 * given array of filled with random integers:
 * 
 * */

import java.util.Random;

public class LargestElementRandomArray {
	
	public static void main(String[] args) {
		
		// Create an array of integers
		int[] numbers = new int[10];
		// Fill the array with random numbers
		Random rand = new Random();
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = rand.nextInt(100);
		}

		// Initialize the maximum number to the first element of the array
		int max = numbers[0];

		// Iterate through the array and compare each element to the maximum number
		for (int i = 1; i < numbers.length; i++) {
			if (numbers[i] > max) {
				max = numbers[i];
			}
		}

		// Print the largest number
		System.out.println("The largest number in the array is: " + max);
	}
}
