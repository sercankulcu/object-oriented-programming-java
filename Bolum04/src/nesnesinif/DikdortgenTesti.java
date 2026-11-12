package nesnesinif;

// Dikdortgen sinifi: yapici ve alan/cevre hesaplayan metotlar;
// iki nesne ayni metotlarla farkli sonuc verir.
public class DikdortgenTesti {

	static class Dikdortgen {
		private double uzunluk;     // dikdortgenin uzunlugu
		private double genislik;    // dikdortgenin genisligi

		// Yapici metot
		public Dikdortgen(double uzunluk, double genislik) {
			this.uzunluk = uzunluk;
			this.genislik = genislik;
		}

		public double alanHesapla() {      // alani hesaplar
			return uzunluk * genislik;
		}

		public double cevreHesapla() {     // cevreyi hesaplar
			return 2 * (uzunluk + genislik);
		}
	}

	public static void main(String[] args) {
		Dikdortgen dikdortgen = new Dikdortgen(5.0, 3.0);
		Dikdortgen kare = new Dikdortgen(5.0, 5.0);
		double alan = dikdortgen.alanHesapla();
		double cevre = dikdortgen.cevreHesapla();
		System.out.println("Alani: " + alan
				+ " Cevresi: " + cevre);   // Alani: 15.0 Cevresi: 16.0
		alan = kare.alanHesapla();
		cevre = kare.cevreHesapla();
		System.out.println("Alani: " + alan
				+ " Cevresi: " + cevre);   // Alani: 25.0 Cevresi: 20.0
	}
}

/* Beklenen cikti:
Alani: 15.0 Cevresi: 16.0
Alani: 25.0 Cevresi: 20.0
*/
