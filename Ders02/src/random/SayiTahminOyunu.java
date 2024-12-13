package random;
import java.util.Random;
import java.util.Scanner;

public class SayiTahminOyunu{
	
	public static void main(String[] args) {
		
		// 1 ile 10 arasinda rastgele bir sayi uret
		Random rand = new Random();
		int gizliSayi = rand.nextInt(10) + 1;

		// Kullanicinin tahminini al
		Scanner input = new Scanner(System.in);
		System.out.println("Tahmininizi girin (1-10):");
		int tahmin = input.nextInt();
		input.close();

		// Tahminin dogru olup olmadigini kontrol et
		if (tahmin == gizliSayi) {
			System.out.println("Tebrikler! Dogru sayiyi tahmin ettiniz!");
		} else {
			System.out.println("Uzgunum, dogru sayi " + gizliSayi + " idi.");
		}
	}
}
