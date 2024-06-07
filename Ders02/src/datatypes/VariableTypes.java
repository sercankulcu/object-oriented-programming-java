/*
 * Here is a code that demonstrates the use of various Java variable types:
 * 
 * This code declares and initializes variables of the following types: 
 * byte, short, int, long, float, double, boolean, char, and String. 
 * It then prints the values of these variables to the console. 
 * 
 * The byte, short, and int variables are all integer types, with the byte 
 * type being the smallest and the int type being the largest. The long type 
 * is a larger integer type that can hold values up to 9,223,372,036,854,775,807.
 * 
 * The float and double types are both floating-point types, with the float type 
 * being a single-precision type and the double type being a double-precision type.
 * 
 * The boolean type can hold a value of either true or false. 
 * 
 * The char type is a single character type that can hold any Unicode character.
 * 
 * The String type is a reference type that holds a sequence of characters.
 * */
package datatypes;

public class VariableTypes {

	public static void main(String[] args) {

		// Declare and initialize variables of different types
		byte b = 127;
		short s = 32000;
		int i = 2147483647;
		long l = 9223372036854775807L;
		float f = 3.14f;
		double d = 3.14159265358979323846;
		boolean bool = true;
		char c = 'A';
		String str = "Hello, World!";

		// Print the values of the variables
		System.out.println("byte: " + b);
		System.out.println("short: " + s);
		System.out.println("int: " + i);
		System.out.println("long: " + l);
		System.out.println("float: " + f);
		System.out.println("double: " + d);
		System.out.println("boolean: " + bool);
		System.out.println("char: " + c);
		System.out.println("String: " + str);
	}
}
