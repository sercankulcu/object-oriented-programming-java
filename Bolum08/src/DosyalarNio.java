import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Locale;

// NIO.2 Path ve Files: klasor olusturma, tek satirla yazma/okuma, sona ekleme.
// "Ayse" adindaki s-cedilla UTF-8'de 2 bayt: dosya 23 bayt.
public class DosyalarNio {
	public static void main(String[] args) throws IOException {
		Path yol = Path.of("veri", "notlar.txt");      // Java 11+
		Files.createDirectories(yol.getParent());
		Files.writeString(yol, "Ali 70\nAy\u015fe 85\nCan 90\n");
		System.out.println(yol.getFileName() + ": " + Files.exists(yol));   // notlar.txt: true
		System.out.println("Boyut: " + Files.size(yol) + " byte");          // Boyut: 23 byte
		List<String> satirlar = Files.readAllLines(yol);
		for (String satir : satirlar) {
			System.out.println(satir.toUpperCase(Locale.ROOT));   // ALI 70 / AYSE 85 (s-cedilla ile) / CAN 90
		}
		Files.write(yol, List.of("Deniz 60"), StandardOpenOption.APPEND);
		System.out.println(Files.readAllLines(yol).size() + " satir");      // 4 satir

		Files.delete(yol);
		Files.delete(yol.getParent());
	}
}
