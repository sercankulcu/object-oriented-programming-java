import java.util.Scanner;

// for, while, do-while, ic ice donguler, break, continue ve etiketli break.
// do-while izleme ornegi klavye yerine sabit dizgiden okur.
public class Donguler {

	// Sayi Toplama (for)
	static void forToplam() {
		int toplam = 0;
		for (int sayac = 1; sayac <= 10; sayac++) {
			toplam += sayac;
		}
		System.out.println("Toplam: " + toplam);               // Toplam: 55
	}

	// while Dongusu: genel kalip
	static void whileKalip() {
		int i = 0;
		while (i < 5) {
			// Dongu icinde yapilacak islemler
			i++;
		}
		System.out.println("while sonrasi i = " + i);          // while sonrasi i = 5
	}

	// for ve while Karsilastirmasi
	static void whileToplam() {
		int toplam = 0;
		int sayac = 1;
		while (sayac <= 10) {
			toplam += sayac;
			sayac++;
		}
		System.out.println("Toplam: " + toplam);               // Toplam: 55
	}

	// Faktoriyel Hesaplama (while)
	static void faktoriyelWhile() {
		int n = 5;
		int faktoriyel = 1;
		int sayac = 1;
		while (sayac <= n) {
			faktoriyel *= sayac;
			sayac++;
		}
		System.out.println(n + " faktoriyeli: " + faktoriyel); // 5 faktoriyeli: 120
	}

	// do-while Dongusu: genel kalip
	static void doWhileKalip() {
		int i = 0;
		do {
			// Dongu icinde yapilacak islemler
			i++;
		} while (i < 5);
		System.out.println("do-while sonrasi i = " + i);       // do-while sonrasi i = 5
	}

	// do-while: Girdi Dogrulama Izleme (girdi: 12 -3 4)
	static void doWhileIzleme(String girdiler) {
		Scanner klavye = new Scanner(girdiler);
		int sayi;
		do {
			System.out.print("1-10 arasi bir sayi girin: ");
			sayi = klavye.nextInt();
		} while (sayi < 1 || sayi > 10);
		System.out.println("Kabul edilen sayi: " + sayi);
		// 1-10 arasi bir sayi girin: (uc kez) Kabul edilen sayi: 4
		klavye.close();
	}

	// while ve do-while Farki
	static void whileDoWhileFarki() {
		int i = 10;
		while (i < 5) {
			System.out.println("while: " + i);
			i++;
		}
		int j = 10;
		do {
			System.out.println("do-while: " + j);              // do-while: 10
			j++;
		} while (j < 5);
		System.out.println("i = " + i + ", j = " + j);         // i = 10, j = 11
	}

	// Ic Ice Donguler: genel kalip
	static void icIceKalip() {
		int tur = 0;
		for (int i = 1; i <= 3; i++) {
			for (int j = 1; j <= 2; j++) {
				// Ic ice dongu govdesi
				tur++;
			}
		}
		System.out.println("govde " + tur + " kez calisti");   // govde 6 kez calisti
	}

	// Ic Ice Dongulerin Isleyisi
	static void icIceIsleyis() {
		for (int i = 1; i <= 3; i++) {
			for (int j = 1; j <= 2; j++) {
				System.out.println("i = " + i + ", j = " + j);
			}
		}
		// i = 1, j = 1 / i = 1, j = 2 / i = 2, j = 1 / i = 2, j = 2 / i = 3, j = 1 / i = 3, j = 2
	}

