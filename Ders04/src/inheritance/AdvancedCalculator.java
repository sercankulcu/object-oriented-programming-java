/*
 * Here is an example of how you could extend the Calculator class to add more 
 * specific functions:
 * 
 * This AdvancedCalculator class extends the Calculator class and adds four new 
 * specific functions: squareRoot, power, logarithm, and factorial. These functions 
 * allow the calculator to perform square root, power, logarithm, and factorial 
 * calculations, respectively.
 * */
package inheritance;

public class AdvancedCalculator extends Calculator {

    public AdvancedCalculator() {
        super();
    }

    public double squareRoot(double number) {
        return Math.sqrt(number);
    }

    public double power(double base, double exponent) {
        return Math.pow(base, exponent);
    }

    public double logarithm(double number) {
        return Math.log(number);
    }

    public double factorial(double number) {
        if (number == 0) {
            return 1;
        } else {
            return number * factorial(number - 1);
        }
    }
    
    public static void main(String[] args)
	{
		AdvancedCalculator calc = new AdvancedCalculator();
		double result = calc.logarithm(5.3);
		System.out.println(result); // prints 1.6677..

	}

}
