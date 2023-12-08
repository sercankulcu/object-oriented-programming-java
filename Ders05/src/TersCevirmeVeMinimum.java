// Java'da bir diziyi ters çeviren ve dizideki minimum elemanı bulan program

public class TersCevirmeVeMinimum {

	public static void main(String[] args) {
		// Bir dizi tanımla ve değerlerini ata
		int[] dizi = {5, 2, 8, 1, 9, 4, 7};

		// Diziyi ters çevir
		tersCevir(dizi);

		// Ters çevrilmiş diziyi ekrana yazdır
		System.out.println("Ters Çevrilmiş Dizi Elemanları:");
		for (int eleman : dizi) {
			System.out.print(eleman + " ");
		}

		// Dizideki minimum elemanı bul ve ekrana yazdır
		int minEleman = bulMinEleman(dizi);

		System.out.println("\nDizideki Minimum Eleman: " + minEleman);
	}

	// Diziyi ters çeviren metod
	public static void tersCevir(int[] dizi) {
		int baslangic = 0;
		int bitis = dizi.length - 1;

		while (baslangic < bitis) {
			// Swap (değiş tokuş): Başlangıç ve bitiş indekslerindeki elemanları değiştir
			int gecici = dizi[baslangic];
			dizi[baslangic] = dizi[bitis];
			dizi[bitis] = gecici;

			// İndeksleri güncelle
			baslangic++;
			bitis--;
		}
	}

	// Dizideki minimum elemanı bulan metod
	public static int bulMinEleman(int[] dizi) {
		int minEleman = dizi[0]; // Minimum elemanı başlangıçta ilk eleman olarak ata

		for (int i = 1; i < dizi.length; i++) {
			if (dizi[i] < minEleman) {
				minEleman = dizi[i];
			}
		}

		return minEleman;
	}
}
