import java.text.Collator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

// Koleksiyonlarda sik yapilan hatalar: ilkel tip parametresi, remove(int)
// ile remove(Object), Integer'i == ile karsilastirma, sabit boyutlu liste,
// Map'te for-each, indeks tasmasi ve Turkce harflerle siralama.
public class SikYapilanHatalar {

	// Sik Yapilan Hatalar (1)
	static void hatalar1() {
		// List<int> notlar = new ArrayList<>();
		// derleme hatasi: unexpected type; required: reference, found: int
		List<Integer> notlar = new ArrayList<>();   // duzeltme: sarmalayici tip
		notlar.add(90);
		System.out.println(notlar);   // [90]

		List<String> isimler = new ArrayList<>();
		// isimler.add(42);
		// derleme hatasi: incompatible types: int cannot be converted to String
		isimler.add("42");            // duzeltme: String ekle
		System.out.println(isimler);  // [42]
	}

	// Sik Yapilan Hatalar (2)
	static void hatalar2() {
		List<Integer> liste = new ArrayList<>();
		Collections.addAll(liste, 10, 20, 30);
		liste.remove(1);                   // indeks 1
		System.out.println(liste);         // [10, 30]
		liste.remove(Integer.valueOf(10)); // deger 10
		System.out.println(liste);         // [30]

		List<Integer> a = new ArrayList<>();
		Collections.addAll(a, 1000, 1000);
		System.out.println(a.get(0) == a.get(1));       // false
		System.out.println(a.get(0).equals(a.get(1)));  // true
	}

	// Sik Yapilan Hatalar (3)
	static void hatalar3() {
		List<Integer> sabit = Arrays.asList(1, 2, 3);
		try {
			sabit.add(4);
		} catch (UnsupportedOperationException e) {
			System.out.println(e);   // java.lang.UnsupportedOperationException
		}

		Map<String, Integer> m = new HashMap<>();
		m.put("x", 1);
		// for (String s : m) {
		// derleme hatasi: for-each not applicable to expression type
		//   required: array or java.lang.Iterable, found: Map<String,Integer>
		for (String s : m.keySet()) {   // duzeltme: keySet() uzerinde gez
			System.out.println(s);       // x
		}
	}

	// Sik Yapilan Hatalar (4)
	static void hatalar4() {
		List<String> l = new ArrayList<>();
		Collections.addAll(l, "a", "b", "c");
		try {
			System.out.println(l.get(3));
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e);   // java.lang.IndexOutOfBoundsException: Index 3 out of bounds for length 3
		}

		// Turkce harfli adlar unicode kacisiyla yazildi: Cagla ve Omer
		List<String> adlar = new ArrayList<>();
		Collections.addAll(adlar,
				"Zeynep", "\u00c7a\u011fla", "Can", "\u00d6mer");
		Collections.sort(adlar);
		System.out.println(adlar);   // [Can, Zeynep, Cagla, Omer] (Turkce harfle baslayanlar sona)
		Locale tr = Locale.forLanguageTag("tr-TR");
		Collections.sort(adlar, Collator.getInstance(tr));
		System.out.println(adlar);   // [Can, Cagla, Omer, Zeynep]
	}

	public static void main(String[] args) {
		hatalar1();
		hatalar2();
		hatalar3();
		hatalar4();
	}
}

/* Beklenen cikti:
[90]
[42]
[10, 30]
[30]
false
true
java.lang.UnsupportedOperationException
x
java.lang.IndexOutOfBoundsException: Index 3 out of bounds for length 3
[Can, Zeynep, Çağla, Ömer]
[Can, Çağla, Ömer, Zeynep]
*/
