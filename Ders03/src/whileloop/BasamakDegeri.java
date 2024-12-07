package whileloop;

public class BasamakDegeri {

	public static void main(String[] args) {
		
		basamaklariYazdir();
		
		System.out.println("Basamak Sayisi: " + basamakSayisi(345987));
		
		System.out.println("Rakamlar Toplami: " + rakamlarToplami(24653));
		
	}
	
	// Basamaklari yazdirmak icin bir fonksiyon
	public static void basamaklariYazdir() {
		// Onlar ve birler basamagini gezmek icin donguler
		for (int onlar = 0; onlar <= 4; onlar++) {
			for (int birler = 1; birler <= 9; birler++) {
				// Onlar ve birler basamagini birlestirerek sayiyi olustur
				int sayi = onlar * 10 + birler;
				// Sayiyi ve basamaklari ekrana yazdir
				System.out.println("Onlar basamagi: " + onlar + ", Birler basamagi: " + birler + " --> " + sayi);
			}
		}
	}
	
	// Rakamlar toplamini bulan fonksiyon
	public static int rakamlarToplami(int sayi) {
		int toplam = 0;
		// Sayinin her rakamini toplamak icin while dongusu
		while (sayi > 0) {
			int kalan = sayi % 10;  // Sayinin son rakamini al
			toplam += kalan;  // Rakami toplam degiskenine ekle
			sayi /= 10;  // Sayiyi bir basamak kucult
		}
		// Hesaplanan toplami dondur
		return toplam;
	}
	
	// Basamak sayisini bulan fonksiyon
	public static int basamakSayisi(int sayi) {
		int basamak = 0;
		// Sayinin her basamagini saymak icin while dongusu
		while (sayi > 0) {
			basamak++;  // basamak degerini bir arttir
			sayi /= 10;  // Sayiyi bir basamak kucult
		}
		// Hesaplanan basamak sayisini dondur
		return basamak;
	}
}
