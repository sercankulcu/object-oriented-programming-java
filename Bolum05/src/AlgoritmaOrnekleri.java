import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// Collections algoritmalari: binarySearch ile arama; max, min, frequency;
// copy, reverse, swap ve fill ile kompozisyon.
public class AlgoritmaOrnekleri {

	// Arama Algoritmalari
	static void aramaAlgoritmalari() {
		List<Integer> sayilar = Arrays.asList(1, 3, 5, 7, 9, 11);
		System.out.println(Collections.binarySearch(sayilar, 7));  // 3
		System.out.println(Collections.binarySearch(sayilar, 6));  // -4
		System.out.println(sayilar.indexOf(7));    // 3 (dogrusal arama)
	}

	// Kompozisyon Algoritmalari
	static void kompozisyonAlgoritmalari() {
		List<Integer> n = Arrays.asList(4, 9, 2, 9, 5);
		System.out.println(Collections.max(n));           // 9
		System.out.println(Collections.min(n));           // 2
		System.out.println(Collections.frequency(n, 9));  // 2
	}

	// Kompozisyon: Izleme
	static void kompozisyonIzleme() {
		List<String> isimler =
				Arrays.asList("Ahmet", "Ayse", "Cem");
		List<String> hedef = new ArrayList<>(
				Arrays.asList("X", "Y", "Z", "W"));
		Collections.copy(hedef, isimler);
		System.out.println(hedef);   // [Ahmet, Ayse, Cem, W]
		Collections.reverse(hedef);
		System.out.println(hedef);   // [W, Cem, Ayse, Ahmet]
		Collections.swap(hedef, 0, 2);
		System.out.println(hedef);   // [Ayse, Cem, W, Ahmet]
		Collections.fill(hedef, "Java");
		System.out.println(hedef);   // [Java, Java, Java, Java]
	}

	public static void main(String[] args) {
		aramaAlgoritmalari();
		kompozisyonAlgoritmalari();
		kompozisyonIzleme();
	}
}

/* Beklenen cikti:
3
-4
3
9
2
2
[Ahmet, Ayse, Cem, W]
[W, Cem, Ayse, Ahmet]
[Ayse, Cem, W, Ahmet]
[Java, Java, Java, Java]
*/
