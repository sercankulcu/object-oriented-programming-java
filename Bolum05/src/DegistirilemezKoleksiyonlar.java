import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Degistirilemez koleksiyonlar: List.of / Set.of / Map.of ve
// Collections.unmodifiableList (alttaki listeye bakan salt okunur gorunum).
public class DegistirilemezKoleksiyonlar {

	static void ofMetotlari() {
		List<String> r = List.of("kirmizi", "yesil");
		Set<Integer> asal = Set.of(2, 3, 5);
		Map<String, Integer> puan =
				Map.of("Ali", 90, "Banu", 85);
		System.out.println(r);                  // [kirmizi, yesil]
		System.out.println(puan.get("Banu"));   // 85
		System.out.println(asal.contains(3));   // true
		try {
			r.add("mavi");
		} catch (UnsupportedOperationException e) {
			System.out.println(e);   // java.lang.UnsupportedOperationException
		}
	}

	static void unmodifiableList() {
		List<String> liste = new ArrayList<>();
		liste.add("a");
		List<String> salt =
				Collections.unmodifiableList(liste);
		liste.add("b");
		System.out.println(salt);   // [a, b]
		try {
			salt.add("c");
		} catch (UnsupportedOperationException e) {
			System.out.println(e);   // java.lang.UnsupportedOperationException
		}
	}

	public static void main(String[] args) {
		ofMetotlari();
		unmodifiableList();
	}
}

/* Beklenen cikti:
[kirmizi, yesil]
85
true
java.lang.UnsupportedOperationException
[a, b]
java.lang.UnsupportedOperationException
*/
