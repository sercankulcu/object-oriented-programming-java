import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

// ArrayIndexOutOfBoundsException ve akrabalari: dizi, ArrayList, Vector,
// Arrays.asList ve String.charAt ile sinir disina cikmak.
public class SinirAsimiOrnekleri {
	public static void main(String[] args) {
		// ArrayIndexOutOfBoundsException: dogru dongu
		int[] numbers = {1, 2, 3};
		for (int i = 0; i < numbers.length; i++) {
			System.out.print(numbers[i] + " ");
		}
		System.out.println();   // 1 2 3

		// Sinir Asimi Ornekleri: her satir ayri try icinde
		int value;
		String svalue;
		try {
			value = numbers[5];
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e);   // java.lang.ArrayIndexOutOfBoundsException: Index 5 out of bounds for length 3
		}
		ArrayList<String> list = new ArrayList<>();
		try {
			svalue = list.get(5);
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e);   // java.lang.IndexOutOfBoundsException: Index 5 out of bounds for length 0
		}
		Vector<Integer> vector = new Vector<>();
		try {
			value = vector.get(10);
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e);   // java.lang.ArrayIndexOutOfBoundsException: Array index out of range: 10
		}
		String[] names = {"Alice", "Bob", "Charlie"};
		try {
			svalue = Arrays.asList(names).get(5);
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e);   // java.lang.ArrayIndexOutOfBoundsException: Index 5 out of bounds for length 3
		}
		String str = "Hello";
		try {
			char ch = str.charAt(10);
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e);   // java.lang.StringIndexOutOfBoundsException: Index 10 out of bounds for length 5
		}
	}
}
