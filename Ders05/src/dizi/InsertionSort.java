package dizi;

public class InsertionSort {
	
	public static void sort(int[] arr) {
    for (int i = 1; i < arr.length; i++) {
    	int tmp = arr[i];
    	int j = i - 1;

      while (j >= 0 && arr[j] > tmp) {
        arr[j + 1] = arr[j];
        j--;
      }
      arr[j + 1] = tmp;
    }
  }
	
	public static void main(String[] args) {
		//Create an array with 10 random elements
		int[] numbers = new int[10];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = (int)(Math.random() * 100);
		}

		InsertionSort.sort(numbers); 
		// Print the sorted array
		for (int i = 0; i < numbers.length; i++) {
			System.out.print(numbers[i] + " ");
		}
		System.out.println();
	}

}
