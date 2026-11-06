import java.io.*;

// Sirali erisim (FileInputStream) bastan okur; rastgele erisim (RandomAccessFile) seek ile
// istenen konuma atlar.
public class RasgeleErisim {
	public static void main(String[] args) throws IOException {
		// Hazirlik: ilk bayti 1, 100. konumdaki int'i 256 olan 104 baytlik dosya
		try (FileOutputStream w = new FileOutputStream("dosya")) {
			byte[] b = new byte[104];
			b[0] = 1;
			b[102] = 1;   // 00 00 01 00 -> 256
			w.write(b);
		}

		// Sirali Erisim
		FileInputStream sirali = new FileInputStream("dosya");
		int bayt = sirali.read();
		sirali.close();
		System.out.println("Ilk byte: " + bayt);              // Ilk byte: 1
		// Rasgele Erisim
		RandomAccessFile rast = new RandomAccessFile("dosya", "rw");
		// Dosyanin basindan 100 byte ilerideki konuma git
		rast.seek(100);
		// 100. konumdan itibaren 4 byte'lik bir int oku
		int veri = rast.readInt();
		System.out.println("100. konumdaki int: " + veri);    // 100. konumdaki int: 256
		rast.close();

		new File("dosya").delete();
	}
}
