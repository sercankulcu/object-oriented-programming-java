package random;

import java.util.Random;
import java.util.Scanner;

public class SayıTahminOyunu {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();

		System.out.println("0 ile 100 arasında bir sayı giriniz:");
		int kullaniciSayisi = scanner.nextInt();

		// 0-100 arasında bir sayı olup olmadığını kontrol et
		if (kullaniciSayisi < 0 || kullaniciSayisi > 100) {
			System.out.println("Lütfen 0 ile 100 arasında bir sayı giriniz.");
			return;
		}

		// Rastgele bir sayı üretiyoruz
		int randomNumber = random.nextInt(100);

		// %35 oranında kazanma, %65 oranında kaybetme durumu
		if (randomNumber < 35) {
			System.out.println("Kazandınız!");
		} else {
			System.out.println("Kaybettiniz!");
		}
	}
}
