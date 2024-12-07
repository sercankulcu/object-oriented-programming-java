package functions; 
import java.util.Scanner;  // Kullanicidan giris almak icin Scanner sinifini ice aktar

public class UsAlma {

	// 'usAl' metodu, verilen tabanin belirtilen usse gore ussunu hesaplar
	int usAl(int taban, int us) {
		int sonuc = 1;  // Sonuc degiskeni 1 ile baslar cunku herhangi bir sayinin 0. kuvveti 1'dir

		// Dongu, us sayisi kadar doner ve her adimda sonucu taban ile carpar
		for(int i = 0; i < us; i++) {
			sonuc *= taban;  
		}

		// Hesaplanan sonuc dondurulur
		return sonuc;
	}

	public static void main(String[] args) {

		// Kullanicidan giris almak icin Scanner nesnesi olustur
		Scanner okuyucu = new Scanner(System.in);

		// Kullanicidan taban sayisini girmesini iste
		System.out.println("Lutfen tabani giriniz:");
		int taban = okuyucu.nextInt();  // Kullanicinin girdigi taban sayisi alinir

		// Kullanicidan us sayisini girmesini iste
		System.out.println("Lutfen ussu giriniz:");
		int us = okuyucu.nextInt();  // Kullanicinin girdigi us sayisi alinir

		// UsAlma sinifindan bir nesne olustur
		UsAlma bulucu = new UsAlma();

		// 'usAl' metodunu cagir
		int sonuc = bulucu.usAl(taban, us);

		// Hesaplanan sonuc ekrana yazdirilir
		System.out.println("Sonuc = " + sonuc);

		// Scanner nesnesini kapat
		okuyucu.close();
	}
}