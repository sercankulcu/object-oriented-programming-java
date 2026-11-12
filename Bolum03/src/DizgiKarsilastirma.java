// Dizgi karsilastirma: == referansi, equals icerigi karsilastirir; dizgi havuzu, intern,
// null ile equals, startsWith/endsWith/equalsIgnoreCase/contains ve compareTo.
public class DizgiKarsilastirma {

	// == ile Karsilastirma / Havuz: Adim Adim
	static void esittirEsittir() {
		String str1 = "Giresun";
		String str2 = "Giresun";
		String str3 = new String("Giresun");
		System.out.println(str1 == str2);        // true
		System.out.println(str1 == "Giresun");   // true
		System.out.println(str1 == str3);        // false
		System.out.println(str3 == "Giresun");   // false
	}

	// equals() ile Karsilastirma
	static void equalsIle() {
		String str1 = "Giresun";
		String str2 = "Giresun";
		String str3 = new String("Giresun");
		System.out.println(str1.equals(str2));                 // true
		System.out.println(str1.equals("Giresun"));            // true
		System.out.println(str1.equals(str3));                 // true
		System.out.println(str3.equals("Giresun"));            // true
		System.out.println(str3.intern() == str1);             // true
		String a = "Gire";
		String b = a + "sun";  // yeni nesne
		System.out.println(b == str1);                         // false
		System.out.println(b.equals(str1));                    // true

		String cevap = null;
		System.out.println("evet".equals(cevap)); // false
		try {
			System.out.println(cevap.equals("evet")); // hata!
		} catch (NullPointerException e) {
			System.out.println(e);
			// java.lang.NullPointerException: Cannot invoke "String.equals(Object)" because "cevap" is null
		}
	}

	// Karsilastirma Metotlari: Ornek
	static void karsilastirmaMetotlari() {
		String s = "Giresun \u00dcni.";
		System.out.println(s.startsWith("Gir"));                // true
		System.out.println(s.startsWith("G\u0131r"));           // false
		System.out.println(s.endsWith("\u00dcni."));            // true
		System.out.println(s.endsWith("\u00dcni"));             // false
		System.out.println(s.equalsIgnoreCase("Giresun \u00dcni."));       // true
		System.out.println(s.equalsIgnoreCase("G\u0131resun \u00fcni."));  // true
		System.out.println(s.equalsIgnoreCase("GIresun Uni."));            // false
		System.out.println(s.contains("\u00dcni"));             // true
	}

	// compareTo: Sozluk Sirasi
	static void compareTo() {
		System.out.println("elma".compareTo("armut"));          // 4
		System.out.println("armut".compareTo("elma"));          // -4
		System.out.println("elma".compareTo("elma"));           // 0
		System.out.println("Elma".compareTo("elma"));           // -32
		System.out.println("Elma".compareToIgnoreCase("elma")); // 0
		System.out.println("ev".compareTo("evet"));             // -2
		System.out.println("\u00e7ay".compareTo("dut"));        // 131
	}

	// compareTo: Kod Izleme
	static void compareToIzleme() {
		String a = "masa", b = "mavi";
		int r1 = a.compareTo(b);
		int r2 = "kar".compareTo("karne");
		int r3 = "Zeki".compareTo("ali");
		System.out.println(r1 + " " + r2 + " " + r3);           // -3 -2 -7
	}

	public static void main(String[] args) {
		esittirEsittir();
		equalsIle();
		karsilastirmaMetotlari();
		compareTo();
		compareToIzleme();
	}
}

/* Beklenen cikti:
true
true
false
false
true
true
true
true
true
false
true
false
java.lang.NullPointerException: Cannot invoke "String.equals(Object)" because "<local5>" is null
true
false
true
false
true
true
false
true
4
-4
0
-32
0
-2
131
-3 -2 -7
*/
