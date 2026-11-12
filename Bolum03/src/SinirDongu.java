// Klasik Hata: <= ile dongu. i == length oldugunda dizi disina tasilir.
// Firlatilan ArrayIndexOutOfBoundsException yakalanip mesaji yazdirilir.
public class SinirDongu {

	// Klasik Hata: <= ile Dongu
	static void klasikHata() {
		int[] dizi = new int[3];
		for (int i = 0; i <= dizi.length; i++) {
			dizi[i] = i * 10;
		}
	}

	// Sinir Disi Dongu: Kod Izleme; "bitti" hic yazilmaz
	static void kodIzleme() {
		int[] kare = new int[4];
		for (int i = 0; i <= kare.length; i++) {
			kare[i] = i * i;
		}
		System.out.println("bitti");
	}

	public static void main(String[] args) {
		try {
			klasikHata();
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e);
			// java.lang.ArrayIndexOutOfBoundsException: Index 3 out of bounds for length 3
		}
		try {
			kodIzleme();
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e);
			// java.lang.ArrayIndexOutOfBoundsException: Index 4 out of bounds for length 4
		}
	}
}

/* Beklenen cikti:
java.lang.ArrayIndexOutOfBoundsException: Index 3 out of bounds for length 3
java.lang.ArrayIndexOutOfBoundsException: Index 4 out of bounds for length 4
*/
