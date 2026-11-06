import java.util.Arrays;

// Diziler: tanimlama, ilk deger verme, erisim ve length, for-each, dizi referanslari,
// java.util.Arrays, bellek, iki boyutlu ve duzensiz (ragged) diziler.
public class Diziler {

	// Neden Dizi?: ayri degiskenler yerine tek ad, numarali hucreler
	static void nedenDizi() {
		int not1 = 70;
		int not2 = 85;
		int not3 = 90;
		// ... not50'ye kadar
		int toplam = not1 + not2 + not3 /* + ... */;
		System.out.println(toplam);                            // 245

		int[] notlar = new int[50];
		// ... notlar doldurulur
		notlar[0] = 70; notlar[1] = 85; notlar[2] = 90;
		toplam = 0;
		for (int i = 0; i < notlar.length; i++) {
			toplam += notlar[i];
		}
		System.out.println(toplam);                            // 245
	}

	// Dizi Tanimlama: VeriTipi[] diziAdi = new VeriTipi[diziBoyutu];
	static void diziTanimlama() {
		int[] sayilar = new int[5];      // 5 tamsayi
		double[] olcum = new double[100]; // 100 ondalik
		String[] isimler = new String[30];
		int n = 12;
		char[] harfler = new char[n];     // boyut degiskenden
		int dizi2[] = new int[3];         // C tarzi, gecerli ama onerilmez
		System.out.println(sayilar.length + " " + olcum.length + " " + isimler.length
				+ " " + harfler.length + " " + dizi2.length);  // 5 100 30 12 3
		System.out.println(sayilar[0] + " " + olcum[0] + " " + isimler[0]);   // 0 0.0 null
	}

	// Erisim ve length
	static void erisimVeLength() {
		int[] sayilar = {10, 20, 30, 40, 50};
		int ilkEleman = sayilar[0];    // Ilk elemani alir
		int ikinciEleman = sayilar[1]; // Ikinci elemani alir
		int diziBoyutu = sayilar.length; // 5
		System.out.println(ilkEleman + " " + ikinciEleman
				+ " " + diziBoyutu);                           // 10 20 5
		sayilar[1] = 25;               // yazma
		int son = sayilar[sayilar.length - 1]; // 50
		System.out.println(sayilar[1] + " " + son);            // 25 50
	}

	// Dizi Ilk Deger Verme (Turkce harfler unicode kacislariyla)
	static void ilkDegerVerme() {
		int[] sayilar = {10, 20, 30, 40, 50};      // 5 elemanli
		int[] n = {1, 2, 3, 4, 5};   // 5 deger oldugundan n 5 elemanli bir dizi olur
		int[] m = new int[]{1, 2, 3}; // uzun bicim: her yerde kullanilabilir
		String[] gunler = {"Pzt", "Sal", "\u00c7ar"};
		char[] sesli = {'a', 'e', '\u0131', 'i', 'o', '\u00f6', 'u', '\u00fc'};
		System.out.println(sayilar.length + " " + n.length + " " + m.length
				+ " " + gunler.length + " " + sesli.length);   // 5 5 3 3 8
	}

	// for-each Dongusu
	static void forEach() {
		int[] notlar = {70, 85, 90};
		// Klasik for: indis elimizde
		for (int i = 0; i < notlar.length; i++) {
			System.out.println(i + ". not: " + notlar[i]);     // 0. not: 70 / 1. not: 85 / 2. not: 90
		}
		// for-each: yalnizca degerler
		int toplam = 0;
		for (int not : notlar) {
			toplam += not;
		}
		System.out.println("Toplam: " + toplam);               // Toplam: 245
	}

	// for-each: Kod Izleme. Dongu degiskeni kopyadir; p = 0 diziyi degistirmez
	static void forEachIzleme() {
		int[] puanlar = {60, 75, 95};
		int toplam = 0;
		for (int p : puanlar) {
			toplam += p;
		}
		System.out.println("Toplam: " + toplam);               // Toplam: 230
		for (int p : puanlar) {
			p = 0;
		}
		System.out.println(puanlar[0] + " " + puanlar[2]);     // 60 95
	}

	// Sicaklik Donusumu: Dizi ve for-each
	static void sicaklikDizisi() {
		double[] celsiuslar = {-40, 0, 25, 100};
		for (double celsius : celsiuslar) {
			double fahrenheit = (celsius * 1.8) + 32;
			double kelvin = celsius + 273.15;
			System.out.println(celsius + " \u00b0C = " + fahrenheit
					+ " \u00b0F = " + kelvin + " K");
		}
		// -40.0 C = -40.0 F = 233.14999999999998 K
		// 0.0 C = 32.0 F = 273.15 K
		// 25.0 C = 77.0 F = 298.15 K
		// 100.0 C = 212.0 F = 373.15 K
	}

