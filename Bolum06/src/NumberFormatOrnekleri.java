// NumberFormatException: metni sayiya ceviremeyen parse metotlari;
// guvenliOku ile hatayi yakalayip varsayilan degere donmek.
public class NumberFormatOrnekleri {

	// Guvenli Donusturme ve Guvenli Donusturme: Kod Izleme (ayni metot)
	static int guvenliOku(String metin, int varsayilan) {
		try {
			return Integer.parseInt(metin.trim());
		} catch (NumberFormatException e) {
			return varsayilan;
		}
	}

	public static void main(String[] args) {
		// NumberFormatException: her donusum ayri try icinde
		String strNumber = "abc";
		int number;
		try {
			number = Integer.parseInt(strNumber);
		} catch (NumberFormatException e) {
			System.out.println(e);   // java.lang.NumberFormatException: For input string: "abc"
		}
		strNumber = "123abc";
		try {
			number = Integer.parseInt(strNumber);
		} catch (NumberFormatException e) {
			System.out.println(e);   // java.lang.NumberFormatException: For input string: "123abc"
		}
		String strDouble = "12.34abc";
		try {
			double doubleValue = Double.parseDouble(strDouble);
		} catch (NumberFormatException e) {
			System.out.println(e);   // java.lang.NumberFormatException: For input string: "12.34abc"
		}
		String strShort = "45xyz";
		try {
			short shortValue = Short.parseShort(strShort);
		} catch (NumberFormatException e) {
			System.out.println(e);   // java.lang.NumberFormatException: For input string: "45xyz"
		}

		System.out.println(guvenliOku(" 42 ", 0));    // 42
		System.out.println(guvenliOku("kirk", 0));    // 0
		System.out.println(guvenliOku("10.5", -1));   // -1

		System.out.println(guvenliOku(" 7 ", 0));     // 7
		System.out.println(guvenliOku("yedi", 0));    // 0
		System.out.println(guvenliOku("7.5", -1));    // -1
	}
}

/* Beklenen cikti:
java.lang.NumberFormatException: For input string: "abc"
java.lang.NumberFormatException: For input string: "123abc"
java.lang.NumberFormatException: For input string: "12.34abc"
java.lang.NumberFormatException: For input string: "45xyz"
42
0
-1
7
0
-1
*/
