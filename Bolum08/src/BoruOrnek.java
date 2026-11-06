import java.io.*;

// Boru (pipe): bir is parcacigi PipedOutputStream'e yazar, digeri PipedInputStream'den okur.
public class BoruOrnek {
	public static void main(String[] args) throws IOException, InterruptedException {
		PipedInputStream pis = new PipedInputStream();
		PipedOutputStream pos = new PipedOutputStream(pis);

		// Okuyucu is parcacigi
		Thread okuyucu = new Thread(() -> {
			try {
				int b;
				while ((b = pis.read()) != -1)
					System.out.print((char) b);
				System.out.println();
				pis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		});

		// Yazici is parcacigi
		Thread yazici = new Thread(() -> {
			try {
				pos.write("Merhaba, boru!".getBytes());
				pos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		okuyucu.start();
		yazici.start();
		yazici.join();
		okuyucu.join();
		// Merhaba, boru!
	}
}
