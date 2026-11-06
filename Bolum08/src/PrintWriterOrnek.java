import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Locale;

// PrintWriter ile println ve printf kullanarak metin dosyasi yazma; dosya sonra ekrana basilir.
public class PrintWriterOrnek {
	public static void main(String[] args) throws IOException {
		PrintWriter yazici = null;
		try {
			yazici = new PrintWriter("yeniDosya.txt");
			yazici.println("Merhaba, dunya!");
			yazici.println("Bu bir ornek dosyadir.");
			yazici.printf(Locale.ROOT, "Pi yaklasik %.2f%n", Math.PI);
			yazici.println(42);
		} catch (IOException e) {
			System.err.println("Dosya hatasi: " + e.getMessage());
			e.printStackTrace();
		} finally {
			if (yazici != null)
				yazici.close();
		}

		// Dosyanin icerigi
		for (String satir : Files.readAllLines(Path.of("yeniDosya.txt")))
			System.out.println(satir);
		// Merhaba, dunya!
		// Bu bir ornek dosyadir.
		// Pi yaklasik 3.14
		// 42
		Files.delete(Path.of("yeniDosya.txt"));
	}
}
