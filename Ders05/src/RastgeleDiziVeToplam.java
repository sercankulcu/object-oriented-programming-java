import java.util.Random;

// Java'da diziye rastgele değerler atayan ve dizideki elemanların toplamını bulan program

public class RastgeleDiziVeToplam {

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

		// Dizideki elemanların toplamını bul ve ekrana yazdır
		int toplam = 0;

		for (int i = 0; i < diziBoyutu; i++) {
			toplam += rastgeleDizi[i];
		}

		System.out.println("\nDizideki Elemanların Toplamı: " + toplam);
	}
}
