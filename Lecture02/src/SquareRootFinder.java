/*
 * Here is a Java code example that finds the square root of a given number without using the 
 * sqrt method:
 * 
 * In this example, the findSquareRoot method uses a binary search algorithm to find the square 
 * root of a given number. It starts by setting the low and high bounds of the search to 0 and 
 * the input number, respectively, and continues to search until the difference between the high 
 * and low bounds is smaller than a specified tolerance.
 * */

public class SquareRootFinder {
	
  public static double findSquareRoot(double num) {
  	
    double low = 0.0;
    double high = num;
    double epsilon = 0.00001;
    while (high - low > epsilon) {
      double mid = (low + high) / 2;
      double midSq = mid * mid;
      if (midSq > num) {
        high = mid;
      } else {
        low = mid;
      }
    }
    return (low + high) / 2;
  }

  public static void main(String[] args) {
    double num = 10.0;
    double sqrt = findSquareRoot(num);
    System.out.println("Square root of " + num + ": " + sqrt);
  }
}
