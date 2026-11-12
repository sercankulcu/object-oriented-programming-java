import java.util.Scanner;

// Asal Sayi: Bayrak ve break. Bolen bulununca bayrak false olur, dongu kirilir.
// Sunumdaki iki girdi (21 ve 97) sabit dizgilerden okunur.
public class AsalSayi {

	// Sunumdaki main govdesi; Scanner klavye yerine verilen dizgiden okur
	static void calistir(String girdi) {
		Scanner tarayici = new Scanner(girdi);
		System.out.print("Bir sayi girin: ");
		int sayi = tarayici.nextInt();
		boolean asalMi = true;            // bayrak (flag)
		if (sayi < 2) asalMi = false;     // 0 ve 1 asal degildir
		for (int bolen = 2; bolen <= sayi / 2; bolen++) {
			if (sayi % bolen == 0) {      // tam bolunuyor
				asalMi = false;
				break;                    // donguyu kir
			}
		}
		if (asalMi) {
			System.out.println(sayi + " bir asal sayidir.");
		} else {
			System.out.println(sayi + " bir asal sayi degildir.");
		}
		tarayici.close();
	}

	public static void main(String[] args) {
		calistir("21");    // Bir sayi girin: 21 bir asal sayi degildir.
		calistir("97");    // Bir sayi girin: 97 bir asal sayidir.
	}
}

/* Beklenen cikti:
Bir sayi girin: 21 bir asal sayi degildir.
Bir sayi girin: 97 bir asal sayidir.
*/
