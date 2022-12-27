/*
 * Here is a simple example that demonstrates the use of some common Java operators:
 * 
 * This code demonstrates the use of 
 * arithmetic operators (such as +, -, *, /, and %),
 * increment and decrement operators (++ and --), 
 * comparison operators (==, !=, >, <, >=, and <=), 
 * and logical operators (&&, ||, and !).
 * */

public class OperatorsExample {

	public static void main(String[] args) {

		int x = 10;
		int y = 20;
		int z = 30;
		// Arithmetic operators
		int sum = x + y; // sum = 30
		int difference = y - x; // difference = 10
		int product = x * y; // product = 200
		int quotient = y / x; // quotient = 2
		int remainder = y % x; // remainder = 0

		// Comparison operators
		boolean isEqual = x == y; // isEqual = false
		boolean isNotEqual = x != y; // isNotEqual = true
		boolean isGreaterThan = y > x; // isGreaterThan = true
		boolean isLessThan = x < y; // isLessThan = true
		boolean isGreaterThanOrEqualTo = x >= z; // isGreaterThanOrEqualTo = false
		boolean isLessThanOrEqualTo = x <= y; // isLessThanOrEqualTo = true

		// Logical operators
		boolean andResult = x < y && y < z; // andResult = true
		boolean orResult = x < y || y > z; // orResult = true
		boolean notResult = !(x < y); // notResult = false

		// Print out the results
		System.out.println("Sum: " + sum);
		System.out.println("Difference: " + difference);
		System.out.println("Product: " + product);
		System.out.println("Quotient: " + quotient);
		System.out.println("Remainder: " + remainder);
		System.out.println("isEqual: " + isEqual);
		System.out.println("isNotEqual: " + isNotEqual);
		System.out.println("isGreaterThan: " + isGreaterThan);
		System.out.println("isLessThan: " + isLessThan);
		System.out.println("isGreaterThanOrEqualTo: " + isGreaterThanOrEqualTo);
		System.out.println("isLessThanOrEqualTo: " + isLessThanOrEqualTo);
		System.out.println("andResult: " + andResult);
		System.out.println("orResult: " + orResult);
		System.out.println("notResult: " + notResult);

	}
}
