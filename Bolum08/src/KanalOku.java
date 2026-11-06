import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

// FileChannel ile okuma: kanal veriyi ByteBuffer'a okur, flip sonrasi tampondan okunur.
public class KanalOku {
	public static void main(String[] args) throws IOException {
		// Hazirlik: 17 baytlik dosya
		Files.writeString(Paths.get("dosya.txt"), "NIO kanal ornegi\n");

		try (FileChannel channel = FileChannel.open(
				Paths.get("dosya.txt"), StandardOpenOption.READ)) {
			ByteBuffer buffer = ByteBuffer.allocate(1024);
			// Dosyadan veriyi okuma
			int bytesRead = channel.read(buffer);
			System.out.println(bytesRead + " byte okundu");   // 17 byte okundu
			// Buffer'i okuma moduna gecirme
			buffer.flip();
			// Veriyi ekrana yazma
			while (buffer.hasRemaining()) {
				System.out.print((char) buffer.get());          // NIO kanal ornegi
			}
		}

		Files.delete(Paths.get("dosya.txt"));
	}
}
