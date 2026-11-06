import java.util.Scanner;

// Bekci Deger: 0 girilene kadar sayilari okur, ortalamayi yazar.
// Sunumdaki girdi: 12 7 5 0. Bos girdi (yalniz 0) "Sayi yok" verir.
public class BekciDeger {

	static void calistir(Scanner giris) {
		int toplam = 0, adet = 0;
		int sayi = giris.nextInt();
		while (sayi != 0) {
			toplam += sayi;
			adet++;
			sayi = giris.nextInt();
		}
		if (adet > 0) {
			System.out.println("Ortalama: "
					+ (double) toplam / adet);
		} else {
			System.out.println("Sayi yok");
		}
	}

	public static void main(String[] args) {
		calistir(new Scanner("12 7 5 0"));  // Ortalama: 8.0
		calistir(new Scanner("0"));         // Sayi yok
	}
}
