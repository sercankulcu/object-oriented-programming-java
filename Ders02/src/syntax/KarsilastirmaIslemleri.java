package syntax;

import java.util.Scanner;

public class KarsilastirmaIslemleri {
	
	public static void main(String[] args) {
		
		// Sayilar ile karsilastirma islemleri
		int sayi1 = 10; // sayi1 degiskeni 10 olarak atandi
		int sayi2 = 20; // sayi2 degiskeni 20 olarak atandi

		// Esitlik karsilastirmasi
		boolean esitMi = (sayi1 == sayi2); // sayi1, sayi2'ye esit mi kontrolu
		System.out.println("sayi1, sayi2'ye esit mi? " + esitMi); // false

		// Esit degil karsilastirmasi
		boolean esitDegilMi = (sayi1 != sayi2); // sayi1, sayi2'ye esit degil mi kontrolu
		System.out.println("sayi1, sayi2'ye esit degil mi? " + esitDegilMi); // true

		// Buyukluk karsilastirmasi
		boolean buyukMu = (sayi1 > sayi2); // sayi1, sayi2'den buyuk mu kontrolu
		System.out.println("sayi1, sayi2'den buyuk mu? " + buyukMu); // false

		// Kucukluk karsilastirmasi
		boolean kucukMu = (sayi1 < sayi2); // sayi1, sayi2'den kucuk mu kontrolu
		System.out.println("sayi1, sayi2'den kucuk mu? " + kucukMu); // true

		// Buyuk veya esit karsilastirmasi
		boolean buyukVeyaEsitMi = (sayi1 >= sayi2); // sayi1, sayi2'den buyuk veya esit mi kontrolu
		System.out.println("sayi1, sayi2'den buyuk veya esit mi? " + buyukVeyaEsitMi); // false

		// Kucuk veya esit karsilastirmasi
		boolean kucukVeyaEsitMi = (sayi1 <= sayi2); // sayi1, sayi2'den kucuk veya esit mi kontrolu
		System.out.println("sayi1, sayi2'den kucuk veya esit mi? " + kucukVeyaEsitMi); // true
		
		// Kullanici girdisi ile karsilastirma
		Scanner scanner = new Scanner(System.in);
		
		// Kullaniciya yasini sormak
		System.out.println("Lutfen yasinizi girin:");
		int kullaniciYasi = scanner.nextInt();

		// 18 yas ile karsilastirma
		boolean buyukMu18 = (kullaniciYasi > 18); // Kullanici 18 yasindan buyuk mu kontrolu
		System.out.println("Yasiniz 18'den buyuk mu? " + buyukMu18);

		// Kullaniciya ismini sormak
		System.out.println("Lutfen adinizi girin:");
		String kullaniciismi = scanner.next();

		// Kullanici ismi ile karsilastirma (orneğin, 'Ali' ile)
		boolean isimKontrol = kullaniciismi.equals("Ali"); // Kullanicinin ismi 'Ali' ile mi esit?
		System.out.println("Adiniz Ali mi? " + isimKontrol);

		// Kullanicidan bir sayi girmesini iste
		System.out.println("Lutfen 5 ile 15 arasinda bir sayi girin:");
		int kullaniciSayisi = scanner.nextInt();

		// Kullanici sayisi ile karsilastirma
		boolean sayiBuyuk = (kullaniciSayisi > 5); // Girilen sayi 5'ten buyuk mu?
		boolean sayiKucuk = (kullaniciSayisi < 15); // Girilen sayi 15'ten kuçuk mu?
		System.out.println("Girilen sayi 5'ten buyuk mu? " + sayiBuyuk); // true/false
		System.out.println("Girilen sayi 15'ten kuçuk mu? " + sayiKucuk); // true/false

		// Karakter karsilastirma
		System.out.println("Lutfen bir karakter girin:");
		char kullaniciKarakter = scanner.next().charAt(0); // Kullanicidan bir karakter al
		boolean karakterEsitMi = (kullaniciKarakter == 'A'); // Girilen karakter 'A' ile esit mi?
		System.out.println("Girilen karakter A mi? " + karakterEsitMi); // true/false

		scanner.close(); // Scanner'i kapat
	}
}
