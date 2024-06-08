package objects;

public class Matematik {
	// Statik toplama metodu
	public static int toplama(int sayi1, int sayi2) {
		return sayi1 + sayi2;
	}

	// Statik çıkarma metodu
	public static int cikarma(int sayi1, int sayi2) {
		return sayi1 - sayi2;
	}

	// Ana metod (main method) içinde kullanımı
	public static void main(String[] args) {
		int sonuc1 = Matematik.toplama(5, 3);  // Statik toplama metodu kullanımı
		int sonuc2 = Matematik.cikarma(10, 4); // Statik çıkarma metodu kullanımı

		System.out.println("Toplama Sonucu: " + sonuc1);
		System.out.println("Çıkarma Sonucu: " + sonuc2);
	}
}
