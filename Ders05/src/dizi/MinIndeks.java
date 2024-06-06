package dizi;

public class MinIndeks {

	public static int minIndeks(int[] dizi) {
		if (dizi == null || dizi.length == 0) {
			// Eğer dizi boş ise veya null ise -1 döndür
			return -1;
		}

		int minIndex = 0; // Minimum elemanın indeksi
		for (int i = 1; i < dizi.length; i++) {
			System.out.println(dizi[i] + " ile " + dizi[minIndex] + " karşılaştırılıyor.");
			if (dizi[i] < dizi[minIndex]) {
				minIndex = i; // Dizideki yeni minimum elemanın indeksini güncelle
			}
		}
		return minIndex; // Minimum elemanın indeksini döndür
	}

	public static void main(String[] args) {
		int[] dizi = {7, 3, 9, 2, 5, 4, 11, 12, 1};
		int minIndex = minIndeks(dizi);

		if (minIndex != -1) {
			System.out.println("Dizideki minimum elemanın indeksi: " + minIndex);
		} else {
			System.out.println("Dizi boş veya null.");
		}
	}
}
