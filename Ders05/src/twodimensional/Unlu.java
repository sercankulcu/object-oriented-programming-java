package twodimensional;
/*
 * Bir grup insan arasinda unlu birinin olup olmadigini belirler
 * ve varsa, onun indeksini dondurur:
 * 
 * Program, `taniyor` dizisini bastan ve sondan itibaren iki isaretci ile iterasyona sokar.
 * Her adimda, soldaki kisi sagdaki kisiyi taniyorsa, soldaki isaretci saga hareket eder,
 * ya da tam tersi durum oldugunda sagdaki isaretci sola hareket eder. Bu sekilde, potansiyel
 * unlu kisi tek bir kisiyle sinirlanir.
 * */

public class Unlu {
	// Bir unlu, herkes tarafindan taninan fakat kimseyi tanimayan bir kisi olarak tanimlanir
	public static int unluBul(int[][] taniyor) {
		// Eger dizi bossa veya 2'den az elemani varsa -1 dondur
		if (taniyor == null || taniyor.length < 2) {
			return -1;
		}

		// Dizinin basinda ve sonunda olacak sekilde iki isaretci baslat
		int sol = 0;
		int sag = taniyor.length - 1;

		// isaretciler kesisene kadar donguye devam et
		while (sol < sag) {
			// Eger soldaki kisi sagdaki kisiyi taniyorsa, sol isaretciyi saga hareket ettir
			if (taniyor[sol][sag] == 1) {
				sol++;
			}
			// Aksi takdirde, sag isaretciyi sola hareket ettir
			else {
				sag--;
			}
		}

		// Bu noktada, sol ve sag isaretcileri ayni kisiye isaret ediyor olmali, bu kisi unlu olabilir
		for (int i = 0; i < taniyor.length; i++) {
			// Eger bu kisi birini taniyorsa ya da kimse bu kisiyi tanimiyorsa, o unlu degildir
			if (i != sol && (taniyor[sol][i] == 1 || taniyor[i][sol] == 0)) {
				return -1;
			}
		}

		// Tum kontroller gecerse, unlunun indeksini dondur
		return sol;
	}

	public static void main(String[] args) {
		int[][] taniyor = {
				{0, 1, 0, 1},
				{0, 0, 1, 1},
				{0, 0, 0, 1},
				{0, 0, 0, 0}
		};
		int unlu = unluBul(taniyor);
		if (unlu == -1) {
			System.out.println("unlu yok.");
		} else {
			System.out.println("unlu kisi indeks " + unlu + " konumunda bulundu.");
		}

		int[][] taniyor2 = {
				{0, 1, 0, 1},
				{0, 0, 1, 1},
				{0, 0, 1, 0},
				{0, 0, 0, 0}
		};
		unlu = unluBul(taniyor2);
		if (unlu == -1) {
			System.out.println("unlu yok.");
		} else {
			System.out.println("unlu kisi indeks " + unlu + " konumunda bulundu.");
		}
	}
}
