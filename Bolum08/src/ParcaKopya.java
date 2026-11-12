import java.io.*;

// Blok blok kopyalama: 16 KB'lik parcalar halinde okuyup yazmak bayt bayt kopyalamadan hizlidir.
public class ParcaKopya {
	public static void main(String[] args) throws IOException {
		// Hazirlik: 40000 baytlik kaynak dosya
		try (FileOutputStream w = new FileOutputStream("dosya.txt")) {
			w.write(new byte[40000]);
		}

		// Veri, 16K'lik parcalar halinde okunacak
		byte[] parca = new byte[1024 * 16];
		File dosya = new File("dosya.txt");
		File dosya2 = new File("dosya2.txt");
		FileInputStream fis = new FileInputStream(dosya);
		FileOutputStream fos = new FileOutputStream(dosya2);
		BufferedInputStream bis = new BufferedInputStream(fis);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		int boyut;
		// 16K'ya kadar oku. Dosyanin sonunda -1 donecektir.
		while ((boyut = bis.read(parca)) > -1)
			bos.write(parca, 0, boyut);   // Okunan parcayi cikisa yaz
		bos.close();
		bis.close();
		System.out.println(dosya2.length() + " byte kopyalandi");   // 40000 byte kopyalandi

		dosya.delete();
		dosya2.delete();
	}
}

/* Beklenen cikti:
40000 byte kopyalandi
*/
