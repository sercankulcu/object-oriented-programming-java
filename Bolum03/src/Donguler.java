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
