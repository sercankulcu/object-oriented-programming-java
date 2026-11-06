import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// Iterator ile gezinme; for-each icinde silmenin ConcurrentModificationException
// firlatmasi ve guvenli yollar: Iterator.remove ile removeIf.
public class IteratorOrnekleri {

	// Iterator: Izleme
	static void iteratorIzleme() {
		ArrayList<Integer> liste = new ArrayList<>();
		liste.add(3);
		liste.add(8);
		liste.add(5);
		Iterator<Integer> iterator = liste.iterator();
		while (iterator.hasNext()) {
			Integer sayi = iterator.next();
			// oge burada islenir
			System.out.println(sayi);   // 3  8  5
		}
	}

	// Gezinirken Silme
	static void gezinirkenSilme() {
		List<Integer> sayilar = new ArrayList<>(Arrays.asList(4, 7, 10, 13, 16));
		try {
			for (Integer s : sayilar) {
				if (s % 2 == 0) {
					sayilar.remove(s);
				}
			}
		} catch (java.util.ConcurrentModificationException e) {
			System.out.println(e);   // java.util.ConcurrentModificationException
		}
	}

	// Gezinirken Silme: guvenli yollar
	static void guvenliSilme() {
		List<Integer> sayilar = new ArrayList<>();
		Collections.addAll(sayilar, 4, 7, 10, 13, 16);
		Iterator<Integer> it = sayilar.iterator();
		while (it.hasNext()) {
			if (it.next() % 2 == 0) {
				it.remove();         // guvenli silme
			}
		}
		System.out.println(sayilar);   // [7, 13]

		List<Integer> s2 = new ArrayList<>();
		Collections.addAll(s2, 4, 7, 10, 13, 16);
		s2.removeIf(s -> s % 2 == 0);
		System.out.println(s2);        // [7, 13]
	}

	// ConcurrentModificationException: Kod Izleme
	static void cmeIzleme() {
		List<Integer> s = new ArrayList<>();
		Collections.addAll(s, 6, 9, 12);
		try {
			for (Integer x : s) {      // gizli Iterator
				if (x % 2 == 0) {
					s.remove(x);
				}
			}
			System.out.println(s);
		} catch (java.util.ConcurrentModificationException e) {
			System.out.println(e);   // java.util.ConcurrentModificationException
		}
	}

	public static void main(String[] args) {
		iteratorIzleme();
		gezinirkenSilme();
		guvenliSilme();
		cmeIzleme();
	}
}
