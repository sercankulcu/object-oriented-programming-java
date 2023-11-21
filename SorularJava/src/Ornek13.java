
import java.util.Scanner;

public class Ornek13 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Bir sayı girin: ");
		int sayi = scanner.nextInt();
		scanner.close();

		int toplam = rakamlarToplami(sayi);

		System.out.println("Rakamların Toplamı: " + toplam);
	}

	public static int rakamlarToplami(int sayi) {
		// Negatif sayıyı pozitife çevirme
		sayi = Math.abs(sayi);

		int toplam = 0;

		while (sayi > 0) {
			int rakam = sayi % 10;  // Son basamağı al
			toplam += rakam;        // Rakamı toplama ekle
			sayi /= 10;             // Son basamağı sayıdan çıkar
		}

		return toplam;
	}
}
