import java.io.*;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.channels.UnresolvedAddressException;
import java.nio.charset.StandardCharsets;

// SocketChannel kullanimi: HTTP istegi tampondan sokete yazilir, cevabin ilk satiri okunur.
// Ag yoksa hata yakalanir.
public class SocketKanalOrnek {
	public static void main(String[] args) {
		try (SocketChannel socketChannel = SocketChannel.open()) {
			socketChannel.connect(new InetSocketAddress("example.com", 80));
			ByteBuffer buffer = ByteBuffer.allocate(1024);
			buffer.put(("GET / HTTP/1.1\r\nHost: example.com\r\n"
					+ "Connection: close\r\n\r\n").getBytes(StandardCharsets.US_ASCII));
			buffer.flip();
			// Veriyi sokete yazma
			socketChannel.write(buffer);
			// Cevabi okuma
			buffer.clear();
			socketChannel.read(buffer);
			buffer.flip();
			String cevap = StandardCharsets.US_ASCII.decode(buffer).toString();
			System.out.println(cevap.substring(0, cevap.indexOf("\r\n")));   // HTTP/1.1 200 OK
		} catch (IOException e) {
			e.printStackTrace();
		} catch (UnresolvedAddressException e) {
			System.out.println("Adres cozulemedi (ag yok?): " + e);
		}
	}
}
