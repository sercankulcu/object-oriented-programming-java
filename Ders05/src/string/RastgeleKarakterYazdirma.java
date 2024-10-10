package string;

import java.util.Random;
import java.util.Scanner;

public class RastgeleKarakterYazdirma {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();

		System.out.println("Bir kelime giriniz:");
		String kelime = scanner.nextLine();

		// Eğer kelime boşsa rastgele karakter seçme işlemi yapılamaz
		if (kelime.isEmpty()) {
			System.out.println("Kelime boş olamaz.");
			return;
		}

		// Rastgele bir indeks seçiyoruz
		int index = random.nextInt(kelime.length());

		// Rastgele karakteri alıyoruz
		char rastgeleKarakter = kelime.charAt(index);

		// Sonucu yazdırıyoruz
		System.out.println("Rastgele karakter: " + rastgeleKarakter);
	}
}
