import java.util.Arrays;
import java.util.Random;

// Java'da diziye rastgele değerler atayan ve diziyi sıralayan program

public class RastgeleDiziVeSiralama {

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

		// Diziyi küçükten büyüğe doğru sırala
		Arrays.sort(rastgeleDizi);

		// Sıralanmış diziyi ekrana yazdır
		System.out.println("\nSıralı Dizi Elemanları:");
		for (int i = 0; i < diziBoyutu; i++) {
			System.out.print(rastgeleDizi[i] + " ");
		}
	}
}
