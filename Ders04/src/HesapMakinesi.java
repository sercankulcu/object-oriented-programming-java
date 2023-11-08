
public class HesapMakinesi {
	// İki tamsayıyı topla
	public int topla(int sayi1, int sayi2) {
		return sayi1 + sayi2;
	}

	// İki double sayıyı topla
	public double topla(double sayi1, double sayi2) {
		return sayi1 + sayi2;
	}

	// Üç tamsayıyı topla
	public int topla(int sayi1, int sayi2, int sayi3) {
		return sayi1 + sayi2 + sayi3;
	}

	// Ana metod (main method) içinde kullanımı
	public static void main(String[] args) {
		HesapMakinesi hesapMakinesi = new HesapMakinesi();

		int sonuc1 = hesapMakinesi.topla(5, 3); // İki tamsayı toplama metodu
		double sonuc2 = hesapMakinesi.topla(3.5, 2.7); // İki double sayı toplama metodu
		int sonuc3 = hesapMakinesi.topla(4, 6, 8); // Üç tamsayı toplama metodu

		System.out.println("Sonuç 1: " + sonuc1);
		System.out.println("Sonuç 2: " + sonuc2);
		System.out.println("Sonuç 3: " + sonuc3);
	}
}
