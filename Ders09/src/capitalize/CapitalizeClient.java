package capitalize;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class CapitalizeClient {
	
	public static void main(String[] args) throws Exception {

		// Sunucuya baglanmak icin soket olusturuluyor
		try (var socket = new Socket("localhost", 59898)) {
			
			// Kullaniciya metin girmesi icin bilgi verilir
			System.out.println("Metin satirlarini girin, cikis yapmak icin Ctrl+D veya Ctrl+C kullanin");
			
			// Kullanicidan input almak icin Scanner nesnesi olusturuluyor
			try (var scanner = new Scanner(System.in)) {
				
				// Sunucudan gelen veriyi okumak icin Scanner nesnesi olusturuluyor
				var in = new Scanner(socket.getInputStream());
				
				// Sunucuya veri gonderebilmek icin PrintWriter nesnesi olusturuluyor
				var out = new PrintWriter(socket.getOutputStream(), true);
				
				// Kullanicidan metin alindikca, bu metin sunucuya gonderiliyor ve cevabi yazdiriliyor
				while (scanner.hasNextLine()) {
					out.println(scanner.nextLine()); // Kullanicinin girdigi metin sunucuya gonderilir
					
					// Sunucudan gelen cevabi alir ve ekrana yazdirir
					System.out.println(in.nextLine());
				}
			}
		}
	}
}
