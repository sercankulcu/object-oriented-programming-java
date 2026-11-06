import java.util.Arrays;

// Dizi algoritmalari: dogrusal arama, ikili arama, eslestirme, secimli ve kabarcik
// siralamasi, diziyi tersine cevirme.
public class DiziAlgoritmalari {

	// Dogrusal Arama
	static boolean lineerArama(int[] dizi, int hedef) {
		for (int eleman : dizi) {
			if (eleman == hedef) {
				return true;
			}
		}
		return false;
	}

	// Ikili Arama: dizi sirali olmali; her adimda arama alani yariya iner
	static int ikiliAra(int[] dizi, int hedef) {
		int alt = 0, ust = dizi.length - 1;
		while (alt <= ust) {
			int orta = (alt + ust) / 2;
			if (dizi[orta] == hedef) {
				return orta;          // bulundu
			} else if (hedef < dizi[orta]) {
				ust = orta - 1;       // sol yari
			} else {
				alt = orta + 1;       // sag yari
			}
		}
		return -1;                    // alan tukendi
	}

	// Eslestirme: her cift karsilastirilir, n x m karsilastirma
	static void eslestir(int[] dizi1, int[] dizi2) {
		for (int eleman1 : dizi1) {
			for (int eleman2 : dizi2) {
				if (eleman1 == eleman2) {
					System.out.println("Eslesen Eleman: " + eleman1);
				}
			}
		}
	}

	// Secimli Siralama
	static void secimliSirala(int[] dizi) {
		for (int i = 0; i < dizi.length - 1; i++) {
			int minIndeks = i;
			for (int j = i + 1; j < dizi.length; j++) {
				if (dizi[j] < dizi[minIndeks]) {
					minIndeks = j;
				}
			}
			int gecici = dizi[minIndeks];
			dizi[minIndeks] = dizi[i];
			dizi[i] = gecici;
		}
	}

	// Secimli Siralama Adim Adim: ayni metot, her turun sonunda diziyi yazdirir
	static class Izleme {
		static void secimliSirala(int[] dizi) {
			for (int i = 0; i < dizi.length - 1; i++) {
				int minIndeks = i;
				for (int j = i + 1; j < dizi.length; j++) {
					if (dizi[j] < dizi[minIndeks]) {
						minIndeks = j;
					}
				}
				int gecici = dizi[minIndeks];
				dizi[minIndeks] = dizi[i];
				dizi[i] = gecici;
				System.out.println("i=" + i + ": "
						+ Arrays.toString(dizi));
			}
		}
	}

	// Kabarcik Siralamasi
	static void kabarcikSirala(int[] dizi) {
		int n = dizi.length;
		for (int tur = 0; tur < n - 1; tur++) {
			boolean degisti = false;
			for (int j = 0; j < n - 1 - tur; j++) {
				if (dizi[j] > dizi[j + 1]) {  // ters sira
					int gecici = dizi[j];
					dizi[j] = dizi[j + 1];
					dizi[j + 1] = gecici;
					degisti = true;
				}
			}
			System.out.println(Arrays.toString(dizi));
			if (!degisti) break;  // takas yok: sirali
		}
	}

	// Diziyi Tersine Cevirme
	static void tersineCevir(int[] dizi) {
		int baslangic = 0;
		int bitis = dizi.length - 1;
		while (baslangic < bitis) {
			// Baslangic ve bitis elemanlarini degistir
			int gecici = dizi[baslangic];
			dizi[baslangic] = dizi[bitis];
			dizi[bitis] = gecici;
			// Baslangic indeksini artir, bitis indeksini azalt
			baslangic++;
			bitis--;
		}
	}

	public static void main(String[] args) {
		// Dogrusal Arama
		// main icinde:
		int[] dizi = {10, 20, 30, 40, 50};
		boolean sonuc = lineerArama(dizi, 30);
		System.out.println(sonuc);                             // true

		// Dogrusal Aramanin Maliyeti
		// Bir dizide belirli bir elemani arama
		int aranan = 30;
		boolean bulundu = false;
		for (int eleman : dizi) {
			if (eleman == aranan) {
				bulundu = true;
				break;
			}
		} // Bu islem O(n) karmasikligina sahiptir.
		System.out.println(bulundu);                           // true

		// Ikili Arama
		int[] sirali = {3, 9, 14, 27, 42, 48, 55, 61, 70};
		System.out.println(ikiliAra(sirali, 48));              // 5
		System.out.println(ikiliAra(sirali, 50));              // -1

		// Eslestirme
		eslestir(new int[]{3, 7, 1}, new int[]{5, 1, 3, 8});
		// Eslesen Eleman: 3
		// Eslesen Eleman: 1

		// Secimli Siralama
		int[] d1 = {64, 25, 12, 22, 11};
		secimliSirala(d1);
		System.out.println(Arrays.toString(d1));               // [11, 12, 22, 25, 64]

		// Secimli Siralama Adim Adim
		int[] d2 = {64, 25, 12, 22, 11};
		Izleme.secimliSirala(d2);
		// i=0: [11, 25, 12, 22, 64]
		// i=1: [11, 12, 25, 22, 64]
		// i=2: [11, 12, 22, 25, 64]
		// i=3: [11, 12, 22, 25, 64]

		// Kabarcik Siralamasi
		kabarcikSirala(new int[]{64, 25, 12, 22, 11, 36, 48});
		// [25, 12, 22, 11, 36, 48, 64]
		// [12, 22, 11, 25, 36, 48, 64]
		// [12, 11, 22, 25, 36, 48, 64]
		// [11, 12, 22, 25, 36, 48, 64]
		// [11, 12, 22, 25, 36, 48, 64]

		// Diziyi Tersine Cevirme
		int[] t1 = {1, 2, 3, 4, 5};
		tersineCevir(t1);
		System.out.println(Arrays.toString(t1));               // [5, 4, 3, 2, 1]
		int[] t2 = {1, 2, 3, 4};
		tersineCevir(t2);
		System.out.println(Arrays.toString(t2));               // [4, 3, 2, 1]
	}
}
