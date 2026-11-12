import java.io.*;
import java.net.URI;
import java.net.URL;

// Web sayfasi indirme: URL.openStream bir InputStream verir, bayt bayt dosyaya kopyalanir.
// Ag yoksa hata yakalanir ve mesaj yazilir. Boyut sayfaya gore degisir.
public class WebIndir {
	static void indir() throws IOException {
		URL url = URI.create("https://sercankulcu.github.io/").toURL();
		BufferedInputStream bis = new BufferedInputStream(url.openStream());
		FileOutputStream fos = new FileOutputStream(new File("kopya.html"));
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		for (int c = bis.read(); c != -1; c = bis.read()) {
			bos.write(c);
		}
		bis.close();
		bos.close();
		System.out.println("kopya.html: " + new File("kopya.html").length() + " byte");   // ornek: kopya.html: 14283 byte
	}

	public static void main(String[] args) {
		try {
			indir();
		} catch (IOException e) {
			System.out.println("Indirilemedi (ag yok?): " + e);
		} finally {
			new File("kopya.html").delete();
		}
	}
}

/* Not: bu programin ciktisi her calistirmada degisir (sayfanin o anki boyutuna ve ag baglantisina gore);
   asagidaki bir ornek calistirmadir. Ag yoksa ya da sertifika dogrulanamazsa program
   "Indirilemedi (ag yok?): ..." yazar. */
/* Beklenen cikti:
kopya.html: 14283 byte
*/
