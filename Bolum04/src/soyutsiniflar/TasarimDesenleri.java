package soyutsiniflar;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

// Tasarim desenleri: Singleton (tek nesne), Fabrika, Gozlemci, Strateji ve MVC.
// Hepsi arayuz ve cok bicimlilik uzerine kuruludur.
public class TasarimDesenleri {

	// Singleton (Tek Nesne)
	public static final class Ayarlar {
		private static final Ayarlar TEK = new Ayarlar();
		private Ayarlar() {
			System.out.println("Ayarlar olusturuldu");
		}
		public static Ayarlar getInstance() { return TEK; }
	}

	// Fabrika (Factory)
	interface Sekil { double alan(); }

	static class Kare implements Sekil {      // alan: a * a
		private double a;
		Kare(double a) { this.a = a; }
		public double alan() { return a * a; }
	}

	static class Daire implements Sekil {     // alan: pi r^2
		private double r;
		Daire(double r) { this.r = r; }
		public double alan() { return Math.PI * r * r; }
	}

	static class SekilFabrikasi {
		static Sekil olustur(String tur, double olcu) {
			switch (tur.toLowerCase(Locale.ROOT)) {
				case "kare":  return new Kare(olcu);
				case "daire": return new Daire(olcu);
				default:      return null;  // bilinmeyen tur
			}
		}
	}

	// Observer (Gozlemci)
	interface Gozlemci { void guncelle(int derece); }

	static class Istasyon {
		private final List<Gozlemci> liste = new ArrayList<>();
		void ekle(Gozlemci g) { liste.add(g); }
		void setSicaklik(int d) {
			for (Gozlemci g : liste) g.guncelle(d);
		}
	}

	// Strategy (Strateji)
	interface Indirim { double uygula(double tutar); }

	static class OgrenciIndirimi implements Indirim {
		public double uygula(double tutar) { return tutar * 0.90; }
	}

	static class Kasa {
		private final Indirim strateji;
		Kasa(Indirim strateji) { this.strateji = strateji; }
		double odenecek(double tutar) {
			return strateji.uygula(tutar);
		}
	}

	// MVC (Model-Gorunum-Denetleyici)
	static class Ogrenci {                // model
		private final String ad;
		Ogrenci(String ad) { this.ad = ad; }
		String getAd() { return ad; }
	}

	static class OgrenciGorunum {         // gorunum
		void goster(String ad) {
			System.out.println("Ogrenci: " + ad);
		}
	}

	static class OgrenciDenetleyici {     // denetleyici
		private final Ogrenci model;
		private final OgrenciGorunum gorunum;
		OgrenciDenetleyici(Ogrenci model, OgrenciGorunum gorunum) {
			this.model = model;
			this.gorunum = gorunum;
		}
		void guncelle() {
			gorunum.goster(model.getAd());
		}
	}

	public static void main(String[] args) {
		// Singleton: nesne ilk getInstance() cagrisinda olusur
		System.out.println("main basladi");
		Ayarlar a = Ayarlar.getInstance();
		Ayarlar b = Ayarlar.getInstance();
		System.out.println(a == b);
		// main basladi
		// Ayarlar olusturuldu
		// true

		// Fabrika
		Sekil s = SekilFabrikasi.olustur("Kare", 3);
		System.out.println(s.alan());   // 9.0
		Sekil u = SekilFabrikasi.olustur("ucgen", 2);
		System.out.println(u == null);   // true

		// Gozlemci Deseni: Kod Izleme
		Istasyon ist = new Istasyon();
		ist.ekle(d -> System.out.println("Ekran: " + d + " \u00B0C"));
		ist.ekle(d -> { if (d > 30) System.out.println("Uyari: sicak!"); });
		ist.setSicaklik(25);
		ist.setSicaklik(34);
		// Ekran: 25 derece C
		// Ekran: 34 derece C
		// Uyari: sicak!

		// Strateji
		Kasa k = new Kasa(new OgrenciIndirimi());
		System.out.println(k.odenecek(250));   // 225.0

		// Strateji Deseni: Kod Izleme
		Kasa ogrenci = new Kasa(t -> t * 0.90);
		Kasa kampanya = new Kasa(t -> t >= 200 ? t - 50 : t);
		System.out.println(ogrenci.odenecek(250));    // 225.0
		System.out.println(kampanya.odenecek(250));   // 200.0
		System.out.println(kampanya.odenecek(120));   // 120.0
		// sabit strateji: Kasa tek basina denenir
		System.out.println(new Kasa(t -> 7).odenecek(100));   // 7.0

		// MVC
		Ogrenci m = new Ogrenci("Ayse");
		OgrenciGorunum g = new OgrenciGorunum();
		OgrenciDenetleyici d =
			new OgrenciDenetleyici(m, g);
		d.guncelle();  // Ogrenci: Ayse   (g.goster(m.getAd()))
	}
}

/* Beklenen cikti:
main basladi
Ayarlar olusturuldu
true
9.0
true
Ekran: 25 °C
Ekran: 34 °C
Uyari: sicak!
225.0
225.0
200.0
120.0
7.0
Ogrenci: Ayse
*/
