package random;

import java.util.Random;
import java.util.Scanner;

public class SansOyunu  {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in); // Kullanicidan veri almak için Scanner nesnesi oluştur
		Random random = new Random(); // Rastgele sayi uretmek için Random nesnesi oluştur

		System.out.println("0 ile 100 arasinda bir sayi giriniz:"); // Kullanicidan bir sayi girmesini iste
		int girdi = scanner.nextInt(); // Kullanicinin girdigi sayiyi al
		scanner.close();

		// 0-100 arasinda bir sayi olup olmadigini kontrol et
		if (girdi < 0 || girdi > 100) { 
			System.out.println("Lutfen 0 ile 100 arasinda bir sayi giriniz."); // Hatali sayi araligi girildiyse uyari ver
			return; 
		}

		// Rastgele bir sayi uret
		int rastgele = random.nextInt(100); // 0 ile 99 arasinda bir rastgele sayi uret

		// %35 oraninda kazanma, %65 oraninda kaybetme durumu
		if (rastgele < 35) { // %35 olasilikla kazanma durumu
			System.out.println("Kazandiniz!"); // Kazandiniz mesaji ver
		} else {
			System.out.println("Kaybettiniz!"); // Kaybettiniz mesaji ver
		}
	}
}
