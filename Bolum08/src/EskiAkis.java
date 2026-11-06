import java.io.*;

// StringBufferInputStream kullanmayin: her karakterin yalnizca alt baytini verir.
// Dogrusu: metni bir kodlamayla bayta cevirip ByteArrayInputStream ile okumak.
// Metin: s-cedilla ve euro isareti (unicode kacislariyla).
public class EskiAkis {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws IOException {
		InputStream eski = new StringBufferInputStream("\u015f\u20ac");
		int b;
		while ((b = eski.read()) != -1) {
			System.out.print(b + " ");
		}
		System.out.println();                      // 95 172
		byte[] dogru = "\u015f\u20ac".getBytes("UTF-8");
		InputStream yeni = new ByteArrayInputStream(dogru);
		while ((b = yeni.read()) != -1) {
			System.out.print(b + " ");
		}
		System.out.println();                      // 197 159 226 130 172
	}
}
