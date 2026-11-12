// Hanoi Kuleleri: n diski kaynaktan hedefe yardimci cubukla tasir; 2^n - 1 hamle.
public class HanoiKuleleri {
	static void coz(int n, char kaynak,
					char hedef, char yardimci) {
		if (n == 1) {   // tek disk: dogrudan tasi
			System.out.println(n + ": " + kaynak + "->" + hedef);
		} else {
			coz(n - 1, kaynak, yardimci, hedef);
			System.out.println(n + ": " + kaynak + "->" + hedef);
			coz(n - 1, yardimci, hedef, kaynak);
		}
	}
	public static void main(String[] args) {
		coz(3, 'A', 'C', 'B');
		// 1: A->C
		// 2: A->B
		// 1: C->B
		// 3: A->C
		// 1: B->A
		// 2: B->C
		// 1: A->C
	}
}

/* Beklenen cikti:
1: A->C
2: A->B
1: C->B
3: A->C
1: B->A
2: B->C
1: A->C
*/
