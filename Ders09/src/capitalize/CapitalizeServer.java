package capitalize; 
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.Executors;

public class CapitalizeServer {

	public static void main(String[] args) throws Exception {
		// 59898 portunda dinlemeye baslar
		try (var listener = new ServerSocket(59898)) {
			System.out.println("Buyuk harfe cevirme sunucusu calisiyor...");
			
			// Thread havuzu olusturulur, en fazla 20 thread calistirilabilir
			var pool = Executors.newFixedThreadPool(20);
			
			// Sonsuz dongu ile her baglantiyi kabul eder ve isler
			while (true) {
				pool.execute(new Capitalizer(listener.accept())); // Yeni bir baglanti alinir ve yeni thread ile islenir
			}
		}
	}

	// Capitalizer sinifi, her bir istemciyi islemek icin calisan bir thread'i temsil eder
	private static class Capitalizer implements Runnable {
		private Socket socket;

		// Constructor: Istemci soketini alir
		Capitalizer(Socket socket) {
			this.socket = socket;
		}

		@Override
		public void run() {
			System.out.println("Baglantili: " + socket);
			try (var in = new Scanner(socket.getInputStream())) { // Istemciden veri almak icin scanner
				var out = new PrintWriter(socket.getOutputStream(), true); // Istemciye veri gondermek icin printwriter
				
				// Istemciden gelen her satir alinir ve buyuk harfe cevrilir
				while (in.hasNextLine()) {
					out.println(in.nextLine().toUpperCase()); // Veriyi buyuk harfe cevirip gonderir
				}
			} catch (Exception e) {
				System.out.println("Hata: " + socket);
			} finally {
				// Soket kapatilir
				try {
					socket.close();
				} catch (IOException e) {
					System.out.println("Hata: " + socket);
				}
				System.out.println("Kapatildi: " + socket);
			}
		}
	}
}
