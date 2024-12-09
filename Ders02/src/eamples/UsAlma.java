package eamples;
import java.util.Scanner; // Kullanicidan veri almak icin Scanner sinifini ice aktarir.

public class UsAlma {

	public static void main(String[] args) {

		// Kullanicidan veri almak icin Scanner objesi olusturur.
		Scanner scanner = new Scanner(System.in);

		// Kullanicidan taban degerini girmesini ister.
		System.out.println("Tabani gir:");
		int taban = scanner.nextInt(); // Girilen taban degerini okur ve 'taban' degiskenine atar.

		// Kullanicidan us degerini girmesini ister.
		System.out.println("Ussu gir:");
		int us = scanner.nextInt(); // Girilen us degerini okur ve 'us' degiskenine atar.
		
		scanner.close();

		// Sonucu hesaplamak icin baslangic degeri 1 olan bir 'sonuc' degiskeni tanimlar.
		int sonuc = 1;

		// 'us' degeri kadar dongu calisir. Her adimda 'taban' degeri ile 'sonuc' carpilir.
		for(int i = 0; i < us; i++) { // Dongu, us sayisi kadar tekrar eder.
			sonuc = sonuc * taban; // Her adimda 'sonuc', 'taban' ile carpilir.
		}

		// Hesaplanan us alma islemine sonucu ekrana yazdirir.
		System.out.println(taban + "^" + us + " = " + sonuc); // Sonucu ekrana yazdirir.
	}
}
