import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

// Kisa yollar: InputStream.transferTo (Java 9+) ve Files.copy (Java 7+).
public class KopyaKisa {
	public static void main(String[] args) throws IOException {
		// Hazirlik: 4 baytlik kaynak dosya
		Files.writeString(Path.of("dosya.txt"), "Java");

		// Java 9+: transferTo
		try (InputStream in = new FileInputStream("dosya.txt");
			OutputStream out = new FileOutputStream("dosya2.txt")) {
			long adet = in.transferTo(out);
			System.out.println(adet + " byte aktarildi");   // 4 byte aktarildi
		}
		// Java 7+: Files.copy
		Files.copy(Path.of("dosya.txt"), Path.of("dosya3.txt"),
				 StandardCopyOption.REPLACE_EXISTING);
		System.out.println(Files.size(Path.of("dosya3.txt")) + " byte kopyalandi");   // 4 byte kopyalandi

		Files.delete(Path.of("dosya.txt"));
		Files.delete(Path.of("dosya2.txt"));
		Files.delete(Path.of("dosya3.txt"));
	}
}

/* Beklenen cikti:
4 byte aktarildi
4 byte kopyalandi
*/
