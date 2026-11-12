// OzellikTest'in sinadigi yardimci: metni ters cevirir.
// Sunumda yalnizca MetinIslem.ters cagrisi var; govdesi burada eklendi.
public class MetinIslem {
	public static String ters(String s) {
		return new StringBuilder(s).reverse().toString();
	}

	public static void main(String[] args) {
		System.out.println(ters("java"));         // avaj
		System.out.println(ters(ters("java")));   // java
	}
}

/* Beklenen cikti:
avaj
java
*/
