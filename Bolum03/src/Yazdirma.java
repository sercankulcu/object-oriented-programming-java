import java.util.Locale;

// Ekrana Yazdirma: println, print ve printf. Turkce yerel ayarda ondalik ayirici virguldur.
public class Yazdirma {
	public static void main(String[] args) {
		Locale.setDefault(Locale.forLanguageTag("tr-TR"));   // sunumdaki "3,14" ciktisi icin
		System.out.println("Merhaba, Dunya!");               // Merhaba, Dunya!
		System.out.print("Bir ");
		System.out.print("satir");
		System.out.println();                                // Bir satir
		int yas = 20;
		System.out.println("Yas: " + yas);                   // Yas: 20
		System.out.printf("Pi yaklasik %.2f%n", Math.PI);    // Pi yaklasik 3,14
	}
}
