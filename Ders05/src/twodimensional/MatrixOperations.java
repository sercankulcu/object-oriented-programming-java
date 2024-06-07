package twodimensional;
import java.util.Arrays;

/*
 * Here is the rest of the MatrixOperations class:
 * 
 * */

public class MatrixOperations {
	// Matrix addition method
	public static double[][] add(double[][] A, double[][] B) {
		// Check the compatibility of the matrices
		if (A.length != B.length || A[0].length != B[0].length) {
			throw new IllegalArgumentException("Matrices are not compatible for addition");
		}

		// Add the matrices and return the result
		int m = A.length;
		int n = A[0].length;
		double[][] C = new double[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				C[i][j] = A[i][j] + B[i][j];
			}
		}
		return C;
	}

	// Scalar multiplication method
	public static double[][] multiply(double c, double[][] A) {
		// Multiply the matrix by the scalar and return the result
		int m = A.length;
		int n = A[0].length;
		double[][] B = new double[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				B[i][j] = c * A[i][j];
			}
		}
		return B;
	}

	// Transposition method
	public static double[][] transpose(double[][] A) {
		// Compute the transpose of the matrix and return the result
		int m = A.length;
		int n = A[0].length;
		double[][] B = new double[n][m];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				B[j][i] = A[i][j];
			}
		}
		return B;
	}

	// Matrix multiplication method
	public static double[][] multiply(double[][] A, double[][] B) {
		// Check the compatibility of the matrices
		if (A[0].length != B.length) {
			throw new IllegalArgumentException("Matrices are not compatible for multiplication");
		}

		// Multiply the matrices and return the result
		int m = A.length;
		int n = B[0].length;
		int p = A[0].length;
		double[][] C = new double[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < p; k++) {
					C[i][j] += A[i][k] * B[k][j];
				}
			}
		}
		return C;
	}

	// Find method
	public static String find(double x, double[][] A) {
		// Search the matrix for the value and return the row and column
		int m = A.length;
		int n = A[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (A[i][j] == x) {
					return i + ";" + j;
				}
			}
		}
		return "Value not found in matrix";
	}

	// Count method
	public static int count(double x, double[][] A) {
		// Search the matrix for the value and count the number of occurrences
		int m = A.length;
		int n = A[0].length;
		int count = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (A[i][j] == x) {
					count++;
				}
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
	  // Define some matrices
	  double[][] A = {{1, 2, 3}, {4, 5, 6}};
	  double[][] B = {{6, 5, 4}, {3, 2, 1}};
	  double[][] C = {{1, 2}, {3, 4}, {5, 6}};
	  double[][] D = {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};

	  // Perform matrix operations
	  double[][] E = MatrixOperations.add(A, B);
	  double[][] F = MatrixOperations.multiply(2, A);
	  double[][] G = MatrixOperations.transpose(A);
	  double[][] H = MatrixOperations.multiply(A, C);
	  String position = MatrixOperations.find(5, A);
	  int count = MatrixOperations.count(0, D);

	  // Print the results
	  System.out.println("Matrix A: " + Arrays.deepToString(A));
	  System.out.println("Matrix B: " + Arrays.deepToString(B));
	  System.out.println("Matrix C: " + Arrays.deepToString(C));
	  System.out.println("Matrix D: " + Arrays.deepToString(D));
	  System.out.println("Matrix E: " + Arrays.deepToString(E));
	  System.out.println("Matrix F: " + Arrays.deepToString(F));
	  System.out.println("Matrix G: " + Arrays.deepToString(G));
	  System.out.println("Matrix H: " + Arrays.deepToString(H));
	  System.out.println("Position of value 5 in matrix A: " + position);
	  System.out.println("Number of value 0 in matrix H" + count);
	}
}

