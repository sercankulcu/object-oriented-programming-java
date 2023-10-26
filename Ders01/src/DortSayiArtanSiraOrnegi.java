import java.util.Scanner;

public class DortSayiArtanSiraOrnegi {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Birinci sayıyı girin: ");
		int sayi1 = scanner.nextInt();

		System.out.print("İkinci sayıyı girin: ");
		int sayi2 = scanner.nextInt();

		System.out.print("Üçüncü sayıyı girin: ");
		int sayi3 = scanner.nextInt();

		System.out.print("Dördüncü sayıyı girin: ");
		int sayi4 = scanner.nextInt();

		scanner.close();

		// Sayıları artan sırayla yazdırma
		int enKucuk = sayi1;
		int ikinciEnKucuk = sayi2;
		int ucuncuEnKucuk = sayi3;
		int enBuyuk = sayi4;

		// İlk iki sayıyı sıralama
		if (enKucuk > ikinciEnKucuk) {
			int gecici = enKucuk;
			enKucuk = ikinciEnKucuk;
			ikinciEnKucuk = gecici;
		}

		// Üçüncü sayıyı eklemek ve sıralamak
		if (sayi3 < enKucuk) {
			ucuncuEnKucuk = ikinciEnKucuk;
			ikinciEnKucuk = enKucuk;
			enKucuk = sayi3;
		} else if (sayi3 < ikinciEnKucuk) {
			ucuncuEnKucuk = ikinciEnKucuk;
			ikinciEnKucuk = sayi3;
		} else if (sayi3 < ucuncuEnKucuk) {
			ucuncuEnKucuk = sayi3;
		}

		// Dördüncü sayıyı eklemek ve sıralamak
		if (sayi4 < enKucuk) {
			enBuyuk = ucuncuEnKucuk;
			ucuncuEnKucuk = ikinciEnKucuk;
			ikinciEnKucuk = enKucuk;
			enKucuk = sayi4;
		} else if (sayi4 < ikinciEnKucuk) {
			enBuyuk = ucuncuEnKucuk;
			ucuncuEnKucuk = ikinciEnKucuk;
			ikinciEnKucuk = sayi4;
		} else if (sayi4 < ucuncuEnKucuk) {
			enBuyuk = ucuncuEnKucuk;
			ucuncuEnKucuk = sayi4;
		} else {
			enBuyuk = sayi4;
		}

		System.out.println("Artan sırayla: " + enKucuk + ", " + ikinciEnKucuk + ", " + ucuncuEnKucuk + ", " + enBuyuk);
	}
}
