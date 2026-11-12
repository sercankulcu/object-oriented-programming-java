import java.util.ArrayList;
import java.util.List;

// Ornek problem: Fibonacci sayilarini bir listede biriktirerek
// n. terimi bulmak.
public class Fibonacci {
	public static int fibonacci(int sayi) {
		List<Integer> liste = new ArrayList<>();
		liste.add(0);
		liste.add(1);
		for (int i = 2; i < sayi + 1; i++) {
			liste.add(liste.get(i - 2) + liste.get(i - 1));
		}
		return liste.get(sayi);
	}
	public static void main(String[] args) {
		int sonuc = fibonacci(10);
		System.out.println(sonuc);   // 55
	}
}

/* Beklenen cikti:
55
*/
