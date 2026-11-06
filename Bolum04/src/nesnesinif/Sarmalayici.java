package nesnesinif;

// Autoboxing ve unboxing: int ile Integer arasindaki otomatik
// donusum ve sarmalayici siniflarin yardimci metotlari.
public class Sarmalayici {
	public static void main(String[] args) {
		// int tipinde bir degisken
		int sayi = 42;
		// Integer wrapper sinifi kullanimi
		Integer wrapperSayi = Integer.valueOf(sayi);
		// Autoboxing (otomatik kutulama)
		Integer wrapperSayi2 = sayi;
		// Unboxing (acik ve otomatik)
		int sayi2 = wrapperSayi2.intValue();
		int sayi3 = wrapperSayi2;
		System.out.println(sayi2 + sayi3);                       // 84
		System.out.println(wrapperSayi.equals(wrapperSayi2));    // true
		System.out.println(Integer.parseInt("123") + 1);         // 124
		System.out.println(Integer.MAX_VALUE);                   // 2147483647
		System.out.println(Character.isDigit('7'));              // true
		System.out.println(Double.parseDouble("2.5") * 2);       // 5.0
		Integer bos = null;      // int bos = null; derlenmez
		System.out.println(bos);                                 // null
	}
}
