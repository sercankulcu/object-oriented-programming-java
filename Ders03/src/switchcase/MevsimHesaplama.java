package switchcase;
import java.util.Scanner;

public class MevsimHesaplama {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);

		System.out.print("Bir ay girin (1-12): ");
		int ay = scanner.nextInt();

		String mevsim;

		switch (ay) {
		case 3:
		case 4:
		case 5:
			mevsim = "İlkbahar";
			break;
		case 6:
		case 7:
		case 8:
			mevsim = "Yaz";
			break;
		case 9:
		case 10:
		case 11:
			mevsim = "Sonbahar";
			break;
		case 12:
		case 1:
		case 2:
			mevsim = "Kış";
			break;
		default:
			mevsim = "Geçersiz ay";
			break;
		}

		System.out.println("Girdiğiniz ayın mevsimi: " + mevsim);

		scanner.close();
	}
}
