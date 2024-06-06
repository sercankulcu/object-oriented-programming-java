package dizi;

public class SecmeliSiralama {

	public static void main(String[] args) {
		// Örnek bir dizi oluştur
		int[] dizi = {64, 25, 12, 22, 11};

		// Seçim sıralaması uygula
		secimSiralama(dizi);

		// Sıralanmış diziyi ekrana yazdır
		System.out.println("Sıralanmış Dizi:");
		for (int i = 0; i < dizi.length; i++) {
			System.out.print(dizi[i] + " ");
		}
	}

	public static void secimSiralama(int[] dizi) {
		int n = dizi.length;

		for (int i = 0; i < n - 1; i++) {
			int minIndex = i;

			for (int j = i + 1; j < n; j++) {
				if (dizi[j] < dizi[minIndex]) {
					minIndex = j;
				}
			}

			// Minimum elemanı bulduktan sonra değiştir
			int gecici = dizi[minIndex];
			dizi[minIndex] = dizi[i];
			dizi[i] = gecici;
		}
	}
}
