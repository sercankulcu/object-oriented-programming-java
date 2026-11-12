import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

// Collection arayuzunun temel metotlari: size, contains, remove,
// containsAll, toArray, clear, isEmpty.
public class CollectionMetotlari {

	public static void main(String[] args) {
		Collection<String> renkler = new ArrayList<>();
		renkler.add("kirmizi");
		renkler.add("yesil");
		renkler.add("mavi");
		System.out.println(renkler.size());              // 3
		System.out.println(renkler.contains("yesil"));   // true
		renkler.remove("yesil");
		System.out.println(renkler);                     // [kirmizi, mavi]
		Collection<String> aranan = Arrays.asList("mavi", "kirmizi");
		System.out.println(renkler.containsAll(aranan)); // true
		Object[] dizi = renkler.toArray();
		System.out.println(dizi.length);                 // 2
		renkler.clear();
		System.out.println(renkler.isEmpty());           // true
	}
}

/* Beklenen cikti:
3
true
[kirmizi, mavi]
true
2
true
*/
