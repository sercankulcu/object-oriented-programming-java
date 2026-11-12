// Asal Sayi: bayrak (flag) ve erken cikisla asallik sinamasi.
// Sozde kodun Java karsiligi; sunumdaki girdilerle (7 ve 21) calisir.
public class AsalSayi {

	static void calistir(int sayi) {
		// Bayrak: 0 ve 1 asal degildir
		boolean asalMi;
		if (sayi < 2) asalMi = false;
		else asalMi = true;
		// 2'den sayinin yarisina kadar bolenleri dene
		for (int bolen = 2; bolen <= sayi / 2; bolen++) {
			if (sayi % bolen == 0) {
				// Bolunuyorsa sayi asal degildir
				asalMi = false;
				break;
			}
		}
		// Bayraga gore sonucu yazdir
		if (asalMi) {
			System.out.println(sayi + " bir asal sayidir.");
		} else {
			System.out.println(sayi + " bir asal sayi degildir.");
		}
	}

	public static void main(String[] args) {
		calistir(7);   // 7 bir asal sayidir.
		calistir(21);  // 21 bir asal sayi degildir.
	}
}

/* Beklenen cikti:
7 bir asal sayidir.
21 bir asal sayi degildir.
*/
