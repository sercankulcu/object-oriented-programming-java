import java.util.Arrays;

// Diziler: Ornek Problemler. Atlamali toplam, dizi parametresi, matris izi,
// onceki elemana bagli doldurma ve referans paylasimi.
public class DiziOrnekProblemler {

	static int gizem(int[] d) {
		int s = 0;
		for (int i = 0; i < d.length; i += 2) {
			s += d[i];
		}
		return s;
	}

	static void degistir(int[] d, int x) {
		d[0] = 100;
		x = 100;
	}

	public static void main(String[] args) {
		// Ornek Problemler (1)
		int[] d = {4, 8, 15, 16, 23, 42};
		System.out.println(gizem(d));                          // 42
		int[] a = {1, 2, 3};
		int x = 1;
		degistir(a, x);
		System.out.println(Arrays.toString(a) + " " + x);      // [100, 2, 3] 1

		// Ornek Problemler (2)
		int[][] m = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		int iz = 0;
		for (int i = 0; i < m.length; i++) {
			iz += m[i][i];
		}
		System.out.println(iz);                                // 15
		// ---
		int[] b = new int[5];
		for (int i = 1; i < b.length; i++) {
			b[i] = b[i - 1] + i;
		}
		System.out.println(Arrays.toString(b));                // [0, 1, 3, 6, 10]
		// ---
		int[] p = {3, 1, 2};
		int[] q = p;
		q[2] = q[0] + q[1];
		System.out.println(Arrays.toString(p));                // [3, 1, 4]
	}
}

/* Beklenen cikti:
42
[100, 2, 3] 1
15
[0, 1, 3, 6, 10]
[3, 1, 4]
*/
