import java.io.*;
import java.net.InetSocketAddress;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;
import java.nio.channels.UnresolvedAddressException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

// Kanal olusturma ve kapatma: FileChannel dosyaya, SocketChannel ag baglantisina acilir.
// Ag yoksa baglanti hatasi yakalanir ve mesaj yazilir.
public class KanalAcKapa {
	public static void main(String[] args) throws IOException {
		// Hazirlik: okunacak dosya
		Files.writeString(Paths.get("dosya.txt"), "NIO kanal ornegi\n");

		// FileChannel olusturma
		FileChannel fileChannel = FileChannel.open(
				Paths.get("dosya.txt"), StandardOpenOption.READ);
		// SocketChannel olusturma
		SocketChannel socketChannel = SocketChannel.open();
		try {
			socketChannel.connect(new InetSocketAddress("example.com", 80));
			System.out.println("Baglandi: " + socketChannel.isConnected());   // Baglandi: true
		} catch (IOException | UnresolvedAddressException e) {
			System.out.println("Baglanti kurulamadi (ag yok?): " + e);
		}
		// Kanal kapatma
		fileChannel.close();
		socketChannel.close();

		Files.delete(Paths.get("dosya.txt"));
	}
}
