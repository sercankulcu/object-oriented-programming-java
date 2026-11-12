import java.util.Locale;
import java.util.Scanner;

// Sirali islemler, if, if-else, else-if zinciri, ic ice kararlar ve kisa devre.
// Klavye yerine sabit dizgiden okunur; ondalik ayirici Turkce yerel ayarda virguldur.
public class KosulYapilari {

	// Sirali Islemler
	static void siraliIslemler() {
		int x = 5;
		int y = 10;
		int sonuc = x + y;
		System.out.println(sonuc);                             // 15
	}

	// if-else Yapisi: kosul yerine somut bir boolean
	static void ifElseYapisi(boolean kosul) {
		if (kosul) {
			// Kosul dogruysa burasi calisir
			System.out.println("kosul dogru");
		} else {
			// Kosul yanlissa burasi calisir
			System.out.println("kosul yanlis");
		}
	}

	// Yalniz if ve Suslu Parantezler
	static void yalnizIf() {
		int sicaklik = 35;
		if (sicaklik > 30) {
			System.out.println("Hava sicak!");                 // Hava sicak!
		}
		System.out.println("Program devam ediyor.");           // Program devam ediyor.
	}

	// Suslu parantez yoksa if yalnizca ilk deyimi kapsar; girinti yaniltir
	static void parantezsizIf() {
		int sicaklik = 35;
		if (sicaklik > 40)
			System.out.println("Cok sicak!");
			System.out.println("Bol su icin.");                // Bol su icin.
	}

	// Ornek: Yas Kontrolu
	static void yasKontrolu() {
		int yas = 18;
		if (yas >= 18) {
			System.out.println("Ehliyet alabilirsiniz.");      // Ehliyet alabilirsiniz.
		} else {
			System.out.println("Ehliyet alamazsiniz.");
		}
	}

	// Ornek: Mutlak Deger (girdi: -7,5)
	static void mutlakDeger(String girdi) {
		Scanner scanner = new Scanner(girdi);
		System.out.print("Bir sayi girin: ");
		double sayi = scanner.nextDouble();
		double mutlakDeger;
		if (sayi < 0) {
			mutlakDeger = -sayi;
		} else {
			mutlakDeger = sayi;
		}
		System.out.println("Mutlak deger: " + mutlakDeger);   // Bir sayi girin: Mutlak deger: 7.5
		scanner.close();
	}

	// else-if Zinciri: Harf Notu
	static void harfNotu() {
		int not = 75;
		if (not >= 90) {
			System.out.println("A");
		} else if (not >= 80) {
			System.out.println("B");
		} else if (not >= 70) {
			System.out.println("C");                           // C
		} else if (not >= 60) {
			System.out.println("D");
		} else {
			System.out.println("F");
		}
	}

	// Ic Ice Kararlar (Nesting): kosul1 ve kosul2 somut boolean
	static void icIceKarar(boolean kosul1, boolean kosul2) {
		if (kosul1) {
			if (kosul2) {
				// kosul1 VE kosul2 dogru
				System.out.println("kosul1 ve kosul2 dogru");
			}
		} else {
			// kosul1 yanlis
			System.out.println("kosul1 yanlis");
		}
	}

	// Ic Ice Karar: Harf Notu
	static void icIceHarfNotu() {
		int not = 85;
		if (not >= 60) {
			if (not >= 90) {
				System.out.println("Harf notu: A");
			} else {
				System.out.println("Harf notu: B");            // Harf notu: B
			}
		} else {
			System.out.println("Harf notu: F");
		}
	}

	// Kisa Devre: Kod Izleme
	static void kisaDevre() {
		int a = 10, b = 0, sayac = 0;
		boolean s1 = b != 0 && a / b > 2;     // sag taraf hic calismaz: sifira bolme yok
		boolean s2 = b == 0 || ++sayac > 0;   // sol true: ++sayac calismaz
		boolean s3 = b == 0 && ++sayac > 0;   // sol true: ++sayac calisir
		System.out.println(s1 + " " + s2 + " " + s3);          // false true true
		System.out.println("sayac = " + sayac);                // sayac = 1
	}

	public static void main(String[] args) {
		Locale.setDefault(Locale.forLanguageTag("tr-TR"));   // sunumdaki "-7,5" girdisi icin
		siraliIslemler();
		ifElseYapisi(true);                                    // kosul dogru
		ifElseYapisi(false);                                   // kosul yanlis
		yalnizIf();
		parantezsizIf();
		yasKontrolu();
		mutlakDeger("-7,5");
		harfNotu();
		icIceKarar(true, true);                                // kosul1 ve kosul2 dogru
		icIceKarar(false, true);                               // kosul1 yanlis
		icIceHarfNotu();
		kisaDevre();
	}
}

/* Beklenen cikti:
15
kosul dogru
kosul yanlis
Hava sicak!
Program devam ediyor.
Bol su icin.
Ehliyet alabilirsiniz.
Bir sayi girin: Mutlak deger: 7.5
C
kosul1 ve kosul2 dogru
kosul1 yanlis
Harf notu: B
false true true
sayac = 1
*/
