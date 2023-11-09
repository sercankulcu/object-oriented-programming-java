import java.util.Scanner;

public class UcSayiArtanSiraOrnegi {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.print("Birinci sayıyı girin: ");
		int sayi1 = scanner.nextInt();

		System.out.print("İkinci sayıyı girin: ");
		int sayi2 = scanner.nextInt();

		System.out.print("Üçüncü sayıyı girin: ");
		int sayi3 = scanner.nextInt();

		scanner.close();

		// Sayıları artan sırayla yazdırma
		if (sayi1 <= sayi2 && sayi2 <= sayi3) {
			System.out.println("Artan sırayla: " + sayi1 + ", " + sayi2 + ", " + sayi3);
		} else if (sayi1 <= sayi3 && sayi3 <= sayi2) {
			System.out.println("Artan sırayla: " + sayi1 + ", " + sayi3 + ", " + sayi2);
		} else if (sayi2 <= sayi1 && sayi1 <= sayi3) {
			System.out.println("Artan sırayla: " + sayi2 + ", " + sayi1 + ", " + sayi3);
		} else if (sayi2 <= sayi3 && sayi3 <= sayi1) {
			System.out.println("Artan sırayla: " + sayi2 + ", " + sayi3 + ", " + sayi1);
		} else if (sayi3 <= sayi1 && sayi1 <= sayi2) {
			System.out.println("Artan sırayla: " + sayi3 + ", " + sayi1 + ", " + sayi2);
		} else {
			System.out.println("Artan sırayla: " + sayi3 + ", " + sayi2 + ", " + sayi1);
		}
	}
}
