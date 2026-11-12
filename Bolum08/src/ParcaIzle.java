import java.io.*;

// Blok kopyalama izleme: 39 baytlik dosya 16 baytlik parcalarla 16 + 16 + 7 olarak kopyalanir.
public class ParcaIzle {
	public static void main(String[] args) throws IOException {
		// Hazirlik: 39 baytlik kaynak dosya
		try (FileWriter w = new FileWriter("dosya.txt")) {
			w.write("Java ile blok blok dosya kopyalama: 39!");
		}

		byte[] parca = new byte[16];
		try (InputStream in = new FileInputStream("dosya.txt");
			OutputStream out = new FileOutputStream("dosya2.txt")) {
			int boyut;
			while ((boyut = in.read(parca)) > -1) {
				out.write(parca, 0, boyut);
				System.out.println("boyut = " + boyut);
			}
		}
		long n = new File("dosya2.txt").length();
		System.out.println("Bitti: " + n + " byte");
		// boyut = 16
		// boyut = 16
		// boyut = 7
		// Bitti: 39 byte

		new File("dosya.txt").delete();
		new File("dosya2.txt").delete();
	}
}

/* Beklenen cikti:
boyut = 16
boyut = 16
boyut = 7
Bitti: 39 byte
*/
