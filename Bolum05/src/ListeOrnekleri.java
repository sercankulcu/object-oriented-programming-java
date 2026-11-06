import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.Vector;

// List uygulamalari: ArrayList, LinkedList, Vector ve Stack;
// ortaya ekleme/silme ve listede gezinmenin uc yolu.
public class ListeOrnekleri {

	// ArrayList Sinifi
	static void arrayListSinifi() {
		ArrayList<String> meyveler = new ArrayList<>();
		meyveler.add("Elma");
		meyveler.add("Armut");
		System.out.println(meyveler.get(1));  // Armut
	}

	// ArrayList Metotlari: Izleme
	static void arrayListMetotlari() {
		ArrayList<String> isimler = new ArrayList<>();
		isimler.add("Ali");
		isimler.add("Banu");
		isimler.add("Cem");
		isimler.add("Deniz");
		isimler.add("Ece");
		System.out.println(isimler);  // [Ali, Banu, Cem, Deniz, Ece]
		isimler.set(3, "Can");       // 3. indeksi degistir
		System.out.println(isimler);  // [Ali, Banu, Cem, Can, Ece]
		isimler.remove(4);           // 4. indeksi sil
		System.out.println(isimler);  // [Ali, Banu, Cem, Can]
		isimler.add(2, "Fatma");     // 2. indekse ekle
		System.out.println(isimler);  // [Ali, Banu, Fatma, Cem, Can]
		int indeks = isimler.indexOf("Banu");
		System.out.println("indeks: " + indeks);           // indeks: 1
		boolean varMi = isimler.contains("Ece");
		System.out.println("Ece var mi: " + varMi);         // Ece var mi: false
		System.out.println("boyut: " + isimler.size());     // boyut: 5
	}

	// Ortaya Ekleme ve Silme
	static void ortayaEkleme() {
		List<Integer> liste2 = new ArrayList<>(Arrays.asList(10, 20, 30, 40));
		liste2.add(1, 15);      // araya ekle: 20, 30, 40 saga kayar
		System.out.println(liste2);   // [10, 15, 20, 30, 40]
		liste2.remove(0);       // bastan sil: hepsi sola kayar
		System.out.println(liste2);   // [15, 20, 30, 40]
	}

	// LinkedList Ornegi ve LinkedList: Kod Izleme (ayni kod)
	static void linkedListOrnegi() {
		LinkedList<String> meyveler = new LinkedList<>();
		meyveler.add("Elma");
		meyveler.add("Armut");
		meyveler.addFirst("Kiraz");   // basa ekle
		meyveler.addLast("Muz");      // sona ekle
		System.out.println(meyveler);             // [Kiraz, Elma, Armut, Muz]
		System.out.println(meyveler.getFirst());  // Kiraz
		System.out.println(meyveler.getLast());   // Muz
		meyveler.removeFirst();
		System.out.println(meyveler);             // [Elma, Armut, Muz]
	}

	// Vector Sinifi
	static void vectorSinifi() {
		Vector<Integer> v = new Vector<>();   // kapasite: 10
		for (int i = 1; i <= 11; i++) {
			v.addElement(i * 10);
		}
		System.out.println(v.size() + " / " + v.capacity());  // 11 / 20
		System.out.println(v.elementAt(0));                     // 10
		v.removeElement(110);    // degeri 110 olan oge
		System.out.println(v.size() + " / " + v.capacity());  // 10 / 20
	}

	// Stack: Izleme
	static void stackIzleme() {
		Stack<String> yigin = new Stack<>();
		yigin.push("A");
		yigin.push("B");
		yigin.push("C");
		System.out.println(yigin);              // [A, B, C]
		System.out.println(yigin.peek());       // C
		System.out.println(yigin.pop());        // C
		System.out.println(yigin.search("A"));  // 2
		System.out.println(yigin.empty());      // false
	}

	// Listede Gezinme
	static void listedeGezinme() {
		List<String> dersler = new ArrayList<>(
				Arrays.asList("Fizik", "Java", "Devre"));
		// 1) Indeksli for
		for (int i = 0; i < dersler.size(); i++) {
			System.out.print(dersler.get(i) + " ");
		}
		System.out.println();   // Fizik Java Devre
		// 2) Gelismis for (for-each)
		for (String d : dersler) {
			System.out.print(d + " ");
		}
		System.out.println();   // Fizik Java Devre
		// 3) forEach + lambda (Java 8+)
		dersler.forEach(d -> System.out.print(d + " "));
		System.out.println();   // Fizik Java Devre
	}

	public static void main(String[] args) {
		arrayListSinifi();
		arrayListMetotlari();
		ortayaEkleme();
		linkedListOrnegi();
		vectorSinifi();
		stackIzleme();
		listedeGezinme();
	}
}
