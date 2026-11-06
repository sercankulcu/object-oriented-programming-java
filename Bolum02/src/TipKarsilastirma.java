// Farkli Tipler Karsilastirilmamalidir: int ile String == ile karsilastirilamaz;
// once ayni tipe donusturulur.
public class TipKarsilastirma {
	public static void main(String[] args) {
		int sayi = 5;
		String metin = "5";
		// derleme hatasi: boolean b = sayi == metin;
		// error: bad operand types for binary operator '=='
		System.out.println(Integer.parseInt(metin) == sayi);          // true
		System.out.println(metin.equals(String.valueOf(sayi)));       // true
		System.out.println(metin.equals(sayi));                       // false
	}
}
