// Kontrol Yapilari: Ornek Problemler ve Alistirmalar. Her parcanin cevabi satir sonunda.
public class KontrolOrnekProblemler {

	// Ornek Problemler (1)
	@SuppressWarnings("fallthrough")
	static void ornekProblemler1() {
		// else en yakin if'e baglanir (dangling else)
		int x = 7;
		if (x > 5)
			if (x > 10)
				System.out.println("A");
			else
				System.out.println("B");                       // B

		int s = 0;
		for (int i = 1; i <= 10; i += 3) {
			s += i;
		}
		System.out.println(s);                                 // 22

		int k = 2;
		int puan = 0;
		switch (k) {
			case 1:  puan += 10;
			case 2:  puan += 20;
			case 3:  puan += 30;  break;
			case 4:  puan += 40;
		}
		System.out.println(puan);                              // 50
	}

	// Ornek Problemler (2)
	static void ornekProblemler2() {
		int toplam = 0;
		for (int i = 1; i <= 100; i++) {
			if (i % 3 == 0 || i % 5 == 0) {
				toplam += i;
			}
		}
		System.out.println(toplam);                            // 2418

		int sayi = 2024, basamak = 0;
		while (sayi > 0) {
			basamak++;
			sayi /= 10;
		}
		System.out.println(basamak);                           // 4
	}

	// Alistirmalar (1)
	static void alistirmalar1() {
		int n = 1;
		while (n < 100) {
			n *= 3;
		}
		System.out.println(n);                                 // 243

		int k = 5;
		do {
			k -= 2;
		} while (k > 0);
		System.out.println(k);                                 // -1

		int adet = 0;
		for (int i = 1; i <= 4; i++) {
			for (int j = i; j <= 4; j++) {
				adet++;
			}
		}
		System.out.println(adet);                              // 10
	}

	// Alistirmalar (2)
	static void alistirmalar2() {
		int t = 0;
		for (int i = 1; i <= 10; i++) {
			if (i % 3 == 0) {
				continue;
			}
			t += i;
		}
		System.out.println(t);                                 // 37

		int i = 10;
		while (i >= 1) {
			System.out.print(i + " ");
			i -= 2;
		}
		System.out.println();                                  // 10 8 6 4 2

		int a = 17, b = 42;
		int enBuyuk = (a > b) ? a : b;
		System.out.println(enBuyuk);                           // 42
	}

	public static void main(String[] args) {
		ornekProblemler1();
		ornekProblemler2();
		alistirmalar1();
		alistirmalar2();
	}
}
