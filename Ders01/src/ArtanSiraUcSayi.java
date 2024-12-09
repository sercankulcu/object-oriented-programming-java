import java.util.Scanner;

public class ArtanSiraUcSayi {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.print("Birinci sayiyi girin: ");
		int sayi1 = scanner.nextInt();

		System.out.print("ikinci sayiyi girin: ");
		int sayi2 = scanner.nextInt();

		System.out.print("Üçüncü sayiyi girin: ");
		int sayi3 = scanner.nextInt();

		scanner.close();

		// Sayilari artan sirayla yazdirma
		if (sayi1 <= sayi2 && sayi2 <= sayi3) {
			System.out.println("Artan sirayla: " + sayi1 + ", " + sayi2 + ", " + sayi3);
		} else if (sayi1 <= sayi3 && sayi3 <= sayi2) {
			System.out.println("Artan sirayla: " + sayi1 + ", " + sayi3 + ", " + sayi2);
		} else if (sayi2 <= sayi1 && sayi1 <= sayi3) {
			System.out.println("Artan sirayla: " + sayi2 + ", " + sayi1 + ", " + sayi3);
		} else if (sayi2 <= sayi3) {
			System.out.println("Artan sirayla: " + sayi2 + ", " + sayi3 + ", " + sayi1);
		} else if (sayi1 <= sayi2) {
			System.out.println("Artan sirayla: " + sayi3 + ", " + sayi1 + ", " + sayi2);
		} else {
			System.out.println("Artan sirayla: " + sayi3 + ", " + sayi2 + ", " + sayi1);
		}
	}
}
