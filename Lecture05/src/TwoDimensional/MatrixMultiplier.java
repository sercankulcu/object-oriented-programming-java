package TwoDimensional;
import java.util.Arrays;

/*
 * Here is a Java code example that multiplies two matrices:
 * 
 * */

public class MatrixMultiplier {
	
  public static int[][] multiplyMatrices(int[][] matrix1, int[][] matrix2) {
  	
    // Check that the matrices can be multiplied
    if (matrix1[0].length != matrix2.length) {
      throw new IllegalArgumentException("Matrices cannot be multiplied");
    }
    // Create a new matrix to store the result
    int[][] result = new int[matrix1.length][matrix2[0].length];
    // Multiply the elements of the matrices
    for (int i = 0; i < result.length; i++) {
      for (int j = 0; j < result[i].length; j++) {
        for (int k = 0; k < matrix1[0].length; k++) {
          result[i][j] += matrix1[i][k] * matrix2[k][j];
        }
      }
    }
    return result;
  }

  public static void main(String[] args) {
    int[][] matrix1 = {{1, 2, 3}, {4, 5, 6}};
    int[][] matrix2 = {{1, 0}, {0, 1}, {1, 1}};
    int[][] result = multiplyMatrices(matrix1, matrix2);
    for (int[] row : result) {
      System.out.println(Arrays.toString(row));
    }
  }
}
