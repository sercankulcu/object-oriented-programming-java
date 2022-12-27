/*
 * Here is a sample code in Java that builds a pyramid of * characters 
 * using a nested loop:
 * 
 * You can adjust the height of the pyramid by changing the value of the height 
 * variable. You can also customize the character used to build the pyramid by 
 * replacing the * characters with any other character.
 * 
 * */

public class Pyramid {

	public static void main(String[] args) {

		int height = 5; // height of the pyramid

		// outer loop to handle number of rows
		for (int i = 1; i <= height; i++) {

			// inner loop to handle number of spaces
			for (int j = height - i; j > 0; j--) {
				System.out.print(" ");
			}

			// inner loop to handle number of * characters
			for (int j = 1; j <= i; j++) {
				System.out.print("* ");
			}

			// move to the next line
			System.out.println();
		}
	}
}
