import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

// Alistirmalar: en sik kelime (HashMap sayaci), TreeSet ile tekrarsiz
// loto cekilisi, ogrenci basina not listesi tutan TreeMap.
public class Alistirmalar {

	// Alistirmalar (1)
	static String enSikKelime(String[] kelimeler) {
		Map<String, Integer> sayac = new HashMap<>();
		for (String k : kelimeler) {
			sayac.put(k, sayac.getOrDefault(k, 0) + 1);
		}
		String enIyi = null;
		int enFazla = 0;
		for (Map.Entry<String, Integer> g : sayac.entrySet()) {
			if (g.getValue() > enFazla) {
				enFazla = g.getValue();
				enIyi = g.getKey();
			}
		}
		return enIyi;
	}

	// Alistirmalar (2): tekrarlanabilir olsun diye sabit tohum
	static void lotoKumesi() {
		Random r = new Random(42);
		Set<Integer> cekilen = new TreeSet<>();
		while (cekilen.size() < 6) {
			cekilen.add(r.nextInt(49) + 1);  // 1 ... 49
		}
		System.out.println(cekilen);   // [20, 26, 30, 32, 34, 35] (tohum 42)
	}

	// Alistirmalar (3)
	static void notOrtalamalari() {
		Map<String, List<Integer>> notlar = new TreeMap<>();
		notlar.put("Ali", new ArrayList<>());
		notlar.get("Ali").add(80);
		notlar.get("Ali").add(90);
		notlar.put("Banu", new ArrayList<>(Arrays.asList(70)));
		for (Map.Entry<String, List<Integer>> g : notlar.entrySet()) {
			int toplam = 0;
			for (int n : g.getValue()) {
				toplam += n;
			}
			System.out.println(g.getKey() + " ort: " + toplam / g.getValue().size());  // Ali ort: 85  Banu ort: 70
		}
	}

	public static void main(String[] args) {
		String[] kelimeler = {"elma", "armut", "elma", "kiraz", "armut", "elma"};
		System.out.println(enSikKelime(kelimeler));   // elma
		lotoKumesi();
		notOrtalamalari();
	}
}

/* Beklenen cikti:
elma
[20, 26, 30, 32, 34, 35]
Ali ort: 85
Banu ort: 70
*/
