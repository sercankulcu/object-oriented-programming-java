import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

// Tampon ve Turkce karakterler: baytlari tek tek char'a cevirmek cok baytli harfleri bozar,
// dogrusu Charset.decode kullanmaktir. Metin "Dunya" (u-umlaut ile, unicode kacisi).
public class TamponUmlaut {
	public static void main(String[] args) {
		ByteBuffer b = ByteBuffer.allocate(64);
		b.put("D\u00fcnya".getBytes(StandardCharsets.UTF_8));
		b.flip();
		while (b.hasRemaining())
			System.out.print((char) b.get());      // yanlis
		System.out.println();                    // bozuk: u-umlaut yerine iki garip karakter
		b.rewind();
		System.out.println(StandardCharsets.UTF_8.decode(b));  // dogru: Dunya (u-umlaut ile)
	}
}

/* Beklenen cikti:
Dￃﾼnya
Dünya
*/
