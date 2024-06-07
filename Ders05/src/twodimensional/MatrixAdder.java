package twodimensional;
import java.util.Arrays;

/*
 * Here is a Java code example that adds two matrices:
 * 
 * */

public class MatrixAdder {
	
  public static int[][] addMatrices(int[][] matrix1, int[][] matrix2) {
  	
    // Check that the matrices have the same dimensions
    if (matrix1.length != matrix2.length || matrix1[0].length != matrix2[0].length) {
      throw new IllegalArgumentException("Matrices must have the same dimensions");
    }
    // Create a new matrix to store the result
    int[][] result = new int[matrix1.length][matrix1[0].length];
    // Add the elements of the matrices
    for (int i = 0; i < matrix1.length; i++) {
      for (int j = 0; j < matrix1[i].length; j++) {
        result[i][j] = matrix1[i][j] + matrix2[i][j];
      }
    }
    return result;
  }

  public static void main(String[] args) {
    int[][] matrix1 = {{1, 2, 3}, {4, 5, 6}};
    int[][] matrix2 = {{6, 5, 4}, {3, 2, 1}};
    int[][] result = addMatrices(matrix1, matrix2);
    for (int[] row : result) {
      System.out.println(Arrays.toString(row));
    }
  }
}
