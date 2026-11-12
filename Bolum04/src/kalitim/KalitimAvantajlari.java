package kalitim;

// Kalitimin avantajlari: GelismisHesapMakinesi, HesapMakinesi'nin metotlarini
// yeniden yazmadan kullanir ve us() ile faktoriyel() ekleyerek genisletir.
public class KalitimAvantajlari {

	public static class HesapMakinesi {
		private double hafiza;   // son sonuc

		public double topla(int a, int b) {
			hafiza = a + b;
			return hafiza;
		}
		public double carp(int a, int b) {
			hafiza = a * b;
			return hafiza;
		}
		public double hafizayiGoruntule() {
			return hafiza;
		}
	}

	public static class GelismisHesapMakinesi
			extends HesapMakinesi {
		// Yeni yetenek: us alma
		public double us(double taban, int us) {
			double sonuc = 1.0;
			for (int i = 0; i < us; i++) {
				sonuc *= taban;
			}
			return sonuc;
		}
		// faktoriyel(int) benzer bicimde eklenir
		public long faktoriyel(int n) {
			long sonuc = 1;
			for (int i = 2; i <= n; i++) {
				sonuc *= i;
			}
			return sonuc;
		}
	}

	public static void main(String[] args) {
		GelismisHesapMakinesi h = new GelismisHesapMakinesi();
		System.out.println(h.topla(5, 3));         // 8.0  (miras)
		System.out.println(h.hafizayiGoruntule()); // 8.0  (miras)
		System.out.println(h.us(2, 5));            // 32.0 (yeni)
		System.out.println(h.carp(4, 6));          // 24.0 (miras)
		System.out.println(h.faktoriyel(5));       // 120  (yeni)
	}
}

/* Beklenen cikti:
8.0
8.0
32.0
24.0
120
*/
