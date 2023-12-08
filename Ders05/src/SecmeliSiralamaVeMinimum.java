// Java'da seçmeli sıralama (selection sort) kullanarak bir diziyi sıralayan ve dizideki minimum elemanı bulan program

public class SecmeliSiralamaVeMinimum {

	public static void main(String[] args) {
		// Bir dizi tanımla ve değerlerini ata
		int[] dizi = {5, 2, 8, 1, 9, 4, 7};

		// Diziyi seçmeli sıralama algoritması ile sırala
		secmeliSiralama(dizi);

		// Sıralanmış diziyi ekrana yazdır
		System.out.println("Sıralanmış Dizi Elemanları:");
		for (int eleman : dizi) {
			System.out.print(eleman + " ");
		}

		// Dizideki minimum elemanı bul ve ekrana yazdır
		int minEleman = dizi[0]; // Minimum elemanı başlangıçta ilk eleman olarak ata

		System.out.println("\nDizideki Minimum Eleman: " + minEleman);
	}

	// Seçmeli sıralama algoritması
	public static void secmeliSiralama(int[] dizi) {
		int n = dizi.length;

		for (int i = 0; i < n - 1; i++) {
			// Dizideki i. elemanı minEleman olarak ata
			int minIndex = i;

			// Dizinin geri kalan kısmında minimum elemanı bul
			for (int j = i + 1; j < n; j++) {
				if (dizi[j] < dizi[minIndex]) {
					minIndex = j;
				}
			}

			// Swap (değiş tokuş): Minimum elemanı bulunan elemanla değiştir
			int gecici = dizi[minIndex];
			dizi[minIndex] = dizi[i];
			dizi[i] = gecici;
		}
	}
}
