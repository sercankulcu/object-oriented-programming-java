import java.io.*;

// BufferedInputStream bayt bayt, BufferedReader satir satir tamponlu okur.
// Disaridaki akisi kapatmak icteki akisi da kapatir.
public class TamponluOkuma {
	public static void main(String[] args) throws IOException {
		// Hazirlik: okunacak dosyayi olustur
		try (FileWriter w = new FileWriter("dosya.txt")) {
			w.write("Java I/O\nTampon\n");
		}

		try {
			FileInputStream fis = new FileInputStream("dosya.txt");
			BufferedInputStream bis = new BufferedInputStream(fis);
			int veri;
			while ((veri = bis.read()) != -1) {
				System.out.print((char) veri);   // Java I/O / Tampon
			}
			bis.close();     // icteki fis'i de kapatir
		} catch (IOException e) {
			System.err.println("Dosya hatasi: " + e.getMessage());
		}

		try {
			FileReader fr = new FileReader("dosya.txt");
			BufferedReader br = new BufferedReader(fr);
			String satir;
			while ((satir = br.readLine()) != null) {
				System.out.println(satir);       // Java I/O / Tampon
			}
			br.close();     // icteki fr'yi de kapatir
		} catch (IOException e) {
			System.err.println("Dosya hatasi: " + e.getMessage());
		}

		new File("dosya.txt").delete();
	}
}
