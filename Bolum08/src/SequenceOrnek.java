import java.io.*;

// SequenceInputStream iki akisi ardisik tek akis gibi okur: birinci bitince ikinciye gecer.
public class SequenceOrnek {
	public static void main(String[] args) throws IOException {
		// Hazirlik: iki kucuk dosya
		try (FileWriter w = new FileWriter("dosya1.txt")) {
			w.write("Birinci dosya.\n");
		}
		try (FileWriter w = new FileWriter("dosya2.txt")) {
			w.write("Ikinci dosya.\n");
		}

		try {
			FileInputStream is1 = new FileInputStream("dosya1.txt");
			FileInputStream is2 = new FileInputStream("dosya2.txt");
			SequenceInputStream sis = new SequenceInputStream(is1, is2);
			int okunanByte;
			while ((okunanByte = sis.read()) != -1)
				System.out.print((char) okunanByte);
			sis.close();     // is1 ve is2'yi de kapatir
		} catch (IOException e) {
			System.err.println("Okuma hatasi: " + e.getMessage());
		}
		// Birinci dosya.
		// Ikinci dosya.

		new File("dosya1.txt").delete();
		new File("dosya2.txt").delete();
	}
}
