package ifcondition; 
import java.util.Scanner;

public class MevsimAdlari {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);

		// Kullanicidan bir ay numarasi girmesini iste
		System.out.print("Bir ay girin (1-12): ");
		int ay = scanner.nextInt();

		String mevsim;

		// Ay numarasina gore mevsimi belirle
		if (ay >= 3 && ay <= 5) {
			mevsim = "ilkbahar";  // Mart, Nisan, Mayis aylari ilkbahar
		} else if (ay >= 6 && ay <= 8) {
			mevsim = "Yaz";  // Haziran, Temmuz, Agustos aylari yaz
		} else if (ay >= 9 && ay <= 11) {
			mevsim = "Sonbahar";  // Eylul, Ekim, Kasim aylari sonbahar
		} else if (ay == 12 || ay == 1 || ay == 2) {
			mevsim = "Kis";  // Aralik, Ocak, subat aylari kis
		} else {
			mevsim = "Gecersiz ay";  // 1 ile 12 arasinda olmayan bir ay girisi icin gecersiz mesaji
		}

		// Sonucu ekrana yazdir
		System.out.println("Girdiginiz ayin mevsimi: " + mevsim);

		// Scanner nesnesini kapat
		scanner.close();
	}
}
