/*
 * Here is an example of a class that extends the AdvancedCalculator class and 
 * adds more specific functions:
 * 
 * 
 * */

public class ExtendedCalculator extends AdvancedCalculator {
	
	public int power(int base, int exponent) {
		int result = 1;
		for (int i = 0; i < exponent; i++) {
			result *= base;
		}
		return result;
	}

	public int modulus(int num, int divisor) {
		return num % divisor;
	}

	public double squareRoot(double num) {
		return Math.sqrt(num);
	}

	public double log(double num) {
		return Math.log(num);
	}
	
	public static void main(String[] args)
	{
		ExtendedCalculator calc = new ExtendedCalculator();
		int result = calc.power(3, 4);
		System.out.println(result); // prints 81

	}
}
