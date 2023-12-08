// Java'da lineer arama kullanarak bir dizide minimum elemanı bulan program

public class LineerAramaVeMinimum {

	public static void main(String[] args) {
		// Bir dizi tanımla ve değerlerini ata
		int[] dizi = {5, 2, 8, 1, 9, 4, 7};

		// Minimum elemanı bulmak için lineer arama yap
		int minEleman = dizi[0]; // Minimum elemanı başlangıçta ilk eleman olarak ata

		for (int i = 1; i < dizi.length; i++) {
			if (dizi[i] < minEleman) {
				minEleman = dizi[i];
			}
		}

		// Minimum elemanı ekrana yazdır
		System.out.println("Dizideki Minimum Eleman: " + minEleman);
	}
}
