/*
 * Here is a simple code that demonstrates the use of a try-catch block 
 * to handle exceptions in Java:
 * 
 * In this code, we are trying to divide the value of a by b, which is zero. 
 * This will throw an ArithmeticException, which will be caught by the catch 
 * block. The catch block will print a message to the console, indicating that 
 * division by zero is not allowed.
 * */

public class TryCatchDemo {
	
	public static void main(String[] args) {
		
		try {
			int a = 10;
			int b = 0;
			int c = a / b;
			System.out.println("Result: " + c);
		} catch (ArithmeticException e) {
			System.out.println("Cannot divide by zero!");
		}
	}
}
