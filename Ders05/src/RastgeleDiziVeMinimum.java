import java.util.Random;

// Java'da diziye rastgele değerler atayan ve dizideki minimum elemanı bulan program

public class RastgeleDiziVeMinimum {

	public static void main(String[] args) {
		// Dizi boyutu belirle
		int diziBoyutu = 5;

		// Rastgele sayılar oluşturmak için Random sınıfını kullan
		Random random = new Random();

		// Rastgele değerlerle bir dizi oluştur
		int[] rastgeleDizi = new int[diziBoyutu];

		// Diziyi doldur ve ekrana yazdır
		System.out.println("Rastgele Dizi Elemanları:");
		for (int i = 0; i < diziBoyutu; i++) {
			// Rastgele bir sayı oluştur ve dizinin ilgili elemanına ata
			rastgeleDizi[i] = random.nextInt(100); // 0 ile 100 arasında rastgele bir sayı
			System.out.print(rastgeleDizi[i] + " ");
		}

		// Dizideki minimum elemanı bul ve ekrana yazdır
		int minEleman = rastgeleDizi[0]; // Minimum elemanı başlangıçta ilk eleman olarak ata

		for (int i = 1; i < diziBoyutu; i++) {
			if (rastgeleDizi[i] < minEleman) {
				minEleman = rastgeleDizi[i];
			}
		}

		System.out.println("\nDizideki Minimum Eleman: " + minEleman);
	}
}
