package dizi;

public class SelectionSort {

	public static void sort(int[] arr) {
		int len = arr.length;

		for (int i = 0; i < len - 1; i++) {
			int minIndex = i;

			for (int j = i + 1; j < len; j++) {
				if(arr[j] < arr[minIndex])
					minIndex = j;
			}

			int tmp = arr[minIndex];
			arr[minIndex] = arr[i];
			arr[i] = tmp;
		}
	}
	
	public static void main(String[] args) {
		//Create an array with 10 random elements
		int[] numbers = new int[10];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = (int)(Math.random() * 100);
		}

		SelectionSort.sort(numbers); 
		// Print the sorted array
		for (int i = 0; i < numbers.length; i++) {
			System.out.print(numbers[i] + " ");
		}
		System.out.println();
	}

}
