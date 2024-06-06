package dizi;

public class KabarcikSiralama {

	public static void main(String[] args) {
		// Örnek bir dizi oluştur
		int[] dizi = {64, 34, 25, 12, 22, 11, 90};

		// Kabarcık sıralama uygula
		kabarcikSiralama(dizi);

		// Sıralanmış diziyi ekrana yazdır
		System.out.println("Sıralanmış Dizi:");
		for (int i = 0; i < dizi.length; i++) {
			System.out.print(dizi[i] + " ");
		}
	}

	public static void kabarcikSiralama(int[] dizi) {
		int n = dizi.length;

		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (dizi[j] > dizi[j + 1]) {
					// Elemanları yer değiştir
					int gecici = dizi[j];
					dizi[j] = dizi[j + 1];
					dizi[j + 1] = gecici;
				}
			}
		}
	}
}