	// Ornek: Yildiz Deseni
	static void yildizDeseni() {
		for (int i = 1; i <= 4; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
		// *
		// * *
		// * * *
		// * * * *
	}

	// Basamak Degeri: Cikti Ne Olur?
	static void basamakDegeri() {
		for (int onlar = 0; onlar <= 4; onlar++) {
			for (int birler = 1; birler <= 9; birler++) {
				int sayi = onlar * 10 + birler;
				System.out.println("Onlar basamagi: " + onlar
						+ ", Birler basamagi: " + birler + " --> " + sayi);
			}
		}
		// Onlar basamagi: 0, Birler basamagi: 1 --> 1
		// ...
		// Onlar basamagi: 4, Birler basamagi: 9 --> 49
	}

	// Carpim Tablosu
	static void carpimTablosu() {
		for (int i = 1; i <= 10; i++) {
			for (int j = 1; j <= 10; j++) {
				int carpim = i * j;
				System.out.print(i + "x" + j + "=" + carpim + "\t");
			}
			System.out.println(); // Yeni satir
		}
		// 1x1=1	1x2=2	1x3=3 ...
		// 10x1=10	10x2=20 ...
	}

	// Dongulerde break
	static void dongudeBreak() {
		for (int i = 1; i <= 10; i++) {
			if (i == 5) {
				break;
			}
			System.out.println("Dongu adimi: " + i);           // Dongu adimi: 1 ... 4
		}
		System.out.println("Donguden cikildi.");               // Donguden cikildi.
	}

	// Dongulerde continue
	static void dongudeContinue() {
		for (int i = 1; i <= 10; i++) {
			if (i % 2 == 0) {
				continue;
			}
			System.out.println("Tek sayi: " + i);              // Tek sayi: 1, 3, 5, 7, 9
		}
	}

	// Ic Ice Dongulerde break: yalnizca ic dongu kirilir
	static void icIceBreak() {
		for (int i = 1; i <= 3; i++) {
			for (int j = 1; j <= 3; j++) {
				if (j == 2) {
					break;
				}
				System.out.println(i + " " + j);               // 1 1 / 2 1 / 3 1
			}
		}
	}

	// Etiketli break: Kod Izleme
	static void etiketliBreak() {
		dis:
		for (int i = 1; i <= 3; i++) {
			for (int j = 1; j <= 3; j++) {
				if (i * j == 4) {
					break dis;
				}
				System.out.println(i + " x " + j);             // 1 x 1 / 1 x 2 / 1 x 3 / 2 x 1
			}
		}
		System.out.println("bitti");                           // bitti
	}

	public static void main(String[] args) {
		forToplam();
		whileKalip();
		whileToplam();
		faktoriyelWhile();
		doWhileKalip();
		doWhileIzleme("12 -3 4");
		whileDoWhileFarki();
		icIceKalip();
		icIceIsleyis();
		yildizDeseni();
		basamakDegeri();
		carpimTablosu();
		dongudeBreak();
		dongudeContinue();
		icIceBreak();
		etiketliBreak();
	}
}

/* Beklenen cikti:
Toplam: 55
while sonrasi i = 5
Toplam: 55
5 faktoriyeli: 120
do-while sonrasi i = 5
1-10 arasi bir sayi girin: 1-10 arasi bir sayi girin: 1-10 arasi bir sayi girin: Kabul edilen sayi: 4
do-while: 10
i = 10, j = 11
govde 6 kez calisti
i = 1, j = 1
i = 1, j = 2
i = 2, j = 1
i = 2, j = 2
i = 3, j = 1
i = 3, j = 2
*
* *
* * *
* * * *
Onlar basamagi: 0, Birler basamagi: 1 --> 1
Onlar basamagi: 0, Birler basamagi: 2 --> 2
Onlar basamagi: 0, Birler basamagi: 3 --> 3
Onlar basamagi: 0, Birler basamagi: 4 --> 4
Onlar basamagi: 0, Birler basamagi: 5 --> 5
Onlar basamagi: 0, Birler basamagi: 6 --> 6
Onlar basamagi: 0, Birler basamagi: 7 --> 7
Onlar basamagi: 0, Birler basamagi: 8 --> 8
Onlar basamagi: 0, Birler basamagi: 9 --> 9
Onlar basamagi: 1, Birler basamagi: 1 --> 11
Onlar basamagi: 1, Birler basamagi: 2 --> 12
Onlar basamagi: 1, Birler basamagi: 3 --> 13
Onlar basamagi: 1, Birler basamagi: 4 --> 14
Onlar basamagi: 1, Birler basamagi: 5 --> 15
Onlar basamagi: 1, Birler basamagi: 6 --> 16
Onlar basamagi: 1, Birler basamagi: 7 --> 17
Onlar basamagi: 1, Birler basamagi: 8 --> 18
Onlar basamagi: 1, Birler basamagi: 9 --> 19
Onlar basamagi: 2, Birler basamagi: 1 --> 21
Onlar basamagi: 2, Birler basamagi: 2 --> 22
Onlar basamagi: 2, Birler basamagi: 3 --> 23
Onlar basamagi: 2, Birler basamagi: 4 --> 24
Onlar basamagi: 2, Birler basamagi: 5 --> 25
Onlar basamagi: 2, Birler basamagi: 6 --> 26
Onlar basamagi: 2, Birler basamagi: 7 --> 27
Onlar basamagi: 2, Birler basamagi: 8 --> 28
Onlar basamagi: 2, Birler basamagi: 9 --> 29
Onlar basamagi: 3, Birler basamagi: 1 --> 31
Onlar basamagi: 3, Birler basamagi: 2 --> 32
Onlar basamagi: 3, Birler basamagi: 3 --> 33
Onlar basamagi: 3, Birler basamagi: 4 --> 34
Onlar basamagi: 3, Birler basamagi: 5 --> 35
Onlar basamagi: 3, Birler basamagi: 6 --> 36
Onlar basamagi: 3, Birler basamagi: 7 --> 37
Onlar basamagi: 3, Birler basamagi: 8 --> 38
Onlar basamagi: 3, Birler basamagi: 9 --> 39
Onlar basamagi: 4, Birler basamagi: 1 --> 41
Onlar basamagi: 4, Birler basamagi: 2 --> 42
Onlar basamagi: 4, Birler basamagi: 3 --> 43
Onlar basamagi: 4, Birler basamagi: 4 --> 44
Onlar basamagi: 4, Birler basamagi: 5 --> 45
Onlar basamagi: 4, Birler basamagi: 6 --> 46
Onlar basamagi: 4, Birler basamagi: 7 --> 47
Onlar basamagi: 4, Birler basamagi: 8 --> 48
Onlar basamagi: 4, Birler basamagi: 9 --> 49
1x1=1	1x2=2	1x3=3	1x4=4	1x5=5	1x6=6	1x7=7	1x8=8	1x9=9	1x10=10
2x1=2	2x2=4	2x3=6	2x4=8	2x5=10	2x6=12	2x7=14	2x8=16	2x9=18	2x10=20
3x1=3	3x2=6	3x3=9	3x4=12	3x5=15	3x6=18	3x7=21	3x8=24	3x9=27	3x10=30
4x1=4	4x2=8	4x3=12	4x4=16	4x5=20	4x6=24	4x7=28	4x8=32	4x9=36	4x10=40
5x1=5	5x2=10	5x3=15	5x4=20	5x5=25	5x6=30	5x7=35	5x8=40	5x9=45	5x10=50
6x1=6	6x2=12	6x3=18	6x4=24	6x5=30	6x6=36	6x7=42	6x8=48	6x9=54	6x10=60
7x1=7	7x2=14	7x3=21	7x4=28	7x5=35	7x6=42	7x7=49	7x8=56	7x9=63	7x10=70
8x1=8	8x2=16	8x3=24	8x4=32	8x5=40	8x6=48	8x7=56	8x8=64	8x9=72	8x10=80
9x1=9	9x2=18	9x3=27	9x4=36	9x5=45	9x6=54	9x7=63	9x8=72	9x9=81	9x10=90
10x1=10	10x2=20	10x3=30	10x4=40	10x5=50	10x6=60	10x7=70	10x8=80	10x9=90	10x10=100
Dongu adimi: 1
Dongu adimi: 2
Dongu adimi: 3
Dongu adimi: 4
Donguden cikildi.
Tek sayi: 1
Tek sayi: 3
Tek sayi: 5
Tek sayi: 7
Tek sayi: 9
1 1
2 1
3 1
1 x 1
1 x 2
1 x 3
2 x 1
bitti
*/
