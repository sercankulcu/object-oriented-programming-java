import java.util.Scanner;

public class ArtanSiraIkiSayi {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("ilk sayiyi girin: ");
		int sayi1 = scanner.nextInt();

		System.out.println("ikinci sayiyi girin: ");
		int sayi2 = scanner.nextInt();

		scanner.close();

		// iki sayiyi artan sirada yazdirma
		if (sayi1 < sayi2) {
			System.out.println("Artan sirayla: " + sayi1 + ", " + sayi2);
		} else {
			System.out.println("Artan sirayla: " + sayi2 + ", " + sayi1);
		}
	}
}
