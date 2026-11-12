// Dongulu Islemler: sozde koddaki "while ... do" ve "repeat ... until"
// yapilarinin Java karsiliklari (while ve do-while).
public class DonguluIslemler {

	// while i > 0 do
	//     set s to s + 1
	//     set i to i - 1
	static void whileDongusu() {
		int s = 0, i = 3;
		while (i > 0) {
			s = s + 1;
			i = i - 1;
		}
		System.out.println("s = " + s + ", i = " + i);  // s = 3, i = 0
	}

	// repeat
	//     print k
	//     set k to k + 1
	// until k > n
	static void doWhileDongusu() {
		int k = 1, n = 3;
		do {
			System.out.println(k);  // 1 / 2 / 3
			k = k + 1;
		} while (k <= n);
	}

	public static void main(String[] args) {
		whileDongusu();
		doWhileDongusu();
	}
}

/* Beklenen cikti:
s = 3, i = 0
1
2
3
*/
