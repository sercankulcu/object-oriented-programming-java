import java.util.Scanner;

// Kullanicidan Dizi Okuma ve Ortalama Adim Adim: boyut ve elemanlar okunur, ortalama bulunur.
// Girdiler (4; 7 3 9 5) klavye yerine sabit dizgiden okunur.
public class OrtalamaHesaplama {
	public static void main(String[] args) {
		// Kullanicidan dizi boyutunu al
		Scanner scanner = new Scanner("4 7 3 9 5");
		System.out.print("boyutu girin: ");
		int boyut = scanner.nextInt();
		// Kullanicidan elemanlari al ve dizi olustur
		double[] dizi = new double[boyut];
		for (int i = 0; i < boyut; i++) {
			System.out.print((i + 1) + ". elemani girin: ");
			dizi[i] = scanner.nextDouble();
		}
		// ... diziyle hesaplamalar (Ortalama Adim Adim)
		double toplam = 0;
		for (int i = 0; i < boyut; i++) {
			toplam += dizi[i];
		}
		double ortalama = toplam / boyut;
		System.out.print("Elemanlar: ");
		for (int i = 0; i < boyut; i++) {
			System.out.print(dizi[i] + " ");
		}
		System.out.println();                                  // ... Elemanlar: 7.0 3.0 9.0 5.0
		System.out.println("Ortalama: " + ortalama);           // Ortalama: 6.0
		scanner.close();
	}
}
