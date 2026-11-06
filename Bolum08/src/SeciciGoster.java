import java.io.*;
import java.net.BindException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Set;

// Secici (Selector) ile sunucu: tek is parcacigi birden cok kanali izler.
// Sunumda dongu sonsuzdur (while (true)); burada program kendine bir istemci baglar,
// ilk baglanti kabul edilince donguden cikar.
public class SeciciGoster {
	public static void main(String[] args) throws IOException {
		ServerSocketChannel kanal = ServerSocketChannel.open();
		Selector secici = Selector.open();
		try {
			kanal.bind(new InetSocketAddress(8080));
		} catch (BindException e) {
			kanal.bind(new InetSocketAddress(0));   // 8080 doluysa bos bir port
		}
		kanal.configureBlocking(false);
		kanal.register(secici, SelectionKey.OP_ACCEPT);

		// Deneme istemcisi: sunucuya baglanir
		int port = ((InetSocketAddress) kanal.getLocalAddress()).getPort();
		SocketChannel istemci = SocketChannel.open(new InetSocketAddress(InetAddress.getLoopbackAddress(), port));

		boolean bitti = false;
		while (!bitti) {                            // sunumda: while (true)
			int hazirKanallar = secici.select();
			if (hazirKanallar > 0) {
				Set<SelectionKey> secilenler = secici.selectedKeys();
				for (SelectionKey secilen : secilenler) {
					if (secilen.isAcceptable()) {
						// Baglanti kabul
						SocketChannel yeni = kanal.accept();
						System.out.println("Baglanti kabul edildi");   // Baglanti kabul edildi
						yeni.close();
						bitti = true;
					} else if (secilen.isReadable()) {
						// Veri okuma
					}
				}
				secilenler.clear(); // Islenen anahtarlari temizle
			}
		}
		istemci.close();
		secici.close();
		kanal.close();
	}
}
