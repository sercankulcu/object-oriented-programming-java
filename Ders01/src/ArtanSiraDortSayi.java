import java.util.Scanner;

public class ArtanSiraDortSayi {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.print("Birinci sayiyi girin: ");
		int sayi1 = scanner.nextInt();

		System.out.print("ikinci sayiyi girin: ");
		int sayi2 = scanner.nextInt();

		System.out.print("uçuncu sayiyi girin: ");
		int sayi3 = scanner.nextInt();

		System.out.print("Dörduncu sayiyi girin: ");
		int sayi4 = scanner.nextInt();

		scanner.close();

		// Basit karşilaştirmalar kullanarak sayilari siralama
		int gecici;

		// sayi1 ve sayi2'yi gerekirse takas et
		if (sayi1 > sayi2) {
			gecici = sayi1;
			sayi1 = sayi2;
			sayi2 = gecici;
		}
		// sayi1 ve sayi3'u gerekirse takas et
		if (sayi1 > sayi3) {
			gecici = sayi1;
			sayi1 = sayi3;
			sayi3 = gecici;
		}
		// sayi1 ve sayi4'u gerekirse takas et
		if (sayi1 > sayi4) {
			gecici = sayi1;
			sayi1 = sayi4;
			sayi4 = gecici;
		}
		// sayi2 ve sayi3'u gerekirse takas et
		if (sayi2 > sayi3) {
			gecici = sayi2;
			sayi2 = sayi3;
			sayi3 = gecici;
		}
		// sayi2 ve sayi4'u gerekirse takas et
		if (sayi2 > sayi4) {
			gecici = sayi2;
			sayi2 = sayi4;
			sayi4 = gecici;
		}
		// sayi3 ve sayi4'u gerekirse takas et
		if (sayi3 > sayi4) {
			gecici = sayi3;
			sayi3 = sayi4;
			sayi4 = gecici;
		}

		System.out.println("Artan sirayla: " + sayi1 + ", " + sayi2 + ", " + sayi3 + ", " + sayi4);
	}
}
