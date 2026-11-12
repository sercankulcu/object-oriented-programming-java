import java.io.*;

// Bayt bayt kopyalama: tamponlu akislarla her seferinde bir bayt okunur ve yazilir.
public class BaytKopya {
	public static void main(String[] args) throws IOException {
		// Hazirlik: 4 baytlik kaynak dosya
		try (FileWriter w = new FileWriter("dosya.txt")) {
			w.write("Java");
		}

		File dosya = new File("dosya.txt");
		File dosya2 = new File("dosya2.txt");
		FileInputStream fis = new FileInputStream(dosya);
		FileOutputStream fos = new FileOutputStream(dosya2);
		BufferedInputStream bis = new BufferedInputStream(fis);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		int veri;
		// Bir byte oku. Dosyanin sonunda -1 donecektir.
		while ((veri = bis.read()) != -1)
			bos.write(veri);    // Okunan byte'i cikisa yaz
		bos.close();
		bis.close();
		System.out.println(dosya2.length() + " byte kopyalandi");   // 4 byte kopyalandi

		dosya.delete();
		dosya2.delete();
	}
}

/* Beklenen cikti:
4 byte kopyalandi
*/
