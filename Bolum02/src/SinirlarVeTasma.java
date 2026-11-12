// Ilkel tiplerin sinirlari ve tasma: sinir asilinca deger sarar.
public class SinirlarVeTasma {

	// Sinirlari Yazdirmak
	static void sinirlariYazdir() {
		System.out.println("byte  : " + Byte.MIN_VALUE + " .. " + Byte.MAX_VALUE);
		System.out.println("short : " + Short.MIN_VALUE + " .. " + Short.MAX_VALUE);
		System.out.println("int   : " + Integer.MIN_VALUE + " .. " + Integer.MAX_VALUE);
		System.out.println("long  : " + Long.MIN_VALUE + " .. " + Long.MAX_VALUE);
		System.out.println("float : " + Float.MIN_VALUE + " .. " + Float.MAX_VALUE);
		System.out.println("double: " + Double.MIN_VALUE + " .. " + Double.MAX_VALUE);
		System.out.println("char  : " + (int) Character.MIN_VALUE + " .. "
				+ (int) Character.MAX_VALUE);
		// byte  : -128 .. 127
		// short : -32768 .. 32767
		// int   : -2147483648 .. 2147483647
		// long  : -9223372036854775808 .. 9223372036854775807
		// float : 1.4E-45 .. 3.4028235E38
		// double: 4.9E-324 .. 1.7976931348623157E308
		// char  : 0 .. 65535
	}

	// Tasma
	static void tasma() {
		int enBuyuk = Integer.MAX_VALUE;
		System.out.println(enBuyuk);       // 2147483647
		System.out.println(enBuyuk + 1);   // tasma! -> -2147483648
		byte sayi1 = 80;
		byte sayi2 = 50;
		byte toplam = (byte) (sayi1 + sayi2);
		System.out.println(toplam);        // 130 degil -> -126
		long dogru = (long) enBuyuk + 1;
		System.out.println(dogru);         // 2147483648
	}

	// Tasma: Kod Izleme
	static void tasmaIzleme() {
		byte b = 125;
		for (int i = 1; i <= 4; i++) {
			b++;
			System.out.println(b);  // 126 / 127 / -128 / -127
		}
	}

	public static void main(String[] args) {
		sinirlariYazdir();
		tasma();
		tasmaIzleme();
	}
}

/* Beklenen cikti:
byte  : -128 .. 127
short : -32768 .. 32767
int   : -2147483648 .. 2147483647
long  : -9223372036854775808 .. 9223372036854775807
float : 1.4E-45 .. 3.4028235E38
double: 4.9E-324 .. 1.7976931348623157E308
char  : 0 .. 65535
2147483647
-2147483648
-126
2147483648
126
127
-128
-127
*/
