package random;
import java.util.Random;
import java.util.Scanner;

public class SayiTahminOyunu{
	
	public static void main(String[] args) {
		
		// 1 ile 10 arasında rastgele bir sayi üret
		Random rand = new Random();
		int gizliSayi = rand.nextInt(10) + 1;

		// Kullanıcının tahminini al
		Scanner input = new Scanner(System.in);
		System.out.println("Tahmininizi girin (1-10):");
		int tahmin = input.nextInt();
		input.close();

		// Tahminin doğru olup olmadığını kontrol et
		if (tahmin == gizliSayi) {
			System.out.println("Tebrikler! Dogru sayiyi tahmin ettiniz!");
		} else {
			System.out.println("Üzgünüm, dogru sayi " + gizliSayi + " idi.");
		}
	}
}
