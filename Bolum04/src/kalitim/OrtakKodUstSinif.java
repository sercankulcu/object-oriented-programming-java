package kalitim;

// Ortak kodu ust sinifa tasimak: Ogrenci ve Ogretmen'deki ad, yas ve kimlik()
// Kisi sinifina tasinir; alt siniflar yalnizca kendi farkini ekler.
public class OrtakKodUstSinif {

	// Once: ayni alanlar ve ayni metot iki sinifta tekrar ediyor
	static class Once {
		static class Ogrenci {
			private String ad;
			private int yas;
			private double ortalama;
			String kimlik() { return ad + " (" + yas + ")"; }
		}
		static class Ogretmen {
			private String ad;
			private int yas;
			private String brans;
			String kimlik() { return ad + " (" + yas + ")"; }
		}
	}

	// Sonra: ortak kod Kisi'de
	static class Kisi {
		private String ad;
		private int yas;
		Kisi(String ad, int yas) { this.ad = ad; this.yas = yas; }
		String kimlik() { return ad + " (" + yas + ")"; }
	}

	static class Ogrenci extends Kisi {
		private double ortalama;
		Ogrenci(String ad, int yas, double ortalama) {
			super(ad, yas);
			this.ortalama = ortalama;
		}
		@Override String kimlik() {
			return super.kimlik() + ", ort. " + ortalama;
		}
	}   // Ogretmen de ayni bicimde: brans eklenir

	static class Ogretmen extends Kisi {
		private String brans;
		Ogretmen(String ad, int yas, String brans) {
			super(ad, yas);
			this.brans = brans;
		}
		@Override String kimlik() {
			return super.kimlik() + ", " + brans;
		}
	}

	public static void main(String[] args) {
		// eski siniflarin alanlarina deger veren yapici yok
		System.out.println(new Once.Ogrenci().kimlik());    // null (0)
		System.out.println(new Once.Ogretmen().kimlik());   // null (0)

		System.out.println(new Ogrenci("Ece", 20, 3.4).kimlik());       // Ece (20), ort. 3.4
		System.out.println(new Ogretmen("Murat", 41, "Fizik").kimlik()); // Murat (41), Fizik
	}
}

/* Beklenen cikti:
null (0)
null (0)
Ece (20), ort. 3.4
Murat (41), Fizik
*/
