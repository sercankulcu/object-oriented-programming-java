package example;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

// Her istemciyi ayri bir is parcasi olarak ele alan sinif
class ClientHandler extends Thread {
	DataInputStream input; // Istemciden veri almak icin
	DataOutputStream output; // Istemciye veri gondermek icin
	final Socket socket; // Bagli olan istemcinin soketi
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); // Kullanici girdisi icin

	// Yapilandirici: Istemci soketi alinir
	public ClientHandler(Socket socket) {
		this.socket = socket;
		try {
			input = new DataInputStream(socket.getInputStream());
			output = new DataOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Istemci baglantisi olusturulurken hata meydana geldi: " + e.getMessage());
		}
	}

	// Istemci ile iletisimi yurutmek icin calistirilacak kod
	public void run() {
		try {
			String str = ""; // Istemciden gelen mesaj
			while (!str.equals("stop")) { // Istemciden "stop" mesajini alana kadar donguye devam et
				str = input.readUTF(); // Istemciden gelen mesaji al
				System.out.println("Istemciden alinan mesaj: " + str); // Gelen mesaji ekrana yazdir
				output.writeUTF(str); // Istemciden alinan mesaji geri gonder
				output.flush(); // Gonderilen mesajlari temizle
			}
		} catch (IOException e) {
			System.out.println("Istemci ile baglanti koptu: " + e.getMessage());
		} finally {
			try {
				// Soketi kapat
				this.socket.close();
				System.out.println("Istemci soketi kapatildi.");
			} catch (IOException e) {
				System.out.println("Soket kapatilirken hata meydana geldi: " + e.getMessage());
			}
		}
	}
}

public class Server {
	public static void main(String[] args) throws IOException {
		// Sunucu soketi olustur
		ServerSocket serverSocket = new ServerSocket(4444);
		System.out.println("Sunucu baslatildi ve baglanti bekleniyor...");

		while (true) {
			Socket socket = null; // Baglanacak istemci soketi
			try {
				// Yeni bir istemci baglandiginda kabul et
				socket = serverSocket.accept();
				System.out.println("Yeni bir istemci baglandi: " + socket);

				// Her istemci icin yeni bir thread baslat
				Thread thread = new ClientHandler(socket);
				thread.start();

			} catch (Exception e) {
				System.out.println("Baglanti sirasinda hata meydana geldi: " + e.getMessage());
				if (socket != null && !socket.isClosed()) {
					socket.close();
					System.out.println("Baglanti hatali soket kapatildi.");
				}
				serverSocket.close();
				e.printStackTrace();
				break; // Hata durumunda sunucuyu sonlandir
			}
		}
	}
}
