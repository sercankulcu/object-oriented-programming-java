import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

// Eslemeler: HashMap, TreeMap, LinkedHashMap, Hashtable; Map uzerinde
// gezinme, kelime sayma ve TreeMap aralik metotlari.
public class MapOrnekleri {

	// HashMap Sinifi
	static void hashMapSinifi() {
		HashMap<String, Double> urunFiyatlari = new HashMap<>();
		urunFiyatlari.put("Telefon", 2000.0);
		urunFiyatlari.put("Kulaklik", 350.0);
		urunFiyatlari.put("Kilif", 120.0);
		Double eski = urunFiyatlari.put("Telefon", 1800.0);
		System.out.println(eski);                                  // 2000.0
		System.out.println(urunFiyatlari.get("Telefon"));          // 1800.0
		System.out.println(urunFiyatlari.get("Tablet"));           // null
		System.out.println(urunFiyatlari.containsKey("Kilif"));    // true
		urunFiyatlari.remove("Kilif");
		System.out.println(urunFiyatlari.size());                  // 2

		urunFiyatlari.put(null, 0.0);         // tek null anahtar
		urunFiyatlari.put("Kalem", null);     // null deger
		System.out.println(urunFiyatlari.size());                  // 4
	}

	// Map Uzerinde Gezinme
	static void mapUzerindeGezinme() {
		Map<String, Integer> notlar = new TreeMap<>();
		notlar.put("Cem", 72);
		notlar.put("Ayse", 95);
		notlar.put("Banu", 60);

		for (String isim : notlar.keySet()) {
			System.out.print(isim + " ");
		}
		System.out.println();   // Ayse Banu Cem
		for (Integer not : notlar.values()) {
			System.out.print(not + " ");
		}
		System.out.println();   // 95 60 72
		for (Map.Entry<String, Integer> g : notlar.entrySet()) {
			System.out.println(g.getKey() + " -> " + g.getValue());  // Ayse -> 95  Banu -> 60  Cem -> 72
		}
	}

	// Kelime Sayma: Izleme
	static void kelimeSayma() {
		String metin = "elma armut elma kiraz armut elma";
		Map<String, Integer> sayac = new TreeMap<>();
		for (String k : metin.split(" ")) {
			if (sayac.containsKey(k)) {
				sayac.put(k, sayac.get(k) + 1);
			} else {
				sayac.put(k, 1);
			}
		}
		System.out.println(sayac);   // {armut=2, elma=3, kiraz=1}
	}

	// LinkedHashMap Sinifi
	static void linkedHashMapSinifi() {
		Map<String, String> rehber = new LinkedHashMap<>();
		rehber.put("Zeynep", "555-1111");
		rehber.put("Ahmet", "555-1234");
		rehber.put("Mert", "555-2222");
		Map<String, String> h = new HashMap<>(rehber);
		Map<String, String> t = new TreeMap<>(rehber);
		System.out.println("LinkedHashMap: " + rehber);  // {Zeynep=555-1111, Ahmet=555-1234, Mert=555-2222}
		System.out.println("HashMap:       " + h);       // {Ahmet=555-1234, Mert=555-2222, Zeynep=555-1111}
		System.out.println("TreeMap:       " + t);       // {Ahmet=555-1234, Mert=555-2222, Zeynep=555-1111}
	}

	// Hashtable Sinifi
	static void hashtableSinifi() {
		Hashtable<String, String> telefonRehberi = new Hashtable<>();
		telefonRehberi.put("Ahmet", "555-1234");
		System.out.println(telefonRehberi.get("Ahmet"));        // 555-1234
		System.out.println(telefonRehberi.containsKey("Ayse")); // false
		try {
			telefonRehberi.put(null, "x");  // -> NullPointerException
		} catch (NullPointerException e) {
			System.out.println(e);  // java.lang.NullPointerException: Cannot invoke "Object.hashCode()" because "key" is null
		}
	}

	// TreeMap Ornegi
	static void treeMapOrnegi() {
		TreeMap<String, Double> urunFiyatlari = new TreeMap<>();
		urunFiyatlari.put("Telefon", 2000.0);
		urunFiyatlari.put("Kalem", 15.0);
		urunFiyatlari.put("Defter", 40.0);
		urunFiyatlari.put("Silgi", 5.0);
		System.out.println(urunFiyatlari);                // {Defter=40.0, Kalem=15.0, Silgi=5.0, Telefon=2000.0}
		System.out.println(urunFiyatlari.firstKey());     // Defter
		System.out.println(urunFiyatlari.lastKey());      // Telefon
		System.out.println(urunFiyatlari.headMap("Kalem"));          // {Defter=40.0}
		System.out.println(urunFiyatlari.tailMap("Kalem"));          // {Kalem=15.0, Silgi=5.0, Telefon=2000.0}
		System.out.println(urunFiyatlari.subMap("Defter", "Silgi")); // {Defter=40.0, Kalem=15.0}
	}

	public static void main(String[] args) {
		hashMapSinifi();
		mapUzerindeGezinme();
		kelimeSayma();
		linkedHashMapSinifi();
		hashtableSinifi();
		treeMapOrnegi();
	}
}

/* Beklenen cikti:
2000.0
1800.0
null
true
2
4
Ayse Banu Cem
95 60 72
Ayse -> 95
Banu -> 60
Cem -> 72
{armut=2, elma=3, kiraz=1}
LinkedHashMap: {Zeynep=555-1111, Ahmet=555-1234, Mert=555-2222}
HashMap:       {Ahmet=555-1234, Mert=555-2222, Zeynep=555-1111}
TreeMap:       {Ahmet=555-1234, Mert=555-2222, Zeynep=555-1111}
555-1234
false
java.lang.NullPointerException: Cannot invoke "Object.hashCode()" because "key" is null
{Defter=40.0, Kalem=15.0, Silgi=5.0, Telefon=2000.0}
Defter
Telefon
{Defter=40.0}
{Kalem=15.0, Silgi=5.0, Telefon=2000.0}
{Defter=40.0, Kalem=15.0}
*/
