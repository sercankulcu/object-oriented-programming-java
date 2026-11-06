import java.util.HashMap;
import java.util.Map;

// Ozyineleme: faktoriyel, toplam, Fibonacci, Lucas, Catalan, Bell serileri, rakamlar toplami,
// palindrom, EBOB, dongu ile karsiliklari, kuyruk ozyinelemesi ve bellekleme.
// Ayni imzali farkli surumler (dongu, bellekleme) static ic siniflardadir.
public class Ozyineleme {

	// Faktoriyel Alma
	static int faktoriyel(int n) {
		if (n == 0 || n == 1) {
			return 1;   // taban durum
		} else {
			return n * faktoriyel(n - 1); // ozyineleme
		}
	}

	// Toplam Bulma
	static int toplam(int n) {
		if (n == 1) {
			return 1;
		} else {
			return n + toplam(n - 1);
		}
	}

	// Fibonacci Serisi
	static int fibonacci(int n) {
		if (n <= 1) {
			return n;
		} else {
			return fibonacci(n - 1) + fibonacci(n - 2);
		}
	}

	// Lucas Serisi
	static int lucas(int n) {
		if (n == 0) {
			return 2;
		} else if (n == 1) {
			return 1;
		} else {
			return lucas(n - 1) + lucas(n - 2);
		}
	}

	// Catalan Serisi
	static long catalan(int n) {
		if (n <= 1) {
			return 1;
		}
		long sonuc = 0;
		for (int i = 0; i < n; i++) {
			sonuc += catalan(i) * catalan(n - i - 1);
		}
		return sonuc;
	}

	// Bell Serisi
	static int bell(int n) {
		if (n == 0) { return 1; }
		int sayi = 0;
		for (int k = 0; k < n; k++) {
			sayi += katsayi(n - 1, k) * bell(k);
		}
		return sayi;
	}

	static int katsayi(int n, int k) {       // C(n, k)
		return faktoriyel(n) / (faktoriyel(k) * faktoriyel(n - k));
	}

	// Ozyinelemeli Dusunme
	static int basamakSayisi(int n) {
		if (n < 10) {                       // taban durum
			return 1;
		}
		return 1 + basamakSayisi(n / 10);   // kucult + birlestir
	}

	// Rakamlar Toplami
	static int rakamlarToplami(int n) {
		if (n < 0) {
			return rakamlarToplami(-n);
		} else if (n < 10) {
			return n;
		} else {
			return rakamlarToplami(n / 10) + (n % 10);
		}
	}

	// Palindrom Kontrolu
	static boolean palindromMu(String s) {
		if (s.length() <= 1) {
			return true;
		} else if (s.charAt(0) == s.charAt(s.length() - 1)) {
			return palindromMu(s.substring(1, s.length() - 1));
		}
		return false;
	}

	// En Buyuk Ortak Bolen
	static int gcd(int x, int y) {
		if (y == 0) {
			return x;
		}
		return gcd(y, x % y);
	}

	// Faktoriyel, Rakamlar Toplami ve Palindrom: Dongu ile
	static class Dongu {
		static int faktoriyel(int n) {
			int carpim = 1;
			for (int i = 1; i <= n; i++) {
				carpim *= i;
			}
			return carpim;
		}

		static int rakamlarToplami(int n) {
			int toplam = 0;
			int kalan = Math.abs(n);
			while (kalan > 0) {
				toplam += kalan % 10;
				kalan /= 10;
			}
			return toplam;
		}

		static boolean palindromMu(String s) {
			s = s.toLowerCase();
			int uzunluk = s.length();
			for (int i = 0; i < uzunluk / 2; i++) {
				if (s.charAt(i) != s.charAt(uzunluk - 1 - i)) {
					return false;
				}
			}
			return true;
		}
	}

	// Kuyruk Ozyinelemeli Ornekler: son is ozyinelemeli cagri
	static int rakamlarToplami(int sayi, int toplam) {
		if (sayi == 0) {
			return toplam;
		} else {
			return rakamlarToplami(sayi / 10,
					toplam + sayi % 10);
		}
	}

	static int faktoriyel(int n, int birikim) {
		if (n == 0) {
			return birikim;
		} else {
			return faktoriyel(n - 1, n * birikim);
		}
	}

