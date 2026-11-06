import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

// Loto ornegi: 1..49 listesini karistirip ilk 6 sayiyi cekmek.
// Tekrarlanabilir olsun diye shuffle sabit tohumlu Random(42) kullanir.
public class Loto {
	// Loto cekilisi yapan metot
	public static Integer[] lotoYap(int toplamSayi, int cekilecekSayi) {
		ArrayList<Integer> sayilar = new ArrayList<Integer>();
		for (int i = 0; i < toplamSayi; i++) {
			sayilar.add(i + 1);          // 1 ... toplamSayi
		}
		Collections.shuffle(sayilar, new Random(42));    // karistir
		Integer[] cekilenSayilar = new Integer[cekilecekSayi];
		for (int i = 0; i < cekilecekSayi; i++) {
			cekilenSayilar[i] = sayilar.get(i);
		}
		return cekilenSayilar;
	}

	public static void main(String[] args) {
		Integer[] sonuc = lotoYap(49, 6);   // 49'dan 6
		for (Integer item : sonuc) {
			System.out.print(item + " ");
		}
		System.out.println();   // 4 34 8 24 26 40 (tohum 42; sunumda tohumsuz: 46 18 22 11 20 10)
	}
}
