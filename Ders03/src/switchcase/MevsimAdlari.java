package switchcase; 
import java.util.Scanner;

public class MevsimAdlari {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);

		// Kullanicidan bir ay numarasi girmesini iste
		System.out.print("Bir ay girin (1-12): ");
		int ay = scanner.nextInt();

		String mevsim;

		// Ay numarasina göre mevsimi belirle
		switch (ay) {
		case 3:
		case 4:
		case 5:
			mevsim = "ilkbahar";  // 3, 4 ve 5. aylar ilkbahar mevsimidir
			break;
		case 6:
		case 7:
		case 8:
			mevsim = "Yaz";  // 6, 7 ve 8. aylar yaz mevsimidir
			break;
		case 9:
		case 10:
		case 11:
			mevsim = "Sonbahar";  // 9, 10 ve 11. aylar sonbahar mevsimidir
			break;
		case 12:
		case 1:
		case 2:
			mevsim = "Kis";  // 12, 1 ve 2. aylar kis mevsimidir
			break;
		default:
			mevsim = "Gecersiz ay";  // Geçersiz bir ay numarasi girilirse
			break;
		}

		// Hesaplanan mevsimi ekrana yazdir
		System.out.println("Girdiginiz ayin mevsimi: " + mevsim);

		// Scanner nesnesini kapat
		scanner.close();
	}
}