	// Bellekleme (Memoization): Fibonacci
	static class BelleklemeFibonacci {
		static Map<Integer, Long> hafiza = new HashMap<>();

		static long fibonacci(int n) {
			if (hafiza.containsKey(n)) {
				return hafiza.get(n);    // daha once hesaplandi
			}
			if (n == 0 || n == 1) {
				return n;
			}
			long sonuc = fibonacci(n - 1) + fibonacci(n - 2);
			hafiza.put(n, sonuc);        // sonucu sakla
			return sonuc;
		}
	}

	// Belleklemeli Faktoriyel
	static class BelleklemeFaktoriyel {
		static Map<Integer, Long> hafiza = new HashMap<>();

		static long faktoriyel(int n) {
			if (hafiza.containsKey(n)) {
				return hafiza.get(n);
			}
			if (n == 0 || n == 1) {
				return 1;
			}
			long sonuc = n * faktoriyel(n - 1);
			hafiza.put(n, sonuc);
			return sonuc;
		}
	}

	// Ornek Problemler (1)
	static void yaz(int n) {
		if (n == 0) return;
		System.out.print(n + " ");
		yaz(n - 1);
	}
	static void yaz2(int n) {
		if (n == 0) return;
		yaz2(n - 1);
		System.out.print(n + " ");
	}
	static int gizem(int a, int b) {
		if (b == 0) return 0;
		return a + gizem(a, b - 1);
	}

	// Ornek Problemler (2)
	static String ters(String s) {
		if (s.isEmpty()) return "";
		return ters(s.substring(1)) + s.charAt(0);
	}

	public static void main(String[] args) {
		System.out.println(faktoriyel(4));                     // 24
		System.out.println(toplam(5));                         // 15
		System.out.println(fibonacci(4));                      // 3

		StringBuilder fib = new StringBuilder();
		StringBuilder luc = new StringBuilder();
		for (int n = 0; n <= 10; n++) {
			fib.append(fibonacci(n)).append(' ');
			luc.append(lucas(n)).append(' ');
		}
		System.out.println(fib);                               // 0 1 1 2 3 5 8 13 21 34 55
		System.out.println(luc);                               // 2 1 3 4 7 11 18 29 47 76 123

		StringBuilder cat = new StringBuilder();
		for (int n = 0; n <= 9; n++) {
			cat.append(catalan(n)).append(' ');
		}
		System.out.println(cat);                               // 1 1 2 5 14 42 132 429 1430 4862

		StringBuilder bel = new StringBuilder();
		for (int n = 0; n <= 7; n++) {
			bel.append(bell(n)).append(' ');
		}
		System.out.println(bel);                               // 1 1 2 5 15 52 203 877

		System.out.println(basamakSayisi(48729) + " " + basamakSayisi(7));   // 5 1
		System.out.println(rakamlarToplami(-48729));           // 30
		System.out.println(rakamlarToplami(-357));             // 15
		System.out.println(palindromMu("kayak") + " " + palindromMu("abba")
				+ " " + palindromMu("java") + " " + palindromMu("racecar"));   // true true false true
		System.out.println(gcd(444, 93));                      // 3

		// Dongu ile
		System.out.println(Dongu.faktoriyel(4));               // 24
		System.out.println(Dongu.rakamlarToplami(-357));       // 15
		System.out.println(Dongu.palindromMu("Kepek"));        // true

		// Kuyruk ozyinelemesi
		System.out.println(faktoriyel(4, 1));                  // 24
		System.out.println(rakamlarToplami(48729, 0));         // 30

		// Bellekleme
		System.out.println(BelleklemeFibonacci.fibonacci(4));  // 3
		System.out.println(BelleklemeFibonacci.fibonacci(50)); // 12586269025
		System.out.println(BelleklemeFaktoriyel.faktoriyel(20));   // 2432902008176640000

		// Ornek Problemler
		yaz(3);
		System.out.println();                                  // 3 2 1
		yaz2(3);
		System.out.println();                                  // 1 2 3
		System.out.println(gizem(4, 3));                       // 12  (a * b)
		try {
			System.out.println(gizem(4, -1));                  // b hic 0 olmaz
		} catch (StackOverflowError e) {
			System.out.println("gizem(4, -1): " + e);          // gizem(4, -1): java.lang.StackOverflowError
		}
		System.out.println(ters("java"));                      // avaj
	}
}
