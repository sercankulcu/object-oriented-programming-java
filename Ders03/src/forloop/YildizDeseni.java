package forloop;

import java.util.Scanner;

public class YildizDeseni {

	public void cizdir1(int satirSayisi) {

		for (int i = 1; i <= satirSayisi; i++) {
			for (int j = 1; j <= satirSayisi - i; j++) {
				System.out.print(" "); // Boşlukları ekrana yazdır
			}
			for (int k = 1; k <= 2 * i - 1; k++) {
				System.out.print("*"); // Yıldızları ekrana yazdır
			}
			System.out.println(); // Yeni satıra geç
		}
	}
	
	public void cizdir2(int satirSayisi) {

		for (int i = satirSayisi; i > 0; i--) {
			for (int j = 1; j <= satirSayisi - i; j++) {
				System.out.print(" "); // Boşlukları ekrana yazdır
			}
			for (int k = 1; k <= 2 * i - 1; k++) {
				System.out.print("*"); // Yıldızları ekrana yazdır
			}
			System.out.println(); // Yeni satıra geç
		}
	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.print("Satır sayısını girin: ");
		int satirSayisi = scanner.nextInt();
		YildizDeseni desen = new YildizDeseni();
		desen.cizdir2(satirSayisi);

		scanner.close();
	}
}
