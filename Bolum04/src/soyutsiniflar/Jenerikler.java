package soyutsiniflar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Jenerikler: tip parametresi donusumu ve calisma zamani hatasini derleme
// zamanina tasir. Jenerik metot, sinirli tip, joker tipler ve tip silme.
public class Jenerikler {

	// Neden Jenerikler?
	static class KutuObj {
		private Object icerik;
		void koy(Object o) { icerik = o; }
		Object al() { return icerik; }
	}

	static class Kutu<T> {                    // T: tip parametresi
		private T icerik;
		void koy(T x) { icerik = x; }
		T al() { return icerik; }
		// T yeni() { return new T(); }   derlenmez
	}

	static <T> void yazdir(T oge) {    // jenerik metot
		System.out.println("Oge: " + oge);
	}

	// Sinirli Tip Parametresi
	static <T extends Number> double ikiKati(T x) {
		return x.doubleValue() * 2;   // Number'in metodu
	}

	static <T extends Comparable<T>> T enBuyuk(T[] dizi) {
		T eb = dizi[0];
		for (int i = 1; i < dizi.length; i++) {
			if (dizi[i].compareTo(eb) > 0) {
				eb = dizi[i];
			}
		}
		return eb;
	}

	// Joker Tipler ve Degismezlik
	static double topla(List<? extends Number> liste) {
		double t = 0;
		for (Number n : liste) t += n.doubleValue();  // okuma
		return t;
	}

	static void doldur(List<? super Integer> liste) {
		liste.add(1);                                 // yazma
		liste.add(2);
	}

	public static void main(String[] args) {
		{
			KutuObj k = new KutuObj();
			k.koy("Merhaba");
			String s = (String) k.al(); // donusum sart
			System.out.println(s);      // Merhaba
			k.koy(42);                  // itiraz yok
			try {
				String t = (String) k.al(); // calisirken hata
				System.out.println(t);
			} catch (ClassCastException e) {
				System.out.println("java.lang.ClassCastException");   // java.lang.ClassCastException
			}
		}
		{
			Kutu<String> k = new Kutu<>();
			k.koy("Merhaba");
			String s = k.al();          // donusum yok
			System.out.println(s);      // Merhaba
			// k.koy(42);                  // derlenmez
			// derleme hatasi: incompatible types:
			//   int cannot be converted to String
		}

		// Jenerik Sinif ve Jenerik Metot
		Kutu<String> k1 = new Kutu<>();
		k1.koy("Merhaba");
		Kutu<Integer> k2 = new Kutu<>();
		k2.koy(42);
		int n = k2.al() + 1;               // kutudan cikarma
		System.out.println(k1.al() + " " + n);   // Merhaba 43
		yazdir(3.14);                      // Oge: 3.14
		yazdir('A');                       // Oge: A

		// Sinirli Tip Parametresi
		System.out.println(ikiKati(21));    // 42.0   (T = Integer)
		System.out.println(ikiKati(1.5));   // 3.0    (T = Double)
		// System.out.println(ikiKati("on")); // derlenmez
		// derleme hatasi: method ikiKati in class Main cannot be
		//   applied to given types; ... inference variable T
		//   has incompatible bounds (upper: Number, lower: String)

		// Sinirli Jenerik Metot: Kod Izleme
		Integer[] sayilar = {7, 12, 5};
		String[] adlar = {"elma", "kiraz", "armut"};
		System.out.println(enBuyuk(sayilar));   // 12
		System.out.println(enBuyuk(adlar));     // kiraz

		// Joker Tipler ve Degismezlik
		List<Integer> tamlar = Arrays.asList(1, 2, 3);
		List<Number> sayiListesi = new ArrayList<>();
		doldur(sayiListesi);
		sayiListesi.add(2.5);
		System.out.println(topla(tamlar) + " " + sayiListesi);   // 6.0 [1, 2, 2.5]
		// List<Number> x = tamlar;   derlenmez

		// Tip Silme
		Kutu<String> a = new Kutu<>();
		Kutu<Integer> b = new Kutu<>();
		System.out.println(a.getClass() == b.getClass());   // true
		System.out.println(a.getClass().getName());
		// soyutsiniflar.Jenerikler$Kutu   (sunumda: Kutu; paket ve dis sinif adi eklenir)
	}
}

/* Beklenen cikti:
Merhaba
java.lang.ClassCastException
Merhaba
Merhaba 43
Oge: 3.14
Oge: A
42.0
3.0
12
kiraz
6.0 [1, 2, 2.5]
true
soyutsiniflar.Jenerikler$Kutu
*/
