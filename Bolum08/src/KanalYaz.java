import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

// FileChannel ile yazma: ByteBuffer.wrap ile sarilan baytlar kanala yazilir.
// "Kanal ile yazildi" metnindeki iki noktasiz i UTF-8'de 2'ser bayt: toplam 20 bayt.
public class KanalYaz {
	public static void main(String[] args) throws IOException {
		try (FileChannel kanal = FileChannel.open(Paths.get("cikti.txt"),
				StandardOpenOption.CREATE, StandardOpenOption.WRITE)) {
			byte[] veri = "Kanal ile yaz\u0131ld\u0131\n".getBytes(StandardCharsets.UTF_8);
			ByteBuffer tampon = ByteBuffer.wrap(veri);
			int yazilan = kanal.write(tampon);
			System.out.println(yazilan + " byte yazildi");   // 20 byte yazildi
		}

		Files.delete(Paths.get("cikti.txt"));
	}
}

/* Beklenen cikti:
20 byte yazildi
*/
