// Sayi sistemleri: tiplerin sinirlari, ikiliye cevirme, Java'da tabanlar,
// ikiye tumleyen gosterim ve tasma.
public class SayiSistemleri {

	// Taban ve Sinirlar
	static void tabanVeSinirlar() {
		System.out.println(Byte.MAX_VALUE);    // 8 bit   -> 127
		System.out.println(Short.MAX_VALUE);   // 16 bit  -> 32767
		System.out.println(Integer.MAX_VALUE); // 32 bit  -> 2147483647
		System.out.println(Long.MAX_VALUE);    // 64 bit  -> 9223372036854775807
		// 64 bitin hepsi 1, isaretsiz okunursa:
		System.out.println(Long.toUnsignedString(-1L));  // 18446744073709551615
	}

	// Ikiliye Cevirme: Izleme (13 -> 1101)
	static void ikiliyeCevir() {
		int sayi = 13;
		String ikili = "";
		while (sayi > 0) {
			int kalan = sayi % 2;
			System.out.println(sayi + " % 2 = " + kalan);  // 13 % 2 = 1 / 6 % 2 = 0 / 3 % 2 = 1 / 1 % 2 = 1
			ikili = kalan + ikili;
			sayi = sayi / 2;
		}
		System.out.println("Sonuc: " + ikili);  // Sonuc: 1101
	}

	// Java'da Tabanlar
	static void javadaTabanlar() {
		System.out.println(Integer.toBinaryString(13));  // ikili -> 1101
		System.out.println(Integer.toOctalString(135));  // sekizli -> 207
		System.out.println(Integer.toHexString(255));    // onaltili -> ff
		System.out.println(Integer.parseInt("1101", 2)); // 2 -> 10: 13
		System.out.println(Integer.parseInt("207", 8));  // 8 -> 10: 135
		System.out.println(0b1101 + " " + 0207 + " " + 0xFF);  // 13 135 255
	}

	// Ikiye Tumleyen ve Tasma
	static void ikiyeTumleyen() {
		int sayi = 3;
		int eksi = ~sayi + 1; // ters cevir, 1 ekle
		System.out.println(eksi);  // -3
		byte b = (byte) 0b11111101;
		System.out.println(b);  // -3
		System.out.println(Integer.toBinaryString(-3));  // 11111111111111111111111111111101
		System.out.println(Byte.MIN_VALUE + " .. "
				+ Byte.MAX_VALUE);  // -128 .. 127
	}

	static void tasma() {
		byte b = 127;
		b++;
		System.out.println(b);  // -128
		int m = Integer.MAX_VALUE;
		System.out.println(m + 1);  // -2147483648
		try {
			System.out.println(Math.addExact(m, 1));
		} catch (ArithmeticException e) {
			// Sunumda: Exception in thread "main" java.lang.ArithmeticException: integer overflow
			System.out.println("java.lang.ArithmeticException: " + e.getMessage());  // ... integer overflow
		}
	}

	public static void main(String[] args) {
		tabanVeSinirlar();
		ikiliyeCevir();
		javadaTabanlar();
		ikiyeTumleyen();
		tasma();
	}
}
