package string;

import java.util.Random;
import java.util.Scanner;

public class RastgeleKarakterDegistirme {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();

		System.out.println("Bir kelime giriniz:");
		String kelime = scanner.nextLine();

		// Eğer kelime 2 veya daha az karakter içeriyorsa değiştirme işlemi yapılamaz
		if (kelime.length() < 2) {
			System.out.println("Kelime en az 2 karakter içermelidir.");
			return;
		}

		// Rastgele iki farklı indeks seçiyoruz
		int index1 = random.nextInt(kelime.length());
		int index2;
		do {
			index2 = random.nextInt(kelime.length());
		} while (index1 == index2); // İki indeksin farklı olmasını sağlıyoruz

		// Karakterleri değiştiriyoruz
		char char1 = kelime.charAt(index1);
		char char2 = kelime.charAt(index2);

		// Yeni kelimeyi oluşturuyoruz
		String yeniKelime = kelime.substring(0, index1) + char2 + kelime.substring(index1 + 1, index2) + char1 + kelime.substring(index2 + 1);

		// Sonucu yazdırıyoruz
		System.out.println("Yeni kelime: " + yeniKelime);
	}
}
