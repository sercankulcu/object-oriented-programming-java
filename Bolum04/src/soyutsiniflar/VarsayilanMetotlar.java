package soyutsiniflar;

// Arayuzde varsayilan (default), static ve private metotlar; iki arayuzden
// gelen ayni default metodun cakismasi ve Arayuz.super.metot() ile cozumu.
public class VarsayilanMetotlar {

	interface Collection {
		void add(Object o);
		void remove(Object o);
		int size();
		default boolean isEmpty() {
			return size() == 0;
		}
	}

	static class Sepet implements Collection {
		private int adet = 0;
		public void add(Object o) { adet++; }
		public void remove(Object o) { adet--; }
		public int size() { return adet; }
		// isEmpty() yazilmadi: default surum kullanilir
	}

	// Varsayilan Metot: Kod Izleme (remove olmadan)
	static class Izleme {
		interface Collection {
			void add(Object o);
			int size();
			default boolean isEmpty() {
				return size() == 0;
			}
		}
		static class Sepet implements Collection {
			private int adet = 0;
			public void add(Object o) { adet++; }
			public int size() { return adet; }
		}
	}

	// static Metotlar
	interface Geometry {
		static double circleArea(double r) { return Math.PI * r * r; }
		static double squareArea(double s) { return s * s; }
		static double perimeter(double s) { return s * 4.0; }
		static double boxVolume(double w, double h, double d) {
			return w * h * d;
		}
	}

	// Default Cakismasi
	interface Selamlayan {
		default void selam() { System.out.println("Merhaba"); }
	}
	interface Karsilayan {
		default void selam() { System.out.println("Hos geldiniz"); }
	}
	static class Gorevli implements Selamlayan, Karsilayan {
		public void selam() {       // gecersiz kilmak zorunlu
			Selamlayan.super.selam();
			Karsilayan.super.selam();
		}
		// selam() yazilmazsa:
		// derleme hatasi: types Selamlayan and Karsilayan are incompatible;
		//   class Gorevli inherits unrelated defaults for selam()
		//   from types Selamlayan and Karsilayan
	}

	// Default Cakismasi: Kod Izleme
	interface Yazici {
		default void calis() { System.out.println("Yazdiriliyor"); }
	}
	interface Tarayici {
		default void calis() { System.out.println("Taraniyor"); }
	}
	static class OfisMakinesi implements Yazici, Tarayici {
		public void calis() {
			Tarayici.super.calis();
			Yazici.super.calis();
			System.out.println("Kopya hazir");
		}
	}

	// Ozel Arayuz Metotlari
	interface Yazdirilabilir {
		String icerik();
		default void yazdir() {
			System.out.println(baslik() + ": " + icerik());
		}
		private String baslik() {   // Java 9+
			return "Belge";
		}
	}
	static class Rapor implements Yazdirilabilir {
		public String icerik() { return "Vize sonuclari"; }
	}

	public static void main(String[] args) {
		Sepet sepet = new Sepet();
		System.out.println(sepet.isEmpty());                       // true
		sepet.add("elma");
		sepet.add("armut");
		System.out.println(sepet.size() + " " + sepet.isEmpty());  // 2 false
		sepet.remove("elma");
		System.out.println(sepet.size());                          // 1

		Izleme.Collection c = new Izleme.Sepet();
		System.out.println(c.isEmpty());   // true
		c.add("elma");
		System.out.println(c.isEmpty());   // false

		System.out.println(Geometry.circleArea(2));       // 12.566370614359172
		System.out.println(Geometry.squareArea(3));       // 9.0
		System.out.println(Geometry.perimeter(2.5));      // 10.0
		System.out.println(Geometry.boxVolume(2, 3, 4));  // 24.0

		new Gorevli().selam();
		// Merhaba
		// Hos geldiniz

		Yazici y = new OfisMakinesi();
		y.calis();
		// Taraniyor
		// Yazdiriliyor
		// Kopya hazir

		new Rapor().yazdir();   // Belge: Vize sonuclari
	}
}

/* Beklenen cikti:
true
2 false
1
true
false
12.566370614359172
9.0
10.0
24.0
Merhaba
Hos geldiniz
Taraniyor
Yazdiriliyor
Kopya hazir
Belge: Vize sonuclari
*/