	// Dizi Referanslari
	static void diziReferanslari() {
		int[] a = {1, 2, 3};
		int[] b = a;         // kopya degil!
		b[0] = 99;
		System.out.println(a[0]);                              // 99
		int[] c = a.clone(); // gercek kopya
		c[1] = 77;
		System.out.println(a[1] + " " + c[1]);                 // 2 77
		System.out.println(a == b);                            // true
		System.out.println(a == c);                            // false
	}

	// java.util.Arrays Sinifi
	static void arraysSinifi() {
		int[] dizi = {5, 3, 8, 1};
		System.out.println(Arrays.toString(dizi));             // [5, 3, 8, 1]
		Arrays.sort(dizi);
		System.out.println(Arrays.toString(dizi));             // [1, 3, 5, 8]
		int[] kopya = Arrays.copyOf(dizi, 6);
		System.out.println(Arrays.toString(kopya));            // [1, 3, 5, 8, 0, 0]
		int[] dolu = new int[4];
		Arrays.fill(dolu, 7);
		System.out.println(Arrays.toString(dolu));             // [7, 7, 7, 7]
		int[] x = {1, 2};
		int[] y = {1, 2};
		System.out.println((x == y) + " " + Arrays.equals(x, y));   // false true
		System.out.println(Arrays.binarySearch(dizi, 5));      // 2
	}

	// Diziler Bellekte Nerede?
	static void bellek() {
		String[] plaka = {"", "Adana", "Ad\u0131yaman", "Afyon"};
		System.out.println(plaka[1]);                          // Adana
		int[] dinamikDizi = new int[10]; // heap'te yer ayrilir
		System.out.println(dinamikDizi.length);                // 10
		dinamikDizi = null; // referans koparildi
		System.out.println(dinamikDizi == null);               // true
	}

	// Iki Boyutlu Diziler (Matrisler)
	static void ikiBoyutlu() {
		int[][] matris = new int[3][3]; // 3x3 boyutunda bir matris
		matris[1][2] = 6;  // 2. satir, 3. sutun
		System.out.println(Arrays.deepToString(matris));       // [[0, 0, 0], [0, 0, 6], [0, 0, 0]]
	}

	// Ilk Deger Verme ve Diziler Dizisi
	static void diziDizisi() {
		int[][] matris = { {1, 2, 3}, {4, 5, 6}, {7, 8, 9} };
		System.out.println(matris.length + " "
				+ matris[0].length + " " + matris[1][2]);      // 3 3 6
	}

	// Duzensiz (Ragged) Diziler
	static void duzensizDiziler() {
		int[][] ucgen = new int[3][];
		for (int i = 0; i < ucgen.length; i++) {
			ucgen[i] = new int[i + 1];
		}
		System.out.println(ucgen[0].length + " " + ucgen[1].length
				+ " " + ucgen[2].length);                      // 1 2 3
		int[][] tablo = {{1, 2}, {3, 4, 5}};
		for (int[] satir : tablo) {
			for (int x : satir) {
				System.out.print(x + " ");
			}
			System.out.println();
		}
		// 1 2
		// 3 4 5
	}

	// Duzensiz Dizi: Kod Izleme (Pascal ucgeni)
	static void duzensizIzleme() {
		int[][] p = new int[4][];
		for (int i = 0; i < p.length; i++) {
			p[i] = new int[i + 1];
			p[i][0] = 1;
			p[i][i] = 1;
			for (int j = 1; j < i; j++) {
				p[i][j] = p[i - 1][j - 1] + p[i - 1][j];
			}
		}
		System.out.println(Arrays.toString(p[3]));             // [1, 3, 3, 1]
	}

	// Uc ve Daha Fazla Boyut
	static void ucBoyut() {
		// 3x3x3 boyutunda uc boyutlu dizi
		int[][][] ucBoyutluDizi = new int[3][3][3];
		ucBoyutluDizi[1][2][0] = 16; // katman 1, satir 2, sutun 0
		System.out.println(ucBoyutluDizi[1][2][0]);            // 16
	}

	public static void main(String[] args) {
		nedenDizi();
		diziTanimlama();
		erisimVeLength();
		ilkDegerVerme();
		forEach();
		forEachIzleme();
		sicaklikDizisi();
		diziReferanslari();
		arraysSinifi();
		bellek();
		ikiBoyutlu();
		diziDizisi();
		duzensizDiziler();
		duzensizIzleme();
		ucBoyut();
	}
}
