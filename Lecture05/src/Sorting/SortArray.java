package Sorting;
/*
 * Here is a code snippet that demonstrates how to sort an array from smallest 
 * to largest 
 * 
 * This code uses a nested loop to compare each element in the array to the rest 
 * of the elements. If the current element is larger than another element, they 
 * are swapped. This process is repeated until the entire array is sorted.
 * */

public class SortArray {

	public static void main(String[] args) {

		// Create an array with 10 random elements
		int[] numbers = new int[10];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = (int)(Math.random() * 100);
		}

		// Sort the array from smallest to largest
		for (int i = 0; i < numbers.length; i++) {
			for (int j = i + 1; j < numbers.length; j++) {
				if (numbers[i] > numbers[j]) {
					int temp = numbers[i];
					numbers[i] = numbers[j];
					numbers[j] = temp;
				}
			}
		}
		// Print the sorted array
		for (int i = 0; i < numbers.length; i++) {
			System.out.print(numbers[i] + " ");
		}
		System.out.println();
	}
}
