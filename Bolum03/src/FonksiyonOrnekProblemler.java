// Fonksiyonlar: Ornek Problemler. Degerle aktarim, ic ice cagri ve asiri yukleme secimi.
public class FonksiyonOrnekProblemler {

	// Ornek Problemler (1)
	static int f(int x) {
		x = x * 2;
		return x + 1;
	}

	static int kare(int n) { return n * n; }
	static int kup(int n) { return n * kare(n); }

	// Ornek Problemler (2)
	static int topla(int a, int b) { return a + b; }
	static double topla(double a, double b) { return a + b; }

	public static void main(String[] args) {
		// Ornek Problemler (1)
		int a = 3;
		int b = f(a);
		System.out.println(a + " " + b);                       // 3 7
		System.out.println(f(f(1)));                           // 7
		// main icinde:
		System.out.println(kup(2) + kare(3));                  // 17

		// Ornek Problemler (2)
		// main icinde:
		System.out.println(topla(2, 3.0));                     // 5.0
		System.out.println(topla(2, 3));                       // 5
		System.out.println(Math.max(Math.abs(-8), Math.sqrt(49)));   // 8.0
	}
}

/* Beklenen cikti:
3 7
7
17
5.0
5
8.0
*/
