package whileloop;
import java.util.Scanner;

/*
 * Bu Java kodu, verilen bir sayinin palindrom olup olmadigini kontrol eder:
 * 
 * */

public class PalindromKontrol {

	// Sayinin palindrom olup olmadigini kontrol eden fonksiyon
	public static boolean palindromMu(int sayi) {

		int orijinalSayi = sayi;  // Orijinal sayiyi sakla
		int tersSayi = 0;  // Ters sayiyi ilklendir
		while (sayi > 0) {
			int rakam = sayi % 10;  // Sayinin son rakamini al
			tersSayi = (tersSayi * 10) + rakam;  // Ters sayiyi olustur
			sayi /= 10;  // Sayiyi bir basamak kucult
		}
		// Orijinal sayi ile ters sayiyi karsilastir
		return orijinalSayi == tersSayi;
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Bir sayi girin: ");
		int sayi = sc.nextInt();
		sc.close();

		// Sayinin palindrom olup olmadigini kontrol et
		if (palindromMu(sayi)) {
			System.out.println(sayi + " bir palindromdur.");
		} else {
			System.out.println(sayi + " bir palindrom degildir.");
		}
	}
}
