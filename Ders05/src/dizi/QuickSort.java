package dizi;

public class QuickSort {

	public static void sort(int[] arr, int left, int right) {

		int pivotIndex = left + (right - left) / 2;
		int pivotValue = arr[pivotIndex];
		int i = left;
		int j = right;
		while (i <= j) {
			while (arr[i] < pivotValue) {
				i++;
			}
			while (arr[j] > pivotValue) {
				j--;
			}
			if (i <= j) {
				int tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
				i++;
				j--;
			}
			if (left < i) {
				sort(arr, left, j);
			}
			if (right > i) {
				sort(arr, i, right);
			}
		}
	}

	public static void main(String[] args) {
		//Create an array with 10 random elements
		int[] numbers = new int[10];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = (int)(Math.random() * 100);
		}

		QuickSort.sort(numbers, 0, numbers.length - 1); 
		// Print the sorted array
		for (int i = 0; i < numbers.length; i++) {
			System.out.print(numbers[i] + " ");
		}
		System.out.println();
	}

}
