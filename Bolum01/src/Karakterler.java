import java.nio.charset.StandardCharsets;

// Metnin kodlanmasi: UTF-8 bayt sayisi, emoji ve char kodlari.
// Turkce harfler ve emojiler kaynakta Unicode kacislariyla yazildi (kaynak ASCII).
public class Karakterler {

	// UTF-8: "cikolata" (c-cedilla ile) 8 karakter, 9 bayt
	static void utf8() {
		String kelime = "\u00E7ikolata";  // c-cedilla ile "cikolata"
		System.out.println(kelime.length());  // 8
		System.out.println(kelime.getBytes(
				StandardCharsets.UTF_8).length);  // 9
	}

	// Emoji: bir yuz iki char, bir kod noktasi; aile emojisi 8 char
	static void emoji() {
		String yuz = "\uD83D\uDE00";  // gulen yuz emojisi
		System.out.println(yuz.length());  // 2
		System.out.println(
				yuz.codePointCount(0, yuz.length()));  // 1
		String aile = "\uD83D\uDC68\u200D\uD83D\uDC69\u200D\uD83D\uDC67";  // aile emojisi (ZWJ dizisi)
		System.out.println(aile.length());  // 8
	}

	// Dizgi Kodlari: Izleme
	static void dizgiKodlari() {
		String kelime = "\u00E7ikolata";
		for (int i = 0; i < kelime.length(); i++) {
			char ch = kelime.charAt(i);
			System.out.print((int) ch + " ");
		}
		System.out.println();  // 231 105 107 111 108 97 116 97
		System.out.println("Uzunluk: " + kelime.length());  // Uzunluk: 8
	}

	public static void main(String[] args) {
		utf8();
		emoji();
		dizgiKodlari();
	}
}
