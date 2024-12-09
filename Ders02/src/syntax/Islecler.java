package syntax;

public class Islecler {

	public static void main(String[] args) {

		int x = 10; // x degiskenine 10 degeri atandi
		int y = 20; // y degiskenine 20 degeri atandi
		int z = 30; // z degiskenine 30 degeri atandi

		// Aritmetik operatorler
		int toplam = x + y; // toplam = 30
		int fark = y - x; // fark = 10
		int carpim = x * y; // carpim = 200
		int bolum = y / x; // bolum = 2
		int kalan = y % x; // kalan = 0

		// Karsilastirma operatorleri
		boolean esitMi = x == y; // esitMi = false
		boolean esitDegilMi = x != y; // esitDegilMi = true
		boolean buyukMu = y > x; // buyukMu = true
		boolean kucukMu = x < y; // kucukMu = true
		boolean buyukVeyaEsitMi = x >= z; // buyukVeyaEsitMi = false
		boolean kucukVeyaEsitMi = x <= y; // kucukVeyaEsitMi = true

		// Mantiksal operatorler
		boolean veSonuc = x < y && y < z; // veSonuc = true
		boolean veyaSonuc = x < y || y > z; // veyaSonuc = true
		boolean degilSonuc = !(x < y); // degilSonuc = false

		// Sonuclari ekrana yazdir
		System.out.println("Toplam: " + toplam);
		System.out.println("Fark: " + fark);
		System.out.println("Carpim: " + carpim);
		System.out.println("Bolum: " + bolum);
		System.out.println("Kalan: " + kalan);
		System.out.println("esitMi: " + esitMi);
		System.out.println("esitDegilMi: " + esitDegilMi);
		System.out.println("buyukMu: " + buyukMu);
		System.out.println("kucukMu: " + kucukMu);
		System.out.println("buyukVeyaEsitMi: " + buyukVeyaEsitMi);
		System.out.println("kucukVeyaEsitMi: " + kucukVeyaEsitMi);
		System.out.println("veSonuc: " + veSonuc);
		System.out.println("veyaSonuc: " + veyaSonuc);
		System.out.println("degilSonuc: " + degilSonuc);

	}
}
