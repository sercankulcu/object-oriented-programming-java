import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

// Scanner ile dosyayi satir satir okuma; dosya yoksa FileNotFoundException yakalanir.
public class ScannerDosya {
	public static void main(String[] args) throws IOException {
		// Hazirlik: okunacak dosyayi olustur
		Files.writeString(Path.of("ornekDosya.txt"), "Java\nGiris Cikis\nAkislar\n");

		Scanner scanner = null;
		try {
			scanner = new Scanner(new File("ornekDosya.txt"));
			// Dosyanin icerigini okuma ve ekrana yazdirma
			while (scanner.hasNextLine()) {
				String satir = scanner.nextLine();
				System.out.println(satir);   // Java / Giris Cikis / Akislar
			}
		} catch (FileNotFoundException e) {
			System.err.println("Dosya bulunamadi: " + e.getMessage());
		} finally {
			if (scanner != null)
				scanner.close();
		}

		Files.delete(Path.of("ornekDosya.txt"));
	}
}
