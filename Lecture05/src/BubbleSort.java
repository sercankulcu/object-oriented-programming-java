
public class BubbleSort {

	public static void sort(int[] arr) {
		int lastIndex = arr.length - 1;

		for(int j = 0; j < lastIndex; j++) {
			for(int i = 0; i < lastIndex - j; i++) {
				if(arr[i] > arr[i + 1]) {
					int tmp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = tmp;
				}
			}
		}
	}

	public static void main(String[] args) {
		//Create an array with 10 random elements
		int[] numbers = new int[10];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = (int)(Math.random() * 100);
		}

		BubbleSort.sort(numbers); 
		// Print the sorted array
		for (int i = 0; i < numbers.length; i++) {
			System.out.print(numbers[i] + " ");
		}
		System.out.println();
	}

}
