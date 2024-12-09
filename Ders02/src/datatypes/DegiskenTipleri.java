package datatypes;

public class DegiskenTipleri {

	public static void main(String[] args) {

		// Farkli turlerde degiskenler tanimlayip baslat
		byte b = 127; 					// byte tipi
		short s = 32000; 				// short tipi
		int i = 2147483647; 			// int tipi
		long l = 9223372036854775807L; 	// long tipi
		float f = 3.14f; 				// float tipi
		double d = 3.1415926535897932; 	// double tipi
		boolean bool = true; 			// boolean tipi
		char c = 'A'; 					// char tipi
		String str = "Hello, World!"; 	// String tipi

		// Degiskenlerin degerlerini yazdir
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
