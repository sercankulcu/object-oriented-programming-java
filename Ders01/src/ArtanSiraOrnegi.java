import java.util.Scanner;

public class ArtanSiraOrnegi {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("İlk sayıyı girin: ");
		int sayi1 = scanner.nextInt();

		System.out.println("İkinci sayıyı girin: ");
		int sayi2 = scanner.nextInt();

		scanner.close();

		// İki sayıyı artan sırada yazdırma
		if (sayi1 < sayi2) {
			System.out.println("Artan sırayla: " + sayi1 + ", " + sayi2);
		} else {
			System.out.println("Artan sırayla: " + sayi2 + ", " + sayi1);
		}
	}
}
