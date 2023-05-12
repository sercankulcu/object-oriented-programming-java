package Array;

public class ArraysDemo {

	public static void main(String[] args) {
		// Declare an array of integers
		int[] myArray = new int[]{1, 2, 3};

		// Print the entire array
		for (int i = 0; i < myArray.length; i++) {
			System.out.print(myArray[i] + " ");
		}
		System.out.println();

		// Print the first element of the array
		System.out.println(myArray[0]);

		// Change the value of the second element of the array
		myArray[1] = 4;

		// Print the entire array
		for (int i = 0; i < myArray.length; i++) {
			System.out.print(myArray[i] + " ");
		}
		System.out.println();
	}
}