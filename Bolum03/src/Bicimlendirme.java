import java.util.Locale;

// printf ve String.format: genislik, hassasiyet, sola yaslama, donusum karakterleri.
// Sunumdaki ciktilar Turkce yerel ayarla (ondalik ayirici virgul, binlik ayirici nokta).
public class Bicimlendirme {

	// printf: Ornek / Genislik ve Hassasiyet: Gorsel
	static void printfOrnek() {
		int i = 3;
		float f = -17;
		String s = "java";

		System.out.printf("x: %d y: %f s: %s\n", i, f, s);           // x: 3 y: -17,000000 s: java
		System.out.printf("x: %4d y: %5.2f s: %6s\n", i, f, s);      // x:    3 y: -17,00 s:   java
		System.out.printf("x: %-4d y: %-7.2f s: %-6s\n", i, f, s);   // x: 3    y: -17,00  s: java__
		System.out.printf("x: %-4d y: %-6.3f s: %-6s\n", i, f, s);   // x: 3    y: -17,000 s: java__
		// (__ iki bosluk)
	}

	// String.format
	static void stringFormat() {
		System.out.printf("|%5s|%-5s|%05d|%.1f|%n", "ab", "ab", 42, 3.14159);   // |   ab|ab   |00042|3,1|
		System.out.printf("%c %b %e %x %%%n", 'Z', true, 1234.5, 255);          // Z true 1,234500e+03 ff %
		String mesaj = String.format("%s: %d puan", "Ay\u015fe", 85);
		System.out.println(mesaj);                                              // Ayse: 85 puan
		System.out.printf("%,d%n", 1234567);                                    // 1.234.567
		System.out.printf(Locale.US, "%.2f%n", 2.5);       // import java.util.Locale;   2.50
		System.out.println("%s = %d".formatted("x", 7));   // Java 15+                   x = 7
	}

	public static void main(String[] args) {
		Locale.setDefault(Locale.forLanguageTag("tr-TR"));
		printfOrnek();
		stringFormat();
	}
}

/* Beklenen cikti:
x: 3 y: -17,000000 s: java
x:    3 y: -17,00 s:   java
x: 3    y: -17,00  s: java
x: 3    y: -17,000 s: java
|   ab|ab   |00042|3,1|
Z true 1,234500e+03 ff %
Ayşe: 85 puan
1.234.567
2.50
x = 7
*/
