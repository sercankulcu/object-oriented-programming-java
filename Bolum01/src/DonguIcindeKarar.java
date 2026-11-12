import java.util.Scanner;

// Dongu Icinde Karar: sayac (gecen) ve biriktirici (toplam).
// Sunumdaki girdi: 45 70 50 30 88.
public class DonguIcindeKarar {
	public static void main(String[] args) {
		Scanner giris = new Scanner("45 70 50 30 88");
		int gecen = 0, toplam = 0;
		for (int k = 1; k <= 5; k++) {
			int not = giris.nextInt();
			toplam += not;
			if (not >= 50) {
				gecen++;
			}
		}
		System.out.println(gecen + " gecti, ortalama "
				+ toplam / 5.0);  // 3 gecti, ortalama 56.6
		giris.close();
	}
}

/* Beklenen cikti:
3 gecti, ortalama 56.6
*/
