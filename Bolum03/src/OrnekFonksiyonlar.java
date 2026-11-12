// Ornek Fonksiyonlar: deger donduren (int, double) ve donmeyen (void) metotlar.
public class OrnekFonksiyonlar {
	// Toplama fonksiyonu
	public static int toplama(int sayi1, int sayi2) {
		return sayi1 + sayi2;
	}
	// Kare hesaplama fonksiyonu
	public static double kareHesapla(double sayi) {
		return sayi * sayi;
	}
	// Merhaba dunya fonksiyonu
	public static void merhabaDunya() {
		System.out.println("Merhaba, Dunya!");
	}

	public static void main(String[] args) {
		System.out.println(toplama(2, 7));        // 9
		System.out.println(kareHesapla(1.5));     // 2.25
		merhabaDunya();                           // Merhaba, Dunya!
	}
}

/* Beklenen cikti:
9
2.25
Merhaba, Dunya!
*/
