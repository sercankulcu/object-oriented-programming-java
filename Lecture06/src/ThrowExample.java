/*
 * Here is an example code that demonstrates the use of the throw statement in Java:
 * 
 * In this example, we have a try-catch block that checks for an exception. If the age 
 * variable is less than 0, we throw a new exception with the message "Age cannot be 
 * negative." The exception is caught in the catch block and the message is printed 
 * to the console.
 * 
 * */

public class ThrowExample {
	
	public static void main(String[] args) {
		
		try {
			int age = -5;
			if (age < 0) {
				throw new Exception("Age cannot be negative");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
