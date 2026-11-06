import java.util.stream.IntStream;

// Ayni problem iki paradigmayla: buyruksal (adim adim durum degistirme)
// ve fonksiyonel (IntStream ile ne istendigini soyleme).
public class Paradigma {
	public static void main(String[] args) {
		// Buyruksal: adim adim durum degistir
		int toplam = 0;
		for (int i = 1; i <= 5; i++) {
			toplam = toplam + i;
		}
		System.out.println("Buyruksal: " + toplam);  // Buyruksal: 15

		// Fonksiyonel (Java 8+): ne istedigini soyle
		int sonuc = IntStream.rangeClosed(1, 5).sum();
		System.out.println("Fonksiyonel: " + sonuc);  // Fonksiyonel: 15
	}
}
