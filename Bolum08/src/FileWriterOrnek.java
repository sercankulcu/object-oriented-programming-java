import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

// FileWriter ile yazma ve ikinci parametre true verilerek dosyanin sonuna ekleme.
public class FileWriterOrnek {
	public static void main(String[] args) throws IOException {
		try (FileWriter yazici = new FileWriter("yeniDosya.txt")) {
			yazici.write("Merhaba, dunya!\n");
			yazici.write("Bu bir FileWriter ornegidir.\n");
			System.out.println("Dosya olusturuldu ve veri yazildi.");   // Dosya olusturuldu ve veri yazildi.
		} catch (IOException e) {
			System.err.println("Dosya hatasi: " + e.getMessage());
			e.printStackTrace();
		}
		// true: dosyanin sonuna ekle (append)
		try (FileWriter ekle = new FileWriter("yeniDosya.txt", true)) {
			ekle.write("Sona eklenen satir.\n");
		} catch (IOException e) {
			System.err.println("Dosya hatasi: " + e.getMessage());
		}

		// Dosyanin icerigi
		for (String satir : Files.readAllLines(Path.of("yeniDosya.txt")))
			System.out.println(satir);
		// Merhaba, dunya!
		// Bu bir FileWriter ornegidir.
		// Sona eklenen satir.
		Files.delete(Path.of("yeniDosya.txt"));
	}
}
