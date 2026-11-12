import java.util.Scanner;

// Ic Ice Karar: pozitif / negatif / sifir. Sunumdaki girdilerle (5, -4, 0)
// ve test durumlarindaki sinir degerleriyle (1, -1) calisir.
public class IcIceKarar {

	static void calistir(Scanner giris) {
		int sayi = giris.nextInt();
		if (sayi > 0) {
			System.out.println("pozitif");
		} else if (sayi < 0) {
			System.out.println("negatif");
		} else {
			System.out.println("sifir");
		}
	}

	public static void main(String[] args) {
		calistir(new Scanner("5"));   // pozitif
		calistir(new Scanner("-4"));  // negatif
		calistir(new Scanner("0"));   // sifir
		calistir(new Scanner("1"));   // pozitif
		calistir(new Scanner("-1"));  // negatif
	}
}

/* Beklenen cikti:
pozitif
negatif
sifir
pozitif
negatif
*/
