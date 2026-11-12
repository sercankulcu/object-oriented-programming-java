// Metot Asiri Yukleme: ayni ad, farkli parametre listesi; derleyici argumanlara gore secer.
public class AsiriYukleme {
	static int topla(int a, int b) {
		return a + b;
	}
	static double topla(double a, double b) {
		return a + b;
	}
	static int topla(int a, int b, int c) {
		return a + b + c;
	}

	public static void main(String[] args) {
		System.out.println(topla(2, 3));          // 5
		System.out.println(topla(2.5, 1.2));      // 3.7
		System.out.println(topla(1, 2, 3));       // 6

		// Asiri Yukleme: Kod Izleme
		System.out.println(topla(4, 6));          // 10
		System.out.println(topla(4, 2.5));        // 6.5  (4 -> 4.0, double surumu)
		System.out.println(topla(7, 1, 2));       // 10
		System.out.println(topla('A', 1));        // 66   ('A' -> 65, int surumu)
	}
}

/* Beklenen cikti:
5
3.7
6
10
6.5
10
66
*/
