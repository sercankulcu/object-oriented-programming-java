import java.util.Arrays;
import java.util.Scanner;

// ModHesaplama: dizi siralanir, ardisik esit elemanlar sayilir; en uzun tekrar mod olur.
// Girdiler (7; 4 2 9 2 7 4 2) klavye yerine sabit dizgiden okunur.
public class ModHesaplama {
	public static void main(String[] args) {
		Scanner scanner = new Scanner("7 4 2 9 2 7 4 2");
		int boyut = scanner.nextInt();
		int[] dizi = new int[boyut];
		for (int i = 0; i < boyut; i++) {
			dizi[i] = scanner.nextInt();
		}
		scanner.close();
		Arrays.sort(dizi);

		// Mod Adim Adim
		int enCokTekrarEden = dizi[0];
		int enCokTekrarSayisi = 1;
		int mevcutTekrarEden = dizi[0];
		int mevcutTekrarSayisi = 1;
		for (int i = 1; i < boyut; i++) {
			if (dizi[i] == dizi[i - 1]) {
				mevcutTekrarSayisi++;
			} else {
				mevcutTekrarSayisi = 1;
				mevcutTekrarEden = dizi[i];
			}
			if (mevcutTekrarSayisi > enCokTekrarSayisi) {
				enCokTekrarSayisi = mevcutTekrarSayisi;
				enCokTekrarEden = mevcutTekrarEden;
			}
		}

		// Sonucu yazdir
		System.out.println("Elemanlar sirali: " + Arrays.toString(dizi));   // Elemanlar sirali: [2, 2, 2, 4, 4, 7, 9]
		System.out.print("Mod: " + enCokTekrarEden);
		System.out.println(" (Tekrar Sayisi: " + enCokTekrarSayisi + ")");  // Mod: 2 (Tekrar Sayisi: 3)
	}
}
