import java.util.Arrays;

// Genel amacli ve hedefe odakli diller: MATLAB'da tek satir olan matris
// carpimi (C = A * B;) Java'da elle yazilan uc ic ice donguyle yapilir.
public class MatrisCarpimi {
	public static void main(String[] args) {
		int n = 2;
		int[][] A = {{1, 2}, {3, 4}};
		int[][] B = {{5, 6}, {7, 8}};
		int[][] C = new int[n][n];

		// MATLAB: C = A * B;   % tek satir
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				for (int k = 0; k < n; k++)
					C[i][j] += A[i][k] * B[k][j];

		System.out.println(Arrays.deepToString(C));  // [[19, 22], [43, 50]]
	}
}

/* Beklenen cikti:
[[19, 22], [43, 50]]
*/
